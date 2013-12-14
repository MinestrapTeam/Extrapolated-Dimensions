package clashsoft.mods.moredimensions.inventory;

import clashsoft.mods.moredimensions.api.IMDMBoss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBossChat extends Container
{
	EntityPlayer	player;
	IMDMBoss		boss;
	
	public ContainerBossChat(EntityPlayer par1EntityPlayer, IMDMBoss par2Boss)
	{
		this.player = par1EntityPlayer;
		this.boss = par2Boss;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return entityplayer == this.player;
	}
	
}
