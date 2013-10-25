package com.chaosdev.paradiseofchaos.dreams;

import clashsoft.mods.moredimensions.addons.POCConfig;

import com.chaosdev.paradiseofchaos.dreams.dim.WorldProviderDreams;
import com.chaosdev.paradiseofchaos.dreams.dim.WorldProviderNightmares;

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
		return NIGHTMARE;
	}
	
	@Override
	public void start()
	{
		WorldProviderNightmares.nightmareType = this.dream;
		
		player.travelToDimension(POCConfig.NIGHTMARES_DIMENSION_ID);
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
