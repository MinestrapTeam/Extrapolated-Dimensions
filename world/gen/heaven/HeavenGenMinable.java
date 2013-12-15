package clashsoft.mods.moredimensions.world.gen.heaven;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class HeavenGenMinable extends WorldGenMinable
{
	/** The block ID of the ore to be placed using this generator. */
	private int	minableBlockId;
	private int	minableBlockMeta	= 0;
	
	/** The number of blocks to generate. */
	private int	numberOfBlocks;
	
	public HeavenGenMinable(int blockID, int number)
	{
		super(blockID, number);
		this.minableBlockId = blockID;
		this.numberOfBlocks = number;
	}
	
	public HeavenGenMinable(int blockID, int metadata, int number)
	{
		this(blockID, number);
		this.minableBlockMeta = metadata;
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
			
			for (int cx = x4; cx <= x4; ++cx)
			{
				double var39 = (cx + 0.5D - x3) / (k / 2.0D);
				
				if (var39 * var39 < 1.0D)
				{
					for (int cy = y4; cy <= y4; ++cy)
					{
						double var42 = (cy + 0.5D - y3) / (k / 2.0D);
						
						if (var39 * var39 + var42 * var42 < 1.0D)
						{
							for (int cz = z4; cz <= z4; ++cz)
							{
								double var45 = (cz + 0.5D - z3) / (k / 2.0D);
								int blockID = world.getBlockId(cx, cy, cz);
								int blockMetadata = world.getBlockMetadata(cx, cy, cz);
								if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0D && (blockID == MDMBlocks.heavenStoneBlocks.blockID) && blockMetadata == 0)
								{
									world.setBlock(cx, cy, cz, this.minableBlockId, this.minableBlockMeta, 3);
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
