package minestrapteam.extracore.potion;

import minestrapteam.extracore.util.ECRegistry;
import minestrapteam.extracore.util.ReflectionUtils;
import minestrapteam.extracore.util.logging.ECLog;
import net.minecraft.potion.Potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PotionRegistry extends ECRegistry
{
	public static PotionRegistry	instance	= new PotionRegistry();
	
	static
	{
		for (Potion potion : Potion.potionTypes)
		{
			if (potion != null)
			{
				add(potion);
			}
		}
		
		expandPotionList(64);
	}
	
	@Override
	public int getFreeID()
	{
		int id = super.getFreeID();
		int len = Potion.potionTypes.length;
		
		if (id > len)
		{
			expandPotionList(len << 1);
			return len;
		}
		return id;
	}
	
	public static int getID(String name)
	{
		return instance.getIDByName(name);
	}
	
	public static void add(Potion potion)
	{
		add(potion, potion.id, potion.getName());
	}
	
	public static void add(Potion potion, int id, String name)
	{
		instance.addObject(id, name, potion);
	}
	
	public static void expandPotionList(int size)
	{
		Potion[] list = Potion.potionTypes;
		if (list.length < size)
		{
			try
			{
				Field f = ReflectionUtils.getField(Potion.class, 0);
				Potion[] potionTypes = new Potion[size];
				
				System.arraycopy(list, 0, potionTypes, 0, list.length);
				ReflectionUtils.setModifier(f, Modifier.FINAL, false);
				f.set(null, potionTypes);
			}
			catch (Exception e)
			{
				ECLog.error(e);
			}
		}
	}
}
