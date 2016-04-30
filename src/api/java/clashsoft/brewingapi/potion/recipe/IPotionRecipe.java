package clashsoft.brewingapi.potion.recipe;

import clashsoft.brewingapi.potion.PotionTypeList;

import net.minecraft.item.ItemStack;

public interface IPotionRecipe
{
	/**
	 * Registers this {@link IPotionRecipe}. It is recommended to register it by
	 * adding it to {@link PotionRecipes#recipes}. See
	 * {@link AbstractPotionRecipe#register()} for a template.
	 * 
	 * @see AbstractPotionRecipe#register()
	 * @return this potion recipe
	 */
	IPotionRecipe register();
	
	/**
	 * Gets the ingredient of this {@link IPotionRecipe}.
	 * 
	 * @return the ingredient
	 */
	ItemStack getIngredient();
	
	/**
	 * Returns true if this {@link IPotionRecipe} is appliable to the given
	 * {@link ItemStack} {@code potion}.
	 * 
	 * @param ingredient
	 *            the ingredient
	 * @param potion
	 *            the potion stack
	 * @return true, if this potion recipe is appliable
	 */
	boolean canApply(ItemStack ingredient, PotionTypeList potionTypes);
	
	/**
	 * Applies this {@link IPotionRecipe} to the given {@link ItemStack}
	 * {@code potion}.
	 * 
	 * @param ingredient
	 *            the ingredient
	 * @param potion
	 *            the potion stack
	 */
	void apply(ItemStack ingredient, PotionTypeList potionTypes);
}
