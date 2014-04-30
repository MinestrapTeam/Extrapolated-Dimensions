package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomGrass;
import clashsoft.mods.moredimensions.addons.Heaven;

import net.minecraft.world.World;

public class BlockHeavenGrass extends BlockCustomGrass
{
	public BlockHeavenGrass(String[] names, String[] topIcons, String[] sideIcons, String[] bottomIcons)
	{
		super(names, topIcons, sideIcons, bottomIcons);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		
		if (world.isAirBlock(x, y + 1, z))
		{
			int randInt = random.nextInt(128);
			if (randInt < 2)
			{
				int metadata = world.getBlockMetadata(x, y, z) + (5 * randInt);
				world.setBlock(x, y + 1, z, Heaven.heavenPlantBlocks, metadata, 2);
			}
		}
	}
}
