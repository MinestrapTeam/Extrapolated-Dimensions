package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.Heaven;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenJungleTree;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeHeavenJungle extends BiomeHeaven
{
	public BiomeHeavenJungle(int i)
	{
		super(i);
		this.theBiomeDecorator.treesPerChunk = 12;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return new HeavenGenJungleTree(true, 7, Heaven.logBlocks, Heaven.leafBlocks);
	}
	
	@Override
	public byte getTopMetadata(int x, int y, int z)
	{
		return 1;
	}
	
	@Override
	public byte getFillerMetadata(int x, int y, int z)
	{
		return 1;
	}
}
