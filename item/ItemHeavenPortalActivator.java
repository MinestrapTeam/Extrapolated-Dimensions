package clashsoft.mods.moredimensions.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;

import cpw.mods.fml.relauncher.*;

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
