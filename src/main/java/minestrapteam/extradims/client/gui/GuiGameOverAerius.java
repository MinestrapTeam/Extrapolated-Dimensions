package minestrapteam.extradims.client.gui;

import minestrapteam.extracore.util.I18n;
import minestrapteam.extradims.client.gui.button.GuiAeriusButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiGameOver;

public class GuiGameOverAerius extends GuiGameOver
{
	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		super.initGui();
		if (!this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
		{
			final GuiButton aeriusButton = new GuiAeriusButton(3, this.width / 2 - 100, this.height / 4 + 120,
			                                                   I18n.getString("button.gameover.aerius"));
			aeriusButton.enabled = false;
			this.buttonList.add(aeriusButton);
		}
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.id == 3)
		{
			this.mc.thePlayer.respawnPlayer();
			this.mc.displayGuiScreen(null);

			// TODO send player to Aerius

			return;
		}

		super.actionPerformed(button);
	}
}
