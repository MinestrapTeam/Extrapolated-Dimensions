package clashsoft.mods.moredimensions.world.gen.heaven;

import java.util.Random;

import clashsoft.clashsoftapi.world.gen.CustomTreeGenerator;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class HeavenGenJungleTree extends CustomTreeGenerator
{
	public HeavenGenJungleTree(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID)
	{
		super(blockUpdates, minTreeHeight, woodID, leavesID);
	}
	
	public HeavenGenJungleTree(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID, int woodMetadata, int leavesMetadata)
	{
		super(blockUpdates, minTreeHeight, woodID, leavesID, woodMetadata, leavesMetadata);
	}
	
	public HeavenGenJungleTree(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID, int woodMetadata, int leavesMetadata, boolean vinesGrow)
	{
		super(blockUpdates, minTreeHeight, woodID, leavesID, woodMetadata, leavesMetadata, vinesGrow);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int treeHeight = random.nextInt(3) + this.minTreeHeight;
		boolean flag = true;
		
		int floor = world.getBlockId(x, y - 1, z);
		
		if (floor == MDMBlocks.heavenDirtBlocks.blockID || floor == MDMBlocks.heavenGrassBlocks.blockID || floor == Block.grass.blockID || floor == Block.dirt.blockID)
		{
			if (y > 0 && y + treeHeight < 256)
			{
				for (int i = 0; i < treeHeight; i++)
				{
					this.setBlockAndMetadata(world, x, y + i, z, this.woodId, this.metaWood);
					
					if (i > 2)
					{
						int randInt = random.nextInt(5);
						if (randInt < 4)
						{
							int meta = this.metaWood | ((randInt == 0 || randInt == 1) ? 8 : 4);
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
							
							this.setBlockAndMetadata(world, x + xOff, y + i, z + zOff, this.woodId, meta);
							this.setBlockAndMetadata(world, x + 2 * xOff, y + i, z + 2 * zOff, this.leavesId, this.metaLeaves);
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
							int blockID = world.getBlockId(i, j, k);
							if (blockID != this.woodId && (Block.blocksList[blockID] == null || Block.blocksList[blockID].canBeReplacedByLeaves(world, i, j, k)))
								this.setBlockAndMetadata(world, i, j, k, this.leavesId, this.metaLeaves);
						}
					}
				}
			}
		}
		return true;
	}
}
