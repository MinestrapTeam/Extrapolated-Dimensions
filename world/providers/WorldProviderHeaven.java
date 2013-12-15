package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.chunkmanagers.WorldChunkManagerHeaven;
import clashsoft.mods.moredimensions.world.providers.chunk.ChunkProviderHeaven;

import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderHeaven extends AbstractWorldProvider
{	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.HEAVEN_ID;
		this.worldChunkMgr = new WorldChunkManagerHeaven();
		this.hasNoSky = false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderHeaven(this.worldObj, this.worldObj.getSeed());
	}

	@Override
	public String getDimensionName()
	{
		return "Heaven";
	}
}