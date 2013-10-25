package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.dreams.dim.WorldProviderDreams;
import clashsoft.mods.moredimensions.dreams.dim.WorldProviderNightmares;
import clashsoft.mods.moredimensions.world.WorldProviderHeaven;
import clashsoft.mods.moredimensions.world.biome.BiomeCorruptedMountains;
import clashsoft.mods.moredimensions.world.biome.BiomeDesertOfDryness;
import clashsoft.mods.moredimensions.world.biome.BiomePlainsOfInsanity;
import clashsoft.mods.moredimensions.world.dim.WorldProviderPOC;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

@Addon(modName = "MoreDimensionsMod", addonName = "World")
public class MDMWorld
{
	public static BiomeGenBase	PlainsOfInsanityBiome;
	public static BiomeGenBase	CorruptedMountainsBiome;
	public static BiomeGenBase	DesertOfDrynessBiome;
	public static int			HEAVEN_ID		= DimensionManager.getNextFreeDimId();
	public static int			HEAVEN_BIOME_ID	= 30;
	
	public static void load()
	{
		// -- Biomes --
		PlainsOfInsanityBiome = new BiomePlainsOfInsanity(150).setBiomeName("Plains Of Insanity");
		CorruptedMountainsBiome = new BiomeCorruptedMountains(151).setBiomeName("Corrupted Mountains");
		DesertOfDrynessBiome = new BiomeDesertOfDryness(152).setBiomeName("Desert Of Dryness");
		
		// -- Dimensions --
		
		//Heaven Dimension
		DimensionManager.registerProviderType(HEAVEN_ID, WorldProviderHeaven.class, true);
		DimensionManager.registerDimension(HEAVEN_ID, HEAVEN_ID);
		// POC Dimension
		DimensionManager.registerProviderType(MDMConfig.POC_DIMENSION_ID, WorldProviderPOC.class, true);
		DimensionManager.registerDimension(MDMConfig.POC_DIMENSION_ID, MDMConfig.POC_DIMENSION_ID);
		// Dreams Dimension
		DimensionManager.registerProviderType(MDMConfig.DREAMS_DIMENSION_ID, WorldProviderDreams.class, true);
		DimensionManager.registerDimension(MDMConfig.DREAMS_DIMENSION_ID, MDMConfig.DREAMS_DIMENSION_ID);
		// Nightmares Dimension
		DimensionManager.registerProviderType(MDMConfig.NIGHTMARES_DIMENSION_ID, WorldProviderNightmares.class, true);
		DimensionManager.registerDimension(MDMConfig.NIGHTMARES_DIMENSION_ID, MDMConfig.NIGHTMARES_DIMENSION_ID);
	}
}
