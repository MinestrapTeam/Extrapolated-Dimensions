package clashsoft.mods.moredimensions.chat.boss;

import clashsoft.mods.moredimensions.api.IMDMBoss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class BossChatEntry
{
	public static net.minecraft.util.ResourceLocation	player_icon	= new ResourceLocation("paradiseofchaos:paradiseofchaos/gui/bosschat/playericon.png");
	
	public EnumBossChatUser								userType;
	public String										text;
	public boolean										localized;
	
	public BossChatEntry()
	{
	}
	
	public BossChatEntry(EnumBossChatUser userType, String text, boolean localized)
	{
		this.userType = userType;
		this.text = text;
		this.localized = localized;
	}
	
	public String getUserName(EntityPlayer player, IMDMBoss boss)
	{
		if (this.userType == EnumBossChatUser.PLAYER)
		{
			return player.getDisplayName();
		}
		else if (this.userType == EnumBossChatUser.BOSS)
		{
			return boss.getDisplayName();
		}
		else
		{
			return "";
		}
	}
	
	public ResourceLocation getIcon(IMDMBoss boss)
	{
		if (this.userType == EnumBossChatUser.PLAYER)
		{
			return player_icon;
		}
		else if (this.userType == EnumBossChatUser.BOSS)
		{
			return boss.getIcon();
		}
		else
		{
			return null;
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt)
	{
		nbt.setString("Message", this.text);
		nbt.setInteger("UserType", this.userType.getID());
		nbt.setBoolean("Localized", this.localized);
	}
	
	public void readFromNBT(NBTTagCompound nbt)
	{
		this.text = nbt.getString("Message");
		this.userType = EnumBossChatUser.getBossChatUserFromID(nbt.getInteger("UserType"));
		this.localized = nbt.getBoolean("Localized");
	}
}