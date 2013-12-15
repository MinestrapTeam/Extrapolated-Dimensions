package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockPOCActivatorLava extends BlockStationary
{
	public BlockPOCActivatorLava(int blockID)
	{
		super(blockID, Material.lava);
		this.setTickRandomly(true);
	}
	
	/**
	 * How many world ticks before ticking
	 */
	@Override
	public int tickRate(World world)
	{
		return 1;
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		this.tryToCreatePortal(world, x, y, z);
	}
	
	private void tryToCreatePortal(World world, int x, int y, int z)
	{
		try
		{
			for (int i = 0; i < 3; i++)
				if (MDMBlocks.pocPortal.tryToCreatePortal(world, x, y - i, z))
					break;
		}
		catch (Exception ex)
		{
		}
	}
	
	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.tryToCreatePortal(world, x, y, z);
	}
}
