package minestrapteam.extradims.block.virtious;

import minestrapteam.extracore.block.BlockCustomLamp;

public class BlockCytoidLamp extends BlockCustomLamp
{
	public BlockCytoidLamp(boolean active)
	{
		super(new String[] { null }, "virtious:cytoid_lamp_" + (active ? "on" : "off"), active);
		
		if (active)
		{
			this.setLightLevel(0.8F);
		}
	}
}
