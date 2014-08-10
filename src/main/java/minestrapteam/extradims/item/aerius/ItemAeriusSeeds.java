package minestrapteam.extradims.item.aerius;

import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.cslib.util.CSArrays;
import minestrapteam.extradims.lib.Aerius;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAeriusSeeds extends CustomItem
{
	public ItemAeriusSeeds(String[] names, String[] iconNames)
	{
		super(names, iconNames, CSArrays.create(Aerius.tabAeriusItems));
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
			return false;
		
		Block block = world.getBlock(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		Block newBlock = null;
		int newMetadata = 0;
		
		switch (stack.getItemDamage())
		{
			case 0: // Heaven Grass Seeds
				if (block == Aerius.dirtBlocks && metadata == 0)
				{
					newBlock = Aerius.grassBlocks;
					newMetadata = 0;
				}
			case 1: // Mud Grass Seeds
				if (block == Aerius.dirtBlocks && metadata == 1)
				{
					newBlock = Aerius.grassBlocks;
					newMetadata = 1;
				}
			case 2: // Corrupted Grass Seeds
				if (block == Blocks.dirt)
				{
					newBlock = Aerius.grassBlocks;
					newMetadata = 2;
				}
			case 3: // Hallowed Grass Seeds
				if (block == Blocks.dirt)
				{
					newBlock = Aerius.grassBlocks;
					newMetadata = 3;
				}
			case 4: // Mushroom Grass Seeds
				if (block == Aerius.dirtBlocks && metadata == 1)
				{
					newBlock = Aerius.grassBlocks;
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
