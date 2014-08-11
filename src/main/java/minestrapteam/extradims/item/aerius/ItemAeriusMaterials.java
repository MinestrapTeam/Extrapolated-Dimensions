package minestrapteam.extradims.item.aerius;

import clashsoft.cslib.minecraft.item.CustomItem;
import minestrapteam.extradims.api.alchemy.IEnergyFuel;

import net.minecraft.item.ItemStack;

public class ItemAeriusMaterials extends CustomItem implements IEnergyFuel
{
	public ItemAeriusMaterials(String[] names, String[] iconNames)
	{
		super(names, iconNames, null);
	}

	@Override
	public boolean isEnergyFuel(ItemStack stack)
	{
		return stack.getItemDamage() == 3;
	}
	
	@Override
	public int getEnergyValue(ItemStack stack)
	{
		return stack.getItemDamage() == 3 ? 2000 : 0;
	}
}
