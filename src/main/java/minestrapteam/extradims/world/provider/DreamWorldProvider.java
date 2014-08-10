package minestrapteam.extradims.world.provider;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import minestrapteam.extradims.dream.Dream;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.chunk_manager.DreamChunkManager;
import minestrapteam.extradims.world.chunk_provider.DefaultChunkProvider;

import net.minecraft.world.chunk.IChunkProvider;

public class DreamWorldProvider extends CustomWorldProvider
{
	protected Dream theDream;
	
	public DreamWorldProvider()
	{
		super(WorldManager.DREAMS_ID);
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