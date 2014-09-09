package minestrapteam.virtious.common;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import minestrapteam.virtious.lib.VBlocks;
import minestrapteam.virtious.lib.VItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class VEventHandler
{
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		ItemStack result = null;
		int x = event.target.blockX;
		int y = event.target.blockY;
		int z = event.target.blockZ;
		Block block = event.world.getBlock(x, y, z);
		int metadata = event.world.getBlockMetadata(x, y, z);
		
		if (block == VBlocks.virtious_acid && metadata == 0)
		{
			result = new ItemStack(VItems.acid_bucket);
		}
		
		if (result != null)
		{
			event.world.setBlockToAir(x, y, z);
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}
}
