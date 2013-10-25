package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.CustomBlock;
import clashsoft.clashsoftapi.ItemCustomBlock;
import clashsoft.clashsoftapi.util.CSBlocks;
import clashsoft.clashsoftapi.util.CSCrafting;
import clashsoft.clashsoftapi.util.CSItems;
import clashsoft.clashsoftapi.util.CSLang;
import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.block.*;
import clashsoft.mods.moredimensions.client.ClientProxy;
import clashsoft.mods.moredimensions.common.CommonProxy;
import clashsoft.mods.moredimensions.entity.EntityScider;
import clashsoft.mods.moredimensions.item.*;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.common.EnumHelper;

@Addon(modName = "MoreDimensionsMod", addonName = "Heaven")
public class MDMHeaven
{
	public static int				SCIDER_ID				= EntityRegistry.findGlobalUniqueEntityId();
	
	/* Tool and Armor Material */
	public static EnumToolMaterial	HEAVENWOODt				= EnumToolMaterial.WOOD;
	public static EnumToolMaterial	HEAVENSTONEt			= EnumHelper.addToolMaterial("HEAVENSTONE", 1, 128, 4.5F, 2, 15);
	public static EnumToolMaterial	SYWOXITEt				= EnumHelper.addToolMaterial("SYWOXITE", 2, 256, 5F, 3, 15);
	public static EnumToolMaterial	CLASHIUMt				= EnumHelper.addToolMaterial("CLASHIUM", 3, 1024, 10F, 5, 15);
	public static EnumToolMaterial	HOLYIUMt				= EnumHelper.addToolMaterial("HALLOWED", 3, 4096, 5F, 20, 15);
	public static EnumToolMaterial	ENERGYt					= EnumHelper.addToolMaterial("ENERGY", 3, 1536, 4F, 10, 2);
	public static EnumToolMaterial	FLAMING					= EnumToolMaterial.IRON;
	
	public static EnumArmorMaterial	SYWOXITEa				= EnumHelper.addArmorMaterial("SYWOXITE", 15, new int[] { 2, 7, 5, 2 }, 9);
	public static EnumArmorMaterial	CLASHIUMa				= EnumHelper.addArmorMaterial("CLASHIUM", 33, new int[] { 4, 9, 6, 4 }, 11);
	public static EnumArmorMaterial	HOLYIUMa				= EnumHelper.addArmorMaterial("HALLOWED", 100, new int[] { 10, 15, 13, 6 }, 10);
	public static EnumArmorMaterial	ENERGYa					= EnumHelper.addArmorMaterial("ENERGY", 200, new int[] { 100, 150, 130, 60 }, 2);
	
	/* Items */
	
	public static Item				heavenStoneSword		= (new ItemSword(26000, HEAVENSTONEt)).setUnlocalizedName("heavenstoneSword");
	public static Item				heavenStoneShovel		= (new ItemSpade(26001, HEAVENSTONEt)).setUnlocalizedName("heavenstoneShovel");
	public static Item				heavenStonePick			= (new ItemPickaxe(26002, HEAVENSTONEt)).setUnlocalizedName("heavenstonePickaxe");
	public static Item				heavenStoneAxe			= (new ItemAxe(26003, HEAVENSTONEt)).setUnlocalizedName("heavenstoneAxe");
	public static Item				heavenStoneHoe			= (new ItemHoe(26004, HEAVENSTONEt)).setUnlocalizedName("heavenstoneHoe");
	
	public static Item				heavenWoodSword			= (new ItemSword(26005, HEAVENWOODt)).setUnlocalizedName("heavenwoodSword");
	public static Item				heavenWoodShovel		= (new ItemSpade(26006, HEAVENWOODt)).setUnlocalizedName("heavenwoodShovel");
	public static Item				heavenWoodPick			= (new ItemPickaxe(26007, HEAVENWOODt)).setUnlocalizedName("heavenwoodPickaxe");
	public static Item				heavenWoodAxe			= (new ItemAxe(26008, HEAVENWOODt)).setUnlocalizedName("heavenwoodAxe");
	public static Item				heavenWoodHoe			= (new ItemHoe(26009, HEAVENWOODt)).setUnlocalizedName("heavenwoodHoe");
	
