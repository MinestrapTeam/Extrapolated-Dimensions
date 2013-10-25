package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMagicOakLeaves extends Block
{
	public BlockMagicOakLeaves(int par1)
	{
		super(par1, Material.leaves);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundGrassFootstep);
		this.setHardness(0.2F);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
	
	/**
	 * CLASHSOFT: This code makes blocks use their unlocalized name as icon name
	 */
	@Override
	public Block setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}