package minestrapteam.extradims.biome.aerius;

import java.util.Random;

import minestrapteam.extracore.world.gen.WorldGenRanged;
import minestrapteam.extradims.lib.Aerius;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.aerius.gen.AeriusGenMinable;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class AeriusBiomeDecorator extends BiomeDecorator
{
	private WorldGenerator	blueFlowerGen	= new WorldGenRanged(Aerius.flowerBlocks, 0);
	private WorldGenerator	whiteFlowerGen	= new WorldGenRanged(Aerius.flowerBlocks, 1);
	private WorldGenerator	orangeFlowerGen	= new WorldGenRanged(Aerius.flowerBlocks, 2);
	
	private WorldGenerator	sywoxiteGen		= new AeriusGenMinable(Aerius.stoneBlocks, 3, 18);
	private WorldGenerator	clashiumGen		= new AeriusGenMinable(Aerius.stoneBlocks, 4, 10);
	private WorldGenerator	bluriteGen		= new AeriusGenMinable(Aerius.stoneBlocks, 5, 8);
	private WorldGenerator	holyiumGen		= new AeriusGenMinable(Aerius.stoneBlocks, 6, 8);
	
	public int				vinesPerChunk;
	
	public AeriusBiomeDecorator()
	{
		this.dirtGen = new AeriusGenMinable(Aerius.dirtBlocks, 20);
		this.diamondGen = new AeriusGenMinable(Blocks.diamond_ore, 7);
		this.treesPerChunk = 1;
		this.grassPerChunk = 3;
		this.vinesPerChunk = 5;
		this.flowersPerChunk = 5;
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
			WorldGenAbstractTree worldgenabstracttree = biome.func_150567_a(random);
			worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);
			
			if (worldgenabstracttree.generate(world, random, x, y, z))
			{
				worldgenabstracttree.func_150524_b(world, random, x, y, z);
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
			
			int rand = random.nextInt(3);
			if (rand == 0)
			{
				this.blueFlowerGen.generate(world, random, x, y, z);
			}
			else if (rand == 1)
			{
				this.whiteFlowerGen.generate(world, random, x, y, z);				
			}
			else
			{
				this.orangeFlowerGen.generate(world, random, x, y, z);
			}
		}
		
		WorldManager.generateAerius(world, random, chunkX, chunkZ);
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
