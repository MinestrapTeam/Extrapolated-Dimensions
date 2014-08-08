package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.mods.moredimensions.lib.Heaven;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenMinable;

import net.minecraft.init.Blocks;
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
		this.randomGenerator = new Random();
	}
	
	@Override
	public void genDecorations(BiomeGenBase biome)
	{
		this.generateOres();
		
		for (int j = 0; j < this.treesPerChunk; ++j)
		{
			try
			{
				int x = this.chunk_X + this.randomGenerator.nextInt(16);
				int z = this.chunk_Z + this.randomGenerator.nextInt(16);
				int y = this.currentWorld.getTopSolidOrLiquidBlock(x, z);
				WorldGenAbstractTree worldgenabstracttree = biome.func_150567_a(this.randomGenerator);
				worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);
				
				if (worldgenabstracttree.generate(this.currentWorld, this.randomGenerator, x, y, z))
				{
					worldgenabstracttree.func_150524_b(this.currentWorld, this.randomGenerator, x, y, z);
				}
			}
			catch (Exception ex)
			{
			}
		}
	}
	
	@Override
	protected void generateOres()
	{
		this.genStandardOre1(20, this.dirtGen, 0, 128);
		this.genStandardOre1(10, this.gravelGen, 0, 128);
		
		this.genStandardOre1(10, this.sywoxiteGen, 0, 128);
		this.genStandardOre1(10, this.clashiumGen, 0, 128);
		this.genStandardOre1(8, this.bluriteGen, 0, 128);
		this.genStandardOre1(6, this.holyiumGen, 0, 128);
		this.genStandardOre1(3, this.diamondGen, 0, 128);
	}
	
	protected void genTrees(int amount, WorldGenerator worldgen, int minHeight, int maxHeight)
	{
		for (int i = 0; i < amount; ++i)
		{
			int x = this.chunk_X + this.randomGenerator.nextInt(16);
			int y = this.randomGenerator.nextInt(maxHeight - minHeight + 1) + minHeight;
			int z = this.chunk_Z + this.randomGenerator.nextInt(16);
			worldgen.generate(this.currentWorld, this.randomGenerator, x, y, z);
		}
	}
}
