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
	public static Block					POCPortalFrame;
	public static BlockPOCPortal		POCPortal;
	public static BlockPOCActivatorLava	ActivatorLava;
	public static BlockPOCDreamBed		DreamBed;
	public static BlockAlchemyTube		AlchemyTube;
	public static CustomBlock			ores1;
	public static CustomBlock			ores2;
	
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
		
		chaosStone = new Block(MDMConfig.getTerrainBlock("Chaos Stone", 180), Material.rock).setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(2.2F).setUnlocalizedName("chaosstone").setTextureName("chaosstone");
		alteredDirt = (BlockAlteredDirt) new BlockAlteredDirt(MDMConfig.getTerrainBlock("Altered Dirt", 181), Material.ground).setUnlocalizedName("alteredDirt").setTextureName("alteredDirt").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.5F).setStepSound(Block.soundGravelFootstep);
		alteredGrass = (BlockAlteredGrass) new BlockAlteredGrass(MDMConfig.getTerrainBlock("Altered Grass", 182), Material.grass).setUnlocalizedName("alteredGrass").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		
		herbs = ((BlockPOCHerb) new BlockPOCHerb(MDMConfig.getBlock("POC Herbs", 1000), new String[] { "Saf Flower" }, new String[] { "safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		
		pocLogs = (BlockCustomLog) new BlockCustomLog(MDMConfig.getBlock("POC Logs", 1001), new String[] { "Magic Oak Log", "Willow Log" }, new String[] { "magicoak_top", "willow_top" }, new String[] { "magicoak_side", "willow_side" }).setUnlocalizedName("pocLogs").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(2.0F);
		pocLeaves = (BlockCustomLeaves) new BlockCustomLeaves(MDMConfig.getBlock("POC Leaves", 1003), new String[] { "Magic Oak Leaves", "Willow Leaves" }, new String[] { "magicoakLeaves", "willowLeaves" }).setUnlocalizedName("pocLeaves").setCreativeTab(MDMItems.tabParadiseOfChaos);
		pocSaplings = (BlockPOCSapling) new BlockPOCSapling(MDMConfig.getBlock("POC Saplings", 1002), new String[] { "Magic Oak Sapling", "Willow Sapling" }, new String[] { "magicoakSapling", "willowSapling" }).setUnlocalizedName("pocSaplings").setCreativeTab(MDMItems.tabParadiseOfChaos);
		
		POCPortalFrame = new BlockPOCPortalFrame(MDMConfig.getBlock("POC Portal Frame", 1004)).setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(4F).setUnlocalizedName("POCPortalFrame").setTextureName("POCPortalFrame");
		ores1 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 1", 1005), Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "copperOre", "tinOre", "silverOre", "mithrilOre", "adamaniteOre", "bluriteOre", "daeyaltOre", "rubiumOre", "noviteOre", "bathusOre", "marmarosOre", "kratoniumOre", "fractiteOre", "zephyriumOre", "argoniteOre", "katagonOre" }, new CreativeTabs[] { MDMItems.tabParadiseOfChaos }).setUnlocalizedName("POCOres1");
		ores2 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 2", 1006), Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "gorgoniteOre", "promethiumOre" }, new CreativeTabs[] { MDMItems.tabParadiseOfChaos }).setUnlocalizedName("POCOres2");
		POCPortal = (BlockPOCPortal) new BlockPOCPortal(MDMConfig.getBlock("POC Portal", 1007)).setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(-1F).setUnlocalizedName("POCPortal").setTextureName("POCPortal");
		
		Block.blocksList[Block.lavaStill.blockID] = null;
		ActivatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		DreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		AlchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(MDMConfig.getBlock("Alchemy Tube", 1011)).setUnlocalizedName("AlchemyTube").setTextureName("alchemyTube").setCreativeTab(MDMItems.tabAlchemy);
		
		// -- Heaven Blocks --
		
		stoneBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Stone Blocks", 202), Material.rock, new String[] { "Heavenstone", "Heaven Cobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Shrekite Block", "Clashium Block", "Blurite Block", "Holyium Block", "Pro Alloy Block" }, new String[] { "heavenstone", "heavenstone_cobble", "heavenstone_mossy", "shrekiteOre", "clashiumOre", "heavenBluriteOre", "holyiumOre", "shrekiteBlock", "clashiumBlock", "heavenBluriteBlock", "holyiumBlock", "proalloyBlock" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("heavenStoneBlocks");
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
		
		groundBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Ground Blocks", 203), Material.ground, new String[] { "Heaven Dirt" }, new String[] { "heavendirt" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("heavenGroundBlocks");
		heavenDirt = new ItemStack(groundBlocks, 1, 0);
		
		heavenGrass = (BlockHeavenGrass) (new BlockHeavenGrass(MDMConfig.getTerrainBlock("Heaven Grass", 204))).setUnlocalizedName("heavengrass").setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		
		woodBlocks = (CustomBlock) new CustomBlock(MDMConfig.getBlock("Heaven Wood Blocks", 1050), Material.wood, new String[] { "Heaven Planks", "Gold Wood Planks" }, new String[] { "heavenwoodPlanks", "goldwoodPlanks" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("heavenWoodBlocks");
		heavenwoodPlanks = new ItemStack(woodBlocks, 1, 0);
		goldwoodPlanks = new ItemStack(woodBlocks, 1, 1);
		
		plantBlocks = (CustomBlock) new BlockHeavenPlant(MDMConfig.getBlock("Heaven Plant Blocks", 1051), new String[] { "Blue Flower", "Orange Flower", "Ground Vine", "Round Plant" }, new String[] { "heavenplant_blue", "heavenplant_orange", "heavenplant_vine", "heavenplant_circle" }).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenPlantBlocks");
		blueFlower = new ItemStack(plantBlocks, 1, 0);
		orangeFlower = new ItemStack(plantBlocks, 1, 1);
		vinePlant = new ItemStack(plantBlocks, 1, 2);
		roundPlant = new ItemStack(plantBlocks, 1, 3);
		
		heavenPortal = (BlockHeavenPortal) (new BlockHeavenPortal(MDMConfig.getBlock("Heaven Portal", 1053))).setCreativeTab(MDMItems.tabHeavenBlocks).setUnlocalizedName("heavenPortal").setHardness(-1F).setLightValue(1F);
		heavenPortalFrame = (new BlockMDM(MDMConfig.getBlock("Heaven Portal Frame", 1054), Material.rock, MDMItems.tabHeavenBlocks)).setUnlocalizedName("heavenPortalFrame").setTextureName("heavenPortalFrame").setHardness(2F);
		
		heavenLogs = (BlockCustomLog) (new BlockCustomLog(MDMConfig.getBlock("Heaven Log", 1052), new String[] { "Heaven Wood Log", "Gold Wood Log" }, new String[] { "heavenwood_top", "goldwood_top" }, new String[] { "heavenwood_side", "goldwood_side" })).setUnlocalizedName("heavenLogs").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(2.0F);
		heavenLeaves = (BlockCustomLeaves) (new BlockCustomLeaves(MDMConfig.getBlock("Heaven Leaves", 1056), new String[] { "Heaven Wood Leaves", "Gold Wood Leaves" }, new String[] { "heavenwoodLeaves", "goldwoodLeaves" })).setUnlocalizedName("heavenLeaves").setCreativeTab(MDMItems.tabHeavenBlocks).setHardness(0.2F);
		heavenSaplings = (BlockHeavenSapling) (new BlockHeavenSapling(MDMConfig.getBlock("Heaven Sapling", 1057), new String[] { "Heaven Wood Sapling", "Gold Wood Sapling" }, new String[] { "heavenwoodSapling", "goldwoodSapling" })).setUnlocalizedName("heavenSaplings").setCreativeTab(MDMItems.tabHeavenBlocks);
		
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
		addBlock(POCPortalFrame, "Paradise Of Chaos Portal Frame");
		addBlock(POCPortal, "Paradise of Chaos Portal");
		addBlock(AlchemyTube, "Alchemy Tube");
		addBlock(ores1, "POC Ores 1");
		addBlock(ores2, "POC Ores 2");
		
		// -- Heaven --
		
		stoneBlocks.setHardnesses(new float[] { 1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F });
		stoneBlocks.setDrops(new ItemStack[] { new ItemStack(stoneBlocks, 1, 1), null, null, MDMItems.shrekiteShard, null, MDMItems.bluriteDust, null, null, null, null, null });
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
