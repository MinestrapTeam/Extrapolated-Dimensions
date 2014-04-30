package clashsoft.mods.moredimensions.addons;

import static clashsoft.cslib.minecraft.crafting.CSCrafting.*;
import cpw.mods.fml.common.registry.GameRegistry;
import clashsoft.cslib.minecraft.block.*;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.cslib.minecraft.util.CSString;
import clashsoft.mods.moredimensions.block.heaven.*;
import clashsoft.mods.moredimensions.item.armor.ItemCape;
import clashsoft.mods.moredimensions.item.heaven.*;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Heaven
{
	public static CustomCreativeTab			tabHeavenBlocks	= new CustomCreativeTab("heaven_blocks");
	public static CustomCreativeTab			tabHeavenItems	= new CustomCreativeTab("heaven_items");
	public static CustomCreativeTab			tabHeavenTools	= new CustomCreativeTab("heaven_tools");
	public static CustomCreativeTab			tabHeavenArmor	= new CustomCreativeTab("heaven_armor");
	
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
	
	public static CustomBlock				heavenStoneBlocks;
	public static CustomBlock				heavenMetalBlocks;
	public static CustomBlock				heavenDirtBlocks;
	public static BlockHeavenGrass			heavenGrassBlocks;
	
	public static BlockCustomLog			heavenLogs;
	public static BlockCustomLeaves			heavenLeaves;
	public static BlockCustomSapling		heavenSaplings;
	public static CustomBlock				heavenPlanks;
	
	public static CustomBlock				heavenPlantBlocks;
	
	public static BlockCustomPortal			heavenPortal;
	public static BlockHeavenPillar			heavenPillar;
	
	public static BlockDamnationTable		damnationTable;
	
	public static ItemStack					heavenWoodStick, goldWoodStick, heavenArrow, shrekiteShard, clashiumIngot, holyiumIngot, energyOrb, proAlloy, bluriteDust;
	
	public static ItemStack					heavenDirt, mudDirt;
	public static ItemStack					heavenGrass, mudGrass, corruptedGrass, hallowedGrass, mushroomGrass;
	
	public static ItemStack					heavenWoodLog, goldWoodLog;
	public static ItemStack					heavenWoodLeaves, goldWoodLeaves;
	public static ItemStack					heavenWoodSapling, goldWoodSapling;
	public static ItemStack					heavenWoodPlanks, goldWoodPlanks;
	
	public static ItemStack					heavenGrassTall, mudGrassTall, corruptedGrassTall, hallowedGrassTall, mushroomGrassTall;
	public static ItemStack					heavenGrassVine, mudGrassVine, corruptedGrassVine, hallowedGrassVine, mushroomGrassVine, grassVine;
	
	public static ItemStack					heavenPortalFrame, heavenStone, heavenCobble, heavenCobbleMossy;
	public static ItemStack					shrekiteOre, clashiumOre, bluriteOre, holyiumOre;
	public static ItemStack					shrekiteBlock, clashiumBlock, bluriteBlock, holyiumBlock, proAlloyBlock;
	
	public static void init()
	{
		// Items
		
		heavenMaterials = (ItemHeavenMaterials) new ItemHeavenMaterials(new String[] { "heaven_wood_stick", "gold_wood_stick", "heaven_arrow", "shrekite_shard", "clashium_ingot", "holyium_ingot", "energy_orb", "pro_ingot", "blurite_dust" }, "mdm_heaven").setCreativeTab(tabHeavenItems);
		
		heavenApple = (ItemFood) new ItemFood(2, 0, false).setTextureName("mdm_heaven:heaven_apple").setCreativeTab(tabHeavenItems);
		lifeHeart = (ItemLifeHeart) new ItemLifeHeart().setTextureName("mdm_heaven:life_heart").setCreativeTab(tabHeavenItems);
		fireSword = (ItemFireSword) new ItemFireSword().setTextureName("mdm_heaven:fire_sword").setCreativeTab(tabHeavenTools);
		icehammer = (ItemIceHammer) new ItemIceHammer().setTextureName("mdm_heaven:ice_hammer").setCreativeTab(tabHeavenTools);
		heavenSouls = (ItemHeavenSoul) new ItemHeavenSoul().setCreativeTab(tabHeavenItems);;
		capes = (ItemCape) new ItemCape().setUnlocalizedName("cape").setCreativeTab(tabHeavenArmor);
		heavenPortalActivator = (ItemHeavenPortalActivator) new ItemHeavenPortalActivator().setTextureName("mdm_heaven:heaven_portal_activator").setCreativeTab(tabHeavenTools);
		
		String[] seeds = new String[] { "heaven_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" };
		heavenSeeds = (ItemHeavenSeeds) new ItemHeavenSeeds(seeds, CSString.concatAll(seeds, "mdm_heaven:", "_seeds"));
		iceStick = (ItemIceStick) new ItemIceStick().setTextureName("mdm_heaven:ice_stick").setCreativeTab(tabHeavenItems);
		
		// Blocks
		
		heavenStoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { "stone", "portal_frame", "cobble", "mossy", "shrekite_ore", "clashium_ore", "blurite_ore", "holyium_ore" }, new String[] { "mdm_heaven:heavenstone", "mdm_heaven:heaven_portal_frame", "mdm_heaven:heavenstone_cobble", "mdm_heaven:heavenstone_mossy", "mdm_heaven:shrekite_ore", "mdm_heaven:clashium_ore", "mdm_heaven:blurite_ore", "mdm_heaven:holyium_ore" }, null).setCreativeTab(tabHeavenBlocks).setStepSound(Block.soundTypeStone);
		heavenMetalBlocks = (CustomBlock) new CustomBlock(Material.iron, new String[] { "shrekite_block", "clashium_block", "blurite_block", "holyium_block", "pro_block" }, new String[] { "mdm_heaven:shrekite_block", "mdm_heaven:clashium_block", "mdm_heaven:blurite_block", "mdm_heaven:holyium_block", "mdm_heaven:pro_block" }, null).setCreativeTab(tabHeavenBlocks).setStepSound(Block.soundTypeMetal);
		
		heavenDirtBlocks = (CustomBlock) new CustomBlock(Material.ground, new String[] { "heaven_dirt", "mud" }, new String[] { "mdm_heaven:heaven_dirt", "mdm_heaven:mud" }, new CreativeTabs[] { tabHeavenBlocks }).setStepSound(Block.soundTypeGravel);
		
		heavenGrassBlocks = (BlockHeavenGrass) (new BlockHeavenGrass(new String[] { "heaven_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" }, new String[] { "mdm_heaven:heaven_grass_top", "mdm_heaven:mud_grass_top", "mdm_heaven:corrupted_grass_top", "mdm_heaven:hallowed_grass_top", "mdm_heaven:mushroom_grass_top" }, new String[] { "mdm_heaven:heaven_grass_side", "mdm_heaven:mud_grass_side", "mdm_heaven:corrupted_grass_side", "mdm_heaven:hallowed_grass_side", "mdm_heaven:mushroom_grass_side" }, new String[] { "mdm_heaven:heaven_dirt", "mdm_heaven:mud", "dirt", "dirt", "mdm_heaven:mud" })).setCreativeTab(tabHeavenBlocks);
		
		heavenLogs = (BlockCustomLog) (new BlockCustomLog(new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_log_top", "mdm_heaven:gold_wood_log_top" }, new String[] { "mdm_heaven:heaven_wood_log_side", "mdm_heaven:gold_wood_log_side" })).setCreativeTab(tabHeavenBlocks);
		
		heavenLeaves = (BlockCustomLeaves) (new BlockCustomLeaves(new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_leaves", "mdm_heaven:gold_wood_leaves" })).setCreativeTab(tabHeavenBlocks).setHardness(0.2F);
		
		heavenSaplings = (BlockHeavenSapling) (new BlockHeavenSapling(new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_sapling", "mdm_heaven:gold_wood_sapling" })).setCreativeTab(tabHeavenBlocks);
		
		heavenPlanks = (CustomBlock) new CustomBlock(Material.wood, new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_planks", "mdm_heaven:gold_wood_planks" }, new CreativeTabs[] { tabHeavenBlocks }).setStepSound(Block.soundTypeWood);
		
		String[] plants = new String[] { "heaven_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass", "heaven_vine", "mud_vine", "corrupted_vine", "hallowed_vine", "mushroom_vine", "grass_vine" };
		heavenPlantBlocks = (CustomBlock) new BlockHeavenPlant(plants, CSString.concatAll(plants, "mdm_heaven:plant_", null)).setCreativeTab(tabHeavenBlocks).setStepSound(Block.soundTypeGrass);
		
		heavenPortal = (BlockCustomPortal) new BlockHeavenPortal("heaven_portal", "mdm_heaven:heaven_portal").setCreativeTab(tabHeavenBlocks);
		heavenPillar = (BlockHeavenPillar) new BlockHeavenPillar().setCreativeTab(tabHeavenBlocks).setHardness(1.75F);
		damnationTable = (BlockDamnationTable) new BlockDamnationTable().setCreativeTab(tabHeavenBlocks).setHardness(4F);
		
		initStacks();
	}
	
	public static void initStacks()
	{
		// Item Stacks
		
		heavenWoodStick = new ItemStack(heavenMaterials, 1, 0);
		goldWoodStick = new ItemStack(heavenMaterials, 1, 1);
		heavenArrow = new ItemStack(heavenMaterials, 1, 2);
		shrekiteShard = new ItemStack(heavenMaterials, 1, 3);
		clashiumIngot = new ItemStack(heavenMaterials, 1, 4);
		holyiumIngot = new ItemStack(heavenMaterials, 1, 5);
		energyOrb = new ItemStack(heavenMaterials, 1, 6);
		proAlloy = new ItemStack(heavenMaterials, 1, 7);
		bluriteDust = new ItemStack(heavenMaterials, 1, 8);
		
		// Block Stacks
		
		heavenStone = new ItemStack(heavenStoneBlocks, 1, 0);
		heavenPortalFrame = new ItemStack(heavenStoneBlocks, 1, 1);
		heavenCobble = new ItemStack(heavenStoneBlocks, 1, 2);
		heavenCobbleMossy = new ItemStack(heavenStoneBlocks, 1, 3);
		shrekiteOre = new ItemStack(heavenStoneBlocks, 1, 4);
		clashiumOre = new ItemStack(heavenStoneBlocks, 1, 5);
		bluriteOre = new ItemStack(heavenStoneBlocks, 1, 6);
		holyiumOre = new ItemStack(heavenStoneBlocks, 1, 7);
		
		shrekiteBlock = new ItemStack(heavenStoneBlocks, 1, 0);
		clashiumBlock = new ItemStack(heavenMetalBlocks, 1, 1);
		bluriteBlock = new ItemStack(heavenMetalBlocks, 1, 2);
		holyiumBlock = new ItemStack(heavenMetalBlocks, 1, 3);
		proAlloyBlock = new ItemStack(heavenMetalBlocks, 1, 4);
		
		heavenDirt = new ItemStack(heavenDirtBlocks, 1, 0);
		mudDirt = new ItemStack(heavenDirtBlocks, 1, 1);
		
		heavenGrass = new ItemStack(heavenGrassBlocks, 1, 0);
		mudGrass = new ItemStack(heavenGrassBlocks, 1, 1);
		corruptedGrass = new ItemStack(heavenGrassBlocks, 1, 2);
		hallowedGrass = new ItemStack(heavenGrassBlocks, 1, 3);
		mushroomGrass = new ItemStack(heavenGrassBlocks, 1, 4);
		
		heavenWoodLog = new ItemStack(heavenLogs, 1, 0);
		goldWoodLog = new ItemStack(heavenLogs, 1, 1);
		
		heavenWoodLeaves = new ItemStack(heavenLeaves, 1, 0);
		goldWoodLeaves = new ItemStack(heavenLeaves, 1, 1);
		
		heavenWoodSapling = new ItemStack(heavenSaplings, 1, 0);
		goldWoodSapling = new ItemStack(heavenSaplings, 1, 1);
		
		heavenWoodPlanks = new ItemStack(heavenPlanks, 1, 0);
		goldWoodPlanks = new ItemStack(heavenPlanks, 1, 1);
		
		heavenGrassTall = new ItemStack(heavenPlantBlocks, 1, 0);
		mudGrassTall = new ItemStack(heavenPlantBlocks, 1, 1);
		corruptedGrassTall = new ItemStack(heavenPlantBlocks, 1, 2);
		hallowedGrassTall = new ItemStack(heavenPlantBlocks, 1, 3);
		mushroomGrassTall = new ItemStack(heavenPlantBlocks, 1, 4);
		heavenGrassVine = new ItemStack(heavenPlantBlocks, 1, 5);
		mudGrassVine = new ItemStack(heavenPlantBlocks, 1, 6);
		corruptedGrassVine = new ItemStack(heavenPlantBlocks, 1, 7);
		hallowedGrassVine = new ItemStack(heavenPlantBlocks, 1, 8);
		mushroomGrassVine = new ItemStack(heavenPlantBlocks, 1, 9);
		grassVine = new ItemStack(heavenPlantBlocks, 1, 10);
	}
	
	public static void load()
	{
		// Items
		
		CSItems.addItem(heavenMaterials, "heaven_materials");
		CSItems.addItem(heavenApple, "heaven_apple");
		CSItems.addItem(lifeHeart, "life_heart");
		CSItems.addItem(fireSword, "fire_sword");
		CSItems.addItem(icehammer, "ice_hammer");
		CSItems.addItem(capes, "cape");
		CSItems.addItem(heavenSeeds, "heaven_seeds");
		CSItems.addItem(iceStick, "ice_stick");
		CSItems.addItem(heavenPortalActivator, "heaven_portal_activator");
		
		// Blocks
		
		heavenStoneBlocks.setHardnesses(1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F);
		heavenStoneBlocks.setDrops(heavenCobble, null, null, shrekiteShard, null, bluriteDust, null, null, null, null, null);
		heavenDirtBlocks.setHardnesses(0.5F, 0.6F);
		heavenGrassBlocks.setHardnesses(0.6F, 0.65F, 0.7F, 0.7F, 0.65F);
		heavenGrassBlocks.setDirtBlocks(new Block[] { heavenDirtBlocks, heavenDirtBlocks, Blocks.dirt, Blocks.dirt, heavenDirtBlocks }, new int[] { 0, 1, 0, 0, 1 });
		
		heavenPlanks.setHardness(2.0F);
		heavenPlantBlocks.setHardnesses(0F, 0F, 0F, 0F);
		
		CSBlocks.addBlock(heavenStoneBlocks, "heaven_stone");
		CSBlocks.addBlock(heavenMetalBlocks, "heaven_metal");
		CSBlocks.addBlock(heavenDirtBlocks, "heaven_dirt");
		CSBlocks.addBlock(heavenGrassBlocks, "heaven_grass");
		
		CSBlocks.addBlock(heavenLogs, "heaven_logs");
		CSBlocks.addBlock(heavenLeaves, "heaven_leaves");
		CSBlocks.addBlock(heavenSaplings, "heaven_saplings");
		CSBlocks.addBlock(heavenPlanks, "heaven_planks");
		CSBlocks.addBlock(heavenPlantBlocks, "heaven_plants");
		
		CSBlocks.addBlock(heavenPortal, "heaven_portal");
		CSBlocks.addBlock(heavenPillar, "heaven_pillar");
		
		CSBlocks.addBlock(damnationTable, "damnation_table");
		GameRegistry.registerTileEntity(TileEntityDamnationTable.class, "DamnationTable");
		
		addRecipes();
		setTabIcons();
	}
	
	public static void addRecipes()
	{
		addPlanks(heavenWoodPlanks, heavenWoodLog);
		addPlanks(goldWoodPlanks, goldWoodLog);
		addStick(heavenWoodStick, heavenWoodPlanks);
		addStick(goldWoodStick, goldWoodPlanks);
		
		addFurnaceRecipe(clashiumOre, clashiumIngot, 0.2F);
		addFurnaceRecipe(holyiumOre, holyiumIngot, 2F);
		
		addStorageBlock(shrekiteShard, shrekiteBlock, 3);
		addStorageBlock(clashiumIngot, clashiumBlock, 3);
		addStorageBlock(holyiumIngot, holyiumBlock, 3);
		addStorageBlock(bluriteDust, bluriteBlock, 3);
		addStorageBlock(proAlloy, proAlloyBlock, 3);
		
		addShapelessRecipe(shrekiteShard, shrekiteBlock);
		addShapelessRecipe(clashiumIngot, clashiumBlock);
		addShapelessRecipe(holyiumIngot, holyiumBlock);
		addShapelessRecipe(bluriteDust, bluriteBlock);
		addShapelessRecipe(proAlloy, proAlloyBlock);
	}
	
	public static void setTabIcons()
	{
		tabHeavenItems.setIconItemStack(shrekiteShard);
		tabHeavenBlocks.setIconItemStack(heavenGrass);
	}
}
