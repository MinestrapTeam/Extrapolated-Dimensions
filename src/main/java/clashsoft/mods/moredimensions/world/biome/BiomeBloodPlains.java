package clashsoft.mods.moredimensions.world.biome;

import clashsoft.mods.moredimensions.addons.ParadiseOfChaos;

import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeBloodPlains extends BiomeGenBase
{
	public final Material	blockMaterial;
	
	public BiomeBloodPlains(int biomeID)
	{
		super(biomeID);
		this.blockMaterial = Material.ground;
		this.setHeight(new Height(0.3F, 0.2F));
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		
		this.topBlock = ParadiseOfChaos.pocGrassBlocks;
		this.fillerBlock = ParadiseOfChaos.pocDirtBlocks;
		
		this.theBiomeDecorator = new BiomeDecorator();
		
		this.waterColorMultiplier = 0xFF0000;
	}
}