package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.minecraft.addon.Addon;
import clashsoft.cslib.minecraft.block.*;
import clashsoft.cslib.minecraft.util.CSString;
import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.block.alchemy.BlockAlchemyTable;
import clashsoft.mods.moredimensions.block.alchemy.BlockAlchemyTube;
import clashsoft.mods.moredimensions.block.heaven.*;
import clashsoft.mods.moredimensions.block.poc.BlockPOCPortal;
import clashsoft.mods.moredimensions.block.poc.BlockPOCSapling;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

@Addon(modName = MoreDimensionsMod.NAME, addonName = "Blocks")
public class MDMBlocks
{
	// -- Paradise of Chaos Blocks --
	
	public static CustomBlock			pocStoneBlocks;
	public static CustomBlock			pocDirtBlocks;
	public static BlockCustomGrass		pocGrassBlocks;
	
	public static CustomBlock			pocOres;
	
	public static BlockCustomLog		pocLogs;
	public static BlockCustomSapling	pocSaplings;
	public static BlockCustomLeaves		pocLeaves;
	public static CustomBlock			pocPlanks;
	
	public static BlockCustomPlant		pocPlantBlocks;
	
	public static BlockCustomPortal		pocPortal;
	// public static BlockPOCActivatorLava activatorLava;
	// public static BlockPOCDreamBed dreamBed;
	
	public static ItemStack				chaosStone, pocPortalFrame;
	
	public static ItemStack				magicOakLog, willowLog;
	public static ItemStack				magicOakLeaves, willowLeaves;
	public static ItemStack				magicOakSapling, willowSapling;
	public static ItemStack				magicOakPlanks, willowPlanks;
	
	// -- Heaven Blocks --
	
	public static CustomBlock			heavenStoneBlocks;
	public static CustomBlock			heavenDirtBlocks;
	public static BlockHeavenGrass		heavenGrassBlocks;
	
	public static BlockCustomLog		heavenLogs;
	public static BlockCustomLeaves		heavenLeaves;
	public static BlockCustomSapling	heavenSaplings;
	public static CustomBlock			heavenPlanks;
	
	public static CustomBlock			heavenPlantBlocks;
	
	public static BlockCustomPortal		heavenPortal;
	public static BlockHeavenPillar		heavenPillar;
	
	public static BlockDamnationTable	damnationTable;
	
	public static ItemStack				heavenDirt, mudDirt;
	public static ItemStack				heavenGrass, mudGrass, corruptedGrass, hallowedGrass,
			mushroomGrass;
	
	public static ItemStack				heavenWoodLog, goldWoodLog;
	public static ItemStack				heavenWoodLeaves, goldWoodLeaves;
	public static ItemStack				heavenWoodSapling, goldWoodSapling;
	public static ItemStack				heavenWoodPlanks, goldWoodPlanks;
	
	public static ItemStack				heavenGrassTall, mudGrassTall, corruptedGrassTall,
			hallowedGrassTall, mushroomGrassTall;
	public static ItemStack				heavenGrassVine, mudGrassVine, corruptedGrassVine,
			hallowedGrassVine, mushroomGrassVine, grassVine;
	
	public static ItemStack				heavenPortalFrame, heavenStone, heavenCobble,
			heavenCobbleMossy;
	public static ItemStack				shrekiteOre, clashiumOre, bluriteOre, holyiumOre;
	public static ItemStack				shrekiteBlock, clashiumBlock, bluriteBlock, holyiumBlock,
			proAlloyBlock;
	
	// -- Alchemy --
	
	public static BlockAlchemyTube		alchemyTube;
	public static BlockAlchemyTable		alchemyTable;
	
	public static void initialize()
	{
		// -- Paradise of Chaos Blocks --
		
		pocStoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { "chaos_stone",
				"portal_frame" }, new String[] { "mdm_poc:chaos_stone",
				"mdm_poc:poc_portal_frame" }, null).setCreativeTab(MDMItems.tabPOCBlocks);
		pocDirtBlocks = (CustomBlock) new CustomBlock(Material.ground, "altered_dirt",
				"mdm_poc:altered_dirt", MDMItems.tabPOCBlocks)
				.setStepSound(Block.soundTypeGravel);
		pocGrassBlocks = (BlockCustomGrass) new BlockCustomGrass("altered_grass",
				"mdm_poc:altered_grass_top", "mdm_poc:altered_grass_side",
				"mdm_poc:altered_grass_bottom").setCreativeTab(MDMItems.tabPOCBlocks);
		
