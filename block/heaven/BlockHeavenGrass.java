package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockHeavenGrass extends Block
{
	public Icon	top;
	public Icon	side;
	public Icon	bottom;
	
	/**
	 * @param par1
	 *            BlockID
	 * @param par2
	 *            Top
	 * @param par3
	 *            Side
	 * @param par4
	 *            Bottom
	 */
	public BlockHeavenGrass(int par1)
	{
		super(par1, Material.grass);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2)
	{
		if (par1 == 0)
		{
			return bottom;
		}
		else if (par1 == 1)
		{
			return top;
		}
		else
		{
			return side;
		}
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		side = par1IconRegister.registerIcon("heavengrass_side");
		top = par1IconRegister.registerIcon("heavengrass_top");
		bottom = par1IconRegister.registerIcon("heavendirt");
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && Block.lightOpacity[par1World.getBlockId(par2, par3 + 1, par4)] > 2)
			{
				par1World.setBlock(par2, par3, par4, MDMBlocks.groundBlocks.blockID);
			}
			else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
			{
				for (int var6 = 0; var6 < 4; ++var6)
				{
					int var7 = par2 + par5Random.nextInt(3) - 1;
					int var8 = par3 + par5Random.nextInt(5) - 3;
					int var9 = par4 + par5Random.nextInt(3) - 1;
					int var10 = par1World.getBlockId(var7, var8 + 1, var9);
					
					if (par1World.getBlockId(var7, var8, var9) == MDMBlocks.groundBlocks.blockID && par1World.getBlockMetadata(var7, var8, var9) == 0 && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && Block.lightOpacity[var10] <= 2)
					{
						par1World.setBlock(var7, var8, var9, MDMBlocks.heavenGrass.blockID);
					}
				}
			}
		}
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MDMBlocks.groundBlocks.idDropped(0, par2Random, par3);
	}
}
