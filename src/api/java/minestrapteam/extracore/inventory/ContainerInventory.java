package minestrapteam.extracore.inventory;

import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.api.CreativeInventory;
import minestrapteam.extracore.api.SurvivalInventory;
import minestrapteam.extracore.inventory.slot.SlotCustomArmor;
import minestrapteam.extracore.util.FakeArrayList;
import minestrapteam.extracore.util.math.Point2i;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

import java.util.ArrayList;
import java.util.List;

public class ContainerInventory extends Container implements ISlotList
{
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
	public IInventory        craftResult = new InventoryCraftResult();

	public final EntityPlayer thePlayer;
	public       boolean      isCreative;

	public ContainerInventory(EntityPlayer player)
	{
		this.thePlayer = player;

		if (ExtraCore.proxy.isClient())
		{
			this.inventorySlots = new FakeArrayList(45);
		}

		this.onContainerOpened(player);
		this.onCraftMatrixChanged(this.craftMatrix);
	}

	@Override
	public Slot addSlot(Slot slot)
	{
		this.addSlotToContainer(slot);
		return slot;
	}

	@Override
	protected Slot addSlotToContainer(Slot slot)
	{
		super.addSlotToContainer(slot);
		if (this.isCreative)
		{
			CreativeInventory.setSlot(slot.slotNumber, slot.xDisplayPosition, slot.yDisplayPosition);
		}
		else
		{
			SurvivalInventory.setSlot(slot.slotNumber, slot.xDisplayPosition, slot.yDisplayPosition);
		}
		return slot;
	}

	public void reloadSlots()
	{
		boolean creative = this.isCreative;
		List<IInventoryHandler> handlers;
		Point2i[] slotPositions;

		if (creative)
		{
			handlers = CreativeInventory.handlers;
			slotPositions = CreativeInventory.getSlots();
		}
		else
		{
			handlers = SurvivalInventory.handlers;
			slotPositions = SurvivalInventory.getSlots();
		}

		for (IInventoryHandler handler : handlers)
		{
			handler.pre(slotPositions, this.thePlayer, creative);
		}

		this.inventorySlots.clear();

		List<Slot> slots = this.createSlots(slotPositions);

		for (Slot slot : slots)
		{
			this.addSlotToContainer(slot);
		}

		for (IInventoryHandler handler : handlers)
		{
			handler.addSlots(this, this.thePlayer, this.isCreative);
		}
	}

	public List<Slot> createSlots(Point2i[] pos)
	{
		List<Slot> slots = new ArrayList<>(pos.length);
		slots
			.add(new SlotCrafting(this.thePlayer, this.craftMatrix, this.craftResult, 0, pos[0].getX(), pos[0].getY()));

		int x;
		int y;
		int slotIndex;

		for (x = 0; x < 2; x++)
		{
			for (y = 0; y < 2; y++)
			{
				slotIndex = y + x * 2;
				slots.add(new Slot(this.craftMatrix, slotIndex, pos[slotIndex + 1].getX(), pos[slotIndex + 1].getY()));
			}
		}

		for (x = 0; x < 4; x++)
		{
			slotIndex = 5 + x;
			slots.add(new SlotCustomArmor(this.thePlayer, this.thePlayer.inventory, 39 - x, pos[slotIndex].getX(),
			                              pos[slotIndex].getY(), x));
		}

		for (x = 0; x < 3; x++)
		{
			for (y = 0; y < 9; y++)
			{
				slotIndex = 9 + y + x * 9;
				slots.add(new Slot(this.thePlayer.inventory, slotIndex, pos[slotIndex].getX(), pos[slotIndex].getY()));
			}
		}

		for (x = 0; x < 9; x++)
		{
			slotIndex = x + 36;
			slots.add(new Slot(this.thePlayer.inventory, x, pos[slotIndex].getX(), pos[slotIndex].getY()));
		}

		return slots;
	}

