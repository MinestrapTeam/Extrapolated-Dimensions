package clashsoft.mods.moredimensions.item.tools;

import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemAxeMDM extends ItemTool
{
	public ItemAxeMDM(int itemID, float weaponDamage, float efficiencyMultiplier, EnumToolMaterial material)
	{
		super(itemID, weaponDamage, material, ItemAxe.blocksEffectiveAgainst);
		this.setCreativeTab(MDMItems.tabTools);
		this.efficiencyOnProperMaterial *= efficiencyMultiplier;
	}
	
	/**
	 * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
	{
		return block != null && (block.blockMaterial == Material.wood || block.blockMaterial == Material.plants || block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(stack, block);
	}
	
	public static class ItemHatchet extends ItemAxeMDM
	{
		public ItemHatchet(int itemID, EnumToolMaterial material)
		{
			super(itemID, 2.5F, 1.25F, material);
		}
	}
	
	public static class ItemBattleaxe extends ItemAxeMDM
	{
		public ItemBattleaxe(int itemID, EnumToolMaterial material)
		{
			super(itemID, 4F, 0.75F, material);
		}
	}
	
	public static class ItemSaw extends ItemAxeMDM
	{
		public ItemSaw(int itemID, EnumToolMaterial material)
		{
			super(itemID, 3F, 2F, material);
		}
	}
	
	public static class ItemThrowableAxe extends ItemAxeMDM
	{
		public ItemThrowableAxe(int itemID, EnumToolMaterial material)
		{
			super(itemID, 2.5F, 1F, material);
		}
	}
}
