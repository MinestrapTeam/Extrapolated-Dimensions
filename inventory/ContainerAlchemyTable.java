package clashsoft.mods.moredimensions.inventory;

import clashsoft.cslib.minecraft.inventory.SlotInfo;
import clashsoft.cslib.minecraft.inventory.SlotInput;
import clashsoft.cslib.minecraft.inventory.SlotOutput;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAlchemyTable extends Container
{
	private TileEntityAlchemyTable	alchemyTable;
	
	public ContainerAlchemyTable(InventoryPlayer inventory, TileEntityAlchemyTable alchemyTable)
	{
		this.alchemyTable = alchemyTable;
		this.addSlotToContainer(new SlotInput(alchemyTable, 0, 12, 47)); // Primary ingredient
		this.addSlotToContainer(new SlotInput(alchemyTable, 1, 66, 16)); // Secondary ingredient
		this.addSlotToContainer(new SlotInput(alchemyTable, 2, 66, 47)); // Smelted primary input
		
		this.addSlotToContainer(new SlotInput(alchemyTable, 3, 12, 85)); // Primary fuel
		this.addSlotToContainer(new SlotInput(alchemyTable, 4, 66, 85)); // Secondary fuel
		this.addSlotToContainer(new SlotInput(alchemyTable, 5, 192, 85)); // Tertiary fuel
		
		this.addSlotToContainer(new SlotInfo(alchemyTable, 6, 116, 47));
		this.addSlotToContainer(new SlotInfo(alchemyTable, 7, 144, 12));
		this.addSlotToContainer(new SlotInfo(alchemyTable, 8, 192, 47));
		this.addSlotToContainer(new SlotInfo(alchemyTable, 9, 153, 38));
		this.addSlotToContainer(new SlotInfo(alchemyTable, 10, 144, 63));
		
		this.addSlotToContainer(new SlotOutput(alchemyTable, 11, 223, 47)); // Primary output
		this.addSlotToContainer(new SlotOutput(alchemyTable, 12, 144, 85)); // Secondary output
		
		
		int i;
		
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 48 + j * 18, 111 + i * 18));
			}
		}
		
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventory, i, 48 + i * 18, 169));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.alchemyTable.isUseableByPlayer(player);
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
			
			if (slotID < 13)
			{
				if (!this.mergeItemStack(itemstack1, 13, 49, false))
				{
					return null;
				}
			}
			else if (slotID >= 13 && slotID < 40)
			{
				if (!this.mergeItemStack(itemstack1, 40, 49, false))
				{
					return null;
				}
			}
			else if (slotID >= 40 && slotID < 49)
			{
				if (!this.mergeItemStack(itemstack1, 13, 40, false))
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
