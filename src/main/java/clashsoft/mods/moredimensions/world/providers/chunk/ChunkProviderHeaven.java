package clashsoft.mods.moredimensions.world.providers.chunk;

import clashsoft.mods.moredimensions.addons.Heaven;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ChunkProviderHeaven extends AbstractChunkProvider
{
	public double[]	noiseField5;
	public double[]	noiseField6;
	public double[]	noiseField7;
	public double[]	noiseField8;
	public double[]	noiseField9;
	
	public ChunkProviderHeaven(World world, long seed)
	{
		super(world, seed, false);
	}
	
	@Override
	public void generate(int x, int y, Block[] blocks)
	{
		this.noiseField1 = this.initializeNoiseField(this.noiseField1, x * (byte) 2, 0, y * (byte) 2, (byte) 2 + 1, (byte) 33, (byte) 2 + 1);
		
		for (int i1 = 0; i1 < (byte) 2; i1++)
		{
			for (int j1 = 0; j1 < (byte) 2; j1++)
			{
				for (int k1 = 0; k1 < 32; k1++)
				{
					double d = 0.25D;
					
					double d1 = this.noiseField1[(((i1 + 0) * ((byte) 2 + 1) + j1 + 0) * (byte) 33 + k1 + 0)];
					double d2 = this.noiseField1[(((i1 + 0) * ((byte) 2 + 1) + j1 + 1) * (byte) 33 + k1 + 0)];
					double d3 = this.noiseField1[(((i1 + 1) * ((byte) 2 + 1) + j1 + 0) * (byte) 33 + k1 + 0)];
					double d4 = this.noiseField1[(((i1 + 1) * ((byte) 2 + 1) + j1 + 1) * (byte) 33 + k1 + 0)];
					double d5 = (this.noiseField1[(((i1 + 0) * ((byte) 2 + 1) + j1 + 0) * (byte) 33 + k1 + 1)] - d1) * d;
					double d6 = (this.noiseField1[(((i1 + 0) * ((byte) 2 + 1) + j1 + 1) * (byte) 33 + k1 + 1)] - d2) * d;
					double d7 = (this.noiseField1[(((i1 + 1) * ((byte) 2 + 1) + j1 + 0) * (byte) 33 + k1 + 1)] - d3) * d;
					double d8 = (this.noiseField1[(((i1 + 1) * ((byte) 2 + 1) + j1 + 1) * (byte) 33 + k1 + 1)] - d4) * d;
					
					for (int l1 = 0; l1 < 4; l1++)
					{
						double d9 = 0.125D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						for (int i2 = 0; i2 < 8; i2++)
						{
							int j2 = i2 + i1 * 8 << 11 | 0 + j1 * 8 << 7 | k1 * 4 + l1;
							
							double d14 = 0.125D;
							double d15 = d10;
							double d16 = (d11 - d10) * d14;
							for (int k2 = 0; k2 < 8; k2++)
							{
								if (d15 > 0.0D)
								{
									blocks[j2] = Heaven.heavenStoneBlocks;
								}
								j2 += 128;
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
	
	public double[] initializeNoiseField(double[] ad, int i, int j, int k, int l, int i1, int j1)
	{
		if (ad == null)
		{
			ad = new double[l * i1 * j1];
		}
		double d = 684.41200000000003D;
		double d1 = 684.41200000000003D;
		
		this.noiseField8 = this.noiseGen1.generateNoiseOctaves(this.noiseField8, i, k, l, j1, 1.121D, 1.121D, 0.5D);
		this.noiseField9 = this.noiseGen4.generateNoiseOctaves(this.noiseField9, i, k, l, j1, 200.0D, 200.0D, 0.5D);
		
		d *= 2.0D;
		this.noiseField5 = this.noiseGen3.generateNoiseOctaves(this.noiseField5, i, j, k, l, i1, j1, d / 80.0D, d1 / 160.0D, d / 80.0D);
		this.noiseField6 = this.noiseGen1.generateNoiseOctaves(this.noiseField6, i, j, k, l, i1, j1, d, d1, d);
		this.noiseField7 = this.noiseGen2.generateNoiseOctaves(this.noiseField7, i, j, k, l, i1, j1, d, d1, d);
		
		int k1 = 0;
		int l1 = 0;
		int i2 = 16 / l;
		for (int j2 = 0; j2 < l; j2++)
		{
			int k2 = j2 * i2 + i2 / 2;
			for (int l2 = 0; l2 < j1; l2++)
			{
				int i3 = l2 * i2 + i2 / 2;
				
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
				d6 = d6 * i1 / 16.0D;
				l1++;
				double d7 = i1 / 2.0D;
				for (int j3 = 0; j3 < i1; j3++)
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
					if (j3 > i1 - k3)
					{
						double d13 = (j3 - (i1 - k3)) / (k3 - 1.0F);
						d8 = d8 * (1.0D - d13) + -30.0D * d13;
					}
					k3 = 8;
					if (j3 < k3)
					{
						double d14 = (k3 - j3) / (k3 - 1.0F);
						d8 = d8 * (1.0D - d14) + -30.0D * d14;
					}
					ad[k1] = d8;
					k1++;
				}
			}
		}
		return ad;
	}
}