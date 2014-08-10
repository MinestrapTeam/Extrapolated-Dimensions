package clashsoft.mods.moredimensions.world.gen_layer;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import clashsoft.mods.moredimensions.lib.WorldManager;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerBiomesAerius extends CustomBiomeLayer
{
	protected BiomeGenBase[]	allowedBiomes	= { WorldManager.biomeAerius, WorldManager.biomeAerianJungle, WorldManager.biomeAerianForest };
	
	public GenLayerBiomesAerius(long seed, GenLayer genlayer)
	{
		super(seed, genlayer);
	}
	
	public GenLayerBiomesAerius(long seed)
	{
		super(seed);
	}
	
	@Override
	public BiomeGenBase[] getBiomes()
	{
		return this.allowedBiomes;
	}
}