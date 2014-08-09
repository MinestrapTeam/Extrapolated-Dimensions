package clashsoft.mods.moredimensions.world.teleporters;

import clashsoft.cslib.minecraft.world.CustomTeleporter;
import clashsoft.mods.moredimensions.lib.Aerius;

import net.minecraft.world.WorldServer;

public class AeriusTeleporter extends CustomTeleporter
{
	public AeriusTeleporter(WorldServer world)
	{
		super(world);
		this.portalBlock = Aerius.portal;
		this.frameBlock = Aerius.portalFrame;
	}
}
