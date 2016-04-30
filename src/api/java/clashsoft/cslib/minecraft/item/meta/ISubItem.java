package clashsoft.cslib.minecraft.item.meta;

import java.util.Collection;

import net.minecraft.block.Block;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * The Interface IItemMetadataList.
 */
public interface ISubItem
{
	ItemStack asStack();
	
	ItemStack asStack(int i);
	
	EnumAction getAction();
	
	Block getBlockPlaced();
	
	int getMetadataPlaced();
	
	PotionEffect[] getEffects();
	
	int getFoodValue();
	
	String getIconName();
	
	int getID();
	
	String getName();
	
	Collection<String> getDescription();
	
	boolean isEnabled();
	
	ISubItem register();
	
	ISubItem setBlockPlaced(Block block, int metadata);
	
	ISubItem setEffects(PotionEffect... effects);
	
	ISubItem setEnabled(boolean enabled);
	
	ISubItem setFoodValue(int foodValue);
	
	ISubItem setIconName(String icon);
	
	ISubItem setName(String name);
	
	ISubItemRecipe getRecipe();
}
