package clashsoft.mods.moredimensions;

import java.util.Random;

import clashsoft.clashsoftapi.util.CSUpdate;
import clashsoft.mods.moredimensions.addons.*;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.handlers.MDMEventHandler;
import clashsoft.mods.moredimensions.handlers.MDMPacketHandler;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenBuildings;
import clashsoft.mods.moredimensions.world.gen.poc.MDMGenTrees;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "MoreDimensionsMod", name = "More Dimensions Mod", version = MoreDimensionsMod.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreDimensionsMod
{
	public static final int			REVISION	= 0;
	public static final String		VERSION		= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	@Instance("MoreDimensionsMod")
	public static MoreDimensionsMod	instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moredimensions.client.MDMClientProxy", serverSide = "clashsoft.mods.moredimensions.common.MDMCommonProxy")
	public static MDMCommonProxy	proxy;
	
	public static MDMPacketHandler	packetHandler;
	public static MDMEventHandler	eventHandler;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MDMConfig.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		eventHandler = new MDMEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		packetHandler = new MDMPacketHandler();
		packetHandler.registerChannels();
		
		MDMBlocks.initialize();
		MDMItems.initialize();
		MDMBlocks.load();
		MDMItems.load();
		
		MDMEntitys.load();
		MDMRecipes.load();
		MDMWorld.load();
		MDMLocalizations.load();
		MDMInventory.load();
		
		proxy.registerRenderers();
		proxy.registerEntityRenderers();
		proxy.registerClientEvents();
		proxy.postRegisterRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MDMConfig.saveConfig();
	}
	
	public static void generateHeaven(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MDMGenTrees(true, 6, MDMBlocks.heavenLog.blockID, MDMBlocks.heavenLeaves.blockID, 0, 0, false)).generate(world, rand, randPosX, randPosY, randPosZ);
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