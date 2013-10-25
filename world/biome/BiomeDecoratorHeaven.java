package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.HeavenGenMinable;
import clashsoft.mods.moredimensions.world.gen.WorldGenTreesMoreDimensions;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorHeaven extends BiomeDecorator
{
	protected WorldGenerator			spikeGen;
	
	private Random						rand		= new Random();
	
	private WorldGenerator				dirtGen		= new HeavenGenMinable(MDMBlocks.groundBlocks.blockID, 20);
	private WorldGenerator				sywoxiteGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 3, 18);
	private WorldGenerator				clashiumGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 4, 10);
	private WorldGenerator				bluriteGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 5, 8);
	private WorldGenerator				holyiumGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 6, 8);
	private WorldGenerator				treeGen		= new WorldGenTreesMoreDimensions(true, 6, MDMBlocks.heavenLog.blockID, MDMBlocks.heavenLeaves.blockID, 0, 0, false);
	
	private int							trees		= rand.nextInt(1);
	
	public BiomeDecoratorHeaven(BiomeGenBase par1BiomeGenBase)
	{
		super(par1BiomeGenBase);
		this.treesPerChunk = trees;
		this.randomGenerator = new Random();
	}
	
	/**
	 * The method that does the work of actually decorating chunks
	 */
	@Override
	protected void decorate()
	{
		this.generateOres();
		this.genTrees(trees, treeGen, 0, 128);
	}
	
	/**
	 * Generates ores in the current chunk
	 */
	@Override
	protected void generateOres()
	{
		this.genStandardOre1(20, this.dirtGen, 0, 128);
		this.genStandardOre1(10, this.gravelGen, 0, 128);
		this.genStandardOre1(20, this.sywoxiteGen, 0, 128);
		this.genStandardOre1(20, this.clashiumGen, 0, 64);
		this.genStandardOre1(2, this.bluriteGen, 0, 32);
		this.genStandardOre1(8, this.holyiumGen, 0, 16);
		this.genStandardOre1(1, this.diamondGen, 0, 16);
	}
	
	/**
	 * Standard ore generation helper. Generates most ores.
	 */
	protected void genTrees(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
	{
		for (int var5 = 0; var5 < par1; ++var5)
		{
			int var6 = this.chunk_X + this.randomGenerator.nextInt(16);
			int var7 = this.randomGenerator.nextInt(par4 - par3) + par3;
			int var8 = this.chunk_Z + this.randomGenerator.nextInt(16);
			par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, var6, var7, var8);
		}
	}
}
