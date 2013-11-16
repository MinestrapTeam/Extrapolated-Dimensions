package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.item.armor.ItemGloves;
import clashsoft.mods.moredimensions.item.armor.ItemShield;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemBattleaxe;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemHatchet;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemSaw;
import clashsoft.mods.moredimensions.item.tools.*;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemClaws;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemDagger;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemHalberd;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemLongsword;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemRapier;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemScimitar;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemSpear;

import net.minecraft.item.*;

@Addon(modName = "MoreDimensionsMod", addonName = "Tools")
public class MDMTools
{
	// -- Stone --
	
	public static ItemPickaxe	woodPickaxeVariant;
	public static ItemSpade		woodSpade;
	
	public static ItemDagger	woodDagger;
	public static ItemHatchet	woodHatchet;
	public static ItemMace		woodMace;
	public static ItemScimitar	woodScimitar;
	public static ItemRapier	woodRapier;
	public static ItemLongsword	woodLongsword;
	public static ItemHalberd	woodHalberd;
	public static ItemSpear		woodSpear;
	public static ItemHammer	woodHammer;
	public static ItemHammer	woodWarhammer;
	public static ItemBattleaxe	woodBattleaxe;
	public static ItemClaws		woodClaws;
	public static ItemSaw		woodSaw;
	
	// public static ItemGloves woodGloves;
	// public static ItemShield woodShield;
	
	// -- Stone --
	
	public static ItemPickaxe	stonePickaxeVariant;
	public static ItemSpade		stoneSpade;
	
	public static ItemDagger	stoneDagger;
	public static ItemHatchet	stoneHatchet;
	public static ItemMace		stoneMace;
	public static ItemScimitar	stoneScimitar;
	public static ItemRapier	stoneRapier;
	public static ItemLongsword	stoneLongsword;
	public static ItemHalberd	stoneHalberd;
	public static ItemSpear		stoneSpear;
	public static ItemHammer	stoneHammer;
	public static ItemHammer	stoneWarhammer;
	public static ItemBattleaxe	stoneBattleaxe;
	public static ItemClaws		stoneClaws;
	public static ItemSaw		stoneSaw;
	
	// public static ItemGloves stoneGloves;
	// public static ItemShield stoneShield;
	
	// -- Iron --
	
	public static ItemPickaxe	ironPickaxeVariant;
	public static ItemSpade		ironSpade;
	
	public static ItemDagger	ironDagger;
	public static ItemHatchet	ironHatchet;
	public static ItemMace		ironMace;
	public static ItemScimitar	ironScimitar;
	public static ItemRapier	ironRapier;
	public static ItemLongsword	ironLongsword;
	public static ItemHalberd	ironHalberd;
	public static ItemSpear		ironSpear;
	public static ItemHammer	ironHammer;
	public static ItemHammer	ironWarhammer;
	public static ItemBattleaxe	ironBattleaxe;
	public static ItemClaws		ironClaws;
	public static ItemSaw		ironSaw;
	
	public static ItemGloves	ironGloves;
	public static ItemShield	ironShield;
	
	// -- Gold --
	
	public static ItemPickaxe	goldPickaxeVariant;
	public static ItemSpade		goldSpade;
	
	public static ItemDagger	goldDagger;
	public static ItemHatchet	goldHatchet;
	public static ItemMace		goldMace;
	public static ItemScimitar	goldScimitar;
	public static ItemRapier	goldRapier;
	public static ItemLongsword	goldLongsword;
	public static ItemHalberd	goldHalberd;
	public static ItemSpear		goldSpear;
	public static ItemHammer	goldHammer;
	public static ItemHammer	goldWarhammer;
	public static ItemBattleaxe	goldBattleaxe;
	public static ItemClaws		goldClaws;
	public static ItemSaw		goldSaw;
	
	public static ItemGloves	goldGloves;
	public static ItemShield	goldShield;
	
	// -- Diamond --
	
