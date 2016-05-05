package minestrapteam.extradims.biome.virtious;

import minestrapteam.extracore.world.gen.WorldGenRanged;
import minestrapteam.extradims.lib.virtious.VBlocks;
import minestrapteam.extradims.lib.virtious.Virtious;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.*;

public class VirtiousBiomeDecorator extends BiomeDecorator
{
	public VirtiousBiomeDecorator()
	{
	}
	
	@Override
	public void decorateChunk(World world, Random random, BiomeGenBase biome, int chunkX, int chunkZ)
	{
		int x1;
		int y1;
		int z1;
		boolean doGen = TerrainGen.decorate(world, random, chunkX, chunkZ, GRASS);
		boolean doFlowerGen = TerrainGen.decorate(world, random, chunkX, chunkZ, FLOWERS);
		boolean doShroomGen = TerrainGen.decorate(world, random, chunkX, chunkZ, SHROOM);
		
		for (int x = 0; doGen && x < this.grassPerChunk; ++x)
		{
			x1 = chunkX + random.nextInt(16) + 8;
			y1 = random.nextInt(128);
			z1 = chunkZ + random.nextInt(16) + 8;
			
			WorldGenerator curlGrass = new WorldGenTallGrass(VBlocks.virtious_flowers, 1);
			curlGrass.generate(world, random, x1, y1, z1);
		}
		
		for (int flowers = 0; doFlowerGen && flowers < this.flowersPerChunk; ++flowers)
		{
			x1 = chunkX + random.nextInt(16) + 8;
			y1 = random.nextInt(128);
			z1 = chunkZ + random.nextInt(16) + 8;
			
			WorldGenerator flowerVeer = new WorldGenRanged(VBlocks.virtious_flowers, 0);
			flowerVeer.generate(world, random, x1, y1, z1);
		}
		
		for (int flowers = 0; doShroomGen && flowers < this.flowersPerChunk; ++flowers)
		{
			x1 = chunkX + random.nextInt(16) + 8;
			y1 = random.nextInt(128);
			z1 = chunkZ + random.nextInt(16) + 8;
			
			WorldGenerator shrooms = new WorldGenRanged(VBlocks.virtious_flowers, 2);
			shrooms.generate(world, random, x1, y1, z1);
		}
		
		for (int flowers = 0; doShroomGen && flowers < this.flowersPerChunk; ++flowers)
		{
			x1 = chunkX + random.nextInt(16) + 8;
			y1 = random.nextInt(128);
			z1 = chunkZ + random.nextInt(16) + 8;
			
			WorldGenerator shrooms = new WorldGenRanged(VBlocks.virtious_flowers, 3);
			shrooms.generate(world, random, x1, y1, z1);
		}
		
		Virtious.generateVirtious(world, random, chunkX, chunkZ);
	}
}
