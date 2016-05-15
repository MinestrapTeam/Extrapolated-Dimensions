package minestrapteam.extracore.crafting;

import minestrapteam.extracore.item.stack.ECStacks;
import minestrapteam.extracore.util.logging.ECLog;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Class ECCrafting.
 * <p>
 * This class adds several utils for adding crafting and furnace recipes and analyzing them.
 *
 * @author Clashsoft
 */
public class ECCrafting
{
	public static final List<IRecipe>             RECIPES        = (List<IRecipe>) CraftingManager.getInstance()
	                                                                                              .getRecipeList();
	public static final Map<ItemStack, ItemStack> SMELTINGMAP    = (Map<ItemStack, ItemStack>) FurnaceRecipes.instance()
	                                                                                                         .getSmeltingList();
	public static final int                       WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;

	public static void updateItemStacks()
	{
		long now = System.currentTimeMillis();
		int count = 0;

		ItemStack stack;
		for (IRecipe r : RECIPES)
		{
			if (r instanceof ShapedRecipes)
			{
				ShapedRecipes sr = (ShapedRecipes) r;

				stack = sr.getRecipeOutput();
				stack.setItem(stack.getItem());
				count++;

				for (ItemStack is : sr.recipeItems)
				{
					if (is != null)
					{
						is.setItem(is.getItem());
						count++;
					}
				}
			}
			else if (r instanceof ShapelessRecipes)
			{
				ShapelessRecipes sr = (ShapelessRecipes) r;
				List<ItemStack> list = sr.recipeItems;

				stack = sr.getRecipeOutput();
				stack.setItem(stack.getItem());
				count++;

				for (ItemStack is : list)
				{
					is.setItem(is.getItem());
					count++;
				}
			}
		}

		for (Entry<ItemStack, ItemStack> entry : SMELTINGMAP.entrySet())
		{
			stack = entry.getKey();
			stack.setItem(stack.getItem());
			stack = entry.getValue();
			stack.setItem(stack.getItem());
			count += 2;
		}

		now = System.currentTimeMillis() - now;
		ECLog.info("Replaced " + count + " ItemStack references (" + now + "ms)");
	}

	/**
	 * Registers the given {@link IRecipe} {@code recipe}.
	 *
	 * @param recipe
	 * 	the recipe
	 */
	public static void registerRecipe(IRecipe recipe)
	{
		RECIPES.add(recipe);
	}

	/**
	 * Adds a new shaped crafting recipe to the game.
	 * <p>
	 * Save for adding advanced recipes (bigger than 3x3)
	 *
	 * @param output
	 * 	the output
	 * @param recipe
	 * 	the recipe
	 *
	 * @return the {@link ShapedRecipes} instance
	 */
	public static ShapedRecipes addRecipe(ItemStack output, Object... recipe)
	{
		return CraftingManager.getInstance().addRecipe(output, recipe);
	}

	public static ShapedOreRecipe addOreRecipe(ItemStack output, Object... recipe)
	{
		return new ShapedOreRecipe(output, recipe);
	}

	/**
	 * Adds a new shapeless crafting recipe to the game.
	 *
	 * @param output
	 * 	the output
	 * @param recipe
	 * 	the recipe
	 *
	 * @see GameRegistry#addShapelessRecipe(ItemStack, Object...)
	 */
	public static void addShapelessRecipe(ItemStack output, Object... recipe)
	{
		GameRegistry.addShapelessRecipe(output, recipe);
	}

	/**
	 * Adds a new furnace recipe to the game.
	 *
	 * @param input
	 * 	the input
	 * @param output
	 * 	the output
	 * @param experience
	 * 	the experience
	 */
	public static void addFurnaceRecipe(Item input, ItemStack output, float experience)
	{
		addFurnaceRecipe(new ItemStack(input), output, experience);
	}

	/**
	 * Adds a new furnace recipe to the game.
	 *
	 * @param input
	 * 	the input
	 * @param output
	 * 	the output
	 * @param experience
	 * 	the experience
	 */
	public static void addFurnaceRecipe(Block input, ItemStack output, float experience)
	{
		addFurnaceRecipe(new ItemStack(input, 1, OreDictionary.WILDCARD_VALUE), output, experience);
	}

	/**
	 * Adds a new furnace recipe to the game.
	 *
	 * @param input
	 * 	the input
	 * @param output
	 * 	the output
	 * @param experience
	 * 	the experience
	 */
	public static void addFurnaceRecipe(ItemStack input, ItemStack output, float experience)
	{
		FurnaceRecipes.instance().addSmeltingRecipe(input, output, experience);
	}

