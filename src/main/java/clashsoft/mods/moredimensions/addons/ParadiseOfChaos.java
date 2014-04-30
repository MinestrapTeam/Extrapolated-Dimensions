package clashsoft.mods.moredimensions.addons;

import static clashsoft.cslib.minecraft.crafting.CSCrafting.addPlanks;
import static clashsoft.cslib.minecraft.crafting.CSCrafting.addRecipe;
import static clashsoft.cslib.minecraft.crafting.CSCrafting.addStick;
import cpw.mods.fml.common.registry.EntityRegistry;
import clashsoft.cslib.minecraft.block.*;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.CSStacks;
import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.cslib.minecraft.util.CSString;
import clashsoft.mods.moredimensions.block.poc.BlockPOCPortal;
import clashsoft.mods.moredimensions.block.poc.BlockPOCSapling;
import clashsoft.mods.moredimensions.entity.boss.EntityLich;
import clashsoft.mods.moredimensions.item.poc.ItemManaStar;
import clashsoft.mods.moredimensions.item.poc.ItemStaff;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class ParadiseOfChaos
{
	public static CustomCreativeTab		tabBlocks	= new CustomCreativeTab("poc_blocks");
	public static CustomCreativeTab		tabItems	= new CustomCreativeTab("poc_items");
	public static CustomCreativeTab		tabTools	= new CustomCreativeTab("poc_tools");
	public static CustomCreativeTab		tabArmor	= new CustomCreativeTab("poc_armor");
	
	// Items
	
	public static ItemStaff				staff;
	public static ItemManaStar			manaStar;
	
	public static CustomItem			pocMaterials;
	
	// Blocks
	
	public static BlockCustomPortal		pocPortal;
	public static Block					pocPortalFrame;
	
	public static CustomBlock			pocStoneBlocks;
	public static CustomBlock			pocBloodStoneBlocks;
	public static CustomBlock			pocDirtBlocks;
	public static BlockCustomGrass		pocGrassBlocks;
	
	public static CustomBlock			pocOres;
	public static CustomBlock			pocBloodOres;
	
	public static BlockCustomLog		pocLogs;
	public static BlockCustomSapling	pocSaplings;
	public static BlockCustomLeaves		pocLeaves;
	public static CustomBlock			pocPlanks;
	
	public static BlockCustomPlant		pocPlantBlocks;
	
	// public static BlockPOCActivatorLava activatorLava;
	// public static BlockPOCDreamBed dreamBed;
	
	// Item Stacks
	
	public static ItemStack				magicOakStick, willowStick, promethiumGem, noviteGem, marmarosGem, kratoniumIngot;
	
	// Block Stacks
	
	public static ItemStack				chaosStone;
	
	public static ItemStack				magicOakLog, willowLog;
	public static ItemStack				magicOakLeaves, willowLeaves;
	public static ItemStack				magicOakSapling, willowSapling;
	public static ItemStack				magicOakPlanks, willowPlanks;
	
	public static void init()
	{
		// Items
		
		staff = (ItemStaff) new ItemStaff().setCreativeTab(tabTools);
		manaStar = (ItemManaStar) new ItemManaStar().setTextureName("mdm_poc:mana_star").setCreativeTab(tabItems);
		pocMaterials = (CustomItem) new CustomItem(new String[] { "magic_oak_stick", "willow_stick", "promethium_gem", "novite_gem", "kratonium_ingot" }, "mdm_poc").setCreativeTab(tabItems);
		
		// Blocks
		
		pocPortal = (BlockCustomPortal) new BlockPOCPortal("poc_portal", "mdm_poc:poc_portal").setCreativeTab(tabBlocks).setHardness(-1F);
		pocPortalFrame = new BlockImpl(Material.rock, "poc_portal_frame", "mdm_poc:poc_portal_frame").setCreativeTab(tabBlocks);
		
		pocStoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { "chaos_stone", "chaos_cobble", "chaos_stone_dark", "chaos_cobble_dark" }, "mdm_poc", null).setCreativeTab(tabBlocks);
		pocBloodStoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { "blood_stone", "blood_cobble", "blood_cobble_bloody", "blood_brick" }, "mdm_poc", null).setCreativeTab(tabBlocks);
		
		pocDirtBlocks = (CustomBlock) new CustomBlock(Material.ground, new String[] { "altered_dirt", "blood_dirt" }, new String[] { "mdm_poc:altered_dirt", "blood_dirt" }, null).setCreativeTab(tabBlocks).setStepSound(Block.soundTypeGravel);
		pocGrassBlocks = (BlockCustomGrass) new BlockCustomGrass(new String[] { "altered_grass", "blood_grass" }, new String[] { "mdm_poc:altered_grass_top", "mdm_poc:blood_grass_top" }, new String[] { "mdm_poc:altered_grass_side", "mdm_poc:blood_grass_side" }, new String[] { "mdm_poc:altered_dirt", "mdm_poc:blood_dirt" }).setCreativeTab(tabBlocks);
		
		String[] ores1 = new String[] { "copper", "tin", "mithril", "adamantite", "rubium", "novite", "kratonium", "promethium", "fractite" };
		pocOres = (CustomBlock) new CustomBlock(Material.rock, ores1, CSString.concatAll(ores1, "mdm_poc:", "_ore"), null).setCreativeTab(tabBlocks);
		
		String[] bloodOres = new String[] { "blood", "death", "whitium" };
		pocBloodOres = (CustomBlock) new CustomBlock(Material.rock, bloodOres, CSString.concatAll(bloodOres, "mdm_poc:", "_ore"), null).setCreativeTab(tabBlocks);
		
		pocLogs = (BlockCustomLog) new BlockCustomLog(new String[] { "magic_oak", "willow" }, new String[] { "mdm_poc:magic_oak_log_top", "mdm_poc:willow_log_top" }, new String[] { "mdm_poc:magic_oak_log_side", "mdm_poc:willow_log_side" }).setCreativeTab(tabBlocks);
		
		pocLeaves = (BlockCustomLeaves) new BlockCustomLeaves(new String[] { "magic_oak", "willow" }, new String[] { "mdm_poc:magic_oak_leaves", "mdm_poc:willow_leaves" }).setCreativeTab(tabBlocks);
		
		pocSaplings = (BlockPOCSapling) new BlockPOCSapling(new String[] { "magic_oak", "willow" }, new String[] { "mdm_poc:magic_oak_sapling", "mdm_poc:willow_sapling" }).setCreativeTab(tabBlocks);
		
		pocPlanks = (CustomBlock) new CustomBlock(Material.wood, new String[] { "magic_oak", "willow" }, new String[] { "mdm_poc:magic_oak_planks", "mdm_poc:willow_planks" }, null).setCreativeTab(tabBlocks).setStepSound(Block.soundTypeWood);
		
		pocPlantBlocks = (BlockCustomPlant) new BlockCustomPlant(new String[] { "saf_flower" }, new String[] { "mdm_poc:saf_flower" }).setCreativeTab(tabBlocks);
		
		// Block.blocksList[Block.lavaStill.blockID] = null;
		// activatorLava = (BlockPOCActivatorLava) new
		// BlockPOCActivatorLava(Block.lavaStill.blockID).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		//
		// Block.blocksList[Block.bed.blockID] = null;
		// dreamBed = (BlockPOCDreamBed) new
		// BlockPOCDreamBed(Block.bed.blockID).setHardness(0.2F).setUnlocalizedName("bed").setTextureName("bed");
		
		initStacks();
	}
	
	public static void initStacks()
	{
		// Item Stacks
		
		magicOakStick = new ItemStack(pocMaterials, 1, 0);
		willowStick = new ItemStack(pocMaterials, 1, 1);
		promethiumGem = new ItemStack(pocMaterials, 1, 2);
		noviteGem = new ItemStack(pocMaterials, 1, 3);
		kratoniumIngot = new ItemStack(pocMaterials, 1, 4);
		
		// Block Stacks
		
		magicOakLog = new ItemStack(pocLogs, 1, 0);
		willowLog = new ItemStack(pocLogs, 1, 1);
		
		magicOakLeaves = new ItemStack(pocLeaves, 1, 0);
		willowLeaves = new ItemStack(pocLeaves, 1, 1);
		
		magicOakSapling = new ItemStack(pocSaplings, 1, 0);
		willowSapling = new ItemStack(pocSaplings, 1, 1);
		
		magicOakPlanks = new ItemStack(pocPlanks, 1, 0);
		willowPlanks = new ItemStack(pocPlanks, 1, 1);
	}
	
	public static void load()
	{
		// Entities
		
		EntityRegistry.registerGlobalEntityID(EntityLich.class, "Lich", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0xEEEEEE);
		
		// Items
		
		CSItems.addItem(staff, "staff");
		CSItems.addItem(manaStar, "mana_star");
		CSItems.addItem(pocMaterials, "poc_materials");
		
		// Blocks
		
		pocStoneBlocks.setHardness(2.2F);
		pocDirtBlocks.setHardness(0.5F);
		pocGrassBlocks.setDirtBlock(0, pocDirtBlocks, 0);
		
		CSBlocks.addBlock(pocPortal, "poc_portal");
		CSBlocks.addBlock(pocPortalFrame, "poc_portal_frame");
		
		CSBlocks.addBlock(pocStoneBlocks, "poc_stone");
		CSBlocks.addBlock(pocBloodStoneBlocks, "poc_blood_stone");
		CSBlocks.addBlock(pocDirtBlocks, "poc_dirt");
		CSBlocks.addBlock(pocGrassBlocks, "poc_grass");
		
		CSBlocks.addBlock(pocOres, "poc_ores");
		CSBlocks.addBlock(pocBloodOres, "poc_blood_ores");
		
		CSBlocks.addBlock(pocLogs, "poc_logs");
		CSBlocks.addBlock(pocLeaves, "poc_leaves");
		CSBlocks.addBlock(pocSaplings, "poc_saplings");
		CSBlocks.addBlock(pocPlanks, "poc_planks");
		CSBlocks.addBlock(pocPlantBlocks, "poc_plants");
		
		addRecipes();
		setTabIcons();
	}
	
	public static void addRecipes()
	{
		addRecipe(new ItemStack(ParadiseOfChaos.pocPortalFrame), "nnn", "ndn", "nnn", 'n', CSStacks.lapis_block, 'd', CSStacks.diamond);
		
		addRecipe(new ItemStack(Alchemy.elixirBottle, 6, 0), " n ", "n n", "nnn", 'n', CSStacks.glass_pane);
		addRecipe(new ItemStack(Alchemy.elixirBottle, 4, 1), " n ", " n ", "nnn", 'n', CSStacks.glass_pane);
		
		addPlanks(ParadiseOfChaos.magicOakPlanks, ParadiseOfChaos.magicOakLog);
		addPlanks(ParadiseOfChaos.willowPlanks, ParadiseOfChaos.willowLog);
		addStick(ParadiseOfChaos.magicOakStick, ParadiseOfChaos.magicOakPlanks);
		addStick(ParadiseOfChaos.willowStick, ParadiseOfChaos.willowPlanks);
	}
	
	public static void setTabIcons()
	{
		tabBlocks.setIconItemStack(new ItemStack(pocGrassBlocks));
		tabItems.setIconItemStack(magicOakStick);
	}
}
