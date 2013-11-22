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
			this.buttonList.add(heavenButton = new GuiButton(3, this.width / 2 - 100, this.height / 4 + 120, "Go to Heaven"));
			heavenButton.enabled = false;
		}
	}
	
	/**
	 * Fired when a control is clicked. This is the equivalent of
	 * ActionListener.actionPerformed(ActionEvent e).
	 */
	@Override
	protected void actionPerformed(GuiButton par1GuiButton)
	{
		if (par1GuiButton.id == 3)
		{
			this.mc.thePlayer.respawnPlayer();
			this.mc.displayGuiScreen((GuiScreen) null);
			PacketDispatcher.sendPacketToServer(new PacketHeaven());
		}
		else
			super.actionPerformed(par1GuiButton);
	}
}
