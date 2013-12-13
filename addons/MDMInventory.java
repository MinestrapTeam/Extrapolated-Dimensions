package clashsoft.mods.moredimensions.addons;

import clashsoft.mods.moredimensions.inventory.MDMSlotHandler;
import clashsoft.playerinventoryapi.Inventory;
import clashsoft.playerinventoryapi.api.ISlotHandler;

public class MDMInventory
{
	public static ISlotHandler	slotHandler	= new MDMSlotHandler();
	
	public static void load()
	{
		Inventory.addSlotHandler(slotHandler);
	}
}
