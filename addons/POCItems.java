package clashsoft.mods.moredimensions.addons;

import com.chaosdev.paradiseofchaos.item.*;
import com.chaosdev.paradiseofchaos.lib.POCCreativeTab;
import com.chaosdev.paradiseofchaos.lib.POCModPart;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;

@POCModPart(modPartId = "Items")
public class POCItems
{
	public static CreativeTabs		PoCTab		= new POCCreativeTab("PoCTab");
	public static CreativeTabs		AlchemyTab	= new POCCreativeTab("ElixirTab");
	
	// public static Item RedstonePickaxe;
	public static ItemTome			Tome;
	public static ItemStaff			Staves;
	public static ItemManaStar		ManaStar;
	public static ItemSword			ShannaraSword;
	public static ItemElixir		Elixir;
	public static ItemElixirBottle	ElixirBottle;
	public static EnumToolMaterial	magic		= EnumHelper.addToolMaterial("MAGIC", 3, 2048, 15.0F, 3.2F, Integer.MAX_VALUE);
	
	public static void loadItems()
	{
		// Tome
		POCItems.Tome = (ItemTome) new ItemTome(POCConfig.Tome_ID).setUnlocalizedName("Tome").setCreativeTab(POCItems.PoCTab);
		
		// Staff
		POCItems.Staves = (ItemStaff) new ItemStaff(POCConfig.Staves_ID).setUnlocalizedName("Staves").setCreativeTab(PoCTab);
		
		// Mana Star
		POCItems.ManaStar = (ItemManaStar) new ItemManaStar(POCConfig.ManaStar_ID).setUnlocalizedName("ManaStar").setCreativeTab(PoCTab);
		
		// The Sword of Shannara
		POCItems.ShannaraSword = (ItemSword) new ItemSword(POCConfig.ShannaraSword_ID, POCItems.magic).setUnlocalizedName("ShannaraSword").setTextureName("shannarasword").setCreativeTab(PoCTab);
		
		// Elixir
		POCItems.Elixir = (ItemElixir) new ItemElixir(POCConfig.Elixir_ID).setUnlocalizedName("elixir");
		
		// Elixir Bottle
		POCItems.ElixirBottle = (ItemElixirBottle) new ItemElixirBottle(POCConfig.ElixirBottle_ID).setUnlocalizedName("elixirbottle");
		
		addItem(POCItems.Tome, "\u00a7bTome", "\u00a7bBuch");
		addItem(POCItems.ManaStar, "Mana Star", "Manastern");
		addItem(POCItems.Tome, "\u00a7bTome");
		addItem(POCItems.ShannaraSword, "The Sword of Shannara");
		addItem(POCItems.Elixir, "Elixir");
		addItem(POCItems.ElixirBottle, "Elixir Bottle", "Elixirflasche");
	}
	
	public static void addItem(Item item, String en, String de)
	{
		LanguageRegistry.addName(item, en);
		LanguageRegistry.instance().addNameForObject(item, "de_DE", de);
	}
	
	public static void addItem(Item item, String name)
	{
		addItem(item, name, name);
	}
}
