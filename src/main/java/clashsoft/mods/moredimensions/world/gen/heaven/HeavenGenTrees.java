package clashsoft.mods.moredimensions.world.gen.heaven;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import clashsoft.mods.moredimensions.lib.Heaven;

public class HeavenGenTrees extends CustomTreeGen
{
	public HeavenGenTrees(boolean blockUpdates, int minTreeHeight, int metaWood, int metaLeaves)
	{
		super(blockUpdates, minTreeHeight, Heaven.logBlocks, Heaven.leafBlocks, metaWood, metaLeaves);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		Block soil = world.getBlock(x, y - 1, z);
		
		if (soil == Heaven.dirtBlocks || soil == Heaven.grassBlocks || soil == Blocks.grass || soil == Blocks.dirt)
		{
			return super.generate(world, random, x, y, z);
		}
		return false;
	}
}
