package clashsoft.mods.moredimensions.common;

import java.util.ConcurrentModificationException;
import java.util.EnumSet;

import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.world.teleporters.TeleporterNoPortal;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class MDMTickHandler implements ITickHandler
{
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		if (type.contains(TickType.WORLD))
		{
			World world = (World) tickData[0];
			try
			{
				for (Object o : world.playerEntities)
				{
					EntityPlayerMP player = (EntityPlayerMP) o;
					MinecraftServer server = player.mcServer;
					if (player.dimension == MDMWorld.HEAVEN_ID && player.posY <= -64)
					{
						player.setPosition(player.posX, 256, player.posZ);
						server.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterNoPortal(server.worldServerForDimension(0)));
					}
					else if (player.dimension == 0 && player.posY > 256)
					{
						player.setPosition(player.posX, 0, player.posZ);
						server.getConfigurationManager().transferPlayerToDimension(player, MDMWorld.HEAVEN_ID, new TeleporterNoPortal(server.worldServerForDimension(MDMWorld.HEAVEN_ID)));
					}
				}
			}
			catch (ConcurrentModificationException ex)
			{
			}
		}
	}
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
	}
	
	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.WORLD);
	}
	
	@Override
	public String getLabel()
	{
		return "More Dimensions Mod Tick Handler";
	}
	
}
