package minestrapteam.virtious.block;

import java.util.Random;

import minestrapteam.virtious.lib.VItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockTakOre extends VBlock
{
	public BlockTakOre(Material material)
	{
		super(material);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int meta)
	{
		return VItems.tak;
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return true;
	}
}
