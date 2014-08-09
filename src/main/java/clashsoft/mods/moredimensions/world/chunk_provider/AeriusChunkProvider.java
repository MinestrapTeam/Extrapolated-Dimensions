package clashsoft.mods.moredimensions.world.chunk_provider;

import clashsoft.cslib.minecraft.world.CustomChunkProvider;
import clashsoft.mods.moredimensions.lib.Aerius;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class AeriusChunkProvider extends CustomChunkProvider
{
	public double[]	noiseField5;
	public double[]	noiseField6;
	public double[]	noiseField7;
	public double[]	noiseField8;
	public double[]	noiseField9;
	
	public AeriusChunkProvider(World world, long seed)
	{
		super(world, seed, false);
	}
	
	@Override
	public void generate(int x, int y, Block[] blocks)
	{
		this.noiseField1 = this.initializeNoiseField(this.noiseField1, x * 2, 0, y * 2, 3, 33, 3);
		double d = 0.125D;
		double d9 = 0.125D;
		double d14 = 0.125D;
		
		for (int x1 = 0; x1 < 2; x1++)
		{
			int l = x1 * 3;
			int i1 = (x1 + 1) * 3;
			
			for (int z1 = 0; z1 < 2; z1++)
			{
				int k1 = (l + z1) * 33;
				int l1 = (l + z1 + 1) * 33;
				int i2 = (i1 + z1) * 33;
				int j2 = (i1 + z1 + 1) * 33;
				
				for (int y1 = 0; y1 < 32; y1++)
				{
					double d1 = this.noiseField1[k1 + y1];
					double d2 = this.noiseField1[l1 + y1];
					double d3 = this.noiseField1[i2 + y1];
					double d4 = this.noiseField1[j2 + y1];
					double d5 = (this.noiseField1[k1 + y1 + 1] - d1) * d;
					double d6 = (this.noiseField1[l1 + y1 + 1] - d2) * d;
					double d7 = (this.noiseField1[i2 + y1 + 1] - d3) * d;
					double d8 = (this.noiseField1[j2 + y1 + 1] - d4) * d;
					
					for (int y2 = 0; y2 < 8; y2++)
					{
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						for (int y3 = 0; y3 < 8; y3++)
						{
							int index = y3 + (x1 * 8) << 12 | (z1 * 8) << 8 | (y1 * 8) + y2;
							
							double d15 = d10;
							double d16 = (d11 - d10) * d14;
							for (int k2 = 0; k2 < 8; k2++)
							{
								if (d15 > 0.0D)
								{
									blocks[index] = Aerius.stoneBlocks;
								}
								index += 256;
								d15 += d16;
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
	
	public double[] initializeNoiseField(double[] noiseArray, int x, int y, int z, int xSize, int ySize, int zSize)
	{
		if (noiseArray == null)
		{
			noiseArray = new double[xSize * ySize * zSize];
		}
		
		this.noiseField8 = this.noiseGen1.generateNoiseOctaves(this.noiseField8, x, z, xSize, zSize, 1.121D, 1.121D, 0.5D);
		this.noiseField9 = this.noiseGen4.generateNoiseOctaves(this.noiseField9, x, z, xSize, zSize, 200.0D, 200.0D, 0.5D);
		
		this.noiseField5 = this.noiseGen3.generateNoiseOctaves(this.noiseField5, x, y, z, xSize, ySize, zSize, 1368.824D / 80.0D, 684.412D / 160.0D, 1368.824D / 80.0D);
		this.noiseField6 = this.noiseGen1.generateNoiseOctaves(this.noiseField6, x, y, z, xSize, ySize, zSize, 1368.824D, 684.412D, 1368.824D);
		this.noiseField7 = this.noiseGen2.generateNoiseOctaves(this.noiseField7, x, y, z, xSize, ySize, zSize, 1368.824D, 684.412D, 1368.824D);
		
		int k1 = 0;
		int l1 = 0;
		for (int j2 = 0; j2 < xSize; j2++)
		{
			for (int l2 = 0; l2 < zSize; l2++)
			{
				double d4 = 1.0D;
				d4 *= d4;
				d4 *= d4;
				d4 = 1.0D - d4;
				double d5 = (this.noiseField8[l1] + 256.0D) / 512.0D;
				d5 *= d4;
				if (d5 > 1.0D)
				{
					d5 = 1.0D;
				}
				double d6 = this.noiseField9[l1] / 8000.0D;
				if (d6 < 0.0D)
				{
					d6 = -d6 * 0.3D;
				}
				d6 = d6 * 3.0D - 2.0D;
				if (d6 > 1.0D)
				{
					d6 = 1.0D;
				}
				d6 /= 8.0D;
				d6 = 0.0D;
				if (d5 < 0.0D)
				{
					d5 = 0.0D;
				}
				d5 += 0.5D;
				d6 = d6 * ySize / 16.0D;
				l1++;
				double d7 = ySize / 2.0D;
				for (int j3 = 0; j3 < ySize; j3++)
				{
					double d8 = 0.0D;
					double d9 = (j3 - d7) * 8.0D / d5;
					if (d9 < 0.0D)
					{
						d9 *= -1.0D;
					}
					double d10 = this.noiseField6[k1] / 512.0D;
					double d11 = this.noiseField7[k1] / 512.0D;
					double d12 = (this.noiseField5[k1] / 10.0D + 1.0D) / 2.0D;
					if (d12 < 0.0D)
						d8 = d10;
					else if (d12 > 1.0D)
						d8 = d11;
					else
					{
						d8 = d10 + (d11 - d10) * d12;
					}
					d8 -= 8.0D;
					int k3 = 32;
					if (j3 > ySize - k3)
					{
						double d13 = (j3 - (ySize - k3)) / (k3 - 1.0F);
						d8 = d8 * (1.0D - d13) + -30.0D * d13;
					}
					k3 = 8;
					if (j3 < k3)
					{
						double d14 = (k3 - j3) / (k3 - 1.0F);
						d8 = d8 * (1.0D - d14) + -30.0D * d14;
					}
					noiseArray[k1] = d8;
					k1++;
				}
			}
		}
		return noiseArray;
	}
}