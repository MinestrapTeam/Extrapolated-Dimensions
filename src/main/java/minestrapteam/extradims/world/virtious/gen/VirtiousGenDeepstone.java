package minestrapteam.extradims.world.virtious.gen;

import minestrapteam.extradims.lib.virtious.VBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class VirtiousGenDeepstone extends WorldGenMinable
{
	public VirtiousGenDeepstone(Block block, int number)
	{
		this(block, 0, number);
	}
    
	public VirtiousGenDeepstone(Block block, int metadata, int number)
	{
		super(block, metadata, number, VBlocks.deepstone);
	}
}
