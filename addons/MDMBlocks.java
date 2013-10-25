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
	
	public static Block					ChaosStone;
	public static BlockAlteredDirt		AlteredDirt;
	public static BlockAlteredGrass		AlteredGrass;
	public static BlockPOCHerb			Herbs;
	public static BlockMagicOakLog		MagicOakLog;
	public static BlockMagicOakSapling	MagicOakSapling;
	public static BlockMagicOakLeaves	MagicOakLeaves;
	public static Block					PortalFrame;
	public static BlockPOCPortal		Portal;
	public static BlockPOCActivatorLava	ActivatorLava;
	public static BlockPOCDreamBed		DreamBed;
	public static BlockAlchemyTube		AlchemyTube;
	public static CustomBlock			Ores1;
	public static CustomBlock			Ores2;
	public static BlockWillowLog		WillowLog;
	public static BlockWillowLeaves		WillowLeaves;
	public static BlockWillowSapling	WillowSapling;
	
	// -- Heaven Blocks --
	
	public static BlockHeavenPortal		heavenPortal;
	public static Block					heavenPortalFrame;
	public static CustomBlock			stoneBlocks;
	public static CustomBlock			woodBlocks;
	public static CustomBlock			groundBlocks;
	public static CustomBlock			plantBlocks;
	public static Block					heavenLog;
	public static Block					heavenGrass;
	public static BlockHeavenLeaves		heavenLeaves;
	public static Block					heavenSapling;
	public static Block					heavenPillar;
	public static Block					compressor;
	
	public static void initialize()
	{
		// -- Paradise of Chaos Blocks --
		
		ChaosStone = new Block(MDMConfig.ChaosStone_ID, Material.rock).setCreativeTab(MDMItems.PoCTab).setHardness(2.2F).setUnlocalizedName("ChaosStone").setTextureName("ChaosStone");
		AlteredDirt = (BlockAlteredDirt) new BlockAlteredDirt(MDMConfig.AlteredDirt_ID, Material.ground).setUnlocalizedName("AlteredDirt").setCreativeTab(MDMItems.PoCTab).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setTextureName("AlteredDirt");
		AlteredGrass = (BlockAlteredGrass) new BlockAlteredGrass(MDMConfig.AlteredGrass_ID, Material.grass).setUnlocalizedName("AlteredGrass").setCreativeTab(MDMItems.PoCTab).setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		Herbs = ((BlockPOCHerb) new BlockPOCHerb(MDMConfig.Safflower_ID, new String[] { "Saf Flower" }, new String[] { "Safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		MagicOakLog = (BlockMagicOakLog) new BlockMagicOakLog(MDMConfig.MagicOakLog_ID).setUnlocalizedName("MagicOakLog").setCreativeTab(MDMItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		MagicOakSapling = (BlockMagicOakSapling) new BlockMagicOakSapling(MDMConfig.MagicOakSapling_ID, 0).setUnlocalizedName("MagicOakSapling").setTextureName("MagicOakSapling").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		MagicOakLeaves = (BlockMagicOakLeaves) new BlockMagicOakLeaves(MDMConfig.MagicOakLeaves_ID).setUnlocalizedName("MagicOakLeaves").setCreativeTab(MDMItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		PortalFrame = new BlockPOCPortalFrame(MDMConfig.PortalFrame_ID).setCreativeTab(MDMItems.PoCTab).setHardness(4F).setUnlocalizedName("POCPortalFrame").setTextureName("POCPortalFrame");
		Ores1 = (CustomBlock) new CustomBlock(MDMConfig.Ores1_ID, Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "CopperOre", "TinOre", "SilverOre", "MithrilOre", "AdamaniteOre", "BluriteOre", "DaeyaltOre", "RubiumOre", "NoviteOre", "BathusOre", "MarmarosOre", "KratoniumOre", "FractiteOre", "ZephyriumOre", "ArgoniteOre", "KatagonOre" }, new CreativeTabs[] { MDMItems.PoCTab }).setUnlocalizedName("POCOres1");
		Ores2 = (CustomBlock) new CustomBlock(MDMConfig.Ores2_ID, Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "GorgoniteOre", "PromethiumOre" }, new CreativeTabs[] { MDMItems.PoCTab }).setUnlocalizedName("POCOres2");
		Portal = (BlockPOCPortal) new BlockPOCPortal(MDMConfig.Portal_ID).setCreativeTab(MDMItems.PoCTab).setHardness(-1F).setUnlocalizedName("POCPortal").setTextureName("POCPortal");
		WillowLog = (BlockWillowLog) new BlockWillowLog(MDMConfig.WillowLog_ID).setUnlocalizedName("WillowLog").setCreativeTab(MDMItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		WillowLeaves = (BlockWillowLeaves) new BlockWillowLeaves(MDMConfig.WillowLeaves_ID).setUnlocalizedName("WillowLeaves").setCreativeTab(MDMItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		WillowSapling = (BlockWillowSapling) new BlockWillowSapling(MDMConfig.WillowSapling_ID, 0).setUnlocalizedName("WillowSapling").setTextureName("WillowSapling").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		
		Block.blocksList[Block.lavaStill.blockID] = null;
		ActivatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		DreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		AlchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(MDMConfig.AlchemyTube_ID).setUnlocalizedName("AlchemyTube").setTextureName("AlchemyTube").setCreativeTab(MDMItems.AlchemyTab);
		
		// -- Heaven Blocks --
		
		stoneBlocks = (CustomBlock) new CustomBlock(202, Material.rock, new String[] { "Heavenstone", "Heavencobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Sywoxite Block", "Clashium Block", "Blurite Block", "Holyium Block" }, new String[] { "heavenstone", "heavencobble", "heavencobble_mossy", "sywoxite_ore", "clashium_ore", "blurite_ore", "holyium_ore", "sywoxite_block", "clashium_block", "blurite_block", "holyium_block" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("heavenStoneBlocks");
		woodBlocks = (CustomBlock) new CustomBlock(203, Material.wood, new String[] { "Heavenplanks" }, new String[] { "heavenplanks" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("heavenWoodBlocks");
		groundBlocks = (CustomBlock) new CustomBlock(204, Material.ground, new String[] { "Heavendirt" }, new String[] { "heavendirt" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("heavenGroundBlocks");
		plantBlocks = (CustomBlock) new BlockHeavenPlant(205, new String[] { "Blue Flower", "Orange Flower", "Ground Vine", "Round Plant" }, new String[] { "heavenplant_blue", "heavenplant_orange", "heavenplant_vine", "heavenplant_circle" }).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenPlantBlocks");
		heavenLog = (new BlockHeavenLog(210)).setUnlocalizedName("heavenwood_side").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		heavenPortal = (BlockHeavenPortal) (new BlockHeavenPortal(200)).setUnlocalizedName("heavenportal").setHardness(-1F).setLightValue(1F);
		heavenPortalFrame = (new BlockHeavenPortalFrame(201)).setUnlocalizedName("heavenportal_frame").setHardness(2F);
		heavenGrass = (new BlockHeavenGrass(211)).setUnlocalizedName("heavengrass").setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		heavenLeaves = (BlockHeavenLeaves) (new BlockHeavenLeaves(212)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenleaves");
		heavenSapling = (new BlockHeavenSapling(213)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavensapling");
		heavenPillar = (new BlockHeavenPillar(214)).setUnlocalizedName("pillar").setHardness(1.75F);
		compressor = (new BlockHeavenCompressor(215)).setUnlocalizedName("heavenfurnace_top").setHardness(1.8F);
	}
	
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addBlock(ChaosStone, "Chaos Stone");
		addBlock(AlteredDirt, "Altered Dirt");
		addBlock(AlteredGrass, "Altered Grass");
		addBlock(Herbs, "POC Herbs", ItemCustomBlock.class);
		addBlock(MagicOakLog, "Magic Oak Log");
		addBlock(MagicOakSapling, "Magic Oak Sapling");
		addBlock(MagicOakLeaves, "Magic Oak Leaves");
		addBlock(PortalFrame, "Paradise Of Chaos Portal Frame");
		addBlock(Portal, "Paradise of Chaos Portal");
		addBlock(AlchemyTube, "Alchemy Tube");
		addBlock(Ores1, "POC Ores 1");
		addBlock(Ores2, "POC Ores 2");
		addBlock(WillowLog, "Willow Log");
		addBlock(WillowLeaves, "Willow Leaves");
		addBlock(WillowSapling, "Willow Sapling");
		
		// -- Heaven --
		
		stoneBlocks.setHardnesses(new float[] { 1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F }).setDrops(new ItemStack[] { new ItemStack(stoneBlocks, 1, 1), null, null, new ItemStack(MDMItems.sywoxiteShard, 1, 1), null, new ItemStack(MDMItems.bluriteDust, 1, 3), null, null, null, null, null });
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
		addBlock(compressor, "Compressor");
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
