package clashsoft.mods.moredimensions.world.gen.poc;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGenerator;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

public class POCGenMagicOakTree extends CustomTreeGenerator
{
	public POCGenMagicOakTree(boolean flag)
	{
		super(flag, 5, MDMBlocks.pocLogs.blockID, MDMBlocks.pocLeaves.blockID, 0, 0);
	}
}