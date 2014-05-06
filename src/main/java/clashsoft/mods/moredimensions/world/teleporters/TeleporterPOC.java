package clashsoft.mods.moredimensions.world.teleporters;

import clashsoft.cslib.minecraft.world.CustomTeleporter;
import clashsoft.mods.moredimensions.addons.ParadiseOfChaos;

import net.minecraft.block.Block;
import net.minecraft.world.WorldServer;

public class TeleporterPOC extends CustomTeleporter
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