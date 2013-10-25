package clashsoft.mods.moredimensions.alchemy;

import clashsoft.brewingapi.brewing.Brewing;
import clashsoft.brewingapi.brewing.BrewingBase;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class ElixirBrewing extends Brewing
{
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3)
	{
		super(par1PotionEffect, par2, par3);
	}
	
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3, Brewing par4Brewing, ItemStack par5ItemStack, BrewingBase par6BrewingBase)
	{
		super(par1PotionEffect, par2, par3, par4Brewing, par5ItemStack, par6BrewingBase);
	}
	
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3, Brewing par4Brewing)
	{
		super(par1PotionEffect, par2, par3, par4Brewing);
	}
	
	public ElixirBrewing(PotionEffect par1PotionEffect, int par2, int par3, ItemStack par4ItemStack, BrewingBase par5BrewingBase)
	{
		super(par1PotionEffect, par2, par3, par4ItemStack, par5BrewingBase);
	}
	
}
