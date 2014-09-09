package minestrapteam.virtious.block;

import minestrapteam.virtious.Virtious;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCytoidControlPanel extends Block
{
	private IIcon	frontIconOn;
	private IIcon	frontIconOff;
	
	public BlockCytoidControlPanel()
	{
		super(Material.iron);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.getBlockMetadata(x, y, z) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 3);
		}
		else
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 3);
		}
		return true;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("virtious:cytoid_wall");
		this.frontIconOn = iconRegister.registerIcon("virtious:cytoid_control_panel_on");
		this.frontIconOff = iconRegister.registerIcon("virtious:cytoid_control_panel_off");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return side == 0 || side == 1 ? this.blockIcon : metadata == 0 ? this.frontIconOff : this.frontIconOn;
	}
}
