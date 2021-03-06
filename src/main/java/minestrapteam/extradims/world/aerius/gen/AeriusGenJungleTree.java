package minestrapteam.extradims.world.aerius.gen;

import minestrapteam.extracore.world.gen.CustomTreeGen;
import minestrapteam.extradims.lib.aerius.ABlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class AeriusGenJungleTree extends CustomTreeGen
{
	public int radius = 3;

	public static AeriusGenJungleTree create(boolean blockUpdates, int minTreeHeight, int type)
	{
		final int metadata = type % 4;
		if (type >= 4)
		{
			return new AeriusGenJungleTree(blockUpdates, minTreeHeight, ABlocks.logBlocks2, ABlocks.leafBlocks2, metadata,
			                               metadata);
		}
		return new AeriusGenJungleTree(blockUpdates, minTreeHeight, ABlocks.logBlocks, ABlocks.leafBlocks, metadata, metadata);
	}

	public AeriusGenJungleTree(boolean blockUpdates, int minTreeHeight, Block log, Block leaf, int woodMetadata, int leavesMetadata)
	{
		super(blockUpdates, minTreeHeight, log, leaf, woodMetadata, leavesMetadata);
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		Block soil = world.getBlock(x, y - 1, z);
		
		if (soil != ABlocks.dirtBlocks && soil != ABlocks.grassBlocks && soil != Blocks.grass && soil != Blocks.dirt)
		{
			return false;
		}
		
		int treeHeight = random.nextInt(3) + this.minTreeHeight;
		if (y <= 0 || y + treeHeight >= 256)
		{
			return false;
		}
		
		for (int i = 0; i < treeHeight + 2; i++)
		{
			this.setBlockAndNotifyAdequately(world, x, y + i, z, this.logBlock, this.logMetadata);
			
			if (i > 2 && (i & 1) == 0)
			{
				int randInt = random.nextInt(5);
				if (randInt < 4)
				{
					int meta = this.logMetadata | ((randInt == 0 || randInt == 1) ? 8 : 4);
					int xOff = 0;
					int zOff = 0;
					
					if (randInt == 0)
						zOff = -1;
					else if (randInt == 1)
						zOff = 1;
					else if (randInt == 2)
						xOff = -1;
					else if (randInt == 3)
						xOff = 1;
					
					this.setBlockAndNotifyAdequately(world, x + xOff, y + i, z + zOff, this.logBlock, meta);
					this.setBlockAndNotifyAdequately(world, x + 2 * xOff, y + i, z + 2 * zOff, this.leafBlock, this.leafMetadata);
				}
			}
		}
		y += treeHeight;
		
		int radius = this.radius;
		int sqradius = radius * radius;
		for (int i = -radius; i <= radius; i++)
		{
			for (int j = -radius; j <= radius; j++)
			{
				for (int k = -radius; k <= radius; k++)
				{
					if (i * i + j * j + k * k > sqradius + random.nextInt(3) - 1)
					{
						continue;
					}
					
					int x1 = x + i;
					int y1 = y + j;
					int z1 = z + k;
					
					Block block = world.getBlock(x1, y1, z1);
					if (block != this.logBlock && (block == null || block.canBeReplacedByLeaves(world, x1, y1, z1)))
					{
						this.setBlockAndNotifyAdequately(world, x1, y1, z1, this.leafBlock, this.leafMetadata);
					}
				}
			}
		}
		
		return true;
	}
}
