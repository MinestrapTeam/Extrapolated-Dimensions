package clashsoft.mods.moredimensions.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomGenLayer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerHeaven extends CustomGenLayer
{	
	@Override
	public GenLayer getBiomeGenLayer(long seed, WorldType worldType)
	{
		return new GenLayerBiomesHeaven(seed);
	}
	
	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 4;
	}
}
