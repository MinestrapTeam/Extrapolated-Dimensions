package clashsoft.mods.moredimensions.world.gen.aerius;

import clashsoft.mods.moredimensions.lib.Aerius;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class AeriusGenMinable extends WorldGenMinable
{	
	public AeriusGenMinable(Block block, int number)
	{
		this(block, 0, number);
	}
	
	public AeriusGenMinable(Block block, int metadata, int number)
	{
		super(block, metadata, number, Aerius.stoneBlocks);
	}
}
