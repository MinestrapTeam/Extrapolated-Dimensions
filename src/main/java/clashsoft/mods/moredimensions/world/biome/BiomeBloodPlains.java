package clashsoft.mods.moredimensions.world.biome;

import clashsoft.mods.moredimensions.lib.ParadiseOfChaos;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeBloodPlains extends BiomePOCPlains
{	
	public BiomeBloodPlains(int biomeID)
	{
		super(biomeID);
		
		this.topBlock = ParadiseOfChaos.grassBlocks;
		this.fillerBlock = ParadiseOfChaos.dirtBlocks;
		
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
		return ParadiseOfChaos.bloodStoneBlocks;
	}
}