package clashsoft.mods.moredimensions.block;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockHeavenCompressor extends Block
{
	private static boolean	keepFurnaceInventory	= false;
	
	public BlockHeavenCompressor(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabDecorations);
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
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}
	
	/**
	 * set a blocks direction
	 */
	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			int var5 = par1World.getBlockId(par2, par3, par4 - 1);
			int var6 = par1World.getBlockId(par2, par3, par4 + 1);
			int var7 = par1World.getBlockId(par2 - 1, par3, par4);
			int var8 = par1World.getBlockId(par2 + 1, par3, par4);
			byte var9 = 3;
			
			if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
			{
				var9 = 3;
			}
			
			if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
			{
				var9 = 2;
			}
			
			if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
			{
				var9 = 5;
			}
			
			if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
			{
				var9 = 4;
			}
			
			par1World.setBlock(par2, par3, par4, this.blockID, var9, 3);
		}
	}
	
	// @SideOnly(Side.CLIENT)
	//
	// /**
	// * Retrieves the block texture to use based on the display side. Args:
	// iBlockAccess, x, y, z, side
	// */
	// public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int
	// par3, int par4, int par5)
	// {
	// if (par5 == 1)
	// {
	// return 55;
	// }
	// else if (par5 == 0)
	// {
	// return 55;
	// }
	// else
	// {
	// int var6 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
	//
	// return par5 != var6 ? 40 : 39;
	// }
	//
	// }
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			/*
			 * TileEntityHeavenCompressor var10 =
			 * (TileEntityHeavenCompressor)par1World.getBlockTileEntity(par2,
			 * par3, par4); if (var10 != null) {
			 * FMLClientHandler.instance().getClient().displayGuiScreen(new
			 * GuiHeavenCompressor(par5EntityPlayer.inventory, var10)); }
			 */
			
			return true;
		}
	}
	
	/**
	 * Update which block ID the furnace is using depending on whether or not it
	 * is burning
	 */
	public static void updateCompressorBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;
		
		if (par0)
		{
			par1World.setBlock(par2, par3, par4, MDMBlocks.compressor.blockID);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, MDMBlocks.compressor.blockID);
		}
		
		keepFurnaceInventory = false;
		par1World.setBlock(par2, par3, par4, var5);
		
		if (var6 != null)
		{
			var6.validate();
			par1World.setBlockTileEntity(par2, par3, par4, var6);
		}
	}
	
	/**
	 * each class overrides this to return a new <className>
	 */
	/*
	 * public TileEntity createNewTileEntity(World par1World) { return new
	 * TileEntityHeavenCompressor(); }
	 */
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		int var6 = MathHelper.floor_double(par5EntityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (var6 == 0)
		{
			par1World.setBlock(par2, par3, par4, this.blockID, 2, 3);
		}
		
		if (var6 == 1)
		{
			par1World.setBlock(par2, par3, par4, this.blockID, 5, 3);
		}
		
		if (var6 == 2)
		{
			par1World.setBlock(par2, par3, par4, this.blockID, 3, 3);
		}
		
		if (var6 == 3)
		{
			par1World.setBlock(par2, par3, par4, this.blockID, 4, 3);
		}
	}
	
	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if (!keepFurnaceInventory)
		{
			/*
			 * TileEntityHeavenCompressor var7 =
			 * (TileEntityHeavenCompressor)par1World.getBlockTileEntity(par2,
			 * par3, par4); if (var7 != null) { for (int var8 = 0; var8 <
			 * var7.getSizeInventory(); ++var8) { ItemStack var9 =
			 * var7.getStackInSlot(var8); if (var9 != null) { float var10 =
			 * this.furnaceRand.nextFloat() * 0.8F + 0.1F; float var11 =
			 * this.furnaceRand.nextFloat() * 0.8F + 0.1F; float var12 =
			 * this.furnaceRand.nextFloat() * 0.8F + 0.1F; while (var9.stackSize
			 * > 0) { int var13 = this.furnaceRand.nextInt(21) + 10; if (var13 >
			 * var9.stackSize) { var13 = var9.stackSize; } var9.stackSize -=
			 * var13; EntityItem var14 = new EntityItem(par1World,
			 * (double)((float)par2 + var10), (double)((float)par3 + var11),
			 * (double)((float)par4 + var12), new ItemStack(var9.itemID, var13,
			 * var9.getItemDamage())); if (var9.hasTagCompound()) {
			 * var14.item.setTagCompound
			 * ((NBTTagCompound)var9.getTagCompound().copy()); } float var15 =
			 * 0.05F; var14.motionX =
			 * (double)((float)this.furnaceRand.nextGaussian() * var15);
			 * var14.motionY = (double)((float)this.furnaceRand.nextGaussian() *
			 * var15 + 0.2F); var14.motionZ =
			 * (double)((float)this.furnaceRand.nextGaussian() * var15);
			 * par1World.spawnEntityInWorld(var14); } } } }
			 */
		}
		
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
}
