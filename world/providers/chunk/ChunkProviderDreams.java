package clashsoft.mods.moredimensions.world.providers.chunk;

import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class ChunkProviderDreams extends AbstractChunkProvider
{
	public DreamType	dreamType;
	
	public ChunkProviderDreams(World world, long seed, boolean flag, DreamType dreamType)
	{
		super(world, seed, flag);
		this.dreamType = dreamType;
	}
	
	/**
	 * Generates the shape of the terrain for the chunk though its all stone though the water is frozen if the temperature is low enough
	 */
	@Override
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
		for (int i1 = 0; i1 < b0; ++i1)
		{
			for (int j1 = 0; j1 < b0; ++j1)
			{
				for (int k1 = 0; k1 < b1; ++k1)
				{
					double d0 = 0.125D;
					double d1 = this.noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
					double d2 = this.noiseArray[((i1 + 0) * l + j1 + 1) * b3 + k1 + 0];
					double d3 = this.noiseArray[((i1 + 1) * l + j1 + 0) * b3 + k1 + 0];
					double d4 = this.noiseArray[((i1 + 1) * l + j1 + 1) * b3 + k1 + 0];
					double d5 = (this.noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
					double d6 = (this.noiseArray[((i1 + 0) * l + j1 + 1) * b3 + k1 + 1] - d2) * d0;
					double d7 = (this.noiseArray[((i1 + 1) * l + j1 + 0) * b3 + k1 + 1] - d3) * d0;
					double d8 = (this.noiseArray[((i1 + 1) * l + j1 + 1) * b3 + k1 + 1] - d4) * d0;
					for (int l1 = 0; l1 < 8; ++l1)
					{
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						for (int i2 = 0; i2 < 4; ++i2)
						{
							int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
							short short1 = 128;
							j2 -= short1;
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;
							for (int k2 = 0; k2 < 4; ++k2)
							{
								if ((d16 += d15) > 0.0D)
								{
									storage[j2 += short1] = (byte) this.dreamType.getStoneBlock().blockID;
								}
								else if (k1 * 8 + l1 < b2)
								{
									storage[j2 += short1] = (byte) this.dreamType.getWaterBlock().blockID;
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
	
	@Override
	public void replaceBlocksForBiome(int x, int y, byte[] storage, BiomeGenBase[] biomes)
	{
		byte var5 = 63;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, x * 16, y * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);
		for (int var8 = 0; var8 < 16; var8++)
		{
			for (int var9 = 0; var9 < 16; var9++)
			{
				BiomeGenBase var10 = biomes[(var9 + var8 * 16)];
				float var11 = var10.getFloatTemperature();
				int var12 = (int) (this.stoneNoise[(var8 + var9 * 16)] / 3.0D + 3.0D + this.random.nextDouble() * 0.25D);
				int var13 = -1;
				byte var14 = var10.topBlock;
				byte var15 = var10.fillerBlock;
				for (int var16 = 127; var16 >= 0; var16--)
				{
					int var17 = (var9 * 16 + var8) * 128 + var16;
					if (var16 <= 0 + this.random.nextInt(5))
					{
						storage[var17] = ((byte) this.dreamType.getBedrockBlock().blockID);
					}
					else
					{
						byte var18 = storage[var17];
						if (var18 == 0)
						{
							var13 = -1;
						}
						/**
						 * Main filler block fill's all the underground, replaces block stone
						 **/
						else if (var18 != this.dreamType.getStoneBlock().blockID)
						{
							if (var13 == -1)
							{
								if (var12 == 0)
								{
									var14 = 0;
									
									var15 = (byte) this.dreamType.getDirtBlock().blockID;//
								}
								else if ((var16 >= var5 - 4) && (var16 <= var5 + 1))
								{
									var14 = var10.topBlock;
									var15 = var10.fillerBlock;
								}
								if ((var16 < var5) && (var14 == 0))
								{
									if (var11 < 0.15F)
									{
										var14 = (byte) this.dreamType.getIceBlock().blockID;
									}
									else
									{
										var14 = (byte) this.dreamType.getWaterBlock().blockID;
									}
								}
								var13 = var12;
								if (var16 >= var5 - 1)
								{
									storage[var17] = var14;
								}
								else
								{
									storage[var17] = var15;
								}
							}
							else if (var13 > 0)
							{
								var13--;
								storage[var17] = var15;
								if ((var13 == 0) && (var15 == this.dreamType.getSandBlock().blockID))
								{
									var13 = this.random.nextInt(4);
									var15 = (byte) this.dreamType.getSandstoneBlock().blockID;
								}
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public Chunk loadChunk(int x, int y)
	{
		return this.provideChunk(x, y);
	}
	
	@Override
	public Chunk provideChunk(int x, int y)
	{
		this.random.setSeed(x * 341873128712L + y * 132897987541L);
		byte[] var3 = new byte[32768];
		this.generateTerrain(x, y, var3);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, y * 16, 16, 16);
		this.replaceBlocksForBiome(x, y, var3, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, x, y, var3);
		this.ravineGenerator.generate(this, this.worldObj, x, y, var3);
		if (this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generate(this, this.worldObj, x, y, var3);
			this.villageGenerator.generate(this, this.worldObj, x, y, var3);
			this.strongholdGenerator.generate(this, this.worldObj, x, y, var3);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, x, y, var3);
		}
		Chunk chunk = new Chunk(this.worldObj, var3, x, y);
		byte[] biomes = chunk.getBiomeArray();
		for (int var6 = 0; var6 < biomes.length; var6++)
		{
			biomes[var6] = ((byte) this.biomesForGeneration[var6].biomeID);
		}
		chunk.generateSkylightMap();
		return chunk;
	}
}