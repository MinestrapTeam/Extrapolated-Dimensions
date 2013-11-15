package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomBlock;
import clashsoft.clashsoftapi.ItemCustomBlock;
import clashsoft.clashsoftapi.block.BlockCustomLeaves;
import clashsoft.clashsoftapi.block.BlockCustomLog;
import clashsoft.clashsoftapi.block.BlockCustomSapling;
import clashsoft.clashsoftapi.block.ICustomBlock;
import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.block.BlockMDM;
import clashsoft.mods.moredimensions.block.heaven.*;
import clashsoft.mods.moredimensions.block.poc.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

@Addon(modName = "MoreDimensionsMod", addonName = "Blocks")
public class MDMBlocks
{
	// -- Paradise of Chaos Blocks --
	
	public static Block					chaosStone;
	public static BlockAlteredDirt		alteredDirt;
	public static BlockAlteredGrass		alteredGrass;
	public static BlockPOCHerb			herbs;
	public static BlockCustomLog		pocLogs;
	public static BlockCustomSapling	pocSaplings;
	public static BlockCustomLeaves		pocLeaves;
	public static Block					pocPortalFrame;
	public static BlockPOCPortal		pocPortal;
	public static BlockPOCActivatorLava	activatorLava;
	public static BlockPOCDreamBed		dreamBed;
	public static BlockAlchemyTube		alchemyTube;
	public static CustomBlock			pocOres1;
	public static CustomBlock			pocOres2;
	public static CustomBlock			pocPlanks;
	
	// -- Heaven Blocks --
	
	public static BlockHeavenPortal		heavenPortal;
	public static Block					heavenPortalFrame;
	public static CustomBlock			stoneBlocks;
	public static CustomBlock			woodBlocks;
	public static CustomBlock			groundBlocks;
	public static CustomBlock			plantBlocks;
	public static BlockHeavenGrass		heavenGrass;
	public static BlockCustomLog		heavenLogs;
	public static BlockCustomLeaves		heavenLeaves;
	public static BlockCustomSapling	heavenSaplings;
	public static BlockHeavenPillar		heavenPillar;
	
	public static ItemStack				heavenwoodPlanks, goldwoodPlanks;
	
	public static ItemStack				heavenDirt;
	
	public static ItemStack				blueFlower, orangeFlower, vinePlant, roundPlant;
	
	public static ItemStack				heavenStone, heavenCobble, heavenCobbleMossy;
	public static ItemStack				shrekiteOre, clashiumOre, bluriteOre, holyiumOre;
	public static ItemStack				shrekiteBlock, clashiumBlock, bluriteBlock, holyiumBlock, proAlloyBlock;
	
