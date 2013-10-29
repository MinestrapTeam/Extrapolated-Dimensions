package clashsoft.mods.moredimensions.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerHeaven extends GenLayer
{
	public GenLayerHeaven(long seed)
	{
		super(seed);
	}
	
	public static GenLayer[] createWorld(long seed, WorldType worldType)
	{
		GenLayer biomes = new GenLayerBiomesHeaven(1L);
		
		// more GenLayerZoom = bigger biomes
		biomes = new GenLayerZoom(2000L, biomes);
		biomes = new GenLayerZoom(2001L, biomes);
		biomes = new GenLayerZoom(2002L, biomes);
		biomes = new GenLayerZoom(2003L, biomes);
		biomes = new GenLayerZoom(2004L, biomes);
		biomes = new GenLayerZoom(2005L, biomes);
		
		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
		
		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);
		
		return new GenLayer[] { biomes, genlayervoronoizoom };
		
	}
}
