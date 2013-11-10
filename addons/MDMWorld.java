package clashsoft.mods.moredimensions.addons;

import java.util.Random;

import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.world.biome.BiomeCorruptedMountains;
import clashsoft.mods.moredimensions.world.biome.BiomeDesertOfDryness;
import clashsoft.mods.moredimensions.world.biome.BiomeHeaven;
import clashsoft.mods.moredimensions.world.biome.BiomePlainsOfInsanity;
import clashsoft.mods.moredimensions.world.gen.MDMGenTrees;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenBuildings;
import clashsoft.mods.moredimensions.world.providers.WorldProviderDreams;
import clashsoft.mods.moredimensions.world.providers.WorldProviderHeaven;
import clashsoft.mods.moredimensions.world.providers.WorldProviderNightmares;
import clashsoft.mods.moredimensions.world.providers.WorldProviderPOC;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

@Addon(modName = "MoreDimensionsMod", addonName = "World")
public class MDMWorld
{
	public static BiomeGenBase	biomeHeaven;
	public static BiomeGenBase	biomePOCPlains;
	public static BiomeGenBase	biomePOCMountains;
	public static BiomeGenBase	biomePOCDesert;
	
	public static int			HEAVEN_ID		= 8;
	public static int			POC_ID			= 9;
	public static int			DREAMS_ID		= 10;
	public static int			NIGHTMARES_ID	= 11;
	
	public static void load()
	{
		HEAVEN_ID = MDMConfig.getDimension("Heaven", 8);
		POC_ID = MDMConfig.getDimension("Paradise of Chaos", 9);
		DREAMS_ID = MDMConfig.getDimension("Dream", 10);
		NIGHTMARES_ID = MDMConfig.getDimension("Nightmares", 11);
		
		// -- Biomes --
		
		biomeHeaven = new BiomeHeaven(MDMConfig.getBiome("Heaven", 149));
		biomePOCPlains = new BiomePlainsOfInsanity(MDMConfig.getBiome("Plains of Insanity", 150)).setBiomeName("POC Plains");
		biomePOCMountains = new BiomeCorruptedMountains(MDMConfig.getBiome("Corrupted Mountains", 151)).setBiomeName("POC Mountains");
		biomePOCDesert = new BiomeDesertOfDryness(MDMConfig.getBiome("Desert of Dryness", 152)).setBiomeName("POC Desert");
		
		// -- Dimensions --
		
		// Heaven Dimension
		DimensionManager.registerProviderType(HEAVEN_ID, WorldProviderHeaven.class, true);
		DimensionManager.registerDimension(HEAVEN_ID, HEAVEN_ID);
		// POC Dimension
		DimensionManager.registerProviderType(POC_ID, WorldProviderPOC.class, true);
		DimensionManager.registerDimension(POC_ID, POC_ID);
		// Dreams Dimension
		DimensionManager.registerProviderType(DREAMS_ID, WorldProviderDreams.class, true);
		DimensionManager.registerDimension(DREAMS_ID, DREAMS_ID);
		// Nightmares Dimension
		DimensionManager.registerProviderType(NIGHTMARES_ID, WorldProviderNightmares.class, true);
		DimensionManager.registerDimension(NIGHTMARES_ID, NIGHTMARES_ID);
	}
	

	public static void generateHeaven(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MDMGenTrees(true, 6, MDMBlocks.heavenLogs.blockID, MDMBlocks.heavenLeaves.blockID, 0, 0, false)).generate(world, rand, randPosX, randPosY, randPosZ);
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
