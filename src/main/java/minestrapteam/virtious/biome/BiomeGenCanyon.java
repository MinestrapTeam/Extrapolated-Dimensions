package minestrapteam.virtious.biome;

import minestrapteam.virtious.lib.VBlocks;

public class BiomeGenCanyon extends BiomeGenVirtious
{
	public BiomeGenCanyon(int id)
	{
		super(id);
		
		this.rootHeight = 0.9F;
		this.heightVariation = 0.6F;
		
		this.setDisableRain();
		this.setTemperatureRainfall(2.0F, 0.0F);
		
		this.topBlock = VBlocks.canyonstone;
		this.fillerBlock = VBlocks.canyonstone;
		this.stoneBlock = VBlocks.virtianstone;
		
		// TODO New biome decorator
		// this.theBiomeDecorator = new BiomeDecoratorVirtious(this);
	}
}
