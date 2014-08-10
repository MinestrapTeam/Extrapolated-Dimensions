package clashsoft.mods.moredimensions.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import clashsoft.mods.moredimensions.lib.WorldManager;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerBiomesPOC extends CustomBiomeLayer
{
	protected BiomeGenBase[]	allowedBiomes	= { WorldManager.biomePOCPlains, WorldManager.biomePOCMountains, WorldManager.biomePOCDesert, WorldManager.biomeBloodPlains };

	public GenLayerBiomesPOC(long seed, GenLayer genlayer)
	{
		super(seed, genlayer);
	}

	public GenLayerBiomesPOC(long seed)
	{
		super(seed);
	}
	
	@Override
	public BiomeGenBase[] getBiomes()
	{
		return this.allowedBiomes;
	}
}