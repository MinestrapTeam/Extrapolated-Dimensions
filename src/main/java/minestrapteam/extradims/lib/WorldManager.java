package minestrapteam.extradims.lib;

import java.util.Random;

import clashsoft.cslib.config.CSConfig;
import minestrapteam.extradims.biome.aerius.BiomeAerius;
import minestrapteam.extradims.biome.aerius.BiomeAeriusForest;
import minestrapteam.extradims.biome.aerius.BiomeAeriusJungle;
import minestrapteam.extradims.biome.aerius.BiomeHallow;
import minestrapteam.extradims.biome.poc.BiomeBloodPlains;
import minestrapteam.extradims.biome.poc.BiomePOCDesert;
import minestrapteam.extradims.biome.poc.BiomePOCMountains;
import minestrapteam.extradims.biome.poc.BiomePOCPlains;
import minestrapteam.extradims.world.aerius.WorldProviderAerius;
import minestrapteam.extradims.world.aerius.gen.AeriusGenClouds;
import minestrapteam.extradims.world.aerius.gen.AeriusGenTemple;
import minestrapteam.extradims.world.poc.POCWorldProvider;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class WorldManager
{
	public static BiomeGenBase		biomeAerius;
	public static BiomeGenBase		biomeAerianForest;
	public static BiomeGenBase		biomeAerianJungle;
	public static BiomeGenBase biomeHallow;
	
	public static BiomeGenBase[]	aeriusBiomes;
	
	public static BiomeGenBase		biomePOCPlains;
	public static BiomeGenBase		biomePOCMountains;
	public static BiomeGenBase		biomePOCDesert;
	public static BiomeGenBase		biomeBloodPlains;
	
	public static BiomeGenBase[]	pocBiomes;
	
	public static int				AERIUS_ID		= 8;
	public static int				POC_ID			= 9;
	public static int				DREAMS_ID		= 10;
	public static int				NIGHTMARES_ID	= 11;
	
	public static void load()
	{
		AERIUS_ID = CSConfig.getDimension("Aerius", 8);
		POC_ID = CSConfig.getDimension("Paradise of Chaos", 9);
		DREAMS_ID = CSConfig.getDimension("Dream", 10);
		NIGHTMARES_ID = CSConfig.getDimension("Nightmares", 11);
		
		// -- Biomes --
		
		biomeAerius = new BiomeAerius(CSConfig.getBiome("Aerius", 60)).setBiomeName("Aerius");
		biomeAerianForest = new BiomeAeriusForest(CSConfig.getBiome("Aerian Forest", 61)).setBiomeName("Aerian Forest");
		biomeAerianJungle = new BiomeAeriusJungle(CSConfig.getBiome("Aerian Jungle", 62)).setBiomeName("Aerian Jungle");
		biomeHallow = new BiomeHallow(CSConfig.getBiome("Hallow", 63)).setBiomeName("Hallow");
		
		aeriusBiomes = new BiomeGenBase[] { biomeAerius, biomeAerianForest, biomeAerianJungle, biomeHallow };
		
		biomePOCPlains = new BiomePOCPlains(CSConfig.getBiome("Plains of Insanity", 70)).setBiomeName("Plains of Insanity");
		biomePOCMountains = new BiomePOCMountains(CSConfig.getBiome("Corrupted Mountains", 71)).setBiomeName("Corrupted Mountains");
		biomePOCDesert = new BiomePOCDesert(CSConfig.getBiome("Desert of Dryness", 72)).setBiomeName("Desert of Dryness");
		biomeBloodPlains = new BiomeBloodPlains(CSConfig.getBiome("Blood Plains", 73)).setBiomeName("Blood Plains");
		
		pocBiomes = new BiomeGenBase[] { biomePOCPlains, biomePOCMountains, biomePOCDesert, biomeBloodPlains };
		
		// -- Dimensions --
		
		// Aerius Dimension
		DimensionManager.registerProviderType(AERIUS_ID, WorldProviderAerius.class, true);
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
		BiomeGenBase biome = world.getBiomeGenForCoords(chunkX, chunkZ);
		if (random.nextInt(64) == 0 && biome == biomeAerius)
		{
			new AeriusGenTemple(false).generate(world, random, chunkX, 96, chunkZ);
		}
		
		int x = chunkX + random.nextInt(16);
		int y = 64 + random.nextInt(128);
		int z = chunkZ + random.nextInt(16);
		
		int count = 10 + random.nextInt(5);
		boolean flat = random.nextInt(8) == 0;
		new AeriusGenClouds(false, count, Aerius.cloud, Aerius.cloud.getRandomType(random), flat).generate(world, random, x, y, z);
	}
}
