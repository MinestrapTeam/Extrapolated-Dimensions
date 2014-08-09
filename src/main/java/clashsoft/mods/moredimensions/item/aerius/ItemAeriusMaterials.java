package clashsoft.mods.moredimensions.item.aerius;

import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.mods.moredimensions.api.alchemy.IEnergyFuel;

import net.minecraft.item.ItemStack;

public class ItemAeriusMaterials extends CustomItem implements IEnergyFuel
{
	public ItemAeriusMaterials(String[] displayNames, String domain)
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
