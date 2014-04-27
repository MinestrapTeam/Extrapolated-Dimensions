package clashsoft.mods.moredimensions.item.heaven;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHeavenPortalActivator extends Item
{
	public ItemHeavenPortalActivator()
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
