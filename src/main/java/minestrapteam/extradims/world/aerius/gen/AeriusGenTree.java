package minestrapteam.extradims.world.aerius.gen;

import minestrapteam.extracore.world.gen.CustomTreeGen;
import minestrapteam.extradims.lib.aerius.ABlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class AeriusGenTree extends CustomTreeGen
{
	public static AeriusGenTree create(boolean blockUpdates, int minTreeHeight, int type)
	{
		final int metadata = type % 4;
		if (type >= 4)
		{
			return new AeriusGenTree(blockUpdates, minTreeHeight, ABlocks.logBlocks2, ABlocks.leafBlocks2, metadata,
			                         metadata);
		}
		return new AeriusGenTree(blockUpdates, minTreeHeight, ABlocks.logBlocks, ABlocks.leafBlocks, metadata, metadata);
	}

	private AeriusGenTree(boolean blockUpdates, int minTreeHeight, Block log, Block leaf, int woodMetadata, int leavesMetadata)
	{
		super(blockUpdates, minTreeHeight, log, leaf, woodMetadata, leavesMetadata);
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		Block soil = world.getBlock(x, y - 1, z);

		return (soil == ABlocks.dirtBlocks || soil == ABlocks.grassBlocks || soil == Blocks.grass || soil == Blocks.dirt)
			       && super.generate(world, random, x, y, z);
	}
}
