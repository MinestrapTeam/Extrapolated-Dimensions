package clashsoft.mods.moredimensions.item.alchemy;

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
	public ItemElixirBottle(int itemID)
	{
		super(itemID);
		this.setCreativeTab(MDMItems.tabAlchemy);
		this.setHasSubtypes(true);
	}
	
	/**
	 * Gets an icon index based on an item's damage value
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int metadata)
	{
		return MDMItems.elixir.bottles[metadata];
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		MDMItems.elixir.addInformation(new ItemStack(this, 1, stack.getItemDamage() * 4), player, list, flag);
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);
		
		if (movingobjectposition == null)
		{
			return stack;
		}
		else
		{
			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;
				
				if (!world.canMineBlock(player, i, j, k))
				{
					return stack;
				}
				
				if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack))
				{
					return stack;
				}
				
				if (world.getBlockMaterial(i, j, k) == Material.water)
				{
					--stack.stackSize;
					
					int damage = stack.getItemDamage() * 4;
					
					if (stack.stackSize <= 0)
					{
						return new ItemStack(MDMItems.elixir, 1, damage);
					}
					
					if (!player.inventory.addItemStackToInventory(new ItemStack(MDMItems.elixir, 1, damage)))
					{
						player.dropPlayerItem(new ItemStack(MDMItems.elixir, 1, damage));
					}
				}
			}
			
			return stack;
		}
	}
	
	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < ItemElixir.BOTTLE_TYPES; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
}
