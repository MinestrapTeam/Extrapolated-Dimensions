package minestrapteam.extradims.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.WorldGenRanged;
import minestrapteam.extradims.lib.Aerius;

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
		this.theBiomeDecorator.flowersPerChunk = 0;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return getTreeGenForTree(random, 1, false);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return new WorldGenRanged(Aerius.plantBlocks, 1);
	}
}
