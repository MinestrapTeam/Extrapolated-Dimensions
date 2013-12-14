package clashsoft.mods.moredimensions.curse;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ObjectArrays;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

/**
 * The class course.
 * 
 * Courses are the opposite of curses.
 * 
 * @author Clashsoft
 */
public class Curse
{
	public static final Curse[] curseList = new Curse[256];
	
	public static Curse test = new Curse(0, 20, EnumCurseType.all).setName("test");

    /** The list of curses applicable by the anvil from a book */
    public static final Curse[] cursesBookList;
	
	public final int effectId;
    private final int weight;

    /** The EnumCurseType given to this Curse. */
    public EnumCurseType type;

    /** Used in localisation and stats. */
    protected String name;

    protected Curse(int effectID, int weight, EnumCurseType type)
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
    public int getMinCursability(int par1)
    {
        return 1 + par1 * 10;
    }

    /**
     * Returns the maximum value of enchantability nedded on the curse level passed.
     */
    public int getMaxCursability(int par1)
    {
        return this.getMinCursability(par1) + 5;
    }

    /**
     * Calculates de damage protection of the curse based on level and damage source passed.
     */
    public int calcModifierDamage(int damage, DamageSource damageSource)
    {
        return 0;
    }

    /**
     * Calculates de (magic) damage done by the curse on a living entity based on level and entity passed.
     */
    public float calcModifierLiving(int damage, EntityLivingBase living)
    {
        return 0.0F;
    }

    /**
     * Determines if the curse passed can be applyied together with this curse.
     */
    public boolean canApplyTogether(Curse curse)
    {
        return this != curse;
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
    public String getName()
    {
        return "curse." + this.name;
    }

    /**
     * Returns the correct traslated name of the curse and the level in roman numbers.
     */
    public String getTranslatedName(int level)
    {
        String s = StatCollector.translateToLocal(this.getName());
        return s + " " + StatCollector.translateToLocal("curse.level." + level);
    }

    public boolean canApply(ItemStack stack)
    {
        return this.type.canCurseItem(stack.getItem());
    }

    /**
     * Add to the list of curses applicable by the anvil from a book
     *
     * @param curse
     */
    public static void addToBookList(Curse curse)
    {
        ObjectArrays.concat(cursesBookList, curse);
    }

    /**
     * Is this curse allowed to be enchanted on books via Curse Table
     * @return false to disable the vanilla feature
     */
    public boolean isAllowedOnBooks()
    {
        return true;
    }

    static
    {
        ArrayList arraylist = new ArrayList();
        Curse[] acurse = curseList;
        int i = acurse.length;

        for (int j = 0; j < i; ++j)
        {
            Curse curse = acurse[j];

            if (curse != null)
            {
                arraylist.add(curse);
            }
        }

        cursesBookList = (Curse[])arraylist.toArray(new Curse[0]);
    }
    
   public void addCurseToItemStack(ItemStack stack, int level)
   {
       if (stack.stackTagCompound == null)
       {
           stack.setTagCompound(new NBTTagCompound());
       }

       if (!stack.stackTagCompound.hasKey("curse"))
       {
           stack.stackTagCompound.setTag("curse", new NBTTagList("curse"));
       }

       NBTTagList nbttaglist = (NBTTagList)stack.stackTagCompound.getTag("curse");
       NBTTagCompound nbttagcompound = new NBTTagCompound();
       nbttagcompound.setShort("id", (short)this.effectId);
       nbttagcompound.setShort("lvl", (short)level);
       nbttaglist.appendTag(nbttagcompound);
   }
    
    public static void addTooltip(ItemStack stack, List<String> toolTip)
    {
    	NBTTagList nbttaglist = getCurseTagList(stack);

        if (nbttaglist != null)
        {
            for (int i = 0; i < nbttaglist.tagCount(); ++i)
            {
                short id = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("id");
                short level = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("lvl");

                if (curseList[id] != null)
                {
                    toolTip.add(curseList[id].getTranslatedName(level));
                }
            }
        }
    }
    
    public static NBTTagList getCurseTagList(ItemStack stack)
    {
        return stack.stackTagCompound == null ? null : (NBTTagList)stack.stackTagCompound.getTag("curse");
    }
}
