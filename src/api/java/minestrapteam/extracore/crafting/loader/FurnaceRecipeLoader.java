package minestrapteam.extracore.crafting.loader;

import minestrapteam.extracore.crafting.ECCrafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FurnaceRecipeLoader extends CustomRecipeLoader
{
	public static FurnaceRecipeLoader	instance	= new FurnaceRecipeLoader();
	
	public FurnaceRecipeLoader()
	{
		super("furnace");
	}
	
	@Override
	public void addRecipe(Item input, int inputMeta, Item output, int outputMeta, int amount, float exp)
	{
		ECCrafting.addFurnaceRecipe(new ItemStack(input, 1, inputMeta), new ItemStack(output, amount, outputMeta), exp);
	}
}
