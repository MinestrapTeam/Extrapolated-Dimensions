package minestrapteam.extradims.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.extracore.block.*;
import minestrapteam.extracore.inventory.creativetab.CustomCreativeTab;
import minestrapteam.extracore.item.CustomItem;
import minestrapteam.extracore.item.ECItems;
import minestrapteam.extracore.util.StringUtils;
import minestrapteam.extradims.block.MaterialCloud;
import minestrapteam.extradims.block.aerius.*;
import minestrapteam.extradims.item.aerius.*;
import minestrapteam.extradims.item.armor.ItemCape;
import minestrapteam.extradims.item.armor.ItemGem;
import minestrapteam.extradims.tileentity.TileEntityDamnationTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import static minestrapteam.extracore.crafting.ECCrafting.*;

public class Aerius
{
	public static final String TEXTURE_DOMAIN = "ed_aerius:";

	public static CustomCreativeTab tabAeriusBlocks = new CustomCreativeTab("aerius_blocks");
	public static CustomCreativeTab tabAeriusItems  = new CustomCreativeTab("aerius_items");

	public static Material cloudMaterial = new MaterialCloud();

	// Items

	public static CustomItem      stickItems;
	public static CustomItem      materialItems;
	public static ItemAeriusLoot  lootItems;
	public static ItemAeriusSeeds seedItems;

	public static ItemFood       aerianApple;
	public static ItemFireSword  fireSword;
	public static ItemIceHammer  iceHammer;
	public static ItemAeriusSoul soul;
	public static ItemCape       capes;
	public static ItemStaff      staff;

	public static ItemAeriusAccessories accessories;
	public static ItemGem               lifeGem;
	public static ItemGem               manaGem;
	public static ItemGem               amnethiteParagonGem;

	// Blocks

	public static BlockCustomPortal portal;

	public static CustomBlock stoneBlocks;

	public static CustomBlock      oreBlocks;
	public static CustomBlock      jungleOreBlocks;
	public static CustomBlock      metalBlocks;
	public static CustomBlock      dirtBlocks;
	public static BlockAeriusGrass grassBlocks;

	public static BlockCustomLog     logBlocks;
	public static BlockCustomLog     logBlocks2;
	public static BlockCustomLeaves  leafBlocks;
	public static BlockCustomLeaves  leafBlocks2;
	public static BlockCustomSapling saplingBlocks;
	public static BlockCustomSapling saplingBlocks2;
	public static CustomBlock        plankBlocks;

	public static CustomBlock plantBlocks;
	public static CustomBlock flowerBlocks;
	public static BlockCloud  cloud;

	public static BlockDamnationTable damnationTable;

	// Item Stacks

	public static ItemStack skybarkStick, darkSkybarkStick, cloudrootStick, goldWoodStick;
	public static ItemStack magicOakStick, willowStick;

	public static ItemStack iceStick, manaStar, lifeHeart, aerwand;

	public static ItemStack luminiteChunk, whiteGoldIngot, condaiusDust, holiumIngot, proAlloy, energyOrb;

	public static ItemStack aerianSoil, mudDirt, ashes;
	public static ItemStack aerianGrass, mudGrass, corruptedGrass, hallowedGrass, mushroomGrass;

	public static ItemStack skybarkLog, darkSkybarkLog, cloudrootLog, goldWoodLog;
	public static ItemStack skybarkLeaves, darkSkybarkLeaves, cloudrootLeaves, goldWoodLeaves;
	public static ItemStack skybarkSapling, darkSkybarkSapling, cloudrootSapling, goldWoodSapling;
	public static ItemStack skybarkPlanks, darkSkybarkPlanks, cloudrootPlanks, goldWoodPlanks;

	public static ItemStack magicOakLog, willowLog;
	public static ItemStack magicOakLeaves, willowLeaves;
	public static ItemStack magicOakSapling, willowSapling;
	public static ItemStack magicOakPlanks, willowPlanks;

	public static ItemStack aerock, cobbledAerock, mossyAerock;

	public static ItemStack luminiteOre, copperOre, whiteGoldOre, holiumOre, condaiusOre, amnethiteOre, diamondOre, obsidianOre;
	public static ItemStack jungleLuminiteOre, jungleCopperOre, jungleWhiteGoldOre, jungleHoliumOre, jungleCondaiusOre, jungleAmnethiteOre, jungleDiamondOre, jungleObsidianOre;
	public static ItemStack luminiteBlock, whiteGoldBlock, condaiusBlock, holiumBlock, proAlloyBlock;

