package clashsoft.mods.moredimensions.item.aerius;

import clashsoft.mods.moredimensions.lib.Tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemFireSword extends ItemSword
{
	public ItemFireSword()
	{
		super(Tools.toolFire);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (side == 0)
			--y;
		
		if (side == 1)
			++y;
		
		if (side == 2)
			--z;
		
		if (side == 3)
			++z;
		
		if (side == 4)
			--x;
		
		if (side == 5)
			++x;
		
		if (world.isAirBlock(x, y, z))
		{
			world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			world.setBlock(x, y, z, Blocks.fire);
		}
		
		stack.damageItem(1, player);
		return true;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase living, EntityLivingBase living2)
	{
		stack.damageItem(1, living);
		living2.setFire(10);
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}
}
