package minestrapteam.extradims.api.alchemy;

import net.minecraft.item.ItemStack;

public interface IEnergyFuel
{
	boolean isEnergyFuel(ItemStack stack);
	
	int getEnergyValue(ItemStack stack);
}
