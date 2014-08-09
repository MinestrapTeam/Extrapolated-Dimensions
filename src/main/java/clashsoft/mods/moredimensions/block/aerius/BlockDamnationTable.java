package clashsoft.mods.moredimensions.block.aerius;

import java.util.Random;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.common.MDMProxy;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockDamnationTable extends BlockContainer
{
	private Random	rand	= new Random();
	
	public IIcon		topIcon;
	public IIcon		bottomIcon;
	
	public BlockDamnationTable()
	{
		super(Material.rock);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.75F, 1F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("mdm_heaven:damnation_table_side");
		this.topIcon = iconRegister.registerIcon("mdm_heaven:damnation_table_top");
		this.bottomIcon = iconRegister.registerIcon("mdm_heaven:damnation_table_bottom");
	}
	
	@Override
	public IIcon getIcon(int side, int metdata)
	{
		return side == 0 ? this.bottomIcon : (side == 1 ? this.topIcon : this.blockIcon);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldBlockMetadata)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
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
		
		super.breakBlock(world, x, y, z, oldBlock, oldBlockMetadata);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			TileEntity tileentity = world.getTileEntity(x, y, z);
			
			if (tileentity instanceof TileEntityDamnationTable)
			{
				FMLNetworkHandler.openGui(player, MoreDimensionsMod.instance, MDMProxy.DAMNATION_TABLE_GUIID, world, x, y, z);
			}
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityDamnationTable();
	}
}
