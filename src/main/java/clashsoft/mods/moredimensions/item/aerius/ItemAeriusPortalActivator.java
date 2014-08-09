package clashsoft.mods.moredimensions.item.aerius;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemAeriusPortalActivator extends Item
{
	public ItemAeriusPortalActivator()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(64);
	}
	
	public void addInformation(ItemStack stack, List list)
	{
		list.add(I18n.getString("item.heaven_portal_activator.desc"));
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
