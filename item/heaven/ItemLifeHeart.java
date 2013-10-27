package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.entity.MDMEntityProperties;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLifeHeart extends ItemHeavenFood
{	
	public ItemLifeHeart(int par1)
	{
		super(par1, 2, 0, false);
	}
	
	@Override
	public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		--par1ItemStack.stackSize;
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		MDMEntityProperties.getEntityProperties(par3EntityPlayer).addAdditionalHearts(1F);
		return par1ItemStack;
	}
	
}
