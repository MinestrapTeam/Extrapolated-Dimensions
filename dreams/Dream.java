package clashsoft.mods.moredimensions.dreams;

import clashsoft.mods.moredimensions.addons.MDMConfig;
import clashsoft.mods.moredimensions.dreams.dim.WorldProviderDreams;
import clashsoft.mods.moredimensions.dreams.dreamtypes.DreamType;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Dream implements IDream
{
	protected DreamType		dream;
	
	protected EntityPlayer	player;
	private World			bedWorld;
	protected int			bedX, bedY, bedZ;
	
	public Dream()
	{
		this.dream = getRandomDreamType();
	}
	
	@Override
	public void setPlayer(EntityPlayer player)
	{
		this.player = player;
	}
	
	@Override
	public void setPlayerBedPos(World world, int x, int y, int z)
	{
		this.bedWorld = world;
		this.bedX = x;
		this.bedY = y;
		this.bedZ = z;
	}
	
	@Override
	public String getDreamName()
	{
		return "Dream";
	}
	
	@Override
	public EntityPlayer getPlayer()
	{
		return player;
	}
	
	@Override
	public EnumDreamType getDreamType()
	{
		return EnumDreamType.DREAM;
	}
	
	@Override
	public int getDreamTime()
	{
		return 0;
	}
	
	@Override
	public void start()
	{
		WorldProviderDreams.dreamType = this.dream;
		
		player.travelToDimension(MDMConfig.DREAMS_DIMENSION_ID);
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
	
	@Override
	public World getBedWorld()
	{
		return bedWorld;
	}
	
	@Override
	public int getBedX()
	{
		return bedX;
	}
	
	@Override
	public int getBedY()
	{
		return bedY;
	}
	
	@Override
	public int getBedZ()
	{
		return bedZ;
	}
	
	public DreamType getRandomDreamType()
	{
		return DreamType.getRandomDreamType(getDreamType());
	}
}
