package clashsoft.mods.moredimensions.world.gen.heaven;

import java.util.Random;

import clashsoft.cslib.minecraft.world.CSWorld;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class HeavenGenBuildings
{
	public static HeavenGenBuildings	instance	= new HeavenGenBuildings();
	
	/**
	 * The WorldGen for a little hut
	 * 
	 * @author Clashsoft
	 */
	public class HeavenGenBuilding1 extends WorldGenerator
	{
		public HeavenGenBuilding1()
		{
			
		}
		
		public HeavenGenBuilding1(boolean flag)
		{
			super(flag);
		}
		
		@Override
		public boolean generate(World world, Random rand, int x, int y, int z)
		{
			return this.generateN(world, rand, x, y, z);
		}
		
		public boolean generateN(World world, Random rand, int x, int y, int z)
		{
			// Heavencobble frame
			CSWorld.setFrame(world, x, y, z, x + 6, y + 4, z + 6, MDMBlocks.heavenStoneBlocks, 1);
			// Walls
			CSWorld.setCube(world, x, y + 1, z + 1, x, y + 3, z + 5, MDMBlocks.heavenPlanks, 0);
			CSWorld.setCube(world, x + 1, y + 1, z, x + 5, y + 3, z, MDMBlocks.heavenPlanks, 0);
			CSWorld.setCube(world, x + 6, y + 1, z + 1, x + 6, y + 3, z + 5, MDMBlocks.heavenPlanks, 0);
			CSWorld.setCube(world, x + 1, y + 1, z + 6, x + 5, y + 3, z + 6, MDMBlocks.heavenPlanks, 0);
			// Floor
			CSWorld.setCube(world, x + 1, y, z + 1, x + 5, y, z + 5, MDMBlocks.heavenLogs, 0);
			// Door
			CSWorld.setCube(world, x + 3, y + 1, z, x + 3, y + 2, z, Blocks.air, 0);
			// Windows
			CSWorld.setBlock(world, x + 3, y + 2, z + 6, Blocks.glass_pane, 0);
			CSWorld.setBlock(world, x + 3, y, z, Blocks.glass_pane, 0);
			CSWorld.setBlock(world, x, y, z + 3, Blocks.glass_pane, 0);
			CSWorld.setBlock(world, x + 6, y, z + 3, Blocks.glass_pane, 0);
			return false;
		}
	}
}