	@Override
	public ItemStack slotClick(int i, int j, int k, EntityPlayer player)
	{
		player.openContainer = this;
		return super.slotClick(i, j, k, player);
	}

	@Override
	public void onCraftMatrixChanged(IInventory inventory)
	{
		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix,
		                                                                                              this.thePlayer.worldObj));
	}

	public void onContainerOpened(EntityPlayer player)
	{
		this.isCreative = player.capabilities.isCreativeMode;
		this.reloadSlots();
	}

	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);

		for (int i = 0; i < 4; ++i)
		{
			ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

			if (itemstack != null)
			{
				player.dropPlayerItemWithRandomChoice(itemstack, false);
			}
		}
		this.craftResult.setInventorySlotContents(0, null);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		Slot slot = (Slot) this.inventorySlots.get(slotID);

		if (slot == null || !slot.getHasStack())
		{
			return null;
		}

		ItemStack stack = slot.getStack();
		ItemStack copy = stack.copy();
		int size = this.inventorySlots.size();

		if (copy.stackSize == 0)
		{
			return null;
		}

		final int armorSlotID;
		if (slotID == 0) // Crafting Output -> Main Inventory
		{
			if (!this.mergeItemStack(stack, 9, 45, true))
			{
				return null;
			}

			slot.onSlotChange(stack, copy);
		}
		else if (slotID >= 1 && slotID < 5) // Crafting grid -> Main Inventory
		{
			if (!this.mergeItemStack(stack, 9, 45, false))
			{
				return null;
			}
		}
		else if (slotID >= 5 && slotID < 9) // Armor slots -> Main Inventory
		{
			if (!this.mergeItemStack(stack, 9, 45, false))
			{
				return null;
			}
		}
		else if (slotID >= 45) // Extra Slots -> Main Inventory
		{
			if (!this.mergeItemStack(stack, 9, 45, false))
			{
				return null;
			}
		}
		else if ((armorSlotID = this.getArmorSlotID(stack, size)) != -1) // Armor
		{
			if (!this.mergeItemStack(stack, armorSlotID, armorSlotID + 1, false))
			{
				return null;
			}
		}
		else if (slotID >= 9 && slotID < 36) // Main Inventory -> Hotbar
		{
			if (!this.mergeItemStack(stack, 36, 45, false))
			{
				return null;
			}
		}
		else if (slotID >= 36 && slotID < 45) // Hotbar -> Main Inventory
		{
			if (!this.mergeItemStack(stack, 9, 36, false) && !this.mergeItemStack(stack, 45, size, false))
			{
				return null;
			}
		}
		else if (!this.mergeItemStack(stack, 9, 45, false)) // -> Main Inventory
		{
			return null;
		}

		if (stack.stackSize == 0)
		{
			slot.putStack(null);
		}
		else
		{
			slot.onSlotChanged();
		}

		if (stack.stackSize == copy.stackSize)
		{
			return null;
		}

		slot.onPickupFromSlot(player, stack);

		return copy;
	}

	private int getArmorSlotID(ItemStack stack, int size)
	{
		if (stack.getItem() instanceof ItemArmor)
		{
			ItemArmor itemArmor = (ItemArmor) stack.getItem();

			final int armorType = itemArmor.armorType;
			if (armorType < 4)
			{
				final Slot armorSlot = (Slot) this.inventorySlots.get(5 + armorType);
				if (!armorSlot.getHasStack())
				{
					return 5 + armorType;
				}
			}
		}

		// Check Extra Slots
		for (int i = 45; i < size; i++)
		{
			final Slot armorSlot = (Slot) this.inventorySlots.get(i);
			if (!armorSlot.getHasStack() && armorSlot instanceof SlotCustomArmor && armorSlot.isItemValid(stack))
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean func_94530_a(ItemStack stack, Slot slot)
	{
		return slot.inventory != this.craftResult;
	}
}
