package clashsoft.mods.moredimensions.world.providers.chunk;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ChunkProviderHeaven extends AbstractChunkProvider
{
	public ChunkProviderHeaven(World par1World, long par2, boolean par4)
	{
		super(par1World, par2, par4);
	}
	
	public void generateTerrain(int i, int j, byte abyte0[])
	{
		byte byte0 = 2;
		int k = byte0 + 1;
		int l = 128 / 4 + 1;
		int i1 = byte0 + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, i * 4 - 2, j * 4 - 2, k + 5, l + 5);
		this.noiseArray = initializeNoiseField(noiseArray, i * byte0, 0, j * byte0, k, l, i1);
		
		label0:
		for (int j1 = 0; j1 < byte0; j1++)
		{
			int k1 = 0;
			
			do
			{
				label1:
				{
					if (k1 >= byte0)
					{
						continue label0;
					}
					
					int l1 = 0;
					
					do
					{						
						if (l1 >= 128 / 4)
						{
							break label1;
						}
						
						double d = 0.25D;
						double d1 = noiseArray[((j1 + 0) * i1 + (k1 + 0)) * l + (l1 + 0)];
						double d2 = noiseArray[((j1 + 0) * i1 + (k1 + 1)) * l + (l1 + 0)];
						double d3 = noiseArray[((j1 + 1) * i1 + (k1 + 0)) * l + (l1 + 0)];
						double d4 = noiseArray[((j1 + 1) * i1 + (k1 + 1)) * l + (l1 + 0)];
						double d5 = (noiseArray[((j1 + 0) * i1 + (k1 + 0)) * l + (l1 + 1)] - d1) * d;
						double d6 = (noiseArray[((j1 + 0) * i1 + (k1 + 1)) * l + (l1 + 1)] - d2) * d;
						double d7 = (noiseArray[((j1 + 1) * i1 + (k1 + 0)) * l + (l1 + 1)] - d3) * d;
						double d8 = (noiseArray[((j1 + 1) * i1 + (k1 + 1)) * l + (l1 + 1)] - d4) * d;
						
						for (int i2 = 0; i2 < 4; i2++)
						{
							double d9 = 0.125D;
							double d10 = d1;
							double d11 = d2;
							double d12 = (d3 - d1) * d9;
							double d13 = (d4 - d2) * d9;
							
							for (int j2 = 0; j2 < 8; j2++)
							{
								int k2 = j2 + j1 * 8 << 11 | 0 + k1 * 8 << 7 | l1 * 4 + i2;
								int l2 = 1 << 7;
								double d14 = 0.125D;
								double d15 = d10;
								double d16 = (d11 - d10) * d14;
								
								for (int i3 = 0; i3 < 8; i3++)
								{
									int j3 = 0;
									
									if (d15 > 0.0D)
									{
										j3 = MDMBlocks.stoneBlocks.blockID;
									}
									
									abyte0[k2] = (byte) j3;
									k2 += l2;
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
						
						l1++;
					}
					while (true);
				}
				k1++;
			}
			while (true);
		}
	}
	
	public void replaceBlocksForBiome(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[])
	{
		double d = 0.03125D;
		stoneNoise = noiseGen4.generateNoiseOctaves(stoneNoise, i * 16, j * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);
		
		for (int k = 0; k < 16; k++)
		{
			for (int l = 0; l < 16; l++)
			{
				BiomeGenBase biomegenbase = abiomegenbase[k + l * 16];
				int i1 = (int) (stoneNoise[k + l * 16] / 3D + 3D + rand.nextDouble() * 0.25D);
				int j1 = -1;
				byte byte0 = biomegenbase.topBlock;
				byte byte1 = biomegenbase.fillerBlock;
				worldObj.getClass();
				
				byte stone = (byte) MDMBlocks.stoneBlocks.blockID;
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
					byte byte2 = abyte0[l1];
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
							{
								abyte0[l1] = byte0;
							}
							else
							{
								abyte0[l1] = byte1;
							}
							
						}
						else if (j1 > 0)
						{
							j1--;
							abyte0[l1] = byte1;
						}
					}
				}
			}
		}
	}
}