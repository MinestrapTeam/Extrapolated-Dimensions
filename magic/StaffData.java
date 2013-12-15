package clashsoft.mods.moredimensions.magic;

import java.util.ArrayList;
import java.util.List;

import clashsoft.mods.moredimensions.magic.spells.Spell;

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
			List<Spell> var1 = Spell.getSpells(stack);
			NBTTagCompound dataCompound = stack.getTagCompound().getCompoundTag("StaffData");
			boolean var2 = dataCompound.getBoolean("RareStaff");
			int var3 = dataCompound.getInteger("StaffType");
			int var4 = dataCompound.getInteger("Damage");
			String var5 = dataCompound.getString("FoundAt");
			return new StaffData(var1, StaffType.staffTypes[var3], var2, var4, var5);
		}
		return new StaffData(new ArrayList<Spell>(), StaffType.staffTypes[0], false, 0, "");
	}
	
	public ItemStack addDataToItemStack(ItemStack stack)
	{
		if (stack != null)
		{
			if (stack.getTagCompound() == null)
				stack.setTagCompound(new NBTTagCompound());
			if (!stack.getTagCompound().hasKey("StaffData"))
			{
				stack.getTagCompound().setCompoundTag("StaffData", new NBTTagCompound("StaffData"));
			}
			
			stack.stackTagCompound.setTag("StaffData", new NBTTagCompound("StaffData"));
			
			for (Spell s : this.getSpells())
			{
				if (s != null)
					s.addSpellToItemStack(stack);
			}
			NBTTagCompound nbt = stack.stackTagCompound.getCompoundTag("StaffData");
			nbt.setBoolean("RareStaff", this.isRare());
			nbt.setInteger("StaffType", this.getStaffType().getID());
			nbt.setInteger("Damage", this.getDamage());
			nbt.setString("FoundAt", this.getFoundAt());
			
			return stack;
		}
		return stack;
	}
}
