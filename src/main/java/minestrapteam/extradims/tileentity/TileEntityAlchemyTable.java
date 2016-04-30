package minestrapteam.extradims.tileentity;

import minestrapteam.extradims.alchemy.EnumHeatType;
import minestrapteam.extracore.tileentity.TileEntityInventory;

public class TileEntityAlchemyTable extends TileEntityInventory
{
	public EnumHeatType[]	heatTypes		= {
			EnumHeatType.NONE,
			EnumHeatType.NONE,
			EnumHeatType.NONE				};
	
	public int				maxProgressTime	= 200;
	public int				progressTime	= 0;
	
	public int[]			itemEnergyTime	= { 0, 0, 0 };
	public int[]			energyTime		= { 0, 0, 0 };
	
	public TileEntityAlchemyTable()
	{
		super(13);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 13;
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
