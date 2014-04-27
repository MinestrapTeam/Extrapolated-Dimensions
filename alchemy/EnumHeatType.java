package clashsoft.mods.moredimensions.alchemy;

import clashsoft.cslib.minecraft.lang.I18n;

public enum EnumHeatType
{
	NONE(-1, "none"), FIRE(0, "fire"), ENERGY(1, "energy"), GREEN_ENERGY(2, "energy.green"), HEPHAESTUS(3, "hephaestus"), WHITE(4, "white"), GRAY(5, "gray"), DARK(6, "dark");
	
	public int		id;
	public String	name;
	
	private EnumHeatType(int id, String name)
	{
		this.name = name;
		this.id = id;
	}
	
	public String getUnlocalizedName()
	{
		return "heat." + this.name;
	}
	
	public String getLocalizedName()
	{
		return I18n.getString(this.getUnlocalizedName());
	}
}
