package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.clashsoftapi.world.gen.CustomTreeGenerator;
import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenMinable;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorHeaven extends BiomeDecorator
{
	protected WorldGenerator			spikeGen;
	
	private WorldGenerator				dirtGen		= new HeavenGenMinable(MDMBlocks.groundBlocks.blockID, 20);
	private WorldGenerator				sywoxiteGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 3, 18);
	private WorldGenerator				clashiumGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 4, 10);
	private WorldGenerator				bluriteGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 5, 8);
	private WorldGenerator				holyiumGen	= new HeavenGenMinable(MDMBlocks.stoneBlocks.blockID, 6, 8);
	private WorldGenerator				treeGen		= new CustomTreeGenerator(true, 6, MDMBlocks.heavenLogs.blockID, MDMBlocks.heavenLeaves.blockID, 0, 0, false);
	
	public BiomeDecoratorHeaven(BiomeGenBase par1BiomeGenBase)
	{
		super(par1BiomeGenBase);
		this.treesPerChunk = 8;
		this.randomGenerator = new Random();
	}
	
	/**
	 * The method that does the work of actually decorating chunks
	 */
	@Override
	protected void decorate()
	{
		this.generateOres();
		this.genTrees(this.randomGenerator.nextInt(4) + 4, treeGen, 0, 128);
	}
	
	/**
	 * Generates ores in the current chunk
	 */
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
	
	/**
	 * Standard ore generation helper. Generates most ores.
	 */
	protected void genTrees(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
	{
		for (int var5 = 0; var5 < par1; ++var5)
		{
			int x = this.chunk_X + this.randomGenerator.nextInt(16);
			int y = this.randomGenerator.nextInt(par4 - par3) + par3;
			int z = this.chunk_Z + this.randomGenerator.nextInt(16);
			par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, x, y, z);
		}
	}
}
