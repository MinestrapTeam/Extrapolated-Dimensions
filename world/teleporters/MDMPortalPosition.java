package clashsoft.mods.moredimensions.world.teleporters;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;

public class MDMPortalPosition extends ChunkCoordinates
{
	/** The worldtime at which this PortalPosition was last verified */
	public long			lastUpdateTime;
	
	/** The teleporter to which this PortalPosition applies */
	final Teleporter	teleporterInstance;
	
	public MDMPortalPosition(Teleporter par1Teleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.teleporterInstance = par1Teleporter;
		this.lastUpdateTime = par5;
	}
}
