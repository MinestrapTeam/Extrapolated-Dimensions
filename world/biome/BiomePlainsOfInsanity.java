package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.poc.POCGenMagicOakTree;
import clashsoft.mods.moredimensions.world.gen.poc.POCGenWillowTree;

import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomePlainsOfInsanity extends BiomeGenBase
{
	public final Material	blockMaterial;
	
	public BiomePlainsOfInsanity(int par1)
	{
		super(par1);
		this.blockMaterial = Material.ground;
		this.minHeight = 0.1F;
		this.maxHeight = 0.5F;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ((byte) MDMBlocks.pocGrassBlocks.blockID);
		this.fillerBlock = ((byte) MDMBlocks.pocDirtBlocks.blockID);
		
		this.theBiomeDecorator = new BiomeDecorator(this);
		
		this.waterColorMultiplier = 0xFFFFFF;
	}
	
	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return par1Random.nextBoolean() ? new POCGenMagicOakTree(true) : new POCGenWillowTree(true);
	}
}