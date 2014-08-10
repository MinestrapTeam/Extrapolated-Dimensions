package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.WorldGenRanged;
import clashsoft.mods.moredimensions.lib.Aerius;
import clashsoft.mods.moredimensions.world.gen.aerius.AeriusGenJungleTree;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeAeriusJungle extends BiomeAerius
{
	public BiomeAeriusJungle(int i)
	{
		super(i);
		
		this.topMetadata = 1;
		this.fillerMetadata = 1;
		this.stoneMetadata = 3;
		
		this.theBiomeDecorator.treesPerChunk = 8;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return new AeriusGenJungleTree(true, 7, Aerius.logBlocks, Aerius.leafBlocks);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return new WorldGenRanged(Aerius.plantBlocks, 1);
	}
}
