package clashsoft.mods.moredimensions.world.provider;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.dream.Dream;
import clashsoft.mods.moredimensions.world.chunk_manager.DreamChunkManager;
import clashsoft.mods.moredimensions.world.chunk_provider.DefaultChunkProvider;

import net.minecraft.world.chunk.IChunkProvider;

public class DreamWorldProvider extends CustomWorldProvider
{
	protected Dream theDream;
	
	public DreamWorldProvider()
	{
		super(MDMWorld.DREAMS_ID);
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new DreamChunkManager(this);
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
	
	public void setDream(Dream dream)
	{
		this.theDream = dream;
	}
	
	public Dream getDream()
	{
		return this.theDream;
	}
}