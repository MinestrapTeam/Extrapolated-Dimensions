package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.CSCrafting;
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
		
		CSCrafting.addCrafting(new ItemStack(MDMBlocks.POCPortalFrame), "nnn", "ndn", "nnn", 'n', Block.blockLapis, 'd', Item.diamond);
		
		CSCrafting.addCrafting(new ItemStack(MDMItems.elixirBottle, 6, 0), " n ", "n n", "nnn", 'n', Block.thinGlass);
		CSCrafting.addCrafting(new ItemStack(MDMItems.elixirBottle, 4, 1), " n ", " n ", "nnn", 'n', Block.thinGlass);
		
		// -- Heaven --
		
		CSCrafting.addShapelessCrafting(MDMBlocks.heavenwoodPlanks, MDMBlocks.heavenLogs);
		CSCrafting.addShapelessCrafting(MDMBlocks.goldwoodPlanks, MDMBlocks.goldwoodPlanks);
		CSCrafting.addCrafting(MDMItems.heavenwoodStick, "p", "p", 'p', MDMBlocks.heavenwoodPlanks);
		CSCrafting.addCrafting(MDMItems.goldwoodStick, "p", "p", 'p', MDMBlocks.goldwoodPlanks);
		
		CSCrafting.addSmelting(MDMBlocks.clashiumOre, MDMItems.clashiumIngot, 0.2F);
		CSCrafting.addSmelting(MDMBlocks.holyiumOre, MDMItems.holyiumIngot, 2F);
		
		CSCrafting.addStorageBlock(MDMItems.shrekiteShard, MDMBlocks.shrekiteBlock, 3);
		CSCrafting.addStorageBlock(MDMItems.clashiumIngot, MDMBlocks.clashiumBlock, 3);
		CSCrafting.addStorageBlock(MDMItems.holyiumIngot, MDMBlocks.holyiumBlock, 3);
		CSCrafting.addStorageBlock(MDMItems.bluriteDust, MDMBlocks.bluriteBlock, 3);
		CSCrafting.addStorageBlock(MDMItems.proAlloy, MDMBlocks.proAlloyBlock, 3);
		
		CSCrafting.addShapelessCrafting(MDMItems.shrekiteShard, MDMBlocks.shrekiteBlock);
		CSCrafting.addShapelessCrafting(MDMItems.clashiumIngot, MDMBlocks.clashiumBlock);
		CSCrafting.addShapelessCrafting(MDMItems.holyiumIngot, MDMBlocks.holyiumBlock);
		CSCrafting.addShapelessCrafting(MDMItems.bluriteDust, MDMBlocks.bluriteBlock);
		CSCrafting.addShapelessCrafting(MDMItems.proAlloy, MDMBlocks.proAlloyBlock);
		
	}
}
