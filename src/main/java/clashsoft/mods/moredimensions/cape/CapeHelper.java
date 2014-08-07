package clashsoft.mods.moredimensions.cape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import clashsoft.cslib.logging.CSLog;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class CapeHelper
{
	// Username, Group
	private static HashMap<String, String>	groups	= new HashMap();
	// Group, Cape
	private static HashMap<String, Cape>	capes	= new HashMap();
	
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
			
			while ((line = reader.readLine()) != null)
			{
				if (line.startsWith("#"))
				{
					continue;
				}
				int i = line.indexOf('=');
				if (i == -1)
				{
					continue;
				}
				
				String key = line.substring(0, i);
				String value = line.substring(i + 1);
				
				if (value.startsWith("http:"))
				{
					Cape cape = new URLCape(key, new URL(value));
					capes.put(key, cape);
				}
				else if (value.startsWith("local:"))
				{
					Cape cape = new LocalCape(key, value.substring(6));
					capes.put(key, cape);
				}
				else
				{
					// Group:User -> (user, group)
					groups.put(value, key);
				}
			}
		}
		catch (IOException ex)
		{
			CSLog.error(ex);
		}
	}
	
	public static void setCape(EntityPlayer player, String cape)
	{
		groups.put(player.getCommandSenderName(), cape);
	}
	
	public static Cape getCape(EntityPlayer player)
	{
		String group = groups.get(player.getCommandSenderName());
		return capes.get(group);
	}
	
	public static void updateCape(EntityPlayer player, boolean override)
	{
		if (player instanceof AbstractClientPlayer)
		{
			AbstractClientPlayer player1 = (AbstractClientPlayer) player;
			if (override || player1.getLocationCape() == null)
			{
				Cape cape = getCape(player1);
				cape.loadTexture(player1);
			}
		}
	}
}