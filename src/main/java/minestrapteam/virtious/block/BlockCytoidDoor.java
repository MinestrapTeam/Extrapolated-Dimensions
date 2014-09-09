package minestrapteam.virtious.block;

import java.util.Random;

import minestrapteam.virtious.lib.VItems;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockCytoidDoor extends BlockDoor
{
	public BlockCytoidDoor(Material material)
	{
		super(material);
	}
    
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return VItems.cytoid_door;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return VItems.cytoid_door;
	}
}
