package minestrapteam.extracore.potion.recipe;

import minestrapteam.extracore.potion.PotionTypeList;
import minestrapteam.extracore.item.stack.ECStacks;

import net.minecraft.item.ItemStack;

public class CustomPotionRecipe extends AbstractPotionRecipe
{
	public ItemStack input;
	public ItemStack output;
	
	public CustomPotionRecipe(ItemStack input, ItemStack ingredient, ItemStack output)
	{
		super(ingredient);
		this.input = input;
		this.output = output;
	}

	@Override
	public boolean canApply(PotionTypeList potionTypes)
	{
		return ECStacks.equals(potionTypes.getPotion(), this.input);
	}

	@Override
	public void apply(PotionTypeList potionTypes)
	{
		potionTypes.setStack(this.output.copy());
	}
}
