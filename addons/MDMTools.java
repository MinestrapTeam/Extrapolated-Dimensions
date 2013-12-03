package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.addon.Addon;
import clashsoft.cslib.util.CSArrays;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.item.armor.*;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemBattleaxe;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemHatchet;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemSaw;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemThrowableAxe;
import clashsoft.mods.moredimensions.item.tools.ItemBowMDM.ItemCrossBow;
import clashsoft.mods.moredimensions.item.tools.ItemBowMDM.ItemShortBow;
import clashsoft.mods.moredimensions.item.tools.*;
import clashsoft.mods.moredimensions.item.tools.ItemHammer.ItemWarhammer;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemClaws;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemDagger;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemDart;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemHalberd;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemJavelin;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemLongsword;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemNinjaStar;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemRapier;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemScimitar;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemSpear;
import clashsoft.mods.moredimensions.item.tools.ItemSwordMDM.ItemThrowableKnife;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.common.EnumHelper;

@Addon(modName = "MoreDimensionsMod", addonName = "Tools")
public class MDMTools
{
	public static EnumToolMaterial		toolWood			= EnumToolMaterial.WOOD;
	public static EnumToolMaterial		toolStone			= EnumToolMaterial.STONE;
	public static EnumToolMaterial		toolIron			= EnumToolMaterial.IRON;
	public static EnumToolMaterial		toolGold			= EnumToolMaterial.GOLD;
	public static EnumToolMaterial		toolDiamond			= EnumToolMaterial.EMERALD;
	
	public static EnumToolMaterial		toolHeavenWood		= EnumHelper.addToolMaterial("HEAVENWOOD", 0, 64, 1F, 1F, 14);
	public static EnumToolMaterial		toolHeavenStone		= EnumHelper.addToolMaterial("HEAVENSTONE", 1, 64, 2F, 2, 12);
	public static EnumToolMaterial		toolShrekite		= EnumHelper.addToolMaterial("SHREKITE", 1, 128, 3F, 3, 9);
	public static EnumToolMaterial		toolClashium		= EnumHelper.addToolMaterial("CLASHIUM", 2, 256, 4F, 5, 11);
	public static EnumToolMaterial		toolHolyium			= EnumHelper.addToolMaterial("HOLYIUM", 3, 2048, 6F, 20, 10);
	public static EnumToolMaterial		toolEnergy			= EnumHelper.addToolMaterial("ENERGY", 3, 1536, 5F, 10, 2);
	public static EnumToolMaterial		toolPro				= EnumHelper.addToolMaterial("PRO", 3, 4096, 8F, 10, 10);
	public static EnumToolMaterial		toolPulse			= EnumHelper.addToolMaterial("PULSE", 2, 512, 3F, 2F, 10);
	public static EnumToolMaterial		toolFire			= EnumHelper.addToolMaterial("FIRE", 2, 416, 3.5F, 2F, 8);
	
	public static EnumToolMaterial		toolWillow			= EnumHelper.addToolMaterial("WILLOW", 0, 100, 1.2F, 1.5F, 16);
	public static EnumToolMaterial		toolGoldWood		= EnumToolMaterial.GOLD;
	public static EnumToolMaterial		toolDaeyalt			= EnumHelper.addToolMaterial("DAEYALT", 2, 512, 4F, 4F, 7);
	public static EnumToolMaterial		toolMarmoros		= EnumToolMaterial.GOLD;
	public static EnumToolMaterial		toolNovite			= EnumToolMaterial.GOLD;
	public static EnumToolMaterial		toolKratonium		= EnumToolMaterial.GOLD;
	public static EnumToolMaterial		toolShannara		= EnumHelper.addToolMaterial("SHANNARA", 3, 2048, 15.0F, 3.2F, Integer.MAX_VALUE);
	
	public static EnumArmorMaterial		armorWood			= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorStone			= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorIron			= EnumArmorMaterial.IRON;
	public static EnumArmorMaterial		armorGold			= EnumArmorMaterial.GOLD;
	public static EnumArmorMaterial		armorDiamond		= EnumArmorMaterial.DIAMOND;
	
