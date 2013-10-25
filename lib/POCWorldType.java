package clashsoft.mods.moredimensions.lib;

import clashsoft.mods.moredimensions.ParadiseOfChaos;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class POCWorldType extends WorldType
{
	public POCWorldType(int par1, String par2Str)
	{
		this(par1, par2Str, 1);
	}
	
	public POCWorldType(int par1, String par2Str, int par3)
	{
		super(par1, par2Str, par3);
		this.biomesForWorldType = new BiomeGenBase[] { ParadiseOfChaos.PlainsOfInsanityBiome };
	}
	
}