	public static ItemPickaxe	diamondPickaxeVariant;
	public static ItemSpade		diamondSpade;
	
	public static ItemDagger	diamondDagger;
	public static ItemHatchet	diamondHatchet;
	public static ItemMace		diamondMace;
	public static ItemScimitar	diamondScimitar;
	public static ItemRapier	diamondRapier;
	public static ItemLongsword	diamondLongsword;
	public static ItemHalberd	diamondHalberd;
	public static ItemSpear		diamondSpear;
	public static ItemHammer	diamondHammer;
	public static ItemHammer	diamondWarhammer;
	public static ItemBattleaxe	diamondBattleaxe;
	public static ItemClaws		diamondClaws;
	public static ItemSaw		diamondSaw;
	
	public static ItemGloves	diamondGloves;
	public static ItemShield	diamondShield;
	
	public static void initialize()
	{
		int itemID = 27000;
		
		// -- Wood --
		
		woodPickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Wood Pickaxe Variant", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("wood_pickaxe_variant").setTextureName("wood_pickaxe_variant");
		woodSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Wood Spade", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("wood_spade").setTextureName("wood_spade");
		
		woodDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Wood Dagger", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_dagger").setTextureName("wood_dagger");
		woodHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Wood Hatchet", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_hatchet").setTextureName("wood_hatchet");
		woodMace = (ItemMace) new ItemMace(MDMConfig.getItem("Wood Mace", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_mace").setTextureName("wood_mace");
		woodScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Wood Scimitar", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_scimitar").setTextureName("wood_scimitar");
		woodRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Wood Rapier", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iro_rapier").setTextureName("wood_rapier");
		woodLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Wood Longsword", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_longsword").setTextureName("wood_longsword");
		woodHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Wood Halberd", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_halberd").setTextureName("wood_halberd");
		woodSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Wood Spear", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_spear").setTextureName("wood_spear");
		woodHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Wood Hammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_hammer").setTextureName("wood_hammer");
		woodWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Wood Warhammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_warhammer").setTextureName("wood_warhammer");
		woodBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Wood Battleaxe", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_battleaxe").setTextureName("wood_battleaxe");
		woodClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Wood Claws", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_claws").setTextureName("wood_claws");
		woodSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Wood Saw", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("wood_saw").setTextureName("wood_saw");
		
		// woodGloves = (ItemGloves) new
		// ItemGloves(MDMConfig.getItem("Wood Gloves", itemID++),
		// EnumArmorMaterial.IRON,
		// 2).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("wood_gloves").setTextureName("wood_gloves");
		// woodShield = (ItemShield) new
		// ItemShield(MDMConfig.getItem("Wood Shield", itemID++),
		// EnumArmorMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("wood_shield").setTextureName("wood_shield");
		
		// -- Stone --
		
		stonePickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Stone Pickaxe Variant", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("stone_pickaxe_variant").setTextureName("stone_pickaxe_variant");
		stoneSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Stone Spade", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("stone_spade").setTextureName("stone_spade");
		
		stoneDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Stone Dagger", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_dagger").setTextureName("stone_dagger");
		stoneHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Stone Hatchet", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_hatchet").setTextureName("stone_hatchet");
		stoneMace = (ItemMace) new ItemMace(MDMConfig.getItem("Stone Mace", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_mace").setTextureName("stone_mace");
		stoneScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Stone Scimitar", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_scimitar").setTextureName("stone_scimitar");
		stoneRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Stone Rapier", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iro_rapier").setTextureName("stone_rapier");
		stoneLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Stone Longsword", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_longsword").setTextureName("stone_longsword");
		stoneHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Stone Halberd", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_halberd").setTextureName("stone_halberd");
		stoneSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Stone Spear", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_spear").setTextureName("stone_spear");
		stoneHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Stone Hammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_hammer").setTextureName("stone_hammer");
		stoneWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Stone Warhammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_warhammer").setTextureName("stone_warhammer");
		stoneBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Stone Battleaxe", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_battleaxe").setTextureName("stone_battleaxe");
		stoneClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Stone Claws", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_claws").setTextureName("stone_claws");
		stoneSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Stone Saw", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("stone_saw").setTextureName("stone_saw");
		
		// stoneGloves = (ItemGloves) new
		// ItemGloves(MDMConfig.getItem("Stone Gloves", itemID++),
		// EnumArmorMaterial.IRON,
		// 2).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("stone_gloves").setTextureName("stone_gloves");
		// stoneShield = (ItemShield) new
		// ItemShield(MDMConfig.getItem("Stone Shield", itemID++),
		// EnumArmorMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("stone_shield").setTextureName("stone_shield");
		
		// -- Iron --
		
		ironPickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Iron Pickaxe Variant", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("iron_pickaxe_variant").setTextureName("iron_pickaxe_variant");
		ironSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Iron Spade", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("iron_spade").setTextureName("iron_spade");
		
		ironDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Iron Dagger", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_dagger").setTextureName("iron_dagger");
		ironHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Iron Hatchet", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_hatchet").setTextureName("iron_hatchet");
		ironMace = (ItemMace) new ItemMace(MDMConfig.getItem("Iron Mace", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_mace").setTextureName("iron_mace");
		ironScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Iron Scimitar", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_scimitar").setTextureName("iron_scimitar");
		ironRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Iron Rapier", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iro_rapier").setTextureName("iron_rapier");
		ironLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Iron Longsword", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_longsword").setTextureName("iron_longsword");
		ironHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Iron Halberd", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_halberd").setTextureName("iron_halberd");
		ironSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Iron Spear", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_spear").setTextureName("iron_spear");
		ironHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Iron Hammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_hammer").setTextureName("iron_hammer");
		ironWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Iron Warhammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_warhammer").setTextureName("iron_warhammer");
		ironBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Iron Battleaxe", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_battleaxe").setTextureName("iron_battleaxe");
		ironClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Iron Claws", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_claws").setTextureName("iron_claws");
		ironSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Iron Saw", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("iron_saw").setTextureName("iron_saw");
		
		ironGloves = (ItemGloves) new ItemGloves(MDMConfig.getItem("Iron Gloves", itemID++), EnumArmorMaterial.IRON, 2).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("iron_gloves").setTextureName("iron_gloves");
		ironShield = (ItemShield) new ItemShield(MDMConfig.getItem("Iron Shield", itemID++), EnumArmorMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("iron_shield").setTextureName("iron_shield");
		
		// -- Gold --
		
		goldPickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Gold Pickaxe Variant", itemID++), EnumToolMaterial.GOLD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("gold_pickaxe_variant").setTextureName("gold_pickaxe_variant");
		goldSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Gold Spade", itemID++), EnumToolMaterial.GOLD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("goldSpade").setTextureName("gold_spade");
		
		goldDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Gold Dagger", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_dagger").setTextureName("gold_dagger");
		goldHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Gold Hatchet", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_hatchet").setTextureName("gold_hatchet");
		goldMace = (ItemMace) new ItemMace(MDMConfig.getItem("Gold Mace", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_mace").setTextureName("gold_mace");
		goldScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Gold Scimitar", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_scimitar").setTextureName("gold_scimitar");
		goldRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Gold Rapier", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_rapier").setTextureName("gold_rapier");
		goldLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Gold Longsword", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_longsword").setTextureName("gold_longsword");
		goldHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Gold Halberd", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_halberd").setTextureName("gold_halberd");
		goldSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Gold Spear", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_spear").setTextureName("gold_spear");
		goldHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Gold Hammer", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_hammer").setTextureName("gold_hammer");
		goldWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Gold Warhammer", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_warhammer").setTextureName("gold_warhammer");
		goldBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Gold Battleaxe", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_battleaxe").setTextureName("gold_battleaxe");
		goldClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Gold Claws", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldClaws").setTextureName("gold_claws");
		goldSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Gold Saw", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("gold_saw").setTextureName("gold_saw");
		
		goldGloves = (ItemGloves) new ItemGloves(MDMConfig.getItem("Gold Gloves", itemID++), EnumArmorMaterial.GOLD, 4).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("gold_gloves").setTextureName("gold_gloves");
		goldShield = (ItemShield) new ItemShield(MDMConfig.getItem("Gold Shield", itemID++), EnumArmorMaterial.GOLD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("gold_shield").setTextureName("gold_shield");
		
		// -- Diamond --
		
		diamondPickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Diamond Pickaxe Variant", itemID++), EnumToolMaterial.EMERALD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamond_pickaxe_variant").setTextureName("diamond_pickaxe_variant");
		diamondSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Diamond Spade", itemID++), EnumToolMaterial.EMERALD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamond_spade").setTextureName("diamond_spade");
		
		diamondDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Diamond Dagger", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_dagger").setTextureName("diamond_dagger");
		diamondHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Diamond Hatchet", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_hatchet").setTextureName("diamond_hatchet");
		diamondMace = (ItemMace) new ItemMace(MDMConfig.getItem("Diamond Mace", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_mace").setTextureName("diamond_mace");
		diamondScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Diamond Scimitar", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_scimitar").setTextureName("diamond_scimitar");
		diamondRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Diamond Rapier", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_rapier").setTextureName("diamond_rapier");
		diamondLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Diamond Longsword", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_longsword").setTextureName("diamond_longsword");
		diamondHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Diamond Halberd", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_halberd").setTextureName("diamond_halberd");
		diamondSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Diamond Spear", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_spear").setTextureName("diamond_spear");
		diamondHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Diamond Hammer", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_hammer").setTextureName("diamond_hammer");
		diamondWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Diamond Warhammer", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_warhammer").setTextureName("diamond_warhammer");
		diamondBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Diamond Battleaxe", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_battleaxe").setTextureName("diamond_battleaxe");
		diamondClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Diamond Claws", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_claws").setTextureName("diamond_claws");
		diamondSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Diamond Saw", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamond_saw").setTextureName("diamond_saw");
		
		diamondGloves = (ItemGloves) new ItemGloves(MDMConfig.getItem("Diamond Gloves", itemID++), EnumArmorMaterial.DIAMOND, 3).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamond_gloves").setTextureName("diamond_gloves");
		diamondShield = (ItemShield) new ItemShield(MDMConfig.getItem("Diamond Shield", itemID++), EnumArmorMaterial.DIAMOND).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamond_shield").setTextureName("diamond_shield");
	}
	
	public static void load()
	{
		// -- Wood --
		
		addItem(woodPickaxeVariant, "Wood Pickaxe");
		addItem(woodSpade, "Wood Spade");
		
		addItem(woodDagger, "Wood Dagger");
		addItem(woodHatchet, "Wood Hatchet");
		addItem(woodMace, "Wood Mace");
		addItem(woodScimitar, "Wood Scimitar");
		addItem(woodRapier, "Wood Rapier");
		addItem(woodLongsword, "Wood Longsword");
		addItem(woodHalberd, "Wood Halberd");
		addItem(woodSpear, "Wood Spear");
		addItem(woodHammer, "Wood Hammer");
		addItem(woodWarhammer, "Wood Warhammer");
		addItem(woodBattleaxe, "Wood Battleaxe");
		addItem(woodClaws, "Wood Claws");
		addItem(woodSaw, "Wood Saw");
		
		// addItem(woodGloves, "Wood Gloves");
		// addItem(woodShield, "Wood Shield");
		
		// -- Stone --
		
		addItem(stonePickaxeVariant, "Stone Pickaxe");
		addItem(stoneSpade, "Stone Spade");
		
		addItem(stoneDagger, "Stone Dagger");
		addItem(stoneHatchet, "Stone Hatchet");
		addItem(stoneMace, "Stone Mace");
		addItem(stoneScimitar, "Stone Scimitar");
		addItem(stoneRapier, "Stone Rapier");
		addItem(stoneLongsword, "Stone Longsword");
		addItem(stoneHalberd, "Stone Halberd");
		addItem(stoneSpear, "Stone Spear");
		addItem(stoneHammer, "Stone Hammer");
		addItem(stoneWarhammer, "Stone Warhammer");
		addItem(stoneBattleaxe, "Stone Battleaxe");
		addItem(stoneClaws, "Stone Claws");
		addItem(stoneSaw, "Stone Saw");
		
		// addItem(stoneGloves, "Stone Gloves");
		// addItem(stoneShield, "Stone Shield");
		
		// -- Iron --
		
		addItem(ironPickaxeVariant, "Iron Pickaxe");
		addItem(ironSpade, "Iron Spade");
		
		addItem(ironDagger, "Iron Dagger");
		addItem(ironHatchet, "Iron Hatchet");
		addItem(ironMace, "Iron Mace");
		addItem(ironScimitar, "Iron Scimitar");
		addItem(ironRapier, "Iron Rapier");
		addItem(ironLongsword, "Iron Longsword");
		addItem(ironHalberd, "Iron Halberd");
		addItem(ironSpear, "Iron Spear");
		addItem(ironHammer, "Iron Hammer");
		addItem(ironWarhammer, "Iron Warhammer");
		addItem(ironBattleaxe, "Iron Battleaxe");
		addItem(ironClaws, "Iron Claws");
		addItem(ironSaw, "Iron Saw");
		
		addItem(ironGloves, "Iron Gloves");
		addItem(ironShield, "Iron Shield");
		
		// -- Gold --
		
		addItem(goldPickaxeVariant, "Gold Pickaxe");
		addItem(goldSpade, "Gold Spade");
		
		addItem(goldDagger, "Gold Dagger");
		addItem(goldHatchet, "Gold Hatchet");
		addItem(goldMace, "Gold Mace");
		addItem(goldScimitar, "Gold Scimitar");
		addItem(goldRapier, "Gold Rapier");
		addItem(goldLongsword, "Gold Longsword");
		addItem(goldHalberd, "Gold Halberd");
		addItem(goldSpear, "Gold Spear");
		addItem(goldHammer, "Gold Hammer");
		addItem(goldWarhammer, "Gold Warhammer");
		addItem(goldBattleaxe, "Gold Battleaxe");
		addItem(goldClaws, "Gold Claws");
		addItem(goldSaw, "Gold Saw");
		
		addItem(goldGloves, "Gold Gloves");
		addItem(goldShield, "Gold Shield");
		
		// -- Diamond --
		
		addItem(diamondPickaxeVariant, "Diamond Pickaxe");
		addItem(diamondSpade, "Diamond Spade");
		
		addItem(diamondDagger, "Diamond Dagger");
		addItem(diamondHatchet, "Diamond Hatchet");
		addItem(diamondMace, "Diamond Mace");
		addItem(diamondScimitar, "Diamond Scimitar");
		addItem(diamondRapier, "Diamond Rapier");
		addItem(diamondLongsword, "Diamond Longsword");
		addItem(diamondHalberd, "Diamond Halberd");
		addItem(diamondSpear, "Diamond Spear");
		addItem(diamondHammer, "Diamond Hammer");
		addItem(diamondWarhammer, "Diamond Warhammer");
		addItem(diamondBattleaxe, "Diamond Battleaxe");
		addItem(diamondClaws, "Diamond Claws");
		addItem(diamondSaw, "Diamond Saw");
		
		addItem(diamondGloves, "Diamond Gloves");
		addItem(diamondShield, "Diamond Shield");
		
		MDMItems.tabTools.setIconItemStack(new ItemStack(ironDagger));
	}
	
	public static void addItem(Item item, String name)
	{
		MDMItems.addItem(item, name);
	}
}
