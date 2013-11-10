package clashsoft.mods.moredimensions.addons;

import java.lang.reflect.Constructor;

import clashsoft.clashsoftapi.CustomCreativeTab;
import clashsoft.clashsoftapi.CustomItem;
import clashsoft.clashsoftapi.util.CSItems;
import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.item.armor.ItemCape;
import clashsoft.mods.moredimensions.item.armor.ItemGloves;
import clashsoft.mods.moredimensions.item.heaven.*;
import clashsoft.mods.moredimensions.item.poc.*;
import clashsoft.mods.moredimensions.item.tools.ItemBowMDM;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.common.EnumHelper;

@Addon(modName = "MoreDimensionsMod", addonName = "Items")
public class MDMItems
{
	public static CustomCreativeTab			tabTools			= new CustomCreativeTab("MDMTools");
	
	public static CustomCreativeTab			tabParadiseOfChaos	= new CustomCreativeTab("POCTab");
	public static CustomCreativeTab			tabAlchemy			= new CustomCreativeTab("AlchemyTab");
	
	public static CustomCreativeTab			tabHeavenBlocks		= new CustomCreativeTab("HeavenBlocks");
	public static CustomCreativeTab			tabHeavenTools		= new CustomCreativeTab("HeavenTools");
	public static CustomCreativeTab			tabHeavenArmor		= new CustomCreativeTab("HeavenArmor");
	public static CustomCreativeTab			tabHeavenMaterials	= new CustomCreativeTab("HeavenMaterials");
	
	public static EnumToolMaterial			toolHeavenwood		= EnumHelper.addToolMaterial("HEAVENWOOD", 0, 64, 1F, 1F, 14);
	public static EnumToolMaterial			toolHeavenStone		= EnumHelper.addToolMaterial("HEAVENSTONE", 1, 64, 2F, 2, 12);
	public static EnumToolMaterial			toolShrekite		= EnumHelper.addToolMaterial("SHREKITE", 1, 128, 3F, 3, 9);
	public static EnumToolMaterial			toolClashium		= EnumHelper.addToolMaterial("CLASHIUM", 2, 256, 4F, 5, 11);
	public static EnumToolMaterial			toolHolyium			= EnumHelper.addToolMaterial("HOLYIUM", 3, 2048, 6F, 20, 10);
	public static EnumToolMaterial			toolEnergy			= EnumHelper.addToolMaterial("ENERGY", 3, 1536, 5F, 10, 2);
	public static EnumToolMaterial			toolPro				= EnumHelper.addToolMaterial("PRO", 3, 4096, 8F, 10, 10);
	
	public static EnumToolMaterial			toolFlaming			= EnumToolMaterial.IRON;
	public static EnumToolMaterial			toolMagic			= EnumHelper.addToolMaterial("MAGIC", 3, 2048, 15.0F, 3.2F, Integer.MAX_VALUE);
	
	public static EnumArmorMaterial			armorShrekite		= EnumHelper.addArmorMaterial("SHREKITE", 32, new int[] { 1, 5, 3, 1 }, 9);
	public static EnumArmorMaterial			armorClashium		= EnumHelper.addArmorMaterial("CLASHIUM", 64, new int[] { 2, 6, 4, 2 }, 11);
	public static EnumArmorMaterial			armorHolyium		= EnumHelper.addArmorMaterial("HOLYIUM", 128, new int[] { 3, 9, 7, 3 }, 10);
	public static EnumArmorMaterial			armorEnergy			= EnumHelper.addArmorMaterial("ENERGY", 256, new int[] { 6, 16, 12, 6 }, 2);
	public static EnumArmorMaterial			armorPro			= EnumHelper.addArmorMaterial("PRO", 512, new int[] { 7, 18, 14, 7 }, 10);
	
	// -- Paradise of Chaos --
	
	public static ItemAlchemyGuide			alchemyGuide;
	public static ItemStaff					staves;
	public static ItemManaStar				manaStar;
	public static ItemSword					shannaraSword;
	
	public static ItemElixir				elixir;
	public static ItemElixirBottle			elixirBottle;
	
	// -- Heaven --
	
	public static int						itemID				= 26000;
	
