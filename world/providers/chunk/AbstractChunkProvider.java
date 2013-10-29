package clashsoft.mods.moredimensions.world.providers.chunk;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
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

public abstract class AbstractChunkProvider implements IChunkProvider
{	
	public final Random					rand;
	public final NoiseGeneratorOctaves	noiseGen1;
	public final NoiseGeneratorOctaves	noiseGen2;
	public final NoiseGeneratorOctaves	noiseGen3;
	public final NoiseGeneratorOctaves	noiseGen4;
	public NoiseGeneratorOctaves		noiseGen5;
	public NoiseGeneratorOctaves		noiseGen6;
	public NoiseGeneratorOctaves		mobSpawnerNoise;
	public final World					worldObj;
	public final boolean				mapFeaturesEnabled;
	public double[]						noiseArray;
	public double[]						stoneNoise					= new double[256];
	public final MapGenBase				caveGenerator				= new MapGenCaves();
	public final MapGenStronghold		strongholdGenerator			= new MapGenStronghold();
	public final MapGenVillage			villageGenerator			= new MapGenVillage();
	public final MapGenMineshaft		mineshaftGenerator			= new MapGenMineshaft();
	public final MapGenScatteredFeature	scatteredFeatureGenerator	= new MapGenScatteredFeature();
	public final MapGenBase				ravineGenerator				= new MapGenRavine();
	public BiomeGenBase[]				biomesForGeneration;
	public double[]						noise3;
	public double[]						noise1;
	public double[]						noise2;
	public double[]						noise5;
	public double[]						noise6;
	public float[]						parabolicField;
	public int[][]						field_73219_j				= new int[32][32];
	
	public AbstractChunkProvider(World par1World, long par2, boolean par4)
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
	
	public abstract void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte);
	
	public abstract void replaceBlocksForBiome(int par1, int par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase);
	
	@Override
	public Chunk loadChunk(int par1, int par2)
	{
		return provideChunk(par1, par2);
	}
	
	@Override
	public Chunk provideChunk(int par1, int par2)
	{
		this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
		// For some reason this is only 16x16x128.
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
	
	public double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7)
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
				BiomeGenBase var20 = this.biomesForGeneration[(var14 + 2 + (var15 + 2) * (par5 + 5))];
				for (int var21 = -var19; var21 <= var19; var21++)
				{
					for (int var22 = -var19; var22 <= var19; var22++)
					{
						BiomeGenBase var23 = this.biomesForGeneration[(var14 + var21 + 2 + (var15 + var22 + 2) * (par5 + 5))];
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
		BlockSand.fallInstantly = true;
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
			int var13 = this.rand.nextInt(256);
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
		//postPopulate(par1IChunkProvider, par2, par3);
		BlockSand.fallInstantly = false;
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
	public int getLoadedChunkCount()
	{
		return 0;
	}
	
	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}
	
	@Override
	public void recreateStructures(int i, int j)
	{
	}
	
	@Override
	public void saveExtraData()
	{
	}
}