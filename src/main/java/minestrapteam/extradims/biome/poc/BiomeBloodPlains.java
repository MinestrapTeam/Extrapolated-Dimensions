package minestrapteam.extradims.biome.poc;

import minestrapteam.extradims.lib.ParadiseOfChaos;

import net.minecraft.world.biome.BiomeDecorator;

public class BiomeBloodPlains extends BiomePOCPlains
{	
	public BiomeBloodPlains(int biomeID)
	{
		super(biomeID);
		
		this.topBlock = ParadiseOfChaos.grassBlocks;
		this.topMetadata = 1;
		this.fillerBlock = ParadiseOfChaos.dirtBlocks;
		this.fillerMetadata = 1;
		this.stoneBlock = ParadiseOfChaos.bloodStoneBlocks;
		
		this.theBiomeDecorator = new BiomeDecorator();
		
		this.waterColorMultiplier = 0xFF0000;
	}
}