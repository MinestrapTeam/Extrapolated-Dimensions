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
import minestrapteam.extradims.biome.virtious.*;
import minestrapteam.extradims.lib.virtious.VBlocks;
import minestrapteam.extradims.world.WorldTypeTest;
import minestrapteam.extradims.world.aerius.WorldProviderAerius;
import minestrapteam.extradims.world.aerius.gen.AeriusGenClouds;
import minestrapteam.extradims.world.aerius.gen.AeriusGenTemple;
import minestrapteam.extradims.world.poc.WorldProviderPOC;
import minestrapteam.extradims.world.virtious.WorldProviderVirtious;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenAmberTree;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenDeepstone;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenMinable;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenVirtianTree;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class WorldManager
{
	public static WorldType			testWorldType;
	
	public static int				VIRTIOUS_ID		= 7;
	public static int				AERIUS_ID		= 8;
	public static int				POC_ID			= 9;
	public static int				DREAMS_ID		= 10;
	public static int				NIGHTMARES_ID	= 11;
	
	public static BiomeGenBase		biomeVirtious;
	public static BiomeGenBase		biomeCanyon;
	public static BiomeGenBase		biomeWhiskerfield;
	public static BiomeGenBase		biomeVirtianMountain;
	public static BiomeGenBase		biomeGravelBeach;
	public static BiomeGenBase		biomeVirtiousOcean;
	
	public static BiomeGenBase[]	virtiousBiomes;
	
	public static BiomeGenBase		biomeAerius;
	public static BiomeGenBase		biomeAerianForest;
	public static BiomeGenBase		biomeAerianJungle;
	public static BiomeGenBase		biomeHallow;
	
	public static BiomeGenBase[]	aeriusBiomes;
	
	public static BiomeGenBase		biomePOCPlains;
	public static BiomeGenBase		biomePOCMountains;
	public static BiomeGenBase		biomePOCDesert;
	public static BiomeGenBase		biomeBloodPlains;
	
	public static BiomeGenBase[]	pocBiomes;
	
	public static void load()
	{
		testWorldType = new WorldTypeTest("test");
		
		VIRTIOUS_ID = CSConfig.getDimension("Virtious", VIRTIOUS_ID);
		AERIUS_ID = CSConfig.getDimension("Aerius", AERIUS_ID);
		POC_ID = CSConfig.getDimension("Paradise of Chaos", POC_ID);
		DREAMS_ID = CSConfig.getDimension("Dream", DREAMS_ID);
		NIGHTMARES_ID = CSConfig.getDimension("Nightmares", NIGHTMARES_ID);
		
		// -- Biomes --
		
		biomeVirtious = new BiomeGenVirtious(CSConfig.getBiome("Virtious", 50)).setBiomeName("Virtious");
		biomeCanyon = new BiomeGenCanyon(CSConfig.getBiome("Canyon", 51)).setBiomeName("Virtious Canyon");
		biomeWhiskerfield = new BiomeGenWhiskerfield(CSConfig.getBiome("Whiskerfield", 52)).setBiomeName("Whiskerfield");
		biomeVirtianMountain = new BiomeGenVirtianMountains(CSConfig.getBiome("Virtian Mountains", 53)).setBiomeName("Virtian Mountains");
		biomeGravelBeach = new BiomeGenGravelBeach(CSConfig.getBiome("Gravel Beach", 54)).setBiomeName("Gravel Beach");
		biomeVirtiousOcean = new BiomeGenVirtiousOcean(CSConfig.getBiome("Virtious Ocean", 55)).setBiomeName("Virtious Ocean");
		
		virtiousBiomes = new BiomeGenBase[] { biomeVirtious, biomeCanyon, biomeWhiskerfield, biomeGravelBeach, biomeVirtiousOcean };
		
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
		
		// Virtious
		DimensionManager.registerProviderType(VIRTIOUS_ID, WorldProviderVirtious.class, true);
		DimensionManager.registerDimension(VIRTIOUS_ID, VIRTIOUS_ID);
		
		// Aerius
		DimensionManager.registerProviderType(AERIUS_ID, WorldProviderAerius.class, true);
		DimensionManager.registerDimension(AERIUS_ID, AERIUS_ID);
		
		// POC
		DimensionManager.registerProviderType(POC_ID, WorldProviderPOC.class, true);
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
	
	public static void generateVirtious(World world, Random random, int chunkX, int chunkZ)
	{
		// Tak Ore
		for (int l = 0; l < 15; l++)
		{
			new VirtiousGenMinable(VBlocks.tak_ore, 9).generate(world, random, chunkX + random.nextInt(16), random.nextInt(64), chunkZ + random.nextInt(16));
		}
		
		// VIron
		for (int l = 0; l < 10; l++)
		{
			new VirtiousGenMinable(VBlocks.virtian_iron_ore, 8).generate(world, random, chunkX + random.nextInt(16), random.nextInt(63), chunkZ + random.nextInt(16));
		}
		
		// Brazeum
		for (int l = 0; l < 9; l++)
		{
			new VirtiousGenDeepstone(VBlocks.brazeum_ore, 8).generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}
		
		// Aquieus
		for (int l = 0; l < 7; l++)
		{
			new VirtiousGenDeepstone(VBlocks.aquieus_ore, 6).generate(world, random, chunkX + random.nextInt(16), random.nextInt(32), chunkZ + random.nextInt(16));
		}
		
		// Pluthorium
		for (int l = 0; l < 2; l++)
		{
			new VirtiousGenDeepstone(VBlocks.pluthorium_ore, 6).generate(world, random, chunkX + random.nextInt(16), random.nextInt(16), chunkZ + random.nextInt(16));
		}
		
		// Illuminous
		for (int l = 0; l < 11; l++)
		{
			new VirtiousGenMinable(VBlocks.illuminous_ore, 7).generate(world, random, chunkX + random.nextInt(16), random.nextInt(64), chunkZ + random.nextInt(16));
		}
		
		// Deep Illuminous
		for (int l = 0; l < 11; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_illuminous_ore, 7).generate(world, random, chunkX + random.nextInt(16), random.nextInt(64), chunkZ + random.nextInt(16));
		}
		
		// Deep Tak
		for (int l = 0; l < 15; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_tak_ore, 9).generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}
		
		// Deep Tak
		for (int l = 0; l < 10; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_iron_ore, 8).generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}
		
		// Deep Tak
		for (int l = 0; l < 9; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deepstone_mossy, 8).generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}
		
		VirtiousGenVirtianTree treeVirtian = new VirtiousGenVirtianTree(false);
		VirtiousGenAmberTree treeAmber = new VirtiousGenAmberTree(false);
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
		
		if (biome instanceof BiomeGenVirtious)
		{
			
			int Xcoord = chunkX + random.nextInt(16);
			int Zcoord = chunkZ + random.nextInt(16);
			int i = world.getHeightValue(Xcoord, Zcoord);
			if (random.nextInt(2) == 1)
			{
				treeVirtian.generate(world, random, Xcoord, i, Zcoord);
			}
			else
			{
				treeAmber.generate(world, random, Xcoord, i, Zcoord);
			}
		}
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
