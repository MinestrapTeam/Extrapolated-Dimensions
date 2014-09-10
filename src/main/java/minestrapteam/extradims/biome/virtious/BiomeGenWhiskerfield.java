package minestrapteam.extradims.biome.virtious;

public class BiomeGenWhiskerfield extends BiomeGenVirtious
{
	public BiomeGenWhiskerfield(int id)
	{
		super(id);
		
		this.theBiomeDecorator = new WhiskerfieldBiomeDecorator();
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = 4;
		this.theBiomeDecorator.grassPerChunk = 10;
	}
}
