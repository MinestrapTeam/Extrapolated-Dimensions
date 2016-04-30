package minestrapteam.extradims.item.virtious;

import minestrapteam.extradims.entity.item.EntityStickyBomb;
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
		if (!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityStickyBomb(world, x + 0.5D, y + 1D, z + 0.5D, player));
		}

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
