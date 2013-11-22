package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.CustomTreeGenerator;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeHeaven extends BiomeGenBase
{
	public BiomeHeaven(int i)
	{
		super(i);
		
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		
		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 6));
		spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 2, 8));
		spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 12, 5, 8));
		
		spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 8, 4, 4));
		
		this.topBlock = (byte) MDMBlocks.heavenGrassBlocks.blockID;
		this.fillerBlock = (byte) MDMBlocks.heavenDirtBlocks.blockID;
		
		this.theBiomeDecorator = getModdedBiomeDecorator(new BiomeDecoratorHeaven(this));
		
		this.color = 0x818181;
		this.waterColorMultiplier = 0x818181;
		this.setMinMaxHeight(-1.9F, 1.9F);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		int type = par1Random.nextInt(1);
		return new CustomTreeGenerator(true, 6, MDMBlocks.heavenLogs.blockID, MDMBlocks.heavenLeaves.blockID, type, type);
	}
}
