package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.api.ICurseIngredient;
import clashsoft.mods.moredimensions.curse.Curse;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemIceStick extends Item implements ICurseIngredient
{
	public ItemIceStick(int itemID)
	{
		super(itemID);
		this.setMaxDamage(64);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote)
			return stack;
		
		MovingObjectPosition var4 = this.getMovingObjectPositionFromPlayer(world, player, true);
		
		if (var4 == null)
		{
			return stack;
		}
		else
		{
			if (var4.typeOfHit == EnumMovingObjectType.TILE)
			{
				int var5 = var4.blockX;
				int var6 = var4.blockY;
				int var7 = var4.blockZ;
				
				if (!world.canMineBlock(player, var5, var6, var7))
				{
					return stack;
				}
				
				if (world.getBlockMaterial(var5, var6, var7) == Material.water && world.getBlockMetadata(var5, var6, var7) == 0)
				{
					world.setBlock(var5, var6, var7, Block.ice.blockID);
					
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
