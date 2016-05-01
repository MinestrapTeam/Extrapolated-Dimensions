package minestrapteam.extradims.item.aerius;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIceHammer extends Item
{
	public ItemIceHammer()
	{
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(256);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attacker, EntityLivingBase living)
	{
		stack.damageItem(1, living);
		attacker.knockBack(attacker, 3, 0, 0);
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote)
		{
			return stack;
		}
		return ItemAeriusLoot.tryFreeze(this.getMovingObjectPositionFromPlayer(world, player, true), stack, world);
	}
	
	@Override
	public boolean isFull3D()
	{
		return true;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 72000;
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.web;
	}
	
	@Override
	public int getItemEnchantability()
	{
		return 15;
	}
}
