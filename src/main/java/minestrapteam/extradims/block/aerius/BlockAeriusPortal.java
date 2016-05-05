package minestrapteam.extradims.block.aerius;

import minestrapteam.extracore.block.BlockCustomPortal;
import minestrapteam.extradims.lib.aerius.Aerius;
import minestrapteam.extradims.world.aerius.TeleporterAerius;
import net.minecraft.init.Blocks;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockAeriusPortal extends BlockCustomPortal
{
	public BlockAeriusPortal(String iconName)
	{
		super(iconName, Aerius.AERIUS_ID);
		this.frameBlock = Blocks.glowstone;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new TeleporterAerius(world);
	}

	@Override
	public void spawnParticle(World world, double x, double y, double z, double vX, double vY, double vZ)
	{
	}
}
