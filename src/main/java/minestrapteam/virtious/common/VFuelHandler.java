package minestrapteam.virtious.common;

import minestrapteam.virtious.lib.VItems;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.IFuelHandler;

public class VFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == VItems.tak)
		{
			return 2400;
		}
		return 0;
	}
}
