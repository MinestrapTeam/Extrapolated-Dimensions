package minestrapteam.extradims.block.virtious;

import java.util.Random;

import minestrapteam.extracore.block.BlockCustomSapling;
import minestrapteam.extradims.lib.virtious.Virtious;
import minestrapteam.extradims.lib.virtious.VBlocks;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenAmberTree;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenVirtianTree;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockVirtiousSapling extends BlockCustomSapling
{
	public BlockVirtiousSapling(String[] names, Object icons)
	{
		super(names, icons);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}

	@Override
	public WorldGenerator getWorldGen(World world, int x, int y, int z, Random random)
	{
		int metadata = world.getBlockMetadata(x, y, z) & 3;
		return metadata == 0 ? new VirtiousGenVirtianTree(true) : new VirtiousGenAmberTree(true);
	}

	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		return block == VBlocks.virtian_soil || block == VBlocks.virtian_grass;
	}
}
