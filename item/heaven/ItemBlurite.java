package clashsoft.mods.moredimensions.item.heaven;

import java.util.List;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.block.heaven.BlockHeavenSapling;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlurite extends ItemHeavenMisc
{
	public ItemBlurite(int par1)
	{
		super(par1, CreativeTabs.tabMaterials);
	}
	
	public void addInformation(ItemStack par1ItemStack, List par2List)
	{
		par2List.add("Used to fertilize Heaven Saplings.");
	}
	
	public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int var11;
		int var12;
		
		var11 = par3World.getBlockId(par4, par5, par6);
		
		if (var11 == MDMBlocks.heavenSapling.blockID)
		{
			if (!par3World.isRemote)
			{
				((BlockHeavenSapling) MDMBlocks.heavenSapling).growTree(par3World, par4, par5, par6, par3World.rand);
				--par1ItemStack.stackSize;
			}
			return true;
		}
		return false;
	}
}
