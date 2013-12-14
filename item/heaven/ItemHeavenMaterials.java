package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.cslib.minecraft.CustomItem;
import clashsoft.mods.moredimensions.api.ICurseFuel;

import net.minecraft.item.ItemStack;

public class ItemHeavenMaterials extends CustomItem implements ICurseFuel
{
	public ItemHeavenMaterials(int itemID, String[] displayNames, String[] iconNames)
	{
		super(itemID, displayNames, iconNames);
	}
	
	@Override
	public boolean isCurseFuel(ItemStack stack)
	{
		return stack.getItemDamage() == 6;
	}
	
	@Override
	public int getCurseFuelValue(ItemStack stack)
	{
		return stack.getItemDamage() == 6 ? 2000 : 0;
	}
	
}
