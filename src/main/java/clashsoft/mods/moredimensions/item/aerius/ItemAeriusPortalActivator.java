package clashsoft.mods.moredimensions.item.aerius;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.mods.moredimensions.lib.Aerius;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAeriusPortalActivator extends Item
{
	public ItemAeriusPortalActivator()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(64);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			if (Aerius.portal.generatePortal(world, x, y + 1, z))
			{
				return true;				
			}
		}
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(I18n.getString("item.aerius_portal_activator.desc"));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.rare;
	}
}
