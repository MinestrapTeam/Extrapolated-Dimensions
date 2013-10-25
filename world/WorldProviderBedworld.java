package clashsoft.mods.moredimensions.world;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderBedworld extends WorldProvider
{
	public WorldProviderBedworld()
	{
		
	}
	
	@Override
	// required by MC:
	public void registerWorldChunkManager()
	{
		worldChunkMgr = new WorldChunkManagerBedworld(worldObj);
	}
	
	public IChunkProvider getChunkProvider()
	{
		return null;
	}
	
	@Override
	public String getDimensionName()
	{
		return null;
	}
}
