package minestrapteam.extradims.tileentity;

import minestrapteam.extracore.tileentity.TileEntityInventory;
import minestrapteam.extradims.api.alchemy.IEnergyFuel;
import minestrapteam.extradims.api.curse.ICurseIngredient;
import minestrapteam.extradims.curse.Curse;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityDamnationTable extends TileEntityInventory implements ISidedInventory
{
	public static int	MAX_CURSE_TIME	= 200;			// 10 seconds
														
	public static int[]	inputSlots		= { 0, 1, 2 };
	public static int[]	outputSlots		= { 3, 4 };
	
	/**
	 * The ItemStacks in this container.
	 * <p>
	 * 0 = fuel; 1 = curse ingredient; 2 = item to curse; 3 = output; 4 = secondary output
	 */
	public int			energyTime;
	public int			itemEnergyTime;
	public int			curseTime;
	
	public TileEntityDamnationTable()
	{
		super(5);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 5;
	}
	
	@Override
	public void updateEntity()
	{
		boolean canCurse = this.canCurse();
		
		if (this.energyTime > 0)
		{
			this.energyTime--;
		}
		else if (this.isEnergyFuel(this.itemStacks[0]) && canCurse)
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
		return !(this.itemStacks[3] != null || this.itemStacks[4] != null) && !(!this.isCurseIngredient(
			this.getIngredient()) || !this.isCursable(this.getIngredient(), this.getItemToCurse()));
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
	
	public boolean isEnergyFuel(ItemStack stack)
	{
		return stack != null && stack.getItem() instanceof IEnergyFuel && ((IEnergyFuel) stack.getItem()).isEnergyFuel(stack);
	}
	
	public int getCurseFuel(ItemStack stack)
	{
		return stack != null && stack.getItem() instanceof IEnergyFuel ? ((IEnergyFuel) stack.getItem()).getEnergyValue(stack) : 0;
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
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.energyTime = nbt.getShort("EnergyTime");
		this.itemEnergyTime = nbt.getShort("ItemEnergyTime");
		this.curseTime = nbt.getShort("CurseTime");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setShort("EnergyTime", (short) this.energyTime);
		nbt.setShort("ItemEnergyTime", (short) this.itemEnergyTime);
		nbt.setShort("CurseTime", (short) this.curseTime);
	}
	
	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack stack)
	{
		switch (slotID)
		{
			case 0:
				return this.isEnergyFuel(stack);
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
