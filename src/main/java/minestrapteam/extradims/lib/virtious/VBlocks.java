package minestrapteam.extradims.lib.virtious;

import minestrapteam.extracore.block.*;
import minestrapteam.extracore.item.block.ItemCustomSlab;
import minestrapteam.extracore.item.stack.StackFactory;
import minestrapteam.extradims.block.virtious.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

import static minestrapteam.extradims.lib.virtious.Virtious.getTexture;

public class VBlocks
{
	public static Block				virtious_portal;
	
	public static Block				virtianstone;
	public static Block				virtianstone_cobbled;
	public static Block				virtianstone_bricks;
	public static Block				deepstone;
	public static Block				deepstone_mossy;
	public static Block				deepstone_bricks;
	public static Block				canyonstone;
	public static Block				canyonstone_bricks;
	
	public static Block				virtian_grass;
	public static Block				virtian_soil;
	public static Block				virtian_soil_tilled;
	public static Block				fine_gravel;
	
	public static Block				virtian_iron_ore;
	public static Block				tak_ore;
	public static Block				brazeum_ore;
	public static Block				aquieus_ore;
	public static Block				pluthorium_ore;
	public static Block				illuminous_ore;
	
	public static Block				deep_iron_ore;
	public static Block				deep_tak_ore;
	public static Block				deep_illuminous_ore;
	
	public static Block				tak_block;
	public static Block				brazeum_block;
	public static Block				aquieus_block;
	public static Block				pluthorium_block;
	public static Block				illuminous_block;
	
	public static Block				virtious_logs;
	public static Block				virtious_leaves;
	public static Block				virtious_saplings;
	public static Block				virtious_planks;
	
	public static Block				blue_torch;
	public static Block				green_torch;
	
	public static Block            virtious_flowers;
	public static BlockCustomCrops veer_crops;
	
	public static Block				virtious_acid;
	
	public static Block				fuel_cell;
	public static Block				rough_glass;
	
	public static Block           cytoid_wall;
	public static Block           cytoid_wall_dark;
	public static Block           cytoid_wall_long;
	public static BlockCustomSlab cytoid_floor;
	public static BlockCustomSlab cytoid_floor_double;
	
	public static Block           cytoid_glass;
	public static Block           cytoid_door;
	public static Block           cytoid_control_panel;
	public static BlockCustomLamp cytoid_lamp_off;
	public static BlockCustomLamp cytoid_lamp_on;
	public static Block           cytoid_lightstrip;
	
	public static void initBlocks()
	{
		virtious_portal = new BlockVirtiousPortal(null).setHardness(5.0F).setStepSound(Block.soundTypeStone);
		
		virtianstone = new VBlock(Material.rock).setHardness(1.5F).setStepSound(Block.soundTypeStone).setBlockTextureName(getTexture("virtianstone"));
		virtianstone_cobbled = new VBlock(Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockTextureName(getTexture("virtianstone_cobbled"));
		virtianstone_bricks = new VBlock(Material.rock).setHardness(3.0F).setBlockTextureName(getTexture("virtianstone_bricks"));
		
		deepstone = new VBlock(Material.rock).setHardness(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName(getTexture("deepstone"));
		deepstone_mossy = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.0F).setBlockTextureName(getTexture("deepstone_mossy"));
		deepstone_bricks = new VBlock(Material.rock).setHardness(5.0F).setBlockTextureName(getTexture("deepstone_bricks"));
		
		canyonstone = new VBlock(Material.rock).setHardness(2.0F).setResistance(0.3F).setBlockTextureName(getTexture("canyonstone"));
		canyonstone_bricks = new VBlock(Material.rock).setHardness(3.0F).setBlockTextureName(getTexture("canyonstone_bricks"));
		
		virtian_grass = new BlockCustomGrass(ICustomBlock.DEFAULT_NAMES, getTexture("mossy_soil")).setHardness(0.6F).setStepSound(Block.soundTypeGrass).setCreativeTab(Virtious.tabVirtiousBlocks);
		virtian_soil = new VBlock(Material.ground).setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockTextureName(getTexture("virtian_soil"));
		virtian_soil_tilled = new BlockCustomFarmland(virtian_soil).setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockTextureName(getTexture("virtian_soil_tilled"));
		fine_gravel = new BlockFalling().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setCreativeTab(Virtious.tabVirtiousBlocks).setBlockTextureName(getTexture("fine_gravel"));
		
		virtian_iron_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockTextureName(getTexture("virtian_iron_ore"));
		tak_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.2F).setResistance(5.2F).setBlockTextureName(getTexture("tak_ore"));
		brazeum_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockTextureName(getTexture("brazeum_ore"));
		aquieus_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(4.0F).setResistance(6.0F).setBlockTextureName(getTexture("aquieus_ore"));
		pluthorium_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(4.0F).setResistance(6.0F).setBlockTextureName(getTexture("pluthorium_ore"));
		illuminous_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.0F).setLightLevel(0.8F).setBlockTextureName(getTexture("illuminous_ore"));
		
