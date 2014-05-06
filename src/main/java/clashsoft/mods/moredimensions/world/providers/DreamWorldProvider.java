package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.dream.type.DreamType;
import clashsoft.mods.moredimensions.world.providers.chunk.DefaultChunkProvider;

import net.minecraft.world.chunk.IChunkProvider;

public class DreamWorldProvider extends AbstractWorldProvider
{
	public static DreamType	dreamType	= DreamType.plains;
	
	public DreamWorldProvider()
	{
		super(MDMWorld.DREAMS_ID);
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.DREAMS_ID;
		this.worldChunkMgr = new DreamChunkManager(this.getSeed(), this.terrainType).setDreamType(dreamType);
		this.hasNoSky = false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new DefaultChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
	}
	
	@Override
	public String getDimensionName()
	{
		return "Dream";
	}
}