	public static Item				sywoxiteSword			= (new ItemSword(26010, SYWOXITEt)).setUnlocalizedName("sywoxiteSword");
	public static Item				sywoxiteShovel			= (new ItemSpade(26011, SYWOXITEt)).setUnlocalizedName("sywoxiteShovel");
	public static Item				sywoxitePick			= (new ItemPickaxe(26012, SYWOXITEt)).setUnlocalizedName("sywoxitePickaxe");
	public static Item				sywoxiteAxe				= (new ItemAxe(26013, SYWOXITEt)).setUnlocalizedName("sywoxiteAxe");
	public static Item				sywoxiteHoe				= (new ItemHoe(26014, SYWOXITEt)).setUnlocalizedName("sywoxiteHoe");
	public static Item				sywoxiteHelmet			= (new ItemArmor(26015, SYWOXITEa, CommonProxy.sywoxite, 0)).setUnlocalizedName("sywoxiteHelmet");
	public static Item				sywoxiteChestplate		= (new ItemArmor(26016, SYWOXITEa, CommonProxy.sywoxite, 1)).setUnlocalizedName("sywoxiteChestplate");
	public static Item				sywoxiteLeggings		= (new ItemArmor(26017, SYWOXITEa, CommonProxy.sywoxite, 2)).setUnlocalizedName("sywoxiteLeggings");
	public static Item				sywoxiteBoots			= (new ItemArmor(26018, SYWOXITEa, CommonProxy.sywoxite, 3)).setUnlocalizedName("sywoxiteBoots");
	
	public static Item				clashiumSword			= (new ItemSword(26019, CLASHIUMt)).setUnlocalizedName("clashiumSword");
	public static Item				clashiumShovel			= (new ItemSpade(26020, CLASHIUMt)).setUnlocalizedName("clashiumShovel");
	public static Item				clashiumPick			= (new ItemPickaxe(26021, CLASHIUMt)).setUnlocalizedName("clashiumPickaxe");
	public static Item				clashiumAxe				= (new ItemAxe(26022, CLASHIUMt)).setUnlocalizedName("clashiumAxe");
	public static Item				clashiumHoe				= (new ItemHoe(26023, CLASHIUMt)).setUnlocalizedName("clashiumHoe");
	// 24, 25, 26, 27
	
	public static Item				holyiumSword			= (new ItemSword(26028, HOLYIUMt)).setUnlocalizedName("holyiumSword");
	public static Item				holyiumShovel			= (new ItemSpade(26029, HOLYIUMt)).setUnlocalizedName("holyiumShovel");
	public static Item				holyiumPick				= (new ItemPickaxe(26030, HOLYIUMt)).setUnlocalizedName("holyiumPickaxe");
	public static Item				holyiumAxe				= (new ItemAxe(26031, HOLYIUMt)).setUnlocalizedName("holyiumAxe");
	public static Item				holyiumHoe				= (new ItemHoe(26032, HOLYIUMt)).setUnlocalizedName("holyiumHoe");
	// 33, 34, 35, 3
	
	public static Item				energySword				= (new ItemSword(26037, ENERGYt)).setUnlocalizedName("energySword");
	public static Item				energyShovel			= (new ItemSpade(26038, ENERGYt)).setUnlocalizedName("energyShovel");
	public static Item				energyPick				= (new ItemPickaxe(26039, ENERGYt)).setUnlocalizedName("energyPickaxe");
	public static Item				energyAxe				= (new ItemAxe(26040, ENERGYt)).setUnlocalizedName("energyAxe");
	public static Item				energyHoe				= (new ItemHoe(26041, ENERGYt)).setUnlocalizedName("energyHoe");
	// 42, 43, 44, 45
	
