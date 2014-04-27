package clashsoft.mods.moredimensions.addons;

import clashsoft.mods.moredimensions.inventory.MDMSlotHandler;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import clashsoft.playerinventoryapi.api.IInventoryHandler;

public class MDMInventory
{
	public static IInventoryHandler	slotHandler	= new MDMSlotHandler();
	
	public static void load()
	{
		PlayerInventoryAPI.addInventoryHandler(slotHandler);
	}
}
