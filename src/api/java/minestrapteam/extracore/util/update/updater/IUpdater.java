package minestrapteam.extracore.util.update.updater;

import java.util.List;

import minestrapteam.extracore.util.update.Update;
import minestrapteam.extracore.util.update.reader.IUpdateReader;

import net.minecraft.util.IChatComponent;

public interface IUpdater
{
	String getName();
	
	String getVersion();
	
	String getURL();
	
	IChatComponent getMOTD();
	
	IUpdater setMOTD(IChatComponent motd);
	
	String[] getUpdateFile();
	
	IUpdater setUpdateFile(String[] updateFile);
	
	IUpdateReader getUpdateReader();
	
	void checkUpdate();
	
	boolean reCheck();
	
	boolean keyEquals(String key);
	
	Update newUpdate(String newVersion, List<String> notes, String downloadURL);
}
