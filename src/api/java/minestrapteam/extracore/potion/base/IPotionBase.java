package minestrapteam.extracore.potion.base;

import java.util.HashMap;
import java.util.Map;

import minestrapteam.extracore.item.ItemPotion2;
import minestrapteam.extracore.potion.PotionTypeList;
import minestrapteam.extracore.potion.type.IPotionType;

import net.minecraft.item.ItemStack;

public interface IPotionBase
{
	Map<String, IPotionBase>	bases	= new HashMap();
	
	IPotionBase						water	= new PotionBaseWater();
	
	/**
	 * Registers this {@link IPotionBase}. It is recommended to register it by
	 * adding it to {@link IPotionBase#bases}.
	 * 
	 * @return this potion recipe
	 */
	IPotionBase register();
	
	/**
	 * Returns the name of this {@link IPotionBase}.
	 * 
	 * @return the name
	 */
	String getName();
	
	/**
	 * Returns the liquid color of this {@link IPotionBase}. Usually
	 * {@code 0x0C0CFF}.
	 * 
	 * @return the liquid color
	 */
	int getLiquidColor();
	
	ItemStack apply(ItemStack potion);
	
	/**
	 * Applies this potion base to the {@link ItemStack}. The item of the stack
	 * should be an instance of {@link ItemPotion2}.
	 * 
	 * @param potionTypes
	 *            the potion stack
	 */
	ItemStack apply(PotionTypeList potionTypes);
	
	/**
	 * Returns true if this {@link IPotionBase} accepts the given
	 * {@link IPotionType} {@code potion}. It is usually possible to apply a
	 * potion type if the required base was found <i>OR</i> any of the existent
	 * bases accept the potion type.
	 * 
	 * @param potion
	 *            the potion type
	 * @return true, if this accepts the potion
	 */
	boolean accepts(IPotionType potion);
	
	/**
	 * Returns true if this potion base matches the given {@link ItemStack}
	 * {@code potion}. The usual implementation returns true if this potion base
	 * can be found in the potion.
	 * 
	 * @param type
	 *            the potion type that is to be applied
	 * @param potion
	 *            the potion stack
	 * @return true, if this potion base matches the potion.
	 */
	boolean matches(IPotionType type, PotionTypeList potionTypes);
	
	void onApplied(IPotionType type, PotionTypeList potionTypes);
}