	public static EnumArmorMaterial		armorHeavenWood		= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorHeavenStone	= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorShrekite		= EnumHelper.addArmorMaterial("SHREKITE", 32, new int[] { 1, 5, 3, 1 }, 9);
	public static EnumArmorMaterial		armorClashium		= EnumHelper.addArmorMaterial("CLASHIUM", 64, new int[] { 2, 6, 4, 2 }, 11);
	public static EnumArmorMaterial		armorHolyium		= EnumHelper.addArmorMaterial("HOLYIUM", 128, new int[] { 3, 9, 7, 3 }, 10);
	public static EnumArmorMaterial		armorEnergy			= EnumHelper.addArmorMaterial("ENERGY", 256, new int[] { 6, 16, 12, 6 }, 2);
	public static EnumArmorMaterial		armorPro			= EnumHelper.addArmorMaterial("PRO", 512, new int[] { 7, 18, 14, 7 }, 10);
	public static EnumArmorMaterial		armorPulse			= EnumArmorMaterial.IRON;
	
	public static EnumArmorMaterial		armorWillow			= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorGoldWood		= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorDaeyalt		= EnumHelper.addArmorMaterial("DAEYALT", 265, new int[] { 4, 9, 7, 4 }, 7);
	public static EnumArmorMaterial		armorMarmoros		= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorNovite			= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorKratonium		= EnumArmorMaterial.CHAIN;
	public static EnumArmorMaterial		armorShannara		= EnumArmorMaterial.CHAIN;
	
	public static String[]				toolTypes			= CSArrays.create("Axe", "Battleaxe", "Boots", "Bow", "Chestplate",//
																	"Claws", "Crossbow", "Dagger", "Dart", "Gloves", //
																	"Halberd", "Hammer", "Hatchet", "Helmet", "Hoe", //
																	"Javelin", "Leggings", "Longsword", "Mace", "Ninjastar", //
																	"Pickaxe", "Pickaxe Variant", "Rapier", "Saw", "Scimitar", //
																	"Shield", "Shortbow", "Shovel", "Spade", "Spear", //
																	"Sword", "Throwing Axe", "Throwing Knife", "Warhammer");
	public static Class[]				toolClasses			= CSArrays.create(ItemAxe.class, ItemBattleaxe.class, ItemBoots.class, ItemBowMDM.class, ItemChestplate.class, //
																	ItemClaws.class, ItemCrossBow.class, ItemDagger.class, ItemDart.class, ItemGloves.class, //
																	ItemHalberd.class, ItemHammer.class, ItemHatchet.class, ItemHelmet.class, ItemHoe.class, //
																	ItemJavelin.class, ItemLeggings.class, ItemLongsword.class, ItemMace.class, ItemNinjaStar.class, //
																	ItemPickaxe.class, ItemPickaxe.class, ItemRapier.class, ItemSaw.class, ItemScimitar.class, //
																	ItemShield.class, ItemShortBow.class, ItemSpade.class, ItemSpade.class, ItemSpear.class, //
																	ItemSword.class, ItemThrowableAxe.class, ItemThrowableKnife.class, ItemWarhammer.class);
	
	public static String[]				materialNames		= CSArrays.create("Wood", "Stone", "Iron", "Gold", "Diamond", // Vanilla
																	"Heaven Wood", "Heaven Stone", "Shrekite", "Clashium", "Holyium", "Energy", "Pro", "Pulse", // Heaven
																	"Willow", "Gold Wood", "Daeyalt", "Marmaros", "Novite", "Kratonium", "Shannara" // POC
															);
	
	public static CreativeTabs			advancedTools		= MDMItems.tabTools, advancedArmor = CreativeTabs.tabCombat;
	public static CreativeTabs			heavenTools			= MDMItems.tabHeavenTools, heavenArmor = MDMItems.tabHeavenArmor;
	public static CreativeTabs			pocTools			= MDMItems.tabPOCTools, pocArmor = MDMItems.tabPOCArmor;
	
