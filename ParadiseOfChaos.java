package com.chaosdev.paradiseofchaos;

import clashsoft.mods.moredimensions.addons.*;

import com.chaosdev.paradiseofchaos.addons.*;
import com.chaosdev.paradiseofchaos.common.CommonProxy;
import com.chaosdev.paradiseofchaos.dreams.dim.WorldProviderDreams;
import com.chaosdev.paradiseofchaos.dreams.dim.WorldProviderNightmares;
import com.chaosdev.paradiseofchaos.entity.boss.EntityLich;
import com.chaosdev.paradiseofchaos.lib.*;
import com.chaosdev.paradiseofchaos.world.biome.BiomeCorruptedMountains;
import com.chaosdev.paradiseofchaos.world.biome.BiomeDesertOfDryness;
import com.chaosdev.paradiseofchaos.world.biome.BiomePlainsOfInsanity;
import com.chaosdev.paradiseofchaos.world.dim.WorldProviderPOC;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = POCConstants.MOD_ID, name = POCConstants.MOD_NAME, version = POCConstants.VERSION)
@NetworkMod(channels = { POCConstants.CHANNEL_NAME, POCEntityProperties.CHANNEL }, serverSideRequired = false, clientSideRequired = true, packetHandler = POCPacketHandler.class)
@POCModPart(modPartId = "POCMain")
public class ParadiseOfChaos
{
	@Instance(POCConstants.MOD_ID)
	public static ParadiseOfChaos	instance;
	
	@SidedProxy(clientSide = POCConstants.CLIENT_PROXY_LOCATION, serverSide = POCConstants.COMMON_PROXY_LOCATION)
	public static CommonProxy		proxy;
	
	public static POCPacketHandler		packetHandler;
	
	public static BiomeGenBase		PlainsOfInsanityBiome;
	public static BiomeGenBase		CorruptedMountainsBiome;
	public static BiomeGenBase		DesertOfDrynessBiome;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		POCConfig.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{	
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		packetHandler = new POCPacketHandler();
		packetHandler.registerChannels();
		
		POCItems.loadItems();
		POCBlocks.loadBlocks();
		
		POCLanguage.addLocalizations();
				
		POCRecipes.addRecipes();
		
		// **********
		// * Events *
		// **********
		
		MinecraftForge.EVENT_BUS.register(new POCEvents());
		proxy.registerClientEvents();
		
		// ***********
		// * Entitys *
		// ***********
		
		// Lich Entity
		EntityRegistry.registerGlobalEntityID(EntityLich.class, "POCBossLich", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0xEEEEEE);
		LanguageRegistry.instance().addStringLocalization("entity.POCBossLich.name", "Lich");
		
		proxy.registerEntityRenderers();
		
		EntityRegistry.addSpawn(EntityLich.class, 100, 1, 10, EnumCreatureType.creature);
		
		// ***************
		// * World Stuff *
		// ***************
		
		// Plains of Insanity Biome
		PlainsOfInsanityBiome = new BiomePlainsOfInsanity(150).setBiomeName("Plains Of Insanity");
		
		// Corrupted Mountains Biome
		CorruptedMountainsBiome = new BiomeCorruptedMountains(151).setBiomeName("Corrupted Mountains");
		
		// Ocean Biome
		DesertOfDrynessBiome = new BiomeDesertOfDryness(152).setBiomeName("Desert Of Dryness");
		
		// POC Dimension
		DimensionManager.registerProviderType(POCConfig.POC_DIMENSION_ID, WorldProviderPOC.class, true);
		DimensionManager.registerDimension(POCConfig.POC_DIMENSION_ID, POCConfig.POC_DIMENSION_ID);
		
		// Dreams Dimension
		DimensionManager.registerProviderType(POCConfig.DREAMS_DIMENSION_ID, WorldProviderDreams.class, true);
		DimensionManager.registerDimension(POCConfig.DREAMS_DIMENSION_ID, POCConfig.DREAMS_DIMENSION_ID);
		
		// Nightmares Dimension
		DimensionManager.registerProviderType(POCConfig.NIGHTMARES_DIMENSION_ID, WorldProviderNightmares.class, true);
		DimensionManager.registerDimension(POCConfig.NIGHTMARES_DIMENSION_ID, POCConfig.NIGHTMARES_DIMENSION_ID);
		
		// ************************
		// * Renderer registering *
		// ************************
		
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postRegisterRenderers();
	}
}