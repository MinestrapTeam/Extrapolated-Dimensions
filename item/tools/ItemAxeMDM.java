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
	public ItemAxeMDM(int par1, float weaponDamage, float efficiencyMultiplier, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, weaponDamage, par2EnumToolMaterial, ItemAxe.blocksEffectiveAgainst);
		this.setCreativeTab(MDMItems.tabTools);
		this.efficiencyOnProperMaterial *= efficiencyMultiplier;
	}
	
	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}
	
	public static class ItemHatchet extends ItemAxeMDM
	{
		public ItemHatchet(int par1, EnumToolMaterial par2EnumToolMaterial)
		{
			super(par1, 2.5F, 1.25F, par2EnumToolMaterial);
		}
	}
	
	public static class ItemBattleaxe extends ItemAxeMDM
	{
		public ItemBattleaxe(int par1, EnumToolMaterial par2EnumToolMaterial)
		{
			super(par1, 4F, 0.75F, par2EnumToolMaterial);
		}
	}
}
