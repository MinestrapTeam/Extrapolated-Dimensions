package clashsoft.mods.moredimensions.dreams;

import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;
import clashsoft.mods.moredimensions.world.providers.WorldProviderDreams;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Dream
{
	protected DreamType		dream;
	
	protected EntityPlayer	player;
	private World			bedWorld;
	protected int			bedX, bedY, bedZ;
	
	public Dream()
	{
		this.dream = getRandomDreamType();
	}
	
	public void setPlayer(EntityPlayer player)
	{
		this.player = player;
	}
	
	public void setPlayerBedPos(World world, int x, int y, int z)
	{
		this.bedWorld = world;
		this.bedX = x;
		this.bedY = y;
		this.bedZ = z;
	}
	
	public String getDreamName()
	{
		return "Dream";
	}
	
	public EntityPlayer getPlayer()
	{
		return player;
	}
	
	public EnumDreamType getDreamType()
	{
		return EnumDreamType.DREAM;
	}
	
	public int getDreamTime()
	{
		return 0;
	}
	
	public void start()
	{
		WorldProviderDreams.dreamType = this.dream;
		
		player.travelToDimension(CSConfig.getDimension("Dream", 10));
	}
	
	public void stop()
	{
		WorldProviderDreams.dreamType = null;
		
		player.travelToDimension(0);
		player.setPosition(bedX, bedY, bedZ);
		player.sleepInBedAt(bedX, bedY, bedZ);
	}
	
	public void onUpdate()
	{
		
	}
	
	public World getBedWorld()
	{
		return bedWorld;
	}
	
	public int getBedX()
	{
		return bedX;
	}
	
	public int getBedY()
	{
		return bedY;
	}
	
	public int getBedZ()
	{
		return bedZ;
	}
	
	public DreamType getRandomDreamType()
	{
		return DreamType.getRandomDreamType(getDreamType());
	}
}
