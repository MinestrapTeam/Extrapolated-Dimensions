package clashsoft.mods.moredimensions.block.heaven;

import net.minecraft.block.Block;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import clashsoft.cslib.minecraft.block.BlockCustomPortal;
import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.addons.MDMWorld;

public class BlockHeavenPortal extends BlockCustomPortal
{
	public BlockHeavenPortal(String name, String iconName)
	{
		super(name, iconName, MDMWorld.HEAVEN_ID);
	}

	@Override
	public Block getFrameBlock()
	{
		return MDMBlocks.heavenStoneBlocks;
	}
	
	@Override
	public int getFrameMetadata()
	{
		return 1;
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return null;
	}
}
