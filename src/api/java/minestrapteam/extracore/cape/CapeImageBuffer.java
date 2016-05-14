package minestrapteam.extracore.cape;

import net.minecraft.client.renderer.IImageBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.awt.image.BufferedImage;

@SideOnly(Side.CLIENT)
public class CapeImageBuffer implements IImageBuffer
{
	private int imageWidth;
	private int imageHeight;

	@Override
	public BufferedImage parseUserSkin(BufferedImage bufferedImage)
	{
		if (bufferedImage == null)
		{
			return null;
		}
		else
		{
			this.imageWidth = bufferedImage.getWidth(null);
			this.imageHeight = bufferedImage.getHeight(null);
			if (this.imageWidth < 64)
			{
				this.imageWidth = 64;
			}
			if (this.imageHeight < 32)
			{
				this.imageHeight = 32;
			}

			BufferedImage capeImage = new BufferedImage(this.imageWidth, this.imageHeight, 2);

			Graphics graphics = capeImage.getGraphics();
			graphics.drawImage(bufferedImage, 0, 0, null);
			graphics.dispose();

			return capeImage;
		}
	}

	@Override
	public void skinAvailable()
	{
	}
}
