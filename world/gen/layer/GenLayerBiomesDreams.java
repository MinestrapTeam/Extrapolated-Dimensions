package clashsoft.mods.moredimensions.world.gen.layer;

import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesDreams extends GenLayer
{
	private DreamType	dream;
	
	public GenLayerBiomesDreams(DreamType dream, long seed, GenLayer genlayer)
	{
		super(seed);
		this.parent = genlayer;
		this.dream = dream;
	}
	
	public GenLayerBiomesDreams(DreamType dream, long seed)
	{
		super(seed);
		this.dream = dream;
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		int[] dest = IntCache.getIntCache(width * depth);
		
		for (int dz = 0; dz < depth; dz++)
		{
			for (int dx = 0; dx < width; dx++)
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = dream.getDreamBiome().biomeID;
			}
		}
		return dest;
	}
}