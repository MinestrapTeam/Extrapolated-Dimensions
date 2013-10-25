package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.poc.WorldGenWillowTree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockWillowSapling extends BlockFlower
{
	/** change the name to your sapling name **/
	public static final String[]	WOOD_TYPES	= new String[] { "WillowSapling" };
	
	public BlockWillowSapling(int i, int j)
	{
		super(i);
		float var3 = 0.4F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			super.updateTick(par1World, par2, par3, par4, par5Random);
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
			{
				this.func_96477_c(par1World, par2, par3, par4, par5Random);
			}
		}
	}
	
	public void func_96477_c(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		this.growTree(par1World, par2, par3, par4, par5Random);
	}
	
	/**
	 * Attempts to grow a sapling into a tree
	 */
	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4))
			return;
		int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		
		if (flag)
		{
			par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
			par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
			par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
			par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, 0, 0, 4);
		}
		if (!(new WorldGenWillowTree(true)).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
		{
			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
			}
		}
	}
	
	/**
	 * Determines if the same sapling is present at the given location.
	 */
	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
	{
		return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}
	
	/**
	 * Gets passed in the blockID of the block below and supposed to return true
	 * if its allowed to grow on the type of blockID passed in. Args: blockID
	 */
	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		/** Change this to your custom grass **/
		return par1 == MDMBlocks.alteredDirt.blockID || par1 == MDMBlocks.alteredGrass.blockID || par1 == Block.dirt.blockID || par1 == Block.grass.blockID;
	}
}