package clashsoft.mods.moredimensions.item.poc;

import java.util.List;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import cpw.mods.fml.common.network.FMLNetworkHandler;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemTome extends Item
{
	public ItemTome(int par1)
	{
		super(par1);
	}
	
	public void updateIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("main:Tome");
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(EnumChatFormatting.ITALIC + "Holds all magical Knowledge, or so it seems.");
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		FMLNetworkHandler.openGui(par3EntityPlayer, MoreDimensionsMod.instance, MDMCommonProxy.TOME_GUIID, par2World, 0, 0, 0);
		return par1ItemStack;
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
