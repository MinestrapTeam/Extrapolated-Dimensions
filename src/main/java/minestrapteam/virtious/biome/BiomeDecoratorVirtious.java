package minestrapteam.virtious.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM;
import clashsoft.cslib.minecraft.world.gen.WorldGenRanged;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorVirtious extends BiomeDecorator
{
	public BiomeDecoratorVirtious()
	{
	}
	
	protected void decorate()
	{
		int x1;
		int y1;
		int z1;
		boolean doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, GRASS);
		boolean doFlowerGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, FLOWERS);
		boolean doShroomGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, SHROOM);
		
		for (int x = 0; doGen && x < this.grassPerChunk; ++x)
		{
			x1 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y1 = this.randomGenerator.nextInt(128);
			z1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			
			WorldGenerator curlGrass = new WorldGenTallGrass(VBlocks.virtious_flowers, 1);
			curlGrass.generate(this.currentWorld, this.randomGenerator, x1, y1, z1);
		}
		
		for (int x = 0; doFlowerGen && x < this.flowersPerChunk; ++x)
		{
			x1 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y1 = this.randomGenerator.nextInt(128);
			z1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			
			WorldGenerator flowerVeer = new WorldGenRanged(VBlocks.virtious_flowers, 0);
			flowerVeer.generate(this.currentWorld, this.randomGenerator, x1, y1, z1);
		}
		
		for (int x = 0; doShroomGen && x < this.flowersPerChunk; ++x)
		{
			x1 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y1 = this.randomGenerator.nextInt(128);
			z1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			
			WorldGenerator shrooms = new WorldGenRanged(VBlocks.virtious_flowers, 2);
			shrooms.generate(this.currentWorld, this.randomGenerator, x1, y1, z1);
		}
		
		for (int x = 0; doShroomGen && x < this.flowersPerChunk; ++x)
		{
			x1 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y1 = this.randomGenerator.nextInt(128);
			z1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			
			WorldGenerator shrooms = new WorldGenRanged(VBlocks.virtious_flowers, 3);
			shrooms.generate(this.currentWorld, this.randomGenerator, x1, y1, z1);
		}
	}
}
