package clashsoft.mods.moredimensions.world.chunkmanagers;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldChunkManagerBedworld extends WorldChunkManager
{
	public WorldChunkManagerBedworld()
	{
	}
	
	public WorldChunkManagerBedworld(long seed, WorldType worldType)
	{
		super(seed, worldType);
	}
	
	public WorldChunkManagerBedworld(World world)
	{
		super(world);
	}
}
