package clashsoft.mods.moredimensions.world.chunkmanagers;

import java.util.List;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.gen.layer.GenLayerPOC;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class POCChunkManager extends AbstractChunkManager
{
	public POCChunkManager(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}
	
	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		list.add(MDMWorld.biomePOCPlains);
		list.add(MDMWorld.biomePOCMountains);
		list.add(MDMWorld.biomePOCDesert);
	}
	
	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return GenLayerPOC.createWorld(seed, worldType);
	}
}