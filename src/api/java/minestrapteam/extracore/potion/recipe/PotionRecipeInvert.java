package minestrapteam.extracore.potion.recipe;

import minestrapteam.extracore.potion.PotionTypeList;
import minestrapteam.extracore.potion.type.IPotionType;

import net.minecraft.item.ItemStack;

public class PotionRecipeInvert extends AbstractPotionRecipe
{
	public PotionRecipeInvert(ItemStack ingredient)
	{
		super(ingredient);
	}
	
	@Override
	public boolean canApply(PotionTypeList potionTypes)
	{
		for (IPotionType type : potionTypes)
		{
			if (type.isInversible())
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void apply(PotionTypeList potionTypes)
	{
		for (int i = 0; i < potionTypes.size(); i++)
		{
			IPotionType type = potionTypes.get(i);
			type = type.onInverted();
			potionTypes.set(i, type);
		}
	}
}
