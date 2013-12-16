package clashsoft.mods.moredimensions.cape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import clashsoft.cslib.reflect.CSReflection;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.util.ResourceLocation;

public class CapeHelper
{
	public static CapeHelper							instance		= new CapeHelper();
	
	private HashMap<String, String>						users			= new HashMap();
	private HashMap<String, ResourceLocation>			capeResources	= new HashMap();
	private HashMap<String, ThreadDownloadImageData>	downloadThreads	= new HashMap();
	
	protected CapeHelper()
	{
	}
	
	public static void addFileUrl(String fileUrl)
	{
		try
		{
			URL url = new URL(fileUrl);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			
			String username = "";
			String group = "";
			String capeUrl = "";
			
			while ((line = reader.readLine()) != null)
			{
				if (!line.startsWith("#"))
				{
					for (int i = 0; i < line.length(); i++)
					{
						if (line.charAt(i) == '=')
						{
							group = line.substring(0, i);
							String subLine = line.substring(i + 1);
							
							if (subLine.startsWith("http"))
							{
								capeUrl = subLine;
								
								ResourceLocation r = new ResourceLocation("moredimensions", "capes/" + group);
								ThreadDownloadImageData t = getDownloadThread(r, capeUrl, null, new CapeImageBuffer());
								
								addCapeResource(group, r);
								addDownloadThread(group, t);
								
								continue;
							}
							else
							{
								username = subLine.toLowerCase();
								addUser(username, group);
							}
						}
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addUser(String username, String group)
	{
		instance.users.put(username, group);
	}
	
	public static String getUserGroup(String username)
	{
		return instance.users.get(username);
	}
	
	public static void addCapeResource(String group, ResourceLocation resourceLocation)
	{
		if (getCapeResource(group) == null)
		{
			instance.capeResources.put(group, resourceLocation);
		}
	}
	
	public static ResourceLocation getCapeResource(String group)
	{
		return instance.capeResources.get(group);
	}
	
	public static void addDownloadThread(String group, ThreadDownloadImageData downloadImageThread)
	{
		if (getDownloadThread(group) == null)
		{
			instance.downloadThreads.put(group, downloadImageThread);
		}
	}
	
	public static ThreadDownloadImageData getDownloadThread(String group)
	{
		return instance.downloadThreads.get(group);
	}
	
	public static ThreadDownloadImageData getDownloadThread(ResourceLocation resourceLocation1, String string, ResourceLocation resourceLocation2, IImageBuffer imageBuffer)
	{
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		
		TextureObject object = new ThreadDownloadImageData(string, resourceLocation2, imageBuffer);
		texturemanager.loadTexture(resourceLocation1, object);
		
		return (ThreadDownloadImageData) object;
	}
	
	public static void setDownloadImageThreadData(AbstractClientPlayer player, ThreadDownloadImageData data)
	{
		CSReflection.setValue(AbstractClientPlayer.class, player, data, 2);
	}
	
	public static ThreadDownloadImageData getDownloadImageThreadData(AbstractClientPlayer player)
	{
		return CSReflection.getValue(AbstractClientPlayer.class, player, 2);
	}
	
	public static void setCapeResourceLocation(AbstractClientPlayer player, ResourceLocation resourceLocation)
	{
		CSReflection.setValue(AbstractClientPlayer.class, player, resourceLocation, 4);
	}
	
	public static ResourceLocation getCapeResourceLocation(AbstractClientPlayer player)
	{
		return CSReflection.getValue(AbstractClientPlayer.class, player, 4);
	}
}