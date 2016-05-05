package minestrapteam.extradims.block.aerius;

import minestrapteam.extracore.block.BlockCustomPlant;
import minestrapteam.extradims.lib.Aerius;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockAeriusPlants extends BlockCustomPlant
{
	public BlockAeriusPlants(String[] names)
	{
		super(names, getIconNames(names));
	}

	private static String[] getIconNames(String[] names)
	{
		final String[] res = new String[names.length];
		for (int i = 0; i < names.length; i++)
		{
			res[i] = Aerius.TEXTURE_PREFIX + "plants/" + names[i];
		}
		return res;
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return (random.nextInt(20) == 0 && metadata < 10) ? Aerius.seedItems : null;
	}

	@Override
	public int damageDropped(int metadata)
	{
		return metadata < 10 ? metadata % 5 : 0;
	}

	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
	{
		return true;
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
