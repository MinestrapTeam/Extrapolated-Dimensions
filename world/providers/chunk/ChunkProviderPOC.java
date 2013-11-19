package clashsoft.mods.moredimensions.world.providers.chunk;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ChunkProviderPOC extends AbstractChunkProvider
{
	public ChunkProviderPOC(World world, long seed, boolean mapFeatures)
	{
		super(world, seed, mapFeatures);
	}
	
	/**
	 * Generates the shape of the terrain for the chunk though its all stone
	 * though the water is frozen if the temperature is low enough
	 */
	public void generateTerrain(int x, int z, byte[] storage)
	{
		byte b0 = 4;
		byte b1 = 16;
		byte b2 = 63;
		
		int k = b0 + 1;
		byte b3 = 17;
		int l = b0 + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, k + 5, l + 5);
		this.noiseArray = this.initializeNoiseField(this.noiseArray, x * b0, 0, z * b0, k, b3, l);
		for (int x1 = 0; x1 < b0; ++x1)
		{
			for (int z1 = 0; z1 < b0; ++z1)
			{
				for (int y1 = 0; y1 < b1; ++y1)
				{
					double d0 = 0.125D;
					double d1 = this.noiseArray[((x1 + 0) * l + z1 + 0) * b3 + y1 + 0];
					double d2 = this.noiseArray[((x1 + 0) * l + z1 + 1) * b3 + y1 + 0];
					double d3 = this.noiseArray[((x1 + 1) * l + z1 + 0) * b3 + y1 + 0];
					double d4 = this.noiseArray[((x1 + 1) * l + z1 + 1) * b3 + y1 + 0];
					double d5 = (this.noiseArray[((x1 + 0) * l + z1 + 0) * b3 + y1 + 1] - d1) * d0;
					double d6 = (this.noiseArray[((x1 + 0) * l + z1 + 1) * b3 + y1 + 1] - d2) * d0;
					double d7 = (this.noiseArray[((x1 + 1) * l + z1 + 0) * b3 + y1 + 1] - d3) * d0;
					double d8 = (this.noiseArray[((x1 + 1) * l + z1 + 1) * b3 + y1 + 1] - d4) * d0;
					for (int l1 = 0; l1 < 8; ++l1)
					{
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						for (int i2 = 0; i2 < 4; ++i2)
						{
							int j2 = i2 + x1 * 4 << 11 | 0 + z1 * 4 << 7 | y1 * 8 + l1;
							short short1 = 128;
							j2 -= short1;
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;
							for (int k2 = 0; k2 < 4; ++k2)
							{
								if ((d16 += d15) > 0.0D)
								{
									storage[j2 += short1] = (byte) MDMBlocks.pocStoneBlocks.blockID;
								}
								else if (y1 * 8 + l1 < b2)
								{
									storage[j2 += short1] = (byte) Block.waterStill.blockID;
								}
								else
								{
									storage[j2 += short1] = 0;
								}
							}
							d10 += d12;
							d11 += d13;
						}
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	
	public void replaceBlocksForBiome(int x, int z, byte[] storage, BiomeGenBase[] biomes)
	{
		byte averageHeight = 63;
		double d = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, x * 16, z * 16, 0, 16, 16, 1, d * 2.0D, d * 2.0D, d * 2.0D);
		for (int x1 = 0; x1 < 16; x1++)
		{
			for (int z1 = 0; z1 < 16; z1++)
			{
				BiomeGenBase biome = biomes[(z1 + x1 * 16)];
				float temperature = biome.getFloatTemperature();
				int noise = (int) (this.stoneNoise[(x1 + z1 * 16)] / 3.0D + 3.0D + this.random.nextDouble() * 0.25D);
				int j1 = -1;
				byte topBlock = biome.topBlock;
				byte fillerBlock = biome.fillerBlock;
				for (int y1 = 127; y1 >= 0; y1--)
				{
					int index = (z1 * 16 + x1) * 128 + y1;
					if (y1 <= 0 + this.random.nextInt(5))
					{
						storage[index] = ((byte) Block.bedrock.blockID);
					}
					else
					{
						byte blockAtIndex = storage[index];
						if (blockAtIndex == 0)
						{
							j1 = -1;
						}
						else if (blockAtIndex != MDMBlocks.pocStoneBlocks.blockID)
						{
							if (j1 == -1)
							{
								if (noise == 0)
								{
									topBlock = 0;
									fillerBlock = (byte) MDMBlocks.pocDirtBlocks.blockID;
								}
								else if ((y1 >= averageHeight - 4) && (y1 <= averageHeight + 1))
								{
									topBlock = biome.topBlock;
									fillerBlock = biome.fillerBlock;
								}
								if ((y1 < averageHeight) && (topBlock == 0))
								{
									if (temperature < 0.15F)
									{
										topBlock = (byte) Block.ice.blockID;
									}
									else
									{
										topBlock = (byte) Block.waterStill.blockID;
									}
								}
								j1 = noise;
								if (y1 >= averageHeight - 1)
								{
									storage[index] = topBlock;
								}
								else
								{
									storage[index] = fillerBlock;
								}
							}
							else if (j1 > 0)
							{
								j1--;
								storage[index] = fillerBlock;
								if ((j1 == 0) && (fillerBlock == Block.sand.blockID))
								{
									j1 = this.random.nextInt(4);
									fillerBlock = (byte) Block.sandStone.blockID;
								}
							}
						}
					}
				}
			}
		}
	}
}