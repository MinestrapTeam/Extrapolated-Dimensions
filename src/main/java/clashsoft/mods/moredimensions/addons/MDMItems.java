package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.minecraft.addon.Addon;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.cslib.util.CSString;
import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.item.alchemy.ItemAlchemyGuide;
import clashsoft.mods.moredimensions.item.alchemy.ItemElixir;
import clashsoft.mods.moredimensions.item.alchemy.ItemElixirBottle;
import clashsoft.mods.moredimensions.item.alchemy.ItemMatter;
import clashsoft.mods.moredimensions.item.armor.ItemCape;
import clashsoft.mods.moredimensions.item.heaven.*;
import clashsoft.mods.moredimensions.item.poc.ItemManaStar;
import clashsoft.mods.moredimensions.item.poc.ItemStaff;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

@Addon(modName = MoreDimensionsMod.NAME, addonName = "Items")
public class MDMItems
{
	public static CustomCreativeTab			tabTools		= new CustomCreativeTab("mdm_tools");
	
	public static CustomCreativeTab			tabPOCBlocks	= new CustomCreativeTab("poc_blocks");
	public static CustomCreativeTab			tabPOCItems		= new CustomCreativeTab("poc_items");
	public static CustomCreativeTab			tabPOCTools		= new CustomCreativeTab("poc_tools");
	public static CustomCreativeTab			tabPOCArmor		= new CustomCreativeTab("poc_armor");
	
	public static CustomCreativeTab			tabAlchemy		= new CustomCreativeTab("alchemy");
	
	public static CustomCreativeTab			tabHeavenBlocks	= new CustomCreativeTab("heaven_blocks");
	public static CustomCreativeTab			tabHeavenItems	= new CustomCreativeTab("heaven_items");
	public static CustomCreativeTab			tabHeavenTools	= new CustomCreativeTab("heaven_tools");
	public static CustomCreativeTab			tabHeavenArmor	= new CustomCreativeTab("heaven_armor");
	
	// -- Paradise of Chaos --
	
	public static ItemStaff					staves;
	public static ItemManaStar				manaStar;
	
	public static CustomItem				pocMaterials;
	
	public static ItemStack					magicOakStick, willowStick, promethiumGem, noviteGem, marmarosGem, kratoniumIngot;
	
	// -- Heaven --
	
	public static ItemHeavenMaterials		heavenMaterials;
	public static ItemFood					heavenApple;
	public static ItemLifeHeart				lifeHeart;
	public static ItemFireSword				fireSword;
	public static ItemIceHammer				icehammer;
	public static ItemHeavenSoul			heavenSouls;
	public static ItemHeavenPortalActivator	heavenPortalActivator;
	public static ItemCape					capes;
	public static ItemHeavenSeeds			heavenSeeds;
	public static CustomItem				specialItems;
	public static ItemIceStick				iceStick;
	
	public static ItemStack					heavenWoodStick, goldWoodStick, heavenArrow, shrekiteShard, clashiumIngot, holyiumIngot, energyOrb, proAlloy, bluriteDust;
	
	// -- Alchemy --
	
	public static ItemAlchemyGuide			alchemyGuide;
	public static ItemElixir				elixir;
	public static ItemElixirBottle			elixirBottle;
	public static ItemMatter				matter;
	
