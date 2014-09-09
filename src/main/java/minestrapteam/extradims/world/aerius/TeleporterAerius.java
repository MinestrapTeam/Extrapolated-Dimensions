package minestrapteam.extradims.world.aerius;

import clashsoft.cslib.minecraft.world.CustomTeleporter;
import minestrapteam.extradims.lib.Aerius;

import net.minecraft.init.Blocks;
import net.minecraft.world.WorldServer;

public class TeleporterAerius extends CustomTeleporter
{
	public TeleporterAerius(WorldServer world)
	{
		super(world);
		this.portalBlock = Aerius.portal;
		this.frameBlock = Blocks.glowstone;
	}
}
