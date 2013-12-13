package clashsoft.mods.moredimensions.dreams;

import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.mods.moredimensions.world.providers.WorldProviderDreams;
import clashsoft.mods.moredimensions.world.providers.WorldProviderNightmares;


public class Nightmare extends Dream
{
	@Override
	public String getDreamName()
	{
		return "Nightmare";
	}
	
	@Override
	public EnumDreamType getDreamType()
	{
		return EnumDreamType.NIGHTMARE;
	}
	
	@Override
	public void start()
	{
		WorldProviderNightmares.nightmareType = this.dream;
		
		player.travelToDimension(CSConfig.getDimension("Nightmare", 11));
	}
	
	@Override
	public void stop()
	{
		WorldProviderDreams.dreamType = null;
		
		player.travelToDimension(0);
		player.setPosition(bedX, bedY, bedZ);
		player.sleepInBedAt(bedX, bedY, bedZ);
	}
	
	@Override
	public void onUpdate()
	{
		
	}
}
