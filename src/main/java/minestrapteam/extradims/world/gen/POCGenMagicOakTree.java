package minestrapteam.extradims.world.gen;

import minestrapteam.extradims.lib.ParadiseOfChaos;
import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;

public class POCGenMagicOakTree extends CustomTreeGen
{
	public POCGenMagicOakTree(boolean flag)
	{
		super(flag, 5, ParadiseOfChaos.logBlocks, ParadiseOfChaos.leafBlocks, 0, 0);
	}
}