package minestrapteam.extradims.magic;

import java.util.ArrayList;
import java.util.List;

import minestrapteam.extradims.magic.spells.Spell;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class StaffData
{
	private List<Spell>	spells;
	private StaffType	staffType;
	private boolean		rare;
	private int			damage;
	private String		foundAt;
	
	public StaffData(List<Spell> spells, StaffType staffType, boolean rare, int damage, String foundat)
	{
		this.spells = spells;
		this.staffType = staffType;
		this.rare = rare;
		this.damage = damage;
		this.foundAt = foundat;
	}
	
	public List<Spell> getSpells()
	{
		return this.spells;
	}
	
	public StaffType getStaffType()
	{
		return this.staffType;
	}
	
	public boolean isRare()
	{
		return this.rare;
	}
	
	public int getDamage()
	{
		return this.damage;
	}
	
	public String getFoundAt()
	{
		return this.foundAt;
	}
	
	public StaffData setSpells(List<Spell> spells)
	{
		this.spells = spells;
		return this;
	}
	
	public StaffData setStaffType(StaffType staffType)
	{
		this.staffType = staffType;
		return this;
	}
	
	public StaffData setRare(boolean rare)
	{
		this.rare = rare;
		return this;
	}
	
	public StaffData setDamage(int damage)
	{
		this.damage = damage;
		return this;
	}
	
	public StaffData setFoundAt(String foundAt)
	{
		this.foundAt = foundAt;
		return this;
	}
	
	public static StaffData getStaffData(ItemStack stack)
	{
		if (stack != null && stack.getTagCompound() != null)
		{
			List<Spell> spells = Spell.getSpells(stack);
			NBTTagCompound nbt = stack.getTagCompound().getCompoundTag("StaffData");
			boolean rare = nbt.getBoolean("RareStaff");
			int type = nbt.getInteger("StaffType");
			int damage = nbt.getInteger("Damage");
			String foundAt = nbt.getString("FoundAt");
			return new StaffData(spells, StaffType.staffTypes[type], rare, damage, foundAt);
		}
		return new StaffData(new ArrayList<Spell>(), StaffType.staffTypes[0], false, 0, "");
	}
	
	public ItemStack addDataToItemStack(ItemStack stack)
	{
		if (stack != null)
		{
			NBTTagCompound compound = stack.getTagCompound();
			if (compound == null)
			{
				compound = new NBTTagCompound();
				stack.setTagCompound(compound);
			}
			
			for (Spell s : this.getSpells())
			{
				if (s != null) {
					s.addSpellToItemStack(stack);}
			}
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setBoolean("RareStaff", this.isRare());
			nbt.setInteger("StaffType", this.getStaffType().getID());
			nbt.setInteger("Damage", this.getDamage());
			nbt.setString("FoundAt", this.getFoundAt());
			compound.setTag("StaffData", nbt);
			
			return stack;
		}
		return stack;
	}
}
