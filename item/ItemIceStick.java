package clashsoft.mods.moredimensions.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemIceStick extends Item
{
	
	public ItemIceStick(int par1)
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxDamage(64);
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		MovingObjectPosition var4 = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);
		
		if (var4 == null)
		{
			return par1ItemStack;
		}
		else
		{
			if (var4.typeOfHit == EnumMovingObjectType.TILE)
			{
				int var5 = var4.blockX;
				int var6 = var4.blockY;
				int var7 = var4.blockZ;
				
				if (!par2World.canMineBlock(par3EntityPlayer, var5, var6, var7))
				{
					return par1ItemStack;
				}
				
				if (par2World.getBlockMaterial(var5, var6, var7) == Material.water && par2World.getBlockMetadata(var5, var6, var7) == 0)
				{
					par2World.setBlock(var5, var6, var7, Block.ice.blockID);
					
					if (!par3EntityPlayer.capabilities.isCreativeMode)
					{
						par1ItemStack.damageItem(1, par3EntityPlayer);
					}
				}
			}
			
			return par1ItemStack;
		}
	}
	
}
