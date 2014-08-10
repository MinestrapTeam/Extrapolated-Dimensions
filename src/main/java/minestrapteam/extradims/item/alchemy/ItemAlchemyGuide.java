package minestrapteam.extradims.item.alchemy;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import minestrapteam.extradims.ExtraDimensions;
import minestrapteam.extradims.common.EDProxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAlchemyGuide extends Item
{
	public ItemAlchemyGuide()
	{
		super();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(I18n.getString("item.alchemy_guide.desc"));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		FMLNetworkHandler.openGui(player, ExtraDimensions.instance, EDProxy.TOME_GUIID, world, 0, 0, 0);
		return stack;
	}
}
