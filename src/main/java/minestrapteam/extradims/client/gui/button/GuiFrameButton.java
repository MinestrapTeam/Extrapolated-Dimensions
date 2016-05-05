package minestrapteam.extradims.client.gui.button;

import minestrapteam.extracore.client.gui.GuiBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class GuiFrameButton extends GuiButton
{
	public GuiFrameButton(int buttonID, int x, int y, int width, int height, String text)
	{
		super(buttonID, x, y, width, height, text);
	}

	public GuiFrameButton(int buttonID, int x, int y, String text)
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

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.field_146123_n =
			mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width
				&& mouseY < this.yPosition + this.height;

		this.mouseDragged(mc, mouseX, mouseY);

		final int color;
		if (!this.enabled)
		{
			color = 0xFFA0A0A0;
		}
		else if (this.field_146123_n)
		{
			color = 0xFFFFA0;
		}
		else {
			color = 0xE0E0E0;
		}

		GuiBuilder.global.drawHoveringFrame(this.xPosition, this.yPosition, this.width, this.height, color);
		this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2,
		                        this.yPosition + (this.height - 8) / 2, color);
	}

	@Override
	public void drawCenteredString(FontRenderer fontRenderer, String string, int x, int y, int color)
	{
		fontRenderer.drawString(string, x - fontRenderer.getStringWidth(string) / 2, y, color);
	}
}