	public static Item				heavenStick				= (new ItemHeavenMisc(26046, CreativeTabs.tabMaterials)).setUnlocalizedName("heavenstick");
	public static Item				sywoxiteShard			= (new ItemHeavenMisc(26047, CreativeTabs.tabMaterials)).setUnlocalizedName("sywoxite_shard");
	public static Item				clashiumIngot			= (new ItemHeavenMisc(26048, CreativeTabs.tabMaterials)).setUnlocalizedName("clashium_ingot");
	public static Item				holyiumIngot			= (new ItemHeavenMisc(26049, CreativeTabs.tabMaterials)).setUnlocalizedName("holyium_ingot");
	public static Item				bluriteDust				= (new ItemBlurite(26050)).setUnlocalizedName("blurite_dust");
	public static Item				heavenBow				= (new ItemHeavenBow(26051)).setUnlocalizedName("heavenbow");
	public static Item				heavenArrow				= (new ItemHeavenMisc(25052, CreativeTabs.tabCombat)).setUnlocalizedName("heavenarrow");
	public static Item				heavenApple				= (new ItemHeavenFood(26053, 2, 0, false)).setUnlocalizedName("heavenapple");
	public static Item				heart					= (new ItemLifeHeart(26053, 2, 0F)).setUnlocalizedName("heart");
	// Boss Loot
	public static Item				flamingSword			= (new ItemFlamingSword(26100)).setUnlocalizedName("fireSword_1");
	public static Item				pulsingSword			= (new ItemPulsingSword(26101)).setUnlocalizedName("pulsatingSword_1");
	public static Item				icestick				= (new ItemIceStick(26102)).setUnlocalizedName("icestick");
	public static Item				icehammer				= (new ItemIceHammer(26103)).setUnlocalizedName("icehammer");
	public static Item				soul					= (new ItemHeavenSoul(26104)).setUnlocalizedName("soul");
	
	public static Item				heavenPortalActivator	= (new ItemHeavenPortalActivator(26099)).setUnlocalizedName("wand");
	
	/* Blocks */
	
	public static BlockHeavenPortal	heavenPortal			= (BlockHeavenPortal) (new BlockHeavenPortal(200)).setUnlocalizedName("heavenportal").setHardness(-1F).setLightValue(1F);
	public static Block				heavenPortalFrame		= (new BlockHeavenPortalFrame(201)).setUnlocalizedName("heavenportal_frame").setHardness(2F);
	
