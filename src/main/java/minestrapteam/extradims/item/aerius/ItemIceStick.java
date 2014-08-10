package minestrapteam.extradims.item.aerius;

import minestrapteam.extradims.api.curse.ICurseIngredient;
import minestrapteam.extradims.curse.Curse;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemIceStick extends Item implements ICurseIngredient
{
	public ItemIceStick()
	{
		super();
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote)
		{
			return stack;
		}
		
		MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
		
		if (mop == null)
		{
			return stack;
		}
		else
		{
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
	}
	
	@Override
	public boolean isCurseIngredient(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public Curse getCurse(ItemStack stack)
	{
		return Curse.test;
	}
	
}
