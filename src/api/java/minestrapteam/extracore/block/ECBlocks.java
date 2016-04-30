package minestrapteam.extracore.block;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import minestrapteam.extracore.item.ECItems;
import minestrapteam.extracore.util.ReflectionUtils;
import minestrapteam.extracore.util.StringUtils;
import minestrapteam.extracore.util.logging.ECLog;
import minestrapteam.extracore.crafting.ECCrafting;
import minestrapteam.extracore.item.block.ItemCustomBlock;
import minestrapteam.extracore.util.Constants;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

/**
 * The Class ECBlocks.
 * <p>
 * This class adds several methods for registering and replacing blocks.
 * 
 * @author Clashsoft
 */
public class ECBlocks
{
	public static boolean	coloredLights;
	
	static
	{
		try
		{
			Class.forName("coloredlightscore.src.api.CLApi");
			coloredLights = true;
			ECLog.info("Clashsoft Lib Colored Lights compatibility activated.");
		}
		catch (Exception ex)
		{
		}
	}
	
	/**
	 * Registers all {@link Block}s from the given {@link Class} {@code mod}.
	 * 
	 * @param mod
	 *            the mod class
	 */
	public static void addAllBlocks(Class mod)
	{
		Block[] blocks = ReflectionUtils.getStaticObjects(mod, Block.class, true);
		
		for (Block block : blocks)
		{
			addBlock(block);
		}
	}
	
	/**
	 * Registers the given {@link Block} {@code block}. This uses the
	 * unlocalized name of the block to compute a registry name and then calls
	 * {@link ECBlocks#addBlock(Block, String)}.
	 * 
	 * @param block
	 *            the block
	 */
	public static void addBlock(Block block)
	{
		String name = block.getUnlocalizedName();
		if (name.startsWith("tile."))
		{
			name = name.substring(5);
		}
		addBlock(block, name);
	}
	
	/**
	 * Registers a Block and its name. This calls
	 * {@link ECBlocks#addBlock(Block, Class, String)} with
	 * {@link ItemCustomBlock}{@code .class} as the {@code itemClass} argument.
	 * 
	 * @param block
	 *            the block
	 * @param name
	 *            the name
	 */
	public static void addBlock(Block block, String name)
	{
		addBlock(block, ItemCustomBlock.class, name);
	}
	
	/**
	 * Registers a Block and its name to a block item.
	 * 
	 * @param block
	 *            the block
	 * @param itemClass
	 *            the item class
	 * @param name
	 *            the name
	 */
	public static void addBlock(Block block, Class<? extends ItemBlock> itemClass, String name)
	{
		name = StringUtils.identifier(name);
		block.setBlockName(name);
		GameRegistry.registerBlock(block, itemClass, name);
	}
	
	/**
	 * Register a block with its name and an recipe for it.
	 * 
	 * @param block
	 *            the block
	 * @param name
	 *            the name
	 * @param craftingAmount
	 *            the crafting amount
	 * @param recipe
	 *            the recipe
	 */
	public static void addBlockWithRecipe(Block block, String name, int craftingAmount, Object... recipe)
	{
		addBlock(block, name);
		ECCrafting.addRecipe(new ItemStack(block, craftingAmount), recipe);
	}
	
	public static boolean replaceBlock(Block block, Block newBlock)
	{
		return replaceBlock(block, newBlock, null, true);
	}
	
	public static boolean replaceBlock(Block block, Block newBlock, ItemBlock newItemBlock)
	{
		return replaceBlock(block, newBlock, newItemBlock, true);
	}
	
