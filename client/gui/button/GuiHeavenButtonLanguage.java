package clashsoft.mods.moredimensions.client.gui.button;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButtonLanguage;

public class GuiHeavenButtonLanguage extends GuiButtonLanguage
{
	public GuiHeavenButtonLanguage(int buttonID, int x, int y)
	{
		super(buttonID, x, y);
	}
	
	/**
	 * Draws this button to the screen.
	 */
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (this.drawButton)
		{
			mc.getTextureManager().bindTexture(GuiPOCButton.buttonTextures);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_82253_i = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			
			int k = this.field_82253_i ? 168 : 148;
			
			this.drawTexturedModalRect(this.xPosition, this.yPosition, 200, k, this.width, this.height);
		}
	}
}
