package clashsoft.mods.moredimensions.common;

import java.util.ConcurrentModificationException;
import java.util.EnumSet;
import java.util.List;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.addons.MDMWorld;
import clashsoft.mods.moredimensions.api.ICape;
import clashsoft.mods.moredimensions.world.teleporters.TeleporterNoPortal;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class MDMTickHandler implements ITickHandler
{
	private int playerCounter = 0;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		if (type.contains(TickType.WORLD))
		{
			World world = (World) tickData[0];
			
			updatePlayerHeight(world);
			updatePlayerCapes(world);
		}
	}
	
	public void updatePlayerHeight(World world)
	{
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
	
	public void updatePlayerCapes(World world)
	{
		if (world != null && world.playerEntities.size() > 0)
		{
			List<AbstractClientPlayer> players = world.playerEntities;
			EntityPlayer player = players.get(playerCounter);
			
			this.playerCounter++;
			if (this.playerCounter >= players.size())
				this.playerCounter = 0;
			
			ExtendedInventory extendedInventory = ExtendedInventory.get(player);
			ItemStack stack = extendedInventory.getStackInSlot(2);
			
			if (stack == null)
			{
				MoreDimensionsMod.proxy.setCape(player, (String) null);
			}
			else if (stack.getItem() instanceof ICape)
			{
				((ICape)stack.getItem()).updateCape(player, stack);
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
