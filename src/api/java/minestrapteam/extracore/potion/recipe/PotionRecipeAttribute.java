package minestrapteam.extracore.potion.recipe;

import minestrapteam.extracore.potion.PotionTypeList;
import minestrapteam.extracore.potion.attribute.IPotionAttribute;
import minestrapteam.extracore.potion.type.IPotionType;

import net.minecraft.item.ItemStack;

public class PotionRecipeAttribute extends AbstractPotionRecipe
{
	private IPotionAttribute	attribute;
	
	/**
	 * Constructs a new {@link PotionRecipeAttribute} from the given
	 * {@link ItemStack} {@code input} and the given {@link IPotionAttribute}
	 * {@code attribute}.
	 * 
	 * @param input
	 *            the input stack
	 * @param attribute
	 *            the attribute
	 */
	public PotionRecipeAttribute(ItemStack input, IPotionAttribute attribute)
	{
		super(input);
		this.attribute = attribute;
	}
	
	@Override
	public boolean canApply(PotionTypeList potionTypes)
	{
		return true;
	}
	
	@Override
	public void apply(PotionTypeList potionTypes)
	{
		for (IPotionType potionType : potionTypes)
		{
			potionType.addAttribute(this.attribute);
		}
	}
}
