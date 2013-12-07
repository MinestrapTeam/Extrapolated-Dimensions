package clashsoft.mods.moredimensions.common;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.entity.boss.IMDMBoss;
import clashsoft.mods.moredimensions.inventory.ContainerBossChat;
import clashsoft.mods.moredimensions.inventory.ContainerTome;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MDMCommonProxy implements IGuiHandler
{	
	public static int	BOSS_CHAT_GUIID	= 20;
	public static int	TOME_GUIID		= 21;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return ID == BOSS_CHAT_GUIID ? new ContainerBossChat(player, (IMDMBoss) world.getEntityByID(x)) : (ID == TOME_GUIID ? new ContainerTome() : null);
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
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
}