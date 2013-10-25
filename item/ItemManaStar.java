package com.chaosdev.paradiseofchaos.item;

import com.chaosdev.paradiseofchaos.lib.POCEntityProperties;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemManaStar extends Item
{
	public ItemManaStar(int par1)
	{
		super(par1);
		this.setMaxStackSize(16);
		this.setTextureName("manastar");
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		POCEntityProperties.getEntityProperties(par3EntityPlayer).addMana(2.5F);
		if (!par3EntityPlayer.capabilities.isCreativeMode)
			par1ItemStack.stackSize--;
		return par1ItemStack;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	/**
	 * CLASHSOFT: This code makes items use their unlocalized name as icon name
	 */
	@Override
	public Item setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}
