package minestrapteam.extracore.util;

import minestrapteam.extracore.ExtraCore;

import java.util.ArrayList;

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
		if (ExtraCore.proxy.isMinecraftClassName(clazz)) // size() called from func_147112_ai
		{
			return this.fakeLength;
		}
		return super.size();
	}
}
