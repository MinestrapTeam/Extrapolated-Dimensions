package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.chunkmanagers.WorldChunkManagerPOC;
import clashsoft.mods.moredimensions.world.providers.chunk.ChunkProviderPOC;

import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderPOC extends AbstractWorldProvider
{	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.POC_ID;
		this.worldChunkMgr = new WorldChunkManagerPOC();
		this.hasNoSky = false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderPOC(this.worldObj, this.worldObj.getSeed(), false);
	}
	
	@Override
	public String getDimensionName()
	{
		return "Paradise Of Chaos";
	}
}