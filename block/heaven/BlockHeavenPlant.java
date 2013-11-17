package clashsoft.mods.moredimensions.block.heaven;

import net.minecraft.block.Block;

import clashsoft.clashsoftapi.block.BlockCustomPlant;
import clashsoft.mods.moredimensions.addons.MDMBlocks;

public class BlockHeavenPlant extends BlockCustomPlant
{
	public BlockHeavenPlant(int blockID, String[] names, String[] icons)
	{
		super(blockID, names, icons);
	}
	
	@Override
	public boolean isValidGround(int metadata, int blockID, int blockMetadata)
	{
		boolean heavenDirtID = blockID == MDMBlocks.heavenGrassBlocks.blockID || blockID == MDMBlocks.heavenDirtBlocks.blockID;
		boolean vanillaDirtID = blockID == Block.grass.blockID || blockID == Block.dirt.blockID;
		
		/*
		 * switch (metadata) { case 0: //Heaven Grass case 5: //Heaven Vine
		 * return heavenDirtID && blockMetadata == 0; case 1: //Mud Grass case
		 * 6: //Mud Vine return heavenDirtID && blockMetadata == 1; case 2:
		 * //Corrupted Grass case 7: //Corrupted Vine case 3: //Hallowed Grass
		 * case 8: //Hallowed Vine return vanillaDirtID; case 4: //Mushroom
		 * Grass case 9: //Mushroom Vine return heavenDirtID && blockMetadata ==
		 * 1; case 10: //Grass Vine return vanillaDirtID; }
		 */
		return heavenDirtID || vanillaDirtID;
	}
}
