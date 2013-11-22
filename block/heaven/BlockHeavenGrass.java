package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import net.minecraft.world.World;

import clashsoft.cslib.minecraft.block.BlockCustomGrass;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

public class BlockHeavenGrass extends BlockCustomGrass
{
	public BlockHeavenGrass(int blockID, String[] names, String[] topIcons, String[] sideIcons, String[] bottomIcons)
	{
		super(blockID, names, topIcons, sideIcons, bottomIcons);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		
		if (world.getBlockId(x, y + 1, z) == 0)
		{
			int randInt = random.nextInt(128);
			if (randInt < 2)
			{
				int metadata = world.getBlockMetadata(x, y, z) + (5 * randInt);
				world.setBlock(x, y + 1, z, MDMBlocks.heavenPlantBlocks.blockID, metadata, 2);
			}
		}
	}
}