	public static Item						heavenStoneSword, heavenStoneShovel, heavenStonePickaxe, heavenStoneAxe, heavenStoneHoe;
	public static Item						heavenWoodSword, heavenWoodShovel, heavenWoodPickaxe, heavenWoodAxe, heavenWoodHoe;
	public static Item						shrekiteSword, shrekiteShovel, shrekitePickaxe, shrekiteAxe, shrekiteHoe;
	public static Item						clashiumSword, clashiumShovel, clashiumPickaxe, clashiumAxe, clashiumHoe;
	public static Item						holyiumSword, holyiumShovel, holyiumPickaxe, holyiumAxe, holyiumHoe;
	public static Item						energySword, energyShovel, energyPickaxe, energyAxe, energyHoe;
	public static Item						proSword, proShovel, proPickaxe, proAxe, proHoe;
	public static Item						goldWoodSword, goldWoodShovel, goldWoodPickaxe, goldWoodAxe, goldWoodHoe;
	
	public static Item						shrekiteHelmet, shrekiteChestplate, shrekiteLeggings, shrekiteBoots, shrekiteGloves;
	public static Item						clashiumHelmet, clashiumChestplate, clashiumLeggings, clashiumBoots, clashiumGloves;
	public static Item						holyiumHelmet, holyiumChestplate, holyiumLeggings, holyiumBoots, holyiumGloves;
	public static Item						energyHelmet, energyChestplate, energyLeggings, energyBoots, energyGloves;
	public static Item						proHelmet, proChestplate, proLeggings, proBoots, proGloves;
	
	public static CustomItem				materials;
	public static ItemBowMDM				heavenBow;
	public static ItemHeavenFood			heavenApple;
	public static ItemLifeHeart				heart;
	public static ItemFlamingSword			flamingSword;
	public static ItemPulsingSword			pulsingSword;
	public static ItemIceStick				icestick;
	public static ItemIceHammer				icehammer;
	public static ItemHeavenSoul			soul;
	public static ItemHeavenPortalActivator	heavenPortalActivator;
	public static ItemCape					capes;
	
	public static ItemStack					heavenwoodStick, goldwoodStick, heavenArrow, shrekiteShard, clashiumIngot, holyiumIngot, energyOrb, proAlloy, bluriteDust;
	
