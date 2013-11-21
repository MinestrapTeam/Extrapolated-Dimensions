package clashsoft.mods.moredimensions.inventory;

import clashsoft.mods.moredimensions.entity.boss.IPOCBoss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBossChat extends Container
{
	EntityPlayer	player;
	IPOCBoss		boss;
	
	public ContainerBossChat(EntityPlayer par1EntityPlayer, IPOCBoss par2Boss)
	{
		player = par1EntityPlayer;
		boss = par2Boss;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return entityplayer == player;
	}
	
}
