package clashsoft.mods.moredimensions.block.aerius;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomSapling;
import clashsoft.mods.moredimensions.lib.Aerius;
import clashsoft.mods.moredimensions.world.gen.aerius.AeriusGenJungleTree;
import clashsoft.mods.moredimensions.world.gen.aerius.AeriusGenTrees;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockAeriusSapling extends BlockCustomSapling
{
	public BlockAeriusSapling(String[] names, String[] icons)
	{
		super(names, icons);
	}
	
	public BlockAeriusSapling(String[] names, String domain)
	{
		super(names, domain);
	}
	
	@Override
	public WorldGenerator getWorldGen(World world, int x, int y, int z, Random random)
	{
		int metadata = world.getBlockMetadata(x, y, z) & 3;
		return random.nextInt(5) == 0 ? new AeriusGenTrees(true, 4, metadata, metadata) : new AeriusGenJungleTree(true, 7, Aerius.logBlocks, Aerius.leafBlocks, metadata, metadata);
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		return (block == Aerius.grassBlocks || block == Aerius.dirtBlocks) && blockMetadata == 0;
	}
}
