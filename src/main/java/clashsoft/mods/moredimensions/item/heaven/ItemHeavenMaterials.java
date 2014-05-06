package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.mods.moredimensions.api.alchemy.IEnergyFuel;

import net.minecraft.item.ItemStack;

public class ItemHeavenMaterials extends CustomItem implements IEnergyFuel
{
	public ItemHeavenMaterials(String[] displayNames, String domain)
	{
		super(displayNames, domain);
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
