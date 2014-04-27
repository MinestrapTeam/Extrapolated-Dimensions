package clashsoft.mods.moredimensions.chat.boss;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class BossChatData
{
	public List<BossChatEntry>	entrys;
	
	public BossChatData()
	{
		this.entrys = new ArrayList<BossChatEntry>();
	}
	
	public void addMessage(BossChatEntry entry)
	{
		this.entrys.add(entry);
	}
	
	public void addMessage(EnumBossChatUser user, String message, boolean translated)
	{
		this.addMessage(new BossChatEntry(user, message, translated));
	}
	
	public void addPlayerMessage(String message, boolean translated)
	{
		this.addMessage(EnumBossChatUser.PLAYER, message, translated);
	}
	
	public void addBossMessage(String message, boolean translated)
	{
		this.addMessage(EnumBossChatUser.BOSS, message, translated);
	}
	
	public void writeToNBT(NBTTagCompound nbt)
	{
		if (nbt != null)
		{
			if (!nbt.hasKey("BossChatData"))
			{
				nbt.setTag("BossChatData", new NBTTagList());
			}
			NBTTagList list = nbt.getTagList("BossChatData", Constants.NBT.TAG_COMPOUND);
			for (BossChatEntry entry : this.entrys)
			{
				NBTTagCompound c = new NBTTagCompound();
				entry.writeToNBT(c);
				list.appendTag(c);
			}
		}
	}
	
	public BossChatData readFromNBT(NBTTagCompound nbt)
	{
		if (nbt != null && nbt.hasKey("BossChatData"))
		{
			NBTTagList list = nbt.getTagList("BossChatData", Constants.NBT.TAG_COMPOUND);
			for (int i = 0; i < list.tagCount(); i++)
			{
				NBTTagCompound c = list.getCompoundTagAt(i);
				BossChatEntry entry = new BossChatEntry();
				entry.readFromNBT(c);
				this.addMessage(entry);
			}
		}
		return this;
	}
}
