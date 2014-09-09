package minestrapteam.virtious.block;

import clashsoft.cslib.minecraft.block.IBlockRenderPass;
import clashsoft.cslib.minecraft.client.renderer.block.RenderBlockMulti;
import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.client.renderer.block.RenderGlowingBlock;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCytoidLightstrip extends VBlock implements IBlockRenderPass
{
	public IIcon	lightStripIcon;
	public IIcon	lightStripGlowIcon;
	
	public BlockCytoidLightstrip()
	{
		super(Material.iron);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
		this.setLightLevel(1F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("virtious:cytoid_wall");
		this.lightStripIcon = iconRegister.registerIcon("virtious:cytoid_lightstrip");
		this.lightStripGlowIcon = iconRegister.registerIcon("virtious:cytoid_lightstrip_light");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side > 1)
		{
			if (RenderBlockMulti.renderPass == 1)
			{
				return this.lightStripGlowIcon;
			}
			return this.lightStripIcon;
		}
		return this.blockIcon;
	}
	
	@Override
	public int getRenderPasses(int metadata)
	{
		return 2;
	}
	
	@Override
	public int getRenderType()
	{
		return RenderGlowingBlock.instance.getRenderId();
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
