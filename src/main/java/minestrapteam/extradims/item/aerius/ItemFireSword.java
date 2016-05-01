package minestrapteam.extradims.item.aerius;

import minestrapteam.extradims.lib.Tools;

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
		switch (side)
		{
		case 0:
			--y;
			break;
		case 1:
			++y;
			break;
		case 2:
			--z;
			break;
		case 3:
			++z;
			break;
		case 4:
			--x;
			break;
		case 5:
			++x;
			break;
		}
		
		if (world.isAirBlock(x, y, z))
		{
			world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			world.setBlock(x, y, z, Blocks.fire);
		}
		
		stack.damageItem(1, player);
		return true;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attacker, EntityLivingBase target)
	{
		stack.damageItem(1, attacker);
		target.setFire(10);
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.rare;
	}
}
