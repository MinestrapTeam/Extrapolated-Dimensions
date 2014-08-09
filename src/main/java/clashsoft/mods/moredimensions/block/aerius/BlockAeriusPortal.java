package clashsoft.mods.moredimensions.block.aerius;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import clashsoft.mods.moredimensions.lib.Aerius;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.teleporters.AeriusTeleporter;

import net.minecraft.block.Block;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class BlockAeriusPortal extends BlockCustomPortal
{
	public BlockAeriusPortal(String name, String iconName)
	{
		super(name, iconName, MDMWorld.AERIUS_ID);
	}

	@Override
	public Block getFrameBlock()
	{
		return Aerius.portalFrame;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new AeriusTeleporter(world);
	}
}
