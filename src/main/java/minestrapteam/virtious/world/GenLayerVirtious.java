package minestrapteam.virtious.world;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import minestrapteam.virtious.lib.VWorld;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerVirtious extends CustomBiomeLayer
{
	public GenLayerVirtious(long seed)
	{
		super(seed);
	}

	@Override
	public BiomeGenBase[] getBiomes()
	{
		return VWorld.biomes;
	}
	
	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 5;
	}
}
