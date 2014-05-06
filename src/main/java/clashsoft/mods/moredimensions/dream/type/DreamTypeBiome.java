package clashsoft.mods.moredimensions.dream.type;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class DreamTypeBiome extends DreamType
{
	private BiomeGenBase	biome;
	
	public DreamTypeBiome(String name, boolean nightmare, BiomeGenBase biome)
	{
		super(name, nightmare);
		this.biome = biome;
	}
	
	@Override
	public BiomeGenBase getDreamBiome()
	{
		return this.biome;
	}
	
	@Override
	public void generateWorld(World world, int chunkX, int chunkY, Random random)
	{
	}
}
