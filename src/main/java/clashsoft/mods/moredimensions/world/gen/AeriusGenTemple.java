package clashsoft.mods.moredimensions.world.gen;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.CustomWorldGen;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public final class AeriusGenTemple extends CustomWorldGen
{
	/**
	 * The length (x size) of the temple. Must be 7 + multiple of 4.
	 */
	public int	length	= 71;
	
	/**
	 * The width (z size) of the temple. Must be 7 + multiple of 4.
	 */
	public int	width	= 31;
	
	/**
	 * The height of the temple
	 */
	public int	height	= 24;
	
	public AeriusGenTemple(boolean update)
	{
		super(update);
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
		
		int length = this.length;
		int width = this.width;
		int height = this.height;
		
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
		
		now = System.currentTimeMillis() - now;
		System.out.println("Temple gen took " + now + " ms");
		
		return true;
	}
}
