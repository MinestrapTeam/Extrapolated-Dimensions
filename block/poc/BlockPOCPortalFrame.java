package clashsoft.mods.moredimensions.block.poc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPOCPortalFrame extends Block
{
	public BlockPOCPortalFrame(int blockID)
	{
		super(blockID, Material.rock);
	}
	
	@Override
	public int idDropped(int metadata, Random random, int fortune)
	{
		return 0;
	}
}
