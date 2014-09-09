package minestrapteam.virtious.world.gen;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.world.World;

public class VirtiousGenAmberTree extends CustomTreeGen
{
	public VirtiousGenAmberTree(boolean update)
	{
		super(update, 8, VBlocks.virtious_logs, VBlocks.virtious_leaves, 1, 1);
	}
	
	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		int leavesHeight = (random.nextInt(2) + 3) * 2;
		int trunk = random.nextInt(2) + 2;
		int radius = Math.round(leavesHeight / 2);
		int center = trunk + radius;
		int radius2 = radius * radius;
		
		int treeHeight = trunk + leavesHeight;
		
		int cycleCount = random.nextInt();
		
		for (int y1 = 0; y1 < treeHeight; y1++)
		{
			this.setBlock(world, i, j + y1, k, this.logBlock, this.logMetadata);
			
			
			int y2 = (center - y1) * (center - y1);
			
			if (y1 >= trunk)
			{
				for (int x1 = -radius; x1 <= radius; x1++)
				{
					for (int z1 = -radius; z1 <= radius; z1++)
					{
						if (cycleCount++ % 2 == 0 && x1 * x1 + y2 + z1 * z1 <= radius2)
						{
							this.setBlock(world, i + x1, j + y1, k + z1, this.leafBlock, this.leafMetadata);
						}
					}
				}
			}
		}
		
		this.setBlock(world, i, j + treeHeight, k, this.leafBlock, this.leafMetadata);
		return true;
	}
}
