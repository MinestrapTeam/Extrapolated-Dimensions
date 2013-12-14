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
	public static int	MAX_PROCESS_TIME	= 200;				// 10 seconds
																
	/**
	 * The ItemStacks in this container.
	 * <p>
	 * 0 = fuel; 1 = curse ingredient; 2 = item to curse; 3 = output; 4 = secondary output
	 */
	public ItemStack[]	itemStacks			= new ItemStack[5];
	public int			energyTime;
	public int			processTime;
	
	private String		name;
	
	@Override
	public void updateEntity()
	{
		if (energyTime > 0)
		{
			energyTime--;
		}
		
		if (this.canCurse())
		{
			processTime++;
		}
		else
		{
			processTime = 0;
		}
		
		if (processTime >= MAX_PROCESS_TIME)
		{
			processTime = 0;
			this.curse();
		}
	}
	
	public void curse()
	{
		ItemStack ingredient = itemStacks[1];
		ItemStack item = itemStacks[2];
		
		Curse curse = getCurse(ingredient);
		if (curse != null)
		{
			curse.addCurseToItemStack(item, ingredient.stackSize - 1);
			this.itemStacks[1] = null;
			this.itemStacks[2] = null;
			this.itemStacks[3] = item;
		}
	}
	
	public boolean canCurse()
	{
		if (energyTime <= 0 || itemStacks[3] != null || itemStacks[4] != null)
		{
			return false;
		}
		
		if (!isCurseIngredient(itemStacks[1]))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean isCursable(ItemStack stack)
	{
		Curse curse = getCurse(itemStacks[1]);
		return curse != null && curse.canApply(stack);
	}
	
	public boolean isCurseFuel(ItemStack stack)
	{
		return stack != null && stack.getItem() instanceof ICurseFuel && ((ICurseFuel) stack.getItem()).isCurseFuel(stack);
	}
	
	public boolean isCurseIngredient(ItemStack stack)
	{
		return stack != null && stack.getItem() instanceof ICurseIngredient && ((ICurseIngredient) stack.getItem()).isCurseIngredient(stack);
	}
	
	public Curse getCurse(ItemStack stack)
	{
		return stack != null && stack.getItem() instanceof ICurseIngredient ? ((ICurseIngredient) stack.getItem()).getCurse(stack) : null;
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
		return this.isInvNameLocalized() ? this.name : "container.damnationtable";
	}
	
	@Override
	public boolean isInvNameLocalized()
	{
		return this.name != null && this.name.length() > 0;
	}
	
	public void setInvName(String par1Str)
	{
		this.name = par1Str;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
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
				return this.isCursable(stack);
			default:
				return true;
		}
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
		return null;
	}
	
	@Override
	public boolean canInsertItem(int slotID, ItemStack stack, int side)
	{
		return false;
	}
	
	@Override
	public boolean canExtractItem(int slotID, ItemStack stack, int side)
	{
		return false;
	}
}
