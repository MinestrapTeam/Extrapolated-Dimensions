package minestrapteam.extradims.common;

import minestrapteam.extradims.lib.virtious.VItems;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.IFuelHandler;

public class EDFuelHandler implements IFuelHandler
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
