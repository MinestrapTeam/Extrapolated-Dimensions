package clashsoft.mods.moredimensions.magic.spells;

import java.util.*;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.util.Constants;

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
		return this.name;
	}
	
	public int getColor()
	{
		return this.color;
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
		nbt.setString("SpellName", this.name);
		return nbt;
	}
	
	/**
	 * Reads a Spell from a NBTTagCompound
	 * 
	 * @param nbt
	 *            NBTTagCompound to read Spell from
	 * @return Spell read from NBTTagCompound
	 */
	public static Spell readFromNBT(NBTTagCompound nbt)
	{
		String name = nbt.getString("SpellName");
		return spellList.get(name);
	}
	
	public static List<Spell> getSpells(ItemStack stack)
	{
		if (stack != null && stack.getTagCompound() != null && stack.getTagCompound().hasKey("Spells"))
		{
			NBTTagList list = stack.getTagCompound().getTagList("Spells", Constants.NBT.TAG_COMPOUND);
			if (list != null)
			{
				List<Spell> spells = new ArrayList<Spell>();
				for (int i = 0; i < list.tagCount(); i++)
				{
					NBTTagCompound nbt = list.getCompoundTagAt(i);
					Spell spell = Spell.readFromNBT(nbt);
					if (spell != null && !spells.contains(spell))
					{
						spells.add(spell);
					}
				}
				return spells;
			}
		}
		return new LinkedList<Spell>();
	}
	
	public ItemStack addSpellToItemStack(ItemStack stack)
	{
		if (stack != null)
		{
			if (stack.stackTagCompound == null)
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			
			if (!stack.stackTagCompound.hasKey("Spells"))
			{
				stack.stackTagCompound.setTag("Spells", new NBTTagList());
			}
			NBTTagList var2 = (NBTTagList) stack.stackTagCompound.getTag("Spells");
			var2.appendTag(this.createNBT());
			return stack;
		}
		return null;
	}
	
	public float getMana()
	{
		return 0.5F;
	}
}
