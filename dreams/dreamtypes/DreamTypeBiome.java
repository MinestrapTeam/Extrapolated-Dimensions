package com.chaosdev.paradiseofchaos.dreams.dreamtypes;

import java.util.Random;

import com.chaosdev.paradiseofchaos.dreams.EnumDreamType;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class DreamTypeBiome extends DreamType
{
	private BiomeGenBase	biome;
	
	public DreamTypeBiome(String name, EnumDreamType type, BiomeGenBase biome)
	{
		super(name, type);
		this.biome = biome;
	}
	
	@Override
	public BiomeGenBase getDreamBiome()
	{
		return biome;
	}
	
	@Override
	public void generateWorld(World world, int chunkX, int chunkY, Random random)
	{
	}
	
}
