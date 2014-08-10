package minestrapteam.extradims.world.gen;

import java.util.Random;

import minestrapteam.extradims.lib.Aerius;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;

public class AeriusGenTrees extends CustomTreeGen
{
	public AeriusGenTrees(boolean blockUpdates, int minTreeHeight, int metaWood, int metaLeaves)
	{
		super(blockUpdates, minTreeHeight, Aerius.logBlocks, Aerius.leafBlocks, metaWood, metaLeaves);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		Block soil = world.getBlock(x, y - 1, z);
		
		if (soil == Aerius.dirtBlocks || soil == Aerius.grassBlocks || soil == Blocks.grass || soil == Blocks.dirt)
		{
			return super.generate(world, random, x, y, z);
		}
		return false;
	}
}
