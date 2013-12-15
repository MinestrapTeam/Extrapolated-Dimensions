package clashsoft.mods.moredimensions.inventory;

import clashsoft.mods.moredimensions.api.IMDMBoss;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBossChat extends Container
{
	public EntityPlayer	player;
	public IMDMBoss		boss;
	
	public ContainerBossChat(EntityPlayer player, IMDMBoss boss)
	{
		this.player = player;
		this.boss = boss;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return player == this.player;
	}
	
}
