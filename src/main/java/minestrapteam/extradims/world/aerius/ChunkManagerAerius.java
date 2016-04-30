package minestrapteam.extradims.world.aerius;

import java.util.List;

import minestrapteam.extracore.world.CustomChunkManager;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class ChunkManagerAerius extends CustomChunkManager
{
	public ChunkManagerAerius(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}

	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		list.add(WorldManager.biomeAerius);
		list.add(WorldManager.biomeAerianJungle);
		list.add(WorldManager.biomeAerianForest);
	}

	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerAerius(seed).generate(seed, worldType);
	}
}
