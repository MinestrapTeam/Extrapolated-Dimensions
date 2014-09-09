package minestrapteam.virtious.world;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import minestrapteam.virtious.client.renderer.VirtiousSkyRenderer;
import minestrapteam.virtious.lib.VWorld;

import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class VirtiousWorldProvider extends CustomWorldProvider
{
	public VirtiousWorldProvider()
	{
		super(VWorld.dimensionID);
		this.hasNoSky = false;
	}

	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new VirtiousChunkManager(this.worldObj);
		
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new VirtiousChunkProvider(this.worldObj, this.getSeed(), true);
	}

	@Override
	public String getDimensionName()
	{
		return "Virtious";
	}
	
	@Override
	public String getSaveFolder()
	{
		return "VIRTIOUS";
	}
	
	@Override
	public IRenderHandler getSkyRenderer()
	{
		return VirtiousSkyRenderer.instance;
	}
}
