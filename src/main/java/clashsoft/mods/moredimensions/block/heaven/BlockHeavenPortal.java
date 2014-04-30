package clashsoft.mods.moredimensions.block.heaven;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import clashsoft.mods.moredimensions.addons.Heaven;
import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.teleporters.TeleporterHeaven;

import net.minecraft.block.Block;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class BlockHeavenPortal extends BlockCustomPortal
{
	public BlockHeavenPortal(String name, String iconName)
	{
		super(name, iconName, MDMWorld.HEAVEN_ID);
	}

	@Override
	public Block getFrameBlock()
	{
		return Heaven.heavenStoneBlocks;
	}
	
	@Override
	public int getFrameMetadata()
	{
		return 1;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new TeleporterHeaven(world);
	}
}
