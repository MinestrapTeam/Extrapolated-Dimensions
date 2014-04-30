package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.addons.Alchemy;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemIceHammer extends ItemIceStick
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
