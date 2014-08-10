package minestrapteam.extradims.magic;

import minestrapteam.extradims.magic.spells.Spell;

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
			System.arraycopy(staffTypes, 0, tmp, 0, staffTypes.length);
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
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Spell getSpell()
	{
		return this.spell;
	}
	
	public int getMaxDamage()
	{
		return this.maxDamage;
	}
	
	public int getCharges()
	{
		return this.charges;
	}
	
	public boolean isChargeable()
	{
		return this.charges > 0;
	}
	
	public String getTextureName(int charge)
	{
		if (this.isChargeable())
			return String.format("mdm_poc:staff_%d_%d", this.id, charge + 1);
		return "mdm_main:staff_" + this.id;
	}
}
