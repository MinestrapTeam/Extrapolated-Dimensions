package clashsoft.mods.moredimensions.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMDM extends Block
{
	public BlockMDM(int par1, Material par2Material, CreativeTabs par3CreativeTabs)
	{
		super(par1, par2Material);
		this.setCreativeTab(par3CreativeTabs);
	}
	
	@Override
	public Block setUnlocalizedName(String par1Str)
	{
		this.setTextureName(par1Str);
		return super.setUnlocalizedName(par1Str);
	}
}
