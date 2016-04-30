package minestrapteam.extracore;

import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extracore.entity.ECEntities;
import minestrapteam.extracore.entity.ECEntities.EntityProperties;
import minestrapteam.extracore.init.ClashsoftMod;
import minestrapteam.extracore.inventory.CreativeInventory;
import minestrapteam.extracore.inventory.SurvivalInventory;
import minestrapteam.extracore.util.update.ECUpdate;
import minestrapteam.extracore.util.update.reader.SimpleUpdateReader;
import minestrapteam.extracore.util.update.updater.ModUpdater;
import minestrapteam.extracore.inventory.IInventoryHandler;
import minestrapteam.extracore.client.inventory.IInventoryObject;
import minestrapteam.extracore.proxy.PIEventHandler;
import minestrapteam.extracore.proxy.PIProxy;
import minestrapteam.extracore.inventory.ExtendedInventory;
import minestrapteam.extracore.network.PINetHandler;
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
	
	public static PIProxy				proxy					= createProxy("minestrapteam.extracore.client.PIClientProxy", "minestrapteam.extracore.proxy.PIProxy");
	
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
		
		ECEntities.registerProperties(new EntityProperties(ExtendedInventory.IDENTIFIER, ExtendedInventory.class)
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
		itemTooltip = ECConfig.getBool("tooltip", "Item Tooltip", itemTooltip);
		buffTooltip = ECConfig.getBool("tooltip", "Buff Tooltip", buffTooltip);
		playerTooltip = ECConfig.getBool("tooltip", "Player Tooltip", playerTooltip);
	}
	
	@Override
	public void updateCheck()
	{
		String url = "https://raw.githubusercontent.com/Clashsoft/Player-Inventory-API/master/version.txt";
		ECUpdate.updateCheck(new ModUpdater(NAME, ACRONYM, VERSION, url, SimpleUpdateReader.instance));
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
