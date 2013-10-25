package clashsoft.mods.moredimensions.item.heaven;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLifeHeart extends ItemHeavenFood
{
	
	private int		healAmount;
	/**
	 * represents the potion effect that will occurr upon eating this food. Set
	 * by setPotionEffect
	 */
	private int		potionId;
	
	/** set by setPotionEffect */
	private int		potionDuration;
	
	/** set by setPotionEffect */
	private int		potionAmplifier;
	
	/** probably of the set potion effect occurring */
	private float	potionEffectProbability;
	
	public ItemLifeHeart(int par1, int par2, float par3)
	{
		super(par1, par2, par3, false);
		healAmount = par2;
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	
	@Override
	public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		--par1ItemStack.stackSize;
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		par3EntityPlayer.heal(healAmount);
		this.func_77849_c(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack;
	}
	
	@Override
	protected void func_77849_c(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote && this.potionId > 0 && par2World.rand.nextFloat() < this.potionEffectProbability)
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
		}
	}
	
}
