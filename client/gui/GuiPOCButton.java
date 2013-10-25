package clashsoft.mods.moredimensions.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiPOCButton extends GuiButton
{
	public static ResourceLocation	buttons	= new ResourceLocation("paradiseofchaos/gui/buttons.png");
	
	private float					colorR	= -1F;
	private float					colorG	= -1F;
	private float					colorB	= -1F;
	
	public GuiPOCButton(int par1, int par2, int par3, String par4Str)
	{
		super(par1, par2, par3, par4Str);
	}
	
	public GuiPOCButton(int par1, int par2, int par3, int par4, int par5, String par6Str)
	{
		super(par1, par2, par3, par4, par5, par6Str);
	}
	
	public GuiPOCButton setColor(float r, float g, float b)
	{
		colorR = r;
		colorG = g;
		colorB = b;
		return this;
	}
	
	public boolean hasSpecialColor()
	{
		return colorR >= 0 && colorG >= 0 && colorB >= 0;
	}
	
	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
	{
		if (this.drawButton)
		{
			FontRenderer fontrenderer = par1Minecraft.fontRenderer;
			par1Minecraft.renderEngine.bindTexture(buttons);
			
			if (hasSpecialColor())
				GL11.glColor4f(colorR, colorG, colorB, 1.0F);
			else if (!this.enabled)
				GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);
			else
				GL11.glColor4f(1F, 1F, 1F, 1F);
			int k = this.getHoverState(this.field_82253_i);
			float buttonScaleX = 0.5F;
			float buttonScaleY = 0.25F;
			GL11.glScalef(buttonScaleX, buttonScaleY, 1F);
			this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
			int posX1 = hasSpecialColor() ? 160 : (k == 1 ? 0 : (k == 2 ? 80 : 160));
			this.drawTexturedModalRect(this.xPosition * (int) (1F / buttonScaleX), this.yPosition * (int) (1F / buttonScaleY), 0, posX1, (int) (this.width * 2F) + 15, 80);
			GL11.glScalef(1F / buttonScaleX, 1F / buttonScaleY, 1F);
			this.mouseDragged(par1Minecraft, par2, par3);
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
