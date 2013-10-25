package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPOCPortalFrame extends Block
{
	public BlockPOCPortalFrame(int par1)
	{
		super(par1, Material.rock);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return 0;
	}
}
