package clashsoft.mods.moredimensions.world.providers;

import java.util.List;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import clashsoft.mods.moredimensions.dream.type.DreamType;
import clashsoft.mods.moredimensions.world.chunkmanagers.AbstractChunkManager;
import clashsoft.mods.moredimensions.world.gen.layer.GenLayerDreams;

public class DreamChunkManager extends AbstractChunkManager
{
	public DreamType dreamType;
	
	public DreamChunkManager(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}
	
	public DreamChunkManager setDreamType(DreamType dreamType)
	{
		this.dreamType = dreamType;
		return this;
	}
	
	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		if (this.dreamType != null)
		{
			this.dreamType.addBiomes(list);
		}
	}
	
	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return GenLayerDreams.createWorld(this.dreamType, seed, worldType);
	}
}
