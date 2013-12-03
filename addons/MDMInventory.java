package clashsoft.mods.moredimensions.addons;

import clashsoft.mods.moredimensions.inventory.MDMSlotHandler;
import clashsoft.playerinventoryapi.CreativeInventory;
import clashsoft.playerinventoryapi.SurvivalInventory;
import clashsoft.playerinventoryapi.api.ISlotHandler;

public class MDMInventory
{
	public static ISlotHandler	slotHandler	= new MDMSlotHandler();
	
	public static void load()
	{
		CreativeInventory.addSlotHandler(slotHandler);
		SurvivalInventory.addSlotHandler(slotHandler);
	}
}
