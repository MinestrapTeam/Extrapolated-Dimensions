package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomBlock;
import clashsoft.clashsoftapi.ItemCustomBlock;
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
	public static BlockMagicOakLog		magicOakLog;
	public static BlockMagicOakSapling	magicOakSapling;
	public static BlockMagicOakLeaves	magicOakLeaves;
	public static Block					POCPortalFrame;
	public static BlockPOCPortal		POCPortal;
	public static BlockPOCActivatorLava	ActivatorLava;
	public static BlockPOCDreamBed		DreamBed;
	public static BlockAlchemyTube		AlchemyTube;
	public static CustomBlock			ores1;
	public static CustomBlock			ores2;
	public static BlockWillowLog		willowLog;
	public static BlockWillowLeaves		willowLeaves;
	public static BlockWillowSapling	willowSapling;
	
	// -- Heaven Blocks --
	
	public static BlockHeavenPortal		heavenPortal;
	public static Block					heavenPortalFrame;
	public static CustomBlock			stoneBlocks;
	public static CustomBlock			woodBlocks;
	public static CustomBlock			groundBlocks;
	public static CustomBlock			plantBlocks;
	public static BlockHeavenLog		heavenLog;
	public static BlockHeavenGrass		heavenGrass;
	public static BlockHeavenLeaves		heavenLeaves;
	public static BlockHeavenSapling	heavenSapling;
	public static BlockHeavenPillar		heavenPillar;
	
	public static ItemStack				heavenPlanks;
	
	public static ItemStack				heavenDirt;
	
	public static ItemStack				blueFlower, orangeFlower, vinePlant, roundPlant;
	
	public static ItemStack				heavenStone, heavenCobble, heavenCobbleMossy;
	public static ItemStack				shrekiteOre, clashiumOre, bluriteOre, holyiumOre;
	public static ItemStack				shrekiteBlock, clashiumBlock, bluriteBlock, holyiumBlock, proAlloyBlock;
	
	public static void initialize()
	{
		// -- Paradise of Chaos Blocks --
		
		chaosStone = new Block(MDMConfig.getTerrainBlock("Chaos Stone", 180), Material.rock).setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(2.2F).setUnlocalizedName("ChaosStone").setTextureName("ChaosStone");
		alteredDirt = (BlockAlteredDirt) new BlockAlteredDirt(MDMConfig.getTerrainBlock("Altered Dirt", 181), Material.ground).setUnlocalizedName("AlteredDirt").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setTextureName("AlteredDirt");
		alteredGrass = (BlockAlteredGrass) new BlockAlteredGrass(MDMConfig.getTerrainBlock("Altered Grass", 182), Material.grass).setUnlocalizedName("AlteredGrass").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		
		herbs = ((BlockPOCHerb) new BlockPOCHerb(MDMConfig.getBlock("POC Herbs", 1000), new String[] { "Saf Flower" }, new String[] { "safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		magicOakLog = (BlockMagicOakLog) new BlockMagicOakLog(MDMConfig.getBlock("Magic Oak Log", 1001)).setUnlocalizedName("MagicOakLog").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		magicOakSapling = (BlockMagicOakSapling) new BlockMagicOakSapling(MDMConfig.getBlock("Magic Oak Sapling", 1002), 0).setUnlocalizedName("MagicOakSapling").setTextureName("MagicOakSapling").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		magicOakLeaves = (BlockMagicOakLeaves) new BlockMagicOakLeaves(MDMConfig.getBlock("Magic Oak Leaves", 1003)).setUnlocalizedName("MagicOakLeaves").setCreativeTab(MDMItems.tabParadiseOfChaos).setStepSound(Block.soundGrassFootstep);
		POCPortalFrame = new BlockPOCPortalFrame(MDMConfig.getBlock("POC Portal Frame", 1004)).setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(4F).setUnlocalizedName("POCPortalFrame").setTextureName("POCPortalFrame");
		ores1 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 1", 1005), Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "CopperOre", "TinOre", "SilverOre", "MithrilOre", "AdamaniteOre", "BluriteOre", "DaeyaltOre", "RubiumOre", "NoviteOre", "BathusOre", "MarmarosOre", "KratoniumOre", "FractiteOre", "ZephyriumOre", "ArgoniteOre", "KatagonOre" }, new CreativeTabs[] { MDMItems.tabParadiseOfChaos }).setUnlocalizedName("POCOres1");
		ores2 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 2", 1006), Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "GorgoniteOre", "PromethiumOre" }, new CreativeTabs[] { MDMItems.tabParadiseOfChaos }).setUnlocalizedName("POCOres2");
		POCPortal = (BlockPOCPortal) new BlockPOCPortal(MDMConfig.getBlock("POC Portal", 1007)).setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(-1F).setUnlocalizedName("POCPortal").setTextureName("POCPortal");
		willowLog = (BlockWillowLog) new BlockWillowLog(MDMConfig.getBlock("Willow Log", 1008)).setUnlocalizedName("WillowLog").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		willowLeaves = (BlockWillowLeaves) new BlockWillowLeaves(MDMConfig.getBlock("Willow Leaves", 1009)).setUnlocalizedName("WillowLeaves").setCreativeTab(MDMItems.tabParadiseOfChaos).setStepSound(Block.soundGrassFootstep);
		willowSapling = (BlockWillowSapling) new BlockWillowSapling(MDMConfig.getBlock("Willow Sapling", 1010), 0).setUnlocalizedName("WillowSapling").setTextureName("WillowSapling").setCreativeTab(MDMItems.tabParadiseOfChaos).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		
		Block.blocksList[Block.lavaStill.blockID] = null;
		ActivatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		DreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		AlchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(MDMConfig.getBlock("Alchemy Tube", 1011)).setUnlocalizedName("AlchemyTube").setTextureName("AlchemyTube").setCreativeTab(MDMItems.tabAlchemy);
		
		// -- Heaven Blocks --
		
		stoneBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Stone Blocks", 202), Material.rock, new String[] { "Heavenstone", "Heaven Cobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Shrekite Block", "Clashium Block", "Blurite Block", "Holyium Block", "Pro Alloy Block" }, new String[] { "heavenstone", "heavencobble", "heavencobble_mossy", "shrekite_ore", "clashium_ore", "blurite_ore", "holyium_ore", "shrekite_block", "clashium_block", "blurite_block", "holyium_block", "proalloy_block" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("heavenStoneBlocks");
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
		
		woodBlocks = (CustomBlock) new CustomBlock(MDMConfig.getBlock("Heaven Wood Blocks", 1050), Material.wood, new String[] { "Heaven Planks" }, new String[] { "heavenplanks" }, new CreativeTabs[] { MDMItems.tabHeavenBlocks }).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("heavenWoodBlocks");
		heavenPlanks = new ItemStack(woodBlocks, 1, 0);
		
		plantBlocks = (CustomBlock) new BlockHeavenPlant(MDMConfig.getBlock("Heaven Plant Blocks", 1051), new String[] { "Blue Flower", "Orange Flower", "Ground Vine", "Round Plant" }, new String[] { "heavenplant_blue", "heavenplant_orange", "heavenplant_vine", "heavenplant_circle" }).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenPlantBlocks");
		blueFlower = new ItemStack(plantBlocks, 1, 0);
		orangeFlower = new ItemStack(plantBlocks, 1, 1);
		vinePlant = new ItemStack(plantBlocks, 1, 2);
		roundPlant = new ItemStack(plantBlocks, 1, 3);
		
		heavenLog = (BlockHeavenLog) (new BlockHeavenLog(MDMConfig.getBlock("Heaven Log", 1052))).setUnlocalizedName("heavenwood_side").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		heavenPortal = (BlockHeavenPortal) (new BlockHeavenPortal(MDMConfig.getBlock("Heaven Portal", 1053))).setCreativeTab(MDMItems.tabHeavenBlocks).setUnlocalizedName("heavenportal").setHardness(-1F).setLightValue(1F);
		heavenPortalFrame = (new BlockMDM(MDMConfig.getBlock("Heaven Portal Frame", 1054), Material.rock, MDMItems.tabHeavenBlocks)).setUnlocalizedName("heavenportal_frame").setTextureName("heavenportal_frame").setHardness(2F);
		heavenLeaves = (BlockHeavenLeaves) (new BlockHeavenLeaves(MDMConfig.getBlock("Heaven Leaves", 1056))).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenleaves");
		heavenSapling = (BlockHeavenSapling) (new BlockHeavenSapling(MDMConfig.getBlock("Heaven Sapling", 1057))).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavensapling");
		heavenPillar = (BlockHeavenPillar) (new BlockHeavenPillar(MDMConfig.getBlock("Heaven Pillar", 1058))).setUnlocalizedName("pillar").setHardness(1.75F);
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addBlock(chaosStone, "Chaos Stone");
		addBlock(alteredDirt, "Altered Dirt");
		addBlock(alteredGrass, "Altered Grass");
		addBlock(herbs, "POC Herbs", ItemCustomBlock.class);
		herbs.addNames();
		addBlock(magicOakLog, "Magic Oak Log");
		addBlock(magicOakSapling, "Magic Oak Sapling");
		addBlock(magicOakLeaves, "Magic Oak Leaves");
		addBlock(POCPortalFrame, "Paradise Of Chaos Portal Frame");
		addBlock(POCPortal, "Paradise of Chaos Portal");
		addBlock(AlchemyTube, "Alchemy Tube");
		addBlock(ores1, "POC Ores 1");
		addBlock(ores2, "POC Ores 2");
		addBlock(willowLog, "Willow Log");
		addBlock(willowLeaves, "Willow Leaves");
		addBlock(willowSapling, "Willow Sapling");
		
		// -- Heaven --
		
		stoneBlocks.setHardnesses(new float[] { 1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F });
		stoneBlocks.setDrops(new ItemStack[] { new ItemStack(stoneBlocks, 1, 1), null, null, MDMItems.shrekiteShard, null, MDMItems.bluriteDust, null, null, null, null, null });
		woodBlocks.setHardnesses(new float[] { 2.0F });
		groundBlocks.setHardnesses(new float[] { 0.5F });
		plantBlocks.setHardnesses(new float[] { 0F, 0F, 0F, 0F });
		
		addBlock(stoneBlocks, "MDM.StoneBlocks");
		addBlock(woodBlocks, "MDM.WoodBlocks");
		addBlock(groundBlocks, "MDM.GroundBlocks");
		addBlock(plantBlocks, "MDM.PlantBlocks");
		addBlock(heavenPortalFrame, "Heaven Portal Frame");
		addBlock(heavenPortal, "Heaven Portal");
		addBlock(heavenGrass, "Heaven Grass");
		addBlock(heavenLog, "Heaven Wood");
		addBlock(heavenLeaves, "Heaven Tree Leaves");
		addBlock(heavenSapling, "Heaven Tree Sapling");
		addBlock(heavenPillar, "Heaven Pillar");
	}
	
	public static void addBlock(Block block, String name)
	{
		addBlock(block, name, block instanceof CustomBlock ? ItemCustomBlock.class : ItemBlock.class);
	}
	
	public static void addBlock(Block block, String name, Class<? extends ItemBlock> itemClass)
	{
		GameRegistry.registerBlock(block, itemClass, name);
		LanguageRegistry.addName(block, name);
		if (block instanceof CustomBlock)
			((CustomBlock) block).addNames();
	}
}
