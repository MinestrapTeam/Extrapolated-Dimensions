package minestrapteam.extradims.world.biome;

import java.util.Random;

import clashsoft.cslib.minecraft.world.biome.CustomBiome;
import clashsoft.cslib.minecraft.world.gen.WorldGenRanged;
import minestrapteam.extradims.lib.Aerius;
import minestrapteam.extradims.world.gen.AeriusGenBigTree;
import minestrapteam.extradims.world.gen.AeriusGenJungleTree;
import minestrapteam.extradims.world.gen.AeriusGenTree;
import minestrapteam.extradims.world.gen.AeriusGenTree2;

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
		int randInt = random.nextInt(10);
		if (randInt == 0)
		{
			// Gold Wood
			return new AeriusGenJungleTree(false, 10, 3, 3);
		}
		else if (randInt < 5)
		{
			// Cloudroot
			if (random.nextInt(4) == 0)
			{
				return new AeriusGenTree(false, 7, 2, 2);
			}
			else
			{
				return new AeriusGenTree2(false, 7, 2, 2);
			}
		}
		else
		{
			// Skybark
			if (random.nextInt(10) == 0)
			{
				return new AeriusGenBigTree(false, 20, 0, 0);
			}
			else
			{
				return new AeriusGenTree(false, 6, 0, 0);
			}
		}
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return new WorldGenRanged(Aerius.plantBlocks, 0);
	}
}
