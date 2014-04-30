package clashsoft.mods.moredimensions.addons;

import java.util.Random;

import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.cslib.minecraft.world.gen.CustomTreeGen;
import clashsoft.mods.moredimensions.world.biome.*;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenBuildings;
import clashsoft.mods.moredimensions.world.providers.DreamWorldProvider;
import clashsoft.mods.moredimensions.world.providers.HeavenWorldProvider;
import clashsoft.mods.moredimensions.world.providers.NightmareWorldProvider;
import clashsoft.mods.moredimensions.world.providers.POCWorldProvider;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class MDMWorld
{
	public static BiomeGenBase	biomeHeaven;
	public static BiomeGenBase	biomeHeavenJungle;
	public static BiomeGenBase	biomePOCPlains;
	public static BiomeGenBase	biomePOCMountains;
	public static BiomeGenBase	biomePOCDesert;
	
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
		
		biomeHeaven = new BiomeHeaven(CSConfig.getBiome("Heaven", 149)).setBiomeName("Heaven");
		biomeHeavenJungle = new BiomeHeavenJungle(CSConfig.getBiome("HeavenJungle", 153)).setBiomeName("HeavenJungle");
		
		biomePOCPlains = new BiomePlainsOfInsanity(CSConfig.getBiome("Plains of Insanity", 150)).setBiomeName("POC Plains");
		biomePOCMountains = new BiomeCorruptedMountains(CSConfig.getBiome("Corrupted Mountains", 151)).setBiomeName("POC Mountains");
		biomePOCDesert = new BiomeDesertOfDryness(CSConfig.getBiome("Desert of Dryness", 152)).setBiomeName("POC Desert");
		
		// -- Dimensions --
		
		// Heaven Dimension
		DimensionManager.registerProviderType(HEAVEN_ID, HeavenWorldProvider.class, true);
		DimensionManager.registerDimension(HEAVEN_ID, HEAVEN_ID);
		// POC Dimension
		DimensionManager.registerProviderType(POC_ID, POCWorldProvider.class, true);
		DimensionManager.registerDimension(POC_ID, POC_ID);
		// Dreams Dimension
		DimensionManager.registerProviderType(DREAMS_ID, DreamWorldProvider.class, true);
		DimensionManager.registerDimension(DREAMS_ID, DREAMS_ID);
		// Nightmares Dimension
		DimensionManager.registerProviderType(NIGHTMARES_ID, NightmareWorldProvider.class, true);
		DimensionManager.registerDimension(NIGHTMARES_ID, NIGHTMARES_ID);
	}
	
	public static void generateHeaven(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new CustomTreeGen(true, 6, Heaven.heavenLogs, Heaven.heavenLeaves, 0, 0, false)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
		for (int i = 0; i < 5; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new HeavenGenBuildings().new HeavenGenBuilding1()).generate(world, rand, randPosX, randPosZ, randPosY);
		}
	}
}
