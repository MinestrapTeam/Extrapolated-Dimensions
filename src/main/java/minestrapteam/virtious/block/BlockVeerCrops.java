package minestrapteam.virtious.block;

import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.block.Block;

import clashsoft.cslib.minecraft.block.BlockCustomCrops;

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
