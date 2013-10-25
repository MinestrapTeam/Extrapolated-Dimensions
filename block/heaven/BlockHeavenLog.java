package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockHeavenLog extends Block
{
	private Icon	top;
	private Icon	side;
	
	public BlockHeavenLog(int par1)
	{
		super(par1, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
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
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MDMBlocks.heavenLog.blockID;
	}
	
	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		byte var7 = 4;
		int var8 = var7 + 1;
		
		if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
		{
			for (int var9 = -var7; var9 <= var7; ++var9)
			{
				for (int var10 = -var7; var10 <= var7; ++var10)
				{
					for (int var11 = -var7; var11 <= var7; ++var11)
					{
						int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);
						
						if (Block.blocksList[var12] != null)
						{
							Block.blocksList[var12].beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
		int var7 = BlockPistonBase.determineOrientation(par1World, par2, par3, par4, par5EntityLivingBase);
		byte var8 = 0;
		
		switch (var7)
		{
		case 0:
		case 1:
			var8 = 0;
			break;
		case 2:
		case 3:
			var8 = 8;
			break;
		case 4:
		case 5:
			var8 = 4;
		}
		
		par1World.setBlock(par2, par3, par4, this.blockID, var6 | var8, 3);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		top = par1IconRegister.registerIcon("heavenwood_top");
		side = par1IconRegister.registerIcon("heavenwood_side");
	}
	
	@Override
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2)
	{
		if (par1 == 0 || par1 == 1)
		{
			return top;
		}
		else
		{
			return side;
		}
	}
	
	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}
}
