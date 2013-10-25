package com.chaosdev.paradiseofchaos.dreams;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;

public class DreamHelper
{
	
	public static void onPlayerStartedSleeping(EntityPlayer player, int x, int y, int z, long worldTime)
	{
		Random rand = player.getRNG();
		rand.setSeed(worldTime * -3014739720835286983L);
		
		int randomNumber = 100; // rand.nextInt(100);
		if (randomNumber < 20) // 20% chance of a dream
			startDream(player, x, y, z);
		else if (randomNumber >= 20 && randomNumber < 35) // 15% chance of a
															// nightmare
			startNightmare(player, x, y, z);
	}
	
	public static void startDream(EntityPlayer player, int x, int y, int z)
	{
		System.out.println("Starting dream");
		
		Dream dream = new Dream();
		dream.setPlayer(player);
		dream.setPlayerBedPos(player.worldObj, x, y, z);
		player.addChatMessage("dreams.starting.dream");
		
		dream.start();
	}
	
	public static void startNightmare(EntityPlayer player, int x, int y, int z)
	{
		System.out.println("Starting nightmare");
		
		Nightmare nightmare = new Nightmare();
		nightmare.setPlayer(player);
		nightmare.setPlayerBedPos(player.worldObj, x, y, z);
		player.addChatMessage("dreams.starting.nightmare");
		
		nightmare.start();
	}
}