	/**
	 * Adds a recipe for a storage block. The size can be
	 * <p>
	 * 1:<br> [X] -> [O]
	 * <p>
	 * 2:<br> [X][X]<br> [X][X] -> [O]
	 * <p>
	 * 3:
	 * <p>
	 * [X][X][X]<br> [X][X][X] -> [O]<br> [X][X][X]
	 *
	 * @param material
	 * 	the input
	 * @param block
	 * 	the output
	 * @param size
	 * 	the size of the recipe
	 */
	public static void addStorageBlock(ItemStack material, ItemStack block, int size)
	{
		switch (size)
		{
		case 1:
			addShapelessRecipe(block, material);
			addShapelessRecipe(material, block);
			break;
		case 2:
			addShapelessRecipe(ECStacks.withSize(material, 4), block);
			addRecipe(block, "XX", "XX", 'X', material);
			break;
		case 3:
			addShapelessRecipe(ECStacks.withSize(material, 9), block);
			addRecipe(block, "XXX", "XXX", "XXX", 'X', material);
			break;
		default:
			throw new IllegalArgumentException("The size of a storage block recipe should be either 1, 2 or 3");
		}
	}

	/**
	 * Adds a new wooden stick-shaped recipe to the game.
	 *
	 * @param output
	 * 	the stick item stack
	 * @param input
	 * 	the planks item stack
	 */
	public static void addStick(ItemStack output, ItemStack input)
	{
		addRecipe(ECStacks.withSize(output, 4), "s", "s", 's', input);
	}

	/**
	 * Adds a new wood-planks-shaped recipe to the game.
	 *
	 * @param output
	 * 	the planks item stack
	 * @param input
	 * 	the log item stack
	 */
	public static void addPlanks(ItemStack output, ItemStack input)
	{
		addShapelessRecipe(ECStacks.withSize(output, 4), input);
	}

	public static void addHelmetRecipe(ItemStack output, Object input)
	{
		addOreRecipe(output, "XXX", "X X", 'X', input);
	}

	public static void addChestplateRecipe(ItemStack output, Object input)
	{
		addOreRecipe(output, "X X", "XXX", "XXX", 'X', input);
	}

	public static void addLeggingsRecipe(ItemStack output, Object input)
	{
		addOreRecipe(output, "XXX", "X X", "X X", 'X', input);
	}

	public static void addBootsRecipe(ItemStack output, Object input)
	{
		addOreRecipe(output, "X X", "X X", 'X', input);
	}

	public static void addGlovesRecipe(ItemStack output, Object input)
	{
		addOreRecipe(output, "X X", 'X', input);
	}

	public static void addSwordRecipe(ItemStack output, ItemStack material, Object stick)
	{
		addOreRecipe(output, "X", "X", "|", 'X', material, '|', stick);
	}

	public static void addShovelRecipe(ItemStack output, ItemStack material, Object stick)
	{
		addOreRecipe(output, "X", "|", "|", 'X', material, '|', stick);
	}

	public static void addPickaxeRecipe(ItemStack output, ItemStack material, Object stick)
	{
		addOreRecipe(output, "XXX", " | ", " | ", 'X', material, '|', stick);
	}

	public static void addAxeRecipe(ItemStack output, ItemStack material, Object stick)
	{
		addOreRecipe(output, "XX ", "X| ", " | ", 'X', material, '|', stick);
	}

	public static void addHoeRecipe(ItemStack output, ItemStack material, Object stick)
	{
		addOreRecipe(output, "XX", " |", " |", 'X', material, '|', stick);
	}

	/**
	 * Removes all recipes for the given {@link ItemStack} {@code output} from the game.
	 *
	 * @param output
	 * 	the output of the recipe
	 *
	 * @return the amount of recipes removed
	 */
	public static int removeRecipe(ItemStack output)
	{
		Iterator<IRecipe> iterator = RECIPES.iterator();
		IRecipe recipe;
		int count = 0;

		while (iterator.hasNext())
		{
			try
			{
				recipe = iterator.next();
				ItemStack stack = recipe.getRecipeOutput();
				if (ECStacks.stackEquals(output, stack))
				{
					iterator.remove();
					count++;
				}
			}
			catch (Exception ignored)
			{
			}
		}

		return count;
	}

	public static void registerOre(ItemStack ore, String name)
	{
		OreDictionary.registerOre(name, ore);
	}

	public static void registerOre(Item ore, String name)
	{
		OreDictionary.registerOre(name, new ItemStack(ore, 1, OreDictionary.WILDCARD_VALUE));
	}

	public static void registerOre(Block ore, String name)
	{
		OreDictionary.registerOre(name, new ItemStack(ore, 1, OreDictionary.WILDCARD_VALUE));
	}
}