	public static void initialize()
	{
		// -- Paradise of Chaos --
		
		staves = (ItemStaff) new ItemStaff().setCreativeTab(tabPOCTools);
		manaStar = (ItemManaStar) new ItemManaStar().setTextureName("mdm_poc:mana_star").setCreativeTab(tabPOCItems);
		pocMaterials = (CustomItem) new CustomItem(new String[] { "magic_oak_stick", "willow_stick", "promethium_gem", "novite_gem", "kratonium_ingot" }, "mdm_poc").setCreativeTab(tabPOCItems);
		
		magicOakStick = new ItemStack(pocMaterials, 1, 0);
		willowStick = new ItemStack(pocMaterials, 1, 1);
		promethiumGem = new ItemStack(pocMaterials, 1, 2);
		noviteGem = new ItemStack(pocMaterials, 1, 3);
		kratoniumIngot = new ItemStack(pocMaterials, 1, 4);
		
		// -- Heaven --
		
		heavenMaterials = (ItemHeavenMaterials) new ItemHeavenMaterials(new String[] { "heaven_wood_stick", "gold_wood_stick", "heaven_arrow", "shrekite_shard", "clashium_ingot", "holyium_ingot", "energy_orb", "pro_ingot", "blurite_dust" }, "mdm_heaven").setCreativeTab(tabHeavenItems);
		
		heavenWoodStick = new ItemStack(heavenMaterials, 1, 0);
		goldWoodStick = new ItemStack(heavenMaterials, 1, 1);
		heavenArrow = new ItemStack(heavenMaterials, 1, 2);
		shrekiteShard = new ItemStack(heavenMaterials, 1, 3);
		clashiumIngot = new ItemStack(heavenMaterials, 1, 4);
		holyiumIngot = new ItemStack(heavenMaterials, 1, 5);
		energyOrb = new ItemStack(heavenMaterials, 1, 6);
		proAlloy = new ItemStack(heavenMaterials, 1, 7);
		bluriteDust = new ItemStack(heavenMaterials, 1, 8);
		
		heavenApple = (ItemFood) new ItemFood(2, 0, false).setTextureName("mdm_heaven:heaven_apple").setCreativeTab(tabHeavenItems);
		lifeHeart = (ItemLifeHeart) new ItemLifeHeart().setTextureName("mdm_heaven:life_heart").setCreativeTab(tabHeavenItems);
		fireSword = (ItemFireSword) new ItemFireSword().setTextureName("mdm_heaven:fire_sword").setCreativeTab(tabHeavenTools);
		icehammer = (ItemIceHammer) new ItemIceHammer().setTextureName("mdm_heaven:ice_hammer").setCreativeTab(tabHeavenTools);
		heavenSouls = (ItemHeavenSoul) new ItemHeavenSoul().setCreativeTab(tabHeavenItems);;
		capes = (ItemCape) new ItemCape().setUnlocalizedName("cape").setCreativeTab(tabHeavenArmor);
		
		String[] seeds = new String[] { "heaven_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" };
		heavenSeeds = (ItemHeavenSeeds) new ItemHeavenSeeds(seeds, CSString.concatAll(seeds, "mdm_heaven:", "_seeds"));
		iceStick = (ItemIceStick) new ItemIceStick().setTextureName("mdm_heaven:ice_stick").setCreativeTab(tabHeavenItems);
		
		heavenPortalActivator = (ItemHeavenPortalActivator) new ItemHeavenPortalActivator().setTextureName("mdm_heaven:heaven_portal_activator").setCreativeTab(tabHeavenTools);
		
		// -- Alchemy --
		
		alchemyGuide = (ItemAlchemyGuide) new ItemAlchemyGuide().setTextureName("mdm_main:alchemy_guide").setCreativeTab(MDMItems.tabAlchemy);
		elixir = (ItemElixir) new ItemElixir().setCreativeTab(tabAlchemy);
		elixirBottle = (ItemElixirBottle) new ItemElixirBottle().setCreativeTab(tabAlchemy);
		matter = (ItemMatter) new ItemMatter().setCreativeTab(tabAlchemy);
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		CSItems.addItem(manaStar, "mana_star");
		CSItems.addItem(pocMaterials, "poc_materials");
		
		// -- Heaven --
		
		CSItems.addItem(heavenMaterials, "heaven_materials");
		CSItems.addItem(heavenApple, "heaven_apple");
		CSItems.addItem(lifeHeart, "life_heart");
		CSItems.addItem(fireSword, "fire_sword");
		CSItems.addItem(icehammer, "ice_hammer");
		CSItems.addItem(capes, "cape");
		CSItems.addItem(heavenSeeds, "heaven_seeds");
		CSItems.addItem(iceStick, "ice_stick");
		CSItems.addItem(heavenPortalActivator, "heaven_portal_activator");
		
		// -- Alchemy --
		
		CSItems.addItem(alchemyGuide, "alchemy_guide");
		CSItems.addItem(elixir, "elixir");
		CSItems.addItem(elixirBottle, "elixir_bottle");
		CSItems.addItem(matter, "matter");
		
		// -- Creative Tab Icons --
		
		tabPOCBlocks.setIconItemStack(new ItemStack(MDMBlocks.pocGrassBlocks));
		tabPOCItems.setIconItemStack(new ItemStack(pocMaterials));
		
		tabAlchemy.setIconItemStack(new ItemStack(elixirBottle));
		
		tabHeavenBlocks.setIconItemStack(new ItemStack(MDMBlocks.heavenGrassBlocks));
		tabHeavenItems.setIconItemStack(shrekiteShard);
	}
}
