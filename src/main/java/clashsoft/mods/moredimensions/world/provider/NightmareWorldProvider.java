package clashsoft.mods.moredimensions.world.provider;

import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.chunk_manager.DreamChunkManager;

public class NightmareWorldProvider extends DreamWorldProvider
{
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.NIGHTMARES_ID;
		this.worldChunkMgr = new DreamChunkManager(this);
		this.hasNoSky = false;
	}
	
	@Override
	public String getDimensionName()
	{
		return "Nightmare";
	}
}