	/**
	 * Replaces the given vanilla {@link Block} {@code block} with the
	 * {@code newBlock}.
	 * 
	 * @param block
	 *            the block to replace
	 * @param newBlock
	 *            the new block
	 * @return true, if successful
	 */
	public static boolean replaceBlock(Block block, Block newBlock, ItemBlock newItemBlock, boolean replaceField)
	{
		long now = System.currentTimeMillis();
		try
		{
			FMLControlledNamespacedRegistry<Block> registry = GameData.getBlockRegistry();
			String registryName = registry.getNameForObject(block);
			int id = Block.getIdFromBlock(block);
			ItemBlock itemBlock = (ItemBlock) Item.getItemFromBlock(block);
			
			// Replace registry entry
			ReflectionUtils.invoke(Constants.METHOD_FMLControlledNamespacedRegistry_addObjectRaw, registry, new Object[] { id, registryName, newBlock });
			
			// Replace delegate referant
			ReflectionUtils.setField(Constants.FIELD_Delegate_referant, block.delegate, newBlock);
			
			// Replace ItemBlock
			if (newItemBlock != null)
			{
				ECItems.replaceItem(itemBlock, newItemBlock, false);
				
				// BUGFIX: Replace mineBlockStat to avoid statistics crash.
				StatCrafting stat = (StatCrafting) StatList.mineBlockStatArray[id];
				if (stat != null)
				{
					ReflectionUtils.setField(Constants.FIELD_StatCrafting_item, stat, newItemBlock);
				}
			}
			// Use old ItemBlock and update reference
			else if (itemBlock != null)
			{
				ReflectionUtils.setField(Constants.FIELD_ItemBlock_block, itemBlock, newBlock);
			}
			
			// Replace Field
			if (replaceField)
			{
				for (Field field : Blocks.class.getDeclaredFields())
				{
					if (!Block.class.isAssignableFrom(field.getType()))
					{
						continue;
					}
					
					Block block1 = (Block) field.get(null);
					if (block1 != block)
					{
						continue;
					}
					
					// Set field
					ReflectionUtils.setModifier(field, Modifier.FINAL, false);
					field.set(null, newBlock);
				}
			}
			
			boolean flag = true;
			if (registry.getObject(registryName) != newBlock)
			{
				flag = false;
			}
			
			now = System.currentTimeMillis() - now;
			ECLog.info(flag ? "Replace Block : %s (%s) with %s, took %d ms" : "Replace Block : %s (%s) with %s FAILED, took %d ms",
			           block.getUnlocalizedName(), block.getClass().getSimpleName(), newBlock.getClass().getSimpleName(),
			           now);
			
			return true;
		}
		catch (Exception e)
		{
			ECLog.error(e);
		}
		return false;
	}
	
	public static int getLightValue(float r, float g, float b, float brightness)
	{
		int ibrightness = (int) (brightness * 15.0F);
		if (!coloredLights)
		{
			return ibrightness;
		}
		return ibrightness | ((int) (15.0F * b) << 15) | ((int) (15.0F * g) << 10) | ((int) (15.0F * r) << 5);
	}
	
	public static int getLightValue(int r, int g, int b, int brightness)
	{
		brightness &= 15;
		if (!coloredLights)
		{
			return brightness;
		}
		return brightness | (b << 15) + (g << 10) + (r << 5);
	}
	
	public static int getLightValue(int rgb, float brightness)
	{
		float r = ((rgb >> 16) & 0xFF) / 255F;
		float g = ((rgb >> 8) & 0xFF) / 255F;
		float b = ((rgb >> 0) & 0xFF) / 255F;
		return getLightValue(r, g, b, brightness);
	}
	
	public static int getLightValue(float r, float g, float b)
	{
		return getLightValue(r, g, b, (r + g + b) / 3F);
	}
	
	public static int getLightValue(int r, int g, int b)
	{
		return getLightValue(r, g, b, (r + g + b) / 3);
	}
	
	public static int getLightValue(int rgb)
	{
		float r = ((rgb >> 16) & 0xFF) / 255F;
		float g = ((rgb >> 8) & 0xFF) / 255F;
		float b = ((rgb >> 0) & 0xFF) / 255F;
		return getLightValue(r, g, b, (r + g + b) / 3F);
	}
}
