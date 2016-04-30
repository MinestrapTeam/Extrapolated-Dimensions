package minestrapteam.extracore.init;

import java.util.Arrays;
import java.util.List;

import minestrapteam.extracore.proxy.BaseProxy;
import minestrapteam.extracore.network.BaseNetHandler;

public abstract class ClashsoftMod<N extends BaseNetHandler> extends BaseMod<N>
{
	public static final List<String>	AUTHORS_CLASHSOFT	= Arrays.asList("Clashsoft");
	
	public ClashsoftMod(BaseProxy proxy, String modID, String name, String version)
	{
		super(proxy, modID, name, version);
		this.authors = AUTHORS_CLASHSOFT;
	}
	
	public ClashsoftMod(BaseProxy proxy, String modID, String name, String acronym, String version)
	{
		super(proxy, modID, name, acronym, version);
		this.authors = AUTHORS_CLASHSOFT;
	}
}
