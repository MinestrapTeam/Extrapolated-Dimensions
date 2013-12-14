package clashsoft.mods.moredimensions.block.heaven;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomPlant;
import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.block.Block;

public class BlockHeavenPlant extends BlockCustomPlant
{
	public Random	rand	= new Random();
	
	public BlockHeavenPlant(int blockID, String[] names, String[] icons)
	{
		super(blockID, names, icons);
	}
	
	@Override
	public int idDropped(int metadata, Random random, int fortune)
	{
		return (random.nextInt(20) == 0 && metadata < 10) ? MDMItems.heavenSeeds.itemID : 0;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata < 10 ? metadata % 5 : 0;
	}
	
	@Override
	public boolean isValidGround(int metadata, int blockID, int blockMetadata)
	{
		boolean heavenDirtID = blockID == MDMBlocks.heavenDirtBlocks.blockID;
		boolean heavenGrassID = blockID == MDMBlocks.heavenGrassBlocks.blockID;
		boolean vanillaDirtID = blockID == Block.dirt.blockID;
		boolean vanillaGrassID = blockID == Block.grass.blockID;
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
