package clashsoft.mods.moredimensions.item.poc;

import clashsoft.mods.moredimensions.entity.MDMEntityProperties;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemManaStar extends Item
{
	public ItemManaStar()
	{
		super();
		this.setMaxStackSize(16);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		MDMEntityProperties.get(player).addMana(2.5F);
		if (!player.capabilities.isCreativeMode)
			stack.stackSize--;
		return stack;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
}
