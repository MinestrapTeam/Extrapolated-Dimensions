package clashsoft.mods.moredimensions.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import clashsoft.mods.moredimensions.dream.Dream;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerBiomesDreams extends CustomBiomeLayer
{
	private Dream	dream;
	
	public GenLayerBiomesDreams(Dream dream, long seed, GenLayer genlayer)
	{
		super(seed, genlayer);
		this.dream = dream;
	}
	
	public GenLayerBiomesDreams(Dream dream, long seed)
	{
		super(seed);
		this.dream = dream;
	}
	
	@Override
	public BiomeGenBase[] getBiomes()
	{
		return null;
	}
}