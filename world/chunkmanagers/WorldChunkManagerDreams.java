package clashsoft.mods.moredimensions.world.chunkmanagers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;
import clashsoft.mods.moredimensions.world.gen.layer.GenLayerDreams;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkManagerDreams extends WorldChunkManager
{
	private DreamType					dreamType;
	
	private final GenLayer				genBiomes;
	private final GenLayer				biomeIndexLayer;
	private final BiomeCache			biomeCache;
	private final List<BiomeGenBase>	biomesToSpawnIn;
	
	public WorldChunkManagerDreams(DreamType dream)
	{
		this(dream, 123456789L, WorldType.DEFAULT);
	}
	
	public WorldChunkManagerDreams(DreamType dream, long seed, WorldType worldtype)
	{
		this.dreamType = dream;
		
		this.biomeCache = new BiomeCache(this);
		this.biomesToSpawnIn = new ArrayList<BiomeGenBase>();
		this.biomesToSpawnIn.add(this.dreamType != null ? this.dreamType.getDreamBiome() : BiomeGenBase.plains);
		
		GenLayer[] agenlayer = GenLayerDreams.createWorld(this.dreamType, seed, worldtype);
		this.genBiomes = agenlayer[0];
		this.biomeIndexLayer = agenlayer[1];
		
	}
	
	public WorldChunkManagerDreams(World world)
	{
		this(DreamType.plains, world.getSeed(), world.provider.terrainType);
	}
	
	/**
	 * Gets the list of valid biomes for the player to spawn in.
	 */
	@Override
	public List<BiomeGenBase> getBiomesToSpawnIn()
	{
		return this.biomesToSpawnIn;
	}
	
	/**
	 * Returns the BiomeGenBase related to the x, z position on the world.
	 */
	@Override
	public BiomeGenBase getBiomeGenAt(int x, int z)
	{
		return this.dreamType.getDreamBiome();
	}
	
	/**
	 * Returns a list of rainfall values for the specified blocks. Args: listToReuse, x, z, width, length.
	 */
	@Override
	public float[] getRainfall(float[] array, int x, int z, int width, int length)
	{
		IntCache.resetIntCache();
		
		if (array == null || array.length < width * length)
		{
			array = new float[width * length];
		}
		
		int[] aint = this.biomeIndexLayer.getInts(x, z, width, length);
		
		for (int i1 = 0; i1 < width * length; ++i1)
		{
			float f = BiomeGenBase.biomeList[aint[i1]].getIntRainfall() / 65536.0F;
			
			if (f > 1.0F)
			{
				f = 1.0F;
			}
			
			array[i1] = f;
		}
		
		return array;
	}
	
	/**
	 * Return an adjusted version of a given temperature based on the y height
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public float getTemperatureAtHeight(float scalar, int y)
	{
		return scalar;
	}
	
	/**
	 * Returns a list of temperatures to use for the specified blocks. Args: listToReuse, x, y, width, length
	 */
	@Override
	public float[] getTemperatures(float[] array, int x, int z, int width, int length)
	{
		IntCache.resetIntCache();
		
		if (array == null || array.length < width * length)
		{
			array = new float[width * length];
		}
		
		int[] aint = this.biomeIndexLayer.getInts(x, z, width, length);
		
		for (int i1 = 0; i1 < width * length; ++i1)
		{
			float f = BiomeGenBase.biomeList[aint[i1]].getIntTemperature() / 65536.0F;
			
			if (f > 1.0F)
			{
				f = 1.0F;
			}
			
			array[i1] = f;
		}
		
		return array;
	}
	
	/**
	 * Returns an array of biomes for the location input.
	 */
	@Override
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int x, int z, int width, int length)
	{
		IntCache.resetIntCache();
		
		if (biomes == null || biomes.length < width * length)
		{
			biomes = new BiomeGenBase[width * length];
		}
		
		int[] aint = this.genBiomes.getInts(x, z, width, length);
		
		for (int i = 0; i < width * length; ++i)
		{
			if (aint[i] >= 0)
			{
				biomes[i] = BiomeGenBase.biomeList[aint[i]];
			}
			else
			{
				biomes[i] = this.dreamType.getDreamBiome();
			}
		}
		
		return biomes;
	}
	
	/**
	 * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the WorldChunkManager Args: oldBiomeList, x, z, width, depth
	 */
	@Override
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomes, int x, int z, int width, int length)
	{
		return this.getBiomeGenAt(biomes, x, z, width, length, true);
	}
	
	/**
	 * Return a list of biomes for the specified blocks. Args: listToReuse, x, y, width, length, cacheFlag (if false, don't check biomeCache to avoid infinite loop in BiomeCacheBlock)
	 */
	@Override
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomes, int x, int y, int width, int length, boolean cacheFlag)
	{
		IntCache.resetIntCache();
		
		if (biomes == null || biomes.length < width * length)
		{
			biomes = new BiomeGenBase[width * length];
		}
		
		if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (y & 15) == 0)
		{
			BiomeGenBase[] abiomegenbase1 = this.biomeCache.getCachedBiomes(x, y);
			System.arraycopy(abiomegenbase1, 0, biomes, 0, width * length);
			return biomes;
		}
		else
		{
			int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);
			
			for (int i = 0; i < width * length; ++i)
			{
				if (aint[i] >= 0)
				{
					biomes[i] = BiomeGenBase.biomeList[aint[i]];
				}
				else
				{
					biomes[i] = this.dreamType.getDreamBiome();
				}
			}
			
			return biomes;
		}
	}
	
	/**
	 * checks given Chunk's Biomes against List of allowed ones
	 */
	@Override
	public boolean areBiomesViable(int x, int z, int off, List list)
	{
		IntCache.resetIntCache();
		int l = x - off >> 2;
		int i1 = z - off >> 2;
		int j1 = x + off >> 2;
		int k1 = z + off >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
		
		for (int j2 = 0; j2 < l1 * i2; ++j2)
		{
			BiomeGenBase biomegenbase = BiomeGenBase.biomeList[aint[j2]];
			
			if (!list.contains(biomegenbase))
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Finds a valid position within a range, that is in one of the listed biomes. Searches {x,y} +- range blocks. Strongly favors positive y positions.
	 */
	@Override
	public ChunkPosition findBiomePosition(int x, int z, int range, List list, Random random)
	{
		IntCache.resetIntCache();
		int l = x - range >> 2;
		int i1 = z - range >> 2;
		int j1 = x + range >> 2;
		int k1 = z + range >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
		ChunkPosition chunkposition = null;
		int j2 = 0;
		
		for (int k2 = 0; k2 < l1 * i2; ++k2)
		{
			int l2 = l + k2 % l1 << 2;
			int i3 = i1 + k2 / l1 << 2;
			BiomeGenBase biomegenbase = BiomeGenBase.biomeList[aint[k2]];
			
			if (list.contains(biomegenbase) && (chunkposition == null || random.nextInt(j2 + 1) == 0))
			{
				chunkposition = new ChunkPosition(l2, 0, i3);
				++j2;
			}
		}
		
		return chunkposition;
	}
	
	/**
	 * Calls the WorldChunkManager's biomeCache.cleanupCache()
	 */
	@Override
	public void cleanupCache()
	{
		this.biomeCache.cleanupCache();
	}
}