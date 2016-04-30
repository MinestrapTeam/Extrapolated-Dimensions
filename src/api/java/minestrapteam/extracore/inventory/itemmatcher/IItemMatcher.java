package minestrapteam.extracore.inventory.itemmatcher;

import net.minecraft.item.ItemStack;

public interface IItemMatcher
{
	boolean isItemValid(ItemStack stack);
}
