package minestrapteam.extracore.util.update.reader;

import java.util.ArrayList;
import java.util.List;

import minestrapteam.extracore.util.update.ECUpdate;
import minestrapteam.extracore.util.update.Update;
import minestrapteam.extracore.util.update.updater.IUpdater;

public class ChangelogUpdateReader implements IUpdateReader
{
	public static final ChangelogUpdateReader	instance	= new ChangelogUpdateReader();
	
	@Override
	public void readFile(IUpdater updater, String[] lines)
	{
		String version = null;
		String url = null;
		List<String> updateNotes = new ArrayList();
		for (String line : lines)
		{
			line = line.trim();
			
			if (!line.isEmpty())
			{
				if (Character.isDigit(line.charAt(0)))
				{
					version = line;
				}
				else if (version != null && !(updateNotes.isEmpty() && url == null))
				{
					Update update = updater.newUpdate(version, updateNotes, url);
					ECUpdate.addUpdate(update);
					
					updateNotes.clear();
					version = null;
					url = null;
				}
				else
				{
					int index = line.indexOf("Download:");
					if (index != -1)
					{
						url = line.substring(index + 10).trim();
					}
					else
					{
						updateNotes.add(line);
					}
				}
			}
		}
	}
}
