package minestrapteam.extracore.world.biome;

import net.minecraft.block.Block;

public interface ICustomBiome
{
	Block getTopBlock();
	
	Block getFillerBlock();
	
	Block getStoneBlock();
	
	Block getWaterBlock();
	
	byte getTopMetadata();
	
	byte getFillerMetadata();
	
	byte getStoneMetadata();
	
	byte getWaterMetadata();
	
	int getBedrockHeight();
	
	int getWaterLevel();
}
