package clashsoft.mods.moredimensions.world.gen.heaven;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.MDMGenTrees;

public class HeavenGenTrees extends MDMGenTrees
{
	public HeavenGenTrees(boolean blockUpdates, int minTreeHeight, int woodMetadata, int leavesMetadata)
	{
		super(blockUpdates, minTreeHeight, MDMBlocks.heavenLogs.blockID, MDMBlocks.heavenLeaves.blockID, woodMetadata, leavesMetadata);
	}
}
