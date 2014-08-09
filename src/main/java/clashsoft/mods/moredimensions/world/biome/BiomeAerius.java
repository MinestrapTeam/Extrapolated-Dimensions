package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.biome.CustomBiome;
import clashsoft.cslib.minecraft.world.gen.WorldGenRanged;
import clashsoft.mods.moredimensions.lib.Aerius;
import clashsoft.mods.moredimensions.world.gen.aerius.AeriusGenTrees;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeAerius extends CustomBiome
{
	public BiomeAerius(int id)
	{
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 2, 8));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 12, 5, 8));
		
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 8, 4, 4));
		
		this.topBlock = Aerius.grassBlocks;
		this.fillerBlock = Aerius.dirtBlocks;
		this.stoneBlock = Aerius.stoneBlocks;
		
		this.theBiomeDecorator = this.getModdedBiomeDecorator(new AeriusBiomeDecorator());
		
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
		int type = random.nextInt(10);
		if (type == 0)
		{
			type = 2;
		}
		else if (type < 5)
		{
			type = 1;
		}
		else
		{
			type = 0;
		}
		return new AeriusGenTrees(false, 6, type == 2 ? 1 : 0, type);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return new WorldGenRanged(Aerius.plantBlocks, 0);
	}
}
