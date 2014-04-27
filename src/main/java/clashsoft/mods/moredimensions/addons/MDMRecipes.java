package clashsoft.mods.moredimensions.addons;

import static clashsoft.cslib.minecraft.crafting.CSCrafting.*;
import clashsoft.cslib.minecraft.addon.Addon;
import clashsoft.cslib.minecraft.item.CSStacks;

import net.minecraft.item.ItemStack;

@Addon(modName = "MoreDimensionsMod", addonName = "Recipes")
public class MDMRecipes
{
	public static void load()
	{
		// -- Paradise of Chaos --
		
		addRecipe(MDMBlocks.pocPortalFrame, "nnn", "ndn", "nnn", 'n', CSStacks.lapis_block, 'd', CSStacks.diamond);
		
		addRecipe(new ItemStack(MDMItems.elixirBottle, 6, 0), " n ", "n n", "nnn", 'n', CSStacks.glass_pane);
		addRecipe(new ItemStack(MDMItems.elixirBottle, 4, 1), " n ", " n ", "nnn", 'n', CSStacks.glass_pane);
		
		addPlanks(MDMBlocks.magicOakPlanks, MDMBlocks.magicOakLog);
		addPlanks(MDMBlocks.willowPlanks, MDMBlocks.willowLog);
		addStick(MDMItems.magicOakStick, MDMBlocks.magicOakPlanks);
		addStick(MDMItems.willowStick, MDMBlocks.willowPlanks);
		
		// -- Heaven --
		
		addPlanks(MDMBlocks.heavenWoodPlanks, MDMBlocks.heavenWoodLog);
		addPlanks(MDMBlocks.goldWoodPlanks, MDMBlocks.goldWoodLog);
		addStick(MDMItems.heavenWoodStick, MDMBlocks.heavenWoodPlanks);
		addStick(MDMItems.goldWoodStick, MDMBlocks.goldWoodPlanks);
		
		addFurnaceRecipe(MDMBlocks.clashiumOre, MDMItems.clashiumIngot, 0.2F);
		addFurnaceRecipe(MDMBlocks.holyiumOre, MDMItems.holyiumIngot, 2F);
		
		addStorageBlock(MDMItems.shrekiteShard, MDMBlocks.shrekiteBlock, 3);
		addStorageBlock(MDMItems.clashiumIngot, MDMBlocks.clashiumBlock, 3);
		addStorageBlock(MDMItems.holyiumIngot, MDMBlocks.holyiumBlock, 3);
		addStorageBlock(MDMItems.bluriteDust, MDMBlocks.bluriteBlock, 3);
		addStorageBlock(MDMItems.proAlloy, MDMBlocks.proAlloyBlock, 3);
		
		addShapelessRecipe(MDMItems.shrekiteShard, MDMBlocks.shrekiteBlock);
		addShapelessRecipe(MDMItems.clashiumIngot, MDMBlocks.clashiumBlock);
		addShapelessRecipe(MDMItems.holyiumIngot, MDMBlocks.holyiumBlock);
		addShapelessRecipe(MDMItems.bluriteDust, MDMBlocks.bluriteBlock);
		addShapelessRecipe(MDMItems.proAlloy, MDMBlocks.proAlloyBlock);
		
	}
}
