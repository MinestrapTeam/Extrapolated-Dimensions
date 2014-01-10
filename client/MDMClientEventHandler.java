package clashsoft.mods.moredimensions.client;

import clashsoft.mods.moredimensions.MoreDimensionsMod;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class MDMClientEventHandler
{	
	@ForgeSubscribe
	public void onGUIOpened(GuiOpenEvent event)
	{
		if (event.gui != null)
		{
			MoreDimensionsMod.proxy.replaceGUIs(event);
		}
	}
}
