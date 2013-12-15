package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.entity.MDMEntityProperties;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLifeHeart extends ItemHeavenFood
{
	public ItemLifeHeart(int itemID)
	{
		super(itemID, 2, 0, false);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		--stack.stackSize;
		world.playSoundAtEntity(player, "random.bow", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		MDMEntityProperties.getEntityProperties(player).addAdditionalHearts(1F);
		return stack;
	}
	
}
