package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.addons.MDMTools;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemFireSword extends ItemSword
{
	public ItemFireSword(int itemID)
	{
		super(itemID, MDMTools.toolFire);
		this.setCreativeTab(CreativeTabs.tabCombat);
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
		
		int var11 = world.getBlockId(x, y, z);
		
		if (var11 == 0)
		{
			world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			world.setBlock(x, y, z, Block.fire.blockID);
		}
		
		stack.damageItem(1, player);
		return true;
	}
	
	/**
	 * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise the damage on the stack.
	 */
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
