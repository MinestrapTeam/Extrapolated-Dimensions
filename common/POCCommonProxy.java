package com.chaosdev.paradiseofchaos.common;

import com.chaosdev.paradiseofchaos.client.gui.GuiTome;
import com.chaosdev.paradiseofchaos.entity.boss.IPOCBoss;
import com.chaosdev.paradiseofchaos.entity.boss.chat.BossChatContainer;
import com.chaosdev.paradiseofchaos.inventory.ContainerTome;

import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler
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
