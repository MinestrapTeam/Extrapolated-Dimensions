package minestrapteam.extradims.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import minestrapteam.extradims.client.gui.GuiGameOverAerius;
import minestrapteam.extradims.client.gui.GuiMainMenuAerius;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiOpenEvent;

public class EDClientEvents
{
	@SubscribeEvent
	public void onGuiOpened(GuiOpenEvent event)
	{
		if (event.gui == null)
		{
			return;
		}

		final Class<? extends GuiScreen> eventClass = event.gui.getClass();
		if (eventClass == GuiMainMenu.class)
		{
			event.gui = new GuiMainMenuAerius();
		}
		else if (eventClass == GuiGameOver.class)
		{
			event.gui = new GuiGameOverAerius();
		}
	}
}
