package clashsoft.mods.moredimensions.common;

import java.util.List;

import clashsoft.cslib.minecraft.common.BaseProxy;
import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.api.IMDMBoss;
import clashsoft.mods.moredimensions.inventory.ContainerAlchemyTable;
import clashsoft.mods.moredimensions.inventory.ContainerBossChat;
import clashsoft.mods.moredimensions.inventory.ContainerDamnationTable;
import clashsoft.mods.moredimensions.inventory.ContainerTome;
import clashsoft.mods.moredimensions.network.CapePacket;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTable;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class MDMProxy extends BaseProxy
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
			return new ContainerDamnationTable(player.inventory, (TileEntityDamnationTable) world.getTileEntity(x, y, z));
		}
		else if (ID == ALCHEMY_TABLE_GUIID)
		{
			return new ContainerAlchemyTable(player.inventory, (TileEntityAlchemyTable) world.getTileEntity(x, y, z));
		}
		else
		{
			return null;
		}
	}
	
	public static int getArmorIndex(String name)
	{
		return MoreDimensionsMod.proxy.getArmor(name);
	}
	
	protected int getArmor(String name)
	{
		return 0;
	}
	
	public void setCape(EntityPlayer player, String cape)
	{
		MoreDimensionsMod.instance.netHandler.sendToAll(new CapePacket(player, cape));
	}
	
	public void sendPlayerToHeaven(EntityPlayer player)
	{
	}
	
	public EntityPlayer findPlayer(String username)
	{
		for (World world : DimensionManager.getWorlds())
		{
			EntityPlayer player = this.findPlayer(world, username);
			if (player != null)
			{
				return player;
			}
		}
		return null;
	}
	
	public EntityPlayer findPlayer(World world, String username)
	{
		List<EntityPlayer> players = world.playerEntities;
		EntityPlayer player = null;
		for (int i = 0; i < players.size(); i++)
		{
			player = players.get(i);
			if (player.getDisplayName().equals(username))
			{
				return player;
			}
		}
		return null;
	}
}