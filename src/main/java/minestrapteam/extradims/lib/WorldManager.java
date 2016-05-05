package minestrapteam.extradims.lib;

import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extradims.biome.aerius.*;
import minestrapteam.extradims.biome.virtious.*;
import minestrapteam.extradims.lib.virtious.VBlocks;
import minestrapteam.extradims.world.WorldTypeTest;
import minestrapteam.extradims.world.aerius.WorldProviderAerius;
import minestrapteam.extradims.world.aerius.gen.AeriusGenClouds;
import minestrapteam.extradims.world.virtious.WorldProviderVirtious;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenAmberTree;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenDeepstone;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenMinable;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenVirtianTree;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

import java.util.Random;

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
	public static BiomeGenBase		biomeCorruption;

	public static BiomeGenBase[]	aeriusBiomes;
	
	public static void load()
	{
		testWorldType = new WorldTypeTest("test");
		
		VIRTIOUS_ID = ECConfig.getDimension("Virtious", VIRTIOUS_ID);
		AERIUS_ID = ECConfig.getDimension("Aerius", AERIUS_ID);
		POC_ID = ECConfig.getDimension("Paradise of Chaos", POC_ID);
		DREAMS_ID = ECConfig.getDimension("Dream", DREAMS_ID);
		NIGHTMARES_ID = ECConfig.getDimension("Nightmares", NIGHTMARES_ID);
		
		// -- Biomes --
		
		biomeVirtious = new BiomeGenVirtious(ECConfig.getBiome("Virtious", 50)).setBiomeName("Virtious");
		biomeCanyon = new BiomeGenCanyon(ECConfig.getBiome("Canyon", 51)).setBiomeName("Virtious Canyon");
		biomeWhiskerfield = new BiomeGenWhiskerfield(ECConfig.getBiome("Whiskerfield", 52)).setBiomeName("Whiskerfield");
		biomeVirtianMountain = new BiomeGenVirtianMountains(ECConfig.getBiome("Virtian Mountains", 53)).setBiomeName("Virtian Mountains");
		biomeGravelBeach = new BiomeGenGravelBeach(ECConfig.getBiome("Gravel Beach", 54)).setBiomeName("Gravel Beach");
		biomeVirtiousOcean = new BiomeGenVirtiousOcean(ECConfig.getBiome("Virtious Ocean", 55)).setBiomeName("Virtious Ocean");
		
		virtiousBiomes = new BiomeGenBase[] { biomeVirtious, biomeCanyon, biomeWhiskerfield, biomeGravelBeach, biomeVirtiousOcean };
		
		biomeAerius = new BiomeAerius(ECConfig.getBiome("Aerius", 60)).setBiomeName("Aerius");
		biomeAerianForest = new BiomeAeriusForest(ECConfig.getBiome("Aerian Forest", 61)).setBiomeName("Aerian Forest");
		biomeAerianJungle = new BiomeAeriusJungle(ECConfig.getBiome("Aerian Jungle", 62)).setBiomeName("Aerian Jungle");
		biomeHallow = new BiomeHallow(ECConfig.getBiome("Hallow", 63)).setBiomeName("Hallow");
		biomeCorruption = new BiomeCorruption(ECConfig.getBiome("Corruption", 64)).setBiomeName("Corruption");

		aeriusBiomes = new BiomeGenBase[] { biomeAerius, biomeAerianForest, biomeAerianJungle, biomeHallow, biomeCorruption };

		// -- Dimensions --
		
		// Virtious
		DimensionManager.registerProviderType(VIRTIOUS_ID, WorldProviderVirtious.class, true);
		DimensionManager.registerDimension(VIRTIOUS_ID, VIRTIOUS_ID);
		
		// Aerius
		DimensionManager.registerProviderType(AERIUS_ID, WorldProviderAerius.class, true);
		DimensionManager.registerDimension(AERIUS_ID, AERIUS_ID);
		
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
}