	public static void init()
	{
		String[] woodTypes = { "skybark", "dark_skybark", "cloudroot", "gold_wood", "magic_oak", "willow" };

		// Items

		stickItems = new CustomItem(woodTypes,
		                            StringUtils.concatAll(woodTypes, TEXTURE_DOMAIN + "materials/", "_stick"), null);

		final String[] materialNames = { "luminite", "copper_ingot", "white_gold_ingot", "holium_ingot",
			"condaius_dust", "amnethite_gem", "energy_orb", "obsidian_ingot", "pro_ingot" };
		materialItems = new CustomItem(materialNames,
		                               StringUtils.concatAll(materialNames, TEXTURE_DOMAIN + "minerals/", ""), null);

		lootItems = new ItemAeriusLoot(new String[] { "ice_stick", "gold_ball", "life_heart", "mana_star", "aerwand",
			"etherical_stone", "bottle_light", "hephaestos_flame", "chains" });

		aerianApple = (ItemFood) new ItemFood(2, 0, false).setTextureName(getTexture("food/aerian_apple"))
		                                                  .setCreativeTab(tabAeriusItems);
		staff = (ItemStaff) new ItemStaff().setCreativeTab(tabAeriusItems);

		fireSword = (ItemFireSword) new ItemFireSword().setTextureName(getTexture("weapons/fire_sword"))
		                                               .setCreativeTab(tabAeriusItems);
		iceHammer = (ItemIceHammer) new ItemIceHammer().setTextureName(getTexture("tools/ice_hammer"))
		                                               .setCreativeTab(tabAeriusItems);
		soul = (ItemAeriusSoul) new ItemAeriusSoul().setCreativeTab(tabAeriusItems);
		capes = (ItemCape) new ItemCape().setUnlocalizedName("cape").setCreativeTab(tabAeriusItems);

		String[] seeds = new String[] { "aerian_grass", "mud_grass", "corrupted_grass", "hallowed_grass",
			"mushroom_grass" };
		seedItems = new ItemAeriusSeeds(seeds, StringUtils.concatAll(seeds, "ed_aerius:food/", "_seeds"));

		accessories = (ItemAeriusAccessories) new ItemAeriusAccessories().setCreativeTab(tabAeriusItems);
		lifeGem = (ItemGem) new ItemGem(ItemArmor.ArmorMaterial.DIAMOND).setTextureName(getTexture("loot/life_gem"))
		                                                                .setCreativeTab(tabAeriusItems);
		manaGem = (ItemGem) new ItemGem(ItemArmor.ArmorMaterial.DIAMOND).setTextureName(getTexture("loot/mana_gem"))
		                                                                .setCreativeTab(tabAeriusItems);
		amnethiteParagonGem = (ItemGem) new ItemGem(ItemArmor.ArmorMaterial.DIAMOND)
			                                .setTextureName(getTexture("loot/amnethite_paragon_gem"))
			                                .setCreativeTab(tabAeriusItems);

		// Blocks

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

		initWoodBlocks(woodTypes);

		plantBlocks = (CustomBlock) new BlockAeriusPlants(new String[] { "angel_grass", "short_angel_grass",
			"corrupted_grass", "hallowed_grass", "mushroom_grass", "wanderers_bane", "wanderers_bane_small",
			"corrupted_vine", "hallowed_vine", "mushroom_vine" }).setHardness(0F).setCreativeTab(tabAeriusBlocks);

		String[] flowers = new String[] { "soulwhisker", "palebloom", "dawnbringer" };
		flowerBlocks = (CustomBlock) new BlockAeriusFlowers(flowers,
		                                                    StringUtils.prefixAll(flowers, getTexture("plants/")))
			                             .setCreativeTab(tabAeriusBlocks);

		cloud = (BlockCloud) new BlockCloud(cloudMaterial).setBlockTextureName(getTexture("clouds/cloud"))
		                                                  .setCreativeTab(tabAeriusBlocks);

		damnationTable = (BlockDamnationTable) new BlockDamnationTable().setCreativeTab(tabAeriusBlocks)
		                                                                .setHardness(4F);
	}

	private static void initOreBlocks()
	{
		final String[] oreNames = { "luminite", "copper", "white_gold", "holium", "condaius", "amnethite", "diamond",
			"obsidian" };
		oreBlocks = new CustomBlock(Material.rock, oreNames,
		                            StringUtils.concatAll(oreNames, TEXTURE_DOMAIN + "minerals/", "_ore_aerock"), null);
		jungleOreBlocks = new CustomBlock(Material.rock, oreNames,
		                                  StringUtils.concatAll(oreNames, TEXTURE_DOMAIN + "minerals/", "_ore_jungle"),
		                                  null);

		metalBlocks = new CustomBlock(Material.iron,
		                              new String[] { "luminite_block", "white_gold_block", "condaius_block",
			                              "holium_block", "pro_block" }, new String[] { getTexture("minerals/luminite_block"),
			                              getTexture("minerals/white_gold_block"),
			                              getTexture("minerals/condaius_block"), getTexture("minerals/holium_block"),
			                              getTexture("minerals/pro_block") }, null);
	}

