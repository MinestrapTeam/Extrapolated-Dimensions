package clashsoft.mods.moredimensions.addons;

import static clashsoft.cslib.minecraft.util.CSBlocks.addBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import clashsoft.cslib.addon.Addon;
import clashsoft.cslib.minecraft.CustomBlock;
import clashsoft.cslib.minecraft.block.BlockCustomGrass;
import clashsoft.cslib.minecraft.block.BlockCustomLeaves;
import clashsoft.cslib.minecraft.block.BlockCustomLog;
import clashsoft.cslib.minecraft.block.BlockCustomSapling;
import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.mods.moredimensions.block.alchemy.BlockAlchemyTube;
import clashsoft.mods.moredimensions.block.heaven.*;
import clashsoft.mods.moredimensions.block.poc.*;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;

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
	
	public static BlockDamnationTable	damnationTable;
	
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
		
		pocStoneBlocks = (CustomBlock) new CustomBlock(CSConfig.getTerrainBlock("Chaos Stone", 180), Material.rock, "Chaos Stone", "moredimensions:chaosstone", MDMItems.tabPOCBlocks).setUnlocalizedName("chaosstone");
		pocDirtBlocks = (CustomBlock) new CustomBlock(CSConfig.getTerrainBlock("Altered Dirt", 181), Material.ground, "Altered Dirt", "moredimensions:altered_dirt", MDMItems.tabPOCBlocks).setUnlocalizedName("altered_dirt").setStepSound(Block.soundGravelFootstep);
		pocGrassBlocks = (BlockCustomGrass) new BlockCustomGrass(CSConfig.getTerrainBlock("Altered Grass", 182), "Altered Grass", "moredimensions:altered_grass_top", "moredimensions:altered_grass_side", "moredimensions:altered_grass_bottom").setUnlocalizedName("altered_grass").setCreativeTab(MDMItems.tabPOCBlocks).setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(0.6F);
		
		pocOres1 = (CustomBlock) new CustomBlock(CSConfig.getBlock("POC Ores 1", 1005), Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "moredimensions:copper_ore", "moredimensions:tin_ore", "moredimensions:silver_ore", "moredimensions:mithril_ore", "moredimensions:adamanite_ore", "moredimensions:blurite_ore", "moredimensions:daeyalt_ore", "moredimensions:rubium_ore", "moredimensions:novite_ore", "moredimensions:bathus_ore", "moredimensions:marmaros_ore", "moredimensions:kratonium_ore", "moredimensions:fractite_ore", "moredimensions:zephyrium_ore", "moredimensions:argonite_ore", "moredimensions:katagon_ore" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_ores_1");
		pocOres2 = (CustomBlock) new CustomBlock(CSConfig.getBlock("POC Ores 2", 1006), Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "moredimensions:gorgonite_ore", "moredimensions:promethium_ore" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_ores_2");
		
		pocLogs = (BlockCustomLog) new BlockCustomLog(CSConfig.getBlock("POC Logs", 1001), new String[] { "Magic Oak Log", "Willow Log" }, new String[] { "moredimensions:magicoak_top", "moredimensions:willow_top" }, new String[] { "moredimensions:magicoak_side", "moredimensions:willow_side" }).setUnlocalizedName("pocLogs").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(2.0F);
		{
			int i = -1;
			magicOakLog = new ItemStack(pocLogs, 1, ++i);
			willowLog = new ItemStack(pocLogs, 1, ++i);
		}
		pocLeaves = (BlockCustomLeaves) new BlockCustomLeaves(CSConfig.getBlock("POC Leaves", 1003), new String[] { "Magic Oak Leaves", "Willow Leaves" }, new String[] { "moredimensions:magicoak_leaves", "moredimensions:willow_leaves" }).setUnlocalizedName("poc_leaves").setCreativeTab(MDMItems.tabPOCBlocks);
		{
			int i = -1;
			magicOakLeaves = new ItemStack(pocLeaves, 1, ++i);
			willowLeaves = new ItemStack(pocLeaves, 1, ++i);
		}
		pocSaplings = (BlockPOCSapling) new BlockPOCSapling(CSConfig.getBlock("POC Saplings", 1002), new String[] { "Magic Oak Sapling", "Willow Sapling" }, new String[] { "moredimensions:magicoak_sapling", "moredimensions:willow_sapling" }).setUnlocalizedName("poc_saplings").setCreativeTab(MDMItems.tabPOCBlocks);
		{
			int i = -1;
			magicOakSapling = new ItemStack(pocSaplings, 1, ++i);
			willowSapling = new ItemStack(pocSaplings, 1, ++i);
		}
		pocPlanks = (CustomBlock) new CustomBlock(CSConfig.getBlock("POC Wood Blocks", 1007), Material.wood, new String[] { "Magic Oak Planks", "Willow Planks" }, new String[] { "moredimensions:magicoak_planks", "moredimensions:willow_planks" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_wood").setStepSound(Block.soundWoodFootstep);
		{
			int i = -1;
			magicOakPlanks = new ItemStack(pocPlanks, 1, ++i);
			willowPlanks = new ItemStack(pocPlanks, 1, ++i);
		}
		
		pocPlantBlocks = ((BlockPOCHerb) new BlockPOCHerb(CSConfig.getBlock("POC Herbs", 1000), new String[] { "Saf Flower" }, new String[] { "moredimensions:safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		
		pocPortal = (BlockPOCPortal) new BlockPOCPortal(CSConfig.getBlock("POC Portal", 1007)).setCreativeTab(MDMItems.tabPOCBlocks).setHardness(-1F).setUnlocalizedName("poc_portal").setTextureName("moredimensions:poc_portal");
		pocPortalFrame = new BlockPOCPortalFrame(CSConfig.getBlock("POC Portal Frame", 1004)).setCreativeTab(MDMItems.tabPOCBlocks).setHardness(4F).setUnlocalizedName("poc_portal_frame").setTextureName("moredimensions:poc_portal_frame");
		
		Block.blocksList[Block.lavaStill.blockID] = null;
		activatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		dreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		alchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(CSConfig.getBlock("Alchemy Tube", 1011)).setUnlocalizedName("AlchemyTube").setTextureName("moredimensions:alchemy_tube").setCreativeTab(MDMItems.tabAlchemy);
		
		// -- Heaven Blocks --
		
		heavenStoneBlocks = (CustomBlock) new CustomBlock(CSConfig.getTerrainBlock("Heaven Stone Blocks", 202), Material.rock, new String[] { "Heavenstone", "Heaven Cobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Shrekite Block", "Clashium Block", "Blurite Block", "Holyium Block", "Pro Alloy Block" }, new String[] { "moredimensions:heavenstone", "moredimensions:heavenstone_cobble", "moredimensions:heavenstone_mossy", "moredimensions:shrekite_ore", "moredimensions:clashium_ore", "moredimensions:blurite_ore_heaven", "moredimensions:holyium_ore", "moredimensions:shrekite_block", "moredimensions:clashium_block", "moredimensions:blurite_block_heaven", "moredimensions:holyium_block", "moredimensions:pro_block" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("heaven_stone");
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
		
		heavenDirtBlocks = (CustomBlock) new CustomBlock(CSConfig.getTerrainBlock("Heaven Ground Blocks", 203), Material.ground, new String[] { "Heaven Dirt", "Mud" }, new String[] { "moredimensions:heaven_dirt", "moredimensions:mud" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("heaven_ground");
		{
			heavenDirt = new ItemStack(heavenDirtBlocks, 1, 0);
			mudDirt = new ItemStack(heavenDirtBlocks, 1, 1);
		}
		
		heavenGrassBlocks = (BlockHeavenGrass) (new BlockHeavenGrass(CSConfig.getTerrainBlock("Heaven Grass", 204), new String[] { "Heaven Grass", "Mud Grass", "Corrupted Grass", "Hallowed Grass", "Mushroom Grass" }, new String[] { "moredimensions:heaven_grass_top", "moredimensions:mud_grass_top", "moredimensions:corrupted_grass_top", "moredimensions:hallowed_grass_top", "moredimensions:mushroom_grass_top" }, new String[] { "moredimensions:heaven_grass_side", "moredimensions:mud_grass_side", "moredimensions:corrupted_grass_side", "moredimensions:hallowed_grass_side", "moredimensions:mushroom_grass_side" }, new String[] { "moredimensions:heaven_dirt", "moredimensions:mud", "dirt", "dirt", "moredimensions:mud" })).setUnlocalizedName("heavenGrassBlocks").setCreativeTab(MDMItems.tabHeavenBlocks);
		{
			int i = -1;
			heavenGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			mudGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			corruptedGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			hallowedGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
			mushroomGrass = new ItemStack(heavenGrassBlocks, 1, ++i);
		}
		
		heavenLogs = (BlockCustomLog) (new BlockCustomLog(CSConfig.getBlock("Heaven Log", 1052), new String[] { "Heaven Wood Log", "Gold Wood Log" }, new String[] { "moredimensions:heavenwood_top", "moredimensions:goldwood_top" }, new String[] { "moredimensions:heavenwood_side", "moredimensions:goldwood_side" })).setUnlocalizedName("heaven_logs").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(2.0F);
		{
			int i = -1;
			heavenWoodLog = new ItemStack(heavenLogs, 1, ++i);
			goldWoodLog = new ItemStack(heavenLogs, 1, ++i);
		}
		heavenLeaves = (BlockCustomLeaves) (new BlockCustomLeaves(CSConfig.getBlock("Heaven Leaves", 1056), new String[] { "Heaven Wood Leaves", "Gold Wood Leaves" }, new String[] { "moredimensions:heavenwood_leaves", "moredimensions:goldwood_leaves" })).setUnlocalizedName("heaven_leaves").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(0.2F);
		{
			int i = -1;
			heavenWoodLeaves = new ItemStack(heavenLeaves, 1, ++i);
			goldWoodLeaves = new ItemStack(heavenLeaves, 1, ++i);
		}
		heavenSaplings = (BlockHeavenSapling) (new BlockHeavenSapling(CSConfig.getBlock("Heaven Sapling", 1057), new String[] { "Heaven Wood Sapling", "Gold Wood Sapling" }, new String[] { "moredimensions:heavenwood_sapling", "moredimensions:goldwood_sapling" })).setUnlocalizedName("heaven_saplings").setCreativeTab(MDMItems.tabHeavenBlocks);
		{
			int i = -1;
			heavenWoodSapling = new ItemStack(heavenSaplings, 1, ++i);
			goldWoodSapling = new ItemStack(heavenSaplings, 1, ++i);
		}
		heavenPlanks = (CustomBlock) new CustomBlock(CSConfig.getBlock("Heaven Wood Blocks", 1050), Material.wood, new String[] { "Heaven Planks", "Gold Wood Planks" }, new String[] { "moredimensions:heavenwood_planks", "moredimensions:goldwood_planks" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setUnlocalizedName("heaven_wood").setStepSound(Block.soundWoodFootstep);
		{
			int i = -1;
			heavenWoodPlanks = new ItemStack(heavenPlanks, 1, ++i);
			goldWoodPlanks = new ItemStack(heavenPlanks, 1, ++i);
		}
		
		heavenPlantBlocks = (CustomBlock) new BlockHeavenPlant(CSConfig.getBlock("Heaven Plant Blocks", 1051), new String[] { "Tall Heaven Grass", "Tall Mud Grass", "Tall Corrupted Grass", "Tall Hallowed Grass", "Tall Mushroom Grass", "Heaven Grass Vine", "Mud Grass Vine", "Corrupted Grass Vine", "Hallowed Grass Vine", "Mushroom Grass Vine", "Grass Vine" }, new String[] { "moredimensions:plant_grass_heaven", "moredimensions:plant_grass_mud", "moredimensions:plant_grass_corrupted", "moredimensions:plant_grass_hallowed", "moredimensions:plant_grass_mushroom", "moredimensions:plant_vine_heaven", "moredimensions:plant_vine_mud", "moredimensions:plant_vine_corrupted", "moredimensions:plant_vine_hallowed", "moredimensions:plant_vine_mushroom", "moredimensions:plant_vine_grass" }).setUnlocalizedName("heavenPlantBlocks").setCreativeTab(MDMItems.tabHeavenBlocks).setStepSound(Block.soundGrassFootstep);
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
		
		heavenPortal = (BlockHeavenPortal) (new BlockHeavenPortal(CSConfig.getBlock("Heaven Portal", 1053))).setUnlocalizedName("heaven_portal").setTextureName("moredimensions:heaven_portal").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(-1F).setLightValue(1F);
		heavenPortalFrame = (new Block(CSConfig.getBlock("Heaven Portal Frame", 1054), Material.rock)).setUnlocalizedName("heaven_portal_frame").setTextureName("moredimensions:heaven_portal_frame").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(2F);
		
		heavenPillar = (BlockHeavenPillar) (new BlockHeavenPillar(CSConfig.getBlock("Heaven Pillar", 1058))).setUnlocalizedName("pillar").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(1.75F);
		
		damnationTable = (BlockDamnationTable) new BlockDamnationTable(CSConfig.getBlock("Damnation Tabel", 1059)).setUnlocalizedName("damnation_table").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(4F);
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
		
		addBlock(damnationTable, "Damnation Table");
		
		GameRegistry.registerTileEntity(TileEntityDamnationTable.class, "DamnationTable");
	}
}
