package minestrapteam.virtious.block;

import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFuelCell extends VBlock
{
	private IIcon	topIcon;
	private IIcon	bottomIcon;
	
	public BlockFuelCell(Material material)
	{
		super(material);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return false;
		}
		
		ItemStack stack = player.getHeldItem();
		if (stack != null && stack.getItem() == Items.blaze_powder)
		{
			Block block = world.getBlock(x, y + 1, z);
			if (block == VBlocks.virtious_portal || !block.isReplaceable(world, x, y + 1, z))
			{
				return false;
			}
			
			for (int x1 = -1; x1 <= 1; x1++)
			{
				for (int z1 = -1; z1 <= 1; z1++)
				{
					if (world.getBlock(x + x1, y - 1, z + z1) != Blocks.iron_block)
					{
						return false;
					}
				}
			}
			
			if (!player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}
			
			world.setBlock(x, y + 1, z, VBlocks.virtious_portal);
			return true;
		}
		return false;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("virtious:fuel_block_side");
		this.topIcon = iconRegister.registerIcon("virtious:fuel_block_top");
		this.bottomIcon = iconRegister.registerIcon("virtious:fuel_block_bottom");
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (side == 1)
		{
			return this.topIcon;
		}
		if (side == 0)
		{
			return this.bottomIcon;
		}
		return this.blockIcon;
	}
}
