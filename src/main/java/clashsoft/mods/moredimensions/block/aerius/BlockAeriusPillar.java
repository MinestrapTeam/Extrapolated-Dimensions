package clashsoft.mods.moredimensions.block.aerius;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockAeriusPillar extends Block
{
	public IIcon	topIcon;
	
	public BlockAeriusPillar()
	{
		super(Material.rock);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1F, 0.9375F);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("mdm_heaven:pillar_side");
		this.topIcon = iconRegister.registerIcon("mdm_heaven:pillar_top");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return side == 0 || side == 1 ? this.topIcon : this.blockIcon;
	}
}
