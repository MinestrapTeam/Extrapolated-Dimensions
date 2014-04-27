package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.minecraft.addon.Addon;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.util.CSArrays;
import clashsoft.cslib.util.CSString;
import clashsoft.mods.moredimensions.common.MDMProxy;
import clashsoft.mods.moredimensions.item.armor.*;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemBattleaxe;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemHatchet;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemSaw;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemThrowableAxe;
import clashsoft.mods.moredimensions.item.tools.*;
import clashsoft.mods.moredimensions.item.tools.ItemBowMDM.ItemCrossBow;
import clashsoft.mods.moredimensions.item.tools.ItemBowMDM.ItemShortBow;
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
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

@Addon(modName = "MoreDimensionsMod", addonName = "Tools")
public class MDMTools
{
	public static ToolMaterial		toolWood			= ToolMaterial.WOOD;
	public static ToolMaterial		toolStone			= ToolMaterial.STONE;
	public static ToolMaterial		toolIron			= ToolMaterial.IRON;
	public static ToolMaterial		toolGold			= ToolMaterial.GOLD;
	public static ToolMaterial		toolDiamond			= ToolMaterial.EMERALD;
	
	public static ToolMaterial		toolHeavenWood		= EnumHelper.addToolMaterial("HEAVENWOOD", 0, 64, 1F, 1F, 14);
	public static ToolMaterial		toolHeavenStone		= EnumHelper.addToolMaterial("HEAVENSTONE", 1, 64, 2F, 2, 12);
	public static ToolMaterial		toolShrekite		= EnumHelper.addToolMaterial("SHREKITE", 1, 128, 3F, 3, 9);
	public static ToolMaterial		toolClashium		= EnumHelper.addToolMaterial("CLASHIUM", 2, 256, 4F, 5, 11);
	public static ToolMaterial		toolHolyium			= EnumHelper.addToolMaterial("HOLYIUM", 3, 2048, 6F, 20, 10);
	public static ToolMaterial		toolEnergy			= EnumHelper.addToolMaterial("ENERGY", 3, 1536, 5F, 10, 2);
	public static ToolMaterial		toolPro				= EnumHelper.addToolMaterial("PRO", 3, 4096, 8F, 10, 10);
	public static ToolMaterial		toolPulse			= EnumHelper.addToolMaterial("PULSE", 2, 512, 3F, 2F, 10);
	public static ToolMaterial		toolFire			= EnumHelper.addToolMaterial("FIRE", 2, 416, 3.5F, 2F, 8);
	
	public static ToolMaterial		toolWillow			= EnumHelper.addToolMaterial("WILLOW", 0, 100, 1.2F, 1.5F, 16);
	public static ToolMaterial		toolGoldWood		= ToolMaterial.GOLD;
	public static ToolMaterial		toolDaeyalt			= EnumHelper.addToolMaterial("DAEYALT", 2, 512, 4F, 4F, 7);
	public static ToolMaterial		toolMarmoros		= ToolMaterial.GOLD;
	public static ToolMaterial		toolNovite			= ToolMaterial.GOLD;
	public static ToolMaterial		toolKratonium		= ToolMaterial.GOLD;
	public static ToolMaterial		toolShannara		= EnumHelper.addToolMaterial("SHANNARA", 3, 2048, 15.0F, 3.2F, Integer.MAX_VALUE);
	
	public static ArmorMaterial		armorWood			= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorStone			= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorIron			= ArmorMaterial.IRON;
	public static ArmorMaterial		armorGold			= ArmorMaterial.GOLD;
	public static ArmorMaterial		armorDiamond		= ArmorMaterial.DIAMOND;
	
	public static ArmorMaterial		armorHeavenWood		= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorHeavenStone	= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorShrekite		= EnumHelper.addArmorMaterial("SHREKITE", 32, new int[] { 1, 5, 3, 1 }, 9);
	public static ArmorMaterial		armorClashium		= EnumHelper.addArmorMaterial("CLASHIUM", 64, new int[] { 2, 6, 4, 2 }, 11);
	public static ArmorMaterial		armorHolyium		= EnumHelper.addArmorMaterial("HOLYIUM", 128, new int[] { 3, 9, 7, 3 }, 10);
	public static ArmorMaterial		armorEnergy			= EnumHelper.addArmorMaterial("ENERGY", 256, new int[] { 6, 16, 12, 6 }, 2);
	public static ArmorMaterial		armorPro			= EnumHelper.addArmorMaterial("PRO", 512, new int[] { 7, 18, 14, 7 }, 10);
	public static ArmorMaterial		armorPulse			= ArmorMaterial.IRON;
	
	public static ArmorMaterial		armorWillow			= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorGoldWood		= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorDaeyalt		= EnumHelper.addArmorMaterial("DAEYALT", 265, new int[] { 4, 9, 7, 4 }, 7);
	public static ArmorMaterial		armorMarmoros		= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorNovite			= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorKratonium		= ArmorMaterial.CHAIN;
	public static ArmorMaterial		armorShannara		= ArmorMaterial.CHAIN;
	
