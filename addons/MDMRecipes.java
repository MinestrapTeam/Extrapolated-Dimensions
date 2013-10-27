package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.CSCrafting;
import clashsoft.clashsoftapi.util.addons.Addon;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Addon(modName = "MoreDimensionsMod", addonName = "Recipes")
public class MDMRecipes
{
	public static void load()
	{
		// -- Paradise of Chaos --
		
		GameRegistry.addRecipe(new ItemStack(MDMBlocks.POCPortalFrame), new Object[] { "nnn", "ndn", "nnn", 'n', Block.blockLapis, 'd', Item.diamond });
		
		GameRegistry.addRecipe(new ItemStack(MDMItems.elixirBottle, 6, 0), new Object[] { " n ", "n n", "nnn", 'n', Block.thinGlass });
		GameRegistry.addRecipe(new ItemStack(MDMItems.elixirBottle, 4, 1), new Object[] { " n ", " n ", "nnn", 'n', Block.thinGlass });
		
		// -- Heaven --
		
		CSCrafting.addShapelessCrafting(new ItemStack(MDMBlocks.woodBlocks, 4, 0), MDMBlocks.heavenLog);
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
