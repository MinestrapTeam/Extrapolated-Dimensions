package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.mods.moredimensions.world.gen.WorldGenMagicOakTree;

import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeCorruptedMountains extends BiomePlainsOfInsanity
{
	public WorldGenMagicOakTree	worldGenMagicTree;
	
	public BiomeCorruptedMountains(int par1)
	{
		super(par1);
		this.maxHeight = 2F;
		this.minHeight = 0.7F;
		this.setDisableRain();
		this.theBiomeDecorator.treesPerChunk = 1;
		// this.spawnableMonsterList.add(new EntityDragon);
		worldGenMagicTree = new WorldGenMagicOakTree(false);
	}
	
	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return worldGenMagicTree;
	}
}
