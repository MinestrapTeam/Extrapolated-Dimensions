package clashsoft.mods.moredimensions.block.aerius;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCloud extends Block
{
	public static int[]	colors	= { 0xFFFFFF, 0x808080, 0x80BFFF, 0x70DF70, 0xFF8080, 0xFFFF80 };
	
	public BlockCloud(Material material)
	{
		super(material);
	}
	
	@Override
	public int getRenderColor(int metadata)
	{
		return colors[metadata];
	}
	
	@Override
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		return this.getRenderColor(world.getBlockMetadata(x, y, z));
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		entity.fallDistance = 0F;
		if (metadata == 0)
		{
			entity.motionY *= 0.05D;
		}
		else if (metadata == 1)
		{
			if (entity.motionY < 0D)
			{
				entity.motionY = -entity.motionY;
			}
			entity.motionY *= 2D;
		}
		else if (metadata == 2)
		{
			entity.motionX *= 2D;
			entity.motionZ *= 2D;
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 0)
		{
			return AxisAlignedBB.getBoundingBox(x, y, z, x + 1D, y, z + 1D);
		}
		else
		{
			return AxisAlignedBB.getBoundingBox(x, y, z, x, y, z);
		}
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < colors.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
