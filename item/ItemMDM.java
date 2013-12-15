package clashsoft.mods.moredimensions.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Deprecated
public class ItemMDM extends Item
{
	public ItemMDM(int itemID, CreativeTabs creativeTab)
	{
		super(itemID);
		this.setCreativeTab(creativeTab);
	}
}
