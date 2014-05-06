package clashsoft.mods.moredimensions.dream;

import java.util.Random;

import clashsoft.mods.moredimensions.dream.type.DreamType;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Dream
{
	public static Random	rand	= new Random(13425786L);
	
	protected DreamType		type;
	
	protected EntityPlayer	player;
	private World			bedWorld;
	protected int			bedX, bedY, bedZ;
	
	public Dream()
	{
		this.type = this.getRandomDreamType();
	}
	
	public void setPlayer(EntityPlayer player)
	{
		this.player = player;
	}
	
	public void setBedLocation(World world, int x, int y, int z)
	{
		this.bedWorld = world;
		this.bedX = x;
		this.bedY = y;
		this.bedZ = z;
	}
	
	public String getDreamName()
	{
		return this.type != null ? this.type.name : "Dream";
	}
	
	public EntityPlayer getPlayer()
	{
		return this.player;
	}
	
	public int getDreamTime()
	{
		return 0;
	}
	
	public void start()
	{
	}
	
	public void stop()
	{
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
		return DreamType.getRandomDreamType(false, rand);
	}
}
