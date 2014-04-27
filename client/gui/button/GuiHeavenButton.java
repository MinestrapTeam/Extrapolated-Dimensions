package clashsoft.mods.moredimensions.client.gui.button;

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
	
	@Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(GuiPOCButton.buttonTextures);
            
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            
            this.field_146123_n = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 128 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 128 + k * 20, this.width / 2, this.height);
            
            this.mouseDragged(mc, mouseX, mouseY);
            int l = 0x505050;
            
            if (!this.enabled)
            {
                l = -6250336;
            }
            else if (this.field_146123_n)
            {
                l = 0x303030;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }
    
    @Override
    public void drawCenteredString(FontRenderer fontRenderer, String string, int x, int y, int color)
    {
    	fontRenderer.drawString(string, x - fontRenderer.getStringWidth(string) / 2, y, color);
    }
}
