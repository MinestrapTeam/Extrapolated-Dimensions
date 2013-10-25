package clashsoft.mods.moredimensions.addons;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class POCRecipes
{
	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(POCBlocks.PortalFrame), new Object[] { "nnn", "ndn", "nnn", 'n', Block.blockLapis, 'd', Item.diamond });
		
		GameRegistry.addRecipe(new ItemStack(POCItems.ElixirBottle, 6, 0), new Object[] { " n ", "n n", "nnn", 'n', Block.thinGlass });
		GameRegistry.addRecipe(new ItemStack(POCItems.ElixirBottle, 4, 1), new Object[] { " n ", " n ", "nnn", 'n', Block.thinGlass });
	}
}
