package clashsoft.mods.moredimensions;

import clashsoft.clashsoftapi.util.CSUpdate;
import clashsoft.mods.moredimensions.addons.*;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.handlers.MDMEventHandler;
import clashsoft.mods.moredimensions.handlers.MDMPacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

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
		MDMTools.initialize();
		
		MDMBlocks.load();
		MDMItems.load();
		MDMTools.load();
		
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
}