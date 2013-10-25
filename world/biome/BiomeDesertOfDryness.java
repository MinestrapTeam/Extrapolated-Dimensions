package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeDesertOfDryness extends BiomeGenOcean
{
	public BiomeDesertOfDryness(int par1)
	{
		super(par1);
		this.topBlock = (byte) Block.sand.blockID;
		this.fillerBlock = (byte) Block.sand.blockID;
		this.maxHeight = -0.1F;
		this.minHeight = -0.2F;
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.generateLakes = false;
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		this.theBiomeDecorator.decorate(par1World, par2Random, par3, par4);
	}
}
