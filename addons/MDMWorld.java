package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.world.biome.BiomeCorruptedMountains;
import clashsoft.mods.moredimensions.world.biome.BiomeDesertOfDryness;
import clashsoft.mods.moredimensions.world.biome.BiomeHeaven;
import clashsoft.mods.moredimensions.world.biome.BiomePlainsOfInsanity;
import clashsoft.mods.moredimensions.world.providers.WorldProviderDreams;
import clashsoft.mods.moredimensions.world.providers.WorldProviderHeaven;
import clashsoft.mods.moredimensions.world.providers.WorldProviderNightmares;
import clashsoft.mods.moredimensions.world.providers.WorldProviderPOC;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

@Addon(modName = "MoreDimensionsMod", addonName = "World")
public class MDMWorld
{
	public static BiomeGenBase	HeavenBiome;
	public static BiomeGenBase	PlainsOfInsanityBiome;
	public static BiomeGenBase	CorruptedMountainsBiome;
	public static BiomeGenBase	DesertOfDrynessBiome;
	
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
		
		HeavenBiome = new BiomeHeaven(MDMConfig.getBiome("Heaven", 149));
		PlainsOfInsanityBiome = new BiomePlainsOfInsanity(MDMConfig.getBiome("Plains of Insanity", 150)).setBiomeName("Plains Of Insanity");
		CorruptedMountainsBiome = new BiomeCorruptedMountains(MDMConfig.getBiome("Corrupted Mountains", 151)).setBiomeName("Corrupted Mountains");
		DesertOfDrynessBiome = new BiomeDesertOfDryness(MDMConfig.getBiome("Desert of Dryness", 152)).setBiomeName("Desert Of Dryness");
		
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
}
