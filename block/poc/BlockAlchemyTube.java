package clashsoft.mods.moredimensions.block.poc;

import java.util.List;

import clashsoft.clashsoftapi.util.CSWorld;
import clashsoft.mods.moredimensions.alchemy.ITubeConnector;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTube;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAlchemyTube extends BlockContainer implements ITubeConnector
{
	public BlockAlchemyTube(int par1)
	{
		super(par1, Material.glass);
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	{
		boolean[] flags = getConnections(par1World, par2, par3, par4);
		boolean xp = flags[0];
		boolean xn = flags[1];
		boolean yp = flags[2];
		boolean yn = flags[3];
		boolean zp = flags[4];
		boolean zn = flags[5];
		
		float f = 6F / 16F;
		float f1 = 10F / 16F;
		
		this.setBlockBounds(f, f, f, f1, f1, f1);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		
		if (xp)
		{
			this.setBlockBounds(f, f, f, 1F, f1, f1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		if (xn)
		{
			this.setBlockBounds(0F, f, f, f1, f1, f1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		if (yp)
		{
			this.setBlockBounds(f, f, f, f1, 1F, f1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		if (yn)
		{
			this.setBlockBounds(f, 0F, f, f1, f1, f1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		if (zp)
		{
			this.setBlockBounds(f, f, f, f1, f1, 1F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		if (zn)
		{
			this.setBlockBounds(f, f, 0F, f1, f1, f1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1World, int par2, int par3, int par4)
	{
		boolean[] flags = getConnections(par1World, par2, par3, par4);
		boolean xp = flags[0];
		boolean xn = flags[1];
		boolean yp = flags[2];
		boolean yn = flags[3];
		boolean zp = flags[4];
		boolean zn = flags[5];
		
		float f = 6F / 16F;
		float f1 = 10F / 16F;
		this.setBlockBounds(xn ? 0F : f, yn ? 0F : f, zn ? 0F : f, xp ? 1F : f1, yp ? 1F : f1, zp ? 1F : f1);
		this.setBlockBoundsForItemRender();
	}
	
	@Override
	public boolean canTubeConnectOnSide(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityAlchemyTube();
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public static boolean[] getConnections(IBlockAccess world, int x, int y, int z)
	{
		int yNeg = CSWorld.getBlockAtSide(world, x, y, z, 0);
		int yPos = CSWorld.getBlockAtSide(world, x, y, z, 1);
		int xNeg = CSWorld.getBlockAtSide(world, x, y, z, 4);
		int xPos = CSWorld.getBlockAtSide(world, x, y, z, 5);
		int zNeg = CSWorld.getBlockAtSide(world, x, y, z, 2);
		int zPos = CSWorld.getBlockAtSide(world, x, y, z, 3);
		
		boolean yn = Block.blocksList[yNeg] instanceof ITubeConnector && ((ITubeConnector) Block.blocksList[yNeg]).canTubeConnectOnSide(world, x, y - 1, z, 1);
		boolean yp = Block.blocksList[yPos] instanceof ITubeConnector && ((ITubeConnector) Block.blocksList[yPos]).canTubeConnectOnSide(world, x, y + 1, z, 0);
		boolean xn = Block.blocksList[xNeg] instanceof ITubeConnector && ((ITubeConnector) Block.blocksList[xNeg]).canTubeConnectOnSide(world, x - 1, y, z, 5);
		boolean xp = Block.blocksList[xPos] instanceof ITubeConnector && ((ITubeConnector) Block.blocksList[xPos]).canTubeConnectOnSide(world, x + 1, y, z, 4);
		boolean zn = Block.blocksList[zNeg] instanceof ITubeConnector && ((ITubeConnector) Block.blocksList[zNeg]).canTubeConnectOnSide(world, x, y, z - 1, 3);
		boolean zp = Block.blocksList[zPos] instanceof ITubeConnector && ((ITubeConnector) Block.blocksList[zPos]).canTubeConnectOnSide(world, x, y, z + 1, 2);
		
		return new boolean[] { xp, xn, yp, yn, zp, zn };
	}
}
