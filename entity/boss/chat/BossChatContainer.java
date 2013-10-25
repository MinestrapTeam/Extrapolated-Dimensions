package com.chaosdev.paradiseofchaos.entity.boss.chat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.chaosdev.paradiseofchaos.entity.boss.IPOCBoss;

public class BossChatContainer extends Container
{
	EntityPlayer	player;
	IPOCBoss		boss;
	
	public BossChatContainer(EntityPlayer par1EntityPlayer, IPOCBoss par2Boss)
	{
		player = par1EntityPlayer;
		boss = par2Boss;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return entityplayer == player;
	}
	
}
