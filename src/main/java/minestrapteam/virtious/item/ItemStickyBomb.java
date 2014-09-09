package minestrapteam.virtious.item;

import minestrapteam.virtious.entity.item.EntityStickyBomb;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStickyBomb extends Item
{
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		EntityStickyBomb bomb = new EntityStickyBomb(world, x + 0.5D, y + 1D, z + 0.5D, player);
		world.spawnEntityInWorld(bomb);
		
		if (!player.capabilities.isCreativeMode)
		{
			stack.stackSize--;
		}
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
	}
}
