package clashsoft.mods.moredimensions.world.chunk_manager;

import java.util.List;

import clashsoft.cslib.minecraft.world.CustomChunkManager;
import clashsoft.mods.moredimensions.dream.Dream;
import clashsoft.mods.moredimensions.world.gen_layer.GenLayerDreams;
import clashsoft.mods.moredimensions.world.provider.DreamWorldProvider;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class DreamChunkManager extends CustomChunkManager
{
	public Dream theDream;
	
	public DreamChunkManager(DreamWorldProvider provider)
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
		return new GenLayerDreams(this.theDream).createWorld(seed, worldType);
	}
	
	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
	}
}
