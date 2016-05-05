package minestrapteam.extradims;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extracore.init.BaseMod;
import minestrapteam.extradims.common.EDEventHandler;
import minestrapteam.extradims.common.EDFuelHandler;
import minestrapteam.extradims.common.EDProxy;
import minestrapteam.extradims.lib.*;
import minestrapteam.extradims.network.EDNetHandler;

import java.util.Arrays;

@Mod(modid = ExtraDimensions.MODID, name = ExtraDimensions.NAME, version = ExtraDimensions.VERSION)
public class ExtraDimensions extends BaseMod
{
	public static final String		MODID	= "extradims";
	public static final String		NAME	= "Extrapolated Dimensions";
	public static final String		ACRONYM	= "ed";
	public static final String		VERSION	= "1.7.10-0.0.2";
	
	@Instance(MODID)
	public static ExtraDimensions	instance;
	
	public static EDProxy			proxy	= createProxy("minestrapteam.extradims.client.EDClientProxy", "minestrapteam.extradims.common.EDProxy");
	
	public ExtraDimensions()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.authors = Arrays.asList("Clashsoft", "Delocuro", "Werty1124", "SoBiohazardous");
		this.eventHandler = new EDEventHandler();
		this.netHandlerClass = EDNetHandler.class;
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		ECConfig.loadConfig(this.configFile);
		
		Virtious.init();
		Aerius.init();
		
		Virtious.load();
		Aerius.load();
		
		WorldManager.load();
		InventoryHandler.load();
		
		ECConfig.saveConfig();
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		GameRegistry.registerFuelHandler(new EDFuelHandler());
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}
