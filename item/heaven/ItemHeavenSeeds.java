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
				blockMetadata1 = MDMBlocks.heavenGrass.getItemDamage();
			}
		case 1: //Mud Grass Seeds
			if (blockID == MDMBlocks.heavenDirtBlocks.blockID && blockMetadata == 1)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = MDMBlocks.mudGrass.getItemDamage();
			}
		case 2: //Corrupted Grass Seeds
			if (blockID == Block.dirt.blockID)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = MDMBlocks.corruptedGrass.getItemDamage();
			}
		case 3: //Hallowed Grass Seeds
			if (blockID == Block.dirt.blockID)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = MDMBlocks.hallowedGrass.getItemDamage();
			}
		case 4: //Mushroom Grass Seeds
			if (blockID == MDMBlocks.heavenDirtBlocks.blockID && blockMetadata == 1)
			{
				blockID1 = MDMBlocks.heavenGrassBlocks.blockID;
				blockMetadata1 = MDMBlocks.mushroomGrass.getItemDamage();
			}
		}
		
		if (blockID1 != 0)
		{
			world.setBlock(x, y, z, blockID1, blockMetadata1, 3);
			return true;
		}
		return false;
	}
}
