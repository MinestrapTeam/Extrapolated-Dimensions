package clashsoft.mods.moredimensions.item.poc;

import java.util.List;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import cpw.mods.fml.common.network.FMLNetworkHandler;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAlchemyGuide extends Item
{
	public ItemAlchemyGuide(int par1)
	{
		super(par1);
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(I18n.getString("alchemyguide.description"));
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
