package clashsoft.mods.moredimensions.entity.boss.chat;

import java.util.LinkedList;
import java.util.List;

import clashsoft.mods.moredimensions.entity.boss.IPOCBoss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

public class BossChatData
{
	public enum EnumBossChatUser
	{
		PLAYER(0, 0xFFFFFF), BOSS(1, 0xFF0000), CUSTOM(-1, 0xFFFFFF);
		
		private int	color;
		private int	id;
		
		private EnumBossChatUser(int id, int color)
		{
			this.id = id;
			this.color = color;
		}
		
		public int getColor()
		{
			return color;
		}
		
		public int getID()
		{
			return id;
		}
		
		public static EnumBossChatUser getBossChatUserFromID(int id)
		{
			for (EnumBossChatUser bcu : values())
			{
				if (bcu.id == id)
					return bcu;
			}
			return null;
		}
	}
	
	public static class BossChatEntry
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
	
	public List<BossChatEntry>	entrys;
	
	public BossChatData()
	{
		entrys = new LinkedList<BossChatEntry>();
	}
	
	public void addMessage(BossChatEntry entry)
	{
		entrys.add(entry);
	}
	
	public void addMessage(EnumBossChatUser user, String message, boolean translated)
	{
		addMessage(new BossChatEntry(user, message, translated));
	}
	
	public void addPlayerMessage(String message, boolean translated)
	{
		addMessage(EnumBossChatUser.PLAYER, message, translated);
	}
	
	public void addBossMessage(String message, boolean translated)
	{
		addMessage(EnumBossChatUser.BOSS, message, translated);
	}
	
	public void writeToNBT(NBTTagCompound nbt)
	{
		if (nbt != null)
		{
			if (!nbt.hasKey("BossChatData"))
			{
				nbt.setTag("BossChatData", new NBTTagList());
			}
			NBTTagList list = nbt.getTagList("BossChatData");
			for (BossChatEntry entry : this.entrys)
			{
				NBTTagCompound c = new NBTTagCompound("BossChatEntry");
				c.setString("Message", entry.text);
				c.setInteger("UserType", entry.userType.getID());
				list.appendTag(c);
			}
		}
	}
	
	public static BossChatData readFromNBT(NBTTagCompound nbt)
	{
		if (nbt != null && nbt.hasKey("BossChatData"))
		{
			NBTTagList list = nbt.getTagList("BossChatData");
			BossChatData bcd = new BossChatData();
			for (int i = 0; i < list.tagCount(); i++)
			{
				NBTTagCompound c = (NBTTagCompound) list.tagAt(i);
				EnumBossChatUser user = EnumBossChatUser.getBossChatUserFromID(nbt.getInteger("UserType"));
				String message = nbt.getString("Message");
				bcd.addMessage(user, message, true);
			}
			return bcd;
		}
		return new BossChatData();
	}
}
