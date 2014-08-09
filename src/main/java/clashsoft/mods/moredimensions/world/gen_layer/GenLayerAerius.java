package clashsoft.mods.moredimensions.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomGenLayer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerAerius extends CustomGenLayer
{	
	@Override
	public GenLayer getBiomeGenLayer(long seed, WorldType worldType)
	{
		return new GenLayerBiomesAerius(seed);
	}
	
	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 5;
	}
}
