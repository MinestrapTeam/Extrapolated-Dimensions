package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.biome.CustomBiome;
import clashsoft.mods.moredimensions.lib.Heaven;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenTrees;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeHeaven extends CustomBiome
{
	public BiomeHeaven(int id)
	{
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 2, 8));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 12, 5, 8));
		
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 8, 4, 4));
		
		this.topBlock = Heaven.grassBlocks;
		this.fillerBlock = Heaven.dirtBlocks;
		this.stoneBlock = Heaven.stoneBlocks;
		
		this.theBiomeDecorator = this.getModdedBiomeDecorator(new BiomeDecoratorHeaven());
		
		this.color = 0x818181;
		this.waterColorMultiplier = 0x818181;
		this.setHeight(new Height(0F, 1.9F));
	}
	
	@Override
	public int getBedrockHeight()
	{
		return 0;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		int type = random.nextInt(8);
		if (type == 0) // Golden Tree
			type = 1;
		else
			type = 0;
		return new HeavenGenTrees(false, 6, type, type);
	}
}
