package minestrapteam.virtious.biome;

import minestrapteam.virtious.lib.VBlocks;

public class BiomeGenGravelBeach extends BiomeGenVirtious
{	
	public BiomeGenGravelBeach(int id)
	{
		super(id);
		
		this.rootHeight = 0.3F;
		this.heightVariation = 0.2F;
		this.setColor(16440917);
		this.setTemperatureRainfall(0.7F, 0.3F);
		
		this.topBlock = VBlocks.fine_gravel;
		this.fillerBlock = VBlocks.fine_gravel;
	}
}
