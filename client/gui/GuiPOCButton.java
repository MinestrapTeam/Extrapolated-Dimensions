package clashsoft.mods.moredimensions.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiPOCButton extends GuiButton
{
	public static ResourceLocation	buttons	= new ResourceLocation("moredimensions", "textures/gui/buttons.png");
	
	private float					colorR	= -1F;
	private float					colorG	= -1F;
	private float					colorB	= -1F;
	
	public GuiPOCButton(int buttonID, int x, int y, String text)
	{
		super(buttonID, x, y, text);
	}
	
	public GuiPOCButton(int buttonID, int x, int y, int width, int height, String text)
	{
		super(buttonID, x, y, width, height, text);
	}
	
	public GuiPOCButton setColor(float r, float g, float b)
	{
		this.colorR = r;
		this.colorG = g;
		this.colorB = b;
		return this;
	}
	
	public boolean hasSpecialColor()
	{
		return this.colorR >= 0 && this.colorG >= 0 && this.colorB >= 0;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (this.drawButton)
		{
			FontRenderer fontrenderer = mc.fontRenderer;
			mc.renderEngine.bindTexture(buttons);
			
			if (this.hasSpecialColor())
				GL11.glColor4f(this.colorR, this.colorG, this.colorB, 1.0F);
			else if (!this.enabled)
				GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);
			else
				GL11.glColor4f(1F, 1F, 1F, 1F);
			int k = this.getHoverState(this.field_82253_i);
			float buttonScaleX = 0.5F;
			float buttonScaleY = 0.25F;
			GL11.glScalef(buttonScaleX, buttonScaleY, 1F);
			this.field_82253_i = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			int posX1 = this.hasSpecialColor() ? 160 : (k == 1 ? 0 : (k == 2 ? 80 : 160));
			this.drawTexturedModalRect(this.xPosition * (int) (1F / buttonScaleX), this.yPosition * (int) (1F / buttonScaleY), 0, posX1, (int) (this.width * 2F) + 15, 80);
			GL11.glScalef(1F / buttonScaleX, 1F / buttonScaleY, 1F);
			this.mouseDragged(mc, mouseX, mouseY);
			int l = 14737632;
			
			if (!this.enabled)
			{
				l = -6250336;
			}
			else if (this.field_82253_i)
			{
				l = 16777120;
			}
			
			this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + (this.width + 5) / 2, this.yPosition + (this.height - 8) / 2, l);
		}
	}
	
}
