package minestrapteam.extradims.client.renderer.block;

import minestrapteam.extracore.client.renderer.block.RenderBlockMulti;
import minestrapteam.extradims.client.EDClientProxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderGlowingBlock extends RenderBlockMulti
{
	public static RenderGlowingBlock instance = new RenderGlowingBlock();

	public RenderGlowingBlock()
	{
		super(EDClientProxy.lightStripRenderType);
	}

	@Override
	public boolean renderBlock(IBlockAccess world, int x, int y, int z, Block block, int metadata, RenderBlocks renderer, boolean inventory)
	{
		if (metadata == 1)
		{
			Tessellator.instance.setBrightness(160);
		}
		return super.renderBlock(world, x, y, z, block, metadata, renderer, inventory);
	}
}
