package clashsoft.mods.moredimensions.world.providers.chunk;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ChunkProviderHeaven extends AbstractChunkProvider
{
	public ChunkProviderHeaven(World par1World, long par2, boolean par4)
	{
		super(par1World, par2, par4);
	}

	/**
	 * Generates the shape of the terrain for the chunk though its all stone
	 * though the water is frozen if the temperature is low enough
	 */
	public void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte)
	{
		byte b0 = 4;
		byte b1 = 16;
		byte b2 = 63;
		int k = b0 + 1;
		byte b3 = 17;
		int l = b0 + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, k + 5, l + 5);
		this.noiseArray = this.initializeNoiseField(this.noiseArray, par1 * b0, 0, par2 * b0, k, b3, l);
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
									par3ArrayOfByte[j2 += short1] = (byte) MDMBlocks.stoneBlocks.blockID;
								}
								else if (k1 * 8 + l1 < b2)
								{
									par3ArrayOfByte[j2 += short1] = (byte) Block.waterStill.blockID;
								}
								else
								{
									par3ArrayOfByte[j2 += short1] = 0;
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
	
	public void replaceBlocksForBiome(int par1, int par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase)
	{
		byte var5 = 63;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);
		for (int var8 = 0; var8 < 16; var8++)
		{
			for (int var9 = 0; var9 < 16; var9++)
			{
				BiomeGenBase var10 = par4ArrayOfBiomeGenBase[(var9 + var8 * 16)];
				float var11 = var10.getFloatTemperature();
				int var12 = (int) (this.stoneNoise[(var8 + var9 * 16)] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int var13 = -1;
				byte var14 = var10.topBlock;
				byte var15 = var10.fillerBlock;
				for (int var16 = 127; var16 >= 0; var16--)
				{
					int var17 = (var9 * 16 + var8) * 128 + var16;
					if (var16 <= 0 + this.rand.nextInt(5))
					{
						par3ArrayOfByte[var17] = ((byte) Block.bedrock.blockID);
					}
					else
					{
						byte var18 = par3ArrayOfByte[var17];
						if (var18 == 0)
						{
							var13 = -1;
						}
						else if (var18 != MDMBlocks.stoneBlocks.blockID)
						{
							if (var13 == -1)
							{
								if (var12 == 0)
								{
									var14 = 0;
									
									var15 = (byte) MDMBlocks.groundBlocks.blockID;
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
										var14 = (byte) Block.ice.blockID;
									}
									else
									{
										var14 = (byte) Block.waterStill.blockID;
									}
								}
								var13 = var12;
								if (var16 >= var5 - 1)
								{
									par3ArrayOfByte[var17] = var14;
								}
								else
								{
									par3ArrayOfByte[var17] = var15;
								}
							}
							else if (var13 > 0)
							{
								var13--;
								par3ArrayOfByte[var17] = var15;
								if ((var13 == 0) && (var15 == Block.sand.blockID))
								{
									var13 = this.rand.nextInt(4);
									var15 = (byte) Block.sandStone.blockID;
								}
							}
						}
					}
				}
			}
		}
	}
}