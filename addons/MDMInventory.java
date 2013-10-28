package clashsoft.mods.moredimensions.addons;

import java.util.List;

import clashsoft.mods.moredimensions.item.armor.ArmorTypes;
import clashsoft.mods.moredimensions.item.armor.ItemCape;
import clashsoft.mods.moredimensions.item.armor.ItemGloves;

import com.chaosdev.playerinventoryapi.CreativeInventory;
import com.chaosdev.playerinventoryapi.SurvivalInventory;
import com.chaosdev.playerinventoryapi.api.ISlotHandler;
import com.chaosdev.playerinventoryapi.inventory.SlotCustomArmor;
import com.chaosdev.playerinventoryapi.lib.ExtendedInventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class MDMInventory
{
	public static ISlotHandler slotHandler = new ISlotHandler()
	{
		@Override
		public void addSlots(List<Slot> list, EntityPlayer player, boolean creative)
		{
			
			if (!creative)
				SurvivalInventory.compactCraftingGrid();
			
			SlotCustomArmor glove = new SlotCustomArmor(player, ExtendedInventory.getExtendedInventory(player), 0, 45, 24, ArmorTypes.GLOVE);
			SlotCustomArmor shield = new SlotCustomArmor(player, ExtendedInventory.getExtendedInventory(player), 1, 63, 24, ArmorTypes.SHIELD);
			SlotCustomArmor cape = new SlotCustomArmor(player, ExtendedInventory.getExtendedInventory(player), 2, 81, 24, ArmorTypes.CAPE);
			
			glove.backgroundIcon = ItemGloves.slotIcon;
			cape.backgroundIcon = ItemCape.slotIcon;
			
			list.add(glove);
			list.add(shield);
			list.add(cape);
		}
	};
	
	public static void load()
	{
		CreativeInventory.addSlotHandler(slotHandler);
		SurvivalInventory.addSlotHandler(slotHandler);
	}
}
