package clashsoft.mods.moredimensions.world.biome;

public class BiomePOCMountains extends BiomePOCPlains
{
	public BiomePOCMountains(int biomeID)
	{
		super(biomeID);
		this.setHeight(new Height(2F, 2F));
		this.setDisableRain();
		this.theBiomeDecorator.treesPerChunk = 1;
		this.waterColorMultiplier = 0x818181;
	}
}
