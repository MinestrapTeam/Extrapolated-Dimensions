package clashsoft.mods.moredimensions.client.gui;

import clashsoft.mods.moredimensions.common.PacketHeaven;
import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiScreen;

public class GuiGameOverHeaven extends GuiGameOver
{
	public GuiButton	heavenButton;
	
	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
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
	
	/**
	 * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
	 */
	@Override
	protected void actionPerformed(GuiButton button)
	{
		if (button.id == 3)
		{
			this.mc.thePlayer.respawnPlayer();
			this.mc.displayGuiScreen((GuiScreen) null);
			PacketDispatcher.sendPacketToServer(new PacketHeaven());
		}
		else
			super.actionPerformed(button);
	}
}
