package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.addons.MDMItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemIceHammer extends ItemIceStick
{
	public ItemIceHammer(int itemID)
	{
		super(itemID);
		this.maxStackSize = 1;
		this.setMaxDamage(256);
		this.setCreativeTab(MDMItems.tabHeavenTools);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attacker, EntityLivingBase living)
	{
		stack.damageItem(1, living);
		attacker.knockBack(attacker, 3, 0, 0);
		return true;
	}
	
	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	
	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 72000;
	}
	
	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	@Override
	public boolean canHarvestBlock(Block block)
	{
		return block.blockID == Block.web.blockID;
	}
	
	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return 15;
	}
}
