package minestrapteam.extradims.biome.aerius;

import minestrapteam.extracore.world.biome.CustomBiome;
import minestrapteam.extracore.world.gen.WorldGenRanged;
import minestrapteam.extradims.lib.aerius.ABlocks;
import minestrapteam.extradims.world.aerius.gen.AeriusGenBigTree;
import minestrapteam.extradims.world.aerius.gen.AeriusGenFirTree;
import minestrapteam.extradims.world.aerius.gen.AeriusGenJungleTree;
import minestrapteam.extradims.world.aerius.gen.AeriusGenTree;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeAerius extends CustomBiome
{
	public static final int SKYBARK = 0;
	public static final int DARK_SKYBARK = 1;
	public static final int CLOUDROOT = 4;
	public static final int GOLDWOOD = 5;
	public static final int MAGIC_OAK = 6;
	public static final int WILLOW = 7;

	public BiomeAerius(int id)
	{
		super(id);
		
		this.color = 0x818181;
		this.waterColorMultiplier = 0x818181;
		
		this.rootHeight = 0F;
		this.heightVariation = 1.9F;

		this.topBlock = ABlocks.grassBlocks;
		this.fillerBlock = ABlocks.dirtBlocks;
		this.stoneBlock = ABlocks.stoneBlocks;
	}

	@Override
	public BiomeDecorator createBiomeDecorator()
	{
		return this.getModdedBiomeDecorator(new AeriusBiomeDecorator(ABlocks.oreBlocks));
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addSpawnEntries()
	{
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 2, 8));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 12, 5, 8));
		
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 8, 4, 4));
	}
	
	@Override
	public int getBedrockHeight()
	{
		return 0;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		final int randInt = random.nextInt(100);
		if (randInt == 0)
		{
			// Gold Wood 1 %
			return getTreeGenForTree(random, GOLDWOOD, false);
		}
		else if (randInt < 20)
		{
			// Cloudroot 19 %
			return getTreeGenForTree(random, CLOUDROOT, false);
		}
		else
		{
			// Skybark 80 %
			return getTreeGenForTree(random, SKYBARK, false);
		}
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return new WorldGenRanged(ABlocks.plantBlocks, 0);
	}
	
	public static WorldGenAbstractTree getTreeGenForTree(Random random, int metadata, boolean update)
	{
		switch (metadata)
		{
		case SKYBARK:
			if (random.nextInt(10) == 0)
			{
				return AeriusGenBigTree.create(update, 20, SKYBARK);
			}
			else
			{
				return AeriusGenTree.create(update, 6, SKYBARK);
			}
		case DARK_SKYBARK:
			if (random.nextInt(10) == 0)
			{
				return AeriusGenBigTree.create(update, 20, DARK_SKYBARK);
			}
			else
			{
				return AeriusGenJungleTree.create(update, 7, DARK_SKYBARK);
			}
		case CLOUDROOT:
			if (random.nextInt(4) == 0)
			{
				return AeriusGenTree.create(update, 7, CLOUDROOT);
			}
			else
			{
				return AeriusGenFirTree.create(update, 7, CLOUDROOT);
			}
		case GOLDWOOD:
			return AeriusGenJungleTree.create(update, 10, GOLDWOOD);
		case MAGIC_OAK:
			return AeriusGenTree.create(update, 6, MAGIC_OAK);
		case WILLOW:
			return AeriusGenBigTree.create(update, 16, WILLOW);
		}
		return null;
	}
}
