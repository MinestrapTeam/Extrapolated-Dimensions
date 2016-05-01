package minestrapteam.extracore.item;

import minestrapteam.extracore.util.ReflectionUtils;
import minestrapteam.extracore.util.StringUtils;
import minestrapteam.extracore.util.logging.ECLog;
import minestrapteam.extracore.crafting.ECCrafting;
import minestrapteam.extracore.util.Constants;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import static minestrapteam.extracore.item.stack.ECStacks.stick;

/**
 * The Class ECItems.
 * <p>
 * This class adds several utils for adding items.
 * 
 * @author Clashsoft
 */
public class ECItems
{
	public static Map<Item, Item>	replacements	= new HashMap();
	
	/**
	 * Creates a new {@link Item} of the {@link Class Type} {@code type} and the
	 * {@link Object Object[]} {@code args} and then registers it under the name
	 * {@code name}.
	 * 
	 * @param type
	 *            the type
	 * @param name
	 *            the name
	 * @param args
	 *            the constructor arguments
	 * @return the item instance
	 */
	public static <T extends Item> T createItem(Class<T> type, String name, Object... args)
	{
		Class[] classes = new Class[args.length + 1];
		
		for (int i = 0; i < args.length; i++)
		{
			if (args[i] != null)
			{
				classes[i] = args[i].getClass();
			}
			else
			{
				classes[i] = Object.class;
			}
		}
		return createItem(type, name, classes, args);
	}
	
	/**
	 * Creates a new {@link Item} of the {@link Class Type} {@code type} and the
	 * {@link Object Object[]} {@code args} of {@link Class Types}
	 * {@code argsTypes} and then registers it under the name {@code name}.
	 * 
	 * @param type
	 *            the type
	 * @param name
	 *            the name
	 * @param argsTypes
	 *            the types of the arguments
	 * @param args
	 *            the constructor arguments
	 * @return the item instance
	 */
	public static <T extends Item> T createItem(Class<T> type, String name, Class[] argsTypes, Object... args)
	{
		T item = null;
		
		try
		{
			Constructor<T> c = type.getConstructor(argsTypes);
			if (c != null)
			{
				item = c.newInstance(args);
			}
		}
		catch (Throwable ex)
		{
			throw new RuntimeException(ex);
		}
		
		return item;
	}
	
	/**
	 * Registers all {@link Item}s from the given {@link Class} {@code mod}.
	 * 
	 * @param mod
	 *            the mod class
	 */
	public static void addAllItems(Class mod)
	{
		Item[] items = ReflectionUtils.getStaticObjects(mod, Item.class, true);
		
		for (Item item : items)
		{
			addItem(item);
		}
	}
	
	/**
	 * Registers the given {@link Item} {@code item}. This uses the unlocalized
	 * name of the item to compute a registry name and then calls
	 * {@link CSItem#addItem(Item, String)}.
	 * 
	 * @param item
	 *            the item
	 */
	public static void addItem(Item item)
	{
		String name = item.getUnlocalizedName();
		if (name.startsWith("item."))
		{
			name = name.substring(5);
		}
		addItem(item, name);
	}
	
	/**
	 * Adds an Item without a recipe. Internally calls
	 * {@link ECItems#addItem(Item, String, String)} and uses the current mod id
	 * as the {@code modid} parameter. The current mod id is received using
	 * {@link Loader#activeModContainer()}.{@link ModContainer#getModId()}.
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 */
	public static void addItem(Item item, String name)
	{
		String activeModID = Loader.instance().activeModContainer().getModId();
		addItem(item, name, activeModID.toLowerCase());
	}
	