		String[] ores1 = new String[] { "copper", "tin", "silver", "mithril", "adamanite",
				"daeyalt", "rubium", "novite", "kratonium", "fractite", "promethium" };
		
		pocOres = (CustomBlock) new CustomBlock(Material.rock, ores1, CSString.concatAll(ores1,
				"mdm_poc:", "_ore"), null).setCreativeTab(MDMItems.tabPOCBlocks);
		
		pocLogs = (BlockCustomLog) new BlockCustomLog(
				new String[] { "magic_oak", "willow" },
				new String[] { "mdm_poc:magic_oak_log_top", "mdm_poc:willow_log_top" },
				new String[] { "mdm_poc:magic_oak_log_side",
						"mdm_poc:willow_log_side" }).setCreativeTab(MDMItems.tabPOCBlocks);
		
		magicOakLog = new ItemStack(pocLogs, 1, 0);
		willowLog = new ItemStack(pocLogs, 1, 1);
		
		pocLeaves = (BlockCustomLeaves) new BlockCustomLeaves(
				new String[] { "magic_oak", "willow" }, new String[] {
						"mdm_poc:magicoak_leaves", "mdm_poc:willow_leaves" })
				.setCreativeTab(MDMItems.tabPOCBlocks);
		
		magicOakLeaves = new ItemStack(pocLeaves, 1, 0);
		willowLeaves = new ItemStack(pocLeaves, 1, 1);
		
		pocSaplings = (BlockPOCSapling) new BlockPOCSapling(
				new String[] { "magic_oak", "willow" },
				new String[] { "mdm_poc:magic_oak_sapling", "mdm_poc:willow_sapling" })
				.setCreativeTab(MDMItems.tabPOCBlocks);
		
		magicOakSapling = new ItemStack(pocSaplings, 1, 0);
		willowSapling = new ItemStack(pocSaplings, 1, 1);
		
		pocPlanks = (CustomBlock) new CustomBlock(Material.wood, new String[] { "magic_oak",
				"willow" }, new String[] { "mdm_poc:magic_oak_planks",
				"mdm_poc:willow_planks" }, null).setCreativeTab(MDMItems.tabPOCBlocks)
				.setStepSound(Block.soundTypeWood);
		
		magicOakPlanks = new ItemStack(pocPlanks, 1, 0);
		willowPlanks = new ItemStack(pocPlanks, 1, 1);
		
		pocPlantBlocks = (BlockCustomPlant) new BlockCustomPlant(new String[] { "saf_flower" },
				new String[] { "mdm_poc:saf_flower" }).setCreativeTab(MDMItems.tabPOCBlocks);
		
		pocPortal = (BlockCustomPortal) new BlockPOCPortal("poc_portal",
				"mdm_poc:poc_portal").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(-1F);
		
		// Block.blocksList[Block.lavaStill.blockID] = null;
		// activatorLava = (BlockPOCActivatorLava) new
		// BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		//
		// Block.blocksList[Block.bed.blockID] = null;
		// dreamBed = (BlockPOCDreamBed) new
		// BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		// -- Heaven Blocks --
		
		heavenStoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { "stone",
				"portal_frame", "cobble", "mossy", "shrekite_ore", "clashium_ore", "blurite_ore",
				"holyium_ore", "shrekite_block", "clashium_block", "blurite_block",
				"holyium_block", "pro_block" }, new String[] { "mdm_heaven:heavenstone",
				"mdm_heaven:heaven_portal_frame", "mdm_heaven:heavenstone_cobble",
				"mdm_heaven:heavenstone_mossy", "mdm_heaven:shrekite_ore",
				"mdm_heaven:clashium_ore", "mdm_heaven:blurite_ore",
				"mdm_heaven:holyium_ore", "mdm_heaven:shrekite_block",
				"mdm_heaven:clashium_block", "mdm_heaven:blurite_block",
				"mdm_heaven:holyium_block", "mdm_heaven:pro_block" },
				new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundTypeStone);
		
		heavenStone = new ItemStack(heavenStoneBlocks, 1, 0);
		heavenPortalFrame = new ItemStack(heavenStoneBlocks, 1, 1);
		heavenCobble = new ItemStack(heavenStoneBlocks, 1, 2);
		heavenCobbleMossy = new ItemStack(heavenStoneBlocks, 1, 3);
		shrekiteOre = new ItemStack(heavenStoneBlocks, 1, 4);
		clashiumOre = new ItemStack(heavenStoneBlocks, 1, 5);
		bluriteOre = new ItemStack(heavenStoneBlocks, 1, 6);
		holyiumOre = new ItemStack(heavenStoneBlocks, 1, 7);
		shrekiteBlock = new ItemStack(heavenStoneBlocks, 1, 10);
		clashiumBlock = new ItemStack(heavenStoneBlocks, 1, 11);
		bluriteBlock = new ItemStack(heavenStoneBlocks, 1, 12);
		holyiumBlock = new ItemStack(heavenStoneBlocks, 1, 13);
		proAlloyBlock = new ItemStack(heavenStoneBlocks, 1, 14);
		
		heavenDirtBlocks = (CustomBlock) new CustomBlock(Material.ground, new String[] { "dirt",
				"mud" }, new String[] { "mdm_heaven:heaven_dirt", "mdm_heaven:mud" },
				new CreativeTabs[] { MDMItems.tabHeavenBlocks })
				.setStepSound(Block.soundTypeGravel);
		
		heavenDirt = new ItemStack(heavenDirtBlocks, 1, 0);
		mudDirt = new ItemStack(heavenDirtBlocks, 1, 1);
		
		heavenGrassBlocks = (BlockHeavenGrass) (new BlockHeavenGrass(new String[] { "grass",
				"mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" }, new String[] {
				"mdm_heaven:heaven_grass_top", "mdm_heaven:mud_grass_top",
				"mdm_heaven:corrupted_grass_top", "mdm_heaven:hallowed_grass_top",
				"mdm_heaven:mushroom_grass_top" }, new String[] {
				"mdm_heaven:heaven_grass_side", "mdm_heaven:mud_grass_side",
				"mdm_heaven:corrupted_grass_side", "mdm_heaven:hallowed_grass_side",
				"mdm_heaven:mushroom_grass_side" }, new String[] {
				"mdm_heaven:heaven_dirt", "mdm_heaven:mud", "dirt", "dirt",
				"mdm_heaven:mud" })).setCreativeTab(MDMItems.tabHeavenBlocks);
		
		heavenGrass = new ItemStack(heavenGrassBlocks, 1, 0);
		mudGrass = new ItemStack(heavenGrassBlocks, 1, 1);
		corruptedGrass = new ItemStack(heavenGrassBlocks, 1, 2);
		hallowedGrass = new ItemStack(heavenGrassBlocks, 1, 3);
		mushroomGrass = new ItemStack(heavenGrassBlocks, 1, 4);
		
		heavenLogs = (BlockCustomLog) (new BlockCustomLog(
				new String[] { "heaven_wood", "gold_wood" }, new String[] {
						"mdm_heaven:heaven_wood_log_top", "mdm_heaven:gold_wood_log_top" },
				new String[] { "mdm_heaven:heaven_wood_log_side", "mdm_heaven:gold_wood_log_side" }))
				.setCreativeTab(MDMItems.tabHeavenBlocks);
		
		heavenWoodLog = new ItemStack(heavenLogs, 1, 0);
		goldWoodLog = new ItemStack(heavenLogs, 1, 1);
		
		heavenLeaves = (BlockCustomLeaves) (new BlockCustomLeaves(new String[] { "heaven_wood",
				"gold_wood" }, new String[] { "mdm_heaven:heaven_wood_leaves",
				"mdm_heaven:gold_wood_leaves" })).setCreativeTab(MDMItems.tabHeavenBlocks)
				.setHardness(0.2F);
		
		heavenWoodLeaves = new ItemStack(heavenLeaves, 1, 0);
		goldWoodLeaves = new ItemStack(heavenLeaves, 1, 1);
		
		heavenSaplings = (BlockHeavenSapling) (new BlockHeavenSapling(new String[] { "heaven_wood",
				"gold_wood" }, new String[] { "mdm_heaven:heaven_wood_sapling",
				"mdm_heaven:gold_wood_sapling" })).setCreativeTab(MDMItems.tabHeavenBlocks);
		
		heavenWoodSapling = new ItemStack(heavenSaplings, 1, 0);
		goldWoodSapling = new ItemStack(heavenSaplings, 1, 1);
		
		heavenPlanks = (CustomBlock) new CustomBlock(Material.wood, new String[] { "heaven_wood",
				"gold_wood" }, new String[] { "mdm_heaven:heaven_wood_planks",
				"mdm_heaven:gold_wood_planks" },
				new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundTypeWood);
		
		heavenWoodPlanks = new ItemStack(heavenPlanks, 1, 0);
		goldWoodPlanks = new ItemStack(heavenPlanks, 1, 1);
		
		String[] plants = new String[] { "heaven_grass", "mud_grass", "corrupted_grass",
				"hallowed_grass", "mushroom_grass", "heaven_vine", "mud_vine", "corrupted_vine",
				"hallowed_vine", "mushroom_vine", "grass_vine" };
		heavenPlantBlocks = (CustomBlock) new BlockHeavenPlant(plants, CSString.concatAll(plants,
				"mdm_heaven:plant_", null)).setCreativeTab(MDMItems.tabHeavenBlocks)
				.setStepSound(Block.soundTypeGrass);
		
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
		
		heavenPortal = (BlockCustomPortal) new BlockHeavenPortal("heaven_portal",
				"mdm_heaven:heaven_portal").setCreativeTab(MDMItems.tabHeavenBlocks);
		
		heavenPillar = (BlockHeavenPillar) new BlockHeavenPillar().setCreativeTab(
				MDMItems.tabHeavenBlocks).setHardness(1.75F);
		
		damnationTable = (BlockDamnationTable) new BlockDamnationTable().setCreativeTab(
				MDMItems.tabHeavenBlocks).setHardness(4F);
		
		// -- Alchemy Blocks --
		
		alchemyTube = (BlockAlchemyTube) new BlockAlchemyTube().setBlockTextureName(
				"mdm_main:alchemy_tube").setCreativeTab(MDMItems.tabAlchemy);
		alchemyTable = (BlockAlchemyTable) new BlockAlchemyTable()
				.setCreativeTab(MDMItems.tabAlchemy);
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		pocStoneBlocks.setHardness(2.2F);
		pocDirtBlocks.setHardness(0.5F);
		pocGrassBlocks.setDirtBlock(0, pocDirtBlocks, 0);
		
		CSBlocks.addBlock(pocStoneBlocks, "poc_stone");
		CSBlocks.addBlock(pocDirtBlocks, "poc_dirt");
		CSBlocks.addBlock(pocGrassBlocks, "poc_grass");
		
		CSBlocks.addBlock(pocOres, "poc_ores");
		
		CSBlocks.addBlock(pocLogs, "poc_logs");
		CSBlocks.addBlock(pocLeaves, "poc_leaves");
		CSBlocks.addBlock(pocSaplings, "poc_saplings");
		CSBlocks.addBlock(pocPlanks, "poc_planks");
		CSBlocks.addBlock(pocPlantBlocks, "poc_plants");
		
		CSBlocks.addBlock(pocPortal, "poc_portal");
		
		// -- Heaven --
		
		heavenStoneBlocks.setHardnesses(1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F,
				3F);
		heavenStoneBlocks.setDrops(heavenCobble, null, null, MDMItems.shrekiteShard, null,
				MDMItems.bluriteDust, null, null, null, null, null);
		heavenDirtBlocks.setHardnesses(0.5F, 0.6F);
		heavenGrassBlocks.setHardnesses(0.6F, 0.65F, 0.7F, 0.7F, 0.65F);
		heavenGrassBlocks.setDirtBlocks(new Block[] { heavenDirtBlocks, heavenDirtBlocks,
				Blocks.dirt, Blocks.dirt, heavenDirtBlocks }, new int[] { 0, 1, 0, 0, 1 });
		
		heavenPlanks.setHardness(2.0F);
		heavenPlantBlocks.setHardnesses(0F, 0F, 0F, 0F);
		
		CSBlocks.addBlock(heavenStoneBlocks, "heaven_stone");
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
		
		// -- Alchemy --
		
		CSBlocks.addBlock(alchemyTube, "alchemy_tube");
		CSBlocks.addBlock(alchemyTable, "alchemy_table");
	}
}
