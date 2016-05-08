package minestrapteam.extradims.lib.aerius;

import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.extracore.block.*;
import minestrapteam.extracore.util.StringUtils;
import minestrapteam.extradims.block.MaterialCloud;
import minestrapteam.extradims.block.aerius.*;
import minestrapteam.extradims.tileentity.TileEntityDamnationTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

import static minestrapteam.extradims.lib.aerius.Aerius.getTexture;
import static minestrapteam.extradims.lib.aerius.AInventory.tabAeriusBlocks;

public class ABlocks
{
	// ----- Block Materials -----

	public static Material cloudMaterial = new MaterialCloud();

	// ----- Blocks -----

	public static BlockCustomPortal   portal;
	public static CustomBlock         stoneBlocks;
	public static CustomBlock         oreBlocks;
	public static CustomBlock         jungleOreBlocks;
	public static CustomBlock         metalBlocks;
	public static CustomBlock         dirtBlocks;
	public static BlockAeriusGrass    grassBlocks;

	// Wood Blocks
	public static BlockCustomLog      logBlocks;
	public static BlockCustomLog      logBlocks2;
	public static BlockCustomLeaves   leafBlocks;
	public static BlockCustomLeaves   leafBlocks2;
	public static BlockCustomSapling  saplingBlocks;
	public static BlockCustomSapling  saplingBlocks2;
	public static CustomBlock         plankBlocks;

	// Plant Blocks
	public static CustomBlock         plantBlocks;
	public static CustomBlock         flowerBlocks;

	// Misc Blocks
	public static BlockCloud          cloud;
	public static BlockDamnationTable damnationTable;

	// ----- Item Stacks -----

	public static ItemStack aerianSoil;
	public static ItemStack mudDirt;
	public static ItemStack ashes;
	public static ItemStack aerianGrass;
	public static ItemStack mudGrass;
	public static ItemStack corruptedGrass;
	public static ItemStack hallowedGrass;
	public static ItemStack mushroomGrass;
	public static ItemStack skybarkLog;
	public static ItemStack darkSkybarkLog;
	public static ItemStack cloudrootLog;
	public static ItemStack goldWoodLog;
	public static ItemStack skybarkLeaves;
	public static ItemStack darkSkybarkLeaves;
	public static ItemStack cloudrootLeaves;
	public static ItemStack goldWoodLeaves;
	public static ItemStack skybarkSapling;
	public static ItemStack darkSkybarkSapling;
	public static ItemStack cloudrootSapling;
	public static ItemStack goldWoodSapling;
	public static ItemStack skybarkPlanks;
	public static ItemStack darkSkybarkPlanks;
	public static ItemStack cloudrootPlanks;
	public static ItemStack goldWoodPlanks;
	public static ItemStack magicOakLog;
	public static ItemStack willowLog;
	public static ItemStack magicOakLeaves;
	public static ItemStack willowLeaves;
	public static ItemStack magicOakSapling;
	public static ItemStack willowSapling;
	public static ItemStack magicOakPlanks;
	public static ItemStack willowPlanks;
	public static ItemStack aerock;
	public static ItemStack cobbledAerock;
	public static ItemStack jungleAerock;
	public static ItemStack mossyAerock;

	public static ItemStack luminiteOre;
	public static ItemStack whiteGoldOre;
	public static ItemStack holiumOre;
	public static ItemStack condaiusOre;
	public static ItemStack amnethiteOre;
	public static ItemStack diamondOre;
	public static ItemStack obsidianOre;

	public static ItemStack jungleLuminiteOre;
	public static ItemStack jungleWhiteGoldOre;
	public static ItemStack jungleHoliumOre;
	public static ItemStack jungleCondaiusOre;
	public static ItemStack jungleAmnethiteOre;
	public static ItemStack jungleDiamondOre;
	public static ItemStack jungleObsidianOre;

	public static ItemStack luminiteBlock;
	public static ItemStack whiteGoldBlock;
	public static ItemStack condaiusBlock;
	public static ItemStack holiumBlock;
	public static ItemStack proAlloyBlock;

