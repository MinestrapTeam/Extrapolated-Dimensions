package clashsoft.mods.moredimensions.magic;

import clashsoft.mods.moredimensions.magic.spell.Spell;

public class StaffType
{
	public static StaffType[]	staffTypes	= new StaffType[16];
	
	public static StaffType		explosive	= new StaffType(1, "Explosive Staff", Spell.EstuansInterius, 128, 0);
	
	private final int			id;
	private final String		name;
	private final Spell			spell;
	private final int			maxDamage;
	private final int			charges;
	
	public StaffType(int id, String name, Spell spell, int maxDamage, int charges)
	{
		if (id >= staffTypes.length)
		{
			StaffType[] tmp = new StaffType[id + 1];
			for (int x = 0; x < staffTypes.length; x++)
			{
				tmp[x] = staffTypes[x];
			}
			staffTypes = tmp;
		}
		
		this.id = id;
		this.name = name;
		this.spell = spell;
		this.maxDamage = maxDamage;
		this.charges = charges;
		staffTypes[id] = this;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Spell getSpell()
	{
		return spell;
	}
	
	public int getMaxDamage()
	{
		return maxDamage;
	}
	
	public int getCharges()
	{
		return charges;
	}
	
	public boolean isChargeable()
	{
		return charges > 0;
	}
	
	public String getTextureName(int charge)
	{
		return "staff_" + (this.id) + (isChargeable() ? "_" + (charge + 1) : "");
	}
}
