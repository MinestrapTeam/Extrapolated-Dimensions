package minestrapteam.extradims.item.aerius;

import clashsoft.cslib.minecraft.item.CustomItem;
import minestrapteam.extradims.api.curse.ICurseIngredient;
import minestrapteam.extradims.curse.Curse;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemAeriusSticks extends CustomItem implements ICurseIngredient
{
	public ItemAeriusSticks(String[] names, String[] iconNames)
	{
		super(names, iconNames, null);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote)
		{
			return stack;
		}
		
		if (stack.getItemDamage() != 4)
		{
			return stack;
		}
		
		return tryFreeze(this.getMovingObjectPositionFromPlayer(world, player, true), stack, world, player);
	}
	
	public static ItemStack tryFreeze(MovingObjectPosition mop, ItemStack stack, World world, EntityPlayer player)
	{
		if (mop == null)
		{
			return stack;
		}
		
		if (mop.typeOfHit == MovingObjectType.BLOCK)
		{
			int x = mop.blockX;
			int y = mop.blockY;
			int z = mop.blockZ;
			
			if (!world.canMineBlock(player, x, y, z))
			{
				return stack;
			}
			
			if (world.getBlock(x, y, z).getMaterial() == Material.water && world.getBlockMetadata(x, y, z) == 0)
			{
				world.setBlock(x, y, z, Blocks.ice);
				
				if (!player.capabilities.isCreativeMode)
				{
					stack.damageItem(1, player);
				}
			}
		}
		
		return stack;
	}
	
	@Override
	public boolean isCurseIngredient(ItemStack stack)
	{
		return stack.getItemDamage() == 4;
	}
	
	@Override
	public Curse getCurse(ItemStack stack)
	{
		return Curse.test;
	}
}
