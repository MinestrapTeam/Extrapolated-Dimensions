package clashsoft.mods.moredimensions.inventory;

import clashsoft.mods.moredimensions.entity.boss.IMDMBoss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBossChat extends Container
{
	EntityPlayer	player;
	IMDMBoss		boss;
	
	public ContainerBossChat(EntityPlayer par1EntityPlayer, IMDMBoss par2Boss)
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
