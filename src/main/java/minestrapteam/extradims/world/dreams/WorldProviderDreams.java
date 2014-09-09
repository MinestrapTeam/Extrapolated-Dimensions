package minestrapteam.extradims.world.dreams;

import clashsoft.cslib.minecraft.world.CustomChunkProvider;
import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import minestrapteam.extradims.dream.Dream;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.poc.DreamChunkManager;

import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderDreams extends CustomWorldProvider
{
	protected Dream theDream;
	
	public WorldProviderDreams()
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
		return new CustomChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
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