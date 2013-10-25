package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomBlock;
import clashsoft.clashsoftapi.ItemCustomBlock;
import clashsoft.mods.moredimensions.block.*;

import com.chaosdev.paradiseofchaos.block.*;
import com.chaosdev.paradiseofchaos.lib.POCModPart;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

@POCModPart(modPartId = "Blocks")
public class POCBlocks
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
		ChaosStone = new Block(POCConfig.ChaosStone_ID, Material.rock).setCreativeTab(POCItems.PoCTab).setHardness(2.2F).setUnlocalizedName("ChaosStone").setTextureName("ChaosStone");
		
		// Altered Dirt
		AlteredDirt = (BlockAlteredDirt) new BlockAlteredDirt(POCConfig.AlteredDirt_ID, Material.ground).setUnlocalizedName("AlteredDirt").setCreativeTab(POCItems.PoCTab).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setTextureName("AlteredDirt");
		
		// Altered Grass
		AlteredGrass = (BlockAlteredGrass) new BlockAlteredGrass(POCConfig.AlteredGrass_ID, Material.grass).setUnlocalizedName("AlteredGrass").setCreativeTab(POCItems.PoCTab).setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
		
		// Saf Flower
		Herbs = ((BlockPOCHerb) new BlockPOCHerb(POCConfig.Safflower_ID, new String[] { "Saf Flower" }, new String[] { "Safflower" }).setUnlocalizedName("POCHerb").setCreativeTab(POCItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		
		// Magic Oak log
		MagicOakLog = (BlockMagicOakLog) new BlockMagicOakLog(POCConfig.MagicOakLog_ID).setUnlocalizedName("MagicOakLog").setCreativeTab(POCItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		
		// Magic Oak Sapling
		MagicOakSapling = (BlockMagicOakSapling) new BlockMagicOakSapling(POCConfig.MagicOakSapling_ID, 0).setUnlocalizedName("MagicOakSapling").setTextureName("MagicOakSapling").setCreativeTab(POCItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		
		// Magic Oak Leaves
		MagicOakLeaves = (BlockMagicOakLeaves) new BlockMagicOakLeaves(POCConfig.MagicOakLeaves_ID).setUnlocalizedName("MagicOakLeaves").setCreativeTab(POCItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		
		// Portal Frame
		PortalFrame = new BlockPOCPortalFrame(POCConfig.PortalFrame_ID).setCreativeTab(POCItems.PoCTab).setHardness(4F).setUnlocalizedName("POCPortalFrame").setTextureName("POCPortalFrame");
		
		// copper tin silver mithril adamanite blurite daeyalt rubium novite
		// bathus marmaros kratonium fractite zephyrium argonite katagon
		// gorgonite promethium
		Ores1 = (CustomBlock) new CustomBlock(POCConfig.Ores1_ID, Material.rock, new String[] { "Copper Ore", "Tin Ore", "Silver Ore", "Mithril Ore", "Adamanite Ore", "Blurite Ore", "Daeyalt Ore", "Rubium Ore", "Novite Ore", "Bathus Ore", "Marmaros Ore", "Kratonium Ore", "Fractite Ore", "Zephyrium Ore", "Argonite Ore", "Katagon Ore" }, new String[] { "CopperOre", "TinOre", "SilverOre", "MithrilOre", "AdamaniteOre", "BluriteOre", "DaeyaltOre", "RubiumOre", "NoviteOre", "BathusOre", "MarmarosOre", "KratoniumOre", "FractiteOre", "ZephyriumOre", "ArgoniteOre", "KatagonOre" }, new CreativeTabs[] { POCItems.PoCTab }).setUnlocalizedName("POCOres1");
		Ores2 = (CustomBlock) new CustomBlock(POCConfig.Ores2_ID, Material.rock, new String[] { "Gorgonite Ore", "Promethium Ore" }, new String[] { "GorgoniteOre", "PromethiumOre" }, new CreativeTabs[] { POCItems.PoCTab }).setUnlocalizedName("POCOres2");
		
		// Portal
		Portal = (BlockPOCPortal) new BlockPOCPortal(POCConfig.Portal_ID).setCreativeTab(POCItems.PoCTab).setHardness(-1F).setUnlocalizedName("POCPortal").setTextureName("POCPortal");
		
		// Willow Log
		WillowLog = (BlockWillowLog) new BlockWillowLog(POCConfig.WillowLog_ID).setUnlocalizedName("WillowLog").setCreativeTab(POCItems.PoCTab).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
		
		// Willow Leaves
		WillowLeaves = (BlockWillowLeaves) new BlockWillowLeaves(POCConfig.WillowLeaves_ID).setUnlocalizedName("WillowLeaves").setCreativeTab(POCItems.PoCTab).setStepSound(Block.soundGrassFootstep);
		
		// Willow Sapling
		WillowSapling = (BlockWillowSapling) new BlockWillowSapling(POCConfig.WillowSapling_ID, 0).setUnlocalizedName("WillowSapling").setTextureName("WillowSapling").setCreativeTab(POCItems.PoCTab).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		
		// Replace vanilla lava with portal activator lava
		Block.blocksList[Block.lavaStill.blockID] = null;
		ActivatorLava = (BlockPOCActivatorLava) new BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		
		Block.blocksList[Block.bed.blockID] = null;
		DreamBed = (BlockPOCDreamBed) new BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		;
		
		AlchemyTube = (BlockAlchemyTube) new BlockAlchemyTube(POCConfig.AlchemyTube_ID).setUnlocalizedName("AlchemyTube").setTextureName("AlchemyTube").setCreativeTab(POCItems.AlchemyTab);
		
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
