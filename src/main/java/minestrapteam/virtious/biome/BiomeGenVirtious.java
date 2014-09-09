package minestrapteam.virtious.biome;

import clashsoft.cslib.minecraft.world.biome.CustomBiome;
import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityNative;
import minestrapteam.virtious.entity.EntityNativeSkeleton;
import minestrapteam.virtious.lib.VBlocks;

public class BiomeGenVirtious extends CustomBiome
{
	public BiomeGenVirtious(int id)
	{
		super(id);
		
		this.rootHeight = 0.3F;
		this.heightVariation = 0.2F;
		
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityNativeSkeleton.class, 15, 1, 3));
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityBurfalaunt.class, 12, 2, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityNative.class, 12, 2, 4));
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = VBlocks.virtian_grass;
		this.fillerBlock = VBlocks.virtian_soil;
		this.stoneBlock = VBlocks.virtianstone;
		
		this.theBiomeDecorator = new BiomeDecoratorVirtious();
	}
}
