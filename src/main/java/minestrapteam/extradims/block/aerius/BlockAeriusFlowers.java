package minestrapteam.extradims.block.aerius;

import minestrapteam.extradims.lib.aerius.ABlocks;
import net.minecraft.block.Block;

import minestrapteam.extracore.block.BlockCustomPlant;

public class BlockAeriusFlowers extends BlockCustomPlant
{
	public BlockAeriusFlowers(String[] names, String[] iconNames)
	{
		super(names, iconNames);
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		if (metadata == 2) // Dawnbringer
		{
			return (block == ABlocks.dirtBlocks || block == ABlocks.grassBlocks) && blockMetadata == 1;
		}
		return (block == ABlocks.dirtBlocks || block == ABlocks.grassBlocks) && blockMetadata == 0;
	}
}
