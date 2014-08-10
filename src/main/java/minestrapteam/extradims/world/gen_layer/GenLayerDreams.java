package minestrapteam.extradims.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomGenLayer;
import minestrapteam.extradims.dream.Dream;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerDreams extends CustomGenLayer
{
	public Dream theDream;
	
	public GenLayerDreams(Dream dream)
	{
		this.theDream = dream;
	}
	
	@Override
	public GenLayer getBiomeGenLayer(long seed, WorldType worldType)
	{
		return new GenLayerBiomesDreams(this.theDream, seed);
	}

	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 3;
	}	
}
