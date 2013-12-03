package clashsoft.mods.moredimensions.alchemy;

import clashsoft.brewingapi.brewing.PotionType;
import clashsoft.brewingapi.brewing.PotionBase;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class ElixirBrewing extends PotionType
{
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3)
	{
		super(par1PotionEffect, par2, par3);
	}
	
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3, PotionType par4Brewing, ItemStack par5ItemStack, PotionBase par6BrewingBase)
	{
		super(par1PotionEffect, par2, par3, par4Brewing, par5ItemStack, par6BrewingBase);
	}
	
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3, PotionType par4Brewing)
	{
		super(par1PotionEffect, par2, par3, par4Brewing);
	}
	
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3, ItemStack par4ItemStack, PotionBase par5BrewingBase)
	{
		super(par1PotionEffect, par2, par3, par4ItemStack, par5BrewingBase);
	}
	
}
