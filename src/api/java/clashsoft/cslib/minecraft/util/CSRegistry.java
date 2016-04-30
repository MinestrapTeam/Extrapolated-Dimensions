package clashsoft.cslib.minecraft.util;

import net.minecraft.util.RegistryNamespaced;

import java.util.BitSet;

public class CSRegistry extends RegistryNamespaced
{
	protected BitSet	availabilityMap	= new BitSet();
	
	public int getFreeID()
	{
		return this.availabilityMap.nextClearBit(0);
	}
	
	public int getIDByName(String name)
	{
		int i = this.getIDForObject(this.getObject(name));
		if (i == -1)
		{
			i = this.getFreeID();
		}
		return i;
	}
	
	@Override
	public void addObject(int id, String name, Object object)
	{
		super.addObject(id, name, object);
		this.availabilityMap.set(id);
	}
}
