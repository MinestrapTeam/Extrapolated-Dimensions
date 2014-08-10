package minestrapteam.extradims.item.alchemy;

import java.util.List;

import clashsoft.brewingapi.item.ItemGlassBottle2;
import minestrapteam.extradims.lib.Alchemy;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemElixirBottle extends ItemGlassBottle2
{
	public ItemElixirBottle()
	{
		super();
		this.setCreativeTab(Alchemy.tabAlchemy);
		this.setHasSubtypes(true);
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return Alchemy.elixir.bottles[metadata];
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		Alchemy.elixir.addInformation(new ItemStack(this, 1, stack.getItemDamage() * 4), player, list, flag);
	}
	
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
			if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK)
			{
				int x = movingobjectposition.blockX;
				int y = movingobjectposition.blockY;
				int z = movingobjectposition.blockZ;
				
				if (!world.canMineBlock(player, x, y, z))
				{
					return stack;
				}
				
				if (!player.canPlayerEdit(x, y, z, movingobjectposition.sideHit, stack))
				{
					return stack;
				}
				
				if (world.getBlock(x, y, z).getMaterial() == Material.water)
				{
					--stack.stackSize;
					
					int damage = stack.getItemDamage() * 4;
					
					if (stack.stackSize <= 0)
					{
						return new ItemStack(Alchemy.elixir, 1, damage);
					}
					
					if (!player.inventory.addItemStackToInventory(new ItemStack(Alchemy.elixir, 1, damage)))
					{
						player.dropPlayerItemWithRandomChoice(new ItemStack(Alchemy.elixir, 1, damage), false);
					}
				}
			}
			
			return stack;
		}
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < ItemElixir.BOTTLE_TYPES; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
}
