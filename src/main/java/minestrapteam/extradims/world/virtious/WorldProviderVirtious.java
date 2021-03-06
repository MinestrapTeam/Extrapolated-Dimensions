package minestrapteam.extradims.world.virtious;

import minestrapteam.extracore.world.CustomWorldProvider;
import minestrapteam.extradims.client.renderer.VirtiousSkyRenderer;
import minestrapteam.extradims.lib.virtious.Virtious;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderVirtious extends CustomWorldProvider
{
	public WorldProviderVirtious()
	{
		super(Virtious.VIRTIOUS_ID);
		this.hasNoSky = false;
	}

	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new ChunkManagerVirtious(this.worldObj);
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderVirtious(this.worldObj, this.getSeed(), true);
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
		return VirtiousSkyRenderer.INSTANCE;
	}
}
