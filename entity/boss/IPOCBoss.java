package clashsoft.mods.moredimensions.entity.boss;

import clashsoft.mods.moredimensions.entity.boss.chat.BossChatData;
import clashsoft.mods.moredimensions.entity.boss.chat.PlayerInputParser.EnumOutputAction;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface IPOCBoss
{
	public String getDisplayName();
	
	public ResourceLocation getIcon();
	
	public BossChatData getBossChatData();
	
	public void sendParsedPlayerInput(EnumOutputAction action, EntityPlayer player);
	
	public void onChatOpened(EntityPlayer palyer);
}
