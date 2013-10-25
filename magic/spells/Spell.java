package clashsoft.mods.moredimensions.magic.spells;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;

public abstract class Spell
{
	public static Map<String, Spell>	spellList		= new HashMap<String, Spell>();
	
	public static Spell					EstuansInterius	= new SpellEstuansInterius("Estuans Interius", 0xFFFFFF);
	
	private final String				name;
	private final int					color;
	
	public Spell(String name, int color)
	{
		this.name = name;
		this.color = color;
		
		Spell.spellList.put(name, this);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public abstract boolean onApplied(EntityLivingBase user, ItemStack stack, MovingObjectPosition target);
	
	/**
	 * Creates an NBTTagCompound in which the Spell is stored
	 * 
	 * @return NBTTagCompound with Spell data
	 */
	public NBTTagCompound createNBT()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("SpellName", name);
		return nbt;
	}
	
	/**
	 * Reads a Spell from a NBTTagCompound
	 * 
	 * @param par1NBTTagCompound
	 *            NBTTagCompound to read Spell from
	 * @return Spell read from NBTTagCompound
	 */
	public static Spell readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		String name = par1NBTTagCompound.getString("SpellName");
		return spellList.get(name);
	}
	
	public static List<Spell> getSpells(ItemStack par1ItemStack)
	{
		if (par1ItemStack != null && par1ItemStack.getTagCompound() != null && par1ItemStack.getTagCompound().hasKey("Spells"))
		{
			NBTTagList list = par1ItemStack.getTagCompound().getTagList("Spells");
			if (list != null)
			{
				List<Spell> spells = new LinkedList<Spell>();
				for (int i = 0; i < list.tagCount(); i++)
				{
					NBTTagCompound nbt = (NBTTagCompound) list.tagAt(i);
					Spell spell = Spell.readFromNBT(nbt);
					if (spell != null && !spells.contains(spell))
						spells.add(spell);
				}
				return spells;
			}
		}
		return new LinkedList<Spell>();
	}
	
	public ItemStack addSpellToItemStack(ItemStack par1ItemStack)
	{
		if (par1ItemStack != null)
		{
			if (par1ItemStack.stackTagCompound == null)
			{
				par1ItemStack.setTagCompound(new NBTTagCompound());
			}
			
			if (!par1ItemStack.stackTagCompound.hasKey("Spells"))
			{
				par1ItemStack.stackTagCompound.setTag("Spells", new NBTTagList("Spells"));
			}
			NBTTagList var2 = (NBTTagList) par1ItemStack.stackTagCompound.getTag("Spells");
			var2.appendTag(this.createNBT());
			return par1ItemStack;
		}
		return null;
	}
	
	public float getMana()
	{
		return 0.5F;
	}
}
