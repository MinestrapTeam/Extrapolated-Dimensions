package minestrapteam.extradims;

import minestrapteam.extradims.common.MDMEventHandler;
import minestrapteam.extradims.common.MDMProxy;
import minestrapteam.extradims.lib.*;
import minestrapteam.extradims.network.MDMNetHandler;
import clashsoft.cslib.config.CSConfig;
import clashsoft.cslib.minecraft.init.ClashsoftMod;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MoreDimensionsMod.MODID, name = MoreDimensionsMod.NAME, version = MoreDimensionsMod.VERSION)
public class MoreDimensionsMod extends ClashsoftMod
{
	public static final String		MODID	= "moredimensions";
	public static final String		NAME	= "More Dimensions Mod";
	public static final String		ACRONYM	= "mdm";
	public static final String		VERSION	= "1.7.10-0.0.1";
	
	@Instance(MODID)
	public static MoreDimensionsMod	instance;
	
	public static MDMProxy			proxy	= createProxy("minestrapteam.extradims.client.MDMClientProxy", "minestrapteam.extradims.common.MDMProxy");
	
	public MoreDimensionsMod()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.eventHandler = new MDMEventHandler();
		this.netHandlerClass = MDMNetHandler.class;
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		CSConfig.loadConfig(this.configFile);
		
		Aerius.init();
		ParadiseOfChaos.init();
		Alchemy.init();
		//Tools.init();
		
		Aerius.load();
		ParadiseOfChaos.load();
		Alchemy.load();
		//Tools.load();
		
		WorldManager.load();
		InventoryHandler.load();
		
		CSConfig.saveConfig();
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}