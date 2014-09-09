package minestrapteam.extradims.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerAerius extends CustomBiomeLayer
{
	public GenLayerAerius(long seed)
	{
		super(seed);
	}
	
	@Override
	public BiomeGenBase[] getBiomes()
	{
		return WorldManager.aeriusBiomes;
	}
	
	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 5;
	}
}
