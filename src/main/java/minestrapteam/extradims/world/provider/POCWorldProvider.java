package minestrapteam.extradims.world.provider;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.chunk_manager.POCChunkManager;
import minestrapteam.extradims.world.chunk_provider.DefaultChunkProvider;

import net.minecraft.world.chunk.IChunkProvider;

public class POCWorldProvider extends CustomWorldProvider
{
	public POCWorldProvider()
	{
		super(WorldManager.POC_ID);
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