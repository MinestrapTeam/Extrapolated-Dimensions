package minestrapteam.extradims.api;

import minestrapteam.extradims.chat.boss.BossChatData;
import minestrapteam.extradims.chat.boss.PlayerInputParser.EnumOutputAction;

import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public interface IChatEntity extends IBossDisplayData
{
	String getDisplayName();
	
	ResourceLocation getIcon();
	
	BossChatData getBossChatData();
	
	void onPlayerInput(EnumOutputAction action, EntityPlayer player);
	
	void onChatOpened(EntityPlayer player);
}
