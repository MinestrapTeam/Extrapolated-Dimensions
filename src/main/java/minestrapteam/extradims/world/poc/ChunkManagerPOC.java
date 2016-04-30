package minestrapteam.extradims.world.poc;

import java.util.List;

import minestrapteam.extracore.world.CustomChunkManager;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class ChunkManagerPOC extends CustomChunkManager
{
	public ChunkManagerPOC(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}
	
	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		list.add(WorldManager.biomePOCPlains);
		list.add(WorldManager.biomePOCMountains);
		list.add(WorldManager.biomePOCDesert);
	}
	
	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerPOC(seed).generate(seed, worldType);
	}
}
