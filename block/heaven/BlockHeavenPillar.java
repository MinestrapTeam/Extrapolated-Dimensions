package clashsoft.mods.moredimensions.block.heaven;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHeavenPillar extends Block
{
	public BlockHeavenPillar(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1F, 0.9375F);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
