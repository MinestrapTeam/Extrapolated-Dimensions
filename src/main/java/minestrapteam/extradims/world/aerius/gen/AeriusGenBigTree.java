package minestrapteam.extradims.world.aerius.gen;

import minestrapteam.extracore.world.gen.CustomTreeGen;
import minestrapteam.extradims.lib.aerius.ABlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class AeriusGenBigTree extends CustomTreeGen
{
	public static AeriusGenBigTree create(boolean blockUpdates, int minTreeHeight, int type)
	{
		final int metadata = type % 4;
		if (type >= 4)
		{
			return new AeriusGenBigTree(blockUpdates, minTreeHeight, ABlocks.logBlocks2, ABlocks.leafBlocks2, metadata,
			                            metadata);
		}
		return new AeriusGenBigTree(blockUpdates, minTreeHeight, ABlocks.logBlocks, ABlocks.leafBlocks, metadata, metadata);
	}

	private AeriusGenBigTree(boolean blockUpdates, int minTreeHeight, Block log, Block leaf, int woodMetadata, int leavesMetadata)
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
		
		int treeHeight = this.minTreeHeight + random.nextInt(4);
		
		for (int i = 0; i < treeHeight; i++)
		{
			int y1 = y + i;
			this.setBlock(world, x, y1, z, this.logBlock, this.logMetadata);
			this.setBlock(world, x + 1, y1, z, this.logBlock, this.logMetadata);
			this.setBlock(world, x - 1, y1, z, this.logBlock, this.logMetadata);
			this.setBlock(world, x, y1, z + 1, this.logBlock, this.logMetadata);
			this.setBlock(world, x, y1, z - 1, this.logBlock, this.logMetadata);
			
			if (i > 4)
			{
				this.generateBranch(world, random, x, y1, z, (i + random.nextInt(12)) % 9);
				this.generateBranch(world, random, x, y1, z, (i + random.nextInt(12)) % 9);
				this.generateBranch(world, random, x, y1, z, (i + random.nextInt(12)) % 9);
			}
		}
		
		return true;
	}
	
	public void generateBranch(World world, Random random, int x, int y, int z, int direction)
	{
		int xOff = direction % 3 - 1;
		int zOff = direction / 3 % 3 - 1;
		
		if (xOff == 0 && zOff == 0)
		{
			return;
		}
		
		int branchLength = 7 + random.nextInt(3);
		int branchMax = branchLength - 5;
		
		for (int k = 0; k < branchLength; k++)
		{
			if (k > branchMax)
			{
				this.setBranchBlock(world, x + xOff * branchMax, y + k, z + zOff * branchMax);
			}
			else
			{
				this.setBranchBlock(world, x + xOff * k, y + k, z + zOff * k);
			}
		}
	}
	
	public void setBranchBlock(World world, int x, int y, int z)
	{
		this.setBlock(world, x, y, z, this.logBlock, this.logMetadata);
		this.setBlock(world, x + 1, y, z, this.leafBlock, this.leafMetadata);
		this.setBlock(world, x - 1, y, z, this.leafBlock, this.leafMetadata);
		this.setBlock(world, x, y + 1, z, this.leafBlock, this.leafMetadata);
		this.setBlock(world, x, y - 1, z, this.leafBlock, this.leafMetadata);
		this.setBlock(world, x, y, z + 1, this.leafBlock, this.leafMetadata);
		this.setBlock(world, x, y, z - 1, this.leafBlock, this.leafMetadata);
	}
}
