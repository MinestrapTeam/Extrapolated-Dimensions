package clashsoft.mods.moredimensions.world.gen.heaven;

import clashsoft.mods.moredimensions.addons.Heaven;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class HeavenGenMinable extends WorldGenMinable
{	
	public HeavenGenMinable(Block block, int number)
	{
		this(block, 0, number);
	}
	
	public HeavenGenMinable(Block block, int metadata, int number)
	{
		super(block, metadata, number, Heaven.stoneBlocks);
	}
}
