package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;

public class NightmareWorldProvider extends DreamWorldProvider
{
	public static DreamType	nightmareType;
	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.NIGHTMARES_ID;
		this.worldChunkMgr = new DreamChunkManager(this.getSeed(), this.terrainType).setDreamType(nightmareType);;
		this.hasNoSky = false;
	}
	
	@Override
	public String getDimensionName()
	{
		return "Nightmare";
	}
}