	private static void initWoodBlocks(String[] woodTypes)
	{
		String[] woodTypes1 = { "skybark", "dark_skybark" };
		String[] woodTypes2 = { "cloudroot", "gold_wood", "magic_oak", "willow" };

		logBlocks = new BlockCustomLog(woodTypes1,
		                               StringUtils.concatAll(woodTypes1, TEXTURE_DOMAIN + "wood/", "_log_top"),
		                               StringUtils.concatAll(woodTypes1, TEXTURE_DOMAIN + "wood/", "_log_side"));
		logBlocks2 = new BlockCustomLog(woodTypes2,
		                                StringUtils.concatAll(woodTypes2, TEXTURE_DOMAIN + "wood/", "_log_top"),
		                                StringUtils.concatAll(woodTypes2, TEXTURE_DOMAIN + "wood/", "_log_side"));

		leafBlocks = new BlockCustomLeaves(woodTypes1,
		                                   StringUtils.concatAll(woodTypes1, TEXTURE_DOMAIN + "plants/", "_leaves"));
		leafBlocks2 = new BlockCustomLeaves(woodTypes2,
		                                    StringUtils.concatAll(woodTypes2, TEXTURE_DOMAIN + "plants/", "_leaves"));

		saplingBlocks = new BlockAeriusSapling(woodTypes1, StringUtils.concatAll(woodTypes1, TEXTURE_DOMAIN + "plants/",
		                                                                         "_sapling"));
		saplingBlocks2 = new BlockAeriusSapling(woodTypes2, StringUtils
			                                                    .concatAll(woodTypes2, TEXTURE_DOMAIN + "plants/",
			                                                               "_sapling"));

		plankBlocks = new CustomBlock(Material.wood, woodTypes,
		                              StringUtils.concatAll(woodTypes, TEXTURE_DOMAIN + "wood/", "_planks"), null);
	}

	public static void initStacks()
	{
		// Item Stacks

		skybarkStick = new ItemStack(stickItems, 1, 0);
		darkSkybarkStick = new ItemStack(stickItems, 1, 1);
		cloudrootStick = new ItemStack(stickItems, 1, 2);
		goldWoodStick = new ItemStack(stickItems, 1, 3);
		magicOakStick = new ItemStack(stickItems, 1, 4);
		willowStick = new ItemStack(stickItems, 1, 5);

		luminiteChunk = new ItemStack(materialItems, 1, 0);
		whiteGoldIngot = new ItemStack(materialItems, 1, 1);
		condaiusDust = new ItemStack(materialItems, 1, 2);
		holiumIngot = new ItemStack(materialItems, 1, 3);
		proAlloy = new ItemStack(materialItems, 1, 4);
		energyOrb = new ItemStack(materialItems, 1, 5);

		iceStick = new ItemStack(lootItems, 1, 0);
		lifeHeart = new ItemStack(lootItems, 1, 2);
		manaStar = new ItemStack(lootItems, 1, 3);
		aerwand = new ItemStack(lootItems, 1, 4);

		// Block Stacks

		aerock = new ItemStack(stoneBlocks, 1, 0);
		cobbledAerock = new ItemStack(stoneBlocks, 1, 1);
		mossyAerock = new ItemStack(stoneBlocks, 1, 2);

		luminiteOre = new ItemStack(oreBlocks, 1, 0);
		copperOre = new ItemStack(oreBlocks, 1, 1);
		whiteGoldOre = new ItemStack(oreBlocks, 1, 2);
		holiumOre = new ItemStack(oreBlocks, 1, 3);
		condaiusOre = new ItemStack(oreBlocks, 1, 4);
		amnethiteOre = new ItemStack(oreBlocks, 1, 5);
		diamondOre = new ItemStack(oreBlocks, 1, 6);
		obsidianOre = new ItemStack(oreBlocks, 1, 7);

		jungleLuminiteOre = new ItemStack(jungleOreBlocks, 1, 0);
		jungleCopperOre = new ItemStack(jungleOreBlocks, 1, 1);
		jungleWhiteGoldOre = new ItemStack(jungleOreBlocks, 1, 2);
		jungleHoliumOre = new ItemStack(jungleOreBlocks, 1, 3);
		jungleCondaiusOre = new ItemStack(jungleOreBlocks, 1, 4);
		jungleAmnethiteOre = new ItemStack(jungleOreBlocks, 1, 5);
		jungleDiamondOre = new ItemStack(jungleOreBlocks, 1, 6);
		jungleObsidianOre = new ItemStack(jungleOreBlocks, 1, 7);

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

	public static void load()
	{
		// Items

		materialItems.setCreativeTab(tabAeriusItems);
		lootItems.setCreativeTab(tabAeriusItems);
		stickItems.setCreativeTab(tabAeriusItems);

		ECItems.addItem(stickItems, "aerius_sticks");
		ECItems.addItem(materialItems, "aerius_materials");
		ECItems.addItem(seedItems, "aerius_seeds");
		ECItems.addItem(lootItems, "aerius_loot");
		ECItems.addItem(aerianApple, "aerian_apple");
		ECItems.addItem(fireSword, "fire_sword");
		ECItems.addItem(iceHammer, "ice_hammer");
		ECItems.addItem(capes, "cape");
		ECItems.addItem(accessories, "aerius_accessories");
		ECItems.addItem(lifeGem, "life_gem");
		ECItems.addItem(manaGem, "mana_gem");
		ECItems.addItem(amnethiteParagonGem, "amnethite_paragon_gem");

		// Blocks

		final ItemStack[] oreDrops = { luminiteChunk, null, condaiusDust, null, null, null, null, null };
		final float[] oreHardnesses = { 2.1F, 2.5F, 2.5F, 2.7F, 3F, 3F, 3F, 3F };

		stoneBlocks.setDrops(cobbledAerock, null, null, null).setHardnesses(1.5F, 2.0F, 2F, 2.2F)
		           .setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeStone);

		// TODO Hardnesses
		metalBlocks.setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeMetal);

