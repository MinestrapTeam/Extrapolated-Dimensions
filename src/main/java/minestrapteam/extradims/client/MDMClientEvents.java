package minestrapteam.extradims.client;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import minestrapteam.extradims.client.gui.GuiHeavenMainMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;

public class MDMClientEvents
{
	@EventHandler
	public void onTick(ClientTickEvent event)
	{
		Class c = Minecraft.getMinecraft().currentScreen.getClass();
		if (c == GuiMainMenu.class)
		{
			Minecraft.getMinecraft().displayGuiScreen(new GuiHeavenMainMenu());
		}
	}
}