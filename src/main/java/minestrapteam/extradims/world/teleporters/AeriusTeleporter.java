package minestrapteam.extradims.world.teleporters;

import clashsoft.cslib.minecraft.world.CustomTeleporter;
import minestrapteam.extradims.lib.Aerius;

import net.minecraft.init.Blocks;
import net.minecraft.world.WorldServer;

public class AeriusTeleporter extends CustomTeleporter
{
	public AeriusTeleporter(WorldServer world)
	{
		super(world);
		this.portalBlock = Aerius.portal;
		this.frameBlock = Blocks.glowstone;
	}
}
