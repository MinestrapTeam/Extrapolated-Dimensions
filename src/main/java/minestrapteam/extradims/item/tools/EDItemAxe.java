package minestrapteam.extradims.item.tools;

import minestrapteam.extracore.util.ArrayUtil;
import minestrapteam.extradims.lib.Tools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class EDItemAxe extends ItemTool
{
	public static final Set<Block> blocksEffectiveAgainst = ArrayUtil.asSet(Blocks.planks, Blocks.bookshelf, Blocks.log,
	                                                                        Blocks.log2, Blocks.chest, Blocks.pumpkin,
	                                                                        Blocks.lit_pumpkin);

	public EDItemAxe(ToolMaterial material)
	{
		this(3F, 1F, material);
	}

	public EDItemAxe(float weaponDamage, float efficiencyMultiplier, ToolMaterial material)
	{
		super(weaponDamage, material, blocksEffectiveAgainst);
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
