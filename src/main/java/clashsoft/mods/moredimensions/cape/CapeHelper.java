package clashsoft.mods.moredimensions.cape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import clashsoft.cslib.reflect.CSReflection;
import clashsoft.cslib.util.CSLog;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class CapeHelper
{
	public static CapeHelper							instance				= new CapeHelper();
	
	private HashMap<String, String>						users					= new HashMap();
	private HashMap<String, ResourceLocation>			capeResources			= new HashMap();
	private HashMap<String, ThreadDownloadImageData>	downloadThreads			= new HashMap();
	
	public ResourceLocation								EMPTY_RESOURCE_LOCATION	= new ResourceLocation("moredimensions", "capes/empty");
	public ThreadDownloadImageData						EMPTY_IMAGE_DATA		= new ThreadDownloadImageData("", this.EMPTY_RESOURCE_LOCATION, new CapeImageBuffer());
	
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
								ThreadDownloadImageData t = createDownloadThread(r, capeUrl, null, new CapeImageBuffer());
								
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
		catch (IOException ex)
		{
			CSLog.error(ex);
		}
	}
	
	public static void addUser(String username, String group)
	{
		instance.users.put(username, group);
	}
	
	public static void addCapeResource(String group, ResourceLocation resourceLocation)
	{
		instance.capeResources.put(group, resourceLocation);
	}
	
	public static void addDownloadThread(String group, ThreadDownloadImageData downloadImageThread)
	{
		instance.downloadThreads.put(group, downloadImageThread);
	}
	
	public static String getUserGroup(String username)
	{
		return instance.users.get(username);
	}
	
	public static ResourceLocation getCapeResource(String group)
	{
		ResourceLocation rl = instance.capeResources.get(group);
		return rl != null ? rl : instance.EMPTY_RESOURCE_LOCATION;
	}
	
	public static ThreadDownloadImageData getDownloadThread(String group)
	{
		ThreadDownloadImageData tdid = instance.downloadThreads.get(group);
		return tdid != null ? tdid : instance.EMPTY_IMAGE_DATA;
	}
	
	public static ThreadDownloadImageData createDownloadThread(ResourceLocation resourceLocation1, String string, ResourceLocation resourceLocation2, IImageBuffer imageBuffer)
	{
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		
		ITextureObject object = new ThreadDownloadImageData(string, resourceLocation2, imageBuffer);
		texturemanager.loadTexture(resourceLocation1, object);
		
		return (ThreadDownloadImageData) object;
	}
	
	public static void setCape(EntityPlayer player, boolean override)
	{
		String username = player.getDisplayName();
		if (player instanceof AbstractClientPlayer && getUserGroup(username) != null)
		{
			if (override || !getDownloadImageThreadData((AbstractClientPlayer) player).isTextureUploaded())
			{
				String userGroup = getUserGroup(username);
				setCape((AbstractClientPlayer) player, userGroup);
			}
		}
	}
	
	public static void setCape(AbstractClientPlayer player, String userGroup)
	{
		setCapeResourceLocation(player, getCapeResource(userGroup));
		setDownloadImageThreadData(player, getDownloadThread(userGroup));
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