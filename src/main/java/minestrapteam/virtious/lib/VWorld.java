package minestrapteam.virtious.lib;

import clashsoft.cslib.config.CSConfig;
import minestrapteam.virtious.biome.*;
import minestrapteam.virtious.world.VirtiousWorldProvider;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class VWorld
{
	public static int				dimensionID				= DimensionManager.getNextFreeDimId();
	
	public static int				virtiousBiomeID			= 25;
	public static int				canyonBiomeID			= 26;
	public static int				whiskerfieldBiomeID		= 27;
	public static int				virtianMountainBiomeID	= 28;
	public static int				gravelBeachBiomeID		= 29;
	public static int				virtiousOceanID			= 30;
	
	public static BiomeGenBase		virtiousBiome;
	public static BiomeGenBase		canyonBiome;
	public static BiomeGenBase		whiskerfieldBiome;
	public static BiomeGenBase		virtianMontainBiome;
	public static BiomeGenBase		gravelBeachBiome;
	public static BiomeGenBase		virtiousOceanBiome;
	
	public static BiomeGenBase[]	biomes;
	
	public static void readConfig()
	{
		dimensionID = CSConfig.getDimension("Virtious Dimension ID", dimensionID);
		
		virtiousBiomeID = CSConfig.getBiome("Virtious", virtiousBiomeID);
		canyonBiomeID = CSConfig.getBiome("Canyon", canyonBiomeID);
		whiskerfieldBiomeID = CSConfig.getBiome("Whiskerfield", whiskerfieldBiomeID);
		virtianMountainBiomeID = CSConfig.getBiome("Virtian Mountain", virtianMountainBiomeID);
		gravelBeachBiomeID = CSConfig.getBiome("Gravel Beach", gravelBeachBiomeID);
		virtiousOceanID = CSConfig.getBiome("Virtious Ocean", virtiousOceanID);
	}
	
	public static void load()
	{
		DimensionManager.registerProviderType(dimensionID, VirtiousWorldProvider.class, true);
		DimensionManager.registerDimension(dimensionID, dimensionID);
		
		virtiousBiome = new BiomeGenVirtious(virtiousBiomeID).setBiomeName("Virtious");
		canyonBiome = new BiomeGenCanyon(canyonBiomeID).setBiomeName("Virtious Canyon");
		whiskerfieldBiome = new BiomeGenWhiskerfield(whiskerfieldBiomeID).setBiomeName("Whiskerfield");
		virtianMontainBiome = new BiomeGenVirtious(virtianMountainBiomeID).setBiomeName("Virtian Mountains");
		gravelBeachBiome = new BiomeGenGravelBeach(canyonBiomeID).setBiomeName("Gravel Beach");
		virtiousOceanBiome = new BiomeGenVirtiousOcean(virtiousOceanID).setBiomeName("Virtious Ocean");
		
		biomes = new BiomeGenBase[] { virtiousBiome, canyonBiome, whiskerfieldBiome, gravelBeachBiome, virtiousOceanBiome };
	}
}
