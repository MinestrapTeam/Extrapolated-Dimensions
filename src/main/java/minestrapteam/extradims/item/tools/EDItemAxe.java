package minestrapteam.extradims.item.tools;

import clashsoft.cslib.minecraft.item.datatools.ItemDataAxe;
import minestrapteam.extradims.lib.Tools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class EDItemAxe extends ItemTool
{
	public EDItemAxe(ToolMaterial material)
	{
		this(3F, 1F, material);
	}
	
	public EDItemAxe(float weaponDamage, float efficiencyMultiplier, ToolMaterial material)
	{
		super(weaponDamage, material, ItemDataAxe.blocksEffectiveAgainst);
		this.setCreativeTab(Tools.tabTools);
		this.efficiencyOnProperMaterial *= efficiencyMultiplier;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (block != null)
		{
			Material mat = block.getMaterial();
			if (mat == Material.wood || mat == Material.plants || mat == Material.vine)
			{
				return this.efficiencyOnProperMaterial;
			}
		}
		return super.getDigSpeed(stack, block, metadata);
	}
	
	public static class ItemHatchet extends EDItemAxe
	{
		public ItemHatchet(ToolMaterial material)
		{
			super(2.5F, 1.25F, material);
		}
	}
	
	public static class ItemBattleaxe extends EDItemAxe
	{
		public ItemBattleaxe(ToolMaterial material)
		{
			super(4F, 0.75F, material);
		}
	}
	
	public static class ItemSaw extends EDItemAxe
	{
		public ItemSaw(ToolMaterial material)
		{
			super(3F, 2F, material);
		}
	}
	
	public static class ItemThrowableAxe extends EDItemAxe
	{
		public ItemThrowableAxe(ToolMaterial material)
		{
			super(2.5F, 1F, material);
		}
	}
}
