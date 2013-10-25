package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockPOCActivatorLava extends BlockStationary
{
	public BlockPOCActivatorLava(int par1)
	{
		super(par1, Material.lava);
		this.setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").setTextureName("lava_still");
		this.setTickRandomly(true);
	}
	
	/**
	 * How many world ticks before ticking
	 */
	@Override
	public int tickRate(World par1World)
	{
		return 1;
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);
		tryToCreatePortal(par1World, par2, par3, par4);
	}
	
	private void tryToCreatePortal(World par1World, int par2, int par3, int par4)
	{
		try
		{
			for (int i = 0; i < 3; i++)
				if (MDMBlocks.Portal.tryToCreatePortal(par1World, par2, par3 - i, par4))
					break;
		}
		catch (Exception ex) {}
	}
	
	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		tryToCreatePortal(par1World, par2, par3, par4);
	}
}
