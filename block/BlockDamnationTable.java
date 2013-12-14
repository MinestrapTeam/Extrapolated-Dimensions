package clashsoft.mods.moredimensions.block;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;
import cpw.mods.fml.common.network.FMLNetworkHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockDamnationTable extends BlockContainer
{
	public Icon	topIcon;
	public Icon	bottomIcon;
	
	public BlockDamnationTable(int blockID)
	{
		super(blockID, Material.rock);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.75F, 1F);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("damnation_table_side");
		this.topIcon = iconRegister.registerIcon("damnation_table_top");
		this.bottomIcon = iconRegister.registerIcon("damnation_table_bottom");
	}
	
	@Override
	public Icon getIcon(int side, int metdata)
	{
		return side == 0 ? this.bottomIcon : (side == 1 ? this.topIcon : this.blockIcon);
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
				FMLNetworkHandler.openGui(player, MoreDimensionsMod.instance, MDMCommonProxy.DAMNATION_TABLE_GUIID, world, x, y, z);
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