	public static void initialize()
	{
		// -- Paradise of Chaos --
		
		alchemyGuide = (ItemAlchemyGuide) new ItemAlchemyGuide(MDMConfig.getItem("Alchemy Guide", 25000)).setUnlocalizedName("alchemyGuide").setCreativeTab(MDMItems.tabParadiseOfChaos);
		staves = (ItemStaff) new ItemStaff(MDMConfig.getItem("Staves", 25001)).setUnlocalizedName("staves").setCreativeTab(tabParadiseOfChaos);
		manaStar = (ItemManaStar) new ItemManaStar(MDMConfig.getItem("Mana Star", 25002)).setUnlocalizedName("manastar").setCreativeTab(tabParadiseOfChaos);
		shannaraSword = (ItemSword) new ItemSword(MDMConfig.getItem("Shannara Sword", 25003), MDMItems.toolMagic).setUnlocalizedName("shannaraSword").setTextureName("shannarasword").setCreativeTab(tabParadiseOfChaos);
		elixir = (ItemElixir) new ItemElixir(MDMConfig.getItem("Elixir", 25004)).setUnlocalizedName("elixir");
		elixirBottle = (ItemElixirBottle) new ItemElixirBottle(MDMConfig.getItem("Elixir Bottle", 25005)).setUnlocalizedName("elixirbottle");
		
		// -- Heaven --
		
		heavenWoodSword = (new ItemSword(MDMConfig.getItem("Heaven Wood Sword", itemID++), toolHeavenwood)).setUnlocalizedName("heavenwoodSword").setTextureName("heavenwoodSword").setCreativeTab(tabHeavenTools);
		heavenWoodShovel = (new ItemSpade(MDMConfig.getItem("Heaven Wood Shovel", itemID++), toolHeavenwood)).setUnlocalizedName("heavenwoodShovel").setTextureName("heavenwoodShovel").setCreativeTab(tabHeavenTools);
		heavenWoodPickaxe = (new ItemPickaxe(MDMConfig.getItem("Heaven Wood Pickaxe", itemID++), toolHeavenwood)).setUnlocalizedName("heavenwoodPickaxe").setTextureName("heavenwoodPickaxe").setCreativeTab(tabHeavenTools);
		heavenWoodAxe = (new ItemAxe(MDMConfig.getItem("Heaven Wood Axe", itemID++), toolHeavenwood)).setUnlocalizedName("heavenwoodAxe").setTextureName("heavenwoodAxe").setCreativeTab(tabHeavenTools);
		heavenWoodHoe = (new ItemHoe(MDMConfig.getItem("Heaven Wood Hoe", itemID++), toolHeavenwood)).setUnlocalizedName("heavenwoodHoe").setTextureName("heavenwoodHoe").setCreativeTab(tabHeavenTools);
		
		heavenStoneSword = (new ItemSword(MDMConfig.getItem("Heaven Stone Sword", itemID++), toolHeavenStone)).setUnlocalizedName("heavenstoneSword").setTextureName("heavenstoneSword").setCreativeTab(tabHeavenTools);
		heavenStoneShovel = (new ItemSpade(MDMConfig.getItem("Heaven Stone Shovel", itemID++), toolHeavenStone)).setUnlocalizedName("heavenstoneShovel").setTextureName("heavenstoneShovel").setCreativeTab(tabHeavenTools);
		heavenStonePickaxe = (new ItemPickaxe(MDMConfig.getItem("Heaven Stone Pickaxe", itemID++), toolHeavenStone)).setUnlocalizedName("heavenstonePickaxe").setTextureName("heavenstonePickaxe").setCreativeTab(tabHeavenTools);
		heavenStoneAxe = (new ItemAxe(MDMConfig.getItem("Heaven Stone Axe", itemID++), toolHeavenStone)).setUnlocalizedName("heavenstoneAxe").setTextureName("heavenstoneAxe").setCreativeTab(tabHeavenTools);
		heavenStoneHoe = (new ItemHoe(MDMConfig.getItem("Heaven Stone Hoe", itemID++), toolHeavenStone)).setUnlocalizedName("heavenstoneHoe").setTextureName("heavenstoneHoe").setCreativeTab(tabHeavenTools);
		
		shrekiteSword = (new ItemSword(MDMConfig.getItem("Shrekite Sword", itemID++), toolShrekite)).setUnlocalizedName("shrekiteSword").setTextureName("shrekiteSword").setCreativeTab(tabHeavenTools);
		shrekiteShovel = (new ItemSpade(MDMConfig.getItem("Shrekite Shovel", itemID++), toolShrekite)).setUnlocalizedName("shrekiteShovel").setTextureName("shrekiteShovel").setCreativeTab(tabHeavenTools);
		shrekitePickaxe = (new ItemPickaxe(MDMConfig.getItem("Shrekite Pickaxe", itemID++), toolShrekite)).setUnlocalizedName("shrekitePickaxe").setTextureName("shrekitePickaxe").setCreativeTab(tabHeavenTools);
		shrekiteAxe = (new ItemAxe(MDMConfig.getItem("Shrekite Axe", itemID++), toolShrekite)).setUnlocalizedName("shrekiteAxe").setTextureName("shrekiteAxe").setCreativeTab(tabHeavenTools);
		shrekiteHoe = (new ItemHoe(MDMConfig.getItem("Shrekite Hoe", itemID++), toolShrekite)).setUnlocalizedName("shrekiteHoe").setTextureName("shrekiteHoe").setCreativeTab(tabHeavenTools);
		
		clashiumSword = (new ItemSword(MDMConfig.getItem("Clashium Sword", itemID++), toolClashium)).setUnlocalizedName("clashiumSword").setTextureName("clashiumSword").setCreativeTab(tabHeavenTools);
		clashiumShovel = (new ItemSpade(MDMConfig.getItem("Clashium Shovel", itemID++), toolClashium)).setUnlocalizedName("clashiumShovel").setTextureName("clashiumShovel").setCreativeTab(tabHeavenTools);
		clashiumPickaxe = (new ItemPickaxe(MDMConfig.getItem("Clashium Pickaxe", itemID++), toolClashium)).setUnlocalizedName("clashiumPickaxe").setTextureName("clashiumPickaxe").setCreativeTab(tabHeavenTools);
		clashiumAxe = (new ItemAxe(MDMConfig.getItem("Clashium Axe", itemID++), toolClashium)).setUnlocalizedName("clashiumAxe").setTextureName("clashiumAxe").setCreativeTab(tabHeavenTools);
		clashiumHoe = (new ItemHoe(MDMConfig.getItem("Clashium Hoe", itemID++), toolClashium)).setUnlocalizedName("clashiumHoe").setTextureName("clashiumHoe").setCreativeTab(tabHeavenTools);
		
		holyiumSword = (new ItemSword(MDMConfig.getItem("Holyium Sword", itemID++), toolHolyium)).setUnlocalizedName("holyiumSword").setTextureName("holyiumSword").setCreativeTab(tabHeavenTools);
		holyiumShovel = (new ItemSpade(MDMConfig.getItem("Holyium Shovel", itemID++), toolHolyium)).setUnlocalizedName("holyiumShovel").setTextureName("holyiumShovel").setCreativeTab(tabHeavenTools);
		holyiumPickaxe = (new ItemPickaxe(MDMConfig.getItem("Holyium Pickaxe", itemID++), toolHolyium)).setUnlocalizedName("holyiumPickaxe").setTextureName("holyiumPickaxe").setCreativeTab(tabHeavenTools);
		holyiumAxe = (new ItemAxe(MDMConfig.getItem("Holyium Axe", itemID++), toolHolyium)).setUnlocalizedName("holyiumAxe").setTextureName("holyiumAxe").setCreativeTab(tabHeavenTools);
		holyiumHoe = (new ItemHoe(MDMConfig.getItem("Holyium Hoe", itemID++), toolHolyium)).setUnlocalizedName("holyiumHoe").setTextureName("holyiumHoe").setCreativeTab(tabHeavenTools);
		
		energySword = (new ItemSword(MDMConfig.getItem("Energy Sword", itemID++), toolEnergy)).setUnlocalizedName("energySword").setTextureName("energySword").setCreativeTab(tabHeavenTools);
		energyShovel = (new ItemSpade(MDMConfig.getItem("Energy Shovel", itemID++), toolEnergy)).setUnlocalizedName("energyShovel").setTextureName("energyShovel").setCreativeTab(tabHeavenTools);
		energyPickaxe = (new ItemPickaxe(MDMConfig.getItem("Energy Pickaxe", itemID++), toolEnergy)).setUnlocalizedName("energyPickaxe").setTextureName("energyPickaxe").setCreativeTab(tabHeavenTools);
		energyAxe = (new ItemAxe(MDMConfig.getItem("Energy Axe", itemID++), toolEnergy)).setUnlocalizedName("energyAxe").setTextureName("energyAxe").setCreativeTab(tabHeavenTools);
		energyHoe = (new ItemHoe(MDMConfig.getItem("Energy Hoe", itemID++), toolEnergy)).setUnlocalizedName("energyHoe").setTextureName("energyHoe").setCreativeTab(tabHeavenTools);
		
		proSword = (new ItemSword(MDMConfig.getItem("Pro Sword", itemID++), toolPro)).setUnlocalizedName("proSword").setTextureName("proSword").setCreativeTab(tabHeavenTools);
		proShovel = (new ItemSpade(MDMConfig.getItem("Pro Shovel", itemID++), toolPro)).setUnlocalizedName("proShovel").setTextureName("proShovel").setCreativeTab(tabHeavenTools);
		proPickaxe = (new ItemPickaxe(MDMConfig.getItem("Pro Pickaxe", itemID++), toolPro)).setUnlocalizedName("proPickaxe").setTextureName("proPickaxe").setCreativeTab(tabHeavenTools);
		proAxe = (new ItemAxe(MDMConfig.getItem("Pro Axe", itemID++), toolPro)).setUnlocalizedName("proAxe").setTextureName("proAxe").setCreativeTab(tabHeavenTools);
		proHoe = (new ItemHoe(MDMConfig.getItem("Pro Hoe", itemID++), toolPro)).setUnlocalizedName("proHoe").setTextureName("proHoe").setCreativeTab(tabHeavenTools);
		
		goldWoodSword = (new ItemSword(MDMConfig.getItem("Gold Wood Sword", itemID++), toolHeavenwood)).setUnlocalizedName("goldwoodSword").setTextureName("goldwoodSword").setCreativeTab(tabHeavenTools);
		goldWoodShovel = (new ItemSpade(MDMConfig.getItem("Gold Wood Shovel", itemID++), toolHeavenwood)).setUnlocalizedName("goldwoodShovel").setTextureName("goldwoodShovel").setCreativeTab(tabHeavenTools);
		goldWoodPickaxe = (new ItemPickaxe(MDMConfig.getItem("Gold Wood Pickaxe", itemID++), toolHeavenwood)).setUnlocalizedName("goldwoodPickaxe").setTextureName("goldwoodPickaxe").setCreativeTab(tabHeavenTools);
		goldWoodAxe = (new ItemAxe(MDMConfig.getItem("Gold Wood Axe", itemID++), toolHeavenwood)).setUnlocalizedName("goldwoodAxe").setTextureName("goldwoodAxe").setCreativeTab(tabHeavenTools);
		goldWoodHoe = (new ItemHoe(MDMConfig.getItem("Gold Wood Hoe", itemID++), toolHeavenwood)).setUnlocalizedName("goldwoodHoe").setTextureName("goldwoodHoe").setCreativeTab(tabHeavenTools);
		
		shrekiteHelmet = new ItemArmor(MDMConfig.getItem("Shrekite Helmet", itemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 0).setUnlocalizedName("shrekiteHelmet").setTextureName("shrekiteHelmet").setCreativeTab(tabHeavenArmor);
		shrekiteChestplate = new ItemArmor(MDMConfig.getItem("Shrekite Chestplate", itemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 1).setUnlocalizedName("shrekiteChestplate").setTextureName("shrekiteChestplate").setCreativeTab(tabHeavenArmor);
		shrekiteLeggings = new ItemArmor(MDMConfig.getItem("Shrekite Leggings", itemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 2).setUnlocalizedName("shrekiteLeggings").setTextureName("shrekiteLeggings").setCreativeTab(tabHeavenArmor);
		shrekiteBoots = new ItemArmor(MDMConfig.getItem("Shrekite Boots", itemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 3).setUnlocalizedName("shrekiteBoots").setTextureName("shrekiteBoots").setCreativeTab(tabHeavenArmor);
		shrekiteGloves = new ItemGloves(MDMConfig.getItem("Shrekite Gloves", itemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite")).setUnlocalizedName("shrekiteGloves").setTextureName("shrekiteGloves").setCreativeTab(tabHeavenArmor);
		
		clashiumHelmet = new ItemArmor(MDMConfig.getItem("Clashium Helmet", itemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 0).setUnlocalizedName("clashiumHelmet").setTextureName("clashiumHelmet").setCreativeTab(tabHeavenArmor);
		clashiumChestplate = new ItemArmor(MDMConfig.getItem("Clashium Chestplate", itemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 1).setUnlocalizedName("clashiumChestplate").setTextureName("clashiumChestplate").setCreativeTab(tabHeavenArmor);
		clashiumLeggings = new ItemArmor(MDMConfig.getItem("Clashium Leggings", itemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 2).setUnlocalizedName("clashiumLeggings").setTextureName("clashiumLeggings").setCreativeTab(tabHeavenArmor);
		clashiumBoots = new ItemArmor(MDMConfig.getItem("Clashium Boots", itemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 3).setUnlocalizedName("clashiumBoots").setTextureName("clashiumBoots").setCreativeTab(tabHeavenArmor);
		clashiumGloves = new ItemGloves(MDMConfig.getItem("Clashium Gloves", itemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium")).setUnlocalizedName("clashiumGloves").setTextureName("clashiumGloves").setCreativeTab(tabHeavenArmor);
		
		holyiumHelmet = new ItemArmor(MDMConfig.getItem("Holyium Helmet", itemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 0).setUnlocalizedName("holyiumHelmet").setTextureName("holyiumHelmet").setCreativeTab(tabHeavenArmor);
		holyiumChestplate = new ItemArmor(MDMConfig.getItem("Holyium Chestplate", itemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 1).setUnlocalizedName("holyiumChestplate").setTextureName("holyiumChestplate").setCreativeTab(tabHeavenArmor);
		holyiumLeggings = new ItemArmor(MDMConfig.getItem("Holyium Leggings", itemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 2).setUnlocalizedName("holyiumLeggings").setTextureName("holyiumLeggings").setCreativeTab(tabHeavenArmor);
		holyiumBoots = new ItemArmor(MDMConfig.getItem("Holyium Boots", itemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 3).setUnlocalizedName("holyiumBoots").setTextureName("holyiumBoots").setCreativeTab(tabHeavenArmor);
		holyiumGloves = new ItemGloves(MDMConfig.getItem("Holyium Gloves", itemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium")).setUnlocalizedName("holyiumGloves").setTextureName("holyiumGloves").setCreativeTab(tabHeavenArmor);
		
		energyHelmet = new ItemArmor(MDMConfig.getItem("Energy Helmet", itemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 0).setUnlocalizedName("energyHelmet").setTextureName("energyHelmet").setCreativeTab(tabHeavenArmor);
		energyChestplate = new ItemArmor(MDMConfig.getItem("Energy Chestplate", itemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 1).setUnlocalizedName("energyChestplate").setTextureName("energyChestplate").setCreativeTab(tabHeavenArmor);
		energyLeggings = new ItemArmor(MDMConfig.getItem("Energy Leggings", itemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 2).setUnlocalizedName("energyLeggings").setTextureName("energyLeggings").setCreativeTab(tabHeavenArmor);
		energyBoots = new ItemArmor(MDMConfig.getItem("Energy Boots", itemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 3).setUnlocalizedName("energyBoots").setTextureName("energyBoots").setCreativeTab(tabHeavenArmor);
		energyGloves = new ItemGloves(MDMConfig.getItem("Energy Gloves", itemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy")).setUnlocalizedName("energyGloves").setTextureName("energyGloves").setCreativeTab(tabHeavenArmor);
		
		proHelmet = new ItemArmor(MDMConfig.getItem("Pro Helmet", itemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 0).setUnlocalizedName("proHelmet").setTextureName("proHelmet").setCreativeTab(tabHeavenArmor);
		proChestplate = new ItemArmor(MDMConfig.getItem("Pro Chestplate", itemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 1).setUnlocalizedName("proChestplate").setTextureName("proChestplate").setCreativeTab(tabHeavenArmor);
		proLeggings = new ItemArmor(MDMConfig.getItem("Pro Leggings", itemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 2).setUnlocalizedName("proLeggings").setTextureName("proLeggings").setCreativeTab(tabHeavenArmor);
		proBoots = new ItemArmor(MDMConfig.getItem("Pro Boots", itemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 3).setUnlocalizedName("proBoots").setTextureName("proBoots").setCreativeTab(tabHeavenArmor);
		proGloves = new ItemGloves(MDMConfig.getItem("Pro Gloves", itemID++), armorPro, MDMCommonProxy.getArmorIndex("pro")).setUnlocalizedName("proGloves").setTextureName("proGloves").setCreativeTab(tabHeavenArmor);
		
		materials = (CustomItem) new CustomItem(MDMConfig.getItem("Heaven Materials", itemID++), new String[] { "Heaven Wood Stick", "Gold Wood Stick", "Heaven Arrow", "Shrekite Shard", "Clashium Ingot", "Holyium Ingot", "Energy Orb", "Pro Alloy", "Blurite Dust" }, new String[] { "heavenwoodStick", "goldwoodStick", "heavenArrow", "shrekiteShard", "clashiumIngot", "holyiumIngot", "energyOrb", "proAlloy", "blurite" }).setCreativeTab(tabHeavenMaterials);
		heavenwoodStick = new ItemStack(materials, 1, 0);
		goldwoodStick = new ItemStack(materials, 1, 1);
		heavenArrow = new ItemStack(materials, 1, 2);
		shrekiteShard = new ItemStack(materials, 1, 3);
		clashiumIngot = new ItemStack(materials, 1, 4);
		holyiumIngot = new ItemStack(materials, 1, 5);
		energyOrb = new ItemStack(materials, 1, 6);
		proAlloy = new ItemStack(materials, 1, 7);
		bluriteDust = new ItemStack(materials, 1, 8);
		
		heavenBow = (ItemBowMDM) (new ItemBowMDM(MDMConfig.getItem("Heaven Bow", itemID++), "heavenbow", heavenArrow)).setUnlocalizedName("heavenwoodBow");
		heavenApple = (ItemHeavenFood) (new ItemHeavenFood(MDMConfig.getItem("Heaven Apple", itemID++), 2, 0, false)).setUnlocalizedName("heavenApple");
		heart = (ItemLifeHeart) (new ItemLifeHeart(MDMConfig.getItem("Life Heart", itemID++))).setUnlocalizedName("lifeHeart");
		flamingSword = (ItemFlamingSword) (new ItemFlamingSword(MDMConfig.getItem("Fire Sword", itemID++))).setUnlocalizedName("fireSword").setTextureName("fireSword");
		pulsingSword = (ItemPulsingSword) (new ItemPulsingSword(MDMConfig.getItem("Pulsing Sword", itemID++))).setUnlocalizedName("pulseSword").setTextureName("pulseSword");
		icestick = (ItemIceStick) (new ItemIceStick(MDMConfig.getItem("Ice Stick", itemID++))).setUnlocalizedName("iceStick");
		icehammer = (ItemIceHammer) (new ItemIceHammer(MDMConfig.getItem("Ice Hammer", itemID++))).setUnlocalizedName("iceHammer");
		soul = (ItemHeavenSoul) (new ItemHeavenSoul(MDMConfig.getItem("Soul", itemID++))).setUnlocalizedName("soul");
		capes = (ItemCape) new ItemCape(MDMConfig.getItem("Cape", itemID++)).setUnlocalizedName("cape");
		
		heavenPortalActivator = (ItemHeavenPortalActivator) (new ItemHeavenPortalActivator(MDMConfig.getItem("Heaven Portal Activator", itemID++))).setUnlocalizedName("heavenportalactivator");
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addItem(alchemyGuide, "Alchemy Guide", "Buch der Alchemie");
		addItem(manaStar, "Mana Star", "Manastern");
		addItem(shannaraSword, "The Sword of Shannara");
		addItem(elixir, "Elixir", "Elixier");
		addItem(elixirBottle, "Elixir Bottle", "Elixierflasche");
		
		// -- Heaven --
		
		CSItems.addTool(heavenWoodSword, "Heaven Wood Sword", MDMBlocks.heavenwoodPlanks, heavenwoodStick, 0);
		CSItems.addTool(heavenWoodShovel, "Heaven Wood Shovel", MDMBlocks.heavenwoodPlanks, heavenwoodStick, 1);
		CSItems.addTool(heavenWoodPickaxe, "Heaven Wood Pickaxe", MDMBlocks.heavenwoodPlanks, heavenwoodStick, 2);
		CSItems.addTool(heavenWoodAxe, "Heaven Wood Axe", MDMBlocks.heavenwoodPlanks, heavenwoodStick, 3);
		CSItems.addTool(heavenWoodHoe, "Heaven Wood Hoe", MDMBlocks.heavenwoodPlanks, heavenwoodStick, 4);
		
		CSItems.addTool(heavenStoneSword, "Heaven Stone Sword", MDMBlocks.heavenCobble, heavenwoodStick, 0);
		CSItems.addTool(heavenStoneShovel, "Heaven Stone Shovel", MDMBlocks.heavenCobble, heavenwoodStick, 1);
		CSItems.addTool(heavenStonePickaxe, "Heaven Stone Pickaxe", MDMBlocks.heavenCobble, heavenwoodStick, 2);
		CSItems.addTool(heavenStoneAxe, "Heaven Stone Axe", MDMBlocks.heavenCobble, heavenwoodStick, 3);
		CSItems.addTool(heavenStoneHoe, "Heaven Stone Hoe", MDMBlocks.heavenCobble, heavenwoodStick, 4);
		
		CSItems.addTool(shrekiteSword, "Shrekite Sword", shrekiteShard, heavenwoodStick, 0);
		CSItems.addTool(shrekiteShovel, "Shrekite Shovel", shrekiteShard, heavenwoodStick, 1);
		CSItems.addTool(shrekitePickaxe, "Shrekite Pickaxe", shrekiteShard, heavenwoodStick, 2);
		CSItems.addTool(shrekiteAxe, "Shrekite Axe", shrekiteShard, heavenwoodStick, 3);
		CSItems.addTool(shrekiteHoe, "Shrekite Hoe", shrekiteShard, heavenwoodStick, 4);
		
		CSItems.addTool(clashiumSword, "Clashium Sword", clashiumIngot, heavenwoodStick, 0);
		CSItems.addTool(clashiumShovel, "Clashium Shovel", clashiumIngot, heavenwoodStick, 1);
		CSItems.addTool(clashiumPickaxe, "Clashium Pickaxe", clashiumIngot, heavenwoodStick, 2);
		CSItems.addTool(clashiumAxe, "Clashium Axe", clashiumIngot, heavenwoodStick, 3);
		CSItems.addTool(clashiumHoe, "Clashium Hoe", clashiumIngot, heavenwoodStick, 4);
		
		CSItems.addTool(holyiumSword, "Holyium Sword", holyiumIngot, heavenwoodStick, 0);
		CSItems.addTool(holyiumShovel, "Holyium Shovel", holyiumIngot, heavenwoodStick, 1);
		CSItems.addTool(holyiumPickaxe, "Holyium Pickaxe", holyiumIngot, heavenwoodStick, 2);
		CSItems.addTool(holyiumAxe, "Holyium Axe", holyiumIngot, heavenwoodStick, 3);
		CSItems.addTool(holyiumHoe, "Holyium Hoe", holyiumIngot, heavenwoodStick, 4);
		
		CSItems.addTool(energySword, "Energy Sword", energyOrb, heavenwoodStick, 0);
		CSItems.addTool(energyShovel, "Energy Shovel", energyOrb, heavenwoodStick, 1);
		CSItems.addTool(energyPickaxe, "Energy Pickaxe", energyOrb, heavenwoodStick, 2);
		CSItems.addTool(energyAxe, "Energy Axe", energyOrb, heavenwoodStick, 3);
		CSItems.addTool(energyHoe, "Energy Hoe", energyOrb, heavenwoodStick, 4);
		
		CSItems.addTool(proSword, "Pro Sword", proAlloy, heavenwoodStick, 0);
		CSItems.addTool(proShovel, "Pro Shovel", proAlloy, heavenwoodStick, 1);
		CSItems.addTool(proPickaxe, "Pro Pickaxe", proAlloy, heavenwoodStick, 2);
		CSItems.addTool(proAxe, "Pro Axe", proAlloy, heavenwoodStick, 3);
		CSItems.addTool(proHoe, "Pro Hoe", proAlloy, heavenwoodStick, 4);
		
		CSItems.addTool(goldWoodSword, "Gold Wood Sword", MDMBlocks.goldwoodPlanks, goldwoodStick, 0);
		CSItems.addTool(goldWoodShovel, "Gold Wood Shovel", MDMBlocks.goldwoodPlanks, goldwoodStick, 1);
		CSItems.addTool(goldWoodPickaxe, "Gold Wood Pickaxe", MDMBlocks.goldwoodPlanks, goldwoodStick, 2);
		CSItems.addTool(goldWoodAxe, "Gold Wood Axe", MDMBlocks.goldwoodPlanks, goldwoodStick, 3);
		CSItems.addTool(goldWoodHoe, "Gold Wood Hoe", MDMBlocks.goldwoodPlanks, goldwoodStick, 4);
		
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
		CSItems.addItemWithRecipe(heavenBow, "Heaven Bow", 1, new Object[] { "s| ", "s |", "s| ", Character.valueOf('s'), Item.silk, Character.valueOf('|'), heavenwoodStick });
		addItem(heavenApple, "Heaven Apple");
		addItem(heart, "Life Heart");
		addItem(flamingSword, "Flaming Sword");
		addItem(pulsingSword, "Pulsing Sword");
		CSItems.addItemWithRecipe(icestick, "Ice Stick", 1, new Object[] { "i", "i", Character.valueOf('i'), Block.ice });
		CSItems.addItemWithRecipe(icehammer, "Ice Hammer", 1, new Object[] { "IiI", "IiI", " i ", Character.valueOf('I'), Block.ice, Character.valueOf('i'), icestick });
		
		tabParadiseOfChaos.setIconItemStack(new ItemStack(MDMBlocks.alteredGrass));
		tabAlchemy.setIconItemStack(new ItemStack(elixirBottle));
		tabHeavenBlocks.setIconItemStack(new ItemStack(MDMBlocks.heavenGrass));
		tabHeavenMaterials.setIconItemStack(shrekiteShard);
		tabHeavenTools.setIconItemStack(new ItemStack(heavenStonePickaxe));
		tabHeavenArmor.setIconItemStack(new ItemStack(clashiumChestplate));
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
	
	public static <T extends Item> T addItem(Class<T> type, String name, Object... args)
	{
		T item = null;
		
		Class[] classes = new Class[args.length + 1];
		Object[] args2 = new Object[args.length + 1];
		
		classes[0] = int.class;
		args2[0] = MDMConfig.getItem(name, itemID++);
		for (int i = 1; i < args.length; i++)
		{
			args2[i] = args[i];
			if (args[i] != null)
				classes[i] = args[i].getClass();
			else
				classes[i] = Object.class;
		}
		
		try
		{
			Constructor<T> c = type.getConstructor(classes);
			if (c != null)
				item = c.newInstance(args);
		}
		catch (Exception ex)
		{
			return null;
		}
		
		addItem(item, name);
		
		return item;
	}
}
