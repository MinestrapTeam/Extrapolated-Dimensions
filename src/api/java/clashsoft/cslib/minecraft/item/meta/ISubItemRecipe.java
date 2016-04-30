package clashsoft.cslib.minecraft.item.meta;

/**
 * The Interface IItemMetadataRecipe.
 */
public interface ISubItemRecipe
{
	int	CRAFTING			= 0;
	int	CRAFTING_SHAPELESS	= 1;
	int	FURNACE				= 2;
	
	/**
	 * Gets the crafting type.
	 * 
	 * @return the crafting type
	 */
	int getCraftingType();
	
	/**
	 * Gets the amount.
	 * 
	 * @return the amount
	 */
	int getAmount();
	
	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	Object[] getData();
}
