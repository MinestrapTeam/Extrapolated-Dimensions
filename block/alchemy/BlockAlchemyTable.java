package clashsoft.mods.moredimensions.block.alchemy;

import java.util.Random;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTable;
import cpw.mods.fml.common.network.FMLNetworkHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAlchemyTable extends BlockContainer
{
	private Random	rand	= new Random();
	
	public BlockAlchemyTable(int blockID)
	{
		super(blockID, Material.rock);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int oldBlockID, int oldBlockMetadata)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if (tileEntity instanceof IInventory)
		{
			IInventory iinventory = (IInventory) tileEntity;
			
			for (int i = 0; i < iinventory.getSizeInventory(); ++i)
			{
				ItemStack stack = iinventory.getStackInSlot(i);
				
				if (stack != null)
				{
					float offsX = this.rand.nextFloat() * 0.8F + 0.1F;
					float offsY = this.rand.nextFloat() * 0.8F + 0.1F;
					float offsZ = this.rand.nextFloat() * 0.8F + 0.1F;
					
					while (stack.stackSize > 0)
					{
						int j = this.rand.nextInt(21) + 10;
						
						if (j > stack.stackSize)
						{
							j = stack.stackSize;
						}
						stack.stackSize -= j;
						ItemStack newStack = stack.copy();
						newStack.stackSize = j;
						
						EntityItem entityItem = new EntityItem(world, x + offsX, y + offsY, z + offsZ, newStack);
						entityItem.motionX = (float) this.rand.nextGaussian() * 0.05F;
						entityItem.motionY = (float) this.rand.nextGaussian() * 0.05F + 0.2F;
						entityItem.motionZ = (float) this.rand.nextGaussian() * 0.05F;
						world.spawnEntityInWorld(entityItem);
					}
				}
			}
		}
		
		super.breakBlock(world, x, y, z, oldBlockID, oldBlockMetadata);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			TileEntity tileentity = world.getBlockTileEntity(x, y, z);
			
			if (tileentity instanceof TileEntityAlchemyTable)
			{
				FMLNetworkHandler.openGui(player, MoreDimensionsMod.instance, MDMCommonProxy.ALCHEMY_TABLE_GUIID, world, x, y, z);
			}
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityAlchemyTable();
	}
}
