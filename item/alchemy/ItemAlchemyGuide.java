package clashsoft.mods.moredimensions.item.alchemy;

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
	public ItemAlchemyGuide(int itemID)
	{
		super(itemID);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(I18n.getString("alchemyguide.description"));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		FMLNetworkHandler.openGui(player, MoreDimensionsMod.instance, MDMCommonProxy.TOME_GUIID, world, 0, 0, 0);
		return stack;
	}
}
