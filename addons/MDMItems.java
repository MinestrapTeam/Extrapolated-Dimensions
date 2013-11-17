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

import static clashsoft.clashsoftapi.util.CSItems.*;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.common.EnumHelper;

@Addon(modName = "MoreDimensionsMod", addonName = "Items")
public class MDMItems
{
	public static CustomCreativeTab			tabTools		= new CustomCreativeTab("MDMTools");
	
	public static CustomCreativeTab			tabPOCBlocks	= new CustomCreativeTab("POCBlocks");
	public static CustomCreativeTab			tabPOCItems		= new CustomCreativeTab("POCItems");
	public static CustomCreativeTab			tabPOCTools		= new CustomCreativeTab("POCTools");
	public static CustomCreativeTab			tabPOCArmor		= new CustomCreativeTab("POCArmor");
	
	public static CustomCreativeTab			tabAlchemy		= new CustomCreativeTab("AlchemyTab");
	
	public static CustomCreativeTab			tabHeavenBlocks	= new CustomCreativeTab("HeavenBlocks");
	public static CustomCreativeTab			tabHeavenItems	= new CustomCreativeTab("HeavenItems");
	public static CustomCreativeTab			tabHeavenTools	= new CustomCreativeTab("HeavenTools");
	public static CustomCreativeTab			tabHeavenArmor	= new CustomCreativeTab("HeavenArmor");
	
	public static EnumToolMaterial			toolHeavenwood	= EnumHelper.addToolMaterial("HEAVENWOOD", 0, 64, 1F, 1F, 14);
	public static EnumToolMaterial			toolHeavenStone	= EnumHelper.addToolMaterial("HEAVENSTONE", 1, 64, 2F, 2, 12);
	public static EnumToolMaterial			toolShrekite	= EnumHelper.addToolMaterial("SHREKITE", 1, 128, 3F, 3, 9);
	public static EnumToolMaterial			toolClashium	= EnumHelper.addToolMaterial("CLASHIUM", 2, 256, 4F, 5, 11);
	public static EnumToolMaterial			toolHolyium		= EnumHelper.addToolMaterial("HOLYIUM", 3, 2048, 6F, 20, 10);
	public static EnumToolMaterial			toolEnergy		= EnumHelper.addToolMaterial("ENERGY", 3, 1536, 5F, 10, 2);
	public static EnumToolMaterial			toolPro			= EnumHelper.addToolMaterial("PRO", 3, 4096, 8F, 10, 10);
	
	public static EnumToolMaterial			toolWillow		= EnumHelper.addToolMaterial("WILLOW", 0, 100, 1.2F, 1.5F, 16);
	public static EnumToolMaterial			toolFire		= EnumHelper.addToolMaterial("FIRE", 2, 416, 3.5F, 2F, 8);
	public static EnumToolMaterial			toolPulse		= EnumHelper.addToolMaterial("PULSE", 2, 512, 3F, 2F, 10);
	public static EnumToolMaterial			toolShannara	= EnumHelper.addToolMaterial("SHANNARA", 3, 2048, 15.0F, 3.2F, Integer.MAX_VALUE);
	
	public static EnumArmorMaterial			armorShrekite	= EnumHelper.addArmorMaterial("SHREKITE", 32, new int[] { 1, 5, 3, 1 }, 9);
	public static EnumArmorMaterial			armorClashium	= EnumHelper.addArmorMaterial("CLASHIUM", 64, new int[] { 2, 6, 4, 2 }, 11);
	public static EnumArmorMaterial			armorHolyium	= EnumHelper.addArmorMaterial("HOLYIUM", 128, new int[] { 3, 9, 7, 3 }, 10);
	public static EnumArmorMaterial			armorEnergy		= EnumHelper.addArmorMaterial("ENERGY", 256, new int[] { 6, 16, 12, 6 }, 2);
	public static EnumArmorMaterial			armorPro		= EnumHelper.addArmorMaterial("PRO", 512, new int[] { 7, 18, 14, 7 }, 10);
	
	public static int						pocItemID		= 25000;
	public static int						heavenItemID	= 26000;
	
	// -- Paradise of Chaos --
	
	public static ItemAlchemyGuide			alchemyGuide;
	public static ItemStaff					staves;
	public static ItemManaStar				manaStar;
	public static ItemSword					shannaraSword;
	
	public static ItemElixir				elixir;
	public static ItemElixirBottle			elixirBottle;
	
	public static CustomItem				pocMaterials;
	public static Item						willowSword, willowShovel, willowPickaxe, willowAxe, willowHoe;
	
	public static ItemStack					magicOakStick, willowStick, daeyaltGem, noviteGem, marmarosGem;
	
	// -- Heaven --
	
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
	
