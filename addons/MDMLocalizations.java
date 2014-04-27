package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.minecraft.addon.Addon;

@Addon(modName = "MoreDimensionsMod", addonName = "Localizations")
public class MDMLocalizations
{
	public static void load()
	{
		// -- Items --
		
		// - Creative Tabs -
		
		addTranslation("itemGroup.mdm_tools", "Advanced Tools");
		
		addTranslation("itemGroup.poc_blocks", "Paradise of Chaos Blocks");
		addTranslation("itemGroup.poc_items", "Paradise of Chaos Items");
		addTranslation("itemGroup.poc_tools", "Paradise of Chaos Tools and Weapons");
		addTranslation("itemGroup.poc_armor", "Paradise of Chaos Armory");
		
		addTranslation("itemGroup.alchemy", "Alchemy");
		
		addTranslation("itemGroup.heaven_blocks", "Heaven Blocks");
		addTranslation("itemGroup.heaven_items", "Heaven Items");
		addTranslation("itemGroup.heaven_tools", "Heaven Tools and Weapons");
		addTranslation("itemGroup.heaven_armor", "Heaven Armory");
		
		// - Paradise of Chaos -
		
		addTranslation("elixir.prefix.grenade", "en_US", "Throwable");
		addTranslation("elixir.prefix.grenade", "de_DE", "Werfbares");
		addTranslation("elixir.elixirof", "en_US", "Elixir of");
		addTranslation("elixir.elixirof", "de_DE", "Elixier von");
		addTranslation("elixir.empty", "en_US", "Water Elixir Bottle");
		addTranslation("elixir.empty", "de_DE", "Wasserelixierflasche");
		addTranslation("elixir.bottletype", "en_US", "Bottle Type");
		addTranslation("elixir.bottletype", "de_DE", "Flaschentyp");
		
		addTranslation("elixir.bottletype.0", "en_US", "Square");
		addTranslation("elixir.bottletype.0", "de_DE", "Eckig");
		addTranslation("elixir.bottletype.1", "en_US", "Triangular");
		addTranslation("elixir.bottletype.1", "de_DE", "Dreieckig");
		addTranslation("elixir.bottletype.2", "en_US", "Round");
		addTranslation("elixir.bottletype.2", "de_DE", "Rund");
		
		addTranslation("alchemyguide.description", "en_US", "Holds all alchemical knowledge");
		
		// - Heaven -
		
		addTranslation("item.cape_pro.name", "Pro Cape");
		addTranslation("item.cape_blue.name", "Blue Cape");
		addTranslation("item.cape_green.name", "Green Cape");
		addTranslation("item.cape_red.name", "Red Cape");
		addTranslation("item.cape_yellow.name", "Yellow Cape");
		addTranslation("item.cape_invisibility.name", "Invisibility Cape");
		addTranslation("item.cape_minecon2011.name", "Minecon Cape");
		addTranslation("item.cape_minecon2012.name", "Minecon Cape");
		addTranslation("item.cape_minecon2013.name", "Minecon Cape");
		
		// -- Curses --
		
		addTranslation("curse.test", "Test Curse");
		
		// -- Entitys --
		
		// - Paradise of Chaos -
		
		addTranslation("entity.POCBossLich.name", "Lich");
		
		// - Heaven -
		
		addTranslation("entity.Scider.name", "Scider");
		
	}
	
	public static void addTranslation(String key, String value)
	{
		
	}
	
	public static void addTranslation(String key, String lang, String value)
	{
		
	}
}
