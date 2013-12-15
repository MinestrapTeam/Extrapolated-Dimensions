package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.teleporters.TeleporterHeaven;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHeavenPortal extends BlockBreakable
{
	public BlockHeavenPortal(int blockID)
	{
		super(blockID, "moredimensions:heaven_portal", Material.portal, false);
		this.setTickRandomly(true);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		float f;
		float f1;
		
		if (world.getBlockId(x - 1, y, z) != this.blockID && world.getBlockId(x + 1, y, z) != this.blockID)
		{
			f = 0.125F;
			f1 = 0.5F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
		else
		{
			f = 0.5F;
			f1 = 0.125F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared face of two adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
	 */
	public boolean tryToCreatePortal(World world, int x, int y, int z)
	{
		byte b0 = 0;
		byte b1 = 0;
		
		if (world.getBlockId(x - 1, y, z) == MDMBlocks.heavenPortalFrame.blockID || world.getBlockId(x + 1, y, z) == MDMBlocks.heavenPortalFrame.blockID)
		{
			b0 = 1;
		}
		
		if (world.getBlockId(x, y, z - 1) == MDMBlocks.heavenPortalFrame.blockID || world.getBlockId(x, y, z + 1) == MDMBlocks.heavenPortalFrame.blockID)
		{
			b1 = 1;
		}
		
		if (b0 == b1)
		{
			return false;
		}
		else
		{
			if (world.isAirBlock(x - b0, y, z - b1))
			{
				x -= b0;
				z -= b1;
			}
			
			int l;
			int i1;
			
			for (l = -1; l <= 2; ++l)
			{
				for (i1 = -1; i1 <= 3; ++i1)
				{
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
					{
						int j1 = world.getBlockId(x + b0 * l, y + i1, z + b1 * l);
						boolean isAirBlock = world.isAirBlock(x + b0 * l, y + i1, z + b1 * l);
						
						if (flag)
						{
							if (j1 != MDMBlocks.heavenPortalFrame.blockID)
							{
								return false;
							}
						}
						else if (!isAirBlock && j1 != Block.waterStill.blockID)
						{
							return false;
						}
					}
				}
			}
			
			for (l = 0; l < 2; ++l)
			{
				for (i1 = 0; i1 < 3; ++i1)
				{
					world.setBlock(x + b0 * l, y + i1, z + b1 * l, this.blockID, 0, 2);
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are their own) Args: x, y, z, neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neightborBlockID)
	{
		byte b0 = 0;
		byte b1 = 1;
		
		if (world.getBlockId(x - 1, y, z) == this.blockID || world.getBlockId(x + 1, y, z) == this.blockID)
		{
			b0 = 1;
			b1 = 0;
		}
		
		int i1;
		
		for (i1 = y; world.getBlockId(x, i1 - 1, z) == this.blockID; --i1)
		{
			;
		}
		
		if (world.getBlockId(x, i1 - 1, z) != MDMBlocks.heavenPortalFrame.blockID)
		{
			world.setBlockToAir(x, y, z);
		}
		else
		{
			int j1;
			
			for (j1 = 1; j1 < 4 && world.getBlockId(x, i1 + j1, z) == this.blockID; ++j1)
			{
				;
			}
			
			if (j1 == 3 && world.getBlockId(x, i1 + j1, z) == MDMBlocks.heavenPortalFrame.blockID)
			{
				boolean flag = world.getBlockId(x - 1, y, z) == this.blockID || world.getBlockId(x + 1, y, z) == this.blockID;
				boolean flag1 = world.getBlockId(x, y, z - 1) == this.blockID || world.getBlockId(x, y, z + 1) == this.blockID;
				
				if (flag && flag1)
				{
					world.setBlockToAir(x, y, z);
				}
				else
				{
					if ((world.getBlockId(x + b0, y, z + b1) != MDMBlocks.heavenPortalFrame.blockID || world.getBlockId(x - b0, y, z - b1) != this.blockID) && (world.getBlockId(x - b0, y, z - b1) != MDMBlocks.heavenPortalFrame.blockID || world.getBlockId(x + b0, y, z + b1) != this.blockID))
					{
						world.setBlockToAir(x, y, z);
					}
				}
			}
			else
			{
				world.setBlockToAir(x, y, z);
			}
		}
	}
	
	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given coordinates. Args: blockAccess, x, y, z, side
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		if (world.getBlockId(x, y, z) == this.blockID)
		{
			return false;
		}
		else
		{
			boolean flag = world.getBlockId(x - 1, y, z) == this.blockID && world.getBlockId(x - 2, y, z) != this.blockID;
			boolean flag1 = world.getBlockId(x + 1, y, z) == this.blockID && world.getBlockId(x + 2, y, z) != this.blockID;
			boolean flag2 = world.getBlockId(x, y, z - 1) == this.blockID && world.getBlockId(x, y, z - 2) != this.blockID;
			boolean flag3 = world.getBlockId(x, y, z + 1) == this.blockID && world.getBlockId(x, y, z + 2) != this.blockID;
			boolean flag4 = flag || flag1;
			boolean flag5 = flag2 || flag3;
			return flag4 && side == 4 ? true : (flag4 && side == 5 ? true : (flag5 && side == 2 ? true : flag5 && side == 3));
		}
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random random)
	{
		return 0;
	}
	
	/**
	 * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	 */
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP)))
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
			teleportPlayer(thePlayer);
		}
	}
	
	public static void teleportPlayer(EntityPlayerMP player)
	{
		if (player.timeUntilPortal > 0)
		{
			player.timeUntilPortal = 10;
		}
		else if (player.dimension != MDMWorld.HEAVEN_ID)
		{
			player.timeUntilPortal = 10;
			player.mcServer.getConfigurationManager().transferPlayerToDimension(player, MDMWorld.HEAVEN_ID, new TeleporterHeaven(player.mcServer.worldServerForDimension(MDMWorld.HEAVEN_ID)));
		}
		else
		{
			player.timeUntilPortal = 10;
			player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterHeaven(player.mcServer.worldServerForDimension(0)));
		}
	}
	
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (random.nextInt(100) == 0)
		{
			world.playSound(x + 0.5D, y + 0.5D, z + 0.5D, "portal.portal", 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
		}
		
		for (int l = 0; l < 4; ++l)
		{
			double d0 = x + random.nextFloat();
			double d1 = y + random.nextFloat();
			double d2 = z + random.nextFloat();
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = random.nextInt(2) * 2 - 1;
			d3 = (random.nextFloat() - 0.5D) * 0.5D;
			d4 = (random.nextFloat() - 0.5D) * 0.5D;
			d5 = (random.nextFloat() - 0.5D) * 0.5D;
			
			if (world.getBlockId(x - 1, y, z) != this.blockID && world.getBlockId(x + 1, y, z) != this.blockID)
			{
				d0 = x + 0.5D + 0.25D * i1;
				d3 = random.nextFloat() * 2.0F * i1;
			}
			else
			{
				d2 = z + 0.5D + 0.25D * i1;
				d5 = random.nextFloat() * 2.0F * i1;
			}
			
			world.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
		}
	}
	
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return 0;
	}
}
