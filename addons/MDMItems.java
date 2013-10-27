package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomCreativeTab;
import clashsoft.clashsoftapi.util.CSItems;
import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.item.ItemCape;
import clashsoft.mods.moredimensions.item.ItemGloves;
import clashsoft.mods.moredimensions.item.heaven.*;
import clashsoft.mods.moredimensions.item.poc.ItemElixir;
import clashsoft.mods.moredimensions.item.poc.ItemElixirBottle;
import clashsoft.mods.moredimensions.item.poc.ItemStaff;
import clashsoft.mods.moredimensions.item.poc.ItemTome;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.common.EnumHelper;

@Addon(modName = "MoreDimensionsMod", addonName = "Items")
public class MDMItems
{
	public static CreativeTabs				PoCTab			= new CustomCreativeTab("PoCTab");
	public static CreativeTabs				AlchemyTab		= new CustomCreativeTab("ElixirTab");
	
	public static EnumToolMaterial			toolHeavenwood	= EnumToolMaterial.WOOD;
	public static EnumToolMaterial			toolHeavenStone	= EnumHelper.addToolMaterial("HEAVENSTONE", 1, 128, 4.5F, 2, 15);
	public static EnumToolMaterial			toolShrekite	= EnumHelper.addToolMaterial("SHREKITE", 2, 256, 5F, 3, 15);
	public static EnumToolMaterial			toolClashium	= EnumHelper.addToolMaterial("CLASHIUM", 3, 1024, 10F, 5, 15);
	public static EnumToolMaterial			toolHolyium		= EnumHelper.addToolMaterial("HALLOWED", 3, 4096, 5F, 20, 15);
	public static EnumToolMaterial			toolEnergy		= EnumHelper.addToolMaterial("ENERGY", 3, 1536, 4F, 10, 2);
	public static EnumToolMaterial			toolFlaming		= EnumToolMaterial.IRON;
	public static EnumToolMaterial			toolMagic		= EnumHelper.addToolMaterial("MAGIC", 3, 2048, 15.0F, 3.2F, Integer.MAX_VALUE);
	
	public static EnumArmorMaterial			armorShrekite	= EnumHelper.addArmorMaterial("SYWOXITE", 15, new int[] { 2, 7, 5, 2 }, 9);
	public static EnumArmorMaterial			armorClashium	= EnumHelper.addArmorMaterial("CLASHIUM", 33, new int[] { 4, 9, 6, 4 }, 11);
	public static EnumArmorMaterial			armorHolyium	= EnumHelper.addArmorMaterial("HALLOWED", 100, new int[] { 10, 15, 13, 6 }, 10);
	public static EnumArmorMaterial			armorEnergy		= EnumHelper.addArmorMaterial("ENERGY", 200, new int[] { 100, 150, 130, 60 }, 2);
	
	// -- Paradise of Chaos --
	
	public static ItemTome					tome;
	public static ItemStaff					staves;
	public static ItemManaStar				manaStar;
	public static ItemSword					shannaraSword;
	public static ItemElixir				elixir;
	public static ItemElixirBottle			elixirBottle;
	
	// -- Heaven --
	
	public static Item						heavenStoneSword;
	public static Item						heavenStoneShovel;
	public static Item						heavenStonePick;
	public static Item						heavenStoneAxe;
	public static Item						heavenStoneHoe;
	public static Item						heavenWoodSword;
	public static Item						heavenWoodShovel;
	public static Item						heavenWoodPick;
	public static Item						heavenWoodAxe;
	public static Item						heavenWoodHoe;
	
	public static Item						shrekiteSword;
	public static Item						shrekiteShovel;
	public static Item						shrekitePick;
	public static Item						shrekiteAxe;
	public static Item						shrekiteHoe;
	public static Item						shrekiteHelmet;
	public static Item						shrekiteChestplate;
	public static Item						shrekiteLeggings;
	public static Item						shrekiteBoots;
	public static Item						shrekiteGloves;
	
