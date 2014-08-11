package minestrapteam.extradims.block.aerius;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomGrass;
import minestrapteam.extradims.lib.Aerius;

import net.minecraft.world.World;

public class BlockAeriusGrass extends BlockCustomGrass
{
	public BlockAeriusGrass(String[] names, String[] icons)
	{
		super(names, icons);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		
		int randInt = random.nextInt(128);
		if (randInt < 2)
		{
			int metadata = world.getBlockMetadata(x, y, z) + (5 * randInt);
			if (world.isAirBlock(x, y, z) && Aerius.plantBlocks.canPlaceBlockAt(world, x, y + 1, z))
			{
				world.setBlock(x, y + 1, z, Aerius.plantBlocks, metadata, 2);
			}
		}
	}
}