	public static CustomItem				heavenMaterials;
	public static ItemBowMDM				heavenBow;
	public static ItemHeavenFood			heavenApple;
	public static ItemLifeHeart				lifeHeart;
	public static ItemFireSword			fireSword;
	public static ItemPulsingSword			pulsingSword;
	public static ItemIceHammer				icehammer;
	public static ItemHeavenSoul			heavenSouls;
	public static ItemHeavenPortalActivator	heavenPortalActivator;
	public static ItemCape					capes;
	
	public static ItemStack					heavenWoodStick, goldWoodStick, iceStick, heavenArrow, shrekiteShard, clashiumIngot, holyiumIngot, energyOrb, proAlloy, bluriteDust;
	
	public static void initialize()
	{
		// -- Paradise of Chaos --
		
		alchemyGuide = (ItemAlchemyGuide) new ItemAlchemyGuide(MDMConfig.getItem("Alchemy Guide", pocItemID++)).setUnlocalizedName("alchemy_guide").setCreativeTab(MDMItems.tabPOCItems);
		staves = (ItemStaff) new ItemStaff(MDMConfig.getItem("Staves", pocItemID++)).setUnlocalizedName("staves").setCreativeTab(tabPOCTools);
		manaStar = (ItemManaStar) new ItemManaStar(MDMConfig.getItem("Mana Star", pocItemID++)).setUnlocalizedName("manastar").setCreativeTab(tabPOCItems);
		shannaraSword = (ItemSword) new ItemSword(MDMConfig.getItem("Shannara Sword", pocItemID++), MDMItems.toolShannara).setUnlocalizedName("shannara_sword").setTextureName("shannara_sword").setCreativeTab(tabPOCTools);
		elixir = (ItemElixir) new ItemElixir(MDMConfig.getItem("Elixir", pocItemID++)).setUnlocalizedName("elixir");
		elixirBottle = (ItemElixirBottle) new ItemElixirBottle(MDMConfig.getItem("Elixir Bottle", pocItemID++)).setUnlocalizedName("elixirbottle");
		
		pocMaterials = (CustomItem) new CustomItem(MDMConfig.getItem("POC Materials", pocItemID++), new String[] { "Magic Oak Stick", "Willow Stick", "Daeyalt Gem", "Novite Gem", "Marmaros Gem" }, new String[] { "magicoak_stick", "willow_stick", "daeyalt_gem", "novite_gem", "marmaros_gem" }).setUnlocalizedName("pocMaterials").setCreativeTab(tabPOCItems);
		{
			int i = -1;
			magicOakStick = new ItemStack(pocMaterials, 1, ++i);
			willowStick = new ItemStack(pocMaterials, 1, ++i);
			daeyaltGem = new ItemStack(pocMaterials, 1, ++i);
			noviteGem = new ItemStack(pocMaterials, 1, ++i);
			marmarosGem = new ItemStack(pocMaterials, 1, ++i);
		}
		
		willowSword = (new ItemSword(MDMConfig.getItem("Willow Sword", pocItemID++), toolWillow)).setUnlocalizedName("willow_sword").setTextureName("willow_sword").setCreativeTab(tabPOCTools);
		willowShovel = (new ItemSpade(MDMConfig.getItem("Willow Shovel", pocItemID++), toolWillow)).setUnlocalizedName("willow_shovel").setTextureName("willow_shovel").setCreativeTab(tabPOCTools);
		willowPickaxe = (new ItemPickaxe(MDMConfig.getItem("Willow Pickaxe", pocItemID++), toolWillow)).setUnlocalizedName("willow_pickaxe").setTextureName("willow_pickaxe").setCreativeTab(tabPOCTools);
		willowAxe = (new ItemAxe(MDMConfig.getItem("Willow Axe", pocItemID++), toolWillow)).setUnlocalizedName("willow_axe").setTextureName("willow_axe").setCreativeTab(tabPOCTools);
		willowHoe = (new ItemHoe(MDMConfig.getItem("Willow Hoe", pocItemID++), toolWillow)).setUnlocalizedName("willow_hoe").setTextureName("willow_hoe").setCreativeTab(tabPOCTools);
		
		// -- Heaven --
		
		heavenWoodSword = (new ItemSword(MDMConfig.getItem("Heaven Wood Sword", heavenItemID++), toolHeavenwood)).setUnlocalizedName("heavenwood_sword").setTextureName("heavenwood_sword").setCreativeTab(tabHeavenTools);
		heavenWoodShovel = (new ItemSpade(MDMConfig.getItem("Heaven Wood Shovel", heavenItemID++), toolHeavenwood)).setUnlocalizedName("heavenwood_shovel").setTextureName("heavenwood_shovel").setCreativeTab(tabHeavenTools);
		heavenWoodPickaxe = (new ItemPickaxe(MDMConfig.getItem("Heaven Wood Pickaxe", heavenItemID++), toolHeavenwood)).setUnlocalizedName("heavenwood_pickaxe").setTextureName("heavenwood_pickaxe").setCreativeTab(tabHeavenTools);
		heavenWoodAxe = (new ItemAxe(MDMConfig.getItem("Heaven Wood Axe", heavenItemID++), toolHeavenwood)).setUnlocalizedName("heavenwood_axe").setTextureName("heavenwood_axe").setCreativeTab(tabHeavenTools);
		heavenWoodHoe = (new ItemHoe(MDMConfig.getItem("Heaven Wood Hoe", heavenItemID++), toolHeavenwood)).setUnlocalizedName("heavenwood_hoe").setTextureName("heavenwood_hoe").setCreativeTab(tabHeavenTools);
		
		heavenStoneSword = (new ItemSword(MDMConfig.getItem("Heaven Stone Sword", heavenItemID++), toolHeavenStone)).setUnlocalizedName("heavenstone_sword").setTextureName("heavenstone_sword").setCreativeTab(tabHeavenTools);
		heavenStoneShovel = (new ItemSpade(MDMConfig.getItem("Heaven Stone Shovel", heavenItemID++), toolHeavenStone)).setUnlocalizedName("heavenstone_shovel").setTextureName("heavenstone_shovel").setCreativeTab(tabHeavenTools);
		heavenStonePickaxe = (new ItemPickaxe(MDMConfig.getItem("Heaven Stone Pickaxe", heavenItemID++), toolHeavenStone)).setUnlocalizedName("heavenstone_pickaxe").setTextureName("heavenstone_pickaxe").setCreativeTab(tabHeavenTools);
		heavenStoneAxe = (new ItemAxe(MDMConfig.getItem("Heaven Stone Axe", heavenItemID++), toolHeavenStone)).setUnlocalizedName("heavenstone_axe").setTextureName("heavenstone_axe").setCreativeTab(tabHeavenTools);
		heavenStoneHoe = (new ItemHoe(MDMConfig.getItem("Heaven Stone Hoe", heavenItemID++), toolHeavenStone)).setUnlocalizedName("heavenstone_hoe").setTextureName("heavenstone_hoe").setCreativeTab(tabHeavenTools);
		
		shrekiteSword = (new ItemSword(MDMConfig.getItem("Shrekite Sword", heavenItemID++), toolShrekite)).setUnlocalizedName("shrekite_sword").setTextureName("shrekite_sword").setCreativeTab(tabHeavenTools);
		shrekiteShovel = (new ItemSpade(MDMConfig.getItem("Shrekite Shovel", heavenItemID++), toolShrekite)).setUnlocalizedName("shrekite_shovel").setTextureName("shrekite_shovel").setCreativeTab(tabHeavenTools);
		shrekitePickaxe = (new ItemPickaxe(MDMConfig.getItem("Shrekite Pickaxe", heavenItemID++), toolShrekite)).setUnlocalizedName("shrekite_pickaxe").setTextureName("shrekite_pickaxe").setCreativeTab(tabHeavenTools);
		shrekiteAxe = (new ItemAxe(MDMConfig.getItem("Shrekite Axe", heavenItemID++), toolShrekite)).setUnlocalizedName("shrekite_axe").setTextureName("shrekite_axe").setCreativeTab(tabHeavenTools);
		shrekiteHoe = (new ItemHoe(MDMConfig.getItem("Shrekite Hoe", heavenItemID++), toolShrekite)).setUnlocalizedName("shrekite_hoe").setTextureName("shrekite_hoe").setCreativeTab(tabHeavenTools);
		
		clashiumSword = (new ItemSword(MDMConfig.getItem("Clashium Sword", heavenItemID++), toolClashium)).setUnlocalizedName("clashium_sword").setTextureName("clashium_sword").setCreativeTab(tabHeavenTools);
		clashiumShovel = (new ItemSpade(MDMConfig.getItem("Clashium Shovel", heavenItemID++), toolClashium)).setUnlocalizedName("clashium_shovel").setTextureName("clashium_shovel").setCreativeTab(tabHeavenTools);
		clashiumPickaxe = (new ItemPickaxe(MDMConfig.getItem("Clashium Pickaxe", heavenItemID++), toolClashium)).setUnlocalizedName("clashium_pickaxe").setTextureName("clashium_pickaxe").setCreativeTab(tabHeavenTools);
		clashiumAxe = (new ItemAxe(MDMConfig.getItem("Clashium Axe", heavenItemID++), toolClashium)).setUnlocalizedName("clashium_axe").setTextureName("clashium_axe").setCreativeTab(tabHeavenTools);
		clashiumHoe = (new ItemHoe(MDMConfig.getItem("Clashium Hoe", heavenItemID++), toolClashium)).setUnlocalizedName("clashium_hoe").setTextureName("clashium_hoe").setCreativeTab(tabHeavenTools);
		
		holyiumSword = (new ItemSword(MDMConfig.getItem("Holyium Sword", heavenItemID++), toolHolyium)).setUnlocalizedName("holyium_sword").setTextureName("holyium_sword").setCreativeTab(tabHeavenTools);
		holyiumShovel = (new ItemSpade(MDMConfig.getItem("Holyium Shovel", heavenItemID++), toolHolyium)).setUnlocalizedName("holyium_shovel").setTextureName("holyium_shovel").setCreativeTab(tabHeavenTools);
		holyiumPickaxe = (new ItemPickaxe(MDMConfig.getItem("Holyium Pickaxe", heavenItemID++), toolHolyium)).setUnlocalizedName("holyium_pickaxe").setTextureName("holyium_pickaxe").setCreativeTab(tabHeavenTools);
		holyiumAxe = (new ItemAxe(MDMConfig.getItem("Holyium Axe", heavenItemID++), toolHolyium)).setUnlocalizedName("holyium_axe").setTextureName("holyium_axe").setCreativeTab(tabHeavenTools);
		holyiumHoe = (new ItemHoe(MDMConfig.getItem("Holyium Hoe", heavenItemID++), toolHolyium)).setUnlocalizedName("holyium_hoe").setTextureName("holyium_hoe").setCreativeTab(tabHeavenTools);
		
		energySword = (new ItemSword(MDMConfig.getItem("Energy Sword", heavenItemID++), toolEnergy)).setUnlocalizedName("energy_sword").setTextureName("energy_sword").setCreativeTab(tabHeavenTools);
		energyShovel = (new ItemSpade(MDMConfig.getItem("Energy Shovel", heavenItemID++), toolEnergy)).setUnlocalizedName("energy_shovel").setTextureName("energy_shovel").setCreativeTab(tabHeavenTools);
		energyPickaxe = (new ItemPickaxe(MDMConfig.getItem("Energy Pickaxe", heavenItemID++), toolEnergy)).setUnlocalizedName("energy_pickaxe").setTextureName("energy_pickaxe").setCreativeTab(tabHeavenTools);
		energyAxe = (new ItemAxe(MDMConfig.getItem("Energy Axe", heavenItemID++), toolEnergy)).setUnlocalizedName("energy_axe").setTextureName("energy_axe").setCreativeTab(tabHeavenTools);
		energyHoe = (new ItemHoe(MDMConfig.getItem("Energy Hoe", heavenItemID++), toolEnergy)).setUnlocalizedName("energy_hoe").setTextureName("energy_hoe").setCreativeTab(tabHeavenTools);
		
		proSword = (new ItemSword(MDMConfig.getItem("Pro Sword", heavenItemID++), toolPro)).setUnlocalizedName("pro_sword").setTextureName("pro_sword").setCreativeTab(tabHeavenTools);
		proShovel = (new ItemSpade(MDMConfig.getItem("Pro Shovel", heavenItemID++), toolPro)).setUnlocalizedName("pro_shovel").setTextureName("pro_shovel").setCreativeTab(tabHeavenTools);
		proPickaxe = (new ItemPickaxe(MDMConfig.getItem("Pro Pickaxe", heavenItemID++), toolPro)).setUnlocalizedName("pro_pickaxe").setTextureName("pro_pickaxe").setCreativeTab(tabHeavenTools);
		proAxe = (new ItemAxe(MDMConfig.getItem("Pro Axe", heavenItemID++), toolPro)).setUnlocalizedName("pro_axe").setTextureName("pro_axe").setCreativeTab(tabHeavenTools);
		proHoe = (new ItemHoe(MDMConfig.getItem("Pro Hoe", heavenItemID++), toolPro)).setUnlocalizedName("pro_hoe").setTextureName("pro_hoe").setCreativeTab(tabHeavenTools);
		
		goldWoodSword = (new ItemSword(MDMConfig.getItem("Gold Wood Sword", heavenItemID++), toolHeavenwood)).setUnlocalizedName("goldwood_sword").setTextureName("goldwood_sword").setCreativeTab(tabHeavenTools);
		goldWoodShovel = (new ItemSpade(MDMConfig.getItem("Gold Wood Shovel", heavenItemID++), toolHeavenwood)).setUnlocalizedName("goldwood_shovel").setTextureName("goldwood_shovel").setCreativeTab(tabHeavenTools);
		goldWoodPickaxe = (new ItemPickaxe(MDMConfig.getItem("Gold Wood Pickaxe", heavenItemID++), toolHeavenwood)).setUnlocalizedName("goldwood_pickaxe").setTextureName("goldwood_pickaxe").setCreativeTab(tabHeavenTools);
		goldWoodAxe = (new ItemAxe(MDMConfig.getItem("Gold Wood Axe", heavenItemID++), toolHeavenwood)).setUnlocalizedName("goldwood_axe").setTextureName("goldwood_axe").setCreativeTab(tabHeavenTools);
		goldWoodHoe = (new ItemHoe(MDMConfig.getItem("Gold Wood Hoe", heavenItemID++), toolHeavenwood)).setUnlocalizedName("goldwood_hoe").setTextureName("goldwood_hoe").setCreativeTab(tabHeavenTools);
		
		shrekiteHelmet = new ItemArmor(MDMConfig.getItem("Shrekite Helmet", heavenItemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 0).setUnlocalizedName("shrekite_helmet").setTextureName("shrekite_helmet").setCreativeTab(tabHeavenArmor);
		shrekiteChestplate = new ItemArmor(MDMConfig.getItem("Shrekite Chestplate", heavenItemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 1).setUnlocalizedName("shrekite_chestplate").setTextureName("shrekite_chestplate").setCreativeTab(tabHeavenArmor);
		shrekiteLeggings = new ItemArmor(MDMConfig.getItem("Shrekite Leggings", heavenItemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 2).setUnlocalizedName("shrekite_leggings").setTextureName("shrekite_leggings").setCreativeTab(tabHeavenArmor);
		shrekiteBoots = new ItemArmor(MDMConfig.getItem("Shrekite Boots", heavenItemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite"), 3).setUnlocalizedName("shrekite_boots").setTextureName("shrekite_boots").setCreativeTab(tabHeavenArmor);
		shrekiteGloves = new ItemGloves(MDMConfig.getItem("Shrekite Gloves", heavenItemID++), armorShrekite, MDMCommonProxy.getArmorIndex("shrekite")).setUnlocalizedName("shrekite_gloves").setTextureName("shrekite_gloves").setCreativeTab(tabHeavenArmor);
		
		clashiumHelmet = new ItemArmor(MDMConfig.getItem("Clashium Helmet", heavenItemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 0).setUnlocalizedName("clashium_helmet").setTextureName("clashium_helmet").setCreativeTab(tabHeavenArmor);
		clashiumChestplate = new ItemArmor(MDMConfig.getItem("Clashium Chestplate", heavenItemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 1).setUnlocalizedName("clashium_chestplate").setTextureName("clashium_chestplate").setCreativeTab(tabHeavenArmor);
		clashiumLeggings = new ItemArmor(MDMConfig.getItem("Clashium Leggings", heavenItemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 2).setUnlocalizedName("clashium_leggings").setTextureName("clashium_leggings").setCreativeTab(tabHeavenArmor);
		clashiumBoots = new ItemArmor(MDMConfig.getItem("Clashium Boots", heavenItemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium"), 3).setUnlocalizedName("clashium_boots").setTextureName("clashium_boots").setCreativeTab(tabHeavenArmor);
		clashiumGloves = new ItemGloves(MDMConfig.getItem("Clashium Gloves", heavenItemID++), armorClashium, MDMCommonProxy.getArmorIndex("clashium")).setUnlocalizedName("clashium_gloves").setTextureName("clashium_gloves").setCreativeTab(tabHeavenArmor);
		
		holyiumHelmet = new ItemArmor(MDMConfig.getItem("Holyium Helmet", heavenItemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 0).setUnlocalizedName("holyium_helmet").setTextureName("holyium_helmet").setCreativeTab(tabHeavenArmor);
		holyiumChestplate = new ItemArmor(MDMConfig.getItem("Holyium Chestplate", heavenItemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 1).setUnlocalizedName("holyium_chestplate").setTextureName("holyium_chestplate").setCreativeTab(tabHeavenArmor);
		holyiumLeggings = new ItemArmor(MDMConfig.getItem("Holyium Leggings", heavenItemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 2).setUnlocalizedName("holyium_leggings").setTextureName("holyium_leggings").setCreativeTab(tabHeavenArmor);
		holyiumBoots = new ItemArmor(MDMConfig.getItem("Holyium Boots", heavenItemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium"), 3).setUnlocalizedName("holyium_boots").setTextureName("holyium_boots").setCreativeTab(tabHeavenArmor);
		holyiumGloves = new ItemGloves(MDMConfig.getItem("Holyium Gloves", heavenItemID++), armorHolyium, MDMCommonProxy.getArmorIndex("holyium")).setUnlocalizedName("holyium_gloves").setTextureName("holyium_gloves").setCreativeTab(tabHeavenArmor);
		
		energyHelmet = new ItemArmor(MDMConfig.getItem("Energy Helmet", heavenItemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 0).setUnlocalizedName("energy_helmet").setTextureName("energy_helmet").setCreativeTab(tabHeavenArmor);
		energyChestplate = new ItemArmor(MDMConfig.getItem("Energy Chestplate", heavenItemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 1).setUnlocalizedName("energy_chestplate").setTextureName("energy_chestplate").setCreativeTab(tabHeavenArmor);
		energyLeggings = new ItemArmor(MDMConfig.getItem("Energy Leggings", heavenItemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 2).setUnlocalizedName("energy_leggings").setTextureName("energy_leggings").setCreativeTab(tabHeavenArmor);
		energyBoots = new ItemArmor(MDMConfig.getItem("Energy Boots", heavenItemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy"), 3).setUnlocalizedName("energy_boots").setTextureName("energy_boots").setCreativeTab(tabHeavenArmor);
		energyGloves = new ItemGloves(MDMConfig.getItem("Energy Gloves", heavenItemID++), armorEnergy, MDMCommonProxy.getArmorIndex("energy")).setUnlocalizedName("energy_gloves").setTextureName("energy_gloves").setCreativeTab(tabHeavenArmor);
		
		proHelmet = new ItemArmor(MDMConfig.getItem("Pro Helmet", heavenItemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 0).setUnlocalizedName("pro_helmet").setTextureName("pro_helmet").setCreativeTab(tabHeavenArmor);
		proChestplate = new ItemArmor(MDMConfig.getItem("Pro Chestplate", heavenItemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 1).setUnlocalizedName("pro_chestplate").setTextureName("pro_chestplate").setCreativeTab(tabHeavenArmor);
		proLeggings = new ItemArmor(MDMConfig.getItem("Pro Leggings", heavenItemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 2).setUnlocalizedName("pro_leggings").setTextureName("pro_leggings").setCreativeTab(tabHeavenArmor);
		proBoots = new ItemArmor(MDMConfig.getItem("Pro Boots", heavenItemID++), armorPro, MDMCommonProxy.getArmorIndex("pro"), 3).setUnlocalizedName("pro_boots").setTextureName("pro_boots").setCreativeTab(tabHeavenArmor);
		proGloves = new ItemGloves(MDMConfig.getItem("Pro Gloves", heavenItemID++), armorPro, MDMCommonProxy.getArmorIndex("pro")).setUnlocalizedName("pro_gloves").setTextureName("pro_gloves").setCreativeTab(tabHeavenArmor);
		
		heavenMaterials = (CustomItem) new CustomItem(MDMConfig.getItem("Heaven Materials", heavenItemID++), new String[] { "Heaven Wood Stick", "Gold Wood Stick", "Ice Stick", "Heaven Arrow", "Shrekite Shard", "Clashium Ingot", "Holyium Ingot", "Energy Orb", "Pro Alloy", "Blurite Dust" }, new String[] { "heavenwood_stick", "goldwood_stick", "ice_stick", "heaven_arrow", "shrekite_shard", "clashium_ingot", "holyium_ingot", "energy_orb", "pro_ingot", "blurite_dust" }).setUnlocalizedName("heavenMaterials").setCreativeTab(tabHeavenItems);
		{
			int i = -1;
			heavenWoodStick = new ItemStack(heavenMaterials, 1, ++i);
			goldWoodStick = new ItemStack(heavenMaterials, 1, ++i);
			iceStick = new ItemStack(heavenMaterials, 1, ++i);
			heavenArrow = new ItemStack(heavenMaterials, 1, ++i);
			shrekiteShard = new ItemStack(heavenMaterials, 1, ++i);
			clashiumIngot = new ItemStack(heavenMaterials, 1, ++i);
			holyiumIngot = new ItemStack(heavenMaterials, 1, ++i);
			energyOrb = new ItemStack(heavenMaterials, 1, ++i);
			proAlloy = new ItemStack(heavenMaterials, 1, ++i);
			bluriteDust = new ItemStack(heavenMaterials, 1, ++i);
		}
		
		heavenBow = (ItemBowMDM) (new ItemBowMDM(MDMConfig.getItem("Heaven Bow", heavenItemID++), "heavenwood_bow", heavenArrow)).setUnlocalizedName("heavenwood_bow");
		heavenApple = (ItemHeavenFood) (new ItemHeavenFood(MDMConfig.getItem("Heaven Apple", heavenItemID++), 2, 0, false)).setUnlocalizedName("heaven_apple");
		lifeHeart = (ItemLifeHeart) (new ItemLifeHeart(MDMConfig.getItem("Life Heart", heavenItemID++))).setUnlocalizedName("life_heart");
		fireSword = (ItemFireSword) (new ItemFireSword(MDMConfig.getItem("Fire Sword", heavenItemID++))).setUnlocalizedName("fire_sword").setTextureName("fire_sword");
		pulsingSword = (ItemPulsingSword) (new ItemPulsingSword(MDMConfig.getItem("Pulsing Sword", heavenItemID++))).setUnlocalizedName("pulse_sword").setTextureName("pulse_sword");
		icehammer = (ItemIceHammer) (new ItemIceHammer(MDMConfig.getItem("Ice Hammer", heavenItemID++))).setUnlocalizedName("ice_hammer");
		heavenSouls = (ItemHeavenSoul) (new ItemHeavenSoul(MDMConfig.getItem("Soul", heavenItemID++))).setUnlocalizedName("soul");
		capes = (ItemCape) new ItemCape(MDMConfig.getItem("Cape", heavenItemID++)).setUnlocalizedName("cape");
		
		heavenPortalActivator = (ItemHeavenPortalActivator) (new ItemHeavenPortalActivator(MDMConfig.getItem("Heaven Portal Activator", heavenItemID++))).setUnlocalizedName("heaven_portal_activator");
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addItem(alchemyGuide, "Alchemy Guide", "Buch der Alchemie");
		addItem(manaStar, "Mana Star", "Manastern");
		addItem(shannaraSword, "The Sword of Shannara");
		addItem(elixir, "Elixir", "Elixier");
		addItem(elixirBottle, "Elixir Bottle", "Elixierflasche");
		
		addItem(pocMaterials, "POCMaterials");
		
		addTool(willowSword, "Willow Sword", MDMBlocks.willowPlanks, willowStick, 0);
		addTool(willowShovel, "Willow Shovel", MDMBlocks.willowPlanks, willowStick, 1);
		addTool(willowPickaxe, "Willow Pickaxe", MDMBlocks.willowPlanks, willowStick, 2);
		addTool(willowAxe, "Willow Axe", MDMBlocks.willowPlanks, willowStick, 3);
		addTool(willowHoe, "Willow Hoe", MDMBlocks.willowPlanks, willowStick, 4);
		
		// -- Heaven --
		
		addTool(heavenWoodSword, "Heaven Wood Sword", MDMBlocks.heavenWoodPlanks, heavenWoodStick, 0);
		addTool(heavenWoodShovel, "Heaven Wood Shovel", MDMBlocks.heavenWoodPlanks, heavenWoodStick, 1);
		addTool(heavenWoodPickaxe, "Heaven Wood Pickaxe", MDMBlocks.heavenWoodPlanks, heavenWoodStick, 2);
		addTool(heavenWoodAxe, "Heaven Wood Axe", MDMBlocks.heavenWoodPlanks, heavenWoodStick, 3);
		addTool(heavenWoodHoe, "Heaven Wood Hoe", MDMBlocks.heavenWoodPlanks, heavenWoodStick, 4);
		
		addTool(heavenStoneSword, "Heaven Stone Sword", MDMBlocks.heavenCobble, heavenWoodStick, 0);
		addTool(heavenStoneShovel, "Heaven Stone Shovel", MDMBlocks.heavenCobble, heavenWoodStick, 1);
		addTool(heavenStonePickaxe, "Heaven Stone Pickaxe", MDMBlocks.heavenCobble, heavenWoodStick, 2);
		addTool(heavenStoneAxe, "Heaven Stone Axe", MDMBlocks.heavenCobble, heavenWoodStick, 3);
		addTool(heavenStoneHoe, "Heaven Stone Hoe", MDMBlocks.heavenCobble, heavenWoodStick, 4);
		
		addTool(shrekiteSword, "Shrekite Sword", shrekiteShard, heavenWoodStick, 0);
		addTool(shrekiteShovel, "Shrekite Shovel", shrekiteShard, heavenWoodStick, 1);
		addTool(shrekitePickaxe, "Shrekite Pickaxe", shrekiteShard, heavenWoodStick, 2);
		addTool(shrekiteAxe, "Shrekite Axe", shrekiteShard, heavenWoodStick, 3);
		addTool(shrekiteHoe, "Shrekite Hoe", shrekiteShard, heavenWoodStick, 4);
		
		addTool(clashiumSword, "Clashium Sword", clashiumIngot, heavenWoodStick, 0);
		addTool(clashiumShovel, "Clashium Shovel", clashiumIngot, heavenWoodStick, 1);
		addTool(clashiumPickaxe, "Clashium Pickaxe", clashiumIngot, heavenWoodStick, 2);
		addTool(clashiumAxe, "Clashium Axe", clashiumIngot, heavenWoodStick, 3);
		addTool(clashiumHoe, "Clashium Hoe", clashiumIngot, heavenWoodStick, 4);
		
		addTool(holyiumSword, "Holyium Sword", holyiumIngot, heavenWoodStick, 0);
		addTool(holyiumShovel, "Holyium Shovel", holyiumIngot, heavenWoodStick, 1);
		addTool(holyiumPickaxe, "Holyium Pickaxe", holyiumIngot, heavenWoodStick, 2);
		addTool(holyiumAxe, "Holyium Axe", holyiumIngot, heavenWoodStick, 3);
		addTool(holyiumHoe, "Holyium Hoe", holyiumIngot, heavenWoodStick, 4);
		
		addTool(energySword, "Energy Sword", energyOrb, heavenWoodStick, 0);
		addTool(energyShovel, "Energy Shovel", energyOrb, heavenWoodStick, 1);
		addTool(energyPickaxe, "Energy Pickaxe", energyOrb, heavenWoodStick, 2);
		addTool(energyAxe, "Energy Axe", energyOrb, heavenWoodStick, 3);
		addTool(energyHoe, "Energy Hoe", energyOrb, heavenWoodStick, 4);
		
		addTool(proSword, "Pro Sword", proAlloy, heavenWoodStick, 0);
		addTool(proShovel, "Pro Shovel", proAlloy, heavenWoodStick, 1);
		addTool(proPickaxe, "Pro Pickaxe", proAlloy, heavenWoodStick, 2);
		addTool(proAxe, "Pro Axe", proAlloy, heavenWoodStick, 3);
		addTool(proHoe, "Pro Hoe", proAlloy, heavenWoodStick, 4);
		
		addTool(goldWoodSword, "Gold Wood Sword", MDMBlocks.goldWoodPlanks, goldWoodStick, 0);
		addTool(goldWoodShovel, "Gold Wood Shovel", MDMBlocks.goldWoodPlanks, goldWoodStick, 1);
		addTool(goldWoodPickaxe, "Gold Wood Pickaxe", MDMBlocks.goldWoodPlanks, goldWoodStick, 2);
		addTool(goldWoodAxe, "Gold Wood Axe", MDMBlocks.goldWoodPlanks, goldWoodStick, 3);
		addTool(goldWoodHoe, "Gold Wood Hoe", MDMBlocks.goldWoodPlanks, goldWoodStick, 4);
		
		addArmor(shrekiteHelmet, "Shrekite Helmet", shrekiteShard, 0);
		addArmor(shrekiteChestplate, "Shrekite Chestplate", shrekiteShard, 1);
		addArmor(shrekiteLeggings, "Shrekite Leggings", shrekiteShard, 2);
		addArmor(shrekiteBoots, "Shrekite Boots", shrekiteShard, 3);
		addArmor(shrekiteGloves, "Shrekite Gloves", shrekiteShard, 4);
		
		addArmor(clashiumHelmet, "Clashium Helmet", clashiumIngot, 0);
		addArmor(clashiumChestplate, "Clashium Chestplate", clashiumIngot, 1);
		addArmor(clashiumLeggings, "Clashium Leggings", clashiumIngot, 2);
		addArmor(clashiumBoots, "Clashium Boots", clashiumIngot, 3);
		addArmor(clashiumGloves, "Clashium Gloves", clashiumIngot, 4);
		
		addArmor(holyiumHelmet, "Holyium Helmet", holyiumIngot, 0);
		addArmor(holyiumChestplate, "Holyium Chestplate", holyiumIngot, 1);
		addArmor(holyiumLeggings, "Holyium Leggings", holyiumIngot, 2);
		addArmor(holyiumBoots, "Holyium Boots", holyiumIngot, 3);
		addArmor(holyiumGloves, "Holyium Gloves", holyiumIngot, 4);
		
		addArmor(energyHelmet, "Energy Helmet", energyOrb, 0);
		addArmor(energyChestplate, "Energy Chestplate", energyOrb, 1);
		addArmor(energyLeggings, "Energy Leggings", energyOrb, 2);
		addArmor(energyBoots, "Energy Boots", energyOrb, 3);
		addArmor(energyGloves, "Energy Gloves", energyOrb, 4);
		
		addArmor(proHelmet, "Pro Helmet", proAlloy, 0);
		addArmor(proChestplate, "Pro Chestplate", proAlloy, 1);
		addArmor(proLeggings, "Pro Leggings", proAlloy, 2);
		addArmor(proBoots, "Pro Boots", proAlloy, 3);
		addArmor(proGloves, "Pro Gloves", proAlloy, 4);
		
		addItem(heavenMaterials, "HeavenMaterials");
		addItem(heavenPortalActivator, "Heaven Portal Activator");
		addItemWithRecipe(heavenBow, "Heaven Bow", 1, new Object[] { "s| ", "s |", "s| ", Character.valueOf('s'), Item.silk, Character.valueOf('|'), heavenWoodStick });
		addItem(heavenApple, "Heaven Apple");
		addItem(lifeHeart, "Life Heart");
		addItem(fireSword, "Fire Sword");
		addItem(pulsingSword, "Pulsing Sword");
		addItemWithRecipe(icehammer, "Ice Hammer", 1, new Object[] { "IiI", "IiI", " i ", Character.valueOf('I'), Block.ice, Character.valueOf('i'), iceStick });
		
		tabPOCBlocks.setIconItemStack(new ItemStack(MDMBlocks.pocGrassBlocks));
		tabPOCItems.setIconItemStack(new ItemStack(pocMaterials));
		tabPOCTools.setIconItemStack(new ItemStack(willowPickaxe));
		tabPOCArmor.setIconItemStack(null); // <- TODO
		
		tabAlchemy.setIconItemStack(new ItemStack(elixirBottle));
		
		tabHeavenBlocks.setIconItemStack(new ItemStack(MDMBlocks.heavenGrassBlocks));
		tabHeavenItems.setIconItemStack(shrekiteShard);
		tabHeavenTools.setIconItemStack(new ItemStack(heavenStonePickaxe));
		tabHeavenArmor.setIconItemStack(new ItemStack(clashiumChestplate));
	}
	
	public static void addItem(Item item, String en, String de)
	{
		CSItems.addItem(item, en);
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
		args2[0] = MDMConfig.getItem(name, heavenItemID++);
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
