package clashsoft.mods.moredimensions.world.teleporters;

import clashsoft.cslib.minecraft.world.CustomTeleporter;
import clashsoft.mods.moredimensions.lib.ParadiseOfChaos;

import net.minecraft.world.WorldServer;

public class TeleporterPOC extends CustomTeleporter
{
	public TeleporterPOC(WorldServer world)
	{
		super(world);
		this.portalBlock = ParadiseOfChaos.portal;
		this.frameBlock = ParadiseOfChaos.portalFrame;
	}
}