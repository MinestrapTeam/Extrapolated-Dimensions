package minestrapteam.extradims.lib;

import static clashsoft.cslib.minecraft.crafting.CSCrafting.addFurnaceRecipe;
import static clashsoft.cslib.minecraft.crafting.CSCrafting.addPlanks;
import static clashsoft.cslib.minecraft.crafting.CSCrafting.addRecipe;
import static clashsoft.cslib.minecraft.crafting.CSCrafting.addStick;
import clashsoft.cslib.minecraft.block.*;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.cslib.minecraft.stack.CSStacks;
import clashsoft.cslib.util.CSString;
import cpw.mods.fml.common.registry.EntityRegistry;
import minestrapteam.extradims.block.poc.BlockPOCPortal;
import minestrapteam.extradims.block.poc.BlockPOCSapling;
import minestrapteam.extradims.entity.boss.EntityLich;
import minestrapteam.extradims.item.poc.ItemManaStar;
import minestrapteam.extradims.item.poc.ItemStaff;

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
	
	public static CustomItem			items;
	public static CustomItem			materials;
	
	// Blocks
	
	public static BlockCustomPortal		portal;
	public static Block					portalFrame;
	
	public static CustomBlock			stoneBlocks;
	public static CustomBlock			bloodStoneBlocks;
	public static CustomBlock			dirtBlocks;
	public static BlockCustomGrass		grassBlocks;
	
	public static CustomBlock			oreBlocks;
	public static CustomBlock			bloodOreBlocks;
	
	public static BlockCustomLog		logBlocks;
	public static BlockCustomSapling	saplingBlocks;
	public static BlockCustomLeaves		leafBlocks;
	public static CustomBlock			plankBlocks;
	
	public static BlockCustomPlant		plantBlocks;
	
	// public static BlockPOCActivatorLava activatorLava;
	// public static BlockPOCDreamBed dreamBed;
	
	// Item Stacks
	
	public static ItemStack				magicOakStick, willowStick, promethiumGem, noviteGem, marmarosGem, kratoniumIngot, whitiumIngot, deathIngot, bloodIngot;
	
	// Block Stacks
	
	public static ItemStack				chaosStone;
	
	public static ItemStack				magicOakLog, willowLog;
	public static ItemStack				magicOakLeaves, willowLeaves;
	public static ItemStack				magicOakSapling, willowSapling;
	public static ItemStack				magicOakPlanks, willowPlanks;
	
	public static ItemStack				oreBlood, oreDeath, oreWhitium;
	
	public static void init()
	{
		// Items
		
		staff = (ItemStaff) new ItemStaff().setCreativeTab(tabTools);
		manaStar = (ItemManaStar) new ItemManaStar().setTextureName(getTexture("mana_star")).setCreativeTab(tabItems);
		items = (CustomItem) new CustomItem(new String[] { "magic_oak_stick", "willow_stick", "promethium_gem", "novite_gem" }, new String[] { getTexture("magic_oak_stick"), getTexture("willow_stick") }, null).setCreativeTab(tabItems);
		materials = (CustomItem) new CustomItem(new String[] { "kratonium_ingot", "whitium_ingot", "death_ingot", "blood_ingot", "mysterious_ingot", "promethium_gem", "novite_gem" }, new String[] { getTexture("minerals/kratonium_ingot"), getTexture("minerals/whitium_ingot"), getTexture("minerals/death_ingot"), getTexture("minerals/blood_ingot"), getTexture("minerals/mysterious_ingot"), getTexture("minerals/promethium_gem"), getTexture("minerals/novite_gem") }, null).setCreativeTab(tabItems);
		
		// Blocks
		
		portal = (BlockCustomPortal) new BlockPOCPortal("poc_portal", getTexture("poc_portal")).setCreativeTab(tabBlocks).setHardness(-1F);
		portalFrame = new BlockImpl(Material.rock, "poc_portal_frame", getTexture("poc_portal_frame")).setCreativeTab(tabBlocks);
		
		stoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { null, "cobbled", "dark", "dark_cobbled" }, new String[] { getTexture("stone/chaosstone"), getTexture("stone/chaosstone_cobbled"), getTexture("stone/dark_chaosstone"), getTexture("stone/dark_chaosstone_cobbled") }, null).setCreativeTab(tabBlocks);
		bloodStoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { null, "cobbled", "bloody" }, new String[] { getTexture("stone/bleedstone"), getTexture("stone/bleedstone_cobbled"), getTexture("stone/bleedstone_bloody") }, null).setCreativeTab(tabBlocks);
		
		dirtBlocks = (CustomBlock) new CustomBlock(Material.ground, new String[] { "altered_dirt", "blood_dirt" }, new String[] { getTexture("soil/altered_dirt"), getTexture("soil/blood_dirt") }, null).setCreativeTab(tabBlocks).setStepSound(Block.soundTypeGravel);
		grassBlocks = (BlockCustomGrass) new BlockCustomGrass(new String[] { "altered_grass", "blood_grass" }, new String[] { getTexture("soil/altered_grass"), getTexture("soil/blood_grass") }).setCreativeTab(tabBlocks);
		
		String[] ores1 = new String[] { "copper", "tin", "mithril", "adamantite", "rubium", "novite", "kratonium", "promethium", "fractite" };
		oreBlocks = (CustomBlock) new CustomBlock(Material.rock, ores1, CSString.concatAll(ores1, "ed_poc:minerals/", "_ore"), null).setCreativeTab(tabBlocks);
		
		String[] bloodOres = new String[] { "blood", "death", "whitium" };
		bloodOreBlocks = (CustomBlock) new CustomBlock(Material.rock, bloodOres, CSString.concatAll(bloodOres, "ed_poc:minerals/", "_ore"), null).setCreativeTab(tabBlocks);
		
		logBlocks = (BlockCustomLog) new BlockCustomLog(new String[] { "magic_oak", "willow" }, new String[] { getTexture("wood/magic_oak_log_top"), getTexture("wood/willow_log_top") }, new String[] { getTexture("wood/magic_oak_log_side"), getTexture("wood/willow_log_side") }).setCreativeTab(tabBlocks);
		
		leafBlocks = (BlockCustomLeaves) new BlockCustomLeaves(new String[] { "magic_oak", "willow" }, new String[] { getTexture("plants/magic_oak_leaves"), getTexture("plants/willow_leaves") }).setCreativeTab(tabBlocks);
		
		saplingBlocks = (BlockPOCSapling) new BlockPOCSapling(new String[] { "magic_oak", "willow" }, new String[] { getTexture("plants/magic_oak_sapling"), getTexture("plants/willow_sapling") }).setCreativeTab(tabBlocks);
		
		plankBlocks = (CustomBlock) new CustomBlock(Material.wood, new String[] { "magic_oak", "willow" }, new String[] { getTexture("wood/magic_oak_planks"), getTexture("wood/willow_planks") }, null).setCreativeTab(tabBlocks).setStepSound(Block.soundTypeWood);
		
		plantBlocks = (BlockCustomPlant) new BlockCustomPlant(new String[] { "saf_flower" }, new String[] { getTexture("plants/saf_flower") }).setCreativeTab(tabBlocks);
		
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
		
		magicOakStick = new ItemStack(items, 1, 0);
		willowStick = new ItemStack(items, 1, 1);
		promethiumGem = new ItemStack(items, 1, 2);
		noviteGem = new ItemStack(items, 1, 3);
		
		kratoniumIngot = new ItemStack(materials, 1, 0);
		whitiumIngot = new ItemStack(materials, 1, 1);
		deathIngot = new ItemStack(materials, 1, 2);
		bloodIngot = new ItemStack(materials, 1, 3);
		
		// Block Stacks
		
		magicOakLog = new ItemStack(logBlocks, 1, 0);
		willowLog = new ItemStack(logBlocks, 1, 1);
		
		magicOakLeaves = new ItemStack(leafBlocks, 1, 0);
		willowLeaves = new ItemStack(leafBlocks, 1, 1);
		
		magicOakSapling = new ItemStack(saplingBlocks, 1, 0);
		willowSapling = new ItemStack(saplingBlocks, 1, 1);
		
		magicOakPlanks = new ItemStack(plankBlocks, 1, 0);
		willowPlanks = new ItemStack(plankBlocks, 1, 1);
		
		oreBlood = new ItemStack(bloodOreBlocks, 1, 0);
		oreDeath = new ItemStack(bloodOreBlocks, 1, 1);
		oreWhitium = new ItemStack(bloodOreBlocks, 1, 2);
	}
	
	public static void load()
	{
		// Entities
		
		EntityRegistry.registerGlobalEntityID(EntityLich.class, "Lich", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0xEEEEEE);
		
		// Items
		
		CSItems.addItem(staff, "staff");
		CSItems.addItem(manaStar, "mana_star");
		CSItems.addItem(items, "poc_items");
		CSItems.addItem(materials, "poc_materials");
		
		// Blocks
		
		stoneBlocks.setHardness(2.2F);
		dirtBlocks.setHardness(0.5F);
		grassBlocks.setDirtBlock(0, dirtBlocks, 0);
		
		CSBlocks.addBlock(portal, "poc_portal");
		CSBlocks.addBlock(portalFrame, "poc_portal_frame");
		
		CSBlocks.addBlock(stoneBlocks, "chaosstone");
		CSBlocks.addBlock(bloodStoneBlocks, "bleedstone");
		CSBlocks.addBlock(dirtBlocks, "poc_dirt");
		CSBlocks.addBlock(grassBlocks, "poc_grass");
		
		CSBlocks.addBlock(oreBlocks, "poc_ores");
		CSBlocks.addBlock(bloodOreBlocks, "poc_blood_ores");
		
		CSBlocks.addBlock(logBlocks, "poc_logs");
		CSBlocks.addBlock(leafBlocks, "poc_leaves");
		CSBlocks.addBlock(saplingBlocks, "poc_saplings");
		CSBlocks.addBlock(plankBlocks, "poc_planks");
		CSBlocks.addBlock(plantBlocks, "poc_plants");
		
		addRecipes();
		setTabIcons();
	}
	
	public static void addRecipes()
	{
		addRecipe(new ItemStack(ParadiseOfChaos.portalFrame), "nnn", "ndn", "nnn", 'n', CSStacks.lapis_block, 'd', CSStacks.diamond);
		
		addRecipe(new ItemStack(Alchemy.elixirBottle, 6, 0), " n ", "n n", "nnn", 'n', CSStacks.glass_pane);
		addRecipe(new ItemStack(Alchemy.elixirBottle, 4, 1), " n ", " n ", "nnn", 'n', CSStacks.glass_pane);
		
		addFurnaceRecipe(ParadiseOfChaos.oreBlood, ParadiseOfChaos.bloodIngot, 0.8F);
		addFurnaceRecipe(ParadiseOfChaos.oreDeath, ParadiseOfChaos.deathIngot, 0.8F);
		addFurnaceRecipe(ParadiseOfChaos.oreWhitium, ParadiseOfChaos.whitiumIngot, 0.8F);
		
		addPlanks(ParadiseOfChaos.magicOakPlanks, ParadiseOfChaos.magicOakLog);
		addPlanks(ParadiseOfChaos.willowPlanks, ParadiseOfChaos.willowLog);
		addStick(ParadiseOfChaos.magicOakStick, ParadiseOfChaos.magicOakPlanks);
		addStick(ParadiseOfChaos.willowStick, ParadiseOfChaos.willowPlanks);
	}
	
	public static void setTabIcons()
	{
		tabBlocks.setIconItemStack(new ItemStack(grassBlocks));
		tabItems.setIconItemStack(magicOakStick);
	}
	
	public static String getTexture(String name)
	{
		return "ed_poc:" + name;
	}
}
