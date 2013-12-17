package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.cslib.minecraft.CustomItem;
import clashsoft.mods.moredimensions.api.IEnergyFuel;

import net.minecraft.item.ItemStack;

public class ItemHeavenMaterials extends CustomItem implements IEnergyFuel
{
	public ItemHeavenMaterials(int itemID, String[] displayNames, String[] iconNames)
	{
		super(itemID, displayNames, iconNames);
	}
	
	@Override
	public boolean isEnergyFuel(ItemStack stack)
	{
		return stack.getItemDamage() == 6;
	}
	
	@Override
	public int getEnergyValue(ItemStack stack)
	{
		return stack.getItemDamage() == 6 ? 2000 : 0;
	}
	
}
