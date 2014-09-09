package minestrapteam.virtious.world;

import java.util.List;

import clashsoft.cslib.minecraft.world.CustomChunkManager;
import minestrapteam.virtious.lib.VWorld;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class VirtiousChunkManager extends CustomChunkManager
{
	public VirtiousChunkManager(World world)
	{
		super(world);
	}
	
	public VirtiousChunkManager(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}
	
	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		list.add(VWorld.gravelBeachBiome);
		list.add(VWorld.virtiousBiome);
		list.add(VWorld.whiskerfieldBiome);
		list.add(VWorld.virtiousOceanBiome);
		list.add(VWorld.canyonBiome);
	}
	
	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerVirtious(seed).generate(seed, worldType);
	}
}
