package clashsoft.mods.moredimensions.world.providers.chunk;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkProviderHeaven extends AbstractChunkProvider
{
	public NoiseGeneratorOctaves	noiseGenerator1;
	public NoiseGeneratorOctaves	noiseGenerator2;
	public NoiseGeneratorOctaves	noiseGenerator3;
	public NoiseGeneratorOctaves	noiseGenerator4;
	public NoiseGeneratorOctaves	noiseGenerator5;
	public NoiseGeneratorOctaves	noiseGenerator6;
	public NoiseGeneratorOctaves	noiseGenerator7;
	public NoiseGeneratorOctaves	noiseGenerator8;
	
	public double[]					noiseArray1;
	public double[]					noiseArray2;
	public double[]					noiseArray3;
	public double[]					noiseArray4;
	
	public double[]					noiseArray5;
	public double[]					noiseArray6;
	public double[]					noiseArray7;
	public double[]					noiseArray8;
	public double[]					noiseArray9;
	
	public byte						topBlock;
	public byte						fillerBlock;
	
	public ChunkProviderHeaven(World world, long seed)
	{
		super(world, seed, false);
		
		this.noiseArray2 = new double[256];
		this.noiseArray3 = new double[256];
		this.noiseArray4 = new double[256];
		
		this.noiseGenerator1 = new NoiseGeneratorOctaves(this.random, 16);
		this.noiseGenerator2 = new NoiseGeneratorOctaves(this.random, 16);
		this.noiseGenerator3 = new NoiseGeneratorOctaves(this.random, 8);
		this.noiseGenerator4 = new NoiseGeneratorOctaves(this.random, 4);
		this.noiseGenerator5 = new NoiseGeneratorOctaves(this.random, 4);
		this.noiseGenerator6 = new NoiseGeneratorOctaves(this.random, 10);
		this.noiseGenerator7 = new NoiseGeneratorOctaves(this.random, 16);
		this.noiseGenerator8 = new NoiseGeneratorOctaves(this.random, 8);
	}
	
	public void generateTerrain(int x, int y, byte[] storage)
	{
		byte byte0 = 2;
		int k = byte0 + 1;
		byte byte1 = 33;
		int l = byte0 + 1;
		
		this.noiseArray1 = initializeNoiseField(this.noiseArray1, x * byte0, 0, y * byte0, k, byte1, l);
		
		for (int i1 = 0; i1 < byte0; i1++)
			for (int j1 = 0; j1 < byte0; j1++)
				for (int k1 = 0; k1 < 32; k1++)
				{
					double d = 0.25D;
					
					double d1 = this.noiseArray1[(((i1 + 0) * l + j1 + 0) * byte1 + k1 + 0)];
					double d2 = this.noiseArray1[(((i1 + 0) * l + j1 + 1) * byte1 + k1 + 0)];
					double d3 = this.noiseArray1[(((i1 + 1) * l + j1 + 0) * byte1 + k1 + 0)];
					double d4 = this.noiseArray1[(((i1 + 1) * l + j1 + 1) * byte1 + k1 + 0)];
					double d5 = (this.noiseArray1[(((i1 + 0) * l + j1 + 0) * byte1 + k1 + 1)] - d1) * d;
					double d6 = (this.noiseArray1[(((i1 + 0) * l + j1 + 1) * byte1 + k1 + 1)] - d2) * d;
					double d7 = (this.noiseArray1[(((i1 + 1) * l + j1 + 0) * byte1 + k1 + 1)] - d3) * d;
					double d8 = (this.noiseArray1[(((i1 + 1) * l + j1 + 1) * byte1 + k1 + 1)] - d4) * d;
					
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
							
							char c = '';
							double d14 = 0.125D;
							double d15 = d10;
							double d16 = (d11 - d10) * d14;
							for (int k2 = 0; k2 < 8; k2++)
							{
								int l2 = 0;
								if (d15 > 0.0D)
								{
									l2 = MDMBlocks.heavenStoneBlocks.blockID;
								}
								storage[j2] = ((byte) l2);
								j2 += c;
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
	
	public void replaceBlocksForBiome(int x, int z, byte[] storage, BiomeGenBase[] biomes)
	{
		double d = 0.03125D;
		
		this.noiseArray2 = this.noiseGenerator4.generateNoiseOctaves(this.noiseArray2, x * 16, z * 16, 0, 16, 16, 1, d, d, 1.0D);
		this.noiseArray3 = this.noiseGenerator4.generateNoiseOctaves(this.noiseArray3, x * 16, 109, z * 16, 16, 1, 16, d, 1.0D, d);
		this.noiseArray4 = this.noiseGenerator5.generateNoiseOctaves(this.noiseArray4, x * 16, z * 16, 0, 16, 16, 1, d * 2.0D, d * 2.0D, d * 2.0D);
		
		for (int k = 0; k < 16; k++)
			for (int l = 0; l < 16; l++)
			{
				int i1 = (int) (this.noiseArray4[(k + l * 16)] / 3.0D + 3.0D + this.random.nextDouble() * 0.25D);
				BiomeGenBase biome = biomes[k + l * 16];
				
				int j1 = -1;
				this.topBlock = ((byte) MDMBlocks.heavenGrassBlocks.blockID);
				this.fillerBlock = ((byte) MDMBlocks.heavenDirtBlocks.blockID);
				byte byte0 = this.topBlock;
				byte byte1 = this.fillerBlock;
				byte stone = (byte) MDMBlocks.heavenStoneBlocks.blockID;
				if (byte0 < 0)
				{
					byte0 = (byte) (byte0 + 0);
				}
				if (byte1 < 0)
				{
					byte1 = (byte) (byte1 + 0);
				}
				if (stone < 0)
				{
					stone = (byte) (stone + 0);
				}
				for (int k1 = 127; k1 >= 0; k1--)
				{
					int l1 = (l * 16 + k) * 128 + k1;
					byte byte2 = storage[l1];
					if (byte2 == 0)
					{
						j1 = -1;
					}
					else if (byte2 == stone)
					{
						if (j1 == -1)
						{
							if (i1 <= 0)
							{
								byte0 = 0;
								byte1 = stone;
							}
							j1 = i1;
							if (k1 >= 0)
								storage[l1] = byte0;
							else
							{
								storage[l1] = byte1;
							}
							
						}
						else if (j1 > 0)
						{
							j1--;
							storage[l1] = byte1;
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
		
		this.noiseArray8 = this.noiseGenerator6.generateNoiseOctaves(this.noiseArray8, i, k, l, j1, 1.121D, 1.121D, 0.5D);
		this.noiseArray9 = this.noiseGenerator7.generateNoiseOctaves(this.noiseArray9, i, k, l, j1, 200.0D, 200.0D, 0.5D);
		
		d *= 2.0D;
		this.noiseArray5 = this.noiseGenerator3.generateNoiseOctaves(this.noiseArray5, i, j, k, l, i1, j1, d / 80.0D, d1 / 160.0D, d / 80.0D);
		this.noiseArray6 = this.noiseGenerator1.generateNoiseOctaves(this.noiseArray6, i, j, k, l, i1, j1, d, d1, d);
		this.noiseArray7 = this.noiseGenerator2.generateNoiseOctaves(this.noiseArray7, i, j, k, l, i1, j1, d, d1, d);
		
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
				double d5 = (this.noiseArray8[l1] + 256.0D) / 512.0D;
				d5 *= d4;
				if (d5 > 1.0D)
				{
					d5 = 1.0D;
				}
				double d6 = this.noiseArray9[l1] / 8000.0D;
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
					double d10 = this.noiseArray6[k1] / 512.0D;
					double d11 = this.noiseArray7[k1] / 512.0D;
					double d12 = (this.noiseArray5[k1] / 10.0D + 1.0D) / 2.0D;
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
	
	@Override
	public Chunk loadChunk(int x, int z)
	{
		return provideChunk(x, z);
	}
	
	@Override
	public String makeString()
	{
		return "RandomLevelSource";
	}
}