package minestrapteam.extradims.world.dreams;

import minestrapteam.extradims.lib.WorldManager;

public class WorldProviderNightmare extends WorldProviderDreams
{
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = WorldManager.NIGHTMARES_ID;
		this.worldChunkMgr = new ChunkManagerDreams(this);
		this.hasNoSky = false;
	}
	
	@Override
	public String getDimensionName()
	{
		return "Nightmare";
	}
}