	public static CreativeTabs[]		toolTabs			= CSArrays.create(advancedTools, advancedTools, advancedTools, advancedTools, advancedTools, // Vanilla
																	heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, // Heaven
																	pocTools, pocTools, pocTools, pocTools, pocTools, pocTools, pocTools // POC
																	);
	public static CreativeTabs[]		armorTabs			= CSArrays.create(advancedArmor, advancedArmor, advancedArmor, advancedArmor, advancedArmor, // Vanilla
																	heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, // Heaven
																	pocArmor, pocArmor, pocArmor, pocArmor, pocArmor, pocArmor, pocArmor // POC
																	);
	
	public static EnumToolMaterial[]	toolMaterials		= CSArrays.create(toolWood, toolStone, toolIron, toolGold, toolDiamond, // Vanilla
																	toolHeavenWood, toolHeavenStone, toolShrekite, toolClashium, toolHolyium, toolEnergy, toolPro, toolPulse, // Heaven
																	toolWillow, toolGoldWood, toolDaeyalt, toolMarmoros, toolNovite, toolKratonium, toolShannara // POC
																	);
	
	public static EnumArmorMaterial[]	armorMaterials		= CSArrays.create(armorWood, armorStone, armorIron, armorGold, armorDiamond, // Vanilla
																	armorHeavenWood, armorHeavenStone, armorShrekite, armorClashium, armorHolyium, armorEnergy, armorPro, armorPulse, // Heaven
																	armorWillow, armorGoldWood, armorDaeyalt, armorMarmoros, armorNovite, armorKratonium, armorShannara // POC
																	);
	
	public static Item[][]				items				= new Item[materialNames.length][35];
	
	public static int					toolItemID			= 27000;
	
	public static void initialize()
	{
		for (int materialIndex = 0; materialIndex < materialNames.length; materialIndex++)
		{
			String materialName = materialNames[materialIndex];
			String materialID = materialName.replace(" ", "");
			
			CreativeTabs toolTab = toolTabs[materialIndex];
			
			CreativeTabs armorTab = armorTabs[materialIndex];
			EnumToolMaterial toolMaterial = toolMaterials[materialIndex];
			EnumArmorMaterial armorMaterial = armorMaterials[materialIndex];
			
			boolean vanillaMaterial = (materialName == "Wood" || materialName == "Stone" || materialName == "Iron" || materialName == "Gold" || materialName == "Diamond");
			
			for (int toolIndex = 0; toolIndex < toolTypes.length; toolIndex++)
			{	
				String toolType = toolTypes[toolIndex];
				
				String itemName = materialName + " " + toolType;
				String itemID = materialID + toolType.replace(" ", "");
				String itemIconName = (materialID + "_" + toolType.replace(" ", "_")).toLowerCase();
				
				Class toolClass = toolClasses[toolIndex];
				
				boolean vanillaTool = vanillaMaterial && (toolClass == ItemSword.class || toolClass == ItemSpade.class || toolClass == ItemPickaxe.class || toolClass == ItemAxe.class || toolClass == ItemHoe.class);
				boolean vanillaArmor = vanillaMaterial && (toolClass == ItemHelmet.class || toolClass == ItemChestplate.class || toolClass == ItemLeggings.class || toolClass == ItemBoots.class);
				
				if (ItemArmor.class.isAssignableFrom(toolClass))
				{
					if (!vanillaArmor)
						items[materialIndex][toolIndex] = MDMItems.addItem(toolClass, itemName, new Class[] { int.class, EnumArmorMaterial.class, int.class }, new Object[] { MDMConfig.getItem(itemName, toolItemID++), armorMaterial, MDMCommonProxy.getArmorIndex(itemIconName) }).setCreativeTab(armorTab).setUnlocalizedName(itemID).setTextureName(itemIconName);
				}
				else
				{
					if (!vanillaTool)
						items[materialIndex][toolIndex] = MDMItems.addItem(toolClass, itemName, new Class[] { int.class, EnumToolMaterial.class }, new Object[] { MDMConfig.getItem(itemName, toolItemID++), toolMaterial }).setCreativeTab(toolTab).setUnlocalizedName(itemID).setTextureName(itemIconName);
				}
			}
		}
	}
	
	public static void load()
	{
		
	}
	
	public static void addItem(Item item, String name)
	{
		MDMItems.addItem(item, name);
	}
}