	public static String[]			toolTypes			= new String[] { "Axe", "Battleaxe", "Boots", "Bow", "Chestplate", "Claws", "Crossbow", "Dagger", "Dart", "Gloves", "Halberd", "Hammer", "Hatchet", "Helmet", "Hoe", "Javelin", "Leggings", "Longsword", "Mace", "Ninjastar", "Pickaxe", "Pickaxe Variant", "Rapier", "Saw", "Scimitar", "Shield", "Shortbow", "Shovel", "Spade", "Spear", "Sword", "Throwing Axe", "Throwing Knife", "Warhammer" };
	public static Class[]			toolClasses			= new Class[] { ItemAxeMDM.class, ItemBattleaxe.class, ItemBoots.class, ItemBowMDM.class, ItemChestplate.class, ItemClaws.class, ItemCrossBow.class, ItemDagger.class, ItemDart.class, ItemGloves.class, ItemHalberd.class, ItemHammer.class, ItemHatchet.class, ItemHelmet.class, ItemHoe.class, ItemJavelin.class, ItemLeggings.class, ItemLongsword.class, ItemMace.class, ItemNinjaStar.class, ItemPickaxeMDM.class, ItemPickaxeMDM.class, ItemRapier.class, ItemSaw.class, ItemScimitar.class, ItemShield.class, ItemShortBow.class, ItemSpade.class, ItemSpade.class, ItemSpear.class, ItemSword.class, ItemThrowableAxe.class, ItemThrowableKnife.class, ItemWarhammer.class };
	
	public static String[]			materialNames		= new String[] { "Wood", "Stone", "Iron", "Gold", "Diamond", // Vanilla
			"Heaven Wood", "Heaven Stone", "Shrekite", "Clashium", "Holyium", "Energy", "Pro", "Pulse", // Heaven
			"Willow", "Gold Wood", "Daeyalt", "Marmaros", "Novite", "Kratonium", "Shannara" // POC
														};
	
	public static CreativeTabs		advancedTools		= MDMItems.tabTools, advancedArmor = MDMItems.tabTools;
	public static CreativeTabs		heavenTools			= MDMItems.tabHeavenTools, heavenArmor = MDMItems.tabHeavenArmor;
	public static CreativeTabs		pocTools			= MDMItems.tabPOCTools, pocArmor = MDMItems.tabPOCArmor;
	
	public static CreativeTabs[]	toolTabs			= CSArrays.create(advancedTools, advancedTools, advancedTools, advancedTools, advancedTools, // Vanilla
																heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, // Heaven
																pocTools, pocTools, pocTools, pocTools, pocTools, pocTools, pocTools // POC
																);
	public static CreativeTabs[]	armorTabs			= CSArrays.create(advancedArmor, advancedArmor, advancedArmor, advancedArmor, advancedArmor, // Vanilla
																heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, // Heaven
																pocArmor, pocArmor, pocArmor, pocArmor, pocArmor, pocArmor, pocArmor // POC
																);
	
	public static ToolMaterial[]	toolMaterials		= CSArrays.create(toolWood, toolStone, toolIron, toolGold, toolDiamond, // Vanilla
																toolHeavenWood, toolHeavenStone, toolShrekite, toolClashium, toolHolyium, toolEnergy, toolPro, toolPulse, // Heaven
																toolWillow, toolGoldWood, toolDaeyalt, toolMarmoros, toolNovite, toolKratonium, toolShannara // POC
																);
	
	public static ArmorMaterial[]	armorMaterials		= CSArrays.create(armorWood, armorStone, armorIron, armorGold, armorDiamond, // Vanilla
																armorHeavenWood, armorHeavenStone, armorShrekite, armorClashium, armorHolyium, armorEnergy, armorPro, armorPulse, // Heaven
																armorWillow, armorGoldWood, armorDaeyalt, armorMarmoros, armorNovite, armorKratonium, armorShannara // POC
																);
	
	public static Item[][]			items				= new Item[materialNames.length][toolTypes.length];
	
	public static int				toolItemID			= 27000;
	
	public static void initialize()
	{
		for (int materialIndex = 0; materialIndex < materialNames.length; materialIndex++)
		{
			String materialName = materialNames[materialIndex];
			String materialID = materialName.replace(" ", "");
			
			CreativeTabs toolTab = toolTabs[materialIndex];
			
			CreativeTabs armorTab = armorTabs[materialIndex];
			ToolMaterial toolMaterial = toolMaterials[materialIndex];
			ArmorMaterial armorMaterial = armorMaterials[materialIndex];
			
			boolean vanillaMaterial = (materialName == "Wood" || materialName == "Stone" || materialName == "Iron" || materialName == "Gold" || materialName == "Diamond");
			
			for (int toolIndex = 0; toolIndex < toolTypes.length; toolIndex++)
			{
				String toolType = toolTypes[toolIndex];
				
				String itemName = materialName + " " + toolType;
				String itemID = materialID + toolType.replace(" ", "");
				String itemIconName = CSString.fastConcat("moredimensions_tools:", materialID, "_", toolType.replace(" ", "_")).toLowerCase();
				
				Class toolClass = toolClasses[toolIndex];
				
				Item item = null;
				
				if (ItemArmor.class.isAssignableFrom(toolClass))
				{
					boolean vanillaArmor = vanillaMaterial && (toolClass == ItemHelmet.class || toolClass == ItemChestplate.class || toolClass == ItemLeggings.class || toolClass == ItemBoots.class);
					if (!vanillaArmor)
					{
						item = CSItems.createItem(toolClass, itemName, new Class[] { ArmorMaterial.class, int.class }, new Object[] { armorMaterial, MDMProxy.getArmorIndex(materialID.toLowerCase()) });
						if (item != null)
						{
							item.setCreativeTab(armorTab);
						}
					}
				}
				else
				{
					if (!vanillaMaterial || (toolClass != ItemSword.class && toolClass != ItemSpade.class && toolClass != ItemPickaxe.class && toolClass != ItemAxe.class && toolClass != ItemHoe.class))
					{
						item = CSItems.createItem(toolClass, itemName, new Class[] { ToolMaterial.class }, new Object[] { toolMaterial });
						if (item != null)
						{
							item.setCreativeTab(toolTab);
						}
					}
				}
				
				if (item != null)
				{
					item.setUnlocalizedName(itemID).setTextureName(itemIconName);
					CSItems.addItem(item);
				}
			}
		}
	}
	
	public static void load()
	{
	}
}
