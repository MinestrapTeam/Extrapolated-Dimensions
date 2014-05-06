package clashsoft.mods.moredimensions.world.biome;

import net.minecraft.block.Block;
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
	
	@Override
	public Block getTopBlock(int x, int y, int z)
	{
		return Blocks.sand;
	}
	
	@Override
	public Block getFillerBlock(int x, int y, int z)
	{
		return Blocks.sand;
	}
}
