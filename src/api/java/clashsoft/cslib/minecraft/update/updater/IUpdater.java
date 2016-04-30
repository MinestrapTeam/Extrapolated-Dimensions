package clashsoft.cslib.minecraft.update.updater;

import java.util.List;

import clashsoft.cslib.minecraft.update.Update;
import clashsoft.cslib.minecraft.update.reader.IUpdateReader;

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
