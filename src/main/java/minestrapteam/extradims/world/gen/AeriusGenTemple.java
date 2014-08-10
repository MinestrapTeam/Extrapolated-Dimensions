package minestrapteam.extradims.world.gen;

import java.util.Random;

import clashsoft.cslib.minecraft.world.CSWorld;
import clashsoft.cslib.minecraft.world.gen.CustomWorldGen;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

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
		long now = System.currentTimeMillis();
		
		if (CSWorld.isBoxEmpty(world, x, y, z, this.length, this.width, this.height))
		{
			this.generate(world, random, x, y, z, this.length, this.width, this.height);
			
			now = System.currentTimeMillis() - now;
			System.out.println("Temple generation took " + now + " ms");
			return true;
		}
		
		return false;
	}
	
	public void generate(World world, Random random, int x, int y, int z, int length, int width, int height)
	{
		// Steps
		
		this.drawPlaneY(world, x, y, z, length, width, random);
		
		// Roof
		
		y += height;
		this.drawPlaneY(world, x, y, z, length, width, random);
		
		// Slope
		
		int c = this.width / 2;
		for (int i = 0; i < c; i += 2)
		{
			int y1 = y + (i >> 1) + 1;
			this.drawPlaneY(world, x, y1, z + i, length, 2, random);
			this.drawPlaneY(world, x, y1, z + width - i - 2, length, 2, random);
		}
		
		// Second Step
		
		x += 1;
		y += 1 - height;
		z += 1;
		length -= 2;
		width -= 2;
		this.drawPlaneY(world, x, y, z, length, width, random);
		
		// Pillars
		
		x += 2;
		z += 2;
		y += 1;
		length -= 4;
		width -= 4;
		height -= 2;
		
		for (int i = 0; i <= length; i += 4)
		{
			this.drawLineY(world, x + i, y, z, height, Blocks.quartz_block, 2);
			this.drawLineY(world, x + i, y, z + width - 1, height, Blocks.quartz_block, 2);
		}
		
		z += 4;
		width -= 8;
		for (int i = 0; i <= width; i += 4)
		{
			this.drawLineY(world, x, y, z + i, height, Blocks.quartz_block, 2);
			this.drawLineY(world, x + length - 1, y, z + i, height, Blocks.quartz_block, 2);
		}
	}
}
