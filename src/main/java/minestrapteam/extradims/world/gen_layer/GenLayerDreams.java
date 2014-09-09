package minestrapteam.extradims.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import minestrapteam.extradims.dream.Dream;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerDreams extends CustomBiomeLayer
{
	public Dream	theDream;
	
	public GenLayerDreams(long seed, Dream dream)
	{
		super(seed);
		this.theDream = dream;
	}
	
	@Override
	public BiomeGenBase[] getBiomes()
	{
		// FIXME
		return null;
	}
	
	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 3;
	}
}
