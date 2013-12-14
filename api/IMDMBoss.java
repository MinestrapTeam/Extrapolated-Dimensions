package clashsoft.mods.moredimensions.api;

import clashsoft.mods.moredimensions.chat.boss.BossChatData;
import clashsoft.mods.moredimensions.chat.boss.PlayerInputParser.EnumOutputAction;

import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface IMDMBoss extends IBossDisplayData
{
	ResourceLocation getIcon();
	
	BossChatData getBossChatData();
	
	void onPlayerInput(EnumOutputAction action, EntityPlayer player);
	
	void onChatOpened(EntityPlayer player);
}