	public static void initBlocks()
	{
		portal = (BlockCustomPortal) new BlockAeriusPortal(getTexture("aerius_portal")).setCreativeTab(tabAeriusBlocks);

		stoneBlocks = new CustomBlock(Material.rock, new String[] { null, "cobbled", "mossy", "jungle" },
		                                      new String[] { getTexture("stone/aerock"), getTexture("stone/aerock_cobbled"),
			                                      getTexture("stone/aerock_mossy"), getTexture("stone/aerock_jungle") }, null);

		initOreBlocks();

		dirtBlocks = new CustomBlock(Material.ground, new String[] { null, "mud", "ashes" },
		                                     new String[] { getTexture("soil/aerian_soil"), getTexture("soil/aerian_mud"),
			                                     getTexture("ashes") }, null);

		grassBlocks = new BlockAeriusGrass(new String[] { null, "mud_grass", "corrupted_grass", "hallowed_grass",
			"mushroom_grass" }, new String[] { getTexture("soil/aerian_grass"), getTexture("soil/aerian_mud_grass"),
			getTexture("soil/corrupted_grass"), getTexture("soil/hallowed_grass"), getTexture("soil/mushroom_grass") });

		initWoodBlocks();

		plantBlocks = (CustomBlock) new BlockAeriusPlants(new String[] { "angel_grass", "short_angel_grass",
			"corrupted_grass", "hallowed_grass", "mushroom_grass", "wanderers_bane", "wanderers_bane_small",
			"corrupted_vine", "hallowed_vine", "mushroom_vine" }).setHardness(0F).setCreativeTab(tabAeriusBlocks);

		String[] flowers = new String[] { "soulwhisker", "palebloom", "dawnbringer" };
		flowerBlocks = (CustomBlock) new BlockAeriusFlowers(flowers,
		                                                            StringUtils.prefixAll(flowers, getTexture("plants/"))).setCreativeTab(tabAeriusBlocks);

		cloud = (BlockCloud) new BlockCloud(cloudMaterial).setBlockTextureName(getTexture("clouds/cloud"))
		                                                          .setCreativeTab(tabAeriusBlocks);

		damnationTable = (BlockDamnationTable) new BlockDamnationTable().setCreativeTab(tabAeriusBlocks)
		                                                                        .setHardness(4F);
	}

	private static void initOreBlocks()
	{
		final String[] oreNames = { "luminite", "white_gold", "holium", "condaius", "amnethite", "diamond",
			"obsidian" };
		oreBlocks = new CustomBlock(Material.rock, oreNames,
		                            StringUtils.concatAll(oreNames, Aerius.TEXTURE_PREFIX + "minerals/", "_ore_aerock"),
		                            null);
		jungleOreBlocks = new CustomBlock(Material.rock, oreNames, StringUtils.concatAll(oreNames, Aerius.TEXTURE_PREFIX
			                                                                                           + "minerals/",
		                                                                                 "_ore_jungle"), null);

		metalBlocks = new CustomBlock(Material.iron,
		                              new String[] { "luminite_block", "white_gold_block", "condaius_block",
			                              "holium_block", "pro_block" },
		                              new String[] { getTexture("minerals/luminite_block"),
			                              getTexture("minerals/white_gold_block"),
			                              getTexture("minerals/condaius_block"),
			                              getTexture("minerals/holium_block"),
			                              getTexture("minerals/pro_block") }, null);
	}

	private static void initWoodBlocks()
	{
		String[] woodTypes = { "skybark", "dark_skybark", "cloudroot", "gold_wood", "magic_oak", "willow" };
		String[] woodTypes1 = { "skybark", "dark_skybark" };
		String[] woodTypes2 = { "cloudroot", "gold_wood", "magic_oak", "willow" };

		logBlocks = new BlockCustomLog(woodTypes1,
		                               StringUtils.concatAll(woodTypes1, Aerius.TEXTURE_PREFIX + "wood/", "_log_top"),
		                               StringUtils.concatAll(woodTypes1, Aerius.TEXTURE_PREFIX + "wood/", "_log_side"));
		logBlocks2 = new BlockCustomLog(woodTypes2,
		                                StringUtils.concatAll(woodTypes2, Aerius.TEXTURE_PREFIX + "wood/", "_log_top"),
		                                StringUtils
			                                .concatAll(woodTypes2, Aerius.TEXTURE_PREFIX + "wood/", "_log_side"));

		leafBlocks = new BlockCustomLeaves(woodTypes1, StringUtils
			                                               .concatAll(woodTypes1, Aerius.TEXTURE_PREFIX + "plants/",
			                                                          "_leaves"));
		leafBlocks2 = new BlockCustomLeaves(woodTypes2, StringUtils
			                                                .concatAll(woodTypes2, Aerius.TEXTURE_PREFIX + "plants/",
			                                                           "_leaves"));

		saplingBlocks = new BlockAeriusSapling(woodTypes1, StringUtils
			                                                   .concatAll(woodTypes1, Aerius.TEXTURE_PREFIX + "plants/",
			                                                              "_sapling"));
		saplingBlocks2 = new BlockAeriusSapling(woodTypes2, StringUtils.concatAll(woodTypes2,
		                                                                          Aerius.TEXTURE_PREFIX + "plants/",
		                                                                          "_sapling"));

		plankBlocks = new CustomBlock(Material.wood, woodTypes,
		                              StringUtils.concatAll(woodTypes, Aerius.TEXTURE_PREFIX + "wood/", "_planks"),
		                              null);
	}

	public static void registerBlocks()
	{
		final ItemStack[] oreDrops = { AItems.luminiteChunk, null, AItems.condaiusDust, null, null, null, null, null };
		final float[] oreHardnesses = { 2.1F, 2.5F, 2.5F, 2.7F, 3F, 3F, 3F, 3F };

		stoneBlocks.setDrops(cobbledAerock, null, null, null).setHardnesses(1.5F, 2.0F, 2F, 2.2F)
		                   .setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeStone);

		// TODO Hardnesses
		metalBlocks.setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeMetal);

		oreBlocks.setDrops(oreDrops).setHardnesses(oreHardnesses).setCreativeTab(tabAeriusBlocks)
		                 .setStepSound(Block.soundTypeStone);
		jungleOreBlocks.setDrops(oreDrops).setHardnesses(oreHardnesses).setCreativeTab(tabAeriusBlocks)
		                       .setStepSound(Block.soundTypeStone);

		dirtBlocks.setHardnesses(0.5F, 0.6F, 0.5F).setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeGravel).setHarvestLevel("shovel", 0);

		grassBlocks.setDirtBlocks(
			new Block[] { dirtBlocks, dirtBlocks, dirtBlocks, dirtBlocks, dirtBlocks },
			new int[] { 0, 1, 0, 0, 1 }).setHardnesses(0.6F, 0.65F, 0.7F, 0.7F, 0.65F)
		                   .setCreativeTab(tabAeriusBlocks).setHarvestLevel("shovel", 0);

		logBlocks.setCreativeTab(tabAeriusBlocks);
		logBlocks2.setCreativeTab(tabAeriusBlocks);
		saplingBlocks.setCreativeTab(tabAeriusBlocks);
		saplingBlocks2.setCreativeTab(tabAeriusBlocks);
		leafBlocks.setHardness(0.2F).setCreativeTab(tabAeriusBlocks);
		leafBlocks2.setHardness(0.2F).setCreativeTab(tabAeriusBlocks);

		plankBlocks.setHardness(2.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabAeriusBlocks);

		ECBlocks.addBlock(portal, "aerius_portal");

		ECBlocks.addBlock(stoneBlocks, "aerock");
		ECBlocks.addBlock(oreBlocks, "aerius_ores");
		ECBlocks.addBlock(jungleOreBlocks, "aerius_jungle_ores");
		ECBlocks.addBlock(metalBlocks, "aerius_metals");
		ECBlocks.addBlock(dirtBlocks, "aerian_dirt");
		ECBlocks.addBlock(grassBlocks, "aerian_grass");
		ECBlocks.addBlock(logBlocks, "aerius_logs");
		ECBlocks.addBlock(logBlocks2, "aerius_logs2");
		ECBlocks.addBlock(leafBlocks, "aerius_leaves");
		ECBlocks.addBlock(leafBlocks2, "aerius_leaves2");
		ECBlocks.addBlock(saplingBlocks, "aerius_saplings");
		ECBlocks.addBlock(saplingBlocks2, "aerius_saplings2");
		ECBlocks.addBlock(plankBlocks, "aerius_planks");
		ECBlocks.addBlock(plantBlocks, "aerius_plants");
		ECBlocks.addBlock(flowerBlocks, "aerius_flowers");

		ECBlocks.addBlock(cloud, "cloud");

		ECBlocks.addBlock(damnationTable, "damnation_table");
		GameRegistry.registerTileEntity(TileEntityDamnationTable.class, "DamnationTable");
	}

	public static void initStacks()
	{
		// Block Stacks

		aerock = new ItemStack(stoneBlocks, 1, 0);
		cobbledAerock = new ItemStack(stoneBlocks, 1, 1);
		mossyAerock = new ItemStack(stoneBlocks, 1, 2);
		jungleAerock = new ItemStack(stoneBlocks, 1, 3);

		luminiteOre = new ItemStack(oreBlocks, 1, 0);
		whiteGoldOre = new ItemStack(oreBlocks, 1, 1);
		holiumOre = new ItemStack(oreBlocks, 1, 2);
		condaiusOre = new ItemStack(oreBlocks, 1, 3);
		amnethiteOre = new ItemStack(oreBlocks, 1, 4);
		diamondOre = new ItemStack(oreBlocks, 1, 5);
		obsidianOre = new ItemStack(oreBlocks, 1, 6);

		jungleLuminiteOre = new ItemStack(jungleOreBlocks, 1, 0);
		jungleWhiteGoldOre = new ItemStack(jungleOreBlocks, 1, 1);
		jungleHoliumOre = new ItemStack(jungleOreBlocks, 1, 2);
		jungleCondaiusOre = new ItemStack(jungleOreBlocks, 1, 3);
		jungleAmnethiteOre = new ItemStack(jungleOreBlocks, 1, 4);
		jungleDiamondOre = new ItemStack(jungleOreBlocks, 1, 5);
		jungleObsidianOre = new ItemStack(jungleOreBlocks, 1, 6);

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
		cloudrootLog = new ItemStack(logBlocks2, 1, 0);
		goldWoodLog = new ItemStack(logBlocks2, 1, 1);
		magicOakLog = new ItemStack(logBlocks2, 1, 2);
		willowLog = new ItemStack(logBlocks2, 1, 3);

		skybarkLeaves = new ItemStack(leafBlocks, 1, 0);
		darkSkybarkLeaves = new ItemStack(leafBlocks, 1, 1);
		cloudrootLeaves = new ItemStack(leafBlocks2, 1, 0);
		goldWoodLeaves = new ItemStack(leafBlocks2, 1, 1);
		magicOakLeaves = new ItemStack(leafBlocks2, 1, 2);
		willowLeaves = new ItemStack(leafBlocks2, 1, 3);

		skybarkSapling = new ItemStack(saplingBlocks, 1, 0);
		darkSkybarkSapling = new ItemStack(saplingBlocks, 1, 1);
		cloudrootSapling = new ItemStack(saplingBlocks2, 1, 0);
		goldWoodSapling = new ItemStack(saplingBlocks2, 1, 1);
		magicOakSapling = new ItemStack(saplingBlocks2, 1, 2);
		willowSapling = new ItemStack(saplingBlocks2, 1, 3);

		skybarkPlanks = new ItemStack(plankBlocks, 1, 0);
		darkSkybarkPlanks = new ItemStack(plankBlocks, 1, 1);
		cloudrootPlanks = new ItemStack(plankBlocks, 1, 2);
		goldWoodPlanks = new ItemStack(plankBlocks, 1, 3);
		magicOakPlanks = new ItemStack(plankBlocks, 1, 4);
		willowPlanks = new ItemStack(plankBlocks, 1, 5);
	}
}
