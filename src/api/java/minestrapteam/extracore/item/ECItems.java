package minestrapteam.extracore.item;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.extracore.util.Constants;
import minestrapteam.extracore.util.ReflectionUtils;
import minestrapteam.extracore.util.StringUtils;
import minestrapteam.extracore.util.logging.ECLog;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class ECItems.
 * <p>
 * This class adds several utils for adding items.
 *
 * @author Clashsoft
 */
public class ECItems
{
	public static Map<Item, Item> replacements = new HashMap<>();

	/**
	 * Registers all {@link Item}s from the given {@link Class} {@code mod}.
	 *
	 * @param mod
	 * 	the mod class
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
	 * Registers the given {@link Item} {@code item}. This uses the unlocalized name of the item to compute a registry
	 * name and then calls {@link ECItems#addItem(Item, String)}.
	 *
	 * @param item
	 * 	the item
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
	 * Adds an Item without a recipe. Internally calls {@link ECItems#addItem(Item, String, String)} and uses the
	 * current mod id as the {@code modid} parameter. The current mod id is received using {@link
	 * Loader#activeModContainer()}.{@link ModContainer#getModId()}.
	 *
	 * @param item
	 * 	the item
	 * @param name
	 * 	the name
	 */
	public static void addItem(Item item, String name)
	{
		String activeModID = Loader.instance().activeModContainer().getModId();
		addItem(item, name, activeModID.toLowerCase());
	}

	/**
	 * Adds an Item without a recipe. The item is registered with the specified modid as a domain.
	 *
	 * @param item
	 * 	the item to register
	 * @param name
	 * 	the item name
	 * @param modid
	 * 	the mod id
	 */
	public static void addItem(Item item, String name, String modid)
	{
		name = StringUtils.identifier(name);
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name, modid);
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
	 * Replaces the given vanilla {@link Item} {@code item} with the {@code newItem}. If {@code replaceField} is true,
	 * this method searches for the fields in {@link Items} and replaces references.
	 *
	 * @param item
	 * 	the item to replace
	 * @param newItem
	 * 	the new item
	 * @param replaceField
	 * 	replace field
	 *
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
			ReflectionUtils.invoke(Constants.METHOD_FMLControlledNamespacedRegistry_addObjectRaw, registry,
			                       new Object[] { id, registryName, newItem });

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
			ECLog.info(flag ?
				           "Replace Item : %s (%s) with %s, took %d ms" :
				           "Replace Item : %s (%s) with %s FAILED, took %d ms", item.getUnlocalizedName(),
			           item.getClass().getSimpleName(), newItem.getClass().getSimpleName(), now);

			return true;
		}
		catch (Exception e)
		{
			ECLog.error(e);
		}
		return false;
	}
}
