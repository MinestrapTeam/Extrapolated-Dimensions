package clashsoft.mods.moredimensions.lib;

import static clashsoft.cslib.minecraft.crafting.CSCrafting.*;
import clashsoft.cslib.minecraft.block.*;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.util.CSString;
import clashsoft.mods.moredimensions.block.heaven.*;
import clashsoft.mods.moredimensions.item.armor.ItemCape;
import clashsoft.mods.moredimensions.item.heaven.*;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;
import cpw.mods.fml.common.registry.GameRegistry;

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
	
	// Items
	
	public static ItemHeavenMaterials		items;
	public static ItemFood					heavenApple;
	public static ItemLifeHeart				lifeHeart;
	public static ItemFireSword				fireSword;
	public static ItemIceHammer				iceHammer;
	public static ItemHeavenSoul			soul;
	public static ItemHeavenPortalActivator	heavenPortalActivator;
	public static ItemCape					capes;
	public static ItemHeavenSeeds			heavenSeeds;
	public static ItemIceStick				iceStick;
	
	// Blocks
	
	public static CustomBlock				stoneBlocks;
	public static CustomBlock				metalBlocks;
	public static CustomBlock				dirtBlocks;
	public static BlockHeavenGrass			grassBlocks;
	public static BlockCustomLog			logBlocks;
	public static BlockCustomLeaves			leafBlocks;
	public static BlockCustomSapling		saplingBlocks;
	public static CustomBlock				plankBlocks;
	public static CustomBlock				plantBlocks;
	
	public static BlockCustomPortal			portal;
	public static Block portalFrame;
	public static BlockHeavenPillar			pillar;
	
	public static BlockDamnationTable		damnationTable;
	
	// Item Stacks
	
	public static ItemStack					heavenWoodStick, goldWoodStick, heavenArrow, shrekiteShard, clashiumIngot, holyiumIngot, energyOrb, proAlloy, bluriteDust;
	
	public static ItemStack					heavenDirt, mudDirt, ashDirt;
	public static ItemStack					heavenGrass, mudGrass, corruptedGrass, hallowedGrass, mushroomGrass;
	
	public static ItemStack					heavenWoodLog, goldWoodLog;
	public static ItemStack					heavenWoodLeaves, goldWoodLeaves;
	public static ItemStack					heavenWoodSapling, goldWoodSapling;
	public static ItemStack					heavenWoodPlanks, goldWoodPlanks;
	
	public static ItemStack					heavenGrassTall, mudGrassTall, corruptedGrassTall, hallowedGrassTall, mushroomGrassTall;
	public static ItemStack					heavenGrassVine, mudGrassVine, corruptedGrassVine, hallowedGrassVine, mushroomGrassVine, grassVine;
	
	public static ItemStack					heavenStone, heavenCobble, heavenCobbleMossy;
	public static ItemStack					shrekiteOre, clashiumOre, bluriteOre, holyiumOre;
	public static ItemStack					shrekiteBlock, clashiumBlock, bluriteBlock, holyiumBlock, proAlloyBlock;
	
	public static void init()
	{
		// Items
		
		items = (ItemHeavenMaterials) new ItemHeavenMaterials(new String[] { "heaven_wood_stick", "gold_wood_stick", "heaven_arrow", "shrekite_shard", "clashium_ingot", "holyium_ingot", "energy_orb", "pro_ingot", "blurite_dust" }, "mdm_heaven").setCreativeTab(tabHeavenItems);
		
		heavenApple = (ItemFood) new ItemFood(2, 0, false).setTextureName("mdm_heaven:heaven_apple").setCreativeTab(tabHeavenItems);
		lifeHeart = (ItemLifeHeart) new ItemLifeHeart().setTextureName("mdm_heaven:life_heart").setCreativeTab(tabHeavenItems);
		fireSword = (ItemFireSword) new ItemFireSword().setTextureName("mdm_heaven:fire_sword").setCreativeTab(tabHeavenTools);
		iceHammer = (ItemIceHammer) new ItemIceHammer().setTextureName("mdm_heaven:ice_hammer").setCreativeTab(tabHeavenTools);
		soul = (ItemHeavenSoul) new ItemHeavenSoul().setCreativeTab(tabHeavenItems);
		capes = (ItemCape) new ItemCape().setUnlocalizedName("cape").setCreativeTab(tabHeavenArmor);
		heavenPortalActivator = (ItemHeavenPortalActivator) new ItemHeavenPortalActivator().setTextureName("mdm_heaven:heaven_portal_activator").setCreativeTab(tabHeavenTools);
		
		String[] seeds = new String[] { "heaven_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" };
		heavenSeeds = new ItemHeavenSeeds(seeds, CSString.concatAll(seeds, "mdm_heaven:", "_seeds"));
		iceStick = (ItemIceStick) new ItemIceStick().setTextureName("mdm_heaven:ice_stick").setCreativeTab(tabHeavenItems);
		
		// Blocks

		portal = (BlockCustomPortal) new BlockHeavenPortal("heaven_portal", "mdm_heaven:heaven_portal").setCreativeTab(tabHeavenBlocks);
		portalFrame = new BlockImpl(Material.rock, "heaven_portal_frame", "mdm_heaven:heaven_portal_frame").setCreativeTab(tabHeavenBlocks).setHardness(2.2F);
		
		stoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { "stone", "cobble", "mossy", "shrekite_ore", "clashium_ore", "blurite_ore", "holyium_ore" }, new String[] { "mdm_heaven:heavenstone", "mdm_heaven:heavenstone_cobble", "mdm_heaven:heavenstone_mossy", "mdm_heaven:shrekite_ore", "mdm_heaven:clashium_ore", "mdm_heaven:blurite_ore", "mdm_heaven:holyium_ore" }, null).setCreativeTab(tabHeavenBlocks).setStepSound(Block.soundTypeStone);
		metalBlocks = (CustomBlock) new CustomBlock(Material.iron, new String[] { "shrekite_block", "clashium_block", "blurite_block", "holyium_block", "pro_block" }, new String[] { "mdm_heaven:shrekite_block", "mdm_heaven:clashium_block", "mdm_heaven:blurite_block", "mdm_heaven:holyium_block", "mdm_heaven:pro_block" }, null).setCreativeTab(tabHeavenBlocks).setStepSound(Block.soundTypeMetal);
		
		dirtBlocks = (CustomBlock) new CustomBlock(Material.ground, new String[] { "heaven_dirt", "mud", "ashes" }, new String[] { "mdm_heaven:heaven_dirt", "mdm_heaven:mud", "mdm_heaven:ashes" }, new CreativeTabs[] { tabHeavenBlocks }).setStepSound(Block.soundTypeGravel);
		
		grassBlocks = (BlockHeavenGrass) (new BlockHeavenGrass(new String[] { "heaven_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" }, new String[] { "mdm_heaven:heaven_grass_top", "mdm_heaven:mud_grass_top", "mdm_heaven:corrupted_grass_top", "mdm_heaven:hallowed_grass_top", "mdm_heaven:mushroom_grass_top" }, new String[] { "mdm_heaven:heaven_grass_side", "mdm_heaven:mud_grass_side", "mdm_heaven:corrupted_grass_side", "mdm_heaven:hallowed_grass_side", "mdm_heaven:mushroom_grass_side" }, new String[] { "mdm_heaven:heaven_dirt", "mdm_heaven:mud", "dirt", "dirt", "mdm_heaven:mud" })).setCreativeTab(tabHeavenBlocks);
		
		logBlocks = (BlockCustomLog) (new BlockCustomLog(new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_log_top", "mdm_heaven:gold_wood_log_top" }, new String[] { "mdm_heaven:heaven_wood_log_side", "mdm_heaven:gold_wood_log_side" })).setCreativeTab(tabHeavenBlocks);
		
		leafBlocks = (BlockCustomLeaves) (new BlockCustomLeaves(new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_leaves", "mdm_heaven:gold_wood_leaves" })).setCreativeTab(tabHeavenBlocks).setHardness(0.2F);
		
		saplingBlocks = (BlockHeavenSapling) (new BlockHeavenSapling(new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_sapling", "mdm_heaven:gold_wood_sapling" })).setCreativeTab(tabHeavenBlocks);
		
		plankBlocks = (CustomBlock) new CustomBlock(Material.wood, new String[] { "heaven_wood", "gold_wood" }, new String[] { "mdm_heaven:heaven_wood_planks", "mdm_heaven:gold_wood_planks" }, new CreativeTabs[] { tabHeavenBlocks }).setStepSound(Block.soundTypeWood);
		
		String[] plants = new String[] { "heaven_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass", "heaven_vine", "mud_vine", "corrupted_vine", "hallowed_vine", "mushroom_vine", "grass_vine" };
		plantBlocks = (CustomBlock) new BlockHeavenPlant(plants, CSString.concatAll(plants, "mdm_heaven:plant_", null)).setCreativeTab(tabHeavenBlocks).setStepSound(Block.soundTypeGrass);
		
		pillar = (BlockHeavenPillar) new BlockHeavenPillar().setCreativeTab(tabHeavenBlocks).setHardness(1.75F);
		damnationTable = (BlockDamnationTable) new BlockDamnationTable().setCreativeTab(tabHeavenBlocks).setHardness(4F);
		
		initStacks();
	}
	
	public static void initStacks()
	{
		// Item Stacks
		
		heavenWoodStick = new ItemStack(items, 1, 0);
		goldWoodStick = new ItemStack(items, 1, 1);
		heavenArrow = new ItemStack(items, 1, 2);
		shrekiteShard = new ItemStack(items, 1, 3);
		clashiumIngot = new ItemStack(items, 1, 4);
		holyiumIngot = new ItemStack(items, 1, 5);
		energyOrb = new ItemStack(items, 1, 6);
		proAlloy = new ItemStack(items, 1, 7);
		bluriteDust = new ItemStack(items, 1, 8);
		
		// Block Stacks
		
		heavenStone = new ItemStack(stoneBlocks, 1, 0);
		heavenCobble = new ItemStack(stoneBlocks, 1, 1);
		heavenCobbleMossy = new ItemStack(stoneBlocks, 1, 2);
		shrekiteOre = new ItemStack(stoneBlocks, 1, 3);
		clashiumOre = new ItemStack(stoneBlocks, 1, 4);
		bluriteOre = new ItemStack(stoneBlocks, 1, 5);
		holyiumOre = new ItemStack(stoneBlocks, 1, 6);
		
		shrekiteBlock = new ItemStack(stoneBlocks, 1, 0);
		clashiumBlock = new ItemStack(metalBlocks, 1, 1);
		bluriteBlock = new ItemStack(metalBlocks, 1, 2);
		holyiumBlock = new ItemStack(metalBlocks, 1, 3);
		proAlloyBlock = new ItemStack(metalBlocks, 1, 4);
		
		heavenDirt = new ItemStack(dirtBlocks, 1, 0);
		mudDirt = new ItemStack(dirtBlocks, 1, 1);
		ashDirt = new ItemStack(dirtBlocks, 1, 2);
		
		heavenGrass = new ItemStack(grassBlocks, 1, 0);
		mudGrass = new ItemStack(grassBlocks, 1, 1);
		corruptedGrass = new ItemStack(grassBlocks, 1, 2);
		hallowedGrass = new ItemStack(grassBlocks, 1, 3);
		mushroomGrass = new ItemStack(grassBlocks, 1, 4);
		
		heavenWoodLog = new ItemStack(logBlocks, 1, 0);
		goldWoodLog = new ItemStack(logBlocks, 1, 1);
		
		heavenWoodLeaves = new ItemStack(leafBlocks, 1, 0);
		goldWoodLeaves = new ItemStack(leafBlocks, 1, 1);
		
		heavenWoodSapling = new ItemStack(saplingBlocks, 1, 0);
		goldWoodSapling = new ItemStack(saplingBlocks, 1, 1);
		
		heavenWoodPlanks = new ItemStack(plankBlocks, 1, 0);
		goldWoodPlanks = new ItemStack(plankBlocks, 1, 1);
		
		heavenGrassTall = new ItemStack(plantBlocks, 1, 0);
		mudGrassTall = new ItemStack(plantBlocks, 1, 1);
		corruptedGrassTall = new ItemStack(plantBlocks, 1, 2);
		hallowedGrassTall = new ItemStack(plantBlocks, 1, 3);
		mushroomGrassTall = new ItemStack(plantBlocks, 1, 4);
		heavenGrassVine = new ItemStack(plantBlocks, 1, 5);
		mudGrassVine = new ItemStack(plantBlocks, 1, 6);
		corruptedGrassVine = new ItemStack(plantBlocks, 1, 7);
		hallowedGrassVine = new ItemStack(plantBlocks, 1, 8);
		mushroomGrassVine = new ItemStack(plantBlocks, 1, 9);
		grassVine = new ItemStack(plantBlocks, 1, 10);
	}
	
	public static void load()
	{
		// Items
		
		CSItems.addItem(items, "heaven_materials");
		CSItems.addItem(heavenApple, "heaven_apple");
		CSItems.addItem(lifeHeart, "life_heart");
		CSItems.addItem(fireSword, "fire_sword");
		CSItems.addItem(iceHammer, "ice_hammer");
		CSItems.addItem(capes, "cape");
		CSItems.addItem(heavenSeeds, "heaven_seeds");
		CSItems.addItem(iceStick, "ice_stick");
		CSItems.addItem(heavenPortalActivator, "heaven_portal_activator");
		
		// Blocks
		
		stoneBlocks.setHardnesses(1.5F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F);
		stoneBlocks.setDrops(heavenCobble, null, shrekiteShard, null, bluriteDust, null, null, null, null, null);
		dirtBlocks.setHardnesses(0.5F, 0.6F, 0.5F);
		grassBlocks.setHardnesses(0.6F, 0.65F, 0.7F, 0.7F, 0.65F);
		grassBlocks.setDirtBlocks(new Block[] { dirtBlocks, dirtBlocks, Blocks.dirt, Blocks.dirt, dirtBlocks }, new int[] { 0, 1, 0, 0, 1 });
		
		plankBlocks.setHardness(2.0F);
		plantBlocks.setHardnesses(0F, 0F, 0F, 0F);
		
		CSBlocks.addBlock(portal, "heaven_portal");
		CSBlocks.addBlock(portalFrame, "heaven_portal_frame");
		
		CSBlocks.addBlock(stoneBlocks, "heaven_stone");
		CSBlocks.addBlock(metalBlocks, "heaven_metal");
		CSBlocks.addBlock(dirtBlocks, "heaven_dirt");
		CSBlocks.addBlock(grassBlocks, "heaven_grass");
		CSBlocks.addBlock(logBlocks, "heaven_logs");
		CSBlocks.addBlock(leafBlocks, "heaven_leaves");
		CSBlocks.addBlock(saplingBlocks, "heaven_saplings");
		CSBlocks.addBlock(plankBlocks, "heaven_planks");
		CSBlocks.addBlock(plantBlocks, "heaven_plants");
		
		CSBlocks.addBlock(pillar, "heaven_pillar");
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
