package clashsoft.brewingapi.potion.type;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.ArrayList;
import java.util.List;

import clashsoft.brewingapi.potion.PotionTypeList;
import clashsoft.brewingapi.potion.attribute.IPotionAttribute;
import clashsoft.brewingapi.potion.base.IPotionBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * @author Clashsoft
 */
public interface IPotionType extends Comparable<IPotionType>
{
	/** Name of the tag compound that stores the potion type list */
	String					COMPOUND_NAME	= "Brewing";
	
	/** Version identifier for NBTs. **/
	String					NBT_VERSION		= "1.1";
	
	/** List that stores ALL PotionTypes, also PotionBase types **/
	TIntObjectMap<IPotionType>	potionTypes		= new TIntObjectHashMap();
	List<IPotionType>				potionTypeList	= new ArrayList();
	List<IPotionType>				combinableTypes	= new ArrayList();
	List<IPotionType>				effectTypes		= new ArrayList();
	
	/**
	 * Returns an unique identifier for this {@link IPotionType}.
	 * 
	 * @return the UUID
	 */
	String getUUID();
	
	/**
	 * Creates a copy of this {@link IPotionType}. This is usually used to make
	 * a delegate.
	 * 
	 * @return a copy of this {@link IPotionType}
	 */
	IPotionType copy();
	
	/**
	 * Registers a potion type. This is useful to sort the potion types.
	 * 
	 * @return this
	 */
	IPotionType register();
	
	/**
	 * Returns true if this is a base potion type.
	 * 
	 * @return true, if this is a base potion type
	 */
	boolean isBase();
	
	/**
	 * Returns true if this {@link IPotionType} is combinable with an other
	 * potion type.
	 * 
	 * @return true, if this is combinable
	 */
	boolean isCombinable();
	
	/**
	 * Returns the underlying {@link PotionEffect} of this {@link IPotionType}.
	 * 
	 * @return the PotionEffect
	 */
	PotionEffect getEffect();
	
	/**
	 * Returns true if this {@link IPotionType} has an effect
	 * 
	 * @return true, if this has an effect
	 */
	boolean hasEffect();
	
	/**
	 * Returns the name of this {@link IPotionType}'s effect. If the effect is
	 * {@code null}, an empty String is returned.
	 * 
	 * @return
	 */
	String getEffectName();
	
	/**
	 * Returns the display name of this {@link IPotionType}'s effect. The
	 * display name usually contains the effect name, the amplifier and the
	 * duration. The default implementation returns
	 * <p>
	 * <code>
	 * EffectName [RomanAmplifier] ([Minutes]:[Seconds])
	 * </code>
	 * 
	 * @return the display name
	 */
	StringBuilder getDisplayName();
	
	/**
	 * Returns the liquid color of this {@link IPotionType}'s effect. If the
	 * effect is {@code null}, 0x0C0CFF is returned, which is the color of a
	 * Bottle of Water.
	 * 
	 * @return
	 */
	int getLiquidColor();
	
	/**
	 * Returns the {@link Potion} of this {@link IPotionType}'s effect. If the
	 * effect is {@code null}, {@code null} is returned.
	 * 
	 * @return the potion
	 */
	Potion getPotion();
	
	/**
	 * Returns the potion ID of this {@link IPotionType}'s effect. If the effect
	 * is {@code null}, {@code -1} is returned.
	 * 
	 * @return the potion ID
	 */
	int getPotionID();
	
	/**
	 * Returns true if the effect of this {@link IPotionType} is a bad effect /
	 * debuff (red color) or a normal buff (green color)
	 * 
	 * @return true, if this has a bad effect
	 */
	boolean isBadEffect();
	
	/**
	 * Returns the duration of this {@link IPotionType}'s effect. If the effect
	 * is {@code null}, {@code 0} is returned.
	 * 
	 * @return the potion
	 */
	int getDuration();
	
	/**
	 * Returns true if this {@link IPotionType}'s effect is instant.
	 * 
	 * @return true, if this effect is instant.
	 */
	boolean isInstant();
	
	/**
	 * Returns the amplifier of this {@link IPotionType}'s effect. If the effect
	 * is {@code null}, {@code 0} is returned.
	 * 
	 * @return the potion
	 */
	int getAmplifier();
	
	/**
	 * Returns the amount of redstone dust that had to be used to reach the
	 * duration of this potion effect.
	 * 
	 * @return the redstone amount
	 */
	int getRedstoneAmount();
	
	/**
	 * Returns the amount of redstone dust that had to be used to reach the
	 * amplifier of this potion effect.
	 * 
	 * @return the redstone amount
	 */
	int getGlowstoneAmount();
	
	/**
	 * Returns the mximimum amplifier this {@link IPotionType}'s effect can
	 * reach.
	 * 
	 * @return the max amplifier
	 */
	int getMaxAmplifier();
	
	/**
	 * Returns the mximimum duration this {@link IPotionType}'s effect can
	 * reach.
	 * 
	 * @return the max duration
	 */
	int getMaxDuration();
	
	/**
	 * Returns the default duration of this {@link IPotionType}'s effect. If
	 * this effect is {@code null}, {@code 0} is returned.
	 * 
	 * @return the default duration
	 */
	int getDefaultDuration();
	
	/**
	 * Returns the base potion type that is required to brew this
	 * {@link IPotionType}.
	 * 
	 * @return the base potion type
	 */
	IPotionBase getBase();
	
	/**
	 * Returns the inverted effect potion type. This is used when a fermented
	 * spider eye is applied to a potion.
	 * 
	 * @return the inverted potion type
	 */
	IPotionType getInverted();
	
