package minestrapteam.extradims.block.aerius;

import minestrapteam.extracore.block.BlockCustomSapling;
import minestrapteam.extradims.biome.aerius.BiomeAerius;
import minestrapteam.extradims.lib.aerius.ABlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BlockAeriusSapling extends BlockCustomSapling
{
	public BlockAeriusSapling(String[] names, String[] icons)
	{
		super(names, icons);
	}

	@Override
	public WorldGenerator getWorldGen(World world, int x, int y, int z, Random random)
	{
		int type = world.getBlockMetadata(x, y, z) & 3;
		if (this == ABlocks.saplingBlocks2)
		{
			type += 4;
		}

		return BiomeAerius.getTreeGenForTree(random, type, true);
	}

	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		return (block == ABlocks.grassBlocks || block == ABlocks.dirtBlocks) && blockMetadata == 0;
	}
}
