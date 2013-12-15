package clashsoft.mods.moredimensions.tileentity;

import clashsoft.mods.moredimensions.api.ICurseFuel;
import clashsoft.mods.moredimensions.api.ICurseIngredient;
import clashsoft.mods.moredimensions.curse.Curse;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDamnationTable extends TileEntity implements ISidedInventory
{
	public static int	MAX_CURSE_TIME	= 200;				// 10 seconds
															
	public static int[]	inputSlots		= { 0, 1, 2 };
	public static int[]	outputSlots		= { 3, 4 };
	
	/**
	 * The ItemStacks in this container.
	 * <p>
	 * 0 = fuel; 1 = curse ingredient; 2 = item to curse; 3 = output; 4 = secondary output
	 */
	public ItemStack[]	itemStacks		= new ItemStack[5];
	public int			energyTime;
	public int			itemEnergyTime;
	public int			curseTime;
	
	public String		name;
	
	@Override
	public void updateEntity()
	{
		boolean canCurse = this.canCurse();
		
		if (this.energyTime > 0)
		{
			this.energyTime--;
		}
		else if (this.isCurseFuel(this.itemStacks[0]) && canCurse)
		{
			this.energyTime = this.itemEnergyTime = this.getCurseFuel(this.itemStacks[0]);
			this.decrStackSize(0, 1);
		}
		
		if (this.energyTime > 0 && canCurse)
		{
			this.curseTime++;
		}
		else
		{
			this.curseTime = 0;
		}
		
		if (this.curseTime >= MAX_CURSE_TIME)
		{
			this.curseTime = 0;
			this.curse();
		}
	}
	
	public void curse()
	{
		ItemStack ingredient = this.itemStacks[1];
		ItemStack item = this.itemStacks[2].copy();
		
		Curse curse = this.getCurse(ingredient);
		if (curse != null)
		{
			curse.addCurseToItemStack(item, 1);
			this.decrStackSize(1, 1);
			this.decrStackSize(2, 1);
			
			item.stackSize = 1;
			this.itemStacks[3] = item;
		}
	}
	
	public boolean canCurse()
	{
		if (this.itemStacks[3] != null || this.itemStacks[4] != null)
		{
			return false;
		}
		
		if (!this.isCurseIngredient(this.getIngredient()) || !this.isCursable(this.getIngredient(), this.getItemToCurse()))
		{
			return false;
		}
		
		return true;
	}
	
	public ItemStack getFuel()
	{
		return this.itemStacks[0];
	}
	
	public ItemStack getIngredient()
	{
		return this.itemStacks[1];
	}
	
	public ItemStack getItemToCurse()
	{
		return this.itemStacks[2];
	}
	
	public boolean isCursable(ItemStack ingredient, ItemStack stack)
	{
		if (stack == null)
			return false;
		
		Curse curse = this.getCurse(ingredient);
		return curse != null && curse.canApply(stack);
	}
	
	public boolean isCurseFuel(ItemStack stack)
	{
		return stack != null && stack.getItem() instanceof ICurseFuel && ((ICurseFuel) stack.getItem()).isCurseFuel(stack);
	}
	
	public int getCurseFuel(ItemStack stack)
	{
		return stack != null && stack.getItem() instanceof ICurseFuel ? ((ICurseFuel) stack.getItem()).getCurseFuelValue(stack) : 0;
	}
	
	public boolean isCurseIngredient(ItemStack stack)
	{
		if (stack != null && stack.getItem() instanceof ICurseIngredient)
		{
			ICurseIngredient icurseingredient = (ICurseIngredient) stack.getItem();
			return icurseingredient.isCurseIngredient(stack);
		}
		return false;
	}
	
	public Curse getCurse(ItemStack stack)
	{
		return (stack != null && stack.getItem() instanceof ICurseIngredient) ? ((ICurseIngredient) stack.getItem()).getCurse(stack) : null;
	}
	
	public boolean isActive()
	{
		return this.energyTime > 0;
	}
	
	public int getProgressScaled(int scalar)
	{
		return this.curseTime * scalar / MAX_CURSE_TIME;
	}
	
	public int getEnergyTimeRemainingScaled(int scalar)
	{
		if (this.itemEnergyTime == 0)
		{
			this.itemEnergyTime = 200;
		}
		
		return this.energyTime * scalar / this.itemEnergyTime;
	}
	
	@Override
	public int getSizeInventory()
	{
		return this.itemStacks.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slotID)
	{
		return this.itemStacks[slotID];
	}
	
	@Override
	public ItemStack decrStackSize(int slotID, int amount)
	{
		if (this.itemStacks[slotID] != null)
		{
			ItemStack itemstack;
			
			if (this.itemStacks[slotID].stackSize <= amount)
			{
				itemstack = this.itemStacks[slotID];
				this.itemStacks[slotID] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.itemStacks[slotID].splitStack(amount);
				
				if (this.itemStacks[slotID].stackSize == 0)
				{
					this.itemStacks[slotID] = null;
				}
				
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slotID)
	{
		if (this.itemStacks[slotID] != null)
		{
			ItemStack itemstack = this.itemStacks[slotID];
			this.itemStacks[slotID] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void setInventorySlotContents(int slotID, ItemStack stack)
	{
		this.itemStacks[slotID] = stack;
		
		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	@Override
	public String getInvName()
	{
		return this.isInvNameLocalized() ? this.name : "tile.damnation_table.name";
	}
	
	@Override
	public boolean isInvNameLocalized()
	{
		return this.name != null && this.name.length() > 0;
	}
	
	public void setInvName(String name)
	{
		this.name = name;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.energyTime = nbt.getShort("EnergyTime");
		this.itemEnergyTime = nbt.getShort("ItemEnergyTime");
		this.curseTime = nbt.getShort("CurseTime");
		
		NBTTagList nbttaglist = nbt.getTagList("Items");
		this.itemStacks = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			
			if (b0 >= 0 && b0 < this.itemStacks.length)
			{
				this.itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		
		if (nbt.hasKey("CustomName"))
		{
			this.name = nbt.getString("CustomName");
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setShort("EnergyTime", (short) this.energyTime);
		nbt.setShort("ItemEnergyTime", (short) this.itemEnergyTime);
		nbt.setShort("CurseTime", (short) this.curseTime);
		
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.itemStacks.length; ++i)
		{
			if (this.itemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		
		nbt.setTag("Items", nbttaglist);
		
		if (this.isInvNameLocalized())
		{
			nbt.setString("CustomName", this.name);
		}
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}
	
	@Override
	public void openChest()
	{
	}
	
	@Override
	public void closeChest()
	{
	}
	
	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack stack)
	{
		switch (slotID)
		{
			case 0:
				return this.isCurseFuel(stack);
			case 1:
				return this.isCurseIngredient(stack);
			case 2:
				return this.isCursable(this.itemStacks[1], stack);
			default:
				return true;
		}
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
		return side == 0 ? outputSlots : inputSlots;
	}
	
	@Override
	public boolean canInsertItem(int slotID, ItemStack stack, int side)
	{
		return side != 0 && slotID < 4 && this.isItemValidForSlot(slotID, stack);
	}
	
	@Override
	public boolean canExtractItem(int slotID, ItemStack stack, int side)
	{
		return side == 0 && (slotID == 4 || slotID == 5);
	}
}
