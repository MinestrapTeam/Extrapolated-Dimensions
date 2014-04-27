package clashsoft.mods.moredimensions.world.biome;

public class BiomeCorruptedMountains extends BiomePlainsOfInsanity
{
	public BiomeCorruptedMountains(int biomeID)
	{
		super(biomeID);
		this.setHeight(new Height(2F, 0.7F));
		this.setDisableRain();
		this.theBiomeDecorator.treesPerChunk = 1;
		this.waterColorMultiplier = 0x818181;
	}
}
