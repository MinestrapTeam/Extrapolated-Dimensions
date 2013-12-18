package clashsoft.mods.moredimensions.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.api.IMDMBoss;
import clashsoft.mods.moredimensions.inventory.ContainerAlchemyTable;
import clashsoft.mods.moredimensions.inventory.ContainerBossChat;
import clashsoft.mods.moredimensions.inventory.ContainerDamnationTable;
import clashsoft.mods.moredimensions.inventory.ContainerTome;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTable;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;

public class MDMCommonProxy implements IGuiHandler
{
	public static int	BOSS_CHAT_GUIID			= 20;
	public static int	TOME_GUIID				= 21;
	public static int	DAMNATION_TABLE_GUIID	= 22;
	public static int	ALCHEMY_TABLE_GUIID		= 23;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == BOSS_CHAT_GUIID)
		{
			return new ContainerBossChat(player, (IMDMBoss) world.getEntityByID(x));
		}
		else if (ID == TOME_GUIID)
		{
			return new ContainerTome();
		}
		else if (ID == DAMNATION_TABLE_GUIID)
		{
			return new ContainerDamnationTable(player.inventory, (TileEntityDamnationTable) world.getBlockTileEntity(x, y, z));
		}
		else if (ID == ALCHEMY_TABLE_GUIID)
		{
			return new ContainerAlchemyTable(player.inventory, (TileEntityAlchemyTable) world.getBlockTileEntity(x, y, z));
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	public void replaceGUIs(GuiOpenEvent event)
	{
	}
	
	public void register()
	{
		TickRegistry.registerTickHandler(new MDMTickHandler(), Side.SERVER);
	}
	
	public static int getArmorIndex(String name)
	{
		return MoreDimensionsMod.proxy.getArmor(name);
	}
	
	protected int getArmor(String name)
	{
		return 0;
	}
	
	public EntityPlayer findPlayer(World world, String username)
	{
		List<EntityPlayer> players = world.playerEntities;
		EntityPlayer player = null;
		for (int i = 0; i < players.size(); i++)
		{
			player = players.get(i);
			if (player.username.equals(username))
			{
				return player;
			}
		}
		return null;
	}
	
	public void setCape(EntityPlayer player, String cape)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		
		try
		{
			dos.writeUTF(player.username);
			dos.writeUTF(cape);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		Packet packet = new Packet250CustomPayload("MDMCapes", bos.toByteArray());
		PacketDispatcher.sendPacketToAllPlayers(packet);
	}
	
	public void setCape(EntityPlayer player, Packet250CustomPayload packet)
	{
		// Do nothing
	}
}