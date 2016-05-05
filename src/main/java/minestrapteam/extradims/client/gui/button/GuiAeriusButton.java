package minestrapteam.extradims.client.gui.button;

import minestrapteam.extradims.client.gui.GuiMainMenuAerius;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiAeriusButton extends GuiButton
{
	public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("ed_aerius",
	                                                                             "textures/gui/buttons.png");

	public GuiAeriusButton(int buttonID, int x, int y, int width, int height, String text)
	{
		super(buttonID, x, y, width, height, text);
	}

	public GuiAeriusButton(int buttonID, int x, int y, String text)
	{
		super(buttonID, x, y, text);
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (!this.visible)
		{
			return;
		}

		FontRenderer fontrenderer = mc.fontRenderer;
		mc.getTextureManager().bindTexture(TEXTURE_LOCATION);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.field_146123_n =
			mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width
				&& mouseY < this.yPosition + this.height;

		final int vOffset = this.getHoverState(this.field_146123_n);
		this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 128 + vOffset * 20, this.width / 2, this.height);
		this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 128 + vOffset * 20,
		                           this.width / 2, this.height);

		this.mouseDragged(mc, mouseX, mouseY);

		final int textColor;
		if (!this.enabled)
		{
			textColor = 0xA0A0A0;
		}
		else if (this.field_146123_n)
		{
			textColor = 0x303030;
		}
		else
		{
			textColor = GuiMainMenuAerius.TEXT_COLOR;
		}

		this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2,
		                        this.yPosition + (this.height - 8) / 2, textColor);
	}

	@Override
	public void drawCenteredString(FontRenderer fontRenderer, String string, int x, int y, int color)
	{
		fontRenderer.drawString(string, x - fontRenderer.getStringWidth(string) / 2, y, color);
	}
}
