package minestrapteam.extradims.biome.aerius;

public class BiomeAeriusForest extends BiomeAerius
{
	public BiomeAeriusForest(int id)
	{
		super(id);
		this.theBiomeDecorator.treesPerChunk = 4;
	}
}
