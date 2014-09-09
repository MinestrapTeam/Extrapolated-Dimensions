package minestrapteam.extradims.world.poc;

import clashsoft.cslib.minecraft.world.CustomChunkProvider;
import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import minestrapteam.extradims.lib.WorldManager;

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