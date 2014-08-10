package minestrapteam.extradims.api.curse;

import minestrapteam.extradims.curse.Curse;

import net.minecraft.item.ItemStack;

public interface ICurseIngredient
{
	boolean isCurseIngredient(ItemStack stack);
	
	Curse getCurse(ItemStack stack);
}
