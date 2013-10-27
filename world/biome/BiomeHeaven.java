package clashsoft.mods.moredimensions.world.biome;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.poc.MDMGenTrees;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeHeaven extends BiomeGenBase
{
	public BiomeHeaven(int i)
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
		
		this.topBlock = (byte) MDMBlocks.heavenGrass.blockID;
		this.fillerBlock = (byte) MDMBlocks.groundBlocks.blockID;
		this.worldGeneratorTrees = new MDMGenTrees(true, 6, MDMBlocks.heavenLog.blockID, MDMBlocks.heavenLeaves.blockID, 0, 0, false);
		
		setColor(0xffffff);
		setBiomeName("Heaven");
	}
}
