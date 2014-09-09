package minestrapteam.extradims.block.aerius;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.teleporters.AeriusTeleporter;

import net.minecraft.init.Blocks;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockAeriusPortal extends BlockCustomPortal
{
	public BlockAeriusPortal(String iconName)
	{
		super(iconName, WorldManager.AERIUS_ID);
		this.frameBlock = Blocks.glowstone;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new AeriusTeleporter(world);
	}

	@Override
	public void spawnParticle(World world, double x, double y, double z, double vX, double vY, double vZ)
	{
	}
}
