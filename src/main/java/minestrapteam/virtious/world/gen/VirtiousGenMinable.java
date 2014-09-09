package minestrapteam.virtious.world.gen;

import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class VirtiousGenMinable extends WorldGenMinable
{
	public VirtiousGenMinable(Block block, int number)
	{
		this(block, 0, number);
	}
    
	public VirtiousGenMinable(Block block, int metadata, int number)
	{
		super(block, metadata, number, VBlocks.virtianstone);
	}
}
