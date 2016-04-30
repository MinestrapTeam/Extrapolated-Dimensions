package minestrapteam.extradims.world.poc;

import minestrapteam.extracore.world.CustomTeleporter;
import minestrapteam.extradims.lib.ParadiseOfChaos;

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
