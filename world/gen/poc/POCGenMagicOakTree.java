package clashsoft.mods.moredimensions.world.gen.poc;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.MDMGenTrees;

public class POCGenMagicOakTree extends MDMGenTrees
{
	public POCGenMagicOakTree(boolean par1)
	{
		super(par1, 5, MDMBlocks.pocLogs.blockID, MDMBlocks.pocLeaves.blockID, 0, 0);
	}
}