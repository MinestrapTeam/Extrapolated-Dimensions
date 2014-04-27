package clashsoft.mods.moredimensions.block.poc;

import net.minecraft.block.Block;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.teleporters.TeleporterPOC;

public class BlockPOCPortal extends BlockCustomPortal
{
	public BlockPOCPortal(String name, String iconName)
	{
		super(name, iconName, MDMWorld.POC_ID);
	}
	
	@Override
	public Block getFrameBlock()
	{
		return MDMBlocks.pocStoneBlocks;
	}
	
	@Override
	public int getFrameMetadata()
	{
		return 1;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new TeleporterPOC(world);
	}
}
