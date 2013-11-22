package clashsoft.mods.moredimensions.addons;

import java.io.File;

import clashsoft.cslib.addon.Addon;

import net.minecraftforge.common.Configuration;

@Addon(modName = "MoreDimensionsMod", addonName = "Config")
public class MDMConfig
{
	public static Configuration config			= null;
	
	public static void loadConfig(File configFile)
	{
		config = new Configuration(configFile);
	}
	
	public static void saveConfig()
	{
		config.save();
	}
	
	public static int getItem(String key, int _default)
	{
		if (!key.contains(" Item ID"))
			key += " Item ID";
		return config.getItem(key, _default, key + ". Default: " + _default).getInt(_default);
	}
	
	public static int getTerrainBlock(String key, int _default)
	{
		if (!key.contains(" Block ID"))
			key += " Block ID";
		return config.getTerrainBlock(Configuration.CATEGORY_BLOCK, key, _default, key + ". Default: " + _default).getInt(_default);
	}
	
	public static int getBlock(String key, int _default)
	{
		if (!key.contains(" Block ID"))
			key += " Block ID";
		return config.getBlock(key, _default, key + ". Default: " + _default).getInt(_default);
	}
	
	public static int getDimension(String key, int _default)
	{
		if (!key.contains(" Dimension ID"))
			key += " Dimension ID";
		return config.get("dimension", key, _default, key + ". Default: " + _default).getInt(_default);
	}
	
	public static int getBiome(String key, int _default)
	{
		if (!key.contains(" Biome ID"))
			key += " Biome ID";
		return config.get("biome", key, _default, key + ". Default: " + _default).getInt(_default);
	}
}
