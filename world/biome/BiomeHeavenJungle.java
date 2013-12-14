package clashsoft.mods.moredimensions.world.biome;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.world.gen.heaven.HeavenGenJungleTree;

import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeHeavenJungle extends BiomeHeaven
{
	
	public BiomeHeavenJungle(int i)
	{
		super(i);
		this.theBiomeDecorator.treesPerChunk = 12;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return new HeavenGenJungleTree(true, 7, MDMBlocks.heavenLogs.blockID, MDMBlocks.heavenLeaves.blockID);
	}
}
