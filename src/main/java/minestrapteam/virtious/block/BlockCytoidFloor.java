package minestrapteam.virtious.block;

import clashsoft.cslib.minecraft.block.BlockCustomSlab;
import clashsoft.cslib.minecraft.client.icon.slab.SlabIconSupplier;

import net.minecraft.block.material.Material;

public class BlockCytoidFloor extends BlockCustomSlab
{
	public BlockCytoidFloor(boolean doubleSlab)
	{
		super(Material.rock, new String[] { null }, new SlabIconSupplier("virtious:cytoid_floor", "virtious:cytoid_floor_side"), doubleSlab);
	}
}
