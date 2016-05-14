package minestrapteam.extracore.api;

import minestrapteam.extracore.potion.IPotionEffectHandler;
import minestrapteam.extracore.potion.IPotionList;
import minestrapteam.extracore.potion.PotionList;
import minestrapteam.extracore.potion.type.IPotionType;
import minestrapteam.extracore.util.logging.ECLog;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BrewingAPI
{
	public static String  goodEffectColor1      = TextFormatting.GRAY.toString();
	public static String  goodEffectColor2      = TextFormatting.WHITE.toString();
	public static String  badEffectColor1       = TextFormatting.RED.toString();
	public static String  badEffectColor2       = TextFormatting.GOLD.toString();
	public static boolean multiPotions          = false;
	public static boolean advancedPotionInfo    = false;
	public static boolean showAllBaseTypes      = false;
	public static boolean defaultAwkwardBrewing = false;
	public static int     potionStackSize       = 1;

	public static List<IPotionEffectHandler> effectHandlers = new ArrayList<>();

	public static IPotionType addPotionType(IPotionType potionType)
	{
		return potionType.register();
	}

	public static void setPotionList(IPotionList potionList)
	{
		PotionList.instance = potionList;
	}

	public static void registerEffectHandler(IPotionEffectHandler handler)
	{
		if (!effectHandlers.contains(handler))
		{
			ECLog.info("Effect handler \"" + handler + "\" registered");
			effectHandlers.add(handler);
		}
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase living = event.getEntityLiving();
		if (living == null || living.worldObj.isRemote)
		{
			return;
		}

		Collection<PotionEffect> collection = (Collection<PotionEffect>) living.getActivePotionEffects();
		List<PotionEffect> potionEffects = new ArrayList<>(collection);

		for (PotionEffect effect : potionEffects)
		{
			for (IPotionEffectHandler handler : effectHandlers)
			{
				if (handler.canHandle(effect))
				{
					handler.onPotionUpdate(living.deathTime, living, effect);
				}
			}
		}
	}
}
