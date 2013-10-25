package clashsoft.mods.moredimensions.common;

import clashsoft.mods.moredimensions.client.gui.GuiTome;
import clashsoft.mods.moredimensions.entity.boss.IPOCBoss;
import clashsoft.mods.moredimensions.entity.boss.chat.BossChatContainer;
import clashsoft.mods.moredimensions.inventory.ContainerTome;
import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class POCCommonProxy implements IGuiHandler
{
	public static int	BOSS_CHAT_GUIID	= 20;
	public static int	TOME_GUIID		= 21;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return ID == BOSS_CHAT_GUIID ? new BossChatContainer(player, (IPOCBoss) world.getEntityByID(x)) : (ID == TOME_GUIID ? new ContainerTome() : null);
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return ID == BOSS_CHAT_GUIID ? new BossChatContainer(player, (IPOCBoss) world.getEntityByID(x)) : (ID == TOME_GUIID ? new GuiTome() : null);
	}
	
	public void registerRenderers()
	{
	}
	
	public void postRegisterRenderers()
	{
	}
	
	public void registerEntityRenderers()
	{
	}
	
	public void registerClientEvents()
	{
	}
}
