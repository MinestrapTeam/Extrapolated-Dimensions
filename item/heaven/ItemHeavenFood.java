package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHeavenFood extends Item
{
	/** Number of ticks to run while 'EnumAction'ing until result. */
	public final int		itemUseDuration;
	
	/** The amount this food item heals the player. */
	private final int		healAmount;
	private final float		saturationModifier;
	
	/** Whether wolves like this food (true for raw and cooked porkchop). */
	private final boolean	isWolfsFavoriteMeat;
	
	/**
	 * If this field is true, the food can be consumed even if the player don't need to eat.
	 */
	private boolean			alwaysEdible;
	
	/**
	 * represents the potion effect that will occurr upon eating this food. Set by setPotionEffect
	 */
	private int				potionId;
	
	/** set by setPotionEffect */
	private int				potionDuration;
	
	/** set by setPotionEffect */
	private int				potionAmplifier;
	
	/** probably of the set potion effect occurring */
	private float			potionEffectProbability;
	
	public ItemHeavenFood(int itemID, int healAmount, float saturationModifier, boolean wolfFood)
	{
		super(itemID);
		this.itemUseDuration = 32;
		this.healAmount = healAmount;
		this.isWolfsFavoriteMeat = wolfFood;
		this.saturationModifier = saturationModifier;
		this.setCreativeTab(MDMItems.tabHeavenItems);
	}
	
	public ItemHeavenFood(int itemID, int healAmount, boolean wolfFood)
	{
		this(itemID, healAmount, 0.6F, wolfFood);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		--stack.stackSize;
		world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		// world.playSoundAtEntity(player, "chorus", 0.5F,
		// world.rand.nextFloat() * 0.1F + 0.9F);
		this.applyPotionEffects(stack, world, player);
		return stack;
	}
	
	protected void applyPotionEffects(ItemStack stack, World world, EntityPlayer player)
	{
		if (!world.isRemote && this.potionId > 0 && world.rand.nextFloat() < this.potionEffectProbability)
		{
			player.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
		}
	}
	
	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 32;
	}
	
	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.eat;
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.canEat(this.alwaysEdible))
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		
		return stack;
	}
	
	public int getHealAmount()
	{
		return this.healAmount;
	}
	
	/**
	 * Gets the saturationModifier of the ItemFood
	 */
	public float getSaturationModifier()
	{
		return this.saturationModifier;
	}
	
	/**
	 * Whether wolves like this food (true for raw and cooked porkchop).
	 */
	public boolean isWolfsFavoriteMeat()
	{
		return this.isWolfsFavoriteMeat;
	}
	
	/**
	 * Sets a potion effect on the item. Args: int potionId, int duration (will be multiplied by 20), int amplifier, float probability of effect happening
	 */
	public ItemHeavenFood setPotionEffect(int potionID, int duration, int amplifier, float propability)
	{
		this.potionId = potionID;
		this.potionDuration = duration;
		this.potionAmplifier = amplifier;
		this.potionEffectProbability = propability;
		return this;
	}
	
	/**
	 * Set the field 'alwaysEdible' to true, and make the food edible even if the player don't need to eat.
	 */
	public ItemHeavenFood setAlwaysEdible()
	{
		this.alwaysEdible = true;
		return this;
	}
}
