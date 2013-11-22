package clashsoft.mods.moredimensions.world.gen.heaven;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGenerator;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

public class HeavenGenTrees extends CustomTreeGenerator
{
	public HeavenGenTrees(boolean blockUpdates, int minTreeHeight, int woodMetadata, int leavesMetadata)
	{
		super(blockUpdates, minTreeHeight, MDMBlocks.heavenLogs.blockID, MDMBlocks.heavenLeaves.blockID, woodMetadata, leavesMetadata);
	}
}
