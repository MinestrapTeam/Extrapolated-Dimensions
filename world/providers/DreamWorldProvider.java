package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;
import clashsoft.mods.moredimensions.world.providers.chunk.DefaultChunkProvider;

import net.minecraft.world.chunk.IChunkProvider;

public class DreamWorldProvider extends AbstractWorldProvider
{
	public static DreamType	dreamType	= DreamType.plains;
	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMWorld.DREAMS_ID;
		this.worldChunkMgr = new DreamChunkManager().setDreamType(dreamType);
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