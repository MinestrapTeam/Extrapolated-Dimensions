package clashsoft.mods.moredimensions.world;

import java.util.List;
import java.util.Random;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.addons.MDMHeaven;
import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.biome.BiomeGenHeaven;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;

public class ChunkProviderHeaven implements IChunkProvider
{	
	/** RNG. */
	private Random						rand;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves		noiseGen1;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves		noiseGen2;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves		noiseGen3;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves		noiseGen4;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves		noiseGen5;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves		noiseGen6;
	public NoiseGeneratorOctaves		mobSpawnerNoise;
	
	/** Reference to the World object. */
	private World						worldObj;
	
	/** are map structures going to be generated (e.g. strongholds) */
	private boolean						mapFeaturesEnabled;
	
	/** Holds the overall noise array used in chunk generation */
	private double[]					noiseArray;
	private double[]					stoneNoise					= new double[256];
	private MapGenBase					caveGenerator				= new MapGenCaves();
	
	/** Holds Stronghold Generator */
	private MapGenStronghold			strongholdGenerator			= new MapGenStronghold();
	
	/** Holds Village Generator */
	private MapGenVillage				villageGenerator			= new MapGenVillage();
	
	/** Holds Mineshaft Generator */
	private MapGenMineshaft				mineshaftGenerator			= new MapGenMineshaft();
	private MapGenScatteredFeature		scatteredFeatureGenerator	= new MapGenScatteredFeature();
	
	/** Holds ravine generator */
	private MapGenBase					ravineGenerator				= new MapGenRavine();
	
	/** The biomes that are used to generate the chunk */
	private BiomeGenBase[]				biomesForGeneration;
	
	/** A double array that hold terrain noise from noiseGen3 */
	double[]							noise3;
	
	/** A double array that hold terrain noise */
	double[]							noise1;
	
	/** A double array that hold terrain noise from noiseGen2 */
	double[]							noise2;
	
	/** A double array that hold terrain noise from noiseGen5 */
	double[]							noise5;
	
	/** A double array that holds terrain noise from noiseGen6 */
	double[]							noise6;
	
	/**
	 * Used to store the 5x5 parabolic field that is used during terrain
	 * generation.
	 */
	float[]								parabolicField;
	int[][]								field_73219_j				= new int[32][32];
	
	public ChunkProviderHeaven(World par1World, long par2, boolean par4)
	{
		this.worldObj = par1World;
		this.mapFeaturesEnabled = par4;
		this.rand = new Random(par2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
	}
	
	public void generateTerrain(int i, int j, byte abyte0[])
	{
		byte byte0 = 2;
		int k = byte0 + 1;
		worldObj.getClass();
		int l = 128 / 4 + 1;
		int i1 = byte0 + 1;
		noiseArray = initializeNoiseField(noiseArray, i * byte0, 0, j * byte0, k, l, i1);
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
						worldObj.getClass();
						
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
								worldObj.getClass();
								worldObj.getClass();
								int k2 = j2 + j1 * 8 << 11 | 0 + k1 * 8 << 7 | l1 * 4 + i2;
								worldObj.getClass();
								int l2 = 1 << 7;
								double d14 = 0.125D;
								double d15 = d10;
								double d16 = (d11 - d10) * d14;
								
								for (int i3 = 0; i3 < 8; i3++)
								{
									int j3 = 0;
									
									if (d15 > 0.0D)
									{
										j3 = MDMHeaven.stoneBlocks.blockID;
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
		MoreDimensionsMod.generateHeaven(worldObj, rand, i, j);
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
				
				byte stone = (byte) MDMHeaven.stoneBlocks.blockID;
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
	
	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}
	
	@Override
	public void recreateStructures(int par1, int par2)
	{
		if (this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.villageGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.strongholdGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
		}
	}
	
	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}
	
	@Override
	public Chunk loadChunk(int par1, int par2)
	{
		return provideChunk(par1, par2);
	}
	
	@Override
	public Chunk provideChunk(int par1, int par2)
	{
		this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
		byte[] var3 = new byte[32768];
		generateTerrain(par1, par2, var3);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		replaceBlocksForBiome(par1, par2, var3, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, par1, par2, var3);
		this.ravineGenerator.generate(this, this.worldObj, par1, par2, var3);
		if (this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generate(this, this.worldObj, par1, par2, var3);
			this.villageGenerator.generate(this, this.worldObj, par1, par2, var3);
			this.strongholdGenerator.generate(this, this.worldObj, par1, par2, var3);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, par1, par2, var3);
		}
		Chunk var4 = new Chunk(this.worldObj, var3, par1, par2);
		byte[] var5 = var4.getBiomeArray();
		for (int var6 = 0; var6 < var5.length; var6++)
		{
			var5[var6] = ((byte) this.biomesForGeneration[var6].biomeID);
		}
		var4.generateSkylightMap();
		return var4;
	}
	
	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7)
	{
		if (par1ArrayOfDouble == null)
		{
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}
		if (this.parabolicField == null)
		{
			this.parabolicField = new float[25];
			for (int var8 = -2; var8 <= 2; var8++)
			{
				for (int var9 = -2; var9 <= 2; var9++)
				{
					float var10 = 10.0F / MathHelper.sqrt_float(var8 * var8 + var9 * var9 + 0.2F);
					this.parabolicField[(var8 + 2 + (var9 + 2) * 5)] = var10;
				}
			}
		}
		double var44 = 684.41200000000003D;
		double var45 = 684.41200000000003D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		boolean var43 = false;
		boolean var42 = false;
		int var12 = 0;
		int var13 = 0;
		for (int var14 = 0; var14 < par5; var14++)
		{
			for (int var15 = 0; var15 < par7; var15++)
			{
				float var16 = 0.0F;
				float var17 = 0.0F;
				float var18 = 0.0F;
				byte var19 = 2;
				BiomeGenBase var20 = new BiomeGenHeaven(MDMWorld.HEAVEN_BIOME_ID);
				for (int var21 = -var19; var21 <= var19; var21++)
				{
					for (int var22 = -var19; var22 <= var19; var22++)
					{
						BiomeGenBase var23 = var20;
						float var24 = this.parabolicField[(var21 + 2 + (var22 + 2) * 5)] / (var23.minHeight + 2.0F);
						if (var23.minHeight > var20.minHeight)
						{
							var24 /= 2.0F;
						}
						var16 += var23.maxHeight * var24;
						var17 += var23.minHeight * var24;
						var18 += var24;
					}
				}
				var16 /= var18;
				var17 /= var18;
				var16 = var16 * 0.9F + 0.1F;
				var17 = (var17 * 4.0F - 1.0F) / 8.0F;
				double var47 = this.noise6[var13] / 8000.0D;
				if (var47 < 0.0D)
				{
					var47 = -var47 * 0.3D;
				}
				var47 = var47 * 3.0D - 2.0D;
				if (var47 < 0.0D)
				{
					var47 /= 2.0D;
					if (var47 < -1.0D)
					{
						var47 = -1.0D;
					}
					var47 /= 1.4D;
					var47 /= 2.0D;
				}
				else
				{
					if (var47 > 1.0D)
					{
						var47 = 1.0D;
					}
					var47 /= 8.0D;
				}
				var13++;
				for (int var46 = 0; var46 < par6; var46++)
				{
					double var48 = var17;
					double var26 = var16;
					var48 += var47 * 0.2D;
					var48 = var48 * par6 / 16.0D;
					double var28 = par6 / 2.0D + var48 * 4.0D;
					double var30 = 0.0D;
					double var32 = (var46 - var28) * 12.0D * 128.0D / 128.0D / var26;
					if (var32 < 0.0D)
					{
						var32 *= 4.0D;
					}
					double var34 = this.noise1[var12] / 512.0D;
					double var36 = this.noise2[var12] / 512.0D;
					double var38 = (this.noise3[var12] / 10.0D + 1.0D) / 2.0D;
					if (var38 < 0.0D)
					{
						var30 = var34;
					}
					else if (var38 > 1.0D)
					{
						var30 = var36;
					}
					else
					{
						var30 = var34 + (var36 - var34) * var38;
					}
					var30 -= var32;
					if (var46 > par6 - 4)
					{
						double var40 = (var46 - (par6 - 4)) / 3.0F;
						var30 = var30 * (1.0D - var40) + -10.0D * var40;
					}
					par1ArrayOfDouble[var12] = var30;
					var12++;
				}
			}
		}
		return par1ArrayOfDouble;
	}
	
	@Override
	public boolean chunkExists(int par1, int par2)
	{
		return true;
	}
	
	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
	{
		net.minecraft.block.BlockSand.fallInstantly = true;
		int var4 = par2 * 16;
		int var5 = par3 * 16;
		BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(par2 * var7 + par3 * var9 ^ this.worldObj.getSeed());
		boolean var11 = false;
		if (this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
			var11 = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
			this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
			this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
		}
		if ((!var11) && (this.rand.nextInt(4) == 0))
		{
			int var12 = var4 + this.rand.nextInt(16) + 8;
			int var13 = this.rand.nextInt(128);
			int var14 = var5 + this.rand.nextInt(16) + 8;
			new WorldGenLakes(Block.waterStill.blockID).generate(this.worldObj, this.rand, var12, var13, var14);
		}
		var6.decorate(this.worldObj, this.rand, var4, var5);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
		var4 += 8;
		var5 += 8;
		for (int var12 = 0; var12 < 16; var12++)
		{
			for (int var13 = 0; var13 < 16; var13++)
			{
				int var14 = this.worldObj.getPrecipitationHeight(var4 + var12, var5 + var13);
				if (this.worldObj.isBlockFreezable(var12 + var4, var14 - 1, var13 + var5))
				{
					this.worldObj.setBlock(var12 + var4, var14 - 1, var13 + var5, Block.ice.blockID);
				}
				if (this.worldObj.canSnowAt(var12 + var4, var14, var13 + var5))
				{
					this.worldObj.setBlock(var12 + var4, var14, var13 + var5, Block.snow.blockID);
				}
			}
		}
		net.minecraft.block.BlockSand.fallInstantly = false;
	}
	
	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
	{
		return true;
	}
	
	public boolean unload100OldestChunks()
	{
		return false;
	}
	
	@Override
	public boolean canSave()
	{
		return true;
	}
	
	@Override
	public String makeString()
	{
		return "RandomLevelSource";
	}
	
	@Override
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
	{
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(par2, par4);
		return var5 == null ? null : var5.getSpawnableList(par1EnumCreatureType);
	}
	
	@Override
	public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5)
	{
		return ("Stronghold".equals(par2Str)) && (this.strongholdGenerator != null) ? this.strongholdGenerator.getNearestInstance(par1World, par3, par4, par5) : null;
	}
	
	@Override
	public void saveExtraData()
	{
	}
}