package clashsoft.mods.moredimensions.world.teleporters;

import clashsoft.cslib.minecraft.world.CustomTeleporter;
import clashsoft.mods.moredimensions.lib.Heaven;

import net.minecraft.world.WorldServer;

public class TeleporterHeaven extends CustomTeleporter
{
	public TeleporterHeaven(WorldServer world)
	{
		super(world);
		this.portalBlock = Heaven.portal;
		this.frameBlock = Heaven.portalFrame;
	}
}
