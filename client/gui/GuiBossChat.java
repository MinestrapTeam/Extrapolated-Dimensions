package com.chaosdev.paradiseofchaos.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.chaosdev.paradiseofchaos.entity.boss.IPOCBoss;
import com.chaosdev.paradiseofchaos.entity.boss.chat.BossChatData.BossChatEntry;
import com.chaosdev.paradiseofchaos.entity.boss.chat.PlayerInputParser;

public class GuiBossChat extends GuiScreen
{
	public EntityPlayer											thePlayer;
	public com.chaosdev.paradiseofchaos.entity.boss.IPOCBoss	theBoss;
	
	private GuiTextField										playerInput;
	
	public GuiBossChat(EntityPlayer player, IPOCBoss boss)
	{
		thePlayer = player;
		theBoss = boss;
	}
	
	@Override
	public void initGui()
	{
		playerInput = new GuiTextField(fontRenderer, this.width / 2 - 100, this.height - 50, 200, 20);
	}
	
	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
		
		playerInput.drawTextBox();
		fontRenderer.drawString("TEST", 2, 2, 0xFFFFFF);
		
		for (int i = 0; i < theBoss.getBossChatData().entrys.size(); i++)
		{
			int textureSizeX = 16;
			int textureSizeY = 16;
			
			// Renders the Chat User Name
			BossChatEntry entry = theBoss.getBossChatData().entrys.get(i);
			String text = entry.getUserName(this.mc.thePlayer, theBoss) + ": " + (entry.translated ? entry.text : StatCollector.translateToLocal(entry.text));
			int textPosX = (this.width - fontRenderer.getStringWidth(text) - textureSizeX) / 2;
			int textPosY = (this.height - 60) - (i * (textureSizeX + 2));
			
			GL11.glColor4f(1F, 1F, 1F, 1F - (i * 0.1F));
			fontRenderer.drawString(text, textPosX, textPosY, theBoss.getBossChatData().entrys.get(i).userType.getColor());
			
			// Renders the Icon
			this.mc.renderEngine.bindTexture(entry.getIcon(theBoss));
			GL11.glScalef(textureSizeX / 64F, textureSizeY / 64F, 1F);
			this.drawTexturedModalRect(textPosX - 2, textPosY - 18, 0, 0, textureSizeX, textureSizeY);
			GL11.glScalef(1F / (textureSizeX / 64F), 1F / (textureSizeY / 64F), 1F);
		}
	}
	
	/**
	 * Fired when a key is typed. This is the equivalent of
	 * KeyListener.keyTyped(KeyEvent e).
	 */
	@Override
	protected void keyTyped(char par1, int par2)
	{
		if (par2 == Keyboard.KEY_SPACE)
		{
			String message = playerInput.getText();
			
			theBoss.getBossChatData().addPlayerMessage(message, true);
			theBoss.sendParsedPlayerInput(PlayerInputParser.parseInput(message), thePlayer);
		}
	}
}
