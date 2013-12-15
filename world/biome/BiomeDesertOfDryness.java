package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeDesertOfDryness extends BiomeGenOcean
{
	public BiomeDesertOfDryness(int biomeID)
	{
		super(biomeID);
		this.topBlock = (byte) Block.sand.blockID;
		this.fillerBlock = (byte) Block.sand.blockID;
		this.maxHeight = -0.1F;
		this.minHeight = -0.2F;
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = 0xFFFF00;
	}
	
	@Override
	public void decorate(World world, Random random, int chunkX, int chunkZ)
	{
		this.theBiomeDecorator.decorate(world, random, chunkX, chunkZ);
	}
}
