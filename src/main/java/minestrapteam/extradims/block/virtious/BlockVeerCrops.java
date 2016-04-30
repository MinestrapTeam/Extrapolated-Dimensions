package minestrapteam.extradims.block.virtious;

import minestrapteam.extradims.lib.virtious.VBlocks;

import net.minecraft.block.Block;

import minestrapteam.extracore.block.BlockCustomCrops;

public class BlockVeerCrops extends BlockCustomCrops
{	
	public BlockVeerCrops()
	{
		super(6);
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		return block == VBlocks.virtian_soil_tilled;
	}
}
