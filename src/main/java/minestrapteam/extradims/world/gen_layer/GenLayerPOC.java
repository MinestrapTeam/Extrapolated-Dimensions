package minestrapteam.extradims.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerPOC extends CustomBiomeLayer
{
	public GenLayerPOC(long seed)
	{
		super(seed);
	}
	
	@Override
	public BiomeGenBase[] getBiomes()
	{
		return WorldManager.pocBiomes;
	}
	
	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 5;
	}
}
