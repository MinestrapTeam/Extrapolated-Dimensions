package clashsoft.mods.moredimensions.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomePOCDesert extends BiomeGenOcean
{
	public BiomePOCDesert(int biomeID)
	{
		super(biomeID);
		this.topBlock = Blocks.sand;
		this.fillerBlock = Blocks.sand;
		
		this.setHeight(new Height(0.1F, 0.1F));
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = 0xFFFF00;
	}
}
