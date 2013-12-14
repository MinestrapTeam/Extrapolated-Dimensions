package clashsoft.mods.moredimensions.api;

import net.minecraft.item.ItemStack;

public interface ICurseFuel
{
	boolean isCurseFuel(ItemStack stack);
	
	int getCurseFuelValue(ItemStack stack);
}
