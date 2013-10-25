package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomBlock;
import clashsoft.clashsoftapi.ItemCustomBlock;
import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

@Addon(modName = "MoreDimensionsMod", addonName = "Blocks")
public class MDMBlocks
{
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
	
	public static void loadBlocks()
	{
		// Chaos Stone
		ChaosStone = new Block(MDMConfig.ChaosStone_ID, Material.rock).setCreativeTab(MDMItems.PoCTab).setHardness(2.2F).setUnlocalizedName("ChaosStone").setTextureName("ChaosStone");
		
		// Altered Dirt
		AlteredDirt = (BlockAlteredDirt) new BlockAlteredDirt(MDMConfig.AlteredDirt_ID, Material.ground).setUnlocalizedName("AlteredDirt").setCreativeTab(MDMItems.PoCTab).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setTextureName("AlteredDirt");
		
		// Altered Grass
		AlteredGrass = (BlockAlteredGrass) new BlockAlteredGrass(MDMConfig.AlteredGrass_ID, Material.grass).setUnlocalizedName("AlteredGrass").setCreativeTab(MDMItems.PoCTab).setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		
		// Saf Flower
		Herbs = ((BlockPOCHerb) new BlockPOCHerb(MDMConfig.Safflower_ID, new String[] { "Saf Flower" }, new String[] { "Safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		
		// Magic Oak log
		MagicOakLog = (BlockMagicOakLog) new BlockMagicOakLog(MDMConfig.MagicOakLog_ID).setUnlocalizedName("MagicOakLog").setCreativeTab(MDMItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		
		// Magic Oak Sapling
		MagicOakSapling = (BlockMagicOakSapling) new BlockMagicOakSapling(MDMConfig.MagicOakSapling_ID, 0).setUnlocalizedName("MagicOakSapling").setTextureName("MagicOakSapling").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		
		// Magic Oak Leaves
		MagicOakLeaves = (BlockMagicOakLeaves) new BlockMagicOakLeaves(MDMConfig.MagicOakLeaves_ID).setUnlocalizedName("MagicOakLeaves").setCreativeTab(MDMItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		
		// Portal Frame
		PortalFrame = new BlockPOCPortalFrame(MDMConfig.PortalFrame_ID).setCreativeTab(MDMItems.PoCTab).setHardness(4F).setUnlocalizedName("POCPortalFrame").setTextureName("POCPortalFrame");
		
		// copper tin silver mithril adamanite blurite daeyalt rubium novite
		// bathus marmaros kratonium fractite zephyrium argonite katagon
		// gorgonite promethium
		Ores1 = (CustomBlock) new CustomBlock(MDMConfig.Ores1_ID, Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "CopperOre", "TinOre", "SilverOre", "MithrilOre", "AdamaniteOre", "BluriteOre", "DaeyaltOre", "RubiumOre", "NoviteOre", "BathusOre", "MarmarosOre", "KratoniumOre", "FractiteOre", "ZephyriumOre", "ArgoniteOre", "KatagonOre" }, new CreativeTabs[] { MDMItems.PoCTab }).setUnlocalizedName("POCOres1");
		Ores2 = (CustomBlock) new CustomBlock(MDMConfig.Ores2_ID, Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "GorgoniteOre", "PromethiumOre" }, new CreativeTabs[] { MDMItems.PoCTab }).setUnlocalizedName("POCOres2");
		
		// Portal
		Portal = (BlockPOCPortal) new BlockPOCPortal(MDMConfig.Portal_ID).setCreativeTab(MDMItems.PoCTab).setHardness(-1F).setUnlocalizedName("POCPortal").setTextureName("POCPortal");
		
		// Willow Log
		WillowLog = (BlockWillowLog) new BlockWillowLog(MDMConfig.WillowLog_ID).setUnlocalizedName("WillowLog").setCreativeTab(MDMItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		
		// Willow Leaves
		WillowLeaves = (BlockWillowLeaves) new BlockWillowLeaves(MDMConfig.WillowLeaves_ID).setUnlocalizedName("WillowLeaves").setCreativeTab(MDMItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		
		// Willow Sapling
		WillowSapling = (BlockWillowSapling) new BlockWillowSapling(MDMConfig.WillowSapling_ID, 0).setUnlocalizedName("WillowSapling").setTextureName("WillowSapling").setCreativeTab(MDMItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		
		// Replace vanilla lava with portal activator lava
		Block.blocksList[Block.lavaStill.blockID] = null;
		ActivatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		DreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		;
		
		AlchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(MDMConfig.AlchemyTube_ID).setUnlocalizedName("AlchemyTube").setTextureName("AlchemyTube").setCreativeTab(MDMItems.AlchemyTab);
		
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
