package minestrapteam.virtious.world;

import clashsoft.cslib.minecraft.world.CustomChunkProvider;

import net.minecraft.world.World;

public class VirtiousChunkProvider extends CustomChunkProvider
{
	public VirtiousChunkProvider(World world, long seed, boolean mapFeatures)
	{
		super(world, seed, mapFeatures);
	}
}
