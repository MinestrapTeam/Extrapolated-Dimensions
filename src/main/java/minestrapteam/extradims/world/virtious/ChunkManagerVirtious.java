package minestrapteam.extradims.world.virtious;

import minestrapteam.extracore.world.CustomChunkManager;
import minestrapteam.extradims.lib.virtious.Virtious;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import java.util.Collections;
import java.util.List;

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
		Collections.addAll(list, Virtious.virtiousBiomes);
	}

	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerVirtious(seed).generate(seed, worldType);
	}
}
