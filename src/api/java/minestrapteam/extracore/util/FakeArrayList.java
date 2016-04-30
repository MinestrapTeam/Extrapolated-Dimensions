package minestrapteam.extracore.util;

import java.util.ArrayList;

import minestrapteam.extracore.util.ReflectionUtils;
import minestrapteam.extracore.PlayerInventoryAPI;

public class FakeArrayList extends ArrayList
{
	private static final long	serialVersionUID	= 5436247638996771146L;
	
	public int					fakeLength;
	
	public FakeArrayList(int fakeLength)
	{
		this.fakeLength = fakeLength;
	}
	
	@Override
	public int size()
	{
		String clazz = ReflectionUtils.getCallerClassName();
		if (PlayerInventoryAPI.proxy.isMinecraftClassName(clazz))
		{
			return this.fakeLength;
		}
		return super.size();
	}
}
