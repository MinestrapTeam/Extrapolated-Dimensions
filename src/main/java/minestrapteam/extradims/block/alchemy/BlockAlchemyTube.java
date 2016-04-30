package minestrapteam.extradims.block.alchemy;

import java.util.List;

import minestrapteam.extracore.world.ECWorld;
import minestrapteam.extradims.api.alchemy.ITubeConnector;
import minestrapteam.extradims.tileentity.TileEntityAlchemyTube;

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
	public BlockAlchemyTube()
	{
		super(Material.glass);
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity)
	{
		boolean[] flags = getConnections(world, x, y, z);
		boolean xp = flags[0];
		boolean xn = flags[1];
		boolean yp = flags[2];
		boolean yn = flags[3];
		boolean zp = flags[4];
		boolean zn = flags[5];
		
		float f = 6F / 16F;
		float f1 = 10F / 16F;
		
		this.setBlockBounds(f, f, f, f1, f1, f1);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		
		if (xp)
		{
			this.setBlockBounds(f, f, f, 1F, f1, f1);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}
		if (xn)
		{
			this.setBlockBounds(0F, f, f, f1, f1, f1);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}
		if (yp)
		{
			this.setBlockBounds(f, f, f, f1, 1F, f1);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}
		if (yn)
		{
			this.setBlockBounds(f, 0F, f, f1, f1, f1);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}
		if (zp)
		{
			this.setBlockBounds(f, f, f, f1, f1, 1F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}
		if (zn)
		{
			this.setBlockBounds(f, f, 0F, f1, f1, f1);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		boolean[] flags = getConnections(world, x, y, z);
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
	public TileEntity createNewTileEntity(World world, int metadata)
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
		Block yNeg = ECWorld.getBlockAtSide(world, x, y, z, 0);
		Block yPos = ECWorld.getBlockAtSide(world, x, y, z, 1);
		Block xNeg = ECWorld.getBlockAtSide(world, x, y, z, 4);
		Block xPos = ECWorld.getBlockAtSide(world, x, y, z, 5);
		Block zNeg = ECWorld.getBlockAtSide(world, x, y, z, 2);
		Block zPos = ECWorld.getBlockAtSide(world, x, y, z, 3);
		
		boolean yn = yNeg instanceof ITubeConnector && ((ITubeConnector) yNeg).canTubeConnectOnSide(world, x, y - 1, z, 1);
		boolean yp = yPos instanceof ITubeConnector && ((ITubeConnector) yPos).canTubeConnectOnSide(world, x, y + 1, z, 0);
		boolean xn = xNeg instanceof ITubeConnector && ((ITubeConnector) xNeg).canTubeConnectOnSide(world, x - 1, y, z, 5);
		boolean xp = xPos instanceof ITubeConnector && ((ITubeConnector) xPos).canTubeConnectOnSide(world, x + 1, y, z, 4);
		boolean zn = zNeg instanceof ITubeConnector && ((ITubeConnector) zNeg).canTubeConnectOnSide(world, x, y, z - 1, 3);
		boolean zp = zPos instanceof ITubeConnector && ((ITubeConnector) zPos).canTubeConnectOnSide(world, x, y, z + 1, 2);
		
		return new boolean[] { xp, xn, yp, yn, zp, zn };
	}
}
