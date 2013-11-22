package clashsoft.mods.moredimensions.addons;

import static clashsoft.cslib.minecraft.util.CSBlocks.addBlock;
import clashsoft.cslib.addon.Addon;
import clashsoft.cslib.minecraft.CustomBlock;
import clashsoft.cslib.minecraft.block.BlockCustomGrass;
import clashsoft.cslib.minecraft.block.BlockCustomLeaves;
import clashsoft.cslib.minecraft.block.BlockCustomLog;
import clashsoft.cslib.minecraft.block.BlockCustomSapling;
import clashsoft.mods.moredimensions.block.BlockMDM;
import clashsoft.mods.moredimensions.block.heaven.*;
import clashsoft.mods.moredimensions.block.poc.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

@Addon(modName = "MoreDimensionsMod", addonName = "Blocks")
public class MDMBlocks
{
	// -- Paradise of Chaos Blocks --
	
	public static CustomBlock			pocStoneBlocks;
	public static CustomBlock			pocDirtBlocks;
	public static BlockCustomGrass		pocGrassBlocks;
	
	public static CustomBlock			pocOres1;
	public static CustomBlock			pocOres2;
	
	public static BlockCustomLog		pocLogs;
	public static BlockCustomSapling	pocSaplings;
	public static BlockCustomLeaves		pocLeaves;
	public static CustomBlock			pocPlanks;
	
	public static BlockPOCHerb			pocPlantBlocks;
	
	public static BlockPOCPortal		pocPortal;
	public static Block					pocPortalFrame;
	public static BlockPOCActivatorLava	activatorLava;
	public static BlockPOCDreamBed		dreamBed;
	
	public static BlockAlchemyTube		alchemyTube;
	
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
	
	public static BlockHeavenPortal		heavenPortal;
	public static Block					heavenPortalFrame;
	public static BlockHeavenPillar		heavenPillar;
	
	public static ItemStack				heavenDirt, mudDirt;
	public static ItemStack				heavenGrass, mudGrass, corruptedGrass, hallowedGrass, mushroomGrass;
	
	public static ItemStack				heavenWoodLog, goldWoodLog;
	public static ItemStack				heavenWoodLeaves, goldWoodLeaves;
	public static ItemStack				heavenWoodSapling, goldWoodSapling;
	public static ItemStack				heavenWoodPlanks, goldWoodPlanks;
	
	public static ItemStack				heavenGrassTall, mudGrassTall, corruptedGrassTall, hallowedGrassTall, mushroomGrassTall;
	public static ItemStack				heavenGrassVine, mudGrassVine, corruptedGrassVine, hallowedGrassVine, mushroomGrassVine, grassVine;
	
	public static ItemStack				heavenStone, heavenCobble, heavenCobbleMossy;
	public static ItemStack				shrekiteOre, clashiumOre, bluriteOre, holyiumOre;
	public static ItemStack				shrekiteBlock, clashiumBlock, bluriteBlock, holyiumBlock, proAlloyBlock;
	
