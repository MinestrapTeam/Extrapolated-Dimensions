package clashsoft.mods.moredimensions.world.gen.poc;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

public class POCGenMagicOakTree extends CustomTreeGen
{
	public POCGenMagicOakTree(boolean flag)
	{
		super(flag, 5, MDMBlocks.pocLogs, MDMBlocks.pocLeaves, 0, 0);
	}
}