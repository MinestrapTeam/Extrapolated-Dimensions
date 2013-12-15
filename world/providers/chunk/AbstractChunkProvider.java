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
	public final World				worldObj;
	public final boolean			mapFeaturesEnabled;
	
	public final Random				random;
	
	public NoiseGeneratorOctaves	noiseGen1;
	public NoiseGeneratorOctaves	noiseGen2;
	public NoiseGeneratorOctaves	noiseGen3;
	public NoiseGeneratorOctaves	noiseGen4;
	public NoiseGeneratorOctaves	noiseGen5;
	public NoiseGeneratorOctaves	noiseGen6;
	public NoiseGeneratorOctaves	mobSpawnerNoise;
	
	public double[]					noiseArray;
	public double[]					stoneNoise					= new double[256];
	
	public MapGenBase				caveGenerator				= new MapGenCaves();
	public MapGenStronghold			strongholdGenerator			= new MapGenStronghold();
	public MapGenVillage			villageGenerator			= new MapGenVillage();
	public MapGenMineshaft			mineshaftGenerator			= new MapGenMineshaft();
	public MapGenScatteredFeature	scatteredFeatureGenerator	= new MapGenScatteredFeature();
	public MapGenBase				ravineGenerator				= new MapGenRavine();
	
	public BiomeGenBase[]			biomesForGeneration;
	public double[]					noise1;
	public double[]					noise2;
	public double[]					noise3;
	public double[]					noise5;
	public double[]					noise6;
	public float[]					parabolicField;
	
	public AbstractChunkProvider(World world, long seed, boolean mapFeatures)
	{
		this.worldObj = world;
		this.mapFeaturesEnabled = mapFeatures;
		
		this.random = new Random(seed);
		
		this.noiseGen1 = new NoiseGeneratorOctaves(this.random, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.random, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.random, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.random, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.random, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.random, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.random, 8);
	}
	
	public abstract void generateTerrain(int x, int z, byte[] storage);
	
	public abstract void replaceBlocksForBiome(int x, int z, byte[] storage, BiomeGenBase[] biomes);
	
	@Override
	public Chunk loadChunk(int x, int z)
	{
		return this.provideChunk(x, z);
	}
	
	@Override
	public Chunk provideChunk(int x, int z)
	{
		this.random.setSeed(x * this.worldObj.getSeed() | z * this.worldObj.getSeed() ^ x - z);
		
		byte[] storage = new byte[32768];
		this.generateTerrain(x, z, storage);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		this.replaceBlocksForBiome(x, z, storage, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, x, z, storage);
		this.ravineGenerator.generate(this, this.worldObj, x, z, storage);
		if (this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generate(this, this.worldObj, x, z, storage);
			this.villageGenerator.generate(this, this.worldObj, x, z, storage);
			this.strongholdGenerator.generate(this, this.worldObj, x, z, storage);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, x, z, storage);
		}
		Chunk chunk = new Chunk(this.worldObj, storage, x, z);
		byte[] biomes = chunk.getBiomeArray();
		for (int var6 = 0; var6 < biomes.length; var6++)
		{
			biomes[var6] = ((byte) this.biomesForGeneration[var6].biomeID);
		}
		chunk.generateSkylightMap();
		return chunk;
	}
	
	public double[] initializeNoiseField(double[] noiseField, int x, int y, int z, int width, int length, int height)
	{
		if (noiseField == null)
		{
			noiseField = new double[width * length * height];
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
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, x, z, width, height, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, x, z, width, height, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, x, y, z, width, length, height, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, x, y, z, width, length, height, var44, var45, var44);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, x, y, z, width, length, height, var44, var45, var44);
		boolean var43 = false;
		boolean var42 = false;
		int var12 = 0;
		int var13 = 0;
		for (int var14 = 0; var14 < width; var14++)
		{
			for (int var15 = 0; var15 < height; var15++)
			{
				float var16 = 0.0F;
				float var17 = 0.0F;
				float var18 = 0.0F;
				byte var19 = 2;
				BiomeGenBase var20 = this.biomesForGeneration[(var14 + 2 + (var15 + 2) * (width + 5))];
				for (int var21 = -var19; var21 <= var19; var21++)
				{
					for (int var22 = -var19; var22 <= var19; var22++)
					{
						BiomeGenBase var23 = this.biomesForGeneration[(var14 + var21 + 2 + (var15 + var22 + 2) * (width + 5))];
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
				for (int var46 = 0; var46 < length; var46++)
				{
					double var48 = var17;
					double var26 = var16;
					var48 += var47 * 0.2D;
					var48 = var48 * length / 16.0D;
					double var28 = length / 2.0D + var48 * 4.0D;
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
					if (var46 > length - 4)
					{
						double var40 = (var46 - (length - 4)) / 3.0F;
						var30 = var30 * (1.0D - var40) + -10.0D * var40;
					}
					noiseField[var12] = var30;
					var12++;
				}
			}
		}
		return noiseField;
	}
	
	@Override
	public boolean chunkExists(int x, int z)
	{
		return true;
	}
	
	@Override
	public void populate(IChunkProvider chunkProvider, int x, int z)
	{
		BlockSand.fallInstantly = true;
		int var4 = x * 16;
		int var5 = z * 16;
		BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.random.setSeed(this.worldObj.getSeed());
		long var7 = this.random.nextLong() / 2L * 2L + 1L;
		long var9 = this.random.nextLong() / 2L * 2L + 1L;
		this.random.setSeed(x * var7 + z * var9 ^ this.worldObj.getSeed());
		boolean var11 = false;
		
		if (this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.random, x, z);
			var11 = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.random, x, z);
			this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.random, x, z);
			this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.random, x, z);
		}
		if ((!var11) && (this.random.nextInt(4) == 0))
		{
			int var12 = var4 + this.random.nextInt(16) + 8;
			int var13 = this.random.nextInt(256);
			int var14 = var5 + this.random.nextInt(16) + 8;
			new WorldGenLakes(Block.waterStill.blockID).generate(this.worldObj, this.random, var12, var13, var14);
		}
		
		try
		{
			var6.decorate(this.worldObj, this.random, var4, var5);
		}
		catch (Exception ex)
		{
		}
		
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.random);
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
		BlockSand.fallInstantly = false;
	}
	
	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate progressUpdate)
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
	public List getPossibleCreatures(EnumCreatureType creaturetype, int x, int y, int z)
	{
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(x, z);
		return var5 == null ? null : var5.getSpawnableList(creaturetype);
	}
	
	@Override
	public ChunkPosition findClosestStructure(World world, String string, int x, int y, int z)
	{
		return ("Stronghold".equals(string)) && (this.strongholdGenerator != null) ? this.strongholdGenerator.getNearestInstance(world, x, y, z) : null;
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
	public void recreateStructures(int x, int y)
	{
	}
	
	@Override
	public void saveExtraData()
	{
	}
}