package clashsoft.mods.moredimensions.api;

import net.minecraft.world.IBlockAccess;

public interface ITubeConnector
{
	boolean canTubeConnectOnSide(IBlockAccess world, int x, int y, int z, int side);
}
