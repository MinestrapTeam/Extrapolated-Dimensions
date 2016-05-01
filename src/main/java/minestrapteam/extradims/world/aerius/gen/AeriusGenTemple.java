package minestrapteam.extradims.world.aerius.gen;

import minestrapteam.extracore.world.gen.CustomWorldGen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public final class AeriusGenTemple extends CustomWorldGen
{
	/**
	 * The length (x size) of the temple. Must be 7 + multiple of 4.
	 */
	public int	length;
	
	/**
	 * The width (z size) of the temple. Must be 7 + multiple of 4.
	 */
	public int	width;
	
	/**
	 * The height of the temple
	 */
	public int	height;
	
	public AeriusGenTemple(boolean update)
	{
		this(update, 71, 31, 24);
	}
	
	public AeriusGenTemple(boolean update, int length, int width, int height)
	{
		super(update);
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void setBlock(World world, int x, int y, int z, Random random)
	{
		world.setBlock(x, y, z, Blocks.quartz_block, 0, this.flags);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		// Steps
		
		this.drawPlaneY(world, x, y, z, this.length, this.width, random);
		
		// Roof
		
		y += this.height;
		this.drawPlaneY(world, x, y, z, this.length, this.width, random);
		
		// Slope
		
		int c = this.width / 2;
		for (int i = 0; i < c; i += 2)
		{
			int y1 = y + (i >> 1) + 1;
			this.drawPlaneY(world, x, y1, z + i, this.length, 2, random);
			this.drawPlaneY(world, x, y1, z + this.width - i - 2, this.length, 2, random);
		}
		
		// Second Step
		
		x += 1;
		y += 1 - this.height;
		z += 1;
		this.length -= 2;
		this.width -= 2;
		this.drawPlaneY(world, x, y, z, this.length, this.width, random);
		
		// Pillars
		
		x += 2;
		z += 2;
		y += 1;
		this.length -= 4;
		this.width -= 4;
		this.height -= 2;
		
		for (int i = 0; i <= this.length; i += 4)
		{
			this.drawLineY(world, x + i, y, z, this.height, Blocks.quartz_block, 2);
			this.drawLineY(world, x + i, y, z + this.width - 1, this.height, Blocks.quartz_block, 2);
		}
		
		z += 4;
		this.width -= 8;
		for (int i = 0; i <= this.width; i += 4)
		{
			this.drawLineY(world, x, y, z + i, this.height, Blocks.quartz_block, 2);
			this.drawLineY(world, x + this.length - 1, y, z + i, this.height, Blocks.quartz_block, 2);
		}

		return true;
	}
}
