package minestrapteam.virtious.item;

import minestrapteam.virtious.entity.EntityLaser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGun extends Item
{
	private int			firetick;
	
	protected int		damage;
	protected int		cooldown;
	protected String	sound;
	
	public ItemGun(int uses, int damage, int cooldown, String sound)
	{
		this.damage = damage;
		this.cooldown = cooldown;
		
		this.setMaxStackSize(1);
		this.setMaxDamage(uses);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.setItemInUse(stack, 2000);
		return stack;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int ticks)
	{
		world.spawnEntityInWorld(new EntityLaser(world, player, this.damage));
		stack.damageItem(this.damage, player);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return this.cooldown;
	}
	
	@Override
	public boolean isFull3D()
	{
		return true;
	}
}
