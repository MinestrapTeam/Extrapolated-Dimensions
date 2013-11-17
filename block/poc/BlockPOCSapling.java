package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import clashsoft.clashsoftapi.block.BlockCustomSapling;
import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.poc.POCGenMagicOakTree;
import clashsoft.mods.moredimensions.world.gen.poc.POCGenWillowTree;

public class BlockPOCSapling extends BlockCustomSapling
{
	public BlockPOCSapling(int blockID, String[] names, String[] icons)
	{
		super(blockID, names, icons);
	}

	@Override
	public WorldGenerator getWorldGen(World world, int x, int y, int z, Random random)
	{
		int metadata = world.getBlockMetadata(x, y, z) & 3;
		return metadata == 0 ? new POCGenMagicOakTree(true) : new POCGenWillowTree(true);
	}

	@Override
	public boolean isValidGround(int blockID, int blockMetadata)
	{
		return blockID == MDMBlocks.pocGrassBlocks.blockID;
	}
}
