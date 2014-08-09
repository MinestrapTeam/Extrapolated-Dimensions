package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.mods.moredimensions.lib.Heaven;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenMinable;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorHeaven extends BiomeDecorator
{
	private WorldGenerator	dirtGen		= new HeavenGenMinable(Heaven.dirtBlocks, 20);
	private WorldGenerator	sywoxiteGen	= new HeavenGenMinable(Heaven.stoneBlocks, 3, 18);
	private WorldGenerator	clashiumGen	= new HeavenGenMinable(Heaven.stoneBlocks, 4, 10);
	private WorldGenerator	bluriteGen	= new HeavenGenMinable(Heaven.stoneBlocks, 5, 8);
	private WorldGenerator	holyiumGen	= new HeavenGenMinable(Heaven.stoneBlocks, 6, 8);
	
	public BiomeDecoratorHeaven()
	{
		this.diamondGen = new HeavenGenMinable(Blocks.diamond_ore, 7);
		this.treesPerChunk = 1;
		this.grassPerChunk = 3;
	}
	
	@Override
	public void decorateChunk(World world, Random random, BiomeGenBase biome, int chunkX, int chunkZ)
	{
		this.currentWorld = world;
		this.randomGenerator = random;
		this.chunk_X = chunkX;
		this.chunk_Z = chunkZ;
		
		this.generateOres();
		
		for (int j = 0; j < this.treesPerChunk; ++j)
		{
			int x = chunkX + random.nextInt(16);
			int z = chunkZ + random.nextInt(16);
			int y = world.getTopSolidOrLiquidBlock(x, z);
			WorldGenAbstractTree worldgenabstracttree = biome.func_150567_a(random);
			worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);
			
			if (worldgenabstracttree.generate(world, random, x, y, z))
			{
				worldgenabstracttree.func_150524_b(world, random, x, y, z);
			}
		}
		
		for (int j = 0; j < this.grassPerChunk; ++j)
		{
			int x = chunkX + random.nextInt(16);
			int z = chunkZ + random.nextInt(16);
			int y = world.getTopSolidOrLiquidBlock(x, z);
			WorldGenerator grassGen = biome.getRandomWorldGenForGrass(random);
			grassGen.generate(world, random, x, y, z);
		}
		
		MDMWorld.generateHeaven(world, random, chunkX, chunkZ);
	}
	
	@Override
	protected void generateOres()
	{
		this.genStandardOre1(20, this.dirtGen, 32, 192);
		
		this.genStandardOre1(10, this.sywoxiteGen, 32, 160);
		this.genStandardOre1(10, this.clashiumGen, 24, 96);
		this.genStandardOre1(8, this.bluriteGen, 32, 128);
		this.genStandardOre1(6, this.holyiumGen, 32, 80);
		this.genStandardOre1(3, this.diamondGen, 32, 64);
	}
}
