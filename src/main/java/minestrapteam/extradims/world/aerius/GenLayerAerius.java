package minestrapteam.extradims.world.aerius;

import minestrapteam.extracore.world.CustomBiomeLayer;
import minestrapteam.extradims.lib.aerius.Aerius;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerAerius extends CustomBiomeLayer
{
	public GenLayerAerius(long seed)
	{
		super(seed);
	}

	@Override
	public BiomeGenBase[] getBiomes()
	{
		return Aerius.aeriusBiomes;
	}

	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 5;
	}
}
