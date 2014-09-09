package minestrapteam.virtious.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import clashsoft.cslib.minecraft.common.BaseProxy;

public class VCommonProxy extends BaseProxy
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}