	public static CustomBlock		stoneBlocks				= (CustomBlock) new CustomBlock(202, Material.rock, new String[] { "Heavenstone", "Heavencobblestone", "Mossy Heavenstone", "Sywoxite Ore", "Clashium Ore", "Blurite Ore", "Holyium Ore", "Sywoxite Block", "Clashium Block", "Blurite Block", "Holyium Block" }, new String[] { "heavenstone", "heavencobble", "heavencobble_mossy", "sywoxite_ore", "clashium_ore", "blurite_ore", "holyium_ore", "sywoxite_block", "clashium_block", "blurite_block", "holyium_block" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setHardnesses(new float[] { 1.5F, 2.0F, 2.0F, 2F, 2.2F, 2.1F, 2.5F, 2.5F, 2.7F, 2.6F, 3F }).setDrops(new ItemStack[] { new ItemStack(200, 1, 1), null, null, new ItemStack(sywoxiteShard, 1, 1), null, new ItemStack(bluriteDust, 1, 3), null, null, null, null, null }).setUnlocalizedName("heavenStoneBlocks").setStepSound(Block.soundStoneFootstep);
	
	public static CustomBlock		woodBlocks				= (CustomBlock) new CustomBlock(203, Material.wood, new String[] { "Heavenplanks" }, new String[] { "heavenplanks" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setHardnesses(new float[] { 2.0F }).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("heavenWoodBlocks");
	
	public static CustomBlock		groundBlocks			= (CustomBlock) new CustomBlock(204, Material.ground, new String[] { "Heavendirt" }, new String[] { "heavendirt" }, new CreativeTabs[] { CreativeTabs.tabBlock }).setHardnesses(new float[] { 0.5F }).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("heavenGroundBlocks");
	
	public static CustomBlock		plantBlocks				= (CustomBlock) new BlockHeavenPlant(205, new String[] { "Blue Flower", "Orange Flower", "Ground Vine", "Round Plant" }, new String[] { "heavenplant_blue", "heavenplant_orange", "heavenplant_vine", "heavenplant_circle" }).setHardnesses(new float[] { 0F, 0F, 0F, 0F }).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenPlantBlocks");
	
	public static Block				heavenLog				= (new BlockHeavenLog(210)).setUnlocalizedName("heavenwood_side").setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
	
	public static Block				heavenGrass				= (new BlockHeavenGrass(211)).setUnlocalizedName("heavengrass").setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
	public static BlockHeavenLeaves	heavenLeaves			= (BlockHeavenLeaves) (new BlockHeavenLeaves(212)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavenleaves");
	
	public static Block				heavenSapling			= (new BlockHeavenSapling(213)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("heavensapling");
	
	public static Block				heavenPillar			= (new BlockHeavenPillar(214)).setUnlocalizedName("pillar").setHardness(1.75F);
	public static Block				compressor				= (new BlockHeavenCompressor(215)).setUnlocalizedName("heavenfurnace_top").setHardness(1.8F);
	
	public static void load()
	{
		GameRegistry.registerBlock(stoneBlocks, ItemCustomBlock.class, "MoreDimensions_" + stoneBlocks.getUnlocalizedName());
		GameRegistry.registerBlock(woodBlocks, ItemCustomBlock.class, "MoreDimensions_" + woodBlocks.getUnlocalizedName());
		GameRegistry.registerBlock(groundBlocks, ItemCustomBlock.class, "MoreDimensions_" + groundBlocks.getUnlocalizedName());
		GameRegistry.registerBlock(plantBlocks, ItemCustomBlock.class, "MoreDimensions_" + plantBlocks.getUnlocalizedName());
		stoneBlocks.addNames();
		woodBlocks.addNames();
		groundBlocks.addNames();
		plantBlocks.addNames();
		
		CSCrafting.addShapelessCrafting(new ItemStack(woodBlocks, 4, 0), heavenLog);
		
		CSBlocks.addBlock(heavenPortalFrame, "Heaven Portal Frame");
		CSBlocks.addBlock(heavenPortal, "Heaven Portal");
		CSBlocks.addBlock(heavenGrass, "Heaven Grass");
		CSBlocks.addBlock(heavenLog, "Heaven Wood");
		CSBlocks.addBlock(heavenLeaves, "Heaven Tree Leaves");
		CSBlocks.addBlock(heavenSapling, "Heaven Tree Sapling");
		CSBlocks.addBlock(heavenPillar, "Heaven Pillar");
		CSBlocks.addBlock(compressor, "Compressor");
		
		/* Items */
		
		CSItems.addItemWithRecipe(heavenStick, "Heaven Wood Stick", 4, new Object[] { "w", "w", Character.valueOf('w'), new ItemStack(woodBlocks, 1, 0) });
		CSItems.addItem(heavenPortalActivator, "Heaven Portal Activator");
		
		CSItems.addItemWithRecipe(heavenStoneSword, "Heavenstone Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStoneShovel, "Heavenstone Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStonePick, "Heavenstone Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStoneAxe, "Heavenstone Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenStoneHoe, "Heavenstone Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 1), Character.valueOf('|'), heavenStick });
		
		CSItems.addItemWithRecipe(heavenWoodSword, "Heavenwood Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), new ItemStack(woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodShovel, "Heavenwood Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), new ItemStack(woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodPick, "Heavenwood Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), new ItemStack(woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodAxe, "Heavenwood Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), new ItemStack(woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenWoodHoe, "Heavenwood Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), new ItemStack(woodBlocks, 1, 0), Character.valueOf('|'), heavenStick });
		
		CSItems.addItemWithRecipe(sywoxiteSword, "Sywoxite Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), sywoxiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(sywoxiteShovel, "Sywoxite Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), sywoxiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(sywoxitePick, "Sywoxite Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), sywoxiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(sywoxiteAxe, "Sywoxite Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), sywoxiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(sywoxiteHoe, "Sywoxite Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), sywoxiteShard, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(sywoxiteHelmet, "Sywoxite Helmet", 1, new Object[] { "XXX", "X X", Character.valueOf('X'), sywoxiteShard });
		CSItems.addItemWithRecipe(sywoxiteChestplate, "Sywoxite Chestplate", 1, new Object[] { "X X", "XXX", "XXX", Character.valueOf('X'), sywoxiteShard });
		CSItems.addItemWithRecipe(sywoxiteLeggings, "Sywoxite Leggings", 1, new Object[] { "XXX", "X X", "X X", Character.valueOf('X'), sywoxiteShard });
		CSItems.addItemWithRecipe(sywoxiteBoots, "Sywoxite Boots", 1, new Object[] { "X X", "X X", Character.valueOf('X'), sywoxiteShard });
		
		CSItems.addItemWithRecipe(clashiumSword, "Clashium Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumShovel, "Clashium Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumPick, "Clashium Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumAxe, "Clashium Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(clashiumHoe, "Clashium Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), clashiumIngot, Character.valueOf('|'), heavenStick });
		
		CSItems.addItemWithRecipe(holyiumSword, "Holyium Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumShovel, "Holyium Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumPick, "Holyium Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumAxe, "Holyium Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(holyiumHoe, "Holyium Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), holyiumIngot, Character.valueOf('|'), heavenStick });
		
		CSItems.addItem(energySword, "Energy Sword");
		CSItems.addItem(energyShovel, "Energy Shovel");
		CSItems.addItem(energyPick, "Energy Pickaxe");
		CSItems.addItem(energyAxe, "Energy Axe");
		CSItems.addItem(energyHoe, "Energy Hoe");
		
		CSItems.addItemWithRecipe(sywoxiteShard, "Sywoxite Shard", 9, new Object[] { "X", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 7) });
		CSItems.addItemWithRecipe(clashiumIngot, "Clashium Ingot", 9, new Object[] { "X", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 8) });
		CSCrafting.addSmelting(new ItemStack(stoneBlocks, 1, 4), new ItemStack(clashiumIngot), 1F);
		CSItems.addItemWithRecipe(holyiumIngot, "Holyium Ingot", 9, new Object[] { "X", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 10) });
		CSCrafting.addSmelting(new ItemStack(stoneBlocks, 1, 6), new ItemStack(holyiumIngot), 2F);
		CSItems.addItemWithRecipe(bluriteDust, "Blurite Dust", 9, new Object[] { "X", Character.valueOf('X'), new ItemStack(stoneBlocks, 1, 9) });
		CSItems.addItemWithRecipe(heavenBow, "Heaven Bow", 1, new Object[] { "s| ", "s |", "s| ", Character.valueOf('s'), Item.silk, Character.valueOf('|'), heavenStick });
		CSItems.addItemWithRecipe(heavenArrow, "Heaven Arrow", 1, new Object[] { "s", "|", "f", Character.valueOf('s'), sywoxiteShard, Character.valueOf('|'), heavenStick, Character.valueOf('f'), Item.feather });
		CSItems.addItem(heavenApple, "Heaven Apple");
		CSItems.addItem(flamingSword, "Flaming Sword");
		CSItems.addItem(pulsingSword, "Pulsing Sword");
		CSItems.addItemWithRecipe(icestick, "Ice Stick", 1, new Object[] { "i", "i", Character.valueOf('i'), Block.ice });
		CSItems.addItemWithRecipe(icehammer, "Ice Hammer", 1, new Object[] { "IiI", "IiI", " i ", Character.valueOf('I'), Block.ice, Character.valueOf('i'), icestick });
		for (int i = 0; i < 16; i++)
		{
			CSLang.addLocalizationUS(soul.getUnlocalizedName() + "." + i, "Soul of " + ItemHeavenSoul.soulNames[i]);
		}
		
		// Load the renderer(s) in ClientProxy.
		ClientProxy.registerRenderInformation();
		// Setting Localization/Name of entity.
		LanguageRegistry.instance().addStringLocalization("entity.Scider.name", "en_US", "Scider");
		// Registers the entities.
		EntityRegistry.registerGlobalEntityID(EntityScider.class, "Scider", SCIDER_ID);
	}
}
