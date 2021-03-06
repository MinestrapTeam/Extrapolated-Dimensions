package minestrapteam.extradims.world.virtious;

import minestrapteam.extracore.world.CustomBiomeLayer;
import minestrapteam.extradims.lib.virtious.Virtious;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerVirtious extends CustomBiomeLayer
{
	public GenLayerVirtious(long seed)
	{
		super(seed);
	}

	@Override
	public BiomeGenBase[] getBiomes()
	{
		return Virtious.virtiousBiomes;
	}

	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 5;
	}
}
