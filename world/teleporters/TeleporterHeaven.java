package clashsoft.mods.moredimensions.world.teleporters;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.WorldServer;

public class TeleporterHeaven extends AbstractTeleporter
{
	public TeleporterHeaven(WorldServer world)
	{
		super(world);
	}

	@Override
	public Block getPortalBlock()
	{
		return MDMBlocks.heavenPortal;
	}

	@Override
	public Block getFrameBlock()
	{
		return MDMBlocks.heavenStoneBlocks;
	}
}
