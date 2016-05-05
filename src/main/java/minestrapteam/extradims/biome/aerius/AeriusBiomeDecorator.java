package minestrapteam.extradims.biome.aerius;

import minestrapteam.extracore.world.gen.WorldGenRanged;
import minestrapteam.extradims.lib.aerius.ABlocks;
import minestrapteam.extradims.world.aerius.gen.AeriusGenClouds;
import minestrapteam.extradims.world.aerius.gen.AeriusGenMinable;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class AeriusBiomeDecorator extends BiomeDecorator
{
	private WorldGenerator soulwhiskerGen = new WorldGenRanged(ABlocks.flowerBlocks, 0);
	private WorldGenerator palebloomGen   = new WorldGenRanged(ABlocks.flowerBlocks, 1);
	private WorldGenerator dawnbringerGen = new WorldGenRanged(ABlocks.flowerBlocks, 2);

	private WorldGenerator luminiteGen;
	private WorldGenerator copperGen;
	private WorldGenerator whiteGoldGen;
	private WorldGenerator holiumGen;
	private WorldGenerator condaiusGen;
	private WorldGenerator amnethiteGen;
	private WorldGenerator obsidianGen;

	public int vinesPerChunk;

	public AeriusBiomeDecorator(Block oreBlock)
	{
		this.treesPerChunk = 1;
		this.grassPerChunk = 3;
		this.vinesPerChunk = 5;
		this.flowersPerChunk = 5;

		this.dirtGen = new AeriusGenMinable(ABlocks.dirtBlocks, 20);

		this.luminiteGen = new AeriusGenMinable(oreBlock, 0, 18);
		this.copperGen = new AeriusGenMinable(oreBlock, 1, 10);
		this.whiteGoldGen = new AeriusGenMinable(oreBlock, 2, 10);
		this.holiumGen = new AeriusGenMinable(oreBlock, 3, 8);
		this.condaiusGen = new AeriusGenMinable(oreBlock, 4, 8);
		this.amnethiteGen = new AeriusGenMinable(oreBlock, 5, 8);
		this.diamondGen = new AeriusGenMinable(oreBlock, 6, 7);
		this.obsidianGen = new AeriusGenMinable(oreBlock, 7, 8);
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
			int x = chunkX + random.nextInt(16) + 8;
			int z = chunkZ + random.nextInt(16) + 8;
			int y = world.getTopSolidOrLiquidBlock(x, z);

			WorldGenAbstractTree treeGen = biome.func_150567_a(random);
			treeGen.setScale(1.0D, 1.0D, 1.0D);

			if (treeGen.generate(world, random, x, y, z))
			{
				treeGen.func_150524_b(world, random, x, y, z);
			}
		}

		for (int j = 0; j < this.grassPerChunk; ++j)
		{
			int x = chunkX + random.nextInt(16) + 8;
			int z = chunkZ + random.nextInt(16) + 8;
			int y = world.getTopSolidOrLiquidBlock(x, z);

			WorldGenerator grassGen = biome.getRandomWorldGenForGrass(random);
			grassGen.generate(world, random, x, y, z);
		}

		for (int j = 0; j < this.vinesPerChunk; ++j)
		{
			int x = chunkX + random.nextInt(16) + 8;
			int z = chunkZ + random.nextInt(16) + 8;
			int y = 0;
			while (y < 64 && world.isAirBlock(x, y, z))
			{
				y++;
			}

			world.setBlock(x, y - 1, z, Blocks.vine);
		}

		for (int j = 0; j < this.flowersPerChunk; ++j)
		{
			int x = chunkX + random.nextInt(16) + 8;
			int z = chunkZ + random.nextInt(16) + 8;
			int y = world.getTopSolidOrLiquidBlock(x, z);

			this.generateFlowers(world, random, x, y, z);
		}

		// Clouds
		generateClouds(world, random, chunkX, chunkZ);
	}

	public static void generateClouds(World world, Random random, int chunkX, int chunkZ)
	{
		int x = chunkX + random.nextInt(16);
		int y = 64 + random.nextInt(128);
		int z = chunkZ + random.nextInt(16);

		int count = 10 + random.nextInt(5);
		boolean flat = random.nextInt(8) == 0;
		new AeriusGenClouds(false, count, ABlocks.cloud, ABlocks.cloud.getRandomType(random), flat)
			.generate(world, random, x, y, z);
	}

	@Override
	protected void generateOres()
	{
		this.genStandardOre1(20, this.dirtGen, 32, 192);

		this.genStandardOre1(10, this.luminiteGen, 32, 160);
		this.genStandardOre1(12, this.copperGen, 24, 128);
		this.genStandardOre1(10, this.whiteGoldGen, 24, 96);
		this.genStandardOre1(6, this.holiumGen, 32, 80);
		this.genStandardOre1(8, this.condaiusGen, 32, 128);
		this.genStandardOre1(4, this.amnethiteGen, 32, 64);
		this.genStandardOre1(3, this.diamondGen, 32, 64);
		this.genStandardOre1(4, this.obsidianGen, 32, 80);
	}

	protected void generateFlowers(World world, Random random, int x, int y, int z)
	{
		int type = random.nextInt(3);
		if (type == 0)
		{
			this.soulwhiskerGen.generate(world, random, x, y, z);
		}
		else if (type == 1)
		{
			this.palebloomGen.generate(world, random, x, y, z);
		}
		else
		{
			this.dawnbringerGen.generate(world, random, x, y, z);
		}
	}
}