	/**
	 * Adds an Item without a recipe. The item is registered with the specified
	 * modid as a domain.
	 * 
	 * @param item
	 * @param name
	 * @param modid
	 */
	public static void addItem(Item item, String name, String modid)
	{
		name = StringUtils.identifier(name);
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name, modid);
	}
	
	/**
	 * Adds an Item with a shaped recipe.
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param craftingAmount
	 *            the crafting amount
	 * @param recipe
	 *            the recipe
	 */
	public static void addItemWithRecipe(Item item, String name, int craftingAmount, Object... recipe)
	{
		addItem(item, name);
		ECCrafting.addRecipe(new ItemStack(item, craftingAmount), recipe);
	}
	
	/**
	 * Adds an Item with a shapeless recipe.
	 * 
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param craftingAmount
	 *            the crafting amount
	 * @param recipe
	 *            the recipe
	 */
	public static void addItemWithShapelessRecipe(Item item, String name, int craftingAmount, Object... recipe)
	{
		addItem(item, name);
		ECCrafting.addShapelessRecipe(new ItemStack(item, craftingAmount), recipe);
	}
	
	/**
	 * Adds an armor item with a shaped recipe.
	 * 
	 * @see ECCrafting#addArmorRecipe(ItemStack, ItemStack, int)
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param material
	 *            the crafting material
	 * @param stick
	 *            the stick
	 * @param type
	 *            the type
	 */
	public static void addArmor(Item item, String name, ItemStack material, int type)
	{
		addItem(item, name);
		ECCrafting.addArmorRecipe(new ItemStack(item), material, type);
	}
	
	/**
	 * Adds a tool with automatic shaped recipe.
	 * 
	 * @see ECItems#addTool(Item, String, ItemStack, ItemStack, int)
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param material
	 *            the crafting material
	 * @param type
	 *            the type
	 */
	public static void addTool(Item item, String name, ItemStack material, int type)
	{
		addTool(item, name, material, stick, type);
	}
	
	/**
	 * Adds a tool with automatic shaped recipe.
	 * 
	 * @see ECCrafting#addToolRecipe(ItemStack, ItemStack, int)
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 * @param material
	 *            the crafting material
	 * @param stick
	 *            the stick
	 * @param type
	 *            the type
	 */
	public static void addTool(Item item, String name, ItemStack material, ItemStack stick, int type)
	{
		addItem(item, name);
		ECCrafting.addToolRecipe(new ItemStack(item), material, stick, type);
	}
	
	public static ToolMaterial getToolMaterial(ArmorMaterial armorMaterial)
	{
		return ReflectionUtils.getEnumConstant(ToolMaterial.class, armorMaterial.name());
	}
	
	public static ArmorMaterial getArmorMaterial(ToolMaterial toolMaterial)
	{
		return ReflectionUtils.getEnumConstant(ArmorMaterial.class, toolMaterial.name());
	}
	
	public static boolean replaceItem(Item item, Item newItem)
	{
		return replaceItem(item, newItem, true);
	}
	
	/**
	 * Replaces the given vanilla {@link Item} {@code item} with the
	 * {@code newItem}. If {@code replaceField} is true, this method searches
	 * for the fields in {@link Items} and replaces references.
	 * 
	 * @param item
	 *            the item to replace
	 * @param newItem
	 *            the new item
	 * @param replaceField
	 *            replace field
	 * @return true, if successful
	 */
	public static boolean replaceItem(Item item, Item newItem, boolean replaceField)
	{
		long now = System.currentTimeMillis();
		try
		{
			FMLControlledNamespacedRegistry<Item> registry = GameData.getItemRegistry();
			String registryName = registry.getNameForObject(item);
			int id = Item.getIdFromItem(item);
			
			// Replace registry entry
			ReflectionUtils.invoke(Constants.METHOD_FMLControlledNamespacedRegistry_addObjectRaw, registry, new Object[] { id, registryName, newItem });
			
			// Replace delegate referant
			ReflectionUtils.setField(Constants.FIELD_Delegate_referant, item.delegate, newItem);
			
			// Replace stat list entries
			StatCrafting stat = (StatCrafting) StatList.objectBreakStats[id];
			if (stat != null)
			{
				ReflectionUtils.setField(Constants.FIELD_StatCrafting_item, stat, newItem);
			}
			stat = (StatCrafting) StatList.objectCraftStats[id];
			if (stat != null)
			{
				ReflectionUtils.setField(Constants.FIELD_StatCrafting_item, stat, newItem);
			}
			stat = (StatCrafting) StatList.objectUseStats[id];
			if (stat != null)
			{
				ReflectionUtils.setField(Constants.FIELD_StatCrafting_item, stat, newItem);
			}
			
			// Replace Crafting Recipes
			replacements.put(item, newItem);
			
			// Replace Field
			if (replaceField)
			{
				for (Field field : Items.class.getDeclaredFields())
				{
					if (!Item.class.isAssignableFrom(field.getType()))
					{
						continue;
					}
					
					Item item1 = (Item) field.get(null);
					if (item1 != item)
					{
						continue;
					}
					
					// Set field
					ReflectionUtils.setModifier(field, Modifier.FINAL, false);
					field.set(null, newItem);
				}
			}
			
			boolean flag = true;
			if (registry.getObject(registryName) != newItem)
			{
				flag = false;
			}
			
			now = System.currentTimeMillis() - now;
			ECLog.info(flag ? "Replace Item : %s (%s) with %s, took %d ms" : "Replace Item : %s (%s) with %s FAILED, took %d ms",
			           item.getUnlocalizedName(), item.getClass().getSimpleName(), newItem.getClass().getSimpleName(),
			           now);
			
			return true;
		}
		catch (Exception e)
		{
			ECLog.error(e);
		}
		return false;
	}
}