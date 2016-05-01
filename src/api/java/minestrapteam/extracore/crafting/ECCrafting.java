package minestrapteam.extracore.crafting;

import minestrapteam.extracore.util.logging.ECLog;
import minestrapteam.extracore.item.stack.ECStacks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static minestrapteam.extracore.item.stack.ECStacks.stick;

/**
 * The Class ECCrafting.
 * <p>
 * This class adds several utils for adding crafting and furnace recipes and
 * analyzing them.
 * 
 * @author Clashsoft
 */
public class ECCrafting
{
	public static final List<IRecipe>				RECIPES			= CraftingManager.getInstance().getRecipeList();
	public static final Map<ItemStack, ItemStack>	SMELTINGMAP		= FurnaceRecipes.smelting().getSmeltingList();
	public static final int							WILDCARD_VALUE	= OreDictionary.WILDCARD_VALUE;
	
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
				stack.func_150996_a(stack.getItem());
				count++;
				
				for (ItemStack is : sr.recipeItems)
				{
					if (is != null)
					{
						is.func_150996_a(is.getItem());
						count++;
					}
				}
			}
			else if (r instanceof ShapelessRecipes)
			{
				ShapelessRecipes sr = (ShapelessRecipes) r;
				List<ItemStack> list = sr.recipeItems;
				
				stack = sr.getRecipeOutput();
				stack.func_150996_a(stack.getItem());
				count++;
				
				for (ItemStack is : list)
				{
					is.func_150996_a(is.getItem());
					count++;
				}
			}
		}
		
		for (Entry<ItemStack, ItemStack> entry : SMELTINGMAP.entrySet())
		{
			stack = entry.getKey();
			stack.func_150996_a(stack.getItem());
			stack = entry.getValue();
			stack.func_150996_a(stack.getItem());
			count += 2;
		}
		
		now = System.currentTimeMillis() - now;
		ECLog.info("Replaced " + count + " ItemStack references (" + now + "ms)");
	}
	
	/**
	 * Registers the given {@link IRecipe} {@code recipe}.
	 * 
	 * @param recipe
	 *            the recipe
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
	 *            the output
	 * @param recipe
	 *            the recipe
	 * @return the {@link ShapedRecipes} instance
	 */
	public static ShapedRecipes addRecipe(ItemStack output, Object... recipe)
	{
		return CraftingManager.getInstance().addRecipe(output, recipe);
	}
	
	/**
	 * Adds a new shapeless crafting recipe to the game.
	 * 
	 * @param output
	 *            the output
	 * @param recipe
	 *            the recipe
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
	 *            the input
	 * @param output
	 *            the output
	 * @param experience
	 *            the experience
	 */
	public static void addFurnaceRecipe(Item input, ItemStack output, float experience)
	{
		addFurnaceRecipe(new ItemStack(input), output, experience);
	}
	
	/**
	 * Adds a new furnace recipe to the game.
	 * 
	 * @param input
	 *            the input
	 * @param output
	 *            the output
	 * @param experience
	 *            the experience
	 */
	public static void addFurnaceRecipe(Block input, ItemStack output, float experience)
	{
		addFurnaceRecipe(new ItemStack(input, 1, OreDictionary.WILDCARD_VALUE), output, experience);
	}
	
	/**
	 * Adds a new furnace recipe to the game.
	 * 
	 * @param input
	 *            the input
	 * @param output
	 *            the output
	 * @param experience
	 *            the experience
	 */
	public static void addFurnaceRecipe(ItemStack input, ItemStack output, float experience)
	{
		FurnaceRecipes.smelting().func_151394_a(input, output, experience);
	}
	
	/**
	 * Adds a recipe for a storage block. The size can be
	 * <p>
	 * 1:<br>
	 * [X] -> [O]
	 * <p>
	 * 2:<br>
	 * [X][X]<br>
	 * [X][X] -> [O]
	 * <p>
	 * 3:
	 * <p>
	 * [X][X][X]<br>
	 * [X][X][X] -> [O]<br>
	 * [X][X][X]
	 * 
	 * @param material
	 *            the input
	 * @param block
	 *            the output
	 * @param size
	 *            the size of the recipe
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
	 *            the stick item stack
	 * @param input
	 *            the planks item stack
	 */
	public static void addStick(ItemStack output, ItemStack input)
	{
		addRecipe(ECStacks.withSize(output, 4), "s", "s", 's', input);
	}
	
	/**
	 * Adds a new wood-planks-shaped recipe to the game.
	 * 
	 * @param output
	 *            the planks item stack
	 * @param input
	 *            the log item stack
	 */
	public static void addPlanks(ItemStack output, ItemStack input)
	{
		addShapelessRecipe(ECStacks.withSize(output, 4), input);
	}
	
	/**
	 * Adds a new armor-shaped recipe to the game. (Type 0 = Helmet, Type 1 =
	 * Chestplate, Type 2 = Leggings, Type 3 = Boots, Type 4 = Gloves)
	 * 
	 * @param output
	 *            the output
	 * @param input
	 *            the material
	 * @param type
	 *            the armor type
	 */
	public static void addArmorRecipe(ItemStack output, ItemStack input, int type)
	{
		if (type == 0)
		{
			addRecipe(output, "XXX", "X X", 'X', input);
		}
		else if (type == 1)
		{
			addRecipe(output, "X X", "XXX", "XXX", 'X', input);
		}
		else if (type == 2)
		{
			addRecipe(output, "XXX", "X X", "X X", 'X', input);
		}
		else if (type == 3)
		{
			addRecipe(output, "X X", "X X", 'X', input);
		}
		else if (type == 4)
		{
			addRecipe(output, "X X", 'X', input);
		}
	}
	
	/**
	 * @see ECCrafting#addToolRecipe(ItemStack, ItemStack, ItemStack, int)
	 * @param output
	 *            the output
	 * @param material
	 *            the material
	 * @param type
	 *            the tool type
	 */
	public static void addToolRecipe(ItemStack output, ItemStack material, int type)
	{
		addToolRecipe(output, material, stick, type);
	}
	
	/**
	 * Adds a new tool-shaped recipe to the game.
	 * <p>
	 * Type 0 = Sword, Type 1 = Spade, Type 2 = Pickaxe, Type 3 = Axe, Type 4 =
	 * Hoe
	 * 
	 * @param output
	 *            the output
	 * @param material
	 *            the material
	 * @param stick
	 *            the stick material
	 * @param type
	 *            the tool type
	 */
	public static void addToolRecipe(ItemStack output, ItemStack material, ItemStack stick, int type)
	{
		if (type == 0)
		{
			addRecipe(output, "X", "X", "|", 'X', material, '|', stick);
		}
		else if (type == 1)
		{
			addRecipe(output, "X", "|", "|", 'X', material, '|', stick);
		}
		else if (type == 2)
		{
			addRecipe(output, "XXX", " | ", " | ", 'X', material, '|', stick);
		}
		else if (type == 3)
		{
			addRecipe(output, "XX ", "X| ", " | ", 'X', material, '|', stick);
		}
		else if (type == 4)
		{
			addRecipe(output, "XX", " |", " |", 'X', material, '|', stick);
		}
	}
	
	/**
	 * Removes all recipes for the given {@link ItemStack} {@code output} from
	 * the game.
	 * 
	 * @param output
	 *            the output of the recipe
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
	
	/**
	 * Registers an ore to the ore dictionary.
	 * 
	 * @see OreDictionary
	 * @see OreDictionary#registerOre(String, ItemStack)
	 * @param name
	 *            the name
	 * @param ore
	 *            the ore
	 * @return the item stack
	 */
	public static ItemStack registerOre(String name, ItemStack ore)
	{
		OreDictionary.registerOre(name, ore);
		return ore;
	}

	
	/**
	 * Analyzes a shaped crafting recipe.
	 * 
	 * @param recipe
	 *            the recipe
	 * @return the item stack[][]
	 */
	public static ItemStack[][] analyseCraftingShaped(Object... recipe)
	{
		String s = "";
		int i = 0;
		int j = 0; // Width
		int k = 0; // Height
		
		if (recipe[i] instanceof String[])
		{
			String[] astring = (String[]) recipe[i++];
			
			k = astring.length;
			for (String s1 : astring)
			{
				j = s1.length();
				s = s + s1;
			}
		}
		else
		{
			while (recipe[i] instanceof String)
			{
				String s2 = (String) recipe[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}
		
		Map<Character, ItemStack> hashmap = new HashMap<>();
		
		for (; i < recipe.length; i += 2)
		{
			Character character = (Character) recipe[i];
			ItemStack itemstack1 = null;
			
			if (recipe[i + 1] instanceof Item)
			{
				itemstack1 = new ItemStack((Item) recipe[i + 1]);
			}
			else if (recipe[i + 1] instanceof Block)
			{
				itemstack1 = new ItemStack((Block) recipe[i + 1], 1, OreDictionary.WILDCARD_VALUE);
			}
			else if (recipe[i + 1] instanceof ItemStack)
			{
				itemstack1 = (ItemStack) recipe[i + 1];
			}
			
			hashmap.put(character, itemstack1);
		}
		
		ItemStack[][] ret = new ItemStack[3][3];
		
		for (int j1 = 0; j1 < j; ++j1)
		{
			for (int k1 = 0; k1 < k; ++k1)
			{
				int i1 = k1 * j + j1;
				char c0 = s.charAt(i1 % s.length());
				
				if (hashmap.containsKey(c0))
				{
					ret[k1 % 3][j1 % 3] = hashmap.get(c0).copy();
				}
				else
				{
					ret[k1 % 3][j1 % 3] = null;
				}
			}
		}
		return ret;
	}
}