		oreBlocks.setDrops(oreDrops).setHardnesses(oreHardnesses).setCreativeTab(tabAeriusBlocks)
		         .setStepSound(Block.soundTypeStone);
		jungleOreBlocks.setDrops(oreDrops).setHardnesses(oreHardnesses).setCreativeTab(tabAeriusBlocks)
		               .setStepSound(Block.soundTypeStone);

		dirtBlocks.setHardnesses(0.5F, 0.6F, 0.5F).setCreativeTab(tabAeriusBlocks).setStepSound(Block.soundTypeGravel)
		          .setHarvestLevel("shovel", 0);

		grassBlocks.setDirtBlocks(new Block[] { dirtBlocks, dirtBlocks, dirtBlocks, dirtBlocks, dirtBlocks },
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

		initStacks();
		addRecipes();
		setTabIcons();

		leafBlocks.setSaplingStacks(skybarkSapling, darkSkybarkSapling)
		          .setAppleStacks(new ItemStack(aerianApple), null, null, null);
		leafBlocks2.setSaplingStacks(cloudrootSapling, goldWoodSapling, magicOakSapling, willowSapling);
	}

	public static void addRecipes()
	{
		addPlanks(skybarkPlanks, skybarkLog);
		addPlanks(darkSkybarkPlanks, darkSkybarkLog);
		addPlanks(cloudrootPlanks, cloudrootLog);
		addPlanks(goldWoodPlanks, goldWoodLog);
		addPlanks(magicOakPlanks, magicOakLog);
		addPlanks(willowPlanks, willowLog);

		addStick(skybarkStick, skybarkPlanks);
		addStick(darkSkybarkStick, darkSkybarkPlanks);
		addStick(cloudrootStick, cloudrootPlanks);
		addStick(goldWoodStick, goldWoodPlanks);
		addStick(magicOakStick, magicOakPlanks);
		addStick(willowStick, willowPlanks);

		addFurnaceRecipe(whiteGoldOre, whiteGoldIngot, 0.2F);
		addFurnaceRecipe(holiumOre, holiumIngot, 2F);

		addStorageBlock(luminiteChunk, luminiteBlock, 3);
		addStorageBlock(whiteGoldIngot, whiteGoldBlock, 3);
		addStorageBlock(holiumIngot, holiumBlock, 3);
		addStorageBlock(condaiusDust, condaiusBlock, 3);
		addStorageBlock(proAlloy, proAlloyBlock, 3);
	}

	public static void setTabIcons()
	{
		tabAeriusBlocks.setIconItemStack(aerianGrass);
		tabAeriusItems.setIconItemStack(condaiusDust);
	}

	public static String getTexture(String name)
	{
		return TEXTURE_DOMAIN + name;
	}
}
