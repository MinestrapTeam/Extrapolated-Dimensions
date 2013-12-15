package clashsoft.mods.moredimensions.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;

public class GuiHeavenButton extends GuiButton
{
	public GuiHeavenButton(int buttonID, int x, int y, int width, int height, String text)
	{
		super(buttonID, x, y, width, height, text);
	}

	public GuiHeavenButton(int buttonID, int x, int y, String text)
	{
		super(buttonID, x, y, text);
	}
	
	/**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.drawButton)
        {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(GuiPOCButton.buttonTextures);
            
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            
            this.field_82253_i = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int k = this.getHoverState(this.field_82253_i);
            
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 128 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 128 + k * 20, this.width / 2, this.height);
            
            this.mouseDragged(mc, mouseX, mouseY);
            int l = 0xAAFFFF;
            
            if (!this.enabled)
            {
                l = -6250336;
            }
            else if (this.field_82253_i)
            {
                l = 0xFFFFFF;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }
}
