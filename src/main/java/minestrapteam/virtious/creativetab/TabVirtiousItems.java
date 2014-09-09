package minestrapteam.virtious.creativetab;

import minestrapteam.virtious.lib.VItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabVirtiousItems extends CreativeTabs
{
	public TabVirtiousItems(int id, String name)
	{
		super(id, name);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return VItems.pluthorium_gem;
	}
}
