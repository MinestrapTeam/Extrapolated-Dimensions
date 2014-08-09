package clashsoft.mods.moredimensions.world.gen.heaven;

import java.util.Random;

import clashsoft.cslib.minecraft.world.gen.CustomWorldGen;

import net.minecraft.world.World;

public class HeavenGenBuildings
{
	/**
	 * The WorldGen for a little hut
	 * 
	 * @author Clashsoft
	 */
	public static class SimpleHut extends CustomWorldGen
	{
		public SimpleHut(boolean flag)
		{
			super(flag);
		}
		
		@Override
		public boolean generate(World world, Random rand, int x, int y, int z)
		{
			return false;
		}
	}
}
