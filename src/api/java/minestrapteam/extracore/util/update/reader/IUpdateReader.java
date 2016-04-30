package minestrapteam.extracore.util.update.reader;

import minestrapteam.extracore.util.update.updater.IUpdater;

public interface IUpdateReader
{
	void readFile(IUpdater updater, String[] lines);
}
