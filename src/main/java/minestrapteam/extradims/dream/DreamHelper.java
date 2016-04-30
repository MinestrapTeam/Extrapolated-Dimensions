package minestrapteam.extradims.dream;

import java.util.Random;

import minestrapteam.extracore.util.logging.ECLog;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;

public class DreamHelper
{
	public static void onPlayerStartedSleeping(EntityPlayer player, int x, int y, int z, long worldTime)
	{
		Random rand = player.getRNG();
		rand.setSeed(worldTime * -3014739720835286983L);
		
		int randomNumber = rand.nextInt(128);
		if (randomNumber < 12)
		{
			startNightmare(player, x, y, z);
		}
		else if (randomNumber < 32)
		{
			startDream(player, x, y, z);
		}
	}
	
	public static void startDream(EntityPlayer player, int x, int y, int z)
	{
		ECLog.info("Starting dream");
		player.addChatMessage(new ChatComponentTranslation("dreams.start.dream"));
		start(new Dream(), player, x, y, z);
	}
	
	public static void startNightmare(EntityPlayer player, int x, int y, int z)
	{
		ECLog.info("Starting nightmare");
		player.addChatMessage(new ChatComponentTranslation("dreams.start.nightmare"));
		start(new Nightmare(), player, x, y, z);
	}
	
	public static void start(Dream dream, EntityPlayer player, int x, int y, int z)
	{
		dream.setPlayer(player);
		dream.setBedLocation(player.worldObj, x, y, z);
		dream.start();
	}
}
