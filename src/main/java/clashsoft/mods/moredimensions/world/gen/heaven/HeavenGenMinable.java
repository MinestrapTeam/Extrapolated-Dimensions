package clashsoft.mods.moredimensions.world.gen.heaven;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class HeavenGenMinable extends WorldGenMinable
{
	/** The block ID of the ore to be placed using this generator. */
	private Block	minableBlock;
	private int	minableBlockMetadata	= 0;
	
	/** The number of blocks to generate. */
	private int	numberOfBlocks;
	
	public HeavenGenMinable(Block block, int number)
	{
		super(block, number);
		this.minableBlock = block;
		this.numberOfBlocks = number;
	}
	
	public HeavenGenMinable(Block block, int metadata, int number)
	{
		this(block, number);
		this.minableBlockMetadata = metadata;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		float var6 = random.nextFloat() * (float) Math.PI;
		double x1 = x + 8 + MathHelper.sin(var6) * this.numberOfBlocks / 8.0F;
		double x2 = x + 8 - MathHelper.sin(var6) * this.numberOfBlocks / 8.0F;
		double y1 = y + random.nextInt(3) - 2;
		double y2 = y + random.nextInt(3) - 2;
		double z1 = z + 8 + MathHelper.cos(var6) * this.numberOfBlocks / 8.0F;
		double z2 = z + 8 - MathHelper.cos(var6) * this.numberOfBlocks / 8.0F;
		
		for (int i = 0; i <= this.numberOfBlocks; ++i)
		{
			double x3 = x1 + (x2 - x1) * i / this.numberOfBlocks;
			double y3 = y1 + (y2 - y1) * i / this.numberOfBlocks;
			double z3 = z1 + (z2 - z1) * i / this.numberOfBlocks;
			double j = random.nextDouble() * this.numberOfBlocks / 16.0D;
			double k = (MathHelper.sin(i * (float) Math.PI / this.numberOfBlocks) + 1.0F) * j + 1.0D;
			int x4 = MathHelper.floor_double(x3 - k / 2.0D);
			int y4 = MathHelper.floor_double(y3 - k / 2.0D);
			int z4 = MathHelper.floor_double(z3 - k / 2.0D);
			
			for (int x0 = x4; x0 <= x4; ++x0)
			{
				double xf = (x0 + 0.5D - x3) / (k / 2.0D);
				
				if (xf * xf < 1.0D)
				{
					for (int y0 = y4; y0 <= y4; ++y0)
					{
						double yf = (y0 + 0.5D - y3) / (k / 2.0D);
						
						if (xf * xf + yf * yf < 1.0D)
						{
							for (int z0 = z4; z0 <= z4; ++z0)
							{
								double zf = (z0 + 0.5D - z3) / (k / 2.0D);
								Block block = world.getBlock(x0, y0, z0);
								int blockMetadata = world.getBlockMetadata(x0, y0, z0);
								if (xf * xf + yf * yf + zf * zf < 1.0D && (block == MDMBlocks.heavenStoneBlocks) && blockMetadata == 0)
								{
									world.setBlock(x0, y0, z0, this.minableBlock, this.minableBlockMetadata, 3);
								}
							}
						}
					}
				}
			}
		}
		
		return true;
	}
}
