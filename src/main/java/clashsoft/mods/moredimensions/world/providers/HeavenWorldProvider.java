package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.chunkmanagers.HeavenChunkManager;
import clashsoft.mods.moredimensions.world.providers.chunk.ChunkProviderHeaven;

import net.minecraft.world.chunk.IChunkProvider;

public class HeavenWorldProvider extends AbstractWorldProvider
{
	public HeavenWorldProvider()
	{
		super(MDMWorld.HEAVEN_ID);
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new HeavenChunkManager(this.getSeed(), this.terrainType);
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
	
	@Override
	public String getSaveFolder()
	{
		return "HEAVEN";
	}
}