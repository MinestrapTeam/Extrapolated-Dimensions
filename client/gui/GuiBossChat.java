package clashsoft.mods.moredimensions.client.gui;

import java.util.List;

import org.lwjgl.input.Keyboard;

import clashsoft.mods.moredimensions.api.IMDMBoss;
import clashsoft.mods.moredimensions.chat.boss.BossChatEntry;
import clashsoft.mods.moredimensions.chat.boss.PlayerInputParser;
import clashsoft.mods.moredimensions.inventory.ContainerBossChat;

import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

public class GuiBossChat extends GuiContainer
{
	public EntityPlayer											thePlayer;
	public IMDMBoss	theBoss;
	
	private GuiTextField										playerInput;
	
	public GuiBossChat(EntityPlayer player, IMDMBoss boss)
	{
		super(new ContainerBossChat(player, boss));
		thePlayer = player;
		theBoss = boss;
	}
	
	@Override
	public void initGui()
	{
		playerInput = new GuiTextField(fontRenderer, this.width / 2 - 100, this.height - 50, 200, 20);
		playerInput.setFocused(true);
		theBoss.onChatOpened(thePlayer);
	}
	
	/**
	 * Fired when a key is typed. This is the equivalent of
	 * KeyListener.keyTyped(KeyEvent e).
	 */
	@Override
	protected void keyTyped(char par1, int par2)
	{
		if (par2 == Keyboard.KEY_ESCAPE)
			super.keyTyped(par1, par2);
		if (par2 == Keyboard.KEY_RETURN)
		{
			String message = playerInput.getText();
			
			theBoss.getBossChatData().addPlayerMessage(message, true);
			theBoss.onPlayerInput(PlayerInputParser.parseInput(message), thePlayer);
			
			playerInput.setText("");
		}
		else
			playerInput.textboxKeyTyped(par1, par2);
	}
	
	@Override
	protected void mouseClicked(int par1, int par2, int par3)
	{
		playerInput.mouseClicked(par1, par2, par3);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		playerInput.drawTextBox();
		
		List<BossChatEntry> entrys = theBoss.getBossChatData().entrys;
		
		for (int i = 0; i < entrys.size(); i++)
		{
			int index = i;
			
			int textureSizeX = 16;
			int textureSizeY = 16;
			
			// Renders the Chat User Name
			BossChatEntry entry = theBoss.getBossChatData().entrys.get(index);
			String text = entry.getUserName(this.mc.thePlayer, theBoss) + ": " + (entry.localized ? entry.text : StatCollector.translateToLocal(entry.text));
			
			int textPosX = (this.width - fontRenderer.getStringWidth(text) - textureSizeX) / 2;
			int textPosY = (this.height - 60) - (i * textureSizeX);
			
			int alpha = (int) (((10 - i) * 0.1F) * 255F);
			fontRenderer.drawStringWithShadow(text, textPosX, textPosY, entry.userType.getColor() | (alpha << 24));
		}
	}
}
