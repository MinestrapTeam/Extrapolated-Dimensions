package clashsoft.mods.moredimensions.item;

import java.util.List;

import clashsoft.brewingapi.item.ItemGlassBottle2;
import clashsoft.mods.moredimensions.addons.MDMItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemElixirBottle extends ItemGlassBottle2
{
	public ItemElixirBottle(int par1)
	{
		super(par1);
		this.setCreativeTab(MDMItems.AlchemyTab);
		this.setHasSubtypes(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Gets an icon index based on an item's damage value
	 */
	public Icon getIconFromDamage(int par1)
	{
		return MDMItems.Elixir.bottles[par1];
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		MDMItems.Elixir.addInformation(new ItemStack(this, 1, par1ItemStack.getItemDamage() * 4), par2EntityPlayer, par3List, par4);
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);
		
		if (movingobjectposition == null)
		{
			return par1ItemStack;
		}
		else
		{
			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;
				
				if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
				{
					return par1ItemStack;
				}
				
				if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
				{
					return par1ItemStack;
				}
				
				if (par2World.getBlockMaterial(i, j, k) == Material.water)
				{
					--par1ItemStack.stackSize;
					
					int damage = par1ItemStack.getItemDamage() * 4;
					
					if (par1ItemStack.stackSize <= 0)
					{
						return new ItemStack(MDMItems.Elixir, 1, damage);
					}
					
					if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MDMItems.Elixir, 1, damage)))
					{
						par3EntityPlayer.dropPlayerItem(new ItemStack(MDMItems.Elixir, 1, damage));
					}
				}
			}
			
			return par1ItemStack;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < ItemElixir.BOTTLE_TYPES; i++)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
	}
}
