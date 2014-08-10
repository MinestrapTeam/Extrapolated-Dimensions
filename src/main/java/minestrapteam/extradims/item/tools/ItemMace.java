package minestrapteam.extradims.item.tools;

import java.util.Collections;

import minestrapteam.extradims.lib.Tools;

import net.minecraft.item.ItemTool;

public class ItemMace extends ItemTool
{
	public ItemMace(ToolMaterial material)
	{
		super(6F, material, Collections.EMPTY_SET);
		this.setCreativeTab(Tools.tabTools);
	}
}
