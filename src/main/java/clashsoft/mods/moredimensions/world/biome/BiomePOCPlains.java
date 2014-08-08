package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.biome.CustomBiome;
import clashsoft.cslib.minecraft.world.gen.CustomBigTreeGen;
import clashsoft.mods.moredimensions.lib.ParadiseOfChaos;
import clashsoft.mods.moredimensions.world.gen.poc.POCGenMagicOakTree;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomePOCPlains extends CustomBiome
{
	public BiomePOCPlains(int biomeID)
	{
		super(biomeID);
		this.setHeight(new Height(0.3F, 0.2F));
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		
		this.topBlock = ParadiseOfChaos.grassBlocks;
		this.fillerBlock = ParadiseOfChaos.dirtBlocks;
		this.stoneBlock = ParadiseOfChaos.stoneBlocks;
		
		this.theBiomeDecorator = new BiomeDecorator();
		
		this.waterColorMultiplier = 0xFFFFFF;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return random.nextBoolean() ? new POCGenMagicOakTree(true) : new CustomBigTreeGen(true, 5, Blocks.log, Blocks.leaves);
	}
}