package minestrapteam.extradims.block.aerius;

import minestrapteam.extradims.lib.Aerius;

import net.minecraft.block.Block;

import minestrapteam.extracore.block.BlockCustomPlant;

public class BlockAeriusFlower extends BlockCustomPlant
{
	public BlockAeriusFlower(String[] names, String[] iconNames)
	{
		super(names, iconNames);
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		if (metadata == 2)
		{
			return (block == Aerius.dirtBlocks || block == Aerius.grassBlocks) && blockMetadata == 1;
		}
		return (block == Aerius.dirtBlocks || block == Aerius.grassBlocks) && blockMetadata == 0;
	}
}
