package clashsoft.mods.moredimensions.item.heaven;

import net.minecraft.item.ItemStack;

import clashsoft.cslib.minecraft.CustomItem;
import clashsoft.mods.moredimensions.addons.MDMItems;
import clashsoft.mods.moredimensions.api.ICurseFuel;

public class ItemHeavenMaterials extends CustomItem implements ICurseFuel
{	
	public ItemHeavenMaterials(int itemID, String[] displayNames, String[] iconNames)
	{
		super(itemID, displayNames, iconNames);
	}

	@Override
	public boolean isCurseFuel(ItemStack stack)
	{
		return stack.getItemDamage() == MDMItems.energyOrb.getItemDamage();
	}
	
}
