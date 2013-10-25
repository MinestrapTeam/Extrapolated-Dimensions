package com.chaosdev.paradiseofchaos.world.biome;

import clashsoft.mods.moredimensions.addons.POCBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeGenBase;

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
		this.topBlock = ((byte) POCBlocks.AlteredGrass.blockID);
		this.fillerBlock = ((byte) POCBlocks.AlteredDirt.blockID);
		
		this.waterColorMultiplier = 0xE42D17;
	}
}