package minestrapteam.extradims.curse;

import minestrapteam.extracore.util.StringUtils;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * The {@code Curse} class. Curses are the opposite of Enchantments and can be applied via Damnation Tables.
 *
 * @author Clashsoft
 */
public class Curse
{
	public static final String  TAG_NAME  = "Curses";
	public static final Curse[] curseList = new Curse[256];

	public static Curse test = new Curse(0, 20, EnumEnchantmentType.all).setName("test");

	public final  int effectId;
	private final int weight;

	public final EnumEnchantmentType type;

	protected String name;

	protected Curse(int effectID, int weight, EnumEnchantmentType type)
	{
		this.effectId = effectID;
		this.weight = weight;
		this.type = type;

		if (curseList[effectID] != null)
		{
			throw new IllegalArgumentException("Duplicate curse id!");
		}
		else
		{
			curseList[effectID] = this;
		}
	}

	public int getWeight()
	{
		return this.weight;
	}

	/**
	 * Returns the minimum level that the curse can have.
	 */
	public int getMinLevel()
	{
		return 1;
	}

	/**
	 * Returns the maximum level that the curse can have.
	 */
	public int getMaxLevel()
	{
		return 1;
	}

	/**
	 * Returns the minimal value of enchantability needed on the curse level passed.
	 */
	public int getMinCursability(int level)
	{
		return 1 + level * 10;
	}

	/**
	 * Returns the maximum value of enchantability nedded on the curse level passed.
	 */
	public int getMaxCursability(int level)
	{
		return this.getMinCursability(level) + 5;
	}

	/**
	 * Sets the curse name
	 */
	public Curse setName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * Return the name of key in translation table of this curse.
	 */
	public String getUnlocalizedName()
	{
		return "curse." + this.name;
	}

	/**
	 * Returns the correct translated name of the curse and the level in roman numbers.
	 */
	public String getTranslatedName(int level)
	{
		final String name = StatCollector.translateToLocal(this.getUnlocalizedName());
		return name + " " + StringUtils.convertToRoman(level);
	}

	public boolean canApply(ItemStack stack)
	{
		return stack != null && this.type.canEnchantItem(stack.getItem());
	}

	/**
	 * Is this curse allowed to be enchanted on books via Curse Table
	 *
	 * @return false to disable the vanilla feature
	 */
	public boolean isAllowedOnBooks()
	{
		return true;
	}

	public void addCurseToItemStack(ItemStack stack, int level)
	{
		if (stack.stackTagCompound == null)
		{
			stack.setTagCompound(new NBTTagCompound());
		}

		if (!stack.stackTagCompound.hasKey(TAG_NAME))
		{
			stack.stackTagCompound.setTag("curse", new NBTTagList());
		}

		NBTTagList nbttaglist = (NBTTagList) stack.stackTagCompound.getTag(TAG_NAME);
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setShort("id", (short) this.effectId);
		nbttagcompound.setShort("lvl", (short) level);
		nbttaglist.appendTag(nbttagcompound);
	}

	public static void addTooltip(ItemStack stack, List<String> toolTip)
	{
		NBTTagList list = getCurseTagList(stack);

		if (list == null)
		{
			return;
		}

		for (int i = 0; i < list.tagCount(); ++i)
		{
			NBTTagCompound tag = list.getCompoundTagAt(i);
			short id = tag.getShort("id");
			short level = tag.getShort("lvl");

			if (curseList[id] != null)
			{
				toolTip.add(1, curseList[id].getTranslatedName(level));
			}
		}
	}

	public static NBTTagList getCurseTagList(ItemStack stack)
	{
		return stack.stackTagCompound == null ? null : (NBTTagList) stack.stackTagCompound.getTag(TAG_NAME);
	}
}
