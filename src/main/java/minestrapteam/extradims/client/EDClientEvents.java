package minestrapteam.extradims.client;

import cpw.mods.fml.common.Mod.EventHandler;
import minestrapteam.extradims.client.gui.GuiMainMenuAerius;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;

public class EDClientEvents
{
	@EventHandler
	public void onGuiOpened(GuiOpenEvent event)
	{
		if (event.gui.getClass() == GuiMainMenu.class)
		{
			event.gui = new GuiMainMenuAerius();
		}
	}
}
