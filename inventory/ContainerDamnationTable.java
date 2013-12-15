package clashsoft.mods.moredimensions.inventory;

import clashsoft.cslib.minecraft.inventory.SlotInput;
import clashsoft.cslib.minecraft.inventory.SlotOutput;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDamnationTable extends Container
{
	private TileEntityDamnationTable	damnationTable;
	
	public ContainerDamnationTable(InventoryPlayer inventory, TileEntityDamnationTable damnationTable)
	{
		this.damnationTable = damnationTable;
		this.addSlotToContainer(new SlotInput(damnationTable, 0, 50, 54));
		this.addSlotToContainer(new SlotInput(damnationTable, 1, 23, 19));
		this.addSlotToContainer(new SlotInput(damnationTable, 2, 73, 19));
		this.addSlotToContainer(new SlotOutput(damnationTable, 3, 133, 19));
		this.addSlotToContainer(new SlotOutput(damnationTable, 4, 101, 54));
		int i;
		
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.damnationTable.isUseableByPlayer(player);
	}
	
	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotID < 5)
			{
				if (!this.mergeItemStack(itemstack1, 5, 41, false))
				{
					return null;
				}
			}
			else if (this.damnationTable.isCurseFuel(itemstack1))
			{
				if (!this.mergeItemStack(itemstack1, 0, 1, false))
				{
					return null;
				}
			}
			else if (this.damnationTable.isCurseIngredient(itemstack1))
			{
				if (!this.mergeItemStack(itemstack1, 1, 2, false))
				{
					return null;
				}
			}
			else if (!this.damnationTable.isCursable(this.damnationTable.getIngredient(), itemstack1))
			{
				if (!this.mergeItemStack(itemstack1, 2, 3, false))
				{
					return null;
				}
			}
			else if (slotID >= 5 && slotID < 32)
			{
				if (!this.mergeItemStack(itemstack1, 32, 41, false))
				{
					return null;
				}
			}
			else if (slotID >= 32 && slotID < 41)
			{
				if (!this.mergeItemStack(itemstack1, 5, 32, false))
				{
					return null;
				}
			}
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}
}
