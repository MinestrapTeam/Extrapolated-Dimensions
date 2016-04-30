package minestrapteam.extracore.potion.recipe;

import minestrapteam.extracore.potion.PotionTypeList;
import minestrapteam.extracore.item.stack.ECStacks;

import net.minecraft.item.ItemStack;

public abstract class AbstractPotionRecipe implements IPotionRecipe
{
	protected ItemStack	ingredient;
	
	public AbstractPotionRecipe(ItemStack input)
	{
		this.ingredient = input;
	}
	
	@Override
	public IPotionRecipe register()
	{
		PotionRecipes.recipes.add(this);
		return this;
	}
	
	@Override
	public ItemStack getIngredient()
	{
		return this.ingredient;
	}
	
	@Override
	public boolean canApply(ItemStack ingredient, PotionTypeList potionTypes)
	{
		return ECStacks.itemEquals(this.getIngredient(), ingredient) && this.canApply(potionTypes);
	}
	
	/**
	 * Returns true if this {@link IPotionRecipe} is appliable to the given
	 * {@link ItemStack} {@code potion}.
	 * 
	 * @param potion
	 *            the potion stack
	 * @return true, if this potion recipe is appliable
	 */
	public abstract boolean canApply(PotionTypeList potionTypes);
	
	@Override
	public void apply(ItemStack ingredient, PotionTypeList potionTypes)
	{
		this.apply(potionTypes);
	}
	
	/**
	 * Applies this {@link IPotionRecipe} to the given {@link ItemStack}
	 * {@code potion}.
	 * 
	 * @param potion
	 *            the potion stack
	 */
	public abstract void apply(PotionTypeList potionTypes);
}
