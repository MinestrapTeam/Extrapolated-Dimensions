package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomPlant;
import clashsoft.mods.moredimensions.addons.Heaven;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockHeavenPlant extends BlockCustomPlant
{
	public Random	rand	= new Random();
	
	public BlockHeavenPlant(String[] names, String[] icons)
	{
		super(names, icons);
	}
	
	public BlockHeavenPlant(String[] names, String domain)
	{
		super(names, domain);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return (random.nextInt(20) == 0 && metadata < 10) ? Heaven.heavenSeeds : null;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata < 10 ? metadata % 5 : 0;
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		boolean heavenDirtID = block == Heaven.dirtBlocks;
		boolean heavenGrassID = block == Heaven.grassBlocks;
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