	public static void initialize()
	{
		// -- Paradise of Chaos Blocks --
		
		pocStoneBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Chaos Stone", 180), Material.rock, "Chaos Stone", "chaosstone", MDMItems.tabPOCBlocks).setUnlocalizedName("chaosstone");
		pocDirtBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Altered Dirt", 181), Material.ground, "Altered Dirt", "altered_dirt", MDMItems.tabPOCBlocks).setUnlocalizedName("altered_dirt").setStepSound(Block.soundGravelFootstep);
		pocGrassBlocks = (BlockCustomGrass) new BlockCustomGrass(MDMConfig.getTerrainBlock("Altered Grass", 182), "Altered Grass", "altered_grass_top", "altered_grass_side", "altered_grass_bottom").setUnlocalizedName("altered_grass").setCreativeTab(MDMItems.tabPOCBlocks).setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(0.6F);
		
		pocOres1 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 1", 1005), Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "copper_ore", "tin_ore", "silver_ore", "mithril_ore", "adamanite_ore", "blurite_ore", "daeyalt_ore", "rubium_ore", "novite_ore", "bathus_ore", "marmaros_ore", "kratonium_ore", "fractite_ore", "zephyrium_ore", "argonite_ore", "katagon_ore" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_ores_1");
		pocOres2 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 2", 1006), Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "gorgonite_ore", "promethium_ore" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_ores_2");
		
		pocLogs = (BlockCustomLog) new BlockCustomLog(MDMConfig.getBlock("POC Logs", 1001), new String[] { "Magic Oak Log", "Willow Log" }, new String[] { "magicoak_top", "willow_top" }, new String[] { "magicoak_side", "willow_side" }).setUnlocalizedName("pocLogs").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(2.0F);
		{
			int i = -1;
			magicOakLog = new ItemStack(pocLogs, 1, ++i);
			willowLog = new ItemStack(pocLogs, 1, ++i);
		}
		pocLeaves = (BlockCustomLeaves) new BlockCustomLeaves(MDMConfig.getBlock("POC Leaves", 1003), new String[] { "Magic Oak Leaves", "Willow Leaves" }, new String[] { "magicoak_leaves", "willow_leaves" }).setUnlocalizedName("poc_leaves").setCreativeTab(MDMItems.tabPOCBlocks);
		{
			int i = -1;
			magicOakLeaves = new ItemStack(pocLeaves, 1, ++i);
			willowLeaves = new ItemStack(pocLeaves, 1, ++i);
		}
		pocSaplings = (BlockPOCSapling) new BlockPOCSapling(MDMConfig.getBlock("POC Saplings", 1002), new String[] { "Magic Oak Sapling", "Willow Sapling" }, new String[] { "magicoak_sapling", "willow_sapling" }).setUnlocalizedName("poc_saplings").setCreativeTab(MDMItems.tabPOCBlocks);
		{
			int i = -1;
			magicOakSapling = new ItemStack(pocSaplings, 1, ++i);
			willowSapling = new ItemStack(pocSaplings, 1, ++i);
		}
		pocPlanks = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Wood Blocks", 1007), Material.wood, new String[] { "Magic Oak Planks", "Willow Planks" }, new String[] { "magicoak_planks", "willow_planks" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_wood").setStepSound(Block.soundWoodFootstep);
		{
			int i = -1;
			magicOakPlanks = new ItemStack(pocPlanks, 1, ++i);
			willowPlanks = new ItemStack(pocPlanks, 1, ++i);
		}
		
		pocPlantBlocks = ((BlockPOCHerb) new BlockPOCHerb(MDMConfig.getBlock("POC Herbs", 1000), new String[] { "Saf Flower" }, new String[] { "safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		
		pocPortal = (BlockPOCPortal) new BlockPOCPortal(MDMConfig.getBlock("POC Portal", 1007)).setCreativeTab(MDMItems.tabPOCBlocks).setHardness(-1F).setUnlocalizedName("poc_portal").setTextureName("poc_portal");
		pocPortalFrame = new BlockPOCPortalFrame(MDMConfig.getBlock("POC Portal Frame", 1004)).setCreativeTab(MDMItems.tabPOCBlocks).setHardness(4F).setUnlocalizedName("poc_portal_frame").setTextureName("poc_portal_frame");
		
		Block.blocksList[Block.lavaStill.blockID] = null;
		activatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		dreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		alchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(MDMConfig.getBlock("Alchemy Tube", 1011)).setUnlocalizedName("AlchemyTube").setTextureName("alchemy_tube").setCreativeTab(MDMItems.tabAlchemy);
		
		// -- Heaven Blocks --
		
		heavenStoneBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Stone Blocks", 202), Material.rock, new String[] { "Heavenstone", "Heaven Cobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Shrekite Block", "Clashium Block", "Blurite Block", "Holyium Block", "Pro Alloy Block" }, new String[] { "heavenstone", "heavenstone_cobble", "heavenstone_mossy", "shrekite_ore", "clashium_ore", "blurite_ore_heaven", "holyium_ore", "shrekite_block", "clashium_block", "blurite_block_heaven", "holyium_block", "pro_block" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("heaven_stone");
		{
			int i = -1;
			heavenStone = new ItemStack(heavenStoneBlocks, 1, ++i);
			heavenCobble = new ItemStack(heavenStoneBlocks, 1, ++i);
			heavenCobbleMossy = new ItemStack(heavenStoneBlocks, 1, ++i);
			shrekiteOre = new ItemStack(heavenStoneBlocks, 1, ++i);
			clashiumOre = new ItemStack(heavenStoneBlocks, 1, ++i);
			bluriteOre = new ItemStack(heavenStoneBlocks, 1, ++i);
			holyiumOre = new ItemStack(heavenStoneBlocks, 1, ++i);
			shrekiteBlock = new ItemStack(heavenStoneBlocks, 1, ++i);
			clashiumBlock = new ItemStack(heavenStoneBlocks, 1, ++i);
			bluriteBlock = new ItemStack(heavenStoneBlocks, 1, ++i);
			holyiumBlock = new ItemStack(heavenStoneBlocks, 1, ++i);
			proAlloyBlock = new ItemStack(heavenStoneBlocks, 1, ++i);
		}
		
		heavenDirtBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Ground Blocks", 203), Material.ground, new String[] { "Heaven Dirt", "Mud" }, new String[] { "heaven_dirt", "mud" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("heaven_ground");
		{
			heavenDirt = new ItemStack(heavenDirtBlocks, 1, 0);
			mudDirt = new ItemStack(heavenDirtBlocks, 1, 1);
		}
		
		heavenGrassBlocks = (BlockHeavenGrass) (new BlockHeavenGrass(MDMConfig.getTerrainBlock("Heaven Grass", 204), new String[] { "Heaven Grass", "Mud Grass", "Corrupted Grass", "Hallowed Grass", "Mushroom Grass" }, new String[] { "heaven_grass_top", "mud_grass_top", "corrupted_grass_top", "hallowed_grass_top", "mushroom_grass_top" }, new String[] { "heaven_grass_side", "mud_grass_side", "corrupted_grass_side", "hallowed_grass_side", "mushroom_grass_side" }, new String[] { "heaven_dirt", "mud", "dirt", "dirt", "mud" })).setUnlocalizedName("heavenGrassBlocks").setCreativeTab(MDMItems.tabHeavenBlocks);
		{
			int i = -1;
			heavenGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			mudGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			corruptedGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			hallowedGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			mushroomGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
		}
		
		heavenLogs = (BlockCustomLog) (new BlockCustomLog(MDMConfig.getBlock("Heaven Log", 1052), new String[] { "Heaven Wood Log", "Gold Wood Log" }, new String[] { "heavenwood_top", "goldwood_top" }, new String[] { "heavenwood_side", "goldwood_side" })).setUnlocalizedName("heaven_logs").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(2.0F);
		{
			int i = -1;
			heavenWoodLog = new ItemStack(heavenLogs, 1, ++i);
			goldWoodLog = new ItemStack(heavenLogs, 1, ++i);
		}
		heavenLeaves = (BlockCustomLeaves) (new BlockCustomLeaves(MDMConfig.getBlock("Heaven Leaves", 1056), new String[] { "Heaven Wood Leaves", "Gold Wood Leaves" }, new String[] { "heavenwood_leaves", "goldwood_leaves" })).setUnlocalizedName("heaven_leaves").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(0.2F);
		{
			int i = -1;
			heavenWoodLeaves = new ItemStack(heavenLeaves, 1, ++i);
			goldWoodLeaves = new ItemStack(heavenLeaves, 1, ++i);
		}
		heavenSaplings = (BlockHeavenSapling) (new BlockHeavenSapling(MDMConfig.getBlock("Heaven Sapling", 1057), new String[] { "Heaven Wood Sapling", "Gold Wood Sapling" }, new String[] { "heavenwood_sapling", "goldwood_sapling" })).setUnlocalizedName("heaven_saplings").setCreativeTab(MDMItems.tabHeavenBlocks);
		{
			int i = -1;
			heavenWoodSapling = new ItemStack(heavenSaplings, 1, ++i);
			goldWoodSapling = new ItemStack(heavenSaplings, 1, ++i);
		}
		heavenPlanks = (CustomBlock) new CustomBlock(MDMConfig.getBlock("Heaven Wood Blocks", 1050), Material.wood, new String[] { "Heaven Planks", "Gold Wood Planks" }, new String[] { "heavenwood_planks", "goldwood_planks" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setUnlocalizedName("heaven_wood").setStepSound(Block.soundWoodFootstep);
		{
			int i = -1;
			heavenWoodPlanks = new ItemStack(heavenPlanks, 1, ++i);
			goldWoodPlanks = new ItemStack(heavenPlanks, 1, ++i);
		}
		
		heavenPlantBlocks = (CustomBlock) new BlockHeavenPlant(MDMConfig.getBlock("Heaven Plant Blocks", 1051), new String[] { "Tall Heaven Grass", "Tall Mud Grass", "Tall Corrupted Grass", "Tall Hallowed Grass", "Tall Mushroom Grass", "Heaven Grass Vine", "Mud Grass Vine", "Corrupted Grass Vine", "Hallowed Grass Vine", "Mushroom Grass Vine", "Grass Vine" }, new String[] { "plant_grass_heaven", "plant_grass_mud", "plant_grass_corrupted", "plant_grass_hallowed", "plant_grass_mushroom", "plant_vine_heaven", "plant_vine_mud", "plant_vine_corrupted", "plant_vine_hallowed", "plant_vine_mushroom", "plant_vine_grass" }).setUnlocalizedName("heavenPlantBlocks").setCreativeTab(MDMItems.tabHeavenBlocks).setStepSound(Block.soundGrassFootstep);
		{
			int i = -1;
			heavenGrassTall = new ItemStack(heavenPlantBlocks, 1, ++i);
			mudGrassTall = new ItemStack(heavenPlantBlocks, 1, ++i);
			corruptedGrassTall = new ItemStack(heavenPlantBlocks, 1, ++i);
			hallowedGrassTall = new ItemStack(heavenPlantBlocks, 1, ++i);
			mushroomGrassTall = new ItemStack(heavenPlantBlocks, 1, ++i);
			
			heavenGrassVine = new ItemStack(heavenPlantBlocks, 1, ++i);
			mudGrassVine = new ItemStack(heavenPlantBlocks, 1, ++i);
			corruptedGrassVine = new ItemStack(heavenPlantBlocks, 1, ++i);
			hallowedGrassVine = new ItemStack(heavenPlantBlocks, 1, ++i);
			mushroomGrassVine = new ItemStack(heavenPlantBlocks, 1, ++i);
			
			grassVine = new ItemStack(heavenPlantBlocks, 1, ++i);
		}
		
		heavenPortal = (BlockHeavenPortal) (new BlockHeavenPortal(MDMConfig.getBlock("Heaven Portal", 1053))).setUnlocalizedName("heaven_portal").setTextureName("heaven_portal").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(-1F).setLightValue(1F);
		heavenPortalFrame = (new BlockMDM(MDMConfig.getBlock("Heaven Portal Frame", 1054), Material.rock, MDMItems.tabHeavenBlocks)).setUnlocalizedName("heaven_portal_frame").setTextureName("heaven_portal_frame").setHardness(2F);
		
		heavenPillar = (BlockHeavenPillar) (new BlockHeavenPillar(MDMConfig.getBlock("Heaven Pillar", 1058))).setUnlocalizedName("pillar").setHardness(1.75F);
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		pocStoneBlocks.setHardness(2.2F);
		pocDirtBlocks.setHardness(0.5F);
		pocGrassBlocks.setDirtBlock(0, pocDirtBlocks.blockID, 0);
		
		addBlock(pocStoneBlocks, "Chaos Stone");
		addBlock(pocDirtBlocks, "Altered Dirt");
		addBlock(pocGrassBlocks, "Altered Grass");
		
		addBlock(pocOres1, "POCOres1");
		addBlock(pocOres2, "POCOres2");
		
		addBlock(pocLogs, "POCLogs");
		addBlock(pocLeaves, "POCLeaves");
		addBlock(pocSaplings, "POCSaplings");
		addBlock(pocPlanks, "POCPlanks");
		
		addBlock(pocPlantBlocks, "POC Herbs");
		addBlock(pocPortal, "Paradise of Chaos Portal");
		addBlock(pocPortalFrame, "Paradise Of Chaos Portal Frame");
		
		addBlock(alchemyTube, "Alchemy Tube");
		
		// -- Heaven --
		
		heavenStoneBlocks.setHardnesses(1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F);
		heavenStoneBlocks.setDrops(heavenCobble, null, null, MDMItems.shrekiteShard, null, MDMItems.bluriteDust, null, null, null, null, null);
		heavenDirtBlocks.setHardnesses(0.5F, 0.6F);
		heavenGrassBlocks.setHardnesses(0.6F, 0.65F, 0.7F, 0.7F, 0.65F);
		heavenGrassBlocks.setDirtBlocks(new int[] { heavenDirtBlocks.blockID, heavenDirtBlocks.blockID, Block.dirt.blockID, Block.dirt.blockID, heavenDirtBlocks.blockID }, new int[] { 0, 1, 0, 0, 1 });
		
		heavenPlanks.setHardness(2.0F);
		heavenPlantBlocks.setHardnesses(0F, 0F, 0F, 0F);
		
		addBlock(heavenStoneBlocks, "HeavenStoneBlocks");
		addBlock(heavenDirtBlocks, "HeavenGroundBlocks");
		addBlock(heavenGrassBlocks, "HeavenGrassBlocks");
		
		addBlock(heavenLogs, "HeavenLogs");
		addBlock(heavenLeaves, "HeavenLeaves");
		addBlock(heavenSaplings, "HeavenSaplings");
		addBlock(heavenPlanks, "HeavenWoodBlocks");
		
		addBlock(heavenPlantBlocks, "HeavenPlantBlocks");
		addBlock(heavenPortal, "Heaven Portal");
		addBlock(heavenPortalFrame, "Heaven Portal Frame");
		addBlock(heavenPillar, "Heaven Pillar");
	}
}