	public static void initialize()
	{
		// -- Paradise of Chaos Blocks --
		
		chaosStone = new Block(MDMConfig.getTerrainBlock("Chaos Stone", 180), Material.rock).setCreativeTab(MDMItems.tabPOCBlocks).setHardness(2.2F).setUnlocalizedName("chaosstone").setTextureName("chaosstone");
		alteredDirt = (BlockAlteredDirt) new BlockAlteredDirt(MDMConfig.getTerrainBlock("Altered Dirt", 181), Material.ground).setUnlocalizedName("altered_dirt").setTextureName("altered_dirt").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(0.5F).setStepSound(Block.soundGravelFootstep);
		alteredGrass = (BlockAlteredGrass) new BlockAlteredGrass(MDMConfig.getTerrainBlock("Altered Grass", 182), Material.grass).setUnlocalizedName("altered_grass").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		
		herbs = ((BlockPOCHerb) new BlockPOCHerb(MDMConfig.getBlock("POC Herbs", 1000), new String[] { "Saf Flower" }, new String[] { "safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		
		pocLogs = (BlockCustomLog) new BlockCustomLog(MDMConfig.getBlock("POC Logs", 1001), new String[] { "Magic Oak Log", "Willow Log" }, new String[] { "magicoak_top", "willow_top" }, new String[] { "magicoak_side", "willow_side" }).setUnlocalizedName("pocLogs").setCreativeTab(MDMItems.tabPOCBlocks).setHardness(2.0F);
		pocLeaves = (BlockCustomLeaves) new BlockCustomLeaves(MDMConfig.getBlock("POC Leaves", 1003), new String[] { "Magic Oak Leaves", "Willow Leaves" }, new String[] { "magicoak_leaves", "willow_leaves" }).setUnlocalizedName("poc_leaves").setCreativeTab(MDMItems.tabPOCBlocks);
		pocSaplings = (BlockPOCSapling) new BlockPOCSapling(MDMConfig.getBlock("POC Saplings", 1002), new String[] { "Magic Oak Sapling", "Willow Sapling" }, new String[] { "magicoak_sapling", "willow_sapling" }).setUnlocalizedName("poc_saplings").setCreativeTab(MDMItems.tabPOCBlocks);
		
		pocPortalFrame = new BlockPOCPortalFrame(MDMConfig.getBlock("POC Portal Frame", 1004)).setCreativeTab(MDMItems.tabPOCBlocks).setHardness(4F).setUnlocalizedName("poc_portal_frame").setTextureName("poc_portal_frame");
		pocPortal = (BlockPOCPortal) new BlockPOCPortal(MDMConfig.getBlock("POC Portal", 1007)).setCreativeTab(MDMItems.tabPOCBlocks).setHardness(-1F).setUnlocalizedName("poc_portal").setTextureName("poc_portal");
		
		pocOres1 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 1", 1005), Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "copper_ore", "tin_ore", "silver_ore", "mithril_ore", "adamanite_ore", "blurite_ore", "daeyalt_ore", "rubium_ore", "novite_ore", "bathus_ore", "marmaros_ore", "kratonium_ore", "fractite_ore", "zephyrium_ore", "argonite_ore", "katagon_ore" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_ores_1");
		pocOres2 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 2", 1006), Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "gorgonite_ore", "promethium_ore" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_ores_2");
		pocPlanks = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Wood Blocks", 1007), Material.wood, new String[] { "Magic Oak Planks", "Willow Planks" }, new String[] { "magicoak_planks", "willow_planks" }, new CreativeTabs[] { MDMItems.tabPOCBlocks }).setUnlocalizedName("poc_wood").setStepSound(Block.soundWoodFootstep);
		
		Block.blocksList[Block.lavaStill.blockID] = null;
		activatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		dreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		alchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(MDMConfig.getBlock("Alchemy Tube", 1011)).setUnlocalizedName("AlchemyTube").setTextureName("alchemy_tube").setCreativeTab(MDMItems.tabAlchemy);
		
		// -- Heaven Blocks --
		
		stoneBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Stone Blocks", 202), Material.rock, new String[] { "Heavenstone", "Heaven Cobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Shrekite Block", "Clashium Block", "Blurite Block", "Holyium Block", "Pro Alloy Block" }, new String[] { "heavenstone", "heavenstone_cobble", "heavenstone_mossy", "shrekite_ore", "clashium_ore", "blurite_ore_heaven", "holyium_ore", "shrekite_block", "clashium_block", "blurite_block_heaven", "holyium_block", "pro_block" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("heaven_stone");
		heavenStone = new ItemStack(stoneBlocks, 1, 0);
		heavenCobble = new ItemStack(stoneBlocks, 1, 1);
		heavenCobbleMossy = new ItemStack(stoneBlocks, 1, 2);
		shrekiteOre = new ItemStack(stoneBlocks, 1, 3);
		clashiumOre = new ItemStack(stoneBlocks, 1, 4);
		bluriteOre = new ItemStack(stoneBlocks, 1, 5);
		holyiumOre = new ItemStack(stoneBlocks, 1, 6);
		shrekiteBlock = new ItemStack(stoneBlocks, 1, 7);
		clashiumBlock = new ItemStack(stoneBlocks, 1, 8);
		bluriteBlock = new ItemStack(stoneBlocks, 1, 9);
		holyiumBlock = new ItemStack(stoneBlocks, 1, 10);
		proAlloyBlock = new ItemStack(stoneBlocks, 1, 11);
		
		groundBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Ground Blocks", 203), Material.ground, new String[] { "Heaven Dirt" }, new String[] { "heaven_dirt" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("heaven_ground");
		heavenDirt = new ItemStack(groundBlocks, 1, 0);
		
		heavenGrass = (BlockHeavenGrass) (new BlockHeavenGrass(MDMConfig.getTerrainBlock("Heaven Grass", 204))).setUnlocalizedName("heavengrass").setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		
		woodBlocks = (CustomBlock) new CustomBlock(MDMConfig.getBlock("Heaven Wood Blocks", 1050), Material.wood, new String[] { "Heaven Planks", "Gold Wood Planks" }, new String[] { "heavenwood_planks", "goldwood_planks" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setUnlocalizedName("heaven_wood").setStepSound(Block.soundWoodFootstep);
		heavenwoodPlanks = new ItemStack(woodBlocks, 1, 0);
		goldwoodPlanks = new ItemStack(woodBlocks, 1, 1);
		
		plantBlocks = (CustomBlock) new BlockHeavenPlant(MDMConfig.getBlock("Heaven Plant Blocks", 1051), new String[] { "Blue Flower", "Orange Flower", "Ground Vine", "Round Plant" }, new String[] { "heavenplant_blue", "heavenplant_orange", "heavenplant_vine", "heavenplant_circle" }).setUnlocalizedName("heaven_plant").setStepSound(Block.soundGrassFootstep);
		blueFlower = new ItemStack(plantBlocks, 1, 0);
		orangeFlower = new ItemStack(plantBlocks, 1, 1);
		vinePlant = new ItemStack(plantBlocks, 1, 2);
		roundPlant = new ItemStack(plantBlocks, 1, 3);
		
		heavenPortal = (BlockHeavenPortal) (new BlockHeavenPortal(MDMConfig.getBlock("Heaven Portal", 1053))).setUnlocalizedName("heaven_portal").setTextureName("heaven_portal").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(-1F).setLightValue(1F);
		heavenPortalFrame = (new BlockMDM(MDMConfig.getBlock("Heaven Portal Frame", 1054), Material.rock, MDMItems.tabHeavenBlocks)).setUnlocalizedName("heaven_portal_frame").setTextureName("heaven_portal_frame").setHardness(2F);
		
		heavenLogs = (BlockCustomLog) (new BlockCustomLog(MDMConfig.getBlock("Heaven Log", 1052), new String[] { "Heaven Wood Log", "Gold Wood Log" }, new String[] { "heavenwood_top", "goldwood_top" }, new String[] { "heavenwood_side", "goldwood_side" })).setUnlocalizedName("heaven_logs").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(2.0F);
		heavenLeaves = (BlockCustomLeaves) (new BlockCustomLeaves(MDMConfig.getBlock("Heaven Leaves", 1056), new String[] { "Heaven Wood Leaves", "Gold Wood Leaves" }, new String[] { "heavenwood_leaves", "goldwood_leaves" })).setUnlocalizedName("heaven_leaves").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(0.2F);
		heavenSaplings = (BlockHeavenSapling) (new BlockHeavenSapling(MDMConfig.getBlock("Heaven Sapling", 1057), new String[] { "Heaven Wood Sapling", "Gold Wood Sapling" }, new String[] { "heavenwood_sapling", "goldwood_sapling" })).setUnlocalizedName("heaven_saplings").setCreativeTab(MDMItems.tabHeavenBlocks);
		
		heavenPillar = (BlockHeavenPillar) (new BlockHeavenPillar(MDMConfig.getBlock("Heaven Pillar", 1058))).setUnlocalizedName("pillar").setHardness(1.75F);
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addBlock(chaosStone, "Chaos Stone");
		addBlock(alteredDirt, "Altered Dirt");
		addBlock(alteredGrass, "Altered Grass");
		addBlock(herbs, "POC Herbs");
		addBlock(pocLogs, "pocLogs");
		addBlock(pocLeaves, "pocLeaves");
		addBlock(pocSaplings, "pocSaplings");
		addBlock(pocPortalFrame, "Paradise Of Chaos Portal Frame");
		addBlock(pocPortal, "Paradise of Chaos Portal");
		addBlock(alchemyTube, "Alchemy Tube");
		addBlock(pocOres1, "POC Ores 1");
		addBlock(pocOres2, "POC Ores 2");
		
		// -- Heaven --
		
		stoneBlocks.setHardnesses(new float[] { 1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F });
		stoneBlocks.setDrops(new ItemStack[] { heavenCobble, null, null, MDMItems.shrekiteShard, null, MDMItems.bluriteDust, null, null, null, null, null });
		woodBlocks.setHardnesses(new float[] { 2.0F });
		groundBlocks.setHardnesses(new float[] { 0.5F });
		plantBlocks.setHardnesses(new float[] { 0F, 0F, 0F, 0F });
		
		addBlock(stoneBlocks, "heavenStoneBlocks");
		addBlock(woodBlocks, "heavenWoodBlocks");
		addBlock(groundBlocks, "heavenGroundBlocks");
		addBlock(plantBlocks, "heavenPlantBlocks");
		
		addBlock(heavenPortalFrame, "Heaven Portal Frame");
		addBlock(heavenPortal, "Heaven Portal");
		addBlock(heavenGrass, "Heaven Grass");
		addBlock(heavenLogs, "heavenLogs");
		addBlock(heavenLeaves, "heavenLeaves");
		addBlock(heavenSaplings, "heavenSaplings");
		addBlock(heavenPillar, "Heaven Pillar");
	}
	
	public static void addBlock(Block block, String name)
	{
		addBlock(block, name, block instanceof ICustomBlock ? ItemCustomBlock.class : ItemBlock.class);
	}
	
	public static void addBlock(Block block, String name, Class<? extends ItemBlock> itemClass)
	{
		GameRegistry.registerBlock(block, itemClass, name);
		if (block instanceof ICustomBlock)
			((ICustomBlock) block).addNames();
		else
			LanguageRegistry.addName(block, name);
	}
}
