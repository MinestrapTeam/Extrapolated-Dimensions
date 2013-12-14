package clashsoft.mods.moredimensions.block.heaven;

import clashsoft.mods.moredimensions.addons.MDMItems;
import clashsoft.mods.moredimensions.block.BlockMDM;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockHeavenPillar extends BlockMDM
{
	public Icon topIcon;
	
	public BlockHeavenPillar(int par1)
	{
		super(par1, Material.rock, MDMItems.tabHeavenBlocks);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1F, 0.9375F);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("moredimensions:pillar_side");
		this.topIcon = par1IconRegister.registerIcon("moredimensions:pillar_top");
	}
	
	@Override
	public Icon getIcon(int side, int metadata)
	{
		return side == 0 || side == 1 ? this.topIcon : this.blockIcon;
	}
}
