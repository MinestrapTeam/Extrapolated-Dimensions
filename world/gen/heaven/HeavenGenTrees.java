package clashsoft.mods.moredimensions.world.gen.heaven;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

public class HeavenGenTrees extends CustomTreeGen
{
	public HeavenGenTrees(boolean blockUpdates, int minTreeHeight, int metaWood, int metaLeaves)
	{
		super(blockUpdates, minTreeHeight, MDMBlocks.heavenLogs, MDMBlocks.heavenLeaves, metaWood, metaLeaves);
	}
}
