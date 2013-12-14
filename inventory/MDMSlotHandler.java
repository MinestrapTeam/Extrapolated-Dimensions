package clashsoft.mods.moredimensions.inventory;

import java.util.List;

import clashsoft.mods.moredimensions.item.armor.ArmorTypes;
import clashsoft.mods.moredimensions.item.armor.ItemCape;
import clashsoft.mods.moredimensions.item.armor.ItemGloves;
import clashsoft.mods.moredimensions.item.armor.ItemShield;
import clashsoft.playerinventoryapi.SurvivalInventory;
import clashsoft.playerinventoryapi.api.ISlotHandler;
import clashsoft.playerinventoryapi.inventory.SlotCustomArmor;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class MDMSlotHandler implements ISlotHandler
{
	@Override
	public void addSlots(List<Slot> list, EntityPlayer player, boolean creative)
	{
		if (!creative)
			SurvivalInventory.compactCraftingGrid();
		
		ExtendedInventory extendedInventory = ExtendedInventory.get(player);
		SlotCustomArmor glove, shield, cape;
		
		if (creative)
		{
			glove = new SlotCustomArmor(player, extendedInventory, 0, 45, 24, ArmorTypes.GLOVE, ItemGloves.slotIcon);
			shield = new SlotCustomArmor(player, extendedInventory, 1, 63, 24, ArmorTypes.SHIELD, ItemCape.slotIcon);
			cape = new SlotCustomArmor(player, extendedInventory, 2, 81, 24, ArmorTypes.CAPE, ItemShield.slotIcon);
		}
		else
		{
			glove = new SlotCustomArmor(player, extendedInventory, 0, 80, 8, ArmorTypes.GLOVE, ItemGloves.slotIcon);
			shield = new SlotCustomArmor(player, extendedInventory, 1, 80, 26, ArmorTypes.SHIELD, ItemCape.slotIcon);
			cape = new SlotCustomArmor(player, extendedInventory, 2, 80, 44, ArmorTypes.CAPE, ItemShield.slotIcon);
		}
		
		list.add(glove);
		list.add(shield);
		list.add(cape);
		
		if (creative)
		{
			for (int i = 3; i < 8; i++)
			{
				list.add(new Slot(extendedInventory, i, 45 + (i * 18), 24));
			}
		}
		else
		{
			for (int i = 3; i < 8; i++)
			{
				list.add(new Slot(extendedInventory, i, 80 + (i / 4) * 18, 8 + (i % 4 * 18)));
			}
		}
	}
}