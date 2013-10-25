package com.chaosdev.paradiseofchaos.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemRedstonePickaxe extends ItemPickaxe
{
	public ItemRedstonePickaxe(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
	}
	
	public void updateIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("main:RedstonePickaxe");
	}
}
