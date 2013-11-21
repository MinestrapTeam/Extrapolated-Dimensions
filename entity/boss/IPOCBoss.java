package clashsoft.mods.moredimensions.entity.boss;

import clashsoft.mods.moredimensions.chat.boss.BossChatData;
import clashsoft.mods.moredimensions.chat.boss.PlayerInputParser.EnumOutputAction;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface IPOCBoss
{
	public String getDisplayName();
	
	public ResourceLocation getIcon();
	
	public BossChatData getBossChatData();
	
	public void onPlayerInput(EnumOutputAction action, EntityPlayer player);
	
	public void onChatOpened(EntityPlayer palyer);
}
