package clashsoft.mods.moredimensions.block.aerius;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.teleporters.AeriusTeleporter;

import net.minecraft.init.Blocks;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class BlockAeriusPortal extends BlockCustomPortal
{
	public BlockAeriusPortal(String name, String iconName)
	{
		super(name, iconName, MDMWorld.AERIUS_ID);
		this.frameBlock = Blocks.glowstone;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new AeriusTeleporter(world);
	}
}
