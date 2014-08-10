package minestrapteam.extradims.block.poc;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import minestrapteam.extradims.lib.ParadiseOfChaos;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.teleporters.TeleporterPOC;

import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class BlockPOCPortal extends BlockCustomPortal
{
	public BlockPOCPortal(String name, String iconName)
	{
		super(name, iconName, WorldManager.POC_ID);
		this.frameBlock = ParadiseOfChaos.portalFrame;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new TeleporterPOC(world);
	}
}
