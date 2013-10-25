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
		// -- Paradise of Chaos
		
		// - Items -
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.PoCTab", "en_US", "Paradise of Chaos");
		LanguageRegistry.instance().addStringLocalization("itemGroup.PoCTab", "de_DE", "Paradies des Chaos");
		LanguageRegistry.instance().addStringLocalization("itemGroup.ElixirTab", "en_US", "Elixirs");
		LanguageRegistry.instance().addStringLocalization("itemGroup.ElixirTab", "de_DE", "Elixiere");
		
		LanguageRegistry.instance().addStringLocalization("elixir.prefix.grenade", "en_US", "Throwable");
		LanguageRegistry.instance().addStringLocalization("elixir.prefix.grenade", "de_DE", "Werfbar");
		LanguageRegistry.instance().addStringLocalization("elixir.elixirof", "en_US", "Elixir of");
		LanguageRegistry.instance().addStringLocalization("elixir.elixirof", "de_DE", "Elixier von");
		LanguageRegistry.instance().addStringLocalization("elixir.empty", "en_US", "Water Elixir Bottle");
		LanguageRegistry.instance().addStringLocalization("elixir.empty", "de_DE", "Wasserelixierflasche");
		LanguageRegistry.instance().addStringLocalization("elixir.bottletype", "en_US", "Bottle Type");
		LanguageRegistry.instance().addStringLocalization("elixir.bottletype", "de_DE", "Flaschentyp");
		
		LanguageRegistry.instance().addStringLocalization("elixir.bottletype.0", "en_US", "Square");
		LanguageRegistry.instance().addStringLocalization("elixir.bottletype.0", "de_DE", "Eckig");
		LanguageRegistry.instance().addStringLocalization("elixir.bottletype.1", "en_US", "Triangular");
		LanguageRegistry.instance().addStringLocalization("elixir.bottletype.1", "de_DE", "Dreieckig");
		
		// - Entitys -
		
		LanguageRegistry.instance().addStringLocalization("entity.POCBossLich.name", "Lich");
		
		// -- Heaven --
		
		// - Items -
		
		for (int i = 0; i < 16; i++)
		{
			LanguageRegistry.addName(new ItemStack(MDMItems.soul, 1, i), "Soul of " + ItemHeavenSoul.soulNames[i]);
		}
		
		// - Entitys --
		
		LanguageRegistry.instance().addStringLocalization("entity.Scider.name", "Scider");

	}
}
