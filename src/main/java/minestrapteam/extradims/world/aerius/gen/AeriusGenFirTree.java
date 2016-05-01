package minestrapteam.extradims.world.aerius.gen;

import minestrapteam.extracore.world.gen.CustomTreeGen;
import minestrapteam.extradims.lib.Aerius;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class AeriusGenFirTree extends CustomTreeGen
{
	public AeriusGenFirTree(boolean blockUpdates, int minTreeHeight, int metaWood, int metaLeaves)
	{
		super(blockUpdates, minTreeHeight, Aerius.logBlocks, Aerius.leafBlocks, metaWood, metaLeaves);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		Block soil = world.getBlock(x, y - 1, z);
		if (soil != Aerius.dirtBlocks && soil != Aerius.grassBlocks && soil != Blocks.grass && soil != Blocks.dirt)
		{
			return false;
		}
		
		int treeHeight = this.minTreeHeight + random.nextInt(3);
		for (int i = 0; i < treeHeight; i++)
		{
			this.setBlockAndNotifyAdequately(world, x, y + i, z, this.logBlock, this.logMetadata);
		}
		this.generateLeafCircles(world, random, x, y + 2, z, treeHeight, 3D, 3D / treeHeight);
		
		return true;
	}
}
