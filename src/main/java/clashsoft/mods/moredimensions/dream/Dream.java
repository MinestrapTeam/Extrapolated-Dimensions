package clashsoft.mods.moredimensions.dream;

import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.mods.moredimensions.dream.type.DreamType;
import clashsoft.mods.moredimensions.world.providers.DreamWorldProvider;

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
		this.dream = this.getRandomDreamType();
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
		return this.player;
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
		DreamWorldProvider.dreamType = this.dream;
		
		this.player.travelToDimension(CSConfig.getDimension("Dream", 10));
	}
	
	public void stop()
	{
		DreamWorldProvider.dreamType = null;
		
		this.player.travelToDimension(0);
		this.player.setPosition(this.bedX, this.bedY, this.bedZ);
		this.player.sleepInBedAt(this.bedX, this.bedY, this.bedZ);
	}
	
	public void onUpdate()
	{
		
	}
	
	public World getBedWorld()
	{
		return this.bedWorld;
	}
	
	public int getBedX()
	{
		return this.bedX;
	}
	
	public int getBedY()
	{
		return this.bedY;
	}
	
	public int getBedZ()
	{
		return this.bedZ;
	}
	
	public DreamType getRandomDreamType()
	{
		return DreamType.getRandomDreamType(this.getDreamType());
	}
}
