package clashsoft.mods.moredimensions.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Deprecated
public class BlockMDM extends Block
{
	public BlockMDM(int blockID, Material material, CreativeTabs creativeTab)
	{
		super(blockID, material);
		this.setCreativeTab(creativeTab);
	}
}
