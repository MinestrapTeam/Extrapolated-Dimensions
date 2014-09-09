package minestrapteam.virtious.world.gen;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class VirtiousGenVirtianTree extends CustomTreeGen
{
	public VirtiousGenVirtianTree(boolean update)
	{
		super(update, 8, VBlocks.virtious_logs, VBlocks.virtious_leaves, 0, 0);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int cap = random.nextInt(2) + 2;
		int trunk = random.nextInt(3) + 3;
		
		int treeHeight = trunk + this.minTreeHeight;
		
		int h1 = treeHeight - random.nextInt(2);
		int h2 = treeHeight - random.nextInt(2);
		int h3 = treeHeight - random.nextInt(2);
		int h4 = treeHeight - random.nextInt(2);
		
		int rand1 = random.nextInt(2);
		int rand2 = random.nextInt(2);
		int rand3 = random.nextInt(2);
		int rand4 = random.nextInt(2);
		
		for (int i = 0; i < treeHeight + cap; i++)
		{
			if (i < treeHeight)
			{
				this.setBlock(world, x, y + i, z, this.logBlock, this.logMetadata);
			}
			
			if (i >= trunk && i < treeHeight + 1)
			{
				addLeaves(world, x + 1, y + i, z);
				addLeaves(world, x - 1, y + i, z);
				addLeaves(world, x, y + i, z + 1);
				addLeaves(world, x, y + i, z - 1);
			}
			
			if (i > trunk && i < h1)
				addLeaves(world, x + 1, y + i, z + 1);
			if (i > trunk && i < h2)
				addLeaves(world, x - 1, y + i, z - 1);
			if (i > trunk && i < h3)
				addLeaves(world, x - 1, y + i, z + 1);
			if (i > trunk && i < h4)
				addLeaves(world, x + 1, y + i, z - 1);
			
			// /
			// if(i + h1 > trunk && i < h1 * 2)
			// addLeaves(world, x + 2, y+i, z + 2);
			// if(i + h2> trunk && i < h2 * 2)
			// addLeaves(world, x - 2, y+i, z - 2);
			// if(i + h3> trunk && i < h3 * 2)
			// addLeaves(world, x - 2, y+i, z + 2);
			// if(i + h4> trunk && i < h4 * 2)
			// addLeaves(world, x + 2, y+i, z - 2);
			// //
			
			if (i >= trunk + rand3 && i < treeHeight - rand1 * 2)
				addLeaves(world, x + 2, y + i, z);
			if (i >= trunk + rand2 && i < treeHeight - rand2 * 2)
				addLeaves(world, x - 2, y + i, z);
			if (i >= trunk + rand4 && i < treeHeight - rand3 * 2)
				addLeaves(world, x, y + i, z + 2);
			if (i >= trunk + rand1 && i < treeHeight - rand4 * 2)
				addLeaves(world, x, y + i, z - 2);
			
			if (i >= treeHeight)
			{
				addLeaves(world, x, y + i, z);
			}
		}
		
		return true;
	}
	
	private boolean addLeaves(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		if (block.canBeReplacedByLeaves(world, x, y, z))
		{
			this.setBlock(world, x, y, z, this.leafBlock, this.leafMetadata);
			return true;
		}
		return false;
	}
}
