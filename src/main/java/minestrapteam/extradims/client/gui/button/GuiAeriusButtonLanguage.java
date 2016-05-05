package minestrapteam.extradims.client.gui.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButtonLanguage;
import org.lwjgl.opengl.GL11;

public class GuiAeriusButtonLanguage extends GuiButtonLanguage
{
	public GuiAeriusButtonLanguage(int buttonID, int x, int y)
	{
		super(buttonID, x, y);
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (!this.visible)
		{
			return;
		}

		mc.getTextureManager().bindTexture(GuiAeriusButton.TEXTURE_LOCATION);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.field_146123_n =
			mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width
				&& mouseY < this.yPosition + this.height;

		final int v = this.field_146123_n ? 168 : 148;
		this.drawTexturedModalRect(this.xPosition, this.yPosition, 200, v, this.width, this.height);
	}
}
