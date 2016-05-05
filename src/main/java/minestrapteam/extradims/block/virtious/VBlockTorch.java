package minestrapteam.extradims.block.virtious;

import java.util.Random;

import minestrapteam.extradims.lib.virtious.Virtious;

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
