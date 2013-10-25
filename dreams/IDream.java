package clashsoft.mods.moredimensions.dreams;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IDream
{	
	public void setPlayer(EntityPlayer player);
	
	public void setPlayerBedPos(World world, int x, int y, int z);
	
	public String getDreamName();
	
	public EntityPlayer getPlayer();
	
	public World getBedWorld();
	
	public int getBedX();
	
	public int getBedY();
	
	public int getBedZ();
	
	public EnumDreamType getDreamType();
	
	public int getDreamTime();
	
	public void start();
	
	public void stop();
	
	public void onUpdate();
}
