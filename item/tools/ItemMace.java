package clashsoft.mods.moredimensions.item.tools;

import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;

public class ItemMace extends ItemTool
{
	public ItemMace(int par1, EnumToolMaterial par3EnumToolMaterial)
	{
		super(par1, 6F, par3EnumToolMaterial, new Block[] {});
		this.setCreativeTab(MDMItems.tabTools);
	}	
}