	/**
	 * Returns the ingredient that is used to brew this {@link IPotionType}.
	 * 
	 * @return the ingredient
	 */
	ItemStack getIngredient();
	
	/**
	 * Returns true if this {@link IPotionType} is amplifiable with Glowstone.
	 * 
	 * @return true, if this {@link IPotionType} is amplifiable
	 */
	boolean isAmplifiable();
	
	/**
	 * Returns true if this {@link IPotionType} is extendable with Redstone.
	 * 
	 * @return true, if this {@link IPotionType} is extendable
	 */
	boolean isExtendable();
	
	/**
	 * Returns true if this {@link IPotionType} is dilutable.
	 * 
	 * @return true, if this {@link IPotionType} is dilutable
	 */
	boolean isDilutable();
	
	/**
	 * Returns true if this {@link IPotionType} is inversible with a Fermented
	 * Spider Eye.
	 * 
	 * @return true, if this {@link IPotionType} is inversible
	 */
	boolean isInversible();
	
	/**
	 * Returns the Glowstone-amplified version of this {@link IPotionType}.
	 * 
	 * @return the amplified version
	 */
	IPotionType onAmplified();
	
	/**
	 * Returns the Redstone-extended version of this {@link IPotionType}.
	 * 
	 * @return the extended version
	 */
	IPotionType onExtended();
	
	/**
	 * Returns the diluted version of this {@link IPotionType}.
	 * 
	 * @return the diluted version
	 */
	IPotionType onDiluted();
	
	/**
	 * Returns the splash version of this {@link IPotionType}.
	 * 
	 * @return the splash version
	 */
	IPotionType onGunpowderUsed();
	
	/**
	 * Returns the Fermented Spider Eye-inverted version of this
	 * {@link IPotionType}.
	 * 
	 * @return the inverted version
	 */
	IPotionType onInverted();
	
	/**
	 * Sets the attributes of this {@link IPotionType} to the given {@link List}
	 * of {@link IPotionAttribute} {@code attributes}.
	 * 
	 * @param attributes
	 *            the attributes
	 */
	void setAttributes(List<IPotionAttribute> attributes);
	
	/**
	 * Returns a {@link List} of {@link IPotionAttribute} of this
	 * {@link IPotionType}'s attributes.
	 * 
	 * @return the attributes
	 */
	List<IPotionAttribute> getAttributes();
	
	/**
	 * Returns true if this {@link IPotionType} has any attributes.
	 * 
	 * @return true, if this {@link IPotionType} has attributes
	 */
	boolean hasAttributes();
	
	/**
	 * Adds the given {@link IPotionAttribute} {@code attribute} to this potion
	 * type's attributes
	 * 
	 * @param attribute
	 */
	void addAttribute(IPotionAttribute attribute);
	
	/**
	 * Returns true if this {@link IPotionType} has the given
	 * {@link IPotionAttribute} {@code attribute}.
	 * 
	 * @param attribute
	 *            the attribute
	 * @return true, if this {@link IPotionType} has the attribute
	 */
	boolean hasAttribute(IPotionAttribute attribute);
	
	/**
	 * Returns a list of sub-types of this {@link IPotionType}.
	 * <p>
	 * If this is improvable, the potion type created by
	 * {@link IPotionType#onImproved()} is added to the list.<br>
	 * If this is extendable, the potion type created by
	 * {@link IPotionType#onExtended()} is added to the list.
	 * 
	 * @return the list of subtypes
	 */
	List<IPotionType> getSubTypes();
	
	ItemStack apply(ItemStack potion);
	
	/**
	 * Adds this {@link IPotionType} to the given {@link PotionTypesList} {@code potionTypes}.
	 * 
	 * @param potionTypes
	 *            the cached list of potion types
	 */
	ItemStack apply(PotionTypeList potionTypes);
	
	ItemStack remove(ItemStack potion);
	
	/**
	 * Removes this {@link IPotionType} from the given {@link PotionTypesList} {@code potionTypes}.
	 * 
	 * @param potionTypes
	 *            the cached list of potion types
	 */
	ItemStack remove(PotionTypeList potionTypes);
	
	/**
	 * Applies this {@link IPotionType}'s effect to the living entity or player.
	 * 
	 * @param target
	 *            the target
	 */
	void apply(EntityLivingBase target);
	
	/**
	 * Applies this {@link IPotionType}'s effect to the living entity or player.
	 * <p>
	 * This method also calculates a new duration from the distance.<br>
	 * The formula for this is
	 * <p>
	 * <code>
	 * integer(distance*duration+0.5)</code>
	 * <p>
	 * If the effect is {@link Potion#heal} or {@link Potion#harm}, the effect
	 * is directly applied using
	 * {@link Potion#performEffect(EntityLivingBase, int)}
	 * 
	 * @param thrower
	 * @param target
	 * @param distance
	 */
	void apply(EntityLivingBase thrower, EntityLivingBase target, double distance);
	
	/**
	 * Directly applies the given {@link PotionEffect} to the living entity or
	 * player.
	 * 
	 * @param target
	 *            the target
	 * @param effect
	 *            the effect to apply
	 */
	void apply_do(EntityLivingBase target, PotionEffect effect);
	
	/**
	 * Writes this {@link IPotionType} to the given {@link NBTTagCompound}
	 * {@code nbt}.
	 * 
	 * @param nbt
	 *            the NBTTagCompound
	 */
	void writeToNBT(NBTTagCompound nbt);
	
	/**
	 * Reads this {@link IPotionType} from the given {@link NBTTagCompound}
	 * {@code nbt}.
	 * 
	 * @param nbt
	 *            the NBTTagCompound
	 */
	void readFromNBT(NBTTagCompound nbt);
}
