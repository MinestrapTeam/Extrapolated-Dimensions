package clashsoft.mods.moredimensions.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMDM extends Item
{
	public ItemMDM(int par1, CreativeTabs par2CreativeTabs)
	{
		super(par1);
		this.setCreativeTab(par2CreativeTabs);
	}
	
	@Override
	public Item setUnlocalizedName(String par1Str)
	{
		this.setTextureName(par1Str);
		return super.setUnlocalizedName(par1Str);
	}
}
