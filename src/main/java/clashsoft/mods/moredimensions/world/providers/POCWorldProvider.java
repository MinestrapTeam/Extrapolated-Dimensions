package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.chunkmanagers.POCChunkManager;
import clashsoft.mods.moredimensions.world.providers.chunk.DefaultChunkProvider;

import net.minecraft.world.chunk.IChunkProvider;

public class POCWorldProvider extends AbstractWorldProvider
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
}