package clashsoft.mods.moredimensions.api;

import net.minecraft.item.ItemStack;

public interface IEnergyFuel
{
	boolean isEnergyFuel(ItemStack stack);
	
	int getEnergyValue(ItemStack stack);
}
