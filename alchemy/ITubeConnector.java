package clashsoft.mods.moredimensions.alchemy;

import net.minecraft.world.IBlockAccess;

public interface ITubeConnector
{
	public boolean canTubeConnectOnSide(IBlockAccess par1World, int x, int y, int z, int side);
}
