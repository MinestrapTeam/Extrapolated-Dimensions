package clashsoft.playerinventoryapi;

import clashsoft.cslib.config.CSConfig;
import clashsoft.cslib.minecraft.entity.CSEntities;
import clashsoft.cslib.minecraft.entity.CSEntities.EntityProperties;
import clashsoft.cslib.minecraft.init.ClashsoftMod;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.update.reader.SimpleUpdateReader;
import clashsoft.cslib.minecraft.update.updater.ModUpdater;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.invobject.IInventoryObject;
import clashsoft.playerinventoryapi.common.PIEventHandler;
import clashsoft.playerinventoryapi.common.PIProxy;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;
import clashsoft.playerinventoryapi.network.PINetHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.IExtendedEntityProperties;

@Mod(modid = PlayerInventoryAPI.MODID, name = PlayerInventoryAPI.NAME, version = PlayerInventoryAPI.VERSION)
public class PlayerInventoryAPI extends ClashsoftMod
{
	public static final String			MODID					= "piapi";
	public static final String			NAME					= "Player Inventory API";
	public static final String			ACRONYM					= "piapi";
	public static final String			VERSION					= "1.7.10-1.0.3";
	
	@Instance(MODID)
	public static PlayerInventoryAPI	instance;
	
	public static PIProxy				proxy					= createProxy("clashsoft.playerinventoryapi.client.PIClientProxy", "clashsoft.playerinventoryapi.common.PIProxy");
	
	public static boolean				customSurvivalInventory	= true;
	public static boolean				customCreativeInventory	= true;
	
	public static boolean				itemTooltip				= false;
	public static boolean				buffTooltip				= true;
	public static boolean				playerTooltip			= true;
	
	public PlayerInventoryAPI()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.hasConfig = true;
		this.eventHandler = new PIEventHandler();
		this.netHandlerClass = PINetHandler.class;
		this.url = "https://github.com/Clashsoft/Player-Inventory-API/wiki/";
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		CSEntities.registerProperties(new EntityProperties(ExtendedInventory.IDENTIFIER, ExtendedInventory.class)
		{
			@Override
			public boolean canApply(Entity entity)
			{
				return entity instanceof EntityPlayer;
			}
			
			@Override
			public IExtendedEntityProperties createProperties(Entity entity)
			{
				return new ExtendedInventory((EntityPlayer) entity);
			}
		});
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	@Override
	public void readConfig()
	{
		itemTooltip = CSConfig.getBool("tooltip", "Item Tooltip", itemTooltip);
		buffTooltip = CSConfig.getBool("tooltip", "Buff Tooltip", buffTooltip);
		playerTooltip = CSConfig.getBool("tooltip", "Player Tooltip", playerTooltip);
	}
	
	@Override
	public void updateCheck()
	{
		String url = "https://raw.githubusercontent.com/Clashsoft/Player-Inventory-API/master/version.txt";
		CSUpdate.updateCheck(new ModUpdater(NAME, ACRONYM, VERSION, url, SimpleUpdateReader.instance));
	}
	
	// ---------- API ---------- \\
	
	/**
	 * Sets the position of a slot in the both the survival and the creative
	 * player inventory.
	 * 
	 * @see PlayerInventoryAPI#setSurvivalSlot(int, int, int)
	 * @see PlayerInventoryAPI#setCreativeSlot(int, int, int)
	 * @param slotID
	 *            the ID of the slot
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public static void setSlot(int slotID, int x, int y)
	{
		SurvivalInventory.setSlot(slotID, x, y);
		CreativeInventory.setSlot(slotID, x, y);
	}
	
	/**
	 * Registers a new {@link IInventoryHandler}.
	 * 
	 * @param handler
	 *            the inventory handler
	 */
	public static void addInventoryHandler(IInventoryHandler handler)
	{
		SurvivalInventory.addHandler(handler);
		CreativeInventory.addHandler(handler);
	}
	
	/**
	 * Adds a button to both the survival and the creative inventory.
	 * 
	 * @param button
	 *            the button
	 */
	public static void addButton(Object button)
	{
		SurvivalInventory.addButton(button);
		CreativeInventory.addButton(button);
	}
	
	/**
	 * Adds an {@link IInventoryObject} to both the survival and the creative
	 * inventory.
	 * 
	 * @param object
	 *            the object
	 */
	public static void addObject(IInventoryObject object)
	{
		SurvivalInventory.addObject(object);
		CreativeInventory.addObject(object);
	}
}
