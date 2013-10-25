package clashsoft.mods.moredimensions.world.biome;

import clashsoft.mods.moredimensions.addons.MDMHeaven;
import clashsoft.mods.moredimensions.world.gen.WorldGenTreesMoreDimensions;

import net.minecraft.entity.passive.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenHeaven extends BiomeGenBase
{
	public BiomeGenHeaven(int i)
	{
		super(i);
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		
		// spawnableMonsterList.add(new SpawnListEntry(EntityScider.class, 11,
		// 1, 4));
		// spawnableMonsterList.add(new SpawnListEntry(EntityGiantZombie.class,
		// 50, 1, 2));
		
		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 6));
		spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 2, 8));
		spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 12, 5, 8));
		
		spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 8, 4, 4));
		
		this.topBlock = (byte) MDMHeaven.heavenGrass.blockID;
		this.fillerBlock = (byte) MDMHeaven.groundBlocks.blockID;
		this.worldGeneratorTrees = new WorldGenTreesMoreDimensions(true, 6, MDMHeaven.heavenLog.blockID, MDMHeaven.heavenLeaves.blockID, 0, 0, false);
		
		setColor(0xffffff);
		setBiomeName("Heaven");
	}
}
