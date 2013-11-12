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
		
		// -- Iron --
		
		ironPickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Iron Pickaxe Variant", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("ironPickaxeVariant").setTextureName("ironPickaxeVariant");
		ironSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Iron Spade", itemID++), EnumToolMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("ironSpade").setTextureName("ironSpade");
		
		ironDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Iron Dagger", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironDagger").setTextureName("ironDagger");
		ironHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Iron Hatchet", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironHatchet").setTextureName("ironHatchet");
		ironMace = (ItemMace) new ItemMace(MDMConfig.getItem("Iron Mace", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironMace").setTextureName("ironMace");
		ironScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Iron Scimitar", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironScimitar").setTextureName("ironScimitar");
		ironRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Iron Rapier", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironRapier").setTextureName("ironRapier");
		ironLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Iron Longsword", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironLongsword").setTextureName("ironLongsword");
		ironHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Iron Halberd", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironHalberd").setTextureName("ironHalberd");
		ironSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Iron Spear", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironSpear").setTextureName("ironSpear");
		ironHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Iron Hammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironHammer").setTextureName("ironHammer");
		ironWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Iron Warhammer", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironWarhammer").setTextureName("ironWarhammer");
		ironBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Iron Battleaxe", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironBattleaxe").setTextureName("ironBattleaxe");
		ironClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Iron Claws", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironClaws").setTextureName("ironClaws");
		ironSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Iron Saw", itemID++), EnumToolMaterial.IRON).setUnlocalizedName("ironSaw").setTextureName("ironSaw");
		
		ironGloves = (ItemGloves) new ItemGloves(MDMConfig.getItem("Iron Gloves", itemID++), EnumArmorMaterial.IRON, 2).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("ironGloves").setTextureName("ironGloves");
		ironShield = (ItemShield) new ItemShield(MDMConfig.getItem("Iron Shield", itemID++), EnumArmorMaterial.IRON).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("ironShield").setTextureName("ironShield");
		
		// -- Gold --
		
		goldPickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Gold Pickaxe Variant", itemID++), EnumToolMaterial.GOLD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("goldPickaxeVariant").setTextureName("goldPickaxeVariant");
		goldSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Gold Spade", itemID++), EnumToolMaterial.GOLD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("goldSpade").setTextureName("goldSpade");
		
		goldDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Gold Dagger", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldDagger").setTextureName("goldDagger");
		goldHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Gold Hatchet", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldHatchet").setTextureName("goldHatchet");
		goldMace = (ItemMace) new ItemMace(MDMConfig.getItem("Gold Mace", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldMace").setTextureName("goldMace");
		goldScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Gold Scimitar", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldScimitar").setTextureName("goldScimitar");
		goldRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Gold Rapier", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldRapier").setTextureName("goldRapier");
		goldLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Gold Longsword", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldLongsword").setTextureName("goldLongsword");
		goldHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Gold Halberd", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldHalberd").setTextureName("goldHalberd");
		goldSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Gold Spear", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldSpear").setTextureName("goldSpear");
		goldHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Gold Hammer", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldHammer").setTextureName("goldHammer");
		goldWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Gold Warhammer", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldWarhammer").setTextureName("goldWarhammer");
		goldBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Gold Battleaxe", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldBattleaxe").setTextureName("goldBattleaxe");
		goldClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Gold Claws", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldClaws").setTextureName("goldClaws");
		goldSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Gold Saw", itemID++), EnumToolMaterial.GOLD).setUnlocalizedName("goldSaw").setTextureName("goldSaw");
		
		goldGloves = (ItemGloves) new ItemGloves(MDMConfig.getItem("Gold Gloves", itemID++), EnumArmorMaterial.GOLD, 4).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("goldGloves").setTextureName("goldGloves");
		goldShield = (ItemShield) new ItemShield(MDMConfig.getItem("Gold Shield", itemID++), EnumArmorMaterial.GOLD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("goldShield").setTextureName("goldShield");
		
		// -- Diamond --
		
		diamondPickaxeVariant = (ItemPickaxe) new ItemPickaxe(MDMConfig.getItem("Diamond Pickaxe Variant", itemID++), EnumToolMaterial.EMERALD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamondPickaxeVariant").setTextureName("diamondPickaxeVariant");
		diamondSpade = (ItemSpade) new ItemSpade(MDMConfig.getItem("Diamond Spade", itemID++), EnumToolMaterial.EMERALD).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamondSpade").setTextureName("diamondSpade");
		
		diamondDagger = (ItemDagger) new ItemDagger(MDMConfig.getItem("Diamond Dagger", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondDagger").setTextureName("diamondDagger");
		diamondHatchet = (ItemHatchet) new ItemHatchet(MDMConfig.getItem("Diamond Hatchet", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondHatchet").setTextureName("diamondHatchet");
		diamondMace = (ItemMace) new ItemMace(MDMConfig.getItem("Diamond Mace", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondMace").setTextureName("diamondMace");
		diamondScimitar = (ItemScimitar) new ItemScimitar(MDMConfig.getItem("Diamond Scimitar", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondScimitar").setTextureName("diamondScimitar");
		diamondRapier = (ItemRapier) new ItemRapier(MDMConfig.getItem("Diamond Rapier", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondRapier").setTextureName("diamondRapier");
		diamondLongsword = (ItemLongsword) new ItemLongsword(MDMConfig.getItem("Diamond Longsword", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondLongsword").setTextureName("diamondLongsword");
		diamondHalberd = (ItemHalberd) new ItemHalberd(MDMConfig.getItem("Diamond Halberd", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondHalberd").setTextureName("diamondHalberd");
		diamondSpear = (ItemSpear) new ItemSpear(MDMConfig.getItem("Diamond Spear", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondSpear").setTextureName("diamondSpear");
		diamondHammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Diamond Hammer", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondHammer").setTextureName("diamondHammer");
		diamondWarhammer = (ItemHammer) new ItemHammer(MDMConfig.getItem("Diamond Warhammer", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondWarhammer").setTextureName("diamondWarhammer");
		diamondBattleaxe = (ItemBattleaxe) new ItemBattleaxe(MDMConfig.getItem("Diamond Battleaxe", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondBattleaxe").setTextureName("diamondBattleaxe");
		diamondClaws = (ItemClaws) new ItemClaws(MDMConfig.getItem("Diamond Claws", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondClaws").setTextureName("diamondClaws");
		diamondSaw = (ItemSaw) new ItemSaw(MDMConfig.getItem("Diamond Saw", itemID++), EnumToolMaterial.EMERALD).setUnlocalizedName("diamondSaw").setTextureName("diamondSaw");
		
		diamondGloves = (ItemGloves) new ItemGloves(MDMConfig.getItem("Diamond Gloves", itemID++), EnumArmorMaterial.DIAMOND, 3).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamondGloves").setTextureName("diamondGloves");
		diamondShield = (ItemShield) new ItemShield(MDMConfig.getItem("Diamond Shield", itemID++), EnumArmorMaterial.DIAMOND).setCreativeTab(MDMItems.tabTools).setUnlocalizedName("diamondShield").setTextureName("diamondShield");
	}
	
	public static void load()
	{
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
		addItem(ironHammer, "Iron Warhammer");
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
		addItem(goldHammer, "Gold Warhammer");
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
		addItem(diamondHammer, "Diamond Warhammer");
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
