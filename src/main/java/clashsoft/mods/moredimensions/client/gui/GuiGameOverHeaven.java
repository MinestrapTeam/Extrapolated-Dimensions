package clashsoft.mods.moredimensions.client.gui;

import clashsoft.mods.moredimensions.MoreDimensionsMod;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiScreen;

public class GuiGameOverHeaven extends GuiGameOver
{
	public GuiButton	heavenButton;
	
	@Override
	public void initGui()
	{
		super.initGui();
		if (!this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled() && this.mc.thePlayer.dimension == 0)
		{
			this.buttonList.add(this.heavenButton = new GuiButton(3, this.width / 2 - 100, this.height / 4 + 120, "Go to Heaven"));
			this.heavenButton.enabled = false;
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.id == 3)
		{
			this.mc.thePlayer.respawnPlayer();
			this.mc.displayGuiScreen((GuiScreen) null);
			MoreDimensionsMod.proxy.sendPlayerToHeaven(this.mc.thePlayer);
		}
		else
		{
			super.actionPerformed(button);
		}
	}
}
