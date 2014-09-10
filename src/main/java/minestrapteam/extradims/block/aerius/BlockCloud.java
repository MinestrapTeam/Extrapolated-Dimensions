package minestrapteam.extradims.block.aerius;

import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.cslib.minecraft.block.ICustomBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCloud extends Block implements ICustomBlock
{
	public static String[]	names	= { "white", "black", "purple", "blue", "green", "yellow", "gold", "orange", "red" };
	public static int[]		colors	= { -1, -1, -1, -1, 0x70DF70, 0xFFFF80, -1, 0xFF8000, -1 };
	
	private IIcon[]			topIcons;
	private IIcon[]			sideIcons;
	
	public BlockCloud(Material material)
	{
		super(material);
		this.setHardness(0.1F);
		this.setStepSound(Block.soundTypeCloth);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcons = new IIcon[names.length];
		this.sideIcons = new IIcon[names.length];
		
		for (int i = 0; i < names.length; i++)
		{
			String s = this.textureName + "_" + names[i];
			if (i == 4 || i == 5 || i == 7)
			{
				this.topIcons[i] = this.topIcons[0];
				this.sideIcons[i] = this.sideIcons[0];
			}
			else
			{
				this.topIcons[i] = iconRegister.registerIcon(s + "_top");
				this.sideIcons[i] = iconRegister.registerIcon(s + "_side");
			}
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return side == 0 || side == 1 ? this.topIcons[metadata] : this.sideIcons[metadata];
	}
	
	@Override
	public int getRenderColor(int metadata)
	{
		int i = colors[metadata];
		return i == -1 ? 0xFFFFFF : i;
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
			// White clouds stop fall damage
			if (entity.motionY < 0)
			{
				entity.motionY *= 0.05D;
			}
		}
		else if (metadata == 3)
		{
			// Blue clouds launch entities in the air
			if (!entity.isSneaking())
			{
				if (entity.motionY <= -5D)
				{
					world.func_147480_a(x, y, z, true);
					return;
				}
				
				if (entity.motionY < 0D)
				{
					entity.motionY = -entity.motionY;
				}
				entity.motionY *= 2D;
			}
		}
		else if (metadata == 4)
		{
			// Green Clouds speed entities up
			entity.motionX *= 2D;
			entity.motionZ *= 2D;
		}
		else if (metadata == 8)
		{
			// Red Clouds damage entities
			entity.attackEntityFrom(new DamageSource("cloud"), 1F);
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 0 || metadata == 1)
		{
			return AxisAlignedBB.getBoundingBox(x, y, z, x + 1D, y + 0.0625D, z + 1D);
		}
		return null;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return CustomBlock.getUnlocalizedName(this, stack, names);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
		CustomBlock.addInformation(this, stack, list);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < colors.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public int getRandomType(Random random)
	{
		int i = random.nextInt(12);
		if (i < 6)
		{
			return i;
		}
		return 0;
	}
}
