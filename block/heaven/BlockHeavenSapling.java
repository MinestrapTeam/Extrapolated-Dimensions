package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.poc.WorldGenTreesMoreDimensions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockHeavenSapling extends BlockHeavenPlant
{
	public BlockHeavenSapling(int par1)
	{
		super(par1, new String[] { "Heaven Sapling" }, new String[] { "heavensapling" });
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
				int var6 = par1World.getBlockMetadata(par2, par3, par4);
				
				if ((var6 & 8) == 0)
				{
					par1World.setBlock(par2, par3, par4, this.blockID, var6 | 8, 3);
				}
				else
				{
					this.growTree(par1World, par2, par3, par4, par5Random);
				}
			}
		}
	}
	
	/**
	 * Attempts to grow a sapling into a tree
	 */
	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
		Object var7 = null;
		int var8 = 0;
		int var9 = 0;
		boolean var10 = false;
		
		var7 = new WorldGenTreesMoreDimensions(true, 5, MDMBlocks.heavenLog.blockID, MDMBlocks.heavenLeaves.blockID, 0, 0, false);
		
		if (var10)
		{
			par1World.setBlock(par2 + var8, par3, par4 + var9, 0);
			par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, 0);
			par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, 0);
			par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, 0);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, 0);
		}
		
		if (!((WorldGenerator) var7).generate(par1World, par5Random, par2 + var8, par3, par4 + var9))
		{
			if (var10)
			{
				par1World.setBlock(par2 + var8, par3, par4 + var9, this.blockID, var6, 3);
				par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, this.blockID, var6, 3);
				par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, this.blockID, var6, 3);
				par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, this.blockID, var6, 3);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, this.blockID, var6, 3);
			}
		}
	}
	
}
