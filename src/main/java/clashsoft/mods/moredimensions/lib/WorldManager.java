package clashsoft.mods.moredimensions.lib;

import java.util.Random;

import clashsoft.cslib.config.CSConfig;
import clashsoft.mods.moredimensions.world.biome.*;
import clashsoft.mods.moredimensions.world.gen.AeriusGenTemple;
import clashsoft.mods.moredimensions.world.provider.AeriusWorldProvider;
import clashsoft.mods.moredimensions.world.provider.POCWorldProvider;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class WorldManager
{
	public static BiomeGenBase	biomeHeaven;
	public static BiomeGenBase	biomeHeavenForest;
	public static BiomeGenBase	biomeHeavenJungle;
	
	public static BiomeGenBase	biomePOCPlains;
	public static BiomeGenBase	biomePOCMountains;
	public static BiomeGenBase	biomePOCDesert;
	public static BiomeGenBase	biomeBloodPlains;
	
	public static int			AERIUS_ID		= 8;
	public static int			POC_ID			= 9;
	public static int			DREAMS_ID		= 10;
	public static int			NIGHTMARES_ID	= 11;
	
	public static void load()
	{
		AERIUS_ID = CSConfig.getDimension("Aerius", 8);
		POC_ID = CSConfig.getDimension("Paradise of Chaos", 9);
		DREAMS_ID = CSConfig.getDimension("Dream", 10);
		NIGHTMARES_ID = CSConfig.getDimension("Nightmares", 11);
		
		// -- Biomes --
		
		biomeHeaven = new BiomeAerius(CSConfig.getBiome("Aerius", 60)).setBiomeName("Aerius");
		biomeHeavenForest = new BiomeAeriusForest(CSConfig.getBiome("Aerial Forest", 61)).setBiomeName("Aerial Forest");
		biomeHeavenJungle = new BiomeAeriusJungle(CSConfig.getBiome("Aerial Jungle", 62)).setBiomeName("Aerial Jungle");
		
		biomePOCPlains = new BiomePOCPlains(CSConfig.getBiome("Plains of Insanity", 70)).setBiomeName("Plains of Insanity");
		biomePOCMountains = new BiomePOCMountains(CSConfig.getBiome("Corrupted Mountains", 71)).setBiomeName("Corrupted Mountains");
		biomePOCDesert = new BiomePOCDesert(CSConfig.getBiome("Desert of Dryness", 72)).setBiomeName("Desert of Dryness");
		biomeBloodPlains = new BiomeBloodPlains(CSConfig.getBiome("Blood Plains", 73)).setBiomeName("Blood Plains");
		
		// -- Dimensions --
		
		// Aerius Dimension
		DimensionManager.registerProviderType(AERIUS_ID, AeriusWorldProvider.class, true);
		DimensionManager.registerDimension(AERIUS_ID, AERIUS_ID);
		
		// POC Dimension
		DimensionManager.registerProviderType(POC_ID, POCWorldProvider.class, true);
		DimensionManager.registerDimension(POC_ID, POC_ID);
		
		/*
		 * // Dreams Dimension DimensionManager.registerProviderType(DREAMS_ID,
		 * DreamWorldProvider.class, true);
		 * DimensionManager.registerDimension(DREAMS_ID, DREAMS_ID); //
		 * Nightmares Dimension
		 * DimensionManager.registerProviderType(NIGHTMARES_ID,
		 * NightmareWorldProvider.class, true);
		 * DimensionManager.registerDimension(NIGHTMARES_ID, NIGHTMARES_ID);
		 */
	}
	
	public static void generateAerius(World world, Random random, int chunkX, int chunkZ)
	{
		if (random.nextInt(64) == 0 && world.getBiomeGenForCoords(chunkX, chunkZ) == biomeHeaven)
		{
			new AeriusGenTemple(false).generate(world, random, chunkX, 96, chunkZ);
		}
	}
}
