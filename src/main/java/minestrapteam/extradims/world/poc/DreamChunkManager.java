package minestrapteam.extradims.world.poc;

import java.util.List;

import clashsoft.cslib.minecraft.world.CustomChunkManager;
import minestrapteam.extradims.dream.Dream;
import minestrapteam.extradims.world.dreams.WorldProviderDreams;
import minestrapteam.extradims.world.dreams.GenLayerDreams;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class DreamChunkManager extends CustomChunkManager
{
	public Dream theDream;
	
	public DreamChunkManager(WorldProviderDreams provider)
	{
		this(provider.getSeed(), provider.terrainType);
		this.theDream = provider.getDream();
	}
	
	public DreamChunkManager(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}
	
	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerDreams(seed, this.theDream).generate(seed, worldType);
	}
	
	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
	}
}
