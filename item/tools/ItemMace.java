package clashsoft.mods.moredimensions.item.tools;

import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;

public class ItemMace extends ItemTool
{
	public ItemMace(int itemID, EnumToolMaterial material)
	{
		super(itemID, 6F, material, new Block[] {});
		this.setCreativeTab(MDMItems.tabTools);
	}
}
