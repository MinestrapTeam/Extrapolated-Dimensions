package clashsoft.mods.moredimensions.block.aerius;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomPlant;
import clashsoft.mods.moredimensions.lib.Aerius;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockAeriusPlant extends BlockCustomPlant
{
	public Random	rand	= new Random();
	
	public BlockAeriusPlant(String[] names, String[] icons)
	{
		super(names, icons);
	}
	
	public BlockAeriusPlant(String[] names, String domain)
	{
		super(names, domain);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return (random.nextInt(20) == 0 && metadata < 10) ? Aerius.heavenSeeds : null;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata < 10 ? metadata % 5 : 0;
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		boolean heavenDirtID = block == Aerius.dirtBlocks;
		boolean heavenGrassID = block == Aerius.grassBlocks;
		boolean vanillaDirtID = block == Blocks.dirt;
		boolean vanillaGrassID = block == Blocks.grass;
		switch (metadata)
		{
			case 0: // Heaven Grass
			case 5: // Heaven Vine
				return (heavenDirtID && blockMetadata == 0) || (heavenGrassID && blockMetadata == 0);
			case 1: // Mud Grass
			case 6: // Mud Vine
				return (heavenDirtID && blockMetadata == 1) || (heavenGrassID && blockMetadata == 1);
			case 2: // Corrupted Grass
			case 7: // Corrupted Vine
				return vanillaDirtID || (heavenGrassID && blockMetadata == 2);
			case 3: // Hallowed Grass
			case 8: // Hallowed Vine
				return vanillaDirtID || (heavenGrassID && blockMetadata == 3);
			case 4: // Mushroom Grass
			case 9: // Mushroom Vine
				return (heavenDirtID && blockMetadata == 1) || (heavenGrassID && blockMetadata == 4);
			case 10: // Grass Vine
				return vanillaDirtID || vanillaGrassID;
		}
		
		return false;
	}
}
