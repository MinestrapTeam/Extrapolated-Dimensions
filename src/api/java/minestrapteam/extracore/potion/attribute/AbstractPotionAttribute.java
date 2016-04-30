package minestrapteam.extracore.potion.attribute;

import minestrapteam.extracore.potion.type.IPotionType;
import net.minecraft.util.StatCollector;

public abstract class AbstractPotionAttribute implements IPotionAttribute
{
	protected String name;
	
	public AbstractPotionAttribute(String name)
	{
		this.name = name;
	}
	
	@Override
	public IPotionAttribute register()
	{
		attributes.put(this.getName(), this);
		return this;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String getDisplayName(IPotionType type)
	{
		return StatCollector.translateToLocal("potion.attribute." + this.getName() + ".name");
	}
}
