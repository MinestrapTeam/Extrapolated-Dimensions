package minestrapteam.extradims.dream;

import minestrapteam.extradims.dream.type.DreamType;

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
