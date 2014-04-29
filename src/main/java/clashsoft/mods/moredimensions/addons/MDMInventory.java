package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.math.Point2i;
import clashsoft.mods.moredimensions.item.armor.ArmorTypes;
import clashsoft.mods.moredimensions.item.armor.ItemCape;
import clashsoft.mods.moredimensions.item.armor.ItemGloves;
import clashsoft.mods.moredimensions.item.armor.ItemShield;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import clashsoft.playerinventoryapi.SurvivalInventory;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.ISlotList;
import clashsoft.playerinventoryapi.inventory.SlotCustomArmor;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class MDMInventory implements IInventoryHandler
{
	public static IInventoryHandler	slotHandler	= new MDMInventory();
	
	public static void load()
	{
		PlayerInventoryAPI.addInventoryHandler(slotHandler);
	}
	
	@Override
	public void pre(Point2i[] slots, EntityPlayer player, boolean creative)
	{
		if (!creative)
		{
			SurvivalInventory.compactCraftingGrid();
			SurvivalInventory.setPlayer(7, 7);
			SurvivalInventory.setArmor(62, 8);
		}
	}
	
	@Override
	public void addSlots(ISlotList list, EntityPlayer player, boolean creative)
	{
		ExtendedInventory extendedInventory = ExtendedInventory.get(player);
		SlotCustomArmor glove, shield, cape;
		
		if (creative)
		{
			glove = new SlotCustomArmor(player, extendedInventory, 64, 45, 24, ArmorTypes.GLOVE, ItemGloves.slotIcon);
			shield = new SlotCustomArmor(player, extendedInventory, 65, 63, 24, ArmorTypes.SHIELD, ItemShield.slotIcon);
			cape = new SlotCustomArmor(player, extendedInventory, 66, 81, 24, ArmorTypes.CAPE, ItemCape.slotIcon);
		}
		else
		{
			glove = new SlotCustomArmor(player, extendedInventory, 64, 80, 8, ArmorTypes.GLOVE, ItemGloves.slotIcon);
			shield = new SlotCustomArmor(player, extendedInventory, 65, 80, 26, ArmorTypes.SHIELD, ItemShield.slotIcon);
			cape = new SlotCustomArmor(player, extendedInventory, 66, 80, 44, ArmorTypes.CAPE, ItemCape.slotIcon);
		}
		
		list.addSlot(glove);
		list.addSlot(shield);
		list.addSlot(cape);
		
		if (creative)
		{
			for (int i = 3; i < 8; i++)
			{
				list.addSlot(new Slot(extendedInventory, 64 + i, 45 + (i * 18), 24));
			}
		}
		else
		{
			for (int i = 3; i < 8; i++)
			{
				list.addSlot(new Slot(extendedInventory, 64 + i, 80 + (i / 4) * 18, 8 + (i % 4 * 18)));
			}
		}
	}

	@Override
	public void buttonPressed(GuiButton button, EntityPlayer player, boolean creative)
	{
	}
}
