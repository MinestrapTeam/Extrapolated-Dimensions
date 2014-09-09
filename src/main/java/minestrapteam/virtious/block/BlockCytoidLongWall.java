package minestrapteam.virtious.block;

import minestrapteam.virtious.Virtious;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCytoidLongWall extends VBlock
{
	private IIcon	insideIcon;
	private IIcon	upper;
	private IIcon	lower;
	
	public BlockCytoidLongWall()
	{
		super(Material.iron);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return super.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y + 1, z).isReplaceable(world, x, y + 1, z);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		if (world.getBlock(x, y + 1, z).isReplaceable(world, x, y + 1, z))
		{
			world.setBlock(x, y + 1, z, this, 1, 3);
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("virtious:cytoid_wall");
		this.insideIcon = iconRegister.registerIcon("virtious:cytoid_wall_inside");
		this.upper = iconRegister.registerIcon("virtious:cytoid_wall_upper");
		this.lower = iconRegister.registerIcon("virtious:cytoid_wall_lower");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 1)
		{
			return side == 0 ? this.insideIcon : side == 1 ? this.blockIcon : this.upper;
		}
		return side == 1 ? this.insideIcon : side == 0 ? this.blockIcon : this.lower;
	}
}
