package com.chaosdev.paradiseofchaos.world.biome;

import java.util.Random;

import com.chaosdev.paradiseofchaos.world.MagicOakTree;

import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeCorruptedMountains extends BiomePlainsOfInsanity
{
	public MagicOakTree	worldGenMagicTree;
	
	public BiomeCorruptedMountains(int par1)
	{
		super(par1);
		this.maxHeight = 2F;
		this.minHeight = 0.7F;
		this.setDisableRain();
		this.theBiomeDecorator.treesPerChunk = 1;
		// this.spawnableMonsterList.add(new EntityDragon);
		worldGenMagicTree = new MagicOakTree(false);
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
