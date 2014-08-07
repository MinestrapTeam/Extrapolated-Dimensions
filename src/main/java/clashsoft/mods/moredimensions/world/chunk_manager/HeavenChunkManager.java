package clashsoft.mods.moredimensions.world.chunk_manager;

import java.util.List;

import clashsoft.cslib.minecraft.world.CustomChunkManager;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.gen_layer.GenLayerHeaven;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class HeavenChunkManager extends CustomChunkManager
{
	public HeavenChunkManager(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}

	@Override
	public void addBiomes(List<BiomeGenBase> list)
	{
		list.add(MDMWorld.biomeHeaven);
		list.add(MDMWorld.biomeHeavenJungle);
	}

	@Override
	public GenLayer[] getGenLayers(long seed, WorldType worldType)
	{
		return new GenLayerHeaven().createWorld(seed, worldType);
	}
}