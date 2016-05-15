package minestrapteam.extracore.crafting.loader;

import minestrapteam.extracore.crafting.ECCrafting;
import net.minecraft.item.ItemStack;

public class FurnaceRecipeLoader extends CustomRecipeLoader
{
	public static FurnaceRecipeLoader	instance	= new FurnaceRecipeLoader();
	
	public FurnaceRecipeLoader()
	{
		super("furnace");
	}
	
	@Override
	public void addRecipe(ItemStack input, ItemStack output, float exp)
	{
		ECCrafting.addFurnaceRecipe(input, output, exp);
	}
}
