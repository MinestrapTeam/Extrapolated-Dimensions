package minestrapteam.extradims.inventory;

import minestrapteam.extradims.api.IChatEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBossChat extends Container
{
	public EntityPlayer	player;
	public IChatEntity		boss;
	
	public ContainerBossChat(EntityPlayer player, IChatEntity boss)
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
