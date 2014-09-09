package minestrapteam.virtious.lib;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class VRecipes
{
	public static void load()
	{
		// Ores
		GameRegistry.addSmelting(VBlocks.virtian_iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(VBlocks.deep_iron_ore, new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(VBlocks.brazeum_ore, new ItemStack(VItems.brazeum_ingot), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(VItems.brazeum_ingot, 9), new Object[] { "S", Character.valueOf('S'), VBlocks.brazeum_block });
		GameRegistry.addRecipe(new ItemStack(VItems.aquieus_shard, 9), new Object[] { "S", Character.valueOf('S'), VBlocks.aquieus_block });
		GameRegistry.addRecipe(new ItemStack(VItems.pluthorium_gem, 9), new Object[] { "S", Character.valueOf('S'), VBlocks.pluthorium_block });
		GameRegistry.addRecipe(new ItemStack(VItems.illuminous_gem, 4), new Object[] { "S", Character.valueOf('S'), VBlocks.illuminous_block });
		GameRegistry.addRecipe(new ItemStack(VBlocks.brazeum_block), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), VItems.brazeum_ingot });
		GameRegistry.addRecipe(new ItemStack(VBlocks.tak_block), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), VItems.tak });
		GameRegistry.addRecipe(new ItemStack(VBlocks.aquieus_block), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), VItems.aquieus_shard });
		GameRegistry.addRecipe(new ItemStack(VBlocks.pluthorium_block), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), VItems.pluthorium_gem });
		GameRegistry.addRecipe(new ItemStack(VBlocks.illuminous_block), new Object[] { "SS", "SS", Character.valueOf('S'), VItems.illuminous_gem });
		
		// Stone Blocks
		GameRegistry.addRecipe(new ItemStack(Blocks.furnace), new Object[] { "SSS", "S S", "SSS", 'S', VBlocks.virtianstone_cobbled });
		GameRegistry.addSmelting(VBlocks.virtianstone_cobbled, new ItemStack(VBlocks.virtianstone), 0.5F);
		GameRegistry.addRecipe(new ItemStack(VBlocks.virtianstone_bricks), new Object[] { "SS", "SS", Character.valueOf('S'), VBlocks.virtianstone });
		GameRegistry.addRecipe(new ItemStack(VBlocks.deepstone_bricks, 4), new Object[] { "SS", "SS", Character.valueOf('S'), VBlocks.deepstone });
		GameRegistry.addRecipe(new ItemStack(VBlocks.canyonstone_bricks, 4), new Object[] { "SS", "SS", Character.valueOf('S'), VBlocks.canyonstone });
		
		// Wood Blocks
		ItemStack virtianwoodPlanks = new ItemStack(VBlocks.virtious_planks, 4, 0);
		ItemStack amberwoodPlanks = new ItemStack(VBlocks.virtious_planks, 4, 1);
		GameRegistry.addShapelessRecipe(virtianwoodPlanks, new Object[] { new ItemStack(VBlocks.virtious_logs, 1, 0) });
		GameRegistry.addShapelessRecipe(amberwoodPlanks, new Object[] { new ItemStack(VBlocks.virtious_logs, 1, 1) });
		
		// Misc Blocks
		GameRegistry.addRecipe(new ItemStack(VBlocks.fuel_cell, 1), new Object[] { "IRI", "GCG", "IDI", Character.valueOf('I'), Blocks.iron_block, Character.valueOf('R'), Items.redstone, Character.valueOf('G'), Blocks.glass, Character.valueOf('D'), Items.diamond, Character.valueOf('C'), Blocks.coal_block });
		GameRegistry.addRecipe(new ItemStack(VBlocks.blue_torch, 8), new Object[] { "M", "T", "S", Character.valueOf('T'), VItems.tak, Character.valueOf('M'), new ItemStack(VBlocks.virtious_flowers, 1, 2), Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VBlocks.green_torch, 8), new Object[] { "M", "T", "S", Character.valueOf('T'), VItems.tak, Character.valueOf('M'), new ItemStack(VBlocks.virtious_flowers, 1, 3), Character.valueOf('S'), Items.stick });
		GameRegistry.addSmelting(VBlocks.fine_gravel, new ItemStack(VBlocks.rough_glass), 0.7F);
		
		// Tools
		GameRegistry.addRecipe(new ItemStack(VItems.amberwood_pickaxe, 1), new Object[] { "WWW", " S ", " S ", Character.valueOf('W'), amberwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.amberwood_axe, 1), new Object[] { "WW ", "WS ", " S ", Character.valueOf('W'), amberwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.amberwood_hoe, 1), new Object[] { "WW ", " S ", " S ", Character.valueOf('W'), amberwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.amberwood_shovel, 1), new Object[] { "W", "S", "S", Character.valueOf('W'), amberwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.amberwood_sword, 1), new Object[] { "W", "W", "S", Character.valueOf('W'), amberwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianwood_pickaxe, 1), new Object[] { "WWW", " S ", " S ", Character.valueOf('W'), virtianwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianwood_axe, 1), new Object[] { "WW ", "WS ", " S ", Character.valueOf('W'), virtianwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianwood_hoe, 1), new Object[] { "WW ", " S ", " S ", Character.valueOf('W'), virtianwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianwood_shovel, 1), new Object[] { "W", "S", "S", Character.valueOf('W'), virtianwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianwood_sword, 1), new Object[] { "W", "W", "S", Character.valueOf('W'), virtianwoodPlanks, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianstone_pickaxe, 1), new Object[] { "WWW", " S ", " S ", Character.valueOf('W'), VBlocks.virtianstone_cobbled, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianstone_axe, 1), new Object[] { "WW ", "WS ", " S ", Character.valueOf('W'), VBlocks.virtianstone_cobbled, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianstone_hoe, 1), new Object[] { "WW ", " S ", " S ", Character.valueOf('W'), VBlocks.virtianstone_cobbled, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianstone_shovel, 1), new Object[] { "W", "S", "S", Character.valueOf('W'), VBlocks.virtianstone_cobbled, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.virtianstone_sword, 1), new Object[] { "W", "W", "S", Character.valueOf('W'), VBlocks.virtianstone_cobbled, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.deepstone_pickaxe, 1), new Object[] { "WWW", " S ", " S ", Character.valueOf('W'), VBlocks.deepstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.deepstone_axe, 1), new Object[] { "WW ", "WS ", " S ", Character.valueOf('W'), VBlocks.deepstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.deepstone_hoe, 1), new Object[] { "WW ", " S ", " S ", Character.valueOf('W'), VBlocks.deepstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.deepstone_shovel, 1), new Object[] { "W", "S", "S", Character.valueOf('W'), VBlocks.deepstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.deepstone_sword, 1), new Object[] { "W", "W", "S", Character.valueOf('W'), VBlocks.deepstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.brazeum_pickaxe, 1), new Object[] { "WWW", " S ", " S ", Character.valueOf('W'), VItems.brazeum_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.brazeum_axe, 1), new Object[] { "WW ", "WS ", " S ", Character.valueOf('W'), VItems.brazeum_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.brazeum_hoe, 1), new Object[] { "WW ", " S ", " S ", Character.valueOf('W'), VItems.brazeum_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.brazeum_shovel, 1), new Object[] { "W", "S", "S", Character.valueOf('W'), VItems.brazeum_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.brazeum_sword, 1), new Object[] { "W", "W", "S", Character.valueOf('W'), VItems.brazeum_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.aquieus_pickaxe, 1), new Object[] { "WWW", " S ", " S ", Character.valueOf('W'), VItems.aquieus_shard, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.aquieus_axe, 1), new Object[] { "WW ", "WS ", " S ", Character.valueOf('W'), VItems.aquieus_shard, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.aquieus_hoe, 1), new Object[] { "WW ", " S ", " S ", Character.valueOf('W'), VItems.aquieus_shard, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.aquieus_shovel, 1), new Object[] { "W", "S", "S", Character.valueOf('W'), VItems.aquieus_shard, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.aquieus_sword, 1), new Object[] { "W", "W", "S", Character.valueOf('W'), VItems.aquieus_shard, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.pluthorium_pickaxe, 1), new Object[] { "WWW", " S ", " S ", Character.valueOf('W'), VItems.pluthorium_gem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.pluthorium_axe, 1), new Object[] { "WW ", "WS ", " S ", Character.valueOf('W'), VItems.pluthorium_gem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.pluthorium_hoe, 1), new Object[] { "WW ", " S ", " S ", Character.valueOf('W'), VItems.pluthorium_gem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.pluthorium_shovel, 1), new Object[] { "W", "S", "S", Character.valueOf('W'), VItems.pluthorium_gem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(VItems.pluthorium_sword, 1), new Object[] { "W", "W", "S", Character.valueOf('W'), VItems.pluthorium_gem, Character.valueOf('S'), Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(VItems.sticky_bomb, 1), new Object[] { "BBB", "BTB", "BBB", Character.valueOf('B'), VItems.brazeum_ingot, Character.valueOf('T'), VBlocks.tak_block });
		
		// Food
		GameRegistry.addSmelting(VItems.burhaunch_raw, new ItemStack(VItems.burhaunch_cooked, 1), 0.7F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(VItems.vois_food, 1), new ItemStack(VItems.burhaunch_cooked, 1), new ItemStack(VItems.veer_dye, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(VItems.vois_food, 1), new ItemStack(VItems.burhaunch_raw, 1), new ItemStack(VItems.veer_dye, 1));
		
		// Ore Dictionary
		OreDictionary.registerOre("treeSapling", VBlocks.virtious_saplings);
		OreDictionary.registerOre("treeLeaves", VBlocks.virtious_leaves);
		OreDictionary.registerOre("logWood", VBlocks.virtious_logs);
		OreDictionary.registerOre("plankWood", VBlocks.virtious_planks);
		
		OreDictionary.registerOre("oreIron", VBlocks.deep_iron_ore);
		OreDictionary.registerOre("oreIron", VBlocks.virtian_iron_ore);
		
		OreDictionary.registerOre("dyePink", VItems.veer_dye);
	}
}
