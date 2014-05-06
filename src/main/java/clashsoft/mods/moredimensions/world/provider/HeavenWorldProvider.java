package clashsoft.mods.moredimensions.world.provider;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.chunk_manager.HeavenChunkManager;
import clashsoft.mods.moredimensions.world.chunk_provider.ChunkProviderHeaven;

import net.minecraft.world.chunk.IChunkProvider;

public class HeavenWorldProvider extends CustomWorldProvider
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