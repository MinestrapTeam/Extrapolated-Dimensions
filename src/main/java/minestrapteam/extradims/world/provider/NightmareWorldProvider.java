package minestrapteam.extradims.world.provider;

import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.chunk_manager.DreamChunkManager;

public class NightmareWorldProvider extends DreamWorldProvider
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
