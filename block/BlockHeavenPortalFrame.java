package clashsoft.mods.moredimensions.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHeavenPortalFrame extends Block
{
	public BlockHeavenPortalFrame(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
