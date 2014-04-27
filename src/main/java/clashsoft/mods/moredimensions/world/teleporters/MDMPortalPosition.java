package clashsoft.mods.moredimensions.world.teleporters;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;

public class MDMPortalPosition extends ChunkCoordinates
{
	/** The worldtime at which this PortalPosition was last verified */
	public long			lastUpdateTime;
	
	/** The teleporter to which this PortalPosition applies */
	final Teleporter	teleporterInstance;
	
	public MDMPortalPosition(Teleporter teleporter, int x, int y, int z, long lastUpdateTime)
	{
		super(x, y, z);
		this.teleporterInstance = teleporter;
		this.lastUpdateTime = lastUpdateTime;
	}
}
