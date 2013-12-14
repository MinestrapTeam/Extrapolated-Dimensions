package clashsoft.mods.moredimensions.block;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;
import cpw.mods.fml.common.network.FMLNetworkHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDamnationTable extends BlockContainer
{
	public BlockDamnationTable(int par1)
	{
		super(par1, Material.rock);
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			TileEntity tileentity = world.getBlockTileEntity(x, y, z);
			
			if (tileentity instanceof TileEntityDamnationTable)
			{
				FMLNetworkHandler.openGui(player, MoreDimensionsMod.instance, MDMCommonProxy.DAMNATIONTABLE_GUIID, world, x, y, z);
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityDamnationTable();
	}
}
