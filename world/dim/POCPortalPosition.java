package com.chaosdev.paradiseofchaos.world.dim;

import net.minecraft.util.ChunkCoordinates;

public class POCPortalPosition extends ChunkCoordinates
{
	/** The worldtime at which this PortalPosition was last verified */
	public long			lastUpdateTime;
	
	/** The teleporter to which this PortalPosition applies */
	final TeleporterPOC	teleporterInstance;
	
	public POCPortalPosition(TeleporterPOC par1Teleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.teleporterInstance = par1Teleporter;
		this.lastUpdateTime = par5;
	}
}
