package minestrapteam.extradims.world.aerius;

import minestrapteam.extracore.world.CustomTeleporter;
import minestrapteam.extradims.lib.aerius.ABlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.WorldServer;

public class TeleporterAerius extends CustomTeleporter
{
	public TeleporterAerius(WorldServer world)
	{
		super(world);
		this.portalBlock = ABlocks.portal;
		this.frameBlock = Blocks.glowstone;
	}
}
