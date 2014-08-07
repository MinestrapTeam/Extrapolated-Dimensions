package clashsoft.mods.moredimensions.item.tools;

import java.util.Collections;

import clashsoft.mods.moredimensions.lib.Tools;

import net.minecraft.item.ItemTool;

public class ItemMace extends ItemTool
{
	public ItemMace(ToolMaterial material)
	{
		super(6F, material, Collections.EMPTY_SET);
		this.setCreativeTab(Tools.tabTools);
	}
}
