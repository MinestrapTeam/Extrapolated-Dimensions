package minestrapteam.extradims.world.dreams;

import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.poc.DreamChunkManager;

public class WorldProviderNightmare extends WorldProviderDreams
{
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = WorldManager.NIGHTMARES_ID;
		this.worldChunkMgr = new DreamChunkManager(this);
		this.hasNoSky = false;
	}
	
	@Override
	public String getDimensionName()
	{
		return "Nightmare";
	}
}
