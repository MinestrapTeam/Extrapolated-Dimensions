package minestrapteam.extradims.world.aerius;

import minestrapteam.extracore.world.CustomChunkManager;
import minestrapteam.extradims.lib.aerius.Aerius;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import java.util.Collections;
import java.util.List;

public class ChunkManagerAerius extends CustomChunkManager
{
	public ChunkManagerAerius(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}

	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		Collections.addAll(list, Aerius.aeriusBiomes);
	}

	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerAerius(seed).generate(seed, worldType);
	}
}
