package minestrapteam.extradims.world.dreams;

import java.util.List;

import minestrapteam.extracore.world.CustomChunkManager;
import minestrapteam.extradims.dream.Dream;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class ChunkManagerDreams extends CustomChunkManager
{
	public Dream theDream;
	
	public ChunkManagerDreams(WorldProviderDreams provider)
	{
		this(provider.getSeed(), provider.terrainType);
		this.theDream = provider.getDream();
	}
	
	public ChunkManagerDreams(long seed, WorldType worldType)
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
