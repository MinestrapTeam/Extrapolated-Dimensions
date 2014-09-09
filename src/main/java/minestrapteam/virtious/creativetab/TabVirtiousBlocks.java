package minestrapteam.virtious.creativetab;

import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabVirtiousBlocks extends CreativeTabs
{
	public TabVirtiousBlocks(int id, String name)
	{
		super(id, name);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(VBlocks.virtian_grass);
	}
}
