package clashsoft.mods.moredimensions.world.chunk_provider;

import clashsoft.cslib.minecraft.world.CustomChunkProvider;

import net.minecraft.world.World;

public class DefaultChunkProvider extends CustomChunkProvider
{
	public DefaultChunkProvider(World world, long seed, boolean mapFeatures)
	{
		super(world, seed, mapFeatures);
	}
}