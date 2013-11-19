package clashsoft.mods.moredimensions.world.teleporters;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public final class TeleporterNoPortal extends Teleporter
{
	public TeleporterNoPortal(WorldServer par1WorldServer)
	{
		super(par1WorldServer);
	}
	
	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
	{
		
	}
	
	@Override
	public boolean makePortal(Entity par1Entity)
	{
		return true;
	}
	
	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
	{
		return true;
	}
}