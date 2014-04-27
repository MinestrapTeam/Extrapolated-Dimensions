package clashsoft.mods.moredimensions.world.chunkmanagers;

import java.util.List;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.gen.layer.GenLayerHeaven;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class HeavenChunkManager extends AbstractChunkManager
{

	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		list.add(MDMWorld.biomeHeaven);
		list.add(MDMWorld.biomeHeavenJungle);
	}

	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return GenLayerHeaven.createWorld(seed, worldType);
	}
}