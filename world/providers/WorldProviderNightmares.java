package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMConfig;
import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;
import clashsoft.mods.moredimensions.world.chunkmanagers.WorldChunkManagerDreams;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNightmares extends WorldProviderDreams
{
	public static DreamType	nightmareType;
	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMConfig.NIGHTMARES_DIMENSION_ID;
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
	
	@Override
	public boolean renderStars()
	{
		return !super.renderStars();
	}
	
	@Override
	public float getStarBrightness(World world, float f)
	{
		return 100F;
	}
	
	@Override
	public boolean renderClouds()
	{
		return !super.renderClouds();
	}
	
	@Override
	public boolean renderVoidFog()
	{
		return !super.renderVoidFog();
	}
	
	@Override
	public boolean renderEndSky()
	{
		return !super.renderEndSky();
	}
	
	@Override
	public float setSunSize()
	{
		return 0F;
	}
	
	@Override
	public float setMoonSize()
	{
		return 1F;
	}
	
	@Override
	public String getWelcomeMessage()
	{
		return "Entering Nightmare";
	}
}
