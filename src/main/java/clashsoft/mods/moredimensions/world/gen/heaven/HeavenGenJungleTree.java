package clashsoft.mods.moredimensions.world.gen.heaven;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import clashsoft.mods.moredimensions.addons.Heaven;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class HeavenGenJungleTree extends CustomTreeGen
{
	public HeavenGenJungleTree(boolean blockUpdates, int minTreeHeight, Block wood, Block leaves)
	{
		super(blockUpdates, minTreeHeight, wood, leaves);
	}
	
	public HeavenGenJungleTree(boolean blockUpdates, int minTreeHeight, Block wood, Block leaves, int woodMetadata, int leavesMetadata)
	{
		super(blockUpdates, minTreeHeight, wood, leaves, woodMetadata, leavesMetadata);
	}
	
	public HeavenGenJungleTree(boolean blockUpdates, int minTreeHeight, Block wood, Block leaves, int woodMetadata, int leavesMetadata, boolean vinesGrow)
	{
		super(blockUpdates, minTreeHeight, wood, leaves, woodMetadata, leavesMetadata, vinesGrow);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int treeHeight = random.nextInt(3) + this.minTreeHeight;
		
		Block soil = world.getBlock(x, y - 1, z);
		
		if (soil == Heaven.heavenDirtBlocks || soil == Heaven.heavenGrassBlocks || soil == Blocks.grass || soil == Blocks.dirt)
		{
			if (y > 0 && y + treeHeight < 256)
			{
				for (int i = 0; i < treeHeight; i++)
				{
					this.setBlockAndNotifyAdequately(world, x, y + i, z, this.logBlock, this.logMetadata);
					
					if (i > 2)
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
				int y1 = y + treeHeight;
				
				for (int i = x - 2; i <= x + 2; i++)
				{
					for (int j = y1; j <= y1 + 3; j++)
					{
						for (int k = z - 2; k <= z + 2; k++)
						{
							Block block = world.getBlock(i, j, k);
							if (block != this.logBlock && (block == null || block.canBeReplacedByLeaves(world, i, j, k)))
							{
								this.setBlockAndNotifyAdequately(world, i, j, k, this.leafBlock, this.leafMetadata);
							}
						}
					}
				}
			}
		}
		return true;
	}
}
