package com.chaosdev.paradiseofchaos.entity.boss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import com.chaosdev.paradiseofchaos.entity.boss.chat.BossChatData;
import com.chaosdev.paradiseofchaos.entity.boss.chat.PlayerInputParser.EnumOutputAction;

public interface IPOCBoss
{
	public String getDisplayName();
	
	public ResourceLocation getIcon();
	
	public BossChatData getBossChatData();
	
	public void sendParsedPlayerInput(EnumOutputAction action, EntityPlayer player);
	
	public void onChatOpened(EntityPlayer palyer);
}
