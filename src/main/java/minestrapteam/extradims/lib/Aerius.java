package minestrapteam.extradims.lib;

import static clashsoft.cslib.minecraft.crafting.CSCrafting.*;
import clashsoft.cslib.minecraft.block.*;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.util.CSString;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.extradims.block.MaterialCloud;
import minestrapteam.extradims.block.aerius.*;
import minestrapteam.extradims.item.aerius.*;
import minestrapteam.extradims.item.armor.ItemCape;
import minestrapteam.extradims.tileentity.TileEntityDamnationTable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Aerius
{
	public static CustomCreativeTab			tabAeriusBlocks	= new CustomCreativeTab("aerius_blocks");
	public static CustomCreativeTab			tabAeriusItems	= new CustomCreativeTab("aerius_items");
	public static CustomCreativeTab			tabAeriusTools	= new CustomCreativeTab("aerius_tools");
	public static CustomCreativeTab			tabAeriusArmor	= new CustomCreativeTab("aerius_armor");
	
	public static Material					cloudMaterial	= new MaterialCloud();
	
	// Items
	
	public static ItemAeriusMaterials		items;
	public static ItemFood					aerianApple;
	public static ItemLifeHeart				lifeHeart;
	public static ItemFireSword				fireSword;
	public static ItemIceHammer				iceHammer;
	public static ItemAeriusSoul			soul;
	public static ItemAeriusPortalActivator	portalActivator;
	public static ItemCape					capes;
	public static ItemAeriusSeeds			aeriusSeeds;
	public static ItemIceStick				iceStick;
	
	// Blocks
	
	public static BlockCustomPortal			portal;
	
	public static CustomBlock				stoneBlocks;
	public static CustomBlock				oreBlocks;
	public static CustomBlock				metalBlocks;
	public static CustomBlock				dirtBlocks;
	public static BlockAeriusGrass			grassBlocks;
	public static BlockCustomLog			logBlocks;
	public static BlockCustomLeaves			leafBlocks;
	public static BlockCustomSapling		saplingBlocks;
	public static CustomBlock				plankBlocks;
	public static CustomBlock				plantBlocks;
	public static CustomBlock				flowerBlocks;
	
	public static BlockCloud				cloud;
	
	public static BlockAeriusPillar			pillar;
	public static BlockDamnationTable		damnationTable;
	
	// Item Stacks
	
	public static ItemStack					heavenWoodStick, goldWoodStick, heavenArrow, shrekiteShard, clashiumIngot, holyiumIngot, energyOrb, proAlloy, bluriteDust;
	
	public static ItemStack					aerianSoil, mudDirt, ashes;
	public static ItemStack					aerianGrass, mudGrass, corruptedGrass, hallowedGrass, mushroomGrass;
	
	public static ItemStack					heavenWoodLog, goldWoodLog;
	public static ItemStack					heavenWoodLeaves, goldWoodLeaves;
	public static ItemStack					heavenWoodSapling, goldWoodSapling;
	public static ItemStack					heavenWoodPlanks, goldWoodPlanks;
	
	public static ItemStack					aerianGrassTall, mudGrassTall, corruptedGrassTall, hallowedGrassTall, mushroomGrassTall;
	public static ItemStack					aerianGrassVine, mudGrassVine, corruptedGrassVine, hallowedGrassVine, mushroomGrassVine, grassVine;
	
	public static ItemStack					aerock, cobbledAerock, mossyAerock;
	public static ItemStack					shrekiteOre, clashiumOre, condaiusOre, holyiumOre;
	public static ItemStack					shrekiteBlock, clashiumBlock, condaiusBlock, holyiumBlock, proAlloyBlock;
	
	public static void init()
	{
		// Items
		
		items = (ItemAeriusMaterials) new ItemAeriusMaterials(new String[] { "heaven_wood_stick", "gold_wood_stick", "aerian_arrow", "shrekite_shard", "clashium_ingot", "holyium_ingot", "energy_orb", "pro_ingot", "blurite_dust" }, "ed_aerius").setCreativeTab(tabAeriusItems);
		
		aerianApple = (ItemFood) new ItemFood(2, 0, false).setTextureName("ed_aerius:aerian_apple").setCreativeTab(tabAeriusItems);
		lifeHeart = (ItemLifeHeart) new ItemLifeHeart().setTextureName("ed_aerius:life_heart").setCreativeTab(tabAeriusItems);
		fireSword = (ItemFireSword) new ItemFireSword().setTextureName("ed_aerius:fire_sword").setCreativeTab(tabAeriusTools);
		iceHammer = (ItemIceHammer) new ItemIceHammer().setTextureName("ed_aerius:ice_hammer").setCreativeTab(tabAeriusTools);
		soul = (ItemAeriusSoul) new ItemAeriusSoul().setCreativeTab(tabAeriusItems);
		capes = (ItemCape) new ItemCape().setUnlocalizedName("cape").setCreativeTab(tabAeriusArmor);
		portalActivator = (ItemAeriusPortalActivator) new ItemAeriusPortalActivator().setTextureName("ed_aerius:aerius_portal_activator").setCreativeTab(tabAeriusTools);
		
		String[] seeds = new String[] { "aerian_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" };
		aeriusSeeds = new ItemAeriusSeeds(seeds, CSString.concatAll(seeds, "ed_aerius:", "_seeds"));
		iceStick = (ItemIceStick) new ItemIceStick().setTextureName("ed_aerius:ice_stick").setCreativeTab(tabAeriusItems);
		
		// Blocks
		
		portal = (BlockCustomPortal) new BlockAeriusPortal("aerius_portal", "ed_aerius:aerius_portal").setCreativeTab(tabAeriusBlocks);
		
		stoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { null, "cobbled", "mossy", "jungle" }, new String[] { "ed_aerius:aerock", "ed_aerius:aerock_cobbled", "ed_aerius:aerock_mossy", "ed_aerius:aerock_jungle" }, null).setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeStone);
		oreBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { "shrekite_ore", "clashium_ore", "condaius_ore", "holyium_ore" }, new String[] { "ed_aerius:shrekite_ore", "ed_aerius:clashium_ore", "ed_aerius:condaius_ore", "ed_aerius:holyium_ore" }, null).setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeStone);
		metalBlocks = (CustomBlock) new CustomBlock(Material.iron, new String[] { "shrekite_block", "clashium_block", "condaius_block", "holyium_block", "pro_block" }, new String[] { "ed_aerius:shrekite_block", "ed_aerius:clashium_block", "ed_aerius:condaius_block", "ed_aerius:holyium_block", "ed_aerius:pro_block" }, null).setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeMetal);
		
		dirtBlocks = (CustomBlock) new CustomBlock(Material.ground, new String[] { "aerian_soil", "mud", "ashes" }, new String[] { "ed_aerius:aerian_soil", "ed_aerius:aerian_mud", "ed_aerius:ashes" }, new CreativeTabs[] { tabAeriusBlocks }).setStepSound(Block.soundTypeGravel);
		grassBlocks = (BlockAeriusGrass) (new BlockAeriusGrass(new String[] { "aerian_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass" }, new String[] { "ed_aerius:aerian_grass_top", "ed_aerius:aerian_mud_grass_top_full", "ed_aerius:corrupted_grass_top", "ed_aerius:hallowed_grass_top", "ed_aerius:mushroom_grass_top" }, new String[] { "ed_aerius:aerian_grass_side", "ed_aerius:aerian_mud_grass_side_worn", "ed_aerius:corrupted_grass_side", "ed_aerius:hallowed_grass_side", "ed_aerius:mushroom_grass_side" }, new String[] { "ed_aerius:aerian_soil", "ed_aerius:aerian_mud", "dirt", "dirt", "ed_aerius:aerian_mud" })).setCreativeTab(tabAeriusBlocks);
		
		logBlocks = (BlockCustomLog) (new BlockCustomLog(new String[] { "heaven_wood", "gold_wood" }, new String[] { "ed_aerius:heaven_wood_log_top", "ed_aerius:gold_wood_log_top" }, new String[] { "ed_aerius:heaven_wood_log_side", "ed_aerius:gold_wood_log_side" })).setCreativeTab(tabAeriusBlocks);
		leafBlocks = (BlockCustomLeaves) (new BlockCustomLeaves(new String[] { "heaven_wood", "heaven_wood_2", "gold_wood" }, new String[] { "ed_aerius:heaven_wood_leaves", "ed_aerius:heaven_wood_leaves_2", "ed_aerius:gold_wood_leaves" })).setCreativeTab(tabAeriusBlocks).setHardness(0.2F);
		saplingBlocks = (BlockAeriusSapling) (new BlockAeriusSapling(new String[] { "heaven_wood", "gold_wood" }, new String[] { "ed_aerius:heaven_wood_sapling", "ed_aerius:gold_wood_sapling" })).setCreativeTab(tabAeriusBlocks);
		plankBlocks = (CustomBlock) new CustomBlock(Material.wood, new String[] { "heaven_wood", "gold_wood" }, new String[] { "ed_aerius:heaven_wood_planks", "ed_aerius:gold_wood_planks" }, new CreativeTabs[] { tabAeriusBlocks }).setStepSound(Block.soundTypeWood);
		
		String[] plants = new String[] { "aerian_grass", "mud_grass", "corrupted_grass", "hallowed_grass", "mushroom_grass", "aerian_vine", "mud_vine", "corrupted_vine", "hallowed_vine", "mushroom_vine", "grass_vine" };
		plantBlocks = (CustomBlock) new BlockAeriusPlant(plants, CSString.concatAll(plants, "ed_aerius:plant_", null)).setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeGrass);
		
		String[] flowers = new String[] { "blue", "white", "orange" };
		flowerBlocks = (CustomBlock) new BlockAeriusFlower(flowers, CSString.concatAll(plants, "ed_aerius:flower_", null)).setCreativeTab(tabAeriusBlocks);
		
		cloud = (BlockCloud) new BlockCloud(cloudMaterial).setBlockTextureName("ed_aerius:cloud").setCreativeTab(tabAeriusBlocks);
		
		pillar = (BlockAeriusPillar) new BlockAeriusPillar().setCreativeTab(tabAeriusBlocks).setHardness(1.75F);
		damnationTable = (BlockDamnationTable) new BlockDamnationTable().setCreativeTab(tabAeriusBlocks).setHardness(4F);
	}
	
	public static void initStacks()
	{
		// Item Stacks
		
		heavenWoodStick = new ItemStack(items, 1, 0);
		goldWoodStick = new ItemStack(items, 1, 1);
		heavenArrow = new ItemStack(items, 1, 2);
		shrekiteShard = new ItemStack(items, 1, 3);
		clashiumIngot = new ItemStack(items, 1, 4);
		holyiumIngot = new ItemStack(items, 1, 5);
		energyOrb = new ItemStack(items, 1, 6);
		proAlloy = new ItemStack(items, 1, 7);
		bluriteDust = new ItemStack(items, 1, 8);
		
		// Block Stacks
		
		aerock = new ItemStack(stoneBlocks, 1, 0);
		cobbledAerock = new ItemStack(stoneBlocks, 1, 1);
		mossyAerock = new ItemStack(stoneBlocks, 1, 2);
		
		shrekiteOre = new ItemStack(oreBlocks, 1, 0);
		clashiumOre = new ItemStack(oreBlocks, 1, 1);
		condaiusOre = new ItemStack(oreBlocks, 1, 2);
		holyiumOre = new ItemStack(oreBlocks, 1, 3);
		
		shrekiteBlock = new ItemStack(metalBlocks, 1, 0);
		clashiumBlock = new ItemStack(metalBlocks, 1, 1);
		condaiusBlock = new ItemStack(metalBlocks, 1, 2);
		holyiumBlock = new ItemStack(metalBlocks, 1, 3);
		proAlloyBlock = new ItemStack(metalBlocks, 1, 4);
		
		aerianSoil = new ItemStack(dirtBlocks, 1, 0);
		mudDirt = new ItemStack(dirtBlocks, 1, 1);
		ashes = new ItemStack(dirtBlocks, 1, 2);
		
		aerianGrass = new ItemStack(grassBlocks, 1, 0);
		mudGrass = new ItemStack(grassBlocks, 1, 1);
		corruptedGrass = new ItemStack(grassBlocks, 1, 2);
		hallowedGrass = new ItemStack(grassBlocks, 1, 3);
		mushroomGrass = new ItemStack(grassBlocks, 1, 4);
		
		heavenWoodLog = new ItemStack(logBlocks, 1, 0);
		goldWoodLog = new ItemStack(logBlocks, 1, 1);
		
		heavenWoodLeaves = new ItemStack(leafBlocks, 1, 0);
		goldWoodLeaves = new ItemStack(leafBlocks, 1, 1);
		
		heavenWoodSapling = new ItemStack(saplingBlocks, 1, 0);
		goldWoodSapling = new ItemStack(saplingBlocks, 1, 1);
		
		heavenWoodPlanks = new ItemStack(plankBlocks, 1, 0);
		goldWoodPlanks = new ItemStack(plankBlocks, 1, 1);
		
		aerianGrassTall = new ItemStack(plantBlocks, 1, 0);
		mudGrassTall = new ItemStack(plantBlocks, 1, 1);
		corruptedGrassTall = new ItemStack(plantBlocks, 1, 2);
		hallowedGrassTall = new ItemStack(plantBlocks, 1, 3);
		mushroomGrassTall = new ItemStack(plantBlocks, 1, 4);
		aerianGrassVine = new ItemStack(plantBlocks, 1, 5);
		mudGrassVine = new ItemStack(plantBlocks, 1, 6);
		corruptedGrassVine = new ItemStack(plantBlocks, 1, 7);
		hallowedGrassVine = new ItemStack(plantBlocks, 1, 8);
		mushroomGrassVine = new ItemStack(plantBlocks, 1, 9);
		grassVine = new ItemStack(plantBlocks, 1, 10);
	}
	
	public static void load()
	{
		// Items
		
		CSItems.addItem(items, "aerius_materials");
		CSItems.addItem(aerianApple, "aerian_apple");
		CSItems.addItem(lifeHeart, "life_heart");
		CSItems.addItem(fireSword, "fire_sword");
		CSItems.addItem(iceHammer, "ice_hammer");
		CSItems.addItem(capes, "cape");
		CSItems.addItem(aeriusSeeds, "aerius_seeds");
		CSItems.addItem(iceStick, "ice_stick");
		CSItems.addItem(portalActivator, "aerius_portal_activator");
		
		// Blocks
		
		stoneBlocks.setHardnesses(1.5F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F);
		stoneBlocks.setDrops(cobbledAerock, null, shrekiteShard, null, bluriteDust, null, null, null, null, null);
		dirtBlocks.setHardnesses(0.5F, 0.6F, 0.5F);
		grassBlocks.setHardnesses(0.6F, 0.65F, 0.7F, 0.7F, 0.65F);
		grassBlocks.setDirtBlocks(new Block[] { dirtBlocks, dirtBlocks, Blocks.dirt, Blocks.dirt, dirtBlocks }, new int[] { 0, 1, 0, 0, 1 });
		
		plankBlocks.setHardness(2.0F);
		plantBlocks.setHardnesses(0F, 0F, 0F, 0F);
		
		CSBlocks.addBlock(portal, "heaven_portal");
		
		CSBlocks.addBlock(stoneBlocks, "aerock");
		CSBlocks.addBlock(oreBlocks, "aerius_ores");
		CSBlocks.addBlock(metalBlocks, "aerius_metals");
		CSBlocks.addBlock(dirtBlocks, "aerian_dirt");
		CSBlocks.addBlock(grassBlocks, "aerian_grass");
		CSBlocks.addBlock(logBlocks, "aerius_logs");
		CSBlocks.addBlock(leafBlocks, "aerius_leaves");
		CSBlocks.addBlock(saplingBlocks, "aerius_saplings");
		CSBlocks.addBlock(plankBlocks, "aerius_planks");
		CSBlocks.addBlock(plantBlocks, "aerius_plants");
		CSBlocks.addBlock(flowerBlocks, "aerius_flowers");
		
		CSBlocks.addBlock(cloud, "cloud");
		
		CSBlocks.addBlock(pillar, "aerian_pillar");
		CSBlocks.addBlock(damnationTable, "damnation_table");
		GameRegistry.registerTileEntity(TileEntityDamnationTable.class, "DamnationTable");
		
		initStacks();
		addRecipes();
		setTabIcons();
	}
	
	public static void addRecipes()
	{
		addPlanks(heavenWoodPlanks, heavenWoodLog);
		addPlanks(goldWoodPlanks, goldWoodLog);
		addStick(heavenWoodStick, heavenWoodPlanks);
		addStick(goldWoodStick, goldWoodPlanks);
		
		addFurnaceRecipe(clashiumOre, clashiumIngot, 0.2F);
		addFurnaceRecipe(holyiumOre, holyiumIngot, 2F);
		
		addStorageBlock(shrekiteShard, shrekiteBlock, 3);
		addStorageBlock(clashiumIngot, clashiumBlock, 3);
		addStorageBlock(holyiumIngot, holyiumBlock, 3);
		addStorageBlock(bluriteDust, condaiusBlock, 3);
		addStorageBlock(proAlloy, proAlloyBlock, 3);
		
		addShapelessRecipe(shrekiteShard, shrekiteBlock);
		addShapelessRecipe(clashiumIngot, clashiumBlock);
		addShapelessRecipe(holyiumIngot, holyiumBlock);
		addShapelessRecipe(bluriteDust, condaiusBlock);
		addShapelessRecipe(proAlloy, proAlloyBlock);
	}
	
	public static void setTabIcons()
	{
		tabAeriusItems.setIconItemStack(shrekiteShard);
		tabAeriusBlocks.setIconItemStack(aerianGrass);
		tabAeriusTools.setIconItemStack(new ItemStack(iceHammer));
		tabAeriusArmor.setIconItemStack(new ItemStack(capes));
	}
}
