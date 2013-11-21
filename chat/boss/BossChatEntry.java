package clashsoft.mods.moredimensions.chat.boss;

import clashsoft.mods.moredimensions.entity.boss.IPOCBoss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class BossChatEntry
{
	public static net.minecraft.util.ResourceLocation	playericon	= new ResourceLocation("paradiseofchaos:paradiseofchaos/gui/bosschat/playericon.png");
	
	public EnumBossChatUser								userType;
	public String										text;
	public boolean										translated;
	
	public BossChatEntry(EnumBossChatUser userType, String text, boolean translated)
	{
		this.userType = userType;
		this.text = text;
		this.translated = translated;
	}
	
	public String getUserName(EntityPlayer player, IPOCBoss boss)
	{
		if (userType == EnumBossChatUser.PLAYER)
			return player.username;
		else if (userType == EnumBossChatUser.BOSS)
			return boss.getDisplayName();
		else
			return "";
	}
	
	public ResourceLocation getIcon(IPOCBoss boss)
	{
		if (userType == EnumBossChatUser.PLAYER)
			return playericon;
		else if (userType == EnumBossChatUser.BOSS)
			return boss.getIcon();
		else
			return null;
	}
}