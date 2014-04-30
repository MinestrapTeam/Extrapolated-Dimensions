package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.CustomBigTreeGen;
import clashsoft.mods.moredimensions.addons.ParadiseOfChaos;
import clashsoft.mods.moredimensions.world.gen.poc.POCGenMagicOakTree;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomePlainsOfInsanity extends BiomeGenBase
{
	public final Material	blockMaterial;
	
	public BiomePlainsOfInsanity(int biomeID)
	{
		super(biomeID);
		this.blockMaterial = Material.ground;
		this.setHeight(new Height(0.3F, 0.2F));
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ParadiseOfChaos.pocGrassBlocks;
		this.fillerBlock = ParadiseOfChaos.pocDirtBlocks;
		
		this.theBiomeDecorator = new BiomeDecorator();
		
		this.waterColorMultiplier = 0xFFFFFF;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return random.nextBoolean() ? new POCGenMagicOakTree(true) : new CustomBigTreeGen(true, 5, Blocks.log, Blocks.leaves);
	}
}