package minestrapteam.extradims.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class AeriusGenClouds extends WorldGenerator
{
	public int		count;
	public Block	cloudBlock;
	public int		cloudMetadata;
	public boolean	flat;
	
	public AeriusGenClouds(boolean update, int count, Block block, int metadata)
	{
		this(update, count, block, metadata, false);
	}
	
	public AeriusGenClouds(boolean update, int count, Block block, int metadata, boolean flat)
	{
		super(update);
		this.count = count;
		this.cloudBlock = block;
		this.cloudMetadata = metadata;
		this.flat = flat;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int x0 = random.nextInt(3) - 1;
		int z0 = random.nextInt(3) - 1;
		int maxOffset = this.flat ? 12 : 4;
		int maxSize = this.flat ? 9 : 3;
		
		for (int i = 0; i < this.count; i++)
		{
			x += random.nextInt(3) - 1 + x0;
			if (this.flat ? random.nextInt(10) == 0 : random.nextBoolean())
			{
				y += random.nextInt(3) - 1;
			}
			z += random.nextInt(3) - 1 + z0;
			
			for (int x1 = 0; x1 < maxSize + random.nextInt(4); x1++)
			{
				for (int y1 = 0; y1 < 2 + random.nextInt(1); y1++)
				{
					for (int z1 = 0; z1 < maxSize + random.nextInt(4); z1++)
					{
						if (world.isAirBlock(x + x1, y + y1, z + z1) && x1 + y1 + z1 < maxOffset + random.nextInt(2))
						{
							this.setBlockAndNotifyAdequately(world, x + x1, y + y1, z + z1, this.cloudBlock, this.cloudMetadata);
						}
					}
				}
			}
		}
		
		return true;
	}
	
}
