package minestrapteam.virtious.biome;

import clashsoft.cslib.minecraft.world.biome.CustomBiome;
import minestrapteam.virtious.lib.VBlocks;

public class BiomeGenVirtiousOcean extends CustomBiome
{
	public BiomeGenVirtiousOcean(int id)
	{
		super(id);
		this.rootHeight = -0.5F;
		this.heightVariation = 0.2F;
		
		this.topBlock = VBlocks.fine_gravel;
		this.fillerBlock = VBlocks.fine_gravel;
		this.stoneBlock = VBlocks.virtianstone;
		this.waterBlock = VBlocks.virtious_acid;
		this.waterLevel = 64;
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
	}
}
