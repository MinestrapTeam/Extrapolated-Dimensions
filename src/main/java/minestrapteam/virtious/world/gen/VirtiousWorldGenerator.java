package minestrapteam.virtious.world.gen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import minestrapteam.virtious.biome.BiomeGenVirtious;
import minestrapteam.virtious.lib.VBlocks;
import minestrapteam.virtious.world.VirtiousChunkProvider;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class VirtiousWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (chunkGenerator instanceof VirtiousChunkProvider)
		{
			this.generateVirtious(random, chunkX * 16, chunkZ * 16, world);
		}
	}
	
	public void generateVirtious(Random random, int blockX, int blockZ, World world)
	{
		// Tak Ore
		for (int l = 0; l < 15; l++)
		{
			new VirtiousGenMinable(VBlocks.tak_ore, 9).generate(world, random, blockX + random.nextInt(16), random.nextInt(64), blockZ + random.nextInt(16));
		}
		
		// VIron
		for (int l = 0; l < 10; l++)
		{
			new VirtiousGenMinable(VBlocks.virtian_iron_ore, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(63), blockZ + random.nextInt(16));
		}
		
		// Brazeum
		for (int l = 0; l < 9; l++)
		{
			new VirtiousGenDeepstone(VBlocks.brazeum_ore, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		// Aquieus
		for (int l = 0; l < 7; l++)
		{
			new VirtiousGenDeepstone(VBlocks.aquieus_ore, 6).generate(world, random, blockX + random.nextInt(16), random.nextInt(32), blockZ + random.nextInt(16));
		}
		
		// Pluthorium
		for (int l = 0; l < 2; l++)
		{
			new VirtiousGenDeepstone(VBlocks.pluthorium_ore, 6).generate(world, random, blockX + random.nextInt(16), random.nextInt(16), blockZ + random.nextInt(16));
		}
		
		// Illuminous
		for (int l = 0; l < 11; l++)
		{
			new VirtiousGenMinable(VBlocks.illuminous_ore, 7).generate(world, random, blockX + random.nextInt(16), random.nextInt(64), blockZ + random.nextInt(16));
		}
		
		// Deep Illuminous
		for (int l = 0; l < 11; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_illuminous_ore, 7).generate(world, random, blockX + random.nextInt(16), random.nextInt(64), blockZ + random.nextInt(16));
		}
		
		// Deep Tak
		for (int l = 0; l < 15; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_tak_ore, 9).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		// Deep Tak
		for (int l = 0; l < 10; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_iron_ore, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		// Deep Tak
		for (int l = 0; l < 9; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deepstone_mossy, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		VirtiousGenVirtianTree treeVirtian = new VirtiousGenVirtianTree(false);
		VirtiousGenAmberTree treeAmber = new VirtiousGenAmberTree(false);
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(blockX, blockZ);
		
		if (biome instanceof BiomeGenVirtious)
		{
			
			int Xcoord = blockX + random.nextInt(16);
			int Zcoord = blockZ + random.nextInt(16);
			int i = world.getHeightValue(Xcoord, Zcoord);
			if (random.nextInt(2) == 1)
			{
				treeVirtian.generate(world, random, Xcoord, i, Zcoord);
			}
			else
			{
				treeAmber.generate(world, random, Xcoord, i, Zcoord);
			}
			
		}
	}
}
