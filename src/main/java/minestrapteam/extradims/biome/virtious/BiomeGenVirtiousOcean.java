package minestrapteam.extradims.biome.virtious;

import minestrapteam.extracore.world.biome.CustomBiome;
import minestrapteam.extradims.lib.virtious.VBlocks;

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
