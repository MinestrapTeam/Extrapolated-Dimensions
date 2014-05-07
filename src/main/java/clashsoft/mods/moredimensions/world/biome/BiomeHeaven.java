package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.biome.CustomBiome;
import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import clashsoft.mods.moredimensions.addons.Heaven;

import net.minecraft.block.Block;
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
		
		this.theBiomeDecorator = this.getModdedBiomeDecorator(new BiomeDecoratorHeaven());
		
		this.color = 0x818181;
		this.waterColorMultiplier = 0x818181;
		this.setHeight(new Height(0F, 1.9F));
	}
	
	@Override
	public Block getTopBlock(int x, int y, int z)
	{
		return Heaven.grassBlocks;
	}
	
	@Override
	public Block getFillerBlock(int x, int y, int z)
	{
		return Heaven.dirtBlocks;
	}
	
	@Override
	public Block getStoneBlock(int x, int y, int z)
	{
		return Heaven.stoneBlocks;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		int type = random.nextInt(8);
		if (type == 0) // Golden Tree
			type = 1;
		else
			type = 0;
		return new CustomTreeGen(true, 6, Heaven.logBlocks, Heaven.leafBlocks, type, type);
	}
}
