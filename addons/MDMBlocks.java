package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomBlock;
import clashsoft.clashsoftapi.ItemCustomBlock;
import clashsoft.clashsoftapi.util.addons.Addon;
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
	
	public static void initialize()
	{
		// -- Paradise of Chaos Blocks --
		
		chaosStone = new Block(MDMConfig.getTerrainBlock("Chaos Stone", 180), Material.rock).setCreativeTab(MDMItems.PoCTab).setHardness(2.2F).setUnlocalizedName("ChaosStone").setTextureName("ChaosStone");
		alteredDirt = (BlockAlteredDirt) new BlockAlteredDirt(MDMConfig.getTerrainBlock("Altered Dirt", 181), Material.ground).setUnlocalizedName("AlteredDirt").setCreativeTab(MDMItems.PoCTab).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setTextureName("AlteredDirt");
		alteredGrass = (BlockAlteredGrass) new BlockAlteredGrass(MDMConfig.getTerrainBlock("Altered Grass", 182), Material.grass).setUnlocalizedName("AlteredGrass").setCreativeTab(MDMItems.PoCTab).setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		herbs = ((BlockPOCHerb) new BlockPOCHerb(MDMConfig.getBlock("POC Herbs", 183), new String[] { "Saf Flower" }, new String[] { "Safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		magicOakLog = (BlockMagicOakLog) new BlockMagicOakLog(MDMConfig.getBlock("Magic Oak Log", 184)).setUnlocalizedName("MagicOakLog").setCreativeTab(MDMItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		magicOakSapling = (BlockMagicOakSapling) new BlockMagicOakSapling(MDMConfig.getBlock("Magic Oak Sapling", 185), 0).setUnlocalizedName("MagicOakSapling").setTextureName("MagicOakSapling").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		magicOakLeaves = (BlockMagicOakLeaves) new BlockMagicOakLeaves(MDMConfig.getBlock("Magic Oak Leaves", 186)).setUnlocalizedName("MagicOakLeaves").setCreativeTab(MDMItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		POCPortalFrame = new BlockPOCPortalFrame(MDMConfig.getBlock("POC Portal Frame", 187)).setCreativeTab(MDMItems.PoCTab).setHardness(4F).setUnlocalizedName("POCPortalFrame").setTextureName("POCPortalFrame");
		ores1 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 1", 188), Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "CopperOre", "TinOre", "SilverOre", "MithrilOre", "AdamaniteOre", "BluriteOre", "DaeyaltOre", "RubiumOre", "NoviteOre", "BathusOre", "MarmarosOre", "KratoniumOre", "FractiteOre", "ZephyriumOre", "ArgoniteOre", "KatagonOre" }, new CreativeTabs[] { MDMItems.PoCTab }).setUnlocalizedName("POCOres1");
		ores2 = (CustomBlock) new CustomBlock(MDMConfig.getBlock("POC Ores 2", 189), Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "GorgoniteOre", "PromethiumOre" }, new CreativeTabs[] { MDMItems.PoCTab }).setUnlocalizedName("POCOres2");
		POCPortal = (BlockPOCPortal) new BlockPOCPortal(MDMConfig.getBlock("POC Portal", 190)).setCreativeTab(MDMItems.PoCTab).setHardness(-1F).setUnlocalizedName("POCPortal").setTextureName("POCPortal");
		willowLog = (BlockWillowLog) new BlockWillowLog(MDMConfig.getBlock("Willow Log", 191)).setUnlocalizedName("WillowLog").setCreativeTab(MDMItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		willowLeaves = (BlockWillowLeaves) new BlockWillowLeaves(MDMConfig.getBlock("Willow Leaves", 192)).setUnlocalizedName("WillowLeaves").setCreativeTab(MDMItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		willowSapling = (BlockWillowSapling) new BlockWillowSapling(MDMConfig.getBlock("Willow Sapling", 193), 0).setUnlocalizedName("WillowSapling").setTextureName("WillowSapling").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		
		Block.blocksList[Block.lavaStill.blockID] = null;
		ActivatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		DreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		AlchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(MDMConfig.getBlock("Alchemy Tube", 194)).setUnlocalizedName("AlchemyTube").setTextureName("AlchemyTube").setCreativeTab(MDMItems.AlchemyTab);
		
		// -- Heaven Blocks --
		
		stoneBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Stone Blocks", 202), Material.rock, new String[] { "Heavenstone", "Heavencobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Sywoxite Block", "Clashium Block", "Blurite Block", "Holyium Block" }, new String[] { "heavenstone", "heavencobble", "heavencobble_mossy", "sywoxite_ore", "clashium_ore", "blurite_ore", "holyium_ore", "sywoxite_block", "clashium_block", "blurite_block", "holyium_block" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("heavenStoneBlocks");
		woodBlocks = (CustomBlock) new CustomBlock(MDMConfig.getBlock("Heaven Wood Blocks", 203), Material.wood, new String[] { "Heavenplanks" }, new String[] { "heavenplanks" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("heavenWoodBlocks");
		groundBlocks = (CustomBlock) new CustomBlock(MDMConfig.getTerrainBlock("Heaven Ground Blocks", 204), Material.ground, new String[] { "Heavendirt" }, new String[] { "heavendirt" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("heavenGroundBlocks");
		plantBlocks = (CustomBlock) new BlockHeavenPlant(MDMConfig.getBlock("Heaven Plant Blocks", 205), new String[] { "Blue Flower", "Orange Flower", "Ground Vine", "Round Plant" }, new String[] { "heavenplant_blue", "heavenplant_orange", "heavenplant_vine", "heavenplant_circle" }).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenPlantBlocks");
		heavenLog = (BlockHeavenLog) (new BlockHeavenLog(MDMConfig.getBlock("Heaven Log", 210))).setUnlocalizedName("heavenwood_side").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		heavenPortal = (BlockHeavenPortal) (new BlockHeavenPortal(MDMConfig.getBlock("Heaven Portal", 200))).setUnlocalizedName("heavenportal").setHardness(-1F).setLightValue(1F);
		heavenPortalFrame = (new BlockHeavenPortalFrame(MDMConfig.getBlock("Heaven Portal Frame", 201))).setUnlocalizedName("heavenportal_frame").setTextureName("heavenportal_frame").setHardness(2F);
		heavenGrass = (BlockHeavenGrass) (new BlockHeavenGrass(MDMConfig.getBlock("Heaven Grass", 211))).setUnlocalizedName("heavengrass").setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		heavenLeaves = (BlockHeavenLeaves) (new BlockHeavenLeaves(MDMConfig.getBlock("Heaven Leaves", 212))).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenleaves");
		heavenSapling = (BlockHeavenSapling) (new BlockHeavenSapling(MDMConfig.getBlock("Heaven Sapling", 213))).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavensapling");
		heavenPillar = (BlockHeavenPillar) (new BlockHeavenPillar(MDMConfig.getBlock("Heaven Pillar", 214))).setUnlocalizedName("pillar").setHardness(1.75F);
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addBlock(chaosStone, "Chaos Stone");
		addBlock(alteredDirt, "Altered Dirt");
		addBlock(alteredGrass, "Altered Grass");
		addBlock(herbs, "POC Herbs", ItemCustomBlock.class);
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
		stoneBlocks.setDrops(new ItemStack[] { new ItemStack(stoneBlocks, 1, 1), null, null, new ItemStack(MDMItems.shrekiteShard, 1, 1), null, new ItemStack(MDMItems.bluriteDust, 1, 3), null, null, null, null, null });
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