	public static Item						clashiumSword;
	public static Item						clashiumShovel;
	public static Item						clashiumPick;
	public static Item						clashiumAxe;
	public static Item						clashiumHoe;
	public static Item						holyiumSword;
	public static Item						holyiumShovel;
	public static Item						holyiumPick;
	public static Item						holyiumAxe;
	public static Item						holyiumHoe;
	public static Item						energySword;
	public static Item						energyShovel;
	public static Item						energyPick;
	public static Item						energyAxe;
	public static Item						energyHoe;
	public static Item						heavenStick;
	public static Item						shrekiteShard;
	public static Item						clashiumIngot;
	public static Item						holyiumIngot;
	public static ItemBlurite				bluriteDust;
	public static ItemHeavenBow				heavenBow;
	public static ItemHeavenMisc			heavenArrow;
	public static ItemHeavenFood			heavenApple;
	public static ItemLifeHeart				heart;
	public static ItemFlamingSword			flamingSword;
	public static ItemPulsingSword			pulsingSword;
	public static ItemIceStick				icestick;
	public static ItemIceHammer				icehammer;
	public static ItemHeavenSoul			soul;
	public static ItemHeavenPortalActivator	heavenPortalActivator;
	public static ItemCape					capes;
	
	public static void initialize()
	{
		// -- Paradise of Chaos --
		
		tome = (ItemTome) new ItemTome(MDMConfig.getItem("Tome", 25000)).setUnlocalizedName("Tome").setCreativeTab(MDMItems.PoCTab);
		staves = (ItemStaff) new ItemStaff(MDMConfig.getItem("Staves", 25001)).setUnlocalizedName("Staves").setCreativeTab(PoCTab);
		manaStar = (ItemManaStar) new ItemManaStar(MDMConfig.getItem("Mana Star", 25002)).setUnlocalizedName("ManaStar").setCreativeTab(PoCTab);
		shannaraSword = (ItemSword) new ItemSword(MDMConfig.getItem("Shannara Sword", 25003), MDMItems.toolMagic).setUnlocalizedName("ShannaraSword").setTextureName("shannarasword").setCreativeTab(PoCTab);
		elixir = (ItemElixir) new ItemElixir(MDMConfig.getItem("Elixir", 25004)).setUnlocalizedName("elixir");
		elixirBottle = (ItemElixirBottle) new ItemElixirBottle(MDMConfig.getItem("Elixir Bottle", 25005)).setUnlocalizedName("elixirbottle");
		
		// -- Heaven --
		
		heavenStoneSword = (new ItemSword(MDMConfig.getItem("Heaven Stone Sword", 26000), toolHeavenStone)).setUnlocalizedName("heavenstoneSword");
		heavenStoneShovel = (new ItemSpade(MDMConfig.getItem("Heaven Stone Shovel", 26001), toolHeavenStone)).setUnlocalizedName("heavenstoneShovel");
		heavenStonePick = (new ItemPickaxe(MDMConfig.getItem("Heaven Stone Pickaxe", 26002), toolHeavenStone)).setUnlocalizedName("heavenstonePickaxe");
		heavenStoneAxe = (new ItemAxe(MDMConfig.getItem("Heaven Stone Axe", 26003), toolHeavenStone)).setUnlocalizedName("heavenstoneAxe");
		heavenStoneHoe = (new ItemHoe(MDMConfig.getItem("Heaven Stone Hoe", 26004), toolHeavenStone)).setUnlocalizedName("heavenstoneHoe");
		
		heavenWoodSword = (new ItemSword(MDMConfig.getItem("Heaven Wood Sword", 26005), toolHeavenwood)).setUnlocalizedName("heavenwoodSword");
		heavenWoodShovel = (new ItemSpade(MDMConfig.getItem("Heaven Wood Shovel", 26006), toolHeavenwood)).setUnlocalizedName("heavenwoodShovel");
		heavenWoodPick = (new ItemPickaxe(MDMConfig.getItem("Heaven Wood Pickaxe", 26007), toolHeavenwood)).setUnlocalizedName("heavenwoodPickaxe");
		heavenWoodAxe = (new ItemAxe(MDMConfig.getItem("Heaven Wood Axe", 26008), toolHeavenwood)).setUnlocalizedName("heavenwoodAxe");
		heavenWoodHoe = (new ItemHoe(MDMConfig.getItem("Heaven Wood Hoe", 26009), toolHeavenwood)).setUnlocalizedName("heavenwoodHoe");
		
		shrekiteSword = (new ItemSword(MDMConfig.getItem("Shrekite Sword", 26010), toolShrekite)).setUnlocalizedName("shrekiteSword");
		shrekiteShovel = (new ItemSpade(MDMConfig.getItem("Shrekite Shovel", 26011), toolShrekite)).setUnlocalizedName("shrekiteShovel");
		shrekitePick = (new ItemPickaxe(MDMConfig.getItem("Shrekite Pickaxe", 26012), toolShrekite)).setUnlocalizedName("shrekitePickaxe");
		shrekiteAxe = (new ItemAxe(MDMConfig.getItem("Shrekite Axe", 26013), toolShrekite)).setUnlocalizedName("shrekiteAxe");
		shrekiteHoe = (new ItemHoe(MDMConfig.getItem("Shrekite Hoe", 26014), toolShrekite)).setUnlocalizedName("shrekiteHoe");
		
		shrekiteHelmet = new ItemArmor(MDMConfig.getItem("Shrekite Helmet", 26015), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 0).setUnlocalizedName("shrekiteHelmet").setTextureName("shrekiteHelmet");
		shrekiteChestplate = new ItemArmor(MDMConfig.getItem("Shrekite Chestplate", 26016), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 1).setUnlocalizedName("shrekiteChestplate").setTextureName("shrekiteChestplate");
		shrekiteLeggings = new ItemArmor(MDMConfig.getItem("Shrekite Leggings", 26017), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 2).setUnlocalizedName("shrekiteLeggings").setTextureName("shrekiteLeggings");
		shrekiteBoots = new ItemArmor(MDMConfig.getItem("Shrekite Helmet", 26018), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 3).setUnlocalizedName("shrekiteBoots").setTextureName("shrekiteBoots");
		shrekiteGloves = new ItemGloves(MDMConfig.getItem("Shrekite Gloves", 26019), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite")).setUnlocalizedName("shrekiteGloves").setTextureName("shrekiteGloves");
		
		clashiumSword = (new ItemSword(MDMConfig.getItem("Clashium Sword", 26019), toolClashium)).setUnlocalizedName("clashiumSword");
		clashiumShovel = (new ItemSpade(MDMConfig.getItem("Clashium Shovel", 26020), toolClashium)).setUnlocalizedName("clashiumShovel");
		clashiumPick = (new ItemPickaxe(MDMConfig.getItem("Clashium Pickaxe", 26021), toolClashium)).setUnlocalizedName("clashiumPickaxe");
		clashiumAxe = (new ItemAxe(MDMConfig.getItem("Clashium Axe", 26022), toolClashium)).setUnlocalizedName("clashiumAxe");
		clashiumHoe = (new ItemHoe(MDMConfig.getItem("Clashium Hoe", 26023), toolClashium)).setUnlocalizedName("clashiumHoe");
		
		holyiumSword = (new ItemSword(MDMConfig.getItem("Holyium Sword", 26028), toolHolyium)).setUnlocalizedName("holyiumSword");
		holyiumShovel = (new ItemSpade(MDMConfig.getItem("Holyium Shovel", 26029), toolHolyium)).setUnlocalizedName("holyiumShovel");
		holyiumPick = (new ItemPickaxe(MDMConfig.getItem("Holyium Pickaxe", 26030), toolHolyium)).setUnlocalizedName("holyiumPickaxe");
		holyiumAxe = (new ItemAxe(MDMConfig.getItem("Holyium Axe", 26031), toolHolyium)).setUnlocalizedName("holyiumAxe");
		holyiumHoe = (new ItemHoe(MDMConfig.getItem("Holyium Hoe", 26032), toolHolyium)).setUnlocalizedName("holyiumHoe");
		
		energySword = (new ItemSword(MDMConfig.getItem("Energy Sword", 26037), toolEnergy)).setUnlocalizedName("energySword");
		energyShovel = (new ItemSpade(MDMConfig.getItem("Energy Shovel", 26038), toolEnergy)).setUnlocalizedName("energyShovel");
		energyPick = (new ItemPickaxe(MDMConfig.getItem("Energy Pickaxe", 26039), toolEnergy)).setUnlocalizedName("energyPickaxe");
		energyAxe = (new ItemAxe(MDMConfig.getItem("Energy Axe", 26040), toolEnergy)).setUnlocalizedName("energyAxe");
		energyHoe = (new ItemHoe(MDMConfig.getItem("Energy Hoe", 26041), toolEnergy)).setUnlocalizedName("energyHoe");
		
		heavenStick = (new ItemHeavenMisc(MDMConfig.getItem("Heaven Stick", 26046), CreativeTabs.tabMaterials)).setUnlocalizedName("heavenstick");
		shrekiteShard = (new ItemHeavenMisc(MDMConfig.getItem("Shrekite Shard", 26047), CreativeTabs.tabMaterials)).setUnlocalizedName("shrekite_shard");
		clashiumIngot = (new ItemHeavenMisc(MDMConfig.getItem("Clashium Ingot", 26048), CreativeTabs.tabMaterials)).setUnlocalizedName("clashium_ingot");
		holyiumIngot = (new ItemHeavenMisc(MDMConfig.getItem("Holyium Ingot", 26049), CreativeTabs.tabMaterials)).setUnlocalizedName("holyium_ingot");
		bluriteDust = (ItemBlurite) (new ItemBlurite(MDMConfig.getItem("Blurite Dust", 26050))).setUnlocalizedName("blurite_dust");
		heavenBow = (ItemHeavenBow) (new ItemHeavenBow(MDMConfig.getItem("Heaven Bow", 26051))).setUnlocalizedName("heavenbow");
		heavenArrow = (ItemHeavenMisc) (new ItemHeavenMisc(MDMConfig.getItem("Heaven Arrow", 25052), CreativeTabs.tabCombat)).setUnlocalizedName("heavenarrow");
		heavenApple = (ItemHeavenFood) (new ItemHeavenFood(MDMConfig.getItem("Heaven Apple", 26053), 2, 0, false)).setUnlocalizedName("heavenapple");
		heart = (ItemLifeHeart) (new ItemLifeHeart(MDMConfig.getItem("Life Heart", 26053))).setUnlocalizedName("heart");
		flamingSword = (ItemFlamingSword) (new ItemFlamingSword(MDMConfig.getItem("Fire Sword", 26100))).setUnlocalizedName("fireSword_1");
		pulsingSword = (ItemPulsingSword) (new ItemPulsingSword(MDMConfig.getItem("Pulsing Sword", 26101))).setUnlocalizedName("pulsatingSword_1");
		icestick = (ItemIceStick) (new ItemIceStick(MDMConfig.getItem("Ice Stick", 26102))).setUnlocalizedName("icestick");
		icehammer = (ItemIceHammer) (new ItemIceHammer(MDMConfig.getItem("Ice Hammer", 26103))).setUnlocalizedName("icehammer");
		soul = (ItemHeavenSoul) (new ItemHeavenSoul(MDMConfig.getItem("Soul", 26104))).setUnlocalizedName("soul");
		capes = (ItemCape) new ItemCape(MDMConfig.getItem("Cape", 26105)).setUnlocalizedName("cape");
		
		heavenPortalActivator = (ItemHeavenPortalActivator) (new ItemHeavenPortalActivator(MDMConfig.getItem("Heaven Portal Activator", 26099))).setUnlocalizedName("heavenportalactivator");
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addItem(tome, "\u00a7bTome", "\u00a7bBuch");
		addItem(manaStar, "Mana Star", "Manastern");
		addItem(shannaraSword, "The Sword of Shannara");
		addItem(elixir, "Elixir", "Elixier");
		addItem(elixirBottle, "Elixir Bottle", "Elixierflasche");
		
		// -- Heaven --
		
		CSItems.addItemWithRecipe(heavenStick, "Heaven Wood Stick", 4, new Object[] { "w", "w", Character.valueOf('w'), new ItemStack(MDMBlocks.woodBlocks, 1, 0) });
		CSItems.addItem(heavenPortalActivator, "Heaven Portal Activator");
		
		CSItems.addItemWithRecipe(heavenStoneSword, "Heavenstone Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStoneShovel, "Heavenstone Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStonePick, "Heavenstone Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStoneAxe, "Heavenstone Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStoneHoe, "Heavenstone Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		
		CSItems.addItemWithRecipe(heavenWoodSword, "Heavenwood Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), new ItemStack(MDMBlocks.woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodShovel, "Heavenwood Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), new ItemStack(MDMBlocks.woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodPick, "Heavenwood Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), new ItemStack(MDMBlocks.woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodAxe, "Heavenwood Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), new ItemStack(MDMBlocks.woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodHoe, "Heavenwood Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), new ItemStack(MDMBlocks.woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		
		CSItems.addItemWithRecipe(shrekiteSword, "Shrekite Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), shrekiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(shrekiteShovel, "Shrekite Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), shrekiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(shrekitePick, "Shrekite Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), shrekiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(shrekiteAxe, "Shrekite Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), shrekiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(shrekiteHoe, "Shrekite Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), shrekiteShard, Character.valueOf('|'), heavenStick });
		
		CSItems.addItemWithRecipe(shrekiteHelmet, "Shrekite Helmet", 1, new Object[] { "XXX", "X X", Character.valueOf('X'), shrekiteShard });
		CSItems.addItemWithRecipe(shrekiteChestplate, "Shrekite Chestplate", 1, new Object[] { "X X", "XXX", "XXX", Character.valueOf('X'), shrekiteShard });
		CSItems.addItemWithRecipe(shrekiteLeggings, "Shrekite Leggings", 1, new Object[] { "XXX", "X X", "X X", Character.valueOf('X'), shrekiteShard });
		CSItems.addItemWithRecipe(shrekiteBoots, "Shrekite Boots", 1, new Object[] { "X X", "X X", Character.valueOf('X'), shrekiteShard });
		CSItems.addItemWithRecipe(shrekiteGloves, "Shrekite Gloves", 1, "X X", 'X', shrekiteShard);
		
		CSItems.addItemWithRecipe(clashiumSword, "Clashium Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumShovel, "Clashium Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumPick, "Clashium Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumAxe, "Clashium Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumHoe, "Clashium Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		
		CSItems.addItemWithRecipe(holyiumSword, "Holyium Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumShovel, "Holyium Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumPick, "Holyium Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumAxe, "Holyium Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumHoe, "Holyium Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		
		CSItems.addItem(energySword, "Energy Sword");
		CSItems.addItem(energyShovel, "Energy Shovel");
		CSItems.addItem(energyPick, "Energy Pickaxe");
		CSItems.addItem(energyAxe, "Energy Axe");
		CSItems.addItem(energyHoe, "Energy Hoe");
		
		CSItems.addItemWithRecipe(shrekiteShard, "Shrekite Shard", 9, "X", 'X', new ItemStack(MDMBlocks.stoneBlocks, 1, 7));
		CSItems.addItemWithRecipe(clashiumIngot, "Clashium Ingot", 9, new Object[] { "X", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 8) });
		CSItems.addItemWithRecipe(holyiumIngot, "Holyium Ingot", 9, new Object[] { "X", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 10) });
		CSItems.addItemWithRecipe(bluriteDust, "Blurite Dust", 9, new Object[] { "X", Character.valueOf('X'), new ItemStack(MDMBlocks.stoneBlocks, 1, 9) });
		CSItems.addItemWithRecipe(heavenBow, "Heaven Bow", 1, new Object[] { "s| ", "s |", "s| ", Character.valueOf('s'), Item.silk, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenArrow, "Heaven Arrow", 1, new Object[] { "s", "|", "f", Character.valueOf('s'), shrekiteShard, Character.valueOf('|'), heavenStick, Character.valueOf('f'), Item.feather });
		CSItems.addItem(heavenApple, "Heaven Apple");
		CSItems.addItem(flamingSword, "Flaming Sword");
		CSItems.addItem(pulsingSword, "Pulsing Sword");
		CSItems.addItemWithRecipe(icestick, "Ice Stick", 1, new Object[] { "i", "i", Character.valueOf('i'), Block.ice });
		CSItems.addItemWithRecipe(icehammer, "Ice Hammer", 1, new Object[] { "IiI", "IiI", " i ", Character.valueOf('I'), Block.ice, Character.valueOf('i'), icestick });
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
