package clashsoft.mods.moredimensions.item.heaven;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHeavenPortalActivator extends Item
{
	
	public ItemHeavenPortalActivator(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	public void addInformation(ItemStack par1ItemStack, List par2List)
	{
		par2List.add((new StringBuilder()).append("Used to activate the Heaven Portal").toString());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return EnumRarity.rare;
	}
}
