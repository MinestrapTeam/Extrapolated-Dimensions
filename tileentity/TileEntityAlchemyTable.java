package clashsoft.mods.moredimensions.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;
import clashsoft.mods.moredimensions.alchemy.EnumHeatType;

public class TileEntityAlchemyTable extends TileEntityInventory
{
	public EnumHeatType[]	heatTypes		= { EnumHeatType.NONE, EnumHeatType.NONE, EnumHeatType.NONE };
	
	public int				maxProgressTime	= 200;
	public int				progressTime	= 0;
	
	public int[]			itemEnergyTime = {0, 0, 0};
	public int[]			energyTime = {0, 0, 0};
	
	public TileEntityAlchemyTable()
	{
		super(13);
	}
	
	public EnumHeatType getHeatType(int slot)
	{
		return this.heatTypes[slot];
	}
	
	public int getProgressScaled(int scalar)
	{
		return this.progressTime * scalar / this.maxProgressTime;
	}
	
	public int getEnergyTimeRemainingScaled(int scalar, int slot)
	{
		if (this.itemEnergyTime[slot] == 0)
		{
			this.itemEnergyTime[slot] = 200;
		}
		
		return this.energyTime[slot] * scalar / this.itemEnergyTime[slot];
	}
}
