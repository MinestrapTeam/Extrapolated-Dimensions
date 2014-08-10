package clashsoft.mods.moredimensions.block.poc;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import clashsoft.mods.moredimensions.lib.WorldManager;
import clashsoft.mods.moredimensions.lib.ParadiseOfChaos;
import clashsoft.mods.moredimensions.world.teleporters.TeleporterPOC;

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
