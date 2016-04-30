package minestrapteam.extradims.world.poc;

import minestrapteam.extracore.world.CustomChunkProvider;
import minestrapteam.extracore.world.CustomWorldProvider;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderPOC extends CustomWorldProvider
{
	public WorldProviderPOC()
	{
		super(WorldManager.POC_ID);
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new ChunkManagerPOC(this.getSeed(), this.terrainType);
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new CustomChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
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
