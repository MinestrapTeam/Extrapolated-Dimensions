package clashsoft.mods.moredimensions.item.heaven;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import clashsoft.cslib.minecraft.CustomItem;
import clashsoft.cslib.util.CSArrays;
import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.addons.MDMItems;

public class ItemHeavenSeeds extends CustomItem
{
	public ItemHeavenSeeds(int itemID, String[] displayNames, String[] iconNames)
	{
		super(itemID, displayNames, iconNames, CSArrays.create(MDMItems.tabHeavenItems));
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
			return false;
		
		int blockID = world.getBlockId(x, y, z);
		int blockMetadata = world.getBlockMetadata(x, y, z);
		int blockID1 = 0;
		int blockMetadata1 = 0;
		
		switch (stack.getItemDamage())
		{
		case 0: // Heaven Grass Seeds
			if (blockID == MDMBlocks.heavenDirtBlocks.blockID && blockMetadata == 0)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = 0;
			}
		case 1: //Mud Grass Seeds
			if (blockID == MDMBlocks.heavenDirtBlocks.blockID && blockMetadata == 1)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = 1;
			}
		case 2: //Corrupted Grass Seeds
			if (blockID == Block.dirt.blockID)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = 2;
			}
		case 3: //Hallowed Grass Seeds
			if (blockID == Block.dirt.blockID)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = 3;
			}
		case 4: //Mushroom Grass Seeds
			if (blockID == MDMBlocks.heavenDirtBlocks.blockID && blockMetadata == 1)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = 4;
			}
		}
		
		if (blockID1 != 0)
		{
			world.setBlock(x, y, z, blockID1, blockMetadata1, 3);
			stack.stackSize--;
			return true;
		}
		return false;
	}
}
