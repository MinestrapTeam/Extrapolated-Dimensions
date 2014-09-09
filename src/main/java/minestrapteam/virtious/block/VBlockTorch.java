package minestrapteam.virtious.block;

import java.util.Random;

import minestrapteam.virtious.Virtious;

import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;

public class VBlockTorch extends BlockTorch
{
	public VBlockTorch()
	{
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
	}
}
