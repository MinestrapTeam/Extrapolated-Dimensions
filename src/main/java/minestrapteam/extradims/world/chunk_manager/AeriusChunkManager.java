package minestrapteam.extradims.world.chunk_manager;

import java.util.List;

import clashsoft.cslib.minecraft.world.CustomChunkManager;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.gen_layer.GenLayerAerius;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class AeriusChunkManager extends CustomChunkManager
{
	public AeriusChunkManager(long seed, WorldType worldType)
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