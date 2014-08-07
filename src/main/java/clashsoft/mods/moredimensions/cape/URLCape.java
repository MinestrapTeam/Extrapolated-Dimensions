package clashsoft.mods.moredimensions.cape;

import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;

public class URLCape extends Cape
{
	protected ITextureObject	texture;
	
	public URLCape(String name, URL url)
	{
		super(name);
		this.setURL(url);
	}
	
	@Override
	public void loadTexture(AbstractClientPlayer player)
	{
		Minecraft.getMinecraft().renderEngine.loadTexture(this.location, this.getTexture());
		super.loadTexture(player);
	}
	
	public ITextureObject getTexture()
	{
		return this.texture;
	}
	
	public void setURL(URL url)
	{
		if (url == null)
		{
			this.texture = null;
			return;
		}
		this.texture = new ThreadDownloadImageData(null, url.toString(), null, new CapeImageBuffer());
	}
}
