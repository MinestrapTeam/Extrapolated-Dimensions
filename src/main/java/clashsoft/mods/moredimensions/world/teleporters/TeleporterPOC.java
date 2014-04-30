package clashsoft.mods.moredimensions.world.teleporters;

import clashsoft.mods.moredimensions.addons.ParadiseOfChaos;

import net.minecraft.block.Block;
import net.minecraft.world.WorldServer;

public class TeleporterPOC extends AbstractTeleporter
{
	public TeleporterPOC(WorldServer world)
	{
		super(world);
	}

	@Override
	public Block getPortalBlock()
	{
		return ParadiseOfChaos.pocPortal;
	}

	@Override
	public Block getFrameBlock()
	{
		return ParadiseOfChaos.pocStoneBlocks;
	}
}