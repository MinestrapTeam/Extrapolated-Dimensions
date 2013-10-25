package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.addons.Addon;

@Addon(modName = "MoreDimensionsMod", addonName = "Objects")
public class MDMObjects
{
	public static void load()
	{
		MDMBlocks.initialize();
		MDMItems.initialize();
		MDMBlocks.load();
		MDMItems.load();
	}
}
