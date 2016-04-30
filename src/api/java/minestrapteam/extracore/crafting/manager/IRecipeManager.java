package minestrapteam.extracore.crafting.manager;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface IRecipeManager
{
	/**
	 * Adds a new recipe.
	 * 
	 * @param block
	 *            the block
	 * @param output
	 *            the output
	 */
	void addRecipe(Block block, ItemStack output);
	
	/**
	 * Adds a new recipe.
	 * 
	 * @param item
	 *            the item
	 * @param output
	 *            the output
	 */
	void addRecipe(Item item, ItemStack output);
	
	/**
	 * Adds a new recipe.
	 * 
	 * @param input
	 *            the input
	 * @param output
	 *            the output
	 */
	void addRecipe(ItemStack input, ItemStack output);
	
	/**
	 * Returns true if the given {@link ItemStack} {@code input} has a crafting
	 * result
	 * 
	 * @param input
	 * @return true, if the input has a crafting result
	 */
	boolean hasResult(ItemStack input);
	
	/**
	 * Returns the crafting result for the given {@link ItemStack} {@code input}
	 * 
	 * @param input
	 *            the input
	 * @return the output
	 */
	ItemStack getResult(ItemStack input);
	
	/**
	 * Returns a copy of the crafting result for the given {@link ItemStack}
	 * {@code input}
	 * 
	 * @param input
	 *            the input
	 * @return the output
	 */
	ItemStack copyResult(ItemStack input);
}
