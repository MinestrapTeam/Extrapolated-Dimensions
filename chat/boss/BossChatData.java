package clashsoft.mods.moredimensions.chat.boss;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class BossChatData
{
	public List<BossChatEntry>	entrys;
	
	public BossChatData()
	{
		entrys = new ArrayList<BossChatEntry>();
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
