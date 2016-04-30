package minestrapteam.extradims.biome.poc;

import java.util.Random;

import minestrapteam.extracore.world.biome.CustomBiome;
import minestrapteam.extracore.world.gen.CustomBigTreeGen;
import minestrapteam.extradims.lib.ParadiseOfChaos;
import minestrapteam.extradims.world.poc.gen.POCGenMagicOakTree;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomePOCPlains extends CustomBiome
{
	public BiomePOCPlains(int biomeID)
	{
		super(biomeID);
		this.setHeight(new Height(0.3F, 0.2F));
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		
		this.topBlock = ParadiseOfChaos.grassBlocks;
		this.fillerBlock = ParadiseOfChaos.dirtBlocks;
		this.stoneBlock = ParadiseOfChaos.stoneBlocks;
		
		this.waterColorMultiplier = 0xFFFFFF;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return random.nextBoolean() ? new POCGenMagicOakTree(true) : new CustomBigTreeGen(true, 5, Blocks.log, Blocks.leaves);
	}
}
