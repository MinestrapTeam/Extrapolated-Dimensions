package minestrapteam.extradims.item.aerius;

import minestrapteam.extradims.entity.MDMEntityProperties;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLifeHeart extends Item
{
	public ItemLifeHeart()
	{
		super();
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		--stack.stackSize;
		world.playSoundAtEntity(player, "random.bow", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		MDMEntityProperties.get(player).addAdditionalHearts(1F);
		return stack;
	}
}
