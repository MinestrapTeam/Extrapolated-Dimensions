package clashsoft.mods.moredimensions.magic;

import java.util.LinkedList;
import java.util.List;

import clashsoft.mods.moredimensions.magic.spell.Spell;

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
		return spells;
	}
	
	public StaffType getStaffType()
	{
		return staffType;
	}
	
	public boolean isRare()
	{
		return rare;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public String getFoundAt()
	{
		return foundAt;
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
	
	public static StaffData getStaffData(ItemStack staff)
	{
		if (staff != null && staff.getTagCompound() != null)
		{
			List<Spell> var1 = Spell.getSpells(staff);
			NBTTagCompound dataCompound = staff.getTagCompound().getCompoundTag("StaffData");
			boolean var2 = dataCompound.getBoolean("RareStaff");
			int var3 = dataCompound.getInteger("StaffType");
			int var4 = dataCompound.getInteger("Damage");
			String var5 = dataCompound.getString("FoundAt");
			return new StaffData(var1, StaffType.staffTypes[var3], var2, var4, var5);
		}
		return new StaffData(new LinkedList<Spell>(), StaffType.staffTypes[0], false, 0, "");
	}
	
	public ItemStack addDataToItemStack(ItemStack par1ItemStack)
	{
		if (par1ItemStack != null)
		{
			if (par1ItemStack.getTagCompound() == null)
				par1ItemStack.setTagCompound(new NBTTagCompound());
			if (!par1ItemStack.getTagCompound().hasKey("StaffData"))
			{
				par1ItemStack.getTagCompound().setCompoundTag("StaffData", new NBTTagCompound("StaffData"));
			}
			
			par1ItemStack.stackTagCompound.setTag("StaffData", new NBTTagCompound("StaffData"));
			
			for (Spell s : this.getSpells())
			{
				if (s != null)
					s.addSpellToItemStack(par1ItemStack);
			}
			NBTTagCompound nbt = par1ItemStack.stackTagCompound.getCompoundTag("StaffData");
			nbt.setBoolean("RareStaff", this.isRare());
			nbt.setInteger("StaffType", this.getStaffType().getID());
			nbt.setInteger("Damage", this.getDamage());
			nbt.setString("FoundAt", this.getFoundAt());
			
			return par1ItemStack;
		}
		return par1ItemStack;
	}
}
