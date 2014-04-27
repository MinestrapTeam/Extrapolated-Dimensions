package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockPOCPortalFrame extends Block
{
	public BlockPOCPortalFrame(int blockID)
	{
		super(Material.rock);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Item.getItemById(0);
	}
}