		deep_iron_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.5F).setResistance(8.5F).setBlockTextureName(getTexture("deep_iron_ore"));
		deep_tak_ore = new BlockTakOre(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.0F).setResistance(0.8F).setBlockTextureName(getTexture("deep_tak_ore"));
		deep_illuminous_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.0F).setResistance(8.0F).setLightLevel(0.8F).setBlockTextureName(getTexture("deep_illuminous_ore"));
		
		tak_block = new BlockTakOre(Material.rock).setHardness(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName(getTexture("tak_block"));
		brazeum_block = new VBlock(Material.iron).setHardness(3.0F).setBlockTextureName(getTexture("brazeum_block"));
		aquieus_block = new VBlock(Material.iron).setHardness(3.0F).setBlockTextureName(getTexture("aquieus_block"));
		pluthorium_block = new VBlock(Material.iron).setHardness(3.0F).setBlockTextureName(getTexture("pluthorium_block"));
		illuminous_block = new VBlock(Material.rock).setHardness(3.0F).setLightLevel(1.0F).setBlockTextureName(getTexture("illuminous_block"));
		
		String[] woodTypes = new String[] { "virtianwood", "amberwood" };
		virtious_logs = new BlockCustomLog(woodTypes, new String[] { getTexture("virtianwood_log_top"), getTexture("amberwood_log_top") }, new String[] { getTexture("virtianwood_log_side"), getTexture("amberwood_log_side") }).setHardness(2.0F).setCreativeTab(Virtious.tabVirtiousBlocks);
		virtious_leaves = new BlockCustomLeaves(woodTypes, new String[] { getTexture("virtianwood_leaves"), getTexture("amberwood_leaves") }).setHardness(0.2F).setCreativeTab(Virtious.tabVirtiousBlocks);
		virtious_saplings = new BlockVirtiousSapling(woodTypes, new String[] { getTexture("virtianwood_sapling"), getTexture("amberwood_sapling") });
		virtious_planks = new CustomBlock(Material.wood, woodTypes, new String[] { getTexture("virtianwood_planks"), getTexture("amberwood_planks") }, null).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Virtious.tabVirtiousBlocks);
		
		blue_torch = new VBlockTorch().setHardness(0.0F).setLightLevel(0.85F).setStepSound(Block.soundTypeWood).setBlockTextureName(getTexture("blue_mushroom_torch"));
		green_torch = new VBlockTorch().setHardness(0.0F).setLightLevel(0.8F).setStepSound(Block.soundTypeWood).setBlockTextureName(getTexture("green_mushroom_torch"));
		
		virtious_flowers = new BlockVirtiousFlowers(new String[] { "veer_flower", "nightwhisker", "blue_mushroom", "green_mushroom" }, new String[] { getTexture("veer_flower"), getTexture("nightwhisker"), getTexture("glowing_blue_mushroom"), getTexture("glowing_green_mushroom") }).setStepSound(Block.soundTypeGrass).setLightLevel(0.4F);
		veer_crops = (BlockCustomCrops) new BlockVeerCrops().setBlockTextureName(getTexture("veer_crops"));
		
		virtious_acid = new BlockVirtiousAcid().setHardness(100.0F).setLightOpacity(3);
		
		fuel_cell = new BlockFuelCell(Material.rock).setHardness(3.0F);
		rough_glass = new BlockCustomGlass(Material.glass, ICustomBlock.DEFAULT_NAMES, getTexture("rough_glass")).setTransparent(true).setCreativeTab(Virtious.tabVirtiousBlocks);
		
		cytoid_wall = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setBlockTextureName(getTexture("cytoid_wall"));
		cytoid_wall_dark = new CustomBlock(Material.iron, new String[] { null, null, null, null }, new String[] { getTexture("cytoid_wall_dark_1"), getTexture("cytoid_wall_dark_2"), getTexture("cytoid_wall_dark_3"), getTexture("cytoid_wall_dark_4") }, null).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeStone).setCreativeTab(Virtious.tabVirtiousBlocks);
		cytoid_wall_long = new BlockCytoidLongWall().setHardness(3F).setResistance(8F);
		cytoid_floor = (BlockCustomSlab) new BlockCytoidFloor(false).setHardness(1.8F).setCreativeTab(Virtious.tabVirtiousBlocks);
		cytoid_floor_double = (BlockCustomSlab) new BlockCytoidFloor(true).setHardness(1.8F).setCreativeTab(null);
		BlockCustomSlab.bind(cytoid_floor, cytoid_floor_double);
		
		cytoid_glass = new BlockCustomGlass(Material.glass, ICustomBlock.DEFAULT_NAMES, getTexture("cytoid_glass")).setCreativeTab(Virtious.tabVirtiousBlocks);
		cytoid_door = new BlockCytoidDoor(Material.iron).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName(getTexture("cytoid_door"));
		cytoid_control_panel = new BlockCytoidControlPanel().setCreativeTab(Virtious.tabVirtiousBlocks).setHardness(3.0F);
		
		cytoid_lamp_off = (BlockCustomLamp) new BlockCytoidLamp(false).setHardness(0.8F).setCreativeTab(Virtious.tabVirtiousBlocks);
		cytoid_lamp_on = (BlockCustomLamp) new BlockCytoidLamp(true).setHardness(0.8F);
		BlockCustomLamp.bind(cytoid_lamp_off, cytoid_lamp_on);
		cytoid_lightstrip = new BlockCytoidLightstrip().setHardness(0.8F);
		
		tak_ore.setHarvestLevel("pickaxe", 1);
		brazeum_ore.setHarvestLevel("pickaxe", 1);
		deepstone.setHarvestLevel("pickaxe", 2);
		deepstone_mossy.setHarvestLevel("pickaxe", 2);
		pluthorium_ore.setHarvestLevel("pickaxe", 3);
		deep_illuminous_ore.setHarvestLevel("pickaxe", 2);
		deep_iron_ore.setHarvestLevel("pickaxe", 2);
		deep_tak_ore.setHarvestLevel("pickaxe", 2);
	}
	
	public static void registerBlocks()
	{
		ECBlocks.addBlock(virtious_portal, "virtious_portal");
		
		ECBlocks.addBlock(virtianstone, "virtianstone");
		ECBlocks.addBlock(virtianstone_cobbled, "virtianstone_cobbled");
		ECBlocks.addBlock(virtianstone_bricks, "virtianstone_bricks");
		ECBlocks.addBlock(deepstone, "deepstone");
		ECBlocks.addBlock(deepstone_mossy, "deepstone_mossy");
		ECBlocks.addBlock(deepstone_bricks, "deepstone_bricks");
		ECBlocks.addBlock(canyonstone, "canyonstone");
		ECBlocks.addBlock(canyonstone_bricks, "canyonstone_bricks");
		
		ECBlocks.addBlock(virtian_grass, "virtian_grass");
		ECBlocks.addBlock(virtian_soil, "virtian_soil");
		ECBlocks.addBlock(virtian_soil_tilled, "virtian_soil_tilled");
		ECBlocks.addBlock(fine_gravel, "fine_gravel");
		
		ECBlocks.addBlock(virtian_iron_ore, "virtian_iron_ore");
		ECBlocks.addBlock(tak_ore, "tak_ore");
		ECBlocks.addBlock(brazeum_ore, "brazeum_ore");
		ECBlocks.addBlock(aquieus_ore, "aquieus_ore");
		ECBlocks.addBlock(pluthorium_ore, "pluthorium_ore");
		ECBlocks.addBlock(illuminous_ore, "illuminous_ore");
		
		ECBlocks.addBlock(deep_iron_ore, "deep_iron_ore");
		ECBlocks.addBlock(deep_tak_ore, "deep_tak_ore");
		ECBlocks.addBlock(deep_illuminous_ore, "deep_illuminous_ore");
		
		ECBlocks.addBlock(tak_block, "tak_block");
		ECBlocks.addBlock(brazeum_block, "brazeum_block");
		ECBlocks.addBlock(aquieus_block, "aquieus_block");
		ECBlocks.addBlock(pluthorium_block, "pluthorium_block");
		ECBlocks.addBlock(illuminous_block, "illuminous_block");
		
		ECBlocks.addBlock(virtious_logs, "virtious_logs");
		ECBlocks.addBlock(virtious_leaves, "virtious_leaves");
		ECBlocks.addBlock(virtious_saplings, "virtious_saplings");
		ECBlocks.addBlock(virtious_planks, "virtious_planks");
		
		ECBlocks.addBlock(blue_torch, "blue_torch");
		ECBlocks.addBlock(green_torch, "green_torch");
		
		ECBlocks.addBlock(virtious_flowers, "virtious_flowers");
		ECBlocks.addBlock(veer_crops, "veer_crops");
		
		ECBlocks.addBlock(virtious_acid, "virtious_acid");
		
		ECBlocks.addBlock(fuel_cell, "fuel_cell");
		ECBlocks.addBlock(rough_glass, "rough_glass");
		
		ECBlocks.addBlock(cytoid_wall, "cytoid_wall");
		ECBlocks.addBlock(cytoid_wall_dark, "cytoid_wall_dark");
		ECBlocks.addBlock(cytoid_wall_long, "cytoid_wall_long");
		ECBlocks.addBlock(cytoid_floor, ItemCustomSlab.class, "cytoid_floor");
		ECBlocks.addBlock(cytoid_floor_double, "cytoid_floor_double");
		
		ECBlocks.addBlock(cytoid_glass, "cytoid_glass");
		ECBlocks.addBlock(cytoid_door, "cytoid_door");
		ECBlocks.addBlock(cytoid_control_panel, "cytoid_control_panel");
		ECBlocks.addBlock(cytoid_lamp_off, "cytoid_lamp_off");
		ECBlocks.addBlock(cytoid_lamp_on, "cytoid_lamp_on");
		ECBlocks.addBlock(cytoid_lightstrip, "cytoid_lightstrip");
		
		veer_crops.setSeed(StackFactory.create(VItems.veer_seeds)).setCrop(StackFactory.create(VItems.veer_dye));
	}
}
