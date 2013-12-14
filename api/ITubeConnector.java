package clashsoft.mods.moredimensions.api;

import net.minecraft.world.IBlockAccess;

public interface ITubeConnector
{
	boolean canTubeConnectOnSide(IBlockAccess par1World, int x, int y, int z, int side);
}
