package clashsoft.mods.moredimensions.alchemy;

import clashsoft.brewingapi.brewing.PotionType;
import clashsoft.brewingapi.brewing.PotionBase;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class ElixirType extends PotionType
{
	public ElixirType()
	{
		super();
	}

	public ElixirType(PotionEffect effect, int maxAmplifier, int maxDuration, ItemStack ingredient, PotionBase base)
	{
		super(effect, maxAmplifier, maxDuration, ingredient, base);
	}

	public ElixirType(PotionEffect effect, int maxAmplifier, int maxDuration, PotionType inverted, ItemStack ingredient, PotionBase base)
	{
		super(effect, maxAmplifier, maxDuration, inverted, ingredient, base);
	}

	public ElixirType(PotionEffect effect, int maxAmplifier, int maxDuration, PotionType inverted)
	{
		super(effect, maxAmplifier, maxDuration, inverted);
	}

	public ElixirType(PotionEffect effect, int maxAmplifier, int maxDuration)
	{
		super(effect, maxAmplifier, maxDuration);
	}
	
}
