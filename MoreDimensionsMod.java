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
@NetworkMod(channels = { "MDM", "MDMHeaven" }, packetHandler = MDMPacketHandler.class, clientSideRequired = true, serverSideRequired = false)
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
		long l0 = System.nanoTime();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		eventHandler = new MDMEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		packetHandler = new MDMPacketHandler();
		packetHandler.registerChannels();
		
		long l1 = System.nanoTime();
		MDMBlocks.initialize();
		long l2 = System.nanoTime();
		MDMItems.initialize();
		long l3 = System.nanoTime();
		MDMTools.initialize();
		
		long l4 = System.nanoTime();
		MDMBlocks.load();
		long l5 = System.nanoTime();
		MDMItems.load();
		long l6 = System.nanoTime();
		MDMTools.load();
		
		long l7 = System.nanoTime();
		MDMEntitys.load();
		long l8 = System.nanoTime();
		MDMRecipes.load();
		long l9 = System.nanoTime();
		MDMWorld.load();
		long l10 = System.nanoTime();
		MDMInventory.load();
		long l11 = System.nanoTime();
		MDMLocalizations.load();
		
		long l12 = System.nanoTime();
		proxy.registerRenderers();
		proxy.registerEntityRenderers();
		proxy.registerClientEvents();
		proxy.postRegisterRenderers();
		long l13 = System.nanoTime();
		
		System.out.println(String.format("[MoreDimensionsMod] Loading times: Init:%.4fs; Blocks{init}:%.4fs; Items{init}:%.4fs; Tools{init}:%.4fs; Blocks{load}:%.4fs; Items{load}:%.4fs; Tools{load}:%.4fs; Entitys:%.4fs; Recipes:%.4fs; World:%.4fs; Inventory:%.4fs; Localizations:%.4fs; Proxy:%.4fs", (double)(l1 - l0) / 1000000000D, (double)(l2 - l1) / 1000000000D, (double)(l3 - l2) / 1000000000D, (double)(l4 - l3) / 1000000000D, (double)(l5 - l4) / 1000000000D, (double)(l6 - l5) / 1000000000D, (double)(l7 - l6) / 1000000000D, (double)(l8 - l7) / 1000000000D, (double)(l9 - l8) / 1000000000D, (double)(l10 - l9) / 1000000000D, (double)(l11 - l10) / 1000000000D, (double)(l12 - l11) / 1000000000D, (double)(l13 - l12) / 1000000000D));
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MDMConfig.saveConfig();
	}
}