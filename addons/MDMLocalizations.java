package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.item.heaven.ItemHeavenSoul;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.item.ItemStack;

@Addon(modName = "MoreDimensionsMod", addonName = "Localizations")
public class MDMLocalizations
{
	public static void load()
	{
		// -- Items --
		
		addTranslation("itemGroup.POCTab", "Paradise of Chaos");
		addTranslation("itemGroup.ElixirTab", "Elixirs");
		addTranslation("itemGroup.HeavenBlocks", "Heaven Blocks");
		addTranslation("itemGroup.HeavenMaterials", "Heaven Materials");
		addTranslation("itemGroup.HeavenTools", "Heaven Tools and Weaponry");
		addTranslation("itemGroup.HeavenArmor", "Heaven Armory");
		
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
		
		// - Heaven -
		
		for (int i = 0; i < 16; i++)
		{
			LanguageRegistry.addName(new ItemStack(MDMItems.soul, 1, i), "Soul of " + ItemHeavenSoul.soulNames[i]);
		}
		
		// -- Entitys --
		
		// - Paradise of Chaos -
		
		addTranslation("entity.POCBossLich.name", "Lich");
		
		// - Heaven -
		
		addTranslation("entity.Scider.name", "Scider");
		
	}
	
	public static void addTranslation(String key, String value)
	{
		LanguageRegistry.instance().addStringLocalization(key, value);
	}
	
	public static void addTranslation(String key, String lang, String value)
	{
		LanguageRegistry.instance().addStringLocalization(key, lang, value);
	}
}
