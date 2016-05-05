package minestrapteam.extradims.item.aerius;

import minestrapteam.extracore.item.CustomItem;
import minestrapteam.extradims.lib.aerius.ABlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAeriusSeeds extends CustomItem
{
	public ItemAeriusSeeds(String[] names, String[] iconNames)
	{
		super(names, iconNames, null);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return false;
		}
		
		Block block = world.getBlock(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		Block newBlock = null;
		int newMetadata = 0;
		
		switch (stack.getItemDamage())
		{
			case 0: // Aerian Grass Seeds
				if (block == ABlocks.dirtBlocks && metadata == 0)
				{
					newBlock = ABlocks.grassBlocks;
					newMetadata = 0;
				}
				break;
			case 1: // Mud Grass Seeds
				if (block == ABlocks.dirtBlocks && metadata == 1)
				{
					newBlock = ABlocks.grassBlocks;
					newMetadata = 1;
				}
				break;
			case 2: // Corrupted Grass Seeds
				if (block == Blocks.dirt)
				{
					newBlock = ABlocks.grassBlocks;
					newMetadata = 2;
				}
				break;
			case 3: // Hallowed Grass Seeds
				if (block == Blocks.dirt)
				{
					newBlock = ABlocks.grassBlocks;
					newMetadata = 3;
				}
				break;
			case 4: // Mushroom Grass Seeds
				if (block == ABlocks.dirtBlocks && metadata == 1)
				{
					newBlock = ABlocks.grassBlocks;
					newMetadata = 4;
				}
		}
		
		if (newBlock != null)
		{
			world.setBlock(x, y, z, newBlock, newMetadata, 3);
			stack.stackSize--;
			return true;
		}
		return false;
	}
}
