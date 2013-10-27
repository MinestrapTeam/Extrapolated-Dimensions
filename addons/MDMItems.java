package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomCreativeTab;
import clashsoft.clashsoftapi.CustomItem;
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
	public static EnumToolMaterial			toolHeavenStone	= EnumHelper.addToolMaterial("HEAVENSTONE", 1, 64, 2F, 2, 12);
	public static EnumToolMaterial			toolShrekite	= EnumHelper.addToolMaterial("SHREKITE", 1, 128, 3F, 3, 9);
	public static EnumToolMaterial			toolClashium	= EnumHelper.addToolMaterial("CLASHIUM", 2, 256, 4F, 5, 11);
	public static EnumToolMaterial			toolHolyium		= EnumHelper.addToolMaterial("HOLYIUM", 3, 2048, 6F, 20, 10);
	public static EnumToolMaterial			toolEnergy		= EnumHelper.addToolMaterial("ENERGY", 3, 1536, 5F, 10, 2);
	public static EnumToolMaterial			toolPro			= EnumHelper.addToolMaterial("PRO", 3, 4096, 8F, 10, 10);
	
	public static EnumToolMaterial			toolFlaming		= EnumToolMaterial.IRON;
	public static EnumToolMaterial			toolMagic		= EnumHelper.addToolMaterial("MAGIC", 3, 2048, 15.0F, 3.2F, Integer.MAX_VALUE);
	
	public static EnumArmorMaterial			armorShrekite	= EnumHelper.addArmorMaterial("SHREKITE", 32, new int[] { 1, 5, 3, 1 }, 9);
	public static EnumArmorMaterial			armorClashium	= EnumHelper.addArmorMaterial("CLASHIUM", 64, new int[] { 2, 6, 4, 2 }, 11);
	public static EnumArmorMaterial			armorHolyium	= EnumHelper.addArmorMaterial("HOLYIUM", 128, new int[] { 3, 9, 7, 3 }, 10);
	public static EnumArmorMaterial			armorEnergy		= EnumHelper.addArmorMaterial("ENERGY", 256, new int[] { 6, 16, 12, 6 }, 2);
	public static EnumArmorMaterial			armorPro		= EnumHelper.addArmorMaterial("PRO", 512, new int[] { 7, 18, 14, 7 }, 10);
	
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
	public static Item						heavenStonePickaxe;
	public static Item						heavenStoneAxe;
	public static Item						heavenStoneHoe;
	
	public static Item						heavenWoodSword;
	public static Item						heavenWoodShovel;
	public static Item						heavenWoodPickaxe;
	public static Item						heavenWoodAxe;
	public static Item						heavenWoodHoe;
	
	public static Item						shrekiteSword;
	public static Item						shrekiteShovel;
	public static Item						shrekitePickaxe;
	public static Item						shrekiteAxe;
	public static Item						shrekiteHoe;
	
	public static Item						clashiumSword;
	public static Item						clashiumShovel;
	public static Item						clashiumPickaxe;
	public static Item						clashiumAxe;
	public static Item						clashiumHoe;
	
	public static Item						holyiumSword;
	public static Item						holyiumShovel;
	public static Item						holyiumPickaxe;
	public static Item						holyiumAxe;
	public static Item						holyiumHoe;
	
	public static Item						energySword;
	public static Item						energyShovel;
	public static Item						energyPickaxe;
	public static Item						energyAxe;
	public static Item						energyHoe;
	
	public static Item						proSword;
	public static Item						proShovel;
	public static Item						proPickaxe;
	public static Item						proAxe;
	public static Item						proHoe;
	
	public static Item						shrekiteHelmet;
	public static Item						shrekiteChestplate;
	public static Item						shrekiteLeggings;
	public static Item						shrekiteBoots;
	public static Item						shrekiteGloves;
	
	public static Item						clashiumHelmet;
	public static Item						clashiumChestplate;
	public static Item						clashiumLeggings;
	public static Item						clashiumBoots;
	public static Item						clashiumGloves;
	
	public static Item						holyiumHelmet;
	public static Item						holyiumChestplate;
	public static Item						holyiumLeggings;
	public static Item						holyiumBoots;
	public static Item						holyiumGloves;
	
	public static Item						energyHelmet;
	public static Item						energyChestplate;
	public static Item						energyLeggings;
	public static Item						energyBoots;
	public static Item						energyGloves;
	
	public static Item						proHelmet;
	public static Item						proChestplate;
	public static Item						proLeggings;
	public static Item						proBoots;
	public static Item						proGloves;
	
	public static CustomItem				materials;
	public static ItemBlurite				bluriteDust;
	public static ItemHeavenBow				heavenBow;
	public static ItemHeavenFood			heavenApple;
	public static ItemLifeHeart				heart;
	public static ItemFlamingSword			flamingSword;
	public static ItemPulsingSword			pulsingSword;
	public static ItemIceStick				icestick;
	public static ItemIceHammer				icehammer;
	public static ItemHeavenSoul			soul;
	public static ItemHeavenPortalActivator	heavenPortalActivator;
	public static ItemCape					capes;
	
	public static ItemStack					heavenStick;
	public static ItemStack					heavenArrow;
	public static ItemStack					shrekiteShard;
	public static ItemStack					clashiumIngot;
	public static ItemStack					holyiumIngot;
	public static ItemStack					energyOrb;
	public static ItemStack					proAlloy;
	
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
		
		int itemIndex = 26000;
		
		heavenWoodSword = (new ItemSword(MDMConfig.getItem("Heaven Wood Sword", itemIndex++), toolHeavenwood)).setUnlocalizedName("heavenwoodSword").setTextureName("heavenwoodSword");
		heavenWoodShovel = (new ItemSpade(MDMConfig.getItem("Heaven Wood Shovel", itemIndex++), toolHeavenwood)).setUnlocalizedName("heavenwoodShovel").setTextureName("heavenwoodShovel");
		heavenWoodPickaxe = (new ItemPickaxe(MDMConfig.getItem("Heaven Wood Pickaxe", itemIndex++), toolHeavenwood)).setUnlocalizedName("heavenwoodPickaxe").setTextureName("heavenwoodPickaxe");
		heavenWoodAxe = (new ItemAxe(MDMConfig.getItem("Heaven Wood Axe", itemIndex++), toolHeavenwood)).setUnlocalizedName("heavenwoodAxe").setTextureName("heavenwoodAxe");
		heavenWoodHoe = (new ItemHoe(MDMConfig.getItem("Heaven Wood Hoe", itemIndex++), toolHeavenwood)).setUnlocalizedName("heavenwoodHoe").setTextureName("heavenwoodHoe");
		
		heavenStoneSword = (new ItemSword(MDMConfig.getItem("Heaven Stone Sword", itemIndex++), toolHeavenStone)).setUnlocalizedName("heavenstoneSword").setTextureName("heavenstoneSword");
		heavenStoneShovel = (new ItemSpade(MDMConfig.getItem("Heaven Stone Shovel", itemIndex++), toolHeavenStone)).setUnlocalizedName("heavenstoneShovel").setTextureName("heavenstoneShovel");
		heavenStonePickaxe = (new ItemPickaxe(MDMConfig.getItem("Heaven Stone Pickaxe", itemIndex++), toolHeavenStone)).setUnlocalizedName("heavenstonePickaxe").setTextureName("heavenstonePickaxe");
		heavenStoneAxe = (new ItemAxe(MDMConfig.getItem("Heaven Stone Axe", itemIndex++), toolHeavenStone)).setUnlocalizedName("heavenstoneAxe").setTextureName("heavenstoneAxe");
		heavenStoneHoe = (new ItemHoe(MDMConfig.getItem("Heaven Stone Hoe", itemIndex++), toolHeavenStone)).setUnlocalizedName("heavenstoneHoe").setTextureName("heavenstoneHoe");
		
		shrekiteSword = (new ItemSword(MDMConfig.getItem("Shrekite Sword", itemIndex++), toolShrekite)).setUnlocalizedName("shrekiteSword").setTextureName("shrekiteSword");
		shrekiteShovel = (new ItemSpade(MDMConfig.getItem("Shrekite Shovel", itemIndex++), toolShrekite)).setUnlocalizedName("shrekiteShovel").setTextureName("shrekiteShovel");
		shrekitePickaxe = (new ItemPickaxe(MDMConfig.getItem("Shrekite Pickaxe", itemIndex++), toolShrekite)).setUnlocalizedName("shrekitePickaxe").setTextureName("shrekitePickaxe");
		shrekiteAxe = (new ItemAxe(MDMConfig.getItem("Shrekite Axe", itemIndex++), toolShrekite)).setUnlocalizedName("shrekiteAxe").setTextureName("shrekiteAxe");
		shrekiteHoe = (new ItemHoe(MDMConfig.getItem("Shrekite Hoe", itemIndex++), toolShrekite)).setUnlocalizedName("shrekiteHoe").setTextureName("shrekiteHoe");
		
		clashiumSword = (new ItemSword(MDMConfig.getItem("Clashium Sword", itemIndex++), toolClashium)).setUnlocalizedName("clashiumSword").setTextureName("clashiumSword");
		clashiumShovel = (new ItemSpade(MDMConfig.getItem("Clashium Shovel", itemIndex++), toolClashium)).setUnlocalizedName("clashiumShovel").setTextureName("clashiumShovel");
		clashiumPickaxe = (new ItemPickaxe(MDMConfig.getItem("Clashium Pickaxe", itemIndex++), toolClashium)).setUnlocalizedName("clashiumPickaxe").setTextureName("clashiumPickaxe");
		clashiumAxe = (new ItemAxe(MDMConfig.getItem("Clashium Axe", itemIndex++), toolClashium)).setUnlocalizedName("clashiumAxe").setTextureName("clashiumAxe");
		clashiumHoe = (new ItemHoe(MDMConfig.getItem("Clashium Hoe", itemIndex++), toolClashium)).setUnlocalizedName("clashiumHoe").setTextureName("clashiumHoe");
		
		holyiumSword = (new ItemSword(MDMConfig.getItem("Holyium Sword", itemIndex++), toolHolyium)).setUnlocalizedName("holyiumSword").setTextureName("holyiumSword");
		holyiumShovel = (new ItemSpade(MDMConfig.getItem("Holyium Shovel", itemIndex++), toolHolyium)).setUnlocalizedName("holyiumShovel").setTextureName("holyiumShovel");
		holyiumPickaxe = (new ItemPickaxe(MDMConfig.getItem("Holyium Pickaxe", itemIndex++), toolHolyium)).setUnlocalizedName("holyiumPickaxe").setTextureName("holyiumPickaxe");
		holyiumAxe = (new ItemAxe(MDMConfig.getItem("Holyium Axe", itemIndex++), toolHolyium)).setUnlocalizedName("holyiumAxe").setTextureName("holyiumAxe");
		holyiumHoe = (new ItemHoe(MDMConfig.getItem("Holyium Hoe", itemIndex++), toolHolyium)).setUnlocalizedName("holyiumHoe").setTextureName("holyiumHoe");
		
		energySword = (new ItemSword(MDMConfig.getItem("Energy Sword", itemIndex++), toolEnergy)).setUnlocalizedName("energySword").setTextureName("energySword");
		energyShovel = (new ItemSpade(MDMConfig.getItem("Energy Shovel", itemIndex++), toolEnergy)).setUnlocalizedName("energyShovel").setTextureName("energyShovel");
		energyPickaxe = (new ItemPickaxe(MDMConfig.getItem("Energy Pickaxe", itemIndex++), toolEnergy)).setUnlocalizedName("energyPickaxe").setTextureName("energyPickaxe");
		energyAxe = (new ItemAxe(MDMConfig.getItem("Energy Axe", itemIndex++), toolEnergy)).setUnlocalizedName("energyAxe").setTextureName("energyAxe");
		energyHoe = (new ItemHoe(MDMConfig.getItem("Energy Hoe", itemIndex++), toolEnergy)).setUnlocalizedName("energyHoe").setTextureName("energyHoe");
		
		proSword = (new ItemSword(MDMConfig.getItem("Pro Sword", itemIndex++), toolPro)).setUnlocalizedName("proSword").setTextureName("proSword");
		proShovel = (new ItemSpade(MDMConfig.getItem("Pro Shovel", itemIndex++), toolPro)).setUnlocalizedName("proShovel").setTextureName("proShovel");
		proPickaxe = (new ItemPickaxe(MDMConfig.getItem("Pro Pickaxe", itemIndex++), toolPro)).setUnlocalizedName("proPickaxe").setTextureName("proPickaxe");
		proAxe = (new ItemAxe(MDMConfig.getItem("Pro Axe", itemIndex++), toolPro)).setUnlocalizedName("proAxe").setTextureName("proAxe");
		proHoe = (new ItemHoe(MDMConfig.getItem("Pro Hoe", itemIndex++), toolPro)).setUnlocalizedName("proHoe").setTextureName("proHoe");
		
		shrekiteHelmet = new ItemArmor(MDMConfig.getItem("Shrekite Helmet", itemIndex++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 0).setUnlocalizedName("shrekiteHelmet").setTextureName("shrekiteHelmet");
		shrekiteChestplate = new ItemArmor(MDMConfig.getItem("Shrekite Chestplate", itemIndex++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 1).setUnlocalizedName("shrekiteChestplate").setTextureName("shrekiteChestplate");
		shrekiteLeggings = new ItemArmor(MDMConfig.getItem("Shrekite Leggings", itemIndex++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 2).setUnlocalizedName("shrekiteLeggings").setTextureName("shrekiteLeggings");
		shrekiteBoots = new ItemArmor(MDMConfig.getItem("Shrekite Helmet", itemIndex++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 3).setUnlocalizedName("shrekiteBoots").setTextureName("shrekiteBoots");
		shrekiteGloves = new ItemGloves(MDMConfig.getItem("Shrekite Gloves", itemIndex++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite")).setUnlocalizedName("shrekiteGloves").setTextureName("shrekiteGloves");
		
		clashiumHelmet = new ItemArmor(MDMConfig.getItem("Clashium Helmet", itemIndex++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 0).setUnlocalizedName("clashiumHelmet").setTextureName("clashiumHelmet");
		clashiumChestplate = new ItemArmor(MDMConfig.getItem("Clashium Chestplate", itemIndex++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 1).setUnlocalizedName("clashiumChestplate").setTextureName("clashiumChestplate");
		clashiumLeggings = new ItemArmor(MDMConfig.getItem("Clashium Leggings", itemIndex++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 2).setUnlocalizedName("clashiumLeggings").setTextureName("clashiumLeggings");
		clashiumBoots = new ItemArmor(MDMConfig.getItem("Clashium Helmet", itemIndex++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 3).setUnlocalizedName("clashiumBoots").setTextureName("clashiumBoots");
		clashiumGloves = new ItemGloves(MDMConfig.getItem("Clashium Gloves", itemIndex++), armorClashium, MDMCommonProxy.getArmorIndex("clashium")).setUnlocalizedName("clashiumGloves").setTextureName("clashiumGloves");
		
		holyiumHelmet = new ItemArmor(MDMConfig.getItem("Holyium Helmet", itemIndex++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 0).setUnlocalizedName("holyiumHelmet").setTextureName("holyiumHelmet");
		holyiumChestplate = new ItemArmor(MDMConfig.getItem("Holyium Chestplate", itemIndex++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 1).setUnlocalizedName("holyiumChestplate").setTextureName("holyiumChestplate");
		holyiumLeggings = new ItemArmor(MDMConfig.getItem("Holyium Leggings", itemIndex++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 2).setUnlocalizedName("holyiumLeggings").setTextureName("holyiumLeggings");
		holyiumBoots = new ItemArmor(MDMConfig.getItem("Holyium Helmet", itemIndex++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 3).setUnlocalizedName("holyiumBoots").setTextureName("holyiumBoots");
		holyiumGloves = new ItemGloves(MDMConfig.getItem("Holyium Gloves", itemIndex++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium")).setUnlocalizedName("holyiumGloves").setTextureName("holyiumGloves");
		
		energyHelmet = new ItemArmor(MDMConfig.getItem("Energy Helmet", itemIndex++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 0).setUnlocalizedName("energyHelmet").setTextureName("energyHelmet");
		energyChestplate = new ItemArmor(MDMConfig.getItem("Energy Chestplate", itemIndex++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 1).setUnlocalizedName("energyChestplate").setTextureName("energyChestplate");
		energyLeggings = new ItemArmor(MDMConfig.getItem("Energy Leggings", itemIndex++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 2).setUnlocalizedName("energyLeggings").setTextureName("energyLeggings");
		energyBoots = new ItemArmor(MDMConfig.getItem("Energy Helmet", itemIndex++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 3).setUnlocalizedName("energyBoots").setTextureName("energyBoots");
		energyGloves = new ItemGloves(MDMConfig.getItem("Energy Gloves", itemIndex++), armorEnergy, MDMCommonProxy.getArmorIndex("energy")).setUnlocalizedName("energyGloves").setTextureName("energyGloves");
		
		proHelmet = new ItemArmor(MDMConfig.getItem("Pro Helmet", itemIndex++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 0).setUnlocalizedName("proHelmet").setTextureName("proHelmet");
		proChestplate = new ItemArmor(MDMConfig.getItem("Pro Chestplate", itemIndex++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 1).setUnlocalizedName("proChestplate").setTextureName("proChestplate");
		proLeggings = new ItemArmor(MDMConfig.getItem("Pro Leggings", itemIndex++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 2).setUnlocalizedName("proLeggings").setTextureName("proLeggings");
		proBoots = new ItemArmor(MDMConfig.getItem("Pro Helmet", itemIndex++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 3).setUnlocalizedName("proBoots").setTextureName("proBoots");
		proGloves = new ItemGloves(MDMConfig.getItem("Pro Gloves", itemIndex++), armorPro, MDMCommonProxy.getArmorIndex("pro")).setUnlocalizedName("proGloves").setTextureName("proGloves");
		
		materials = new CustomItem(MDMConfig.getItem("Heaven Materials", itemIndex++), new String[] { "Heaven Stick", "Heaven Arrow", "Shrekite Shard", "Clashium Ingot", "Holyium Ingot", "Energy Orb", "Pro Alloy" }, new String[] { "heavenstick", "heavenarrow", "shrekite_shard", "clashium_ingot", "holyium_ingot", "energy_orb", "pro_alloy" });
		heavenStick = new ItemStack(materials, 1, 0);
		heavenArrow = new ItemStack(materials, 1, 1);
		shrekiteShard = new ItemStack(materials, 1, 2);
		clashiumIngot = new ItemStack(materials, 1, 3);
		holyiumIngot = new ItemStack(materials, 1, 4);
		energyOrb = new ItemStack(materials, 1, 5);
		proAlloy = new ItemStack(materials, 1, 6);
		
		bluriteDust = (ItemBlurite) (new ItemBlurite(MDMConfig.getItem("Blurite Dust", itemIndex++))).setUnlocalizedName("blurite_dust");
		heavenBow = (ItemHeavenBow) (new ItemHeavenBow(MDMConfig.getItem("Heaven Bow", itemIndex++))).setUnlocalizedName("heavenbow").setTextureName("heavenbow");
		heavenApple = (ItemHeavenFood) (new ItemHeavenFood(MDMConfig.getItem("Heaven Apple", itemIndex++), 2, 0, false)).setUnlocalizedName("heavenapple");
		heart = (ItemLifeHeart) (new ItemLifeHeart(MDMConfig.getItem("Life Heart", itemIndex++))).setUnlocalizedName("heart");
		flamingSword = (ItemFlamingSword) (new ItemFlamingSword(MDMConfig.getItem("Fire Sword", itemIndex++))).setUnlocalizedName("fireSword");
		pulsingSword = (ItemPulsingSword) (new ItemPulsingSword(MDMConfig.getItem("Pulsing Sword", itemIndex++))).setUnlocalizedName("pulseSword");
		icestick = (ItemIceStick) (new ItemIceStick(MDMConfig.getItem("Ice Stick", itemIndex++))).setUnlocalizedName("icestick");
		icehammer = (ItemIceHammer) (new ItemIceHammer(MDMConfig.getItem("Ice Hammer", itemIndex++))).setUnlocalizedName("icehammer");
		soul = (ItemHeavenSoul) (new ItemHeavenSoul(MDMConfig.getItem("Soul", itemIndex++))).setUnlocalizedName("soul");
		capes = (ItemCape) new ItemCape(MDMConfig.getItem("Cape", itemIndex++)).setUnlocalizedName("cape");
		
		heavenPortalActivator = (ItemHeavenPortalActivator) (new ItemHeavenPortalActivator(MDMConfig.getItem("Heaven Portal Activator", itemIndex++))).setUnlocalizedName("heavenportalactivator");
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
		
		CSItems.addTool(heavenWoodSword, "Heaven Wood Sword", MDMBlocks.heavenPlanks, 0);
		CSItems.addTool(heavenWoodShovel, "Heaven Wood Shovel", MDMBlocks.heavenPlanks, 1);
		CSItems.addTool(heavenWoodPickaxe, "Heaven Wood Pickaxe", MDMBlocks.heavenPlanks, 2);
		CSItems.addTool(heavenWoodAxe, "Heaven Wood Axe", MDMBlocks.heavenPlanks, 3);
		CSItems.addTool(heavenWoodHoe, "Heaven Wood Hoe", MDMBlocks.heavenPlanks, 4);
		
		CSItems.addTool(heavenStoneSword, "Heaven Stone Sword", MDMBlocks.heavenCobble, 0);
		CSItems.addTool(heavenStoneShovel, "Heaven Stone Shovel", MDMBlocks.heavenCobble, 1);
		CSItems.addTool(heavenStonePickaxe, "Heaven Stone Pickaxe", MDMBlocks.heavenCobble, 2);
		CSItems.addTool(heavenStoneAxe, "Heaven Stone Axe", MDMBlocks.heavenCobble, 3);
		CSItems.addTool(heavenStoneHoe, "Heaven Stone Hoe", MDMBlocks.heavenCobble, 4);
		
		CSItems.addTool(shrekiteSword, "Shrekite Sword", shrekiteShard, 0);
		CSItems.addTool(shrekiteShovel, "Shrekite Shovel", shrekiteShard, 1);
		CSItems.addTool(shrekitePickaxe, "Shrekite Pickaxe", shrekiteShard, 2);
		CSItems.addTool(shrekiteAxe, "Shrekite Axe", shrekiteShard, 3);
		CSItems.addTool(shrekiteHoe, "Shrekite Hoe", shrekiteShard, 4);
		
		CSItems.addTool(clashiumSword, "Clashium Sword", clashiumIngot, 0);
		CSItems.addTool(clashiumShovel, "Clashium Shovel", clashiumIngot, 1);
		CSItems.addTool(clashiumPickaxe, "Clashium Pickaxe", clashiumIngot, 2);
		CSItems.addTool(clashiumAxe, "Clashium Axe", clashiumIngot, 3);
		CSItems.addTool(clashiumHoe, "Clashium Hoe", clashiumIngot, 4);
		
		CSItems.addTool(holyiumSword, "Holyium Sword", holyiumIngot, 0);
		CSItems.addTool(holyiumShovel, "Holyium Shovel", holyiumIngot, 1);
		CSItems.addTool(holyiumPickaxe, "Holyium Pickaxe", holyiumIngot, 2);
		CSItems.addTool(holyiumAxe, "Holyium Axe", holyiumIngot, 3);
		CSItems.addTool(holyiumHoe, "Holyium Hoe", holyiumIngot, 4);
		
		CSItems.addTool(energySword, "Energy Sword", energyOrb, 0);
		CSItems.addTool(energyShovel, "Energy Shovel", energyOrb, 1);
		CSItems.addTool(energyPickaxe, "Energy Pickaxe", energyOrb, 2);
		CSItems.addTool(energyAxe, "Energy Axe", energyOrb, 3);
		CSItems.addTool(energyHoe, "Energy Hoe", energyOrb, 4);
		
		CSItems.addTool(proSword, "Pro Sword", proAlloy, 0);
		CSItems.addTool(proShovel, "Pro Shovel", proAlloy, 1);
		CSItems.addTool(proPickaxe, "Pro Pickaxe", proAlloy, 2);
		CSItems.addTool(proAxe, "Pro Axe", proAlloy, 3);
		CSItems.addTool(proHoe, "Pro Hoe", proAlloy, 4);
		
		CSItems.addArmor(shrekiteHelmet, "Shrekite Helmet", shrekiteShard, 0);
		CSItems.addArmor(shrekiteChestplate, "Shrekite Chestplate", shrekiteShard, 1);
		CSItems.addArmor(shrekitePickaxe, "Shrekite Leggings", shrekiteShard, 2);
		CSItems.addArmor(shrekiteBoots, "Shrekite Boots", shrekiteShard, 3);
		CSItems.addArmor(shrekiteGloves, "Shrekite Gloves", shrekiteShard, 4);
		
		CSItems.addArmor(clashiumHelmet, "Clashium Helmet", clashiumIngot, 0);
		CSItems.addArmor(clashiumChestplate, "Clashium Chestplate", clashiumIngot, 1);
		CSItems.addArmor(clashiumPickaxe, "Clashium Leggings", clashiumIngot, 2);
		CSItems.addArmor(clashiumBoots, "Clashium Boots", clashiumIngot, 3);
		CSItems.addArmor(clashiumGloves, "Clashium Gloves", clashiumIngot, 4);
		
		CSItems.addArmor(holyiumHelmet, "Holyium Helmet", holyiumIngot, 0);
		CSItems.addArmor(holyiumChestplate, "Holyium Chestplate", holyiumIngot, 1);
		CSItems.addArmor(holyiumPickaxe, "Holyium Leggings", holyiumIngot, 2);
		CSItems.addArmor(holyiumBoots, "Holyium Boots", holyiumIngot, 3);
		CSItems.addArmor(holyiumGloves, "Holyium Gloves", holyiumIngot, 4);
		
		CSItems.addArmor(energyHelmet, "Energy Helmet", energyOrb, 0);
		CSItems.addArmor(energyChestplate, "Energy Chestplate", energyOrb, 1);
		CSItems.addArmor(energyPickaxe, "Energy Leggings", energyOrb, 2);
		CSItems.addArmor(energyBoots, "Energy Boots", energyOrb, 3);
		CSItems.addArmor(energyGloves, "Energy Gloves", energyOrb, 4);
		
		CSItems.addArmor(proHelmet, "Pro Helmet", proAlloy, 0);
		CSItems.addArmor(proChestplate, "Pro Chestplate", proAlloy, 1);
		CSItems.addArmor(proPickaxe, "Pro Leggings", proAlloy, 2);
		CSItems.addArmor(proBoots, "Pro Boots", proAlloy, 3);
		CSItems.addArmor(proGloves, "Pro Gloves", proAlloy, 4);
		
		addItem(heavenPortalActivator, "Heaven Portal Activator");
		CSItems.addItemWithRecipe(bluriteDust, "Blurite Dust", 9, new Object[] { "X", Character.valueOf('X'), MDMBlocks.bluriteBlock });
		CSItems.addItemWithRecipe(heavenBow, "Heaven Bow", 1, new Object[] { "s| ", "s |", "s| ", Character.valueOf('s'), Item.silk, Character.valueOf('|'), heavenStick });
		addItem(heavenApple, "Heaven Apple");
		addItem(flamingSword, "Flaming Sword");
		addItem(pulsingSword, "Pulsing Sword");
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
