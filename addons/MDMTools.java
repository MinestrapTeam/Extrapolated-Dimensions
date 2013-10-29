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
	
	public static void initialize()
	{
		int itemID = 27000;
		
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
	}
	
	public static void load()
	{
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
		
		MDMItems.tabTools.setIconItemStack(new ItemStack(ironDagger));
	}
	
	public static void addItem(Item item, String name)
	{
		MDMItems.addItem(item, name);
	}
}
