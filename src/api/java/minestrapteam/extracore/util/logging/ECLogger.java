package minestrapteam.extracore.util.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ECLogger
{
	public static final Logger	logger	= Logger.getGlobal();
	
	public void log(Level level, String msg)
	{
		logger.log(level, msg);
	}
	
	public void log(Level level, Throwable error)
	{
		logger.log(level, error.getMessage(), error);
	}
}
