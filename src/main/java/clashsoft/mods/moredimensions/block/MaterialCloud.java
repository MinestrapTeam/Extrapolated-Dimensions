package clashsoft.mods.moredimensions.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialCloud extends Material
{
	public MaterialCloud()
	{
		super(MapColor.grayColor);
	}
	
	@Override
	public boolean blocksMovement()
	{
		return false;
	}
	
	@Override
	public boolean isOpaque()
	{
		return false;
	}
	
	@Override
	public boolean isReplaceable()
	{
		return false;
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}
}
