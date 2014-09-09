package minestrapteam.extradims.biome.poc;

import net.minecraft.init.Blocks;

public class BiomePOCDesert extends BiomePOCPlains
{
	public BiomePOCDesert(int biomeID)
	{
		super(biomeID);
		this.topBlock = Blocks.sand;
		this.fillerBlock = Blocks.sand;
		
		this.setHeight(new Height(0.1F, 0.1F));
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = 0x00A4A4;
	}
}
