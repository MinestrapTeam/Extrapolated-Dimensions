package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.util.CSArrays;
import clashsoft.mods.moredimensions.common.MDMProxy;
import clashsoft.mods.moredimensions.item.armor.*;
import clashsoft.mods.moredimensions.item.tools.*;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemBattleaxe;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemHatchet;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemSaw;
import clashsoft.mods.moredimensions.item.tools.ItemAxeMDM.ItemThrowableAxe;
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

public class Tools
{
	public static CustomCreativeTab	tabTools			= new CustomCreativeTab("mdm_tools");
	
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
	
	public static String[]			toolTypes			= CSArrays.create("sword", "shovel", "pickaxe", "axe", "hoe", // Tools
																"helmet", "chestplate", "leggings", "boots", // Armor
																"gloves", "shield", // Armor
																"bow", "crossbow", "shortbow", // Bows
																"battleaxe", "claws", "dagger", "dart", "halberd", "hammer", "hatchet", //
																"javelin", "longsword", "mace", "ninjastar", "pickaxe_variant", "rapier", "saw", "scimitar", //
																"spade", "spear", "throwing_axe", "throwing_knife", "warhammer");
	public static Class[]			toolClasses			= CSArrays.create(ItemSword.class, ItemSpade.class, ItemPickaxeMDM.class, ItemAxeMDM.class, ItemHoe.class, // Tools
																ItemHelmet.class, ItemChestplate.class, ItemLeggings.class, ItemBoots.class, // Armor
																ItemGloves.class, ItemShield.class, // Armor
																ItemBowMDM.class, ItemCrossBow.class, ItemShortBow.class, // Bows
																ItemBattleaxe.class, ItemClaws.class, ItemDagger.class, ItemDart.class, ItemHalberd.class, ItemHammer.class, ItemHatchet.class, //
																ItemJavelin.class, ItemLongsword.class, ItemMace.class, ItemNinjaStar.class, ItemPickaxeMDM.class, ItemRapier.class, ItemSaw.class, ItemScimitar.class, //
																ItemSpade.class, ItemSpear.class, ItemThrowableAxe.class, ItemThrowableKnife.class, ItemWarhammer.class);
	
	public static String[]			materialNames		= new String[] { "wood", "stone", "iron", "gold", "diamond", // vanilla
			"heavenwood", "heavenstone", "shrekite", "clashium", "holyium", "energy", "pro", // heaven
			"willow", "gold_wood" // poc
														};
	
	public static CreativeTabs		advancedTools		= tabTools, advancedArmor = tabTools;
	public static CreativeTabs		heavenTools			= Heaven.tabHeavenTools, heavenArmor = Heaven.tabHeavenArmor;
	public static CreativeTabs		pocTools			= ParadiseOfChaos.tabTools, pocArmor = ParadiseOfChaos.tabArmor;
	
	public static CreativeTabs[]	toolTabs			= CSArrays.create(advancedTools, advancedTools, advancedTools, advancedTools, advancedTools, // Vanilla
																heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, heavenTools, // Heaven
																pocTools, pocTools // POC
																);
	public static CreativeTabs[]	armorTabs			= CSArrays.create(advancedArmor, advancedArmor, advancedArmor, advancedArmor, advancedArmor, // Vanilla
																heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, heavenArmor, // Heaven
																pocArmor, pocArmor // POC
																);
	
	public static ToolMaterial[]	toolMaterials		= CSArrays.create(toolWood, toolStone, toolIron, toolGold, toolDiamond, // Vanilla
																toolHeavenWood, toolHeavenStone, toolShrekite, toolClashium, toolHolyium, toolEnergy, toolPro, // Heaven
																toolWillow, toolGoldWood // POC
																);
	
	public static ArmorMaterial[]	armorMaterials		= CSArrays.create(armorWood, armorStone, armorIron, armorGold, armorDiamond, // Vanilla
																armorHeavenWood, armorHeavenStone, armorShrekite, armorClashium, armorHolyium, armorEnergy, armorPro, // Heaven
																armorWillow, armorGoldWood // POC
																);
	
	public static Item[][]			items				= new Item[materialNames.length][toolTypes.length];
	
	public static void init()
	{
		for (int materialIndex = 0; materialIndex < materialNames.length; materialIndex++)
		{
			String material = materialNames[materialIndex];
			
			CreativeTabs toolTab = toolTabs[materialIndex];
			
			CreativeTabs armorTab = armorTabs[materialIndex];
			ToolMaterial toolMaterial = toolMaterials[materialIndex];
			ArmorMaterial armorMaterial = armorMaterials[materialIndex];
			
			boolean vanillaMaterial = (material == "wood" || material == "stone" || material == "iron" || material == "gold" || material == "diamond");
			
			for (int toolIndex = 0; toolIndex < toolTypes.length; toolIndex++)
			{
				String toolType = toolTypes[toolIndex];
				
				String itemID = material + "_" + toolType;
				String itemIconName = "mdm_tools:" + itemID;
				
				Class toolClass = toolClasses[toolIndex];
				
				Item item = null;
				
				if (ItemArmor.class.isAssignableFrom(toolClass))
				{
					if (!vanillaMaterial || (toolClass != ItemHelmet.class && toolClass != ItemChestplate.class && toolClass != ItemLeggings.class && toolClass != ItemBoots.class))
					{
						item = CSItems.createItem(toolClass, itemID, new Class[] { ArmorMaterial.class, int.class }, new Object[] { armorMaterial, MDMProxy.getArmorIndex(material.toLowerCase()) });
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
						item = CSItems.createItem(toolClass, itemID, new Class[] { ToolMaterial.class }, new Object[] { toolMaterial });
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
