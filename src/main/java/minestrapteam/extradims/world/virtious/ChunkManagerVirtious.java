package minestrapteam.extradims.world.virtious;

import java.util.List;

import minestrapteam.extracore.world.CustomChunkManager;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class ChunkManagerVirtious extends CustomChunkManager
{
	public ChunkManagerVirtious(World world)
	{
		super(world);
	}
	
	public ChunkManagerVirtious(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}
	
	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		for (BiomeGenBase biome : WorldManager.virtiousBiomes)
		{
			list.add(biome);
		}
	}
	
	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerVirtious(seed).generate(seed, worldType);
	}
}
