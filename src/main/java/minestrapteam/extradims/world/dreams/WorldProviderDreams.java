package minestrapteam.extradims.world.dreams;

import minestrapteam.extracore.world.CustomChunkProvider;
import minestrapteam.extracore.world.CustomWorldProvider;
import minestrapteam.extradims.dream.Dream;
import minestrapteam.extradims.lib.WorldManager;

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
		this.worldChunkMgr = new ChunkManagerDreams(this);
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
