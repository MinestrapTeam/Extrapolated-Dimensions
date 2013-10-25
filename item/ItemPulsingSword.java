package clashsoft.mods.moredimensions.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemPulsingSword extends ItemSword
{
	public ItemPulsingSword(int par1)
	{
		super(par1, EnumToolMaterial.STONE);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
}
