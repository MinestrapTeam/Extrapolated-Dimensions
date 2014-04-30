package clashsoft.mods.moredimensions.world.biome;

import clashsoft.mods.moredimensions.addons.ParadiseOfChaos;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeBloodPlains extends BiomePOCPlains
{	
	public BiomeBloodPlains(int biomeID)
	{
		super(biomeID);
		
		this.topBlock = ParadiseOfChaos.pocGrassBlocks;
		this.fillerBlock = ParadiseOfChaos.pocDirtBlocks;
		
		this.theBiomeDecorator = new BiomeDecorator();
		
		this.waterColorMultiplier = 0xFF0000;
	}
	
	@Override
	public byte getTopMetadata(int x, int y, int z)
	{
		return 1;
	}
	
	@Override
	public byte getFillerMetadata(int x, int y, int z)
	{
		return 1;
	}
	
	@Override
	public Block getStoneBlock(int x, int y, int z)
	{
		return ParadiseOfChaos.pocBloodStoneBlocks;
	}
}