package clashsoft.mods.moredimensions.api;

import clashsoft.mods.moredimensions.curse.Curse;

import net.minecraft.item.ItemStack;

public interface ICurseIngredient
{
	boolean isCurseIngredient(ItemStack stack);
	Curse getCurse(ItemStack stack);
}
