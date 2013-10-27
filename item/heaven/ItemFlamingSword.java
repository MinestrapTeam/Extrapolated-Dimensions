package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemFlamingSword extends ItemSword
{
	
	public ItemFlamingSword(int par1)
	{
		super(par1, MDMItems.toolFlaming);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par7 == 0)
		{
			--par5;
		}
		
		if (par7 == 1)
		{
			++par5;
		}
		
		if (par7 == 2)
		{
			--par6;
		}
		
		if (par7 == 3)
		{
			++par6;
		}
		
		if (par7 == 4)
		{
			--par4;
		}
		
		if (par7 == 5)
		{
			++par4;
		}
		
		int var11 = par3World.getBlockId(par4, par5, par6);
		
		if (var11 == 0)
		{
			par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			par3World.setBlock(par4, par5, par6, Block.fire.blockID);
		}
		
		par1ItemStack.damageItem(1, par2EntityPlayer);
		return true;
	}
	
	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
	{
		par1ItemStack.damageItem(1, par3EntityLiving);
		par2EntityLiving.setFire(10);
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack is)
	{
		return EnumRarity.epic;
	}
}
