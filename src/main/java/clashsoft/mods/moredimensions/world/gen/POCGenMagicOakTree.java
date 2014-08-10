package clashsoft.mods.moredimensions.world.gen;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import clashsoft.mods.moredimensions.lib.ParadiseOfChaos;

public class POCGenMagicOakTree extends CustomTreeGen
{
	public POCGenMagicOakTree(boolean flag)
	{
		super(flag, 5, ParadiseOfChaos.logBlocks, ParadiseOfChaos.leafBlocks, 0, 0);
	}
}