package minestrapteam.extradims.biome.aerius;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.WorldGenRanged;
import minestrapteam.extradims.lib.Aerius;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeHallow extends BiomeAerius
{
	public BiomeHallow(int id)
	{
		super(id);
		
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.treesPerChunk = 3;
		
		this.topMetadata = 3;
		this.fillerBlock = Blocks.dirt;
		this.stoneBlock = Blocks.stone;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return new WorldGenRanged(Aerius.plantBlocks, 3);
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return getTreeGenForTree(random, 3, false);
	}
}
