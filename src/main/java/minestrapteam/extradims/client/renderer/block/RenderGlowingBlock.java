package minestrapteam.extradims.client.renderer.block;

import clashsoft.cslib.minecraft.client.renderer.block.RenderBlockMulti;
import minestrapteam.extradims.client.EDClientProxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderGlowingBlock extends RenderBlockMulti
{
	public static RenderGlowingBlock instance = new RenderGlowingBlock();
	
	@Override
	protected void renderPass(int pass, IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer)
	{
		if (pass == 1)
		{
			Tessellator.instance.setBrightness(160);
		}
		super.renderPass(pass, world, x, y, z, block, renderer);
	}
	
	@Override
	public int getRenderID()
	{
		return EDClientProxy.lightStripRenderType;
	}
}
