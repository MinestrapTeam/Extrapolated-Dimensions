package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.clashsoftapi.block.BlockCustomSapling;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenTrees;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockHeavenSapling extends BlockCustomSapling
{
	public BlockHeavenSapling(int blockID, String[] names, String[] icons)
	{
		super(blockID, names, icons);
	}

	@Override
	public WorldGenerator getWorldGen(World world, int x, int y, int z, Random random)
	{
		int metadata = world.getBlockMetadata(x, y, z) & 3;
		return new HeavenGenTrees(true, 4, metadata, metadata);
	}
}
