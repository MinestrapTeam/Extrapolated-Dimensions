package minestrapteam.extradims.block.aerius;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomGrass;
import minestrapteam.extradims.lib.Aerius;

import net.minecraft.world.World;

public class BlockAeriusGrass extends BlockCustomGrass
{
	public BlockAeriusGrass(String[] names, String[] topIcons, String[] sideIcons, String[] bottomIcons)
	{
		super(names, topIcons, sideIcons, bottomIcons);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		
		int randInt = random.nextInt(128);
		if (randInt < 2)
		{
			int metadata = world.getBlockMetadata(x, y, z) + (5 * randInt);
			if (Aerius.plankBlocks.canPlaceBlockAt(world, x, y + 1, z))
			{
				world.setBlock(x, y + 1, z, Aerius.plantBlocks, metadata, 2);
			}
		}
	}
}
