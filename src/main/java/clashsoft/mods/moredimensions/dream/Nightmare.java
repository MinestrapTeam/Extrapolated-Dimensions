package clashsoft.mods.moredimensions.dream;

import clashsoft.mods.moredimensions.dream.type.DreamType;

public class Nightmare extends Dream
{
	@Override
	public String getDreamName()
	{
		return this.type != null ? this.type.name : "Nightmare";
	}
	
	@Override
	public DreamType getRandomDreamType()
	{
		return DreamType.getRandomDreamType(true, rand);
	}
}
