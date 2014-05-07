package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomSapling;
import clashsoft.mods.moredimensions.addons.ParadiseOfChaos;
import clashsoft.mods.moredimensions.world.gen.poc.POCGenMagicOakTree;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockPOCSapling extends BlockCustomSapling
{
	public BlockPOCSapling(String[] names, String[] iconNames)
	{
		super(names, iconNames);
	}
	
	@Override
	public WorldGenerator getWorldGen(World world, int x, int y, int z, Random random)
	{
		int metadata = world.getBlockMetadata(x, y, z) & 3;
		return metadata == 0 ? new POCGenMagicOakTree(true) : null;
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		return block == ParadiseOfChaos.grassBlocks;
	}
}
