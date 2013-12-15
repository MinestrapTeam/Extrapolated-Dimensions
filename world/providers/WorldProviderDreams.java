package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;
import clashsoft.mods.moredimensions.world.chunkmanagers.WorldChunkManagerDreams;
import clashsoft.mods.moredimensions.world.providers.chunk.ChunkProviderDreams;

import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderDreams extends AbstractWorldProvider
{	
	public static DreamType	dreamType			= DreamType.plains;
	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.DREAMS_ID;
		this.worldChunkMgr = new WorldChunkManagerDreams(dreamType);
		this.hasNoSky = false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderDreams(this.worldObj, this.worldObj.getSeed(), false, dreamType);
	}

	@Override
	public String getDimensionName()
	{
		return "Dream";
	}
}