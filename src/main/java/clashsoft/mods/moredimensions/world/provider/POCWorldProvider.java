package clashsoft.mods.moredimensions.world.provider;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.chunk_manager.POCChunkManager;
import clashsoft.mods.moredimensions.world.chunk_provider.DefaultChunkProvider;

import net.minecraft.world.chunk.IChunkProvider;

public class POCWorldProvider extends CustomWorldProvider
{
	public POCWorldProvider()
	{
		super(MDMWorld.POC_ID);
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new POCChunkManager(this.getSeed(), this.terrainType);
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new DefaultChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
	}
	
	@Override
	public String getDimensionName()
	{
		return "Paradise Of Chaos";
	}
	
	@Override
	public String getSaveFolder()
	{
		return "POC";
	}
}