package minestrapteam.extradims.lib;

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

import static clashsoft.cslib.minecraft.crafting.CSCrafting.*;

public class Aerius
{
	public static CustomCreativeTab tabAeriusBlocks = new CustomCreativeTab("aerius_blocks");
	public static CustomCreativeTab tabAeriusItems  = new CustomCreativeTab("aerius_items");

	public static Material cloudMaterial = new MaterialCloud();

	// Items

	public static ItemAeriusSticks          stickItems;
	public static ItemAeriusMaterials       materialItems;
	public static ItemFood                  aerianApple;
	public static ItemLifeHeart             lifeHeart;
	public static ItemFireSword             fireSword;
	public static ItemIceHammer             iceHammer;
	public static ItemAeriusSoul            soul;
	public static ItemAeriusPortalActivator portalActivator;
	public static ItemCape                  capes;
	public static ItemAeriusSeeds           seedItems;

	// Blocks

	public static BlockCustomPortal portal;

	public static CustomBlock        stoneBlocks;
	public static CustomBlock        oreBlocks;
	public static CustomBlock        metalBlocks;
	public static CustomBlock        dirtBlocks;
	public static BlockAeriusGrass   grassBlocks;
	public static BlockCustomLog     logBlocks;
	public static BlockCustomLeaves  leafBlocks;
	public static BlockCustomSapling saplingBlocks;
	public static CustomBlock        plankBlocks;
	public static CustomBlock        plantBlocks;
	public static CustomBlock        flowerBlocks;

	public static BlockCloud cloud;

	public static BlockAeriusPillar   pillar;
	public static BlockDamnationTable damnationTable;

	// Item Stacks

	public static ItemStack skybarkStick, darkSkybarkStick, cloudrootStick, goldWoodStick, iceStick;
	public static ItemStack luminiteChunk, whiteGoldIngot, condaiusDust, holiumIngot, proAlloy, energyOrb;

	public static ItemStack aerianSoil, mudDirt, ashes;
	public static ItemStack aerianGrass, mudGrass, corruptedGrass, hallowedGrass, mushroomGrass;

	public static ItemStack skybarkLog, darkSkybarkLog, cloudrootLog, goldWoodLog;
	public static ItemStack skybarkLeaves, darkSkybarkLeaves, cloudrootLeaves, goldWoodLeaves;
	public static ItemStack skybarkSapling, darkSkybarkSapling, cloudrootSapling, goldWoodSapling;
	public static ItemStack skybarkPlanks, darkSkybarkPlanks, cloudrootPlanks, goldWoodPlanks;

	public static ItemStack aerock, cobbledAerock, mossyAerock;
	public static ItemStack luminiteOre, whiteGoldOre, condaiusOre, holiumOre;
	public static ItemStack luminiteBlock, whiteGoldBlock, condaiusBlock, holiumBlock, proAlloyBlock;

	public static void init()
	{
		String[] woodTypes = new String[] { "skybark", "dark_skybark", "cloudroot", "gold_wood" };

		// Items

		stickItems = (ItemAeriusSticks) new ItemAeriusSticks(new String[] { "skybark", "dark_skybark", "cloudroot",
			"gold_wood", "ice_stick" }, new String[] { getTexture("skybark_stick"), getTexture("dark_skybark_stick"),
			getTexture("cloudroot_stick"), getTexture("gold_wood_stick"), getTexture("ice_stick") })
			                                .setCreativeTab(tabAeriusItems);
		materialItems = (ItemAeriusMaterials) new ItemAeriusMaterials(new String[] { "luminite", "white_gold_ingot",
			"condaius_dust", "holium_ingot", "pro_ingot", "energy_orb" }, new String[] {
			getTexture("minerals/luminite"), getTexture("minerals/white_gold_ingot"),
			getTexture("minerals/condaius_dust"), getTexture("minerals/holium_ingot"),
			getTexture("minerals/pro_ingot"), getTexture("energy_orb") }).setCreativeTab(tabAeriusItems);

		aerianApple = (ItemFood) new ItemFood(2, 0, false).setTextureName(getTexture("food/aerian_apple"))
		                                                  .setCreativeTab(tabAeriusItems);
		lifeHeart = (ItemLifeHeart) new ItemLifeHeart().setTextureName(getTexture("loot/life_heart"))
		                                               .setCreativeTab(tabAeriusItems);
		fireSword = (ItemFireSword) new ItemFireSword().setTextureName(getTexture("weapons/fire_sword"))
		                                               .setCreativeTab(tabAeriusItems);
		iceHammer = (ItemIceHammer) new ItemIceHammer().setTextureName(getTexture("tools/ice_hammer"))
		                                               .setCreativeTab(tabAeriusItems);
		soul = (ItemAeriusSoul) new ItemAeriusSoul().setCreativeTab(tabAeriusItems);
		capes = (ItemCape) new ItemCape().setUnlocalizedName("cape").setCreativeTab(tabAeriusItems);
		portalActivator = (ItemAeriusPortalActivator) new ItemAeriusPortalActivator()
			                                              .setTextureName(getTexture("tools/aerius_portal_activator"))
			                                              .setCreativeTab(tabAeriusItems);

		String[] seeds = new String[] { "aerian_grass", "mud_grass", "corrupted_grass", "hallowed_grass",
			"mushroom_grass" };
		seedItems = new ItemAeriusSeeds(seeds, CSString.concatAll(seeds, "ed_aerius:food/", "_seeds"));

		// Blocks

		portal = (BlockCustomPortal) new BlockAeriusPortal(getTexture("aerius_portal")).setCreativeTab(tabAeriusBlocks);

		stoneBlocks = (CustomBlock) new CustomBlock(Material.rock, new String[] { null, "cobbled", "mossy", "jungle" },
		                                            new String[] { getTexture("stone/aerock"),
			                                            getTexture("stone/aerock_cobbled"),
			                                            getTexture("stone/aerock_mossy"),
			                                            getTexture("stone/aerock_jungle") }, null)
			                            .setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeStone);
		oreBlocks = (CustomBlock) new CustomBlock(Material.rock,
		                                          new String[] { "luminite_ore", "white_gold_ore", "condaius_ore",
			                                          "holium_ore" }, new String[] { getTexture("minerals/luminite_ore"),
			                                          getTexture("minerals/white_gold_ore_aerock"),
			                                          getTexture("minerals/luminite_ore"),
			                                          getTexture("minerals/holium_ore_aerock") }, null)
			                          .setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeStone);
		metalBlocks = (CustomBlock) new CustomBlock(Material.iron,
		                                            new String[] { "luminite_block", "white_gold_block", "condaius_block",
			                                            "holium_block", "pro_block" },
		                                            new String[] { getTexture("minerals/luminite_block"),
			                                            getTexture("minerals/white_gold_block"),
			                                            getTexture("minerals/condaius_block"),
			                                            getTexture("minerals/holium_block"),
			                                            getTexture("minerals/pro_block") }, null)
			                            .setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeMetal);

		dirtBlocks = (CustomBlock) new CustomBlock(Material.ground, new String[] { null, "mud", "ashes" },
		                                           new String[] { getTexture("soil/aerian_soil"),
			                                           getTexture("soil/aerian_mud"), getTexture("ashes") },
		                                           new CreativeTabs[] { tabAeriusBlocks })
			                           .setStepSound(Block.soundTypeGravel);
		grassBlocks = (BlockAeriusGrass) (new BlockAeriusGrass(new String[] { null, "mud_grass", "corrupted_grass",
			"hallowed_grass", "mushroom_grass" }, new String[] { getTexture("soil/aerian_grass"),
			getTexture("soil/aerian_mud_grass"), getTexture("soil/corrupted_grass"), getTexture("soil/hallowed_grass"),
			getTexture("soil/mushroom_grass") }).setCreativeTab(tabAeriusBlocks));

		logBlocks = (BlockCustomLog) (new BlockCustomLog(woodTypes, new String[] { getTexture("wood/skybark_log_top"),
			getTexture("wood/dark_skybark_log_top"), getTexture("wood/cloudroot_log_top"),
			getTexture("wood/gold_wood_log_top") }, new String[] { getTexture("wood/skybark_log_side"),
			getTexture("wood/dark_skybark_log_side"), getTexture("wood/cloudroot_log_side"),
			getTexture("wood/gold_wood_log_side") })).setCreativeTab(tabAeriusBlocks);
		leafBlocks = (BlockCustomLeaves) (new BlockCustomLeaves(woodTypes,
		                                                        new String[] { getTexture("plants/skybark_leaves"),
			                                                        getTexture("plants/dark_skybark_leaves"),
			                                                        getTexture("plants/cloudroot_leaves"),
			                                                        getTexture("plants/gold_wood_leaves") }))
			                                 .setHardness(0.2F).setCreativeTab(tabAeriusBlocks);
		saplingBlocks = (BlockAeriusSapling) (new BlockAeriusSapling(woodTypes, new String[] {
			getTexture("plants/skybark_sapling"), getTexture("plants/dark_skybark_sapling"),
			getTexture("plants/cloudroot_sapling"), getTexture("plants/gold_wood_sapling") }))
			                                     .setCreativeTab(tabAeriusBlocks);
		plankBlocks = (CustomBlock) new CustomBlock(Material.wood, woodTypes,
		                                            new String[] { getTexture("wood/skybark_planks"),
			                                            getTexture("wood/dark_skybark_planks"),
			                                            getTexture("wood/cloudroot_planks"),
			                                            getTexture("wood/gold_wood_planks") }, null)
			                            .setStepSound(Block.soundTypeWood).setCreativeTab(tabAeriusBlocks);

		String[] plants = new String[] { "angel_grass", "short_angel_grass", "corrupted_grass", "hallowed_grass",
			"mushroom_grass", "wanderers_bane", "wanderers_bane_small", "corrupted_vine", "hallowed_vine",
			"mushroom_vine" };
		plantBlocks = (CustomBlock) new BlockAeriusPlant(plants,
		                                                 CSString.concatAll(plants, getTexture("plants/"), null))
			                            .setCreativeTab(tabAeriusBlocks);

		String[] flowers = new String[] { "soulwhisker", "palebloom", "dawnbringer" };
		flowerBlocks = (CustomBlock) new BlockAeriusFlower(flowers,
		                                                   CSString.concatAll(flowers, getTexture("plants/"), null))
			                             .setCreativeTab(tabAeriusBlocks);

		cloud = (BlockCloud) new BlockCloud(cloudMaterial).setBlockTextureName(getTexture("clouds/cloud"))
		                                                  .setCreativeTab(tabAeriusBlocks);

		pillar = (BlockAeriusPillar) new BlockAeriusPillar().setCreativeTab(tabAeriusBlocks).setHardness(1.75F);
		damnationTable = (BlockDamnationTable) new BlockDamnationTable().setCreativeTab(tabAeriusBlocks)
		                                                                .setHardness(4F);
	}

	public static void initStacks()
	{
		// Item Stacks

		skybarkStick = new ItemStack(stickItems, 1, 0);
		darkSkybarkStick = new ItemStack(stickItems, 1, 1);
		cloudrootStick = new ItemStack(stickItems, 1, 2);
		goldWoodStick = new ItemStack(stickItems, 1, 3);
		iceStick = new ItemStack(stickItems, 1, 4);

		luminiteChunk = new ItemStack(materialItems, 1, 0);
		whiteGoldIngot = new ItemStack(materialItems, 1, 1);
		condaiusDust = new ItemStack(materialItems, 1, 2);
		holiumIngot = new ItemStack(materialItems, 1, 3);
		proAlloy = new ItemStack(materialItems, 1, 4);
		energyOrb = new ItemStack(materialItems, 1, 5);

		// Block Stacks

		aerock = new ItemStack(stoneBlocks, 1, 0);
		cobbledAerock = new ItemStack(stoneBlocks, 1, 1);
		mossyAerock = new ItemStack(stoneBlocks, 1, 2);

		luminiteOre = new ItemStack(oreBlocks, 1, 0);
		whiteGoldOre = new ItemStack(oreBlocks, 1, 1);
		condaiusOre = new ItemStack(oreBlocks, 1, 2);
		holiumOre = new ItemStack(oreBlocks, 1, 3);

		luminiteBlock = new ItemStack(metalBlocks, 1, 0);
		whiteGoldBlock = new ItemStack(metalBlocks, 1, 1);
		condaiusBlock = new ItemStack(metalBlocks, 1, 2);
		holiumBlock = new ItemStack(metalBlocks, 1, 3);
		proAlloyBlock = new ItemStack(metalBlocks, 1, 4);

		aerianSoil = new ItemStack(dirtBlocks, 1, 0);
		mudDirt = new ItemStack(dirtBlocks, 1, 1);
		ashes = new ItemStack(dirtBlocks, 1, 2);

		aerianGrass = new ItemStack(grassBlocks, 1, 0);
		mudGrass = new ItemStack(grassBlocks, 1, 1);
		corruptedGrass = new ItemStack(grassBlocks, 1, 2);
		hallowedGrass = new ItemStack(grassBlocks, 1, 3);
		mushroomGrass = new ItemStack(grassBlocks, 1, 4);

		skybarkLog = new ItemStack(logBlocks, 1, 0);
		darkSkybarkLog = new ItemStack(logBlocks, 1, 1);
		cloudrootLog = new ItemStack(logBlocks, 1, 2);
		goldWoodLog = new ItemStack(logBlocks, 1, 3);

		skybarkLeaves = new ItemStack(leafBlocks, 1, 0);
		darkSkybarkLeaves = new ItemStack(leafBlocks, 1, 1);
		cloudrootLeaves = new ItemStack(leafBlocks, 1, 2);
		goldWoodLeaves = new ItemStack(leafBlocks, 1, 3);

		skybarkSapling = new ItemStack(saplingBlocks, 1, 0);
		darkSkybarkSapling = new ItemStack(saplingBlocks, 1, 1);
		cloudrootSapling = new ItemStack(saplingBlocks, 1, 2);
		goldWoodSapling = new ItemStack(saplingBlocks, 1, 3);

		skybarkPlanks = new ItemStack(plankBlocks, 1, 0);
		darkSkybarkPlanks = new ItemStack(plankBlocks, 1, 1);
		cloudrootPlanks = new ItemStack(plankBlocks, 1, 2);
		goldWoodPlanks = new ItemStack(plankBlocks, 1, 3);
	}

	public static void load()
	{
		// Items

		CSItems.addItem(stickItems, "aerius_sticks");
		CSItems.addItem(materialItems, "aerius_materials");
		CSItems.addItem(aerianApple, "aerian_apple");
		CSItems.addItem(lifeHeart, "life_heart");
		CSItems.addItem(fireSword, "fire_sword");
		CSItems.addItem(iceHammer, "ice_hammer");
		CSItems.addItem(capes, "cape");
		CSItems.addItem(seedItems, "aerius_seeds");
		CSItems.addItem(portalActivator, "aerius_portal_activator");

		// Blocks

		stoneBlocks.setHardnesses(1.5F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F);
		stoneBlocks.setDrops(cobbledAerock, null, luminiteChunk, null, condaiusDust, null, null, null, null, null);
		dirtBlocks.setHardnesses(0.5F, 0.6F, 0.5F);
		grassBlocks.setHardnesses(0.6F, 0.65F, 0.7F, 0.7F, 0.65F);
		grassBlocks.setDirtBlocks(new Block[] { dirtBlocks, dirtBlocks, Blocks.dirt, Blocks.dirt, dirtBlocks },
		                          new int[] { 0, 1, 0, 0, 1 });

		plankBlocks.setHardness(2.0F);
		plantBlocks.setHardnesses(0F, 0F, 0F, 0F);

		CSBlocks.addBlock(portal, "aerius_portal");

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
		addPlanks(skybarkPlanks, skybarkLog);
		addPlanks(darkSkybarkPlanks, darkSkybarkLog);
		addPlanks(cloudrootPlanks, cloudrootLog);
		addPlanks(goldWoodPlanks, goldWoodLog);

		addStick(skybarkStick, skybarkPlanks);
		addStick(darkSkybarkStick, darkSkybarkPlanks);
		addStick(cloudrootStick, cloudrootPlanks);
		addStick(goldWoodStick, goldWoodPlanks);

		addFurnaceRecipe(whiteGoldOre, whiteGoldIngot, 0.2F);
		addFurnaceRecipe(holiumOre, holiumIngot, 2F);

		addStorageBlock(luminiteChunk, luminiteBlock, 3);
		addStorageBlock(whiteGoldIngot, whiteGoldBlock, 3);
		addStorageBlock(holiumIngot, holiumBlock, 3);
		addStorageBlock(condaiusDust, condaiusBlock, 3);
		addStorageBlock(proAlloy, proAlloyBlock, 3);

		addShapelessRecipe(luminiteChunk, luminiteBlock);
		addShapelessRecipe(whiteGoldIngot, whiteGoldBlock);
		addShapelessRecipe(condaiusDust, condaiusBlock);
		addShapelessRecipe(holiumIngot, holiumBlock);
		addShapelessRecipe(proAlloy, proAlloyBlock);
	}

	public static void setTabIcons()
	{
		tabAeriusBlocks.setIconItemStack(aerianGrass);
		tabAeriusItems.setIconItemStack(condaiusDust);
	}

	public static String getTexture(String name)
	{
		return "ed_aerius:" + name;
	}
}
