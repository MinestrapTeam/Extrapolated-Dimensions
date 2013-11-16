package clashsoft.mods.moredimensions.addons;

import static clashsoft.clashsoftapi.util.CSCrafting.*;
import clashsoft.clashsoftapi.util.addons.Addon;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Addon(modName = "MoreDimensionsMod", addonName = "Recipes")
public class MDMRecipes
{
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addCrafting(new ItemStack(MDMBlocks.pocPortalFrame), "nnn", "ndn", "nnn", 'n', Block.blockLapis, 'd', Item.diamond);
		
		addCrafting(new ItemStack(MDMItems.elixirBottle, 6, 0), " n ", "n n", "nnn", 'n', Block.thinGlass);
		addCrafting(new ItemStack(MDMItems.elixirBottle, 4, 1), " n ", " n ", "nnn", 'n', Block.thinGlass);
		
		addPlanks(MDMBlocks.magicOakPlanks, MDMBlocks.magicOakLog);
		addPlanks(MDMBlocks.willowPlanks, MDMBlocks.willowLog);
		addStick(MDMItems.magicOakStick, MDMBlocks.magicOakPlanks);
		addStick(MDMItems.willowStick, MDMBlocks.willowPlanks);
		
		// -- Heaven --
		
		addPlanks(MDMBlocks.heavenWoodPlanks, MDMBlocks.heavenWoodLog);
		addPlanks(MDMBlocks.goldWoodPlanks, MDMBlocks.goldWoodLog);
		addStick(MDMItems.heavenWoodStick, MDMBlocks.heavenWoodPlanks);
		addStick(MDMItems.goldWoodStick, MDMBlocks.goldWoodPlanks);
		
		addSmelting(MDMBlocks.clashiumOre, MDMItems.clashiumIngot, 0.2F);
		addSmelting(MDMBlocks.holyiumOre, MDMItems.holyiumIngot, 2F);
		
		addStorageBlock(MDMItems.shrekiteShard, MDMBlocks.shrekiteBlock, 3);
		addStorageBlock(MDMItems.clashiumIngot, MDMBlocks.clashiumBlock, 3);
		addStorageBlock(MDMItems.holyiumIngot, MDMBlocks.holyiumBlock, 3);
		addStorageBlock(MDMItems.bluriteDust, MDMBlocks.bluriteBlock, 3);
		addStorageBlock(MDMItems.proAlloy, MDMBlocks.proAlloyBlock, 3);
		
		addShapelessCrafting(MDMItems.shrekiteShard, MDMBlocks.shrekiteBlock);
		addShapelessCrafting(MDMItems.clashiumIngot, MDMBlocks.clashiumBlock);
		addShapelessCrafting(MDMItems.holyiumIngot, MDMBlocks.holyiumBlock);
		addShapelessCrafting(MDMItems.bluriteDust, MDMBlocks.bluriteBlock);
		addShapelessCrafting(MDMItems.proAlloy, MDMBlocks.proAlloyBlock);
		
	}
}
