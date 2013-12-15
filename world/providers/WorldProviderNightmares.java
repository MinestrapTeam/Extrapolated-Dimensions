package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;
import clashsoft.mods.moredimensions.world.chunkmanagers.WorldChunkManagerDreams;

import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNightmares extends WorldProviderDreams
{
	public static DreamType	nightmareType;
	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.NIGHTMARES_ID;
		this.worldChunkMgr = new WorldChunkManagerDreams(nightmareType);
		this.hasNoSky = false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return super.createChunkGenerator();
	}
	
	@Override
	public String getDimensionName()
	{
		return "Nightmare";
	}
}
