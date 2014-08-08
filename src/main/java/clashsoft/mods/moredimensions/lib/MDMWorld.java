package clashsoft.mods.moredimensions.lib;

import java.util.Random;

import clashsoft.cslib.config.CSConfig;
import clashsoft.mods.moredimensions.world.biome.*;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenBuildings.HeavenGenBuilding1;
import clashsoft.mods.moredimensions.world.provider.HeavenWorldProvider;
import clashsoft.mods.moredimensions.world.provider.POCWorldProvider;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class MDMWorld
{
	public static BiomeGenBase	biomeHeaven;
	public static BiomeGenBase biomeHeavenForest;
	public static BiomeGenBase	biomeHeavenJungle;
	
	public static BiomeGenBase	biomePOCPlains;
	public static BiomeGenBase	biomePOCMountains;
	public static BiomeGenBase	biomePOCDesert;
	public static BiomeGenBase biomeBloodPlains;
	
	public static int			HEAVEN_ID		= 8;
	public static int			POC_ID			= 9;
	public static int			DREAMS_ID		= 10;
	public static int			NIGHTMARES_ID	= 11;
	
	public static void load()
	{
		HEAVEN_ID = CSConfig.getDimension("Heaven", 8);
		POC_ID = CSConfig.getDimension("Paradise of Chaos", 9);
		DREAMS_ID = CSConfig.getDimension("Dream", 10);
		NIGHTMARES_ID = CSConfig.getDimension("Nightmares", 11);
		
		// -- Biomes --
		
		biomeHeaven = new BiomeHeaven(CSConfig.getBiome("Heaven", 60)).setBiomeName("Heaven");
		biomeHeavenForest = new BiomeHeavenForest(CSConfig.getBiome("Heaven Forest", 61)).setBiomeName("Heaven Forest");
		biomeHeavenJungle = new BiomeHeavenJungle(CSConfig.getBiome("Heaven Jungle", 62)).setBiomeName("Heaven Jungle");
		
		biomePOCPlains = new BiomePOCPlains(CSConfig.getBiome("Plains of Insanity", 70)).setBiomeName("Plains of Insanity");
		biomePOCMountains = new BiomePOCMountains(CSConfig.getBiome("Corrupted Mountains", 71)).setBiomeName("Corrupted Mountains");
		biomePOCDesert = new BiomePOCDesert(CSConfig.getBiome("Desert of Dryness", 72)).setBiomeName("Desert of Dryness");
		biomeBloodPlains = new BiomeBloodPlains(CSConfig.getBiome("Blood Plains", 73)).setBiomeName("Blood Plains");
		
		// -- Dimensions --
		
		// Heaven Dimension
		DimensionManager.registerProviderType(HEAVEN_ID, HeavenWorldProvider.class, true);
		DimensionManager.registerDimension(HEAVEN_ID, HEAVEN_ID);
		
		// POC Dimension
		DimensionManager.registerProviderType(POC_ID, POCWorldProvider.class, true);
		DimensionManager.registerDimension(POC_ID, POC_ID);
		
		/*
		// Dreams Dimension
		DimensionManager.registerProviderType(DREAMS_ID, DreamWorldProvider.class, true);
		DimensionManager.registerDimension(DREAMS_ID, DREAMS_ID);
		// Nightmares Dimension
		DimensionManager.registerProviderType(NIGHTMARES_ID, NightmareWorldProvider.class, true);
		DimensionManager.registerDimension(NIGHTMARES_ID, NIGHTMARES_ID);
		*/
	}
	
	public static void generateHeaven(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 5; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new HeavenGenBuilding1()).generate(world, rand, randPosX, randPosZ, randPosY);
		}
	}
}
