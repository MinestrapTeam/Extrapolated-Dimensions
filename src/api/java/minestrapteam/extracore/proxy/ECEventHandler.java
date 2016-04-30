package minestrapteam.extracore.proxy;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.inventory.ExtendedInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class ECEventHandler
{
	@SubscribeEvent
	public void entityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!(event.entity instanceof EntityPlayer))
		{
			return;
		}

		EntityPlayer player = (EntityPlayer) event.entity;

		ExtraCore.proxy.replaceInventory(player);

		if (!event.world.isRemote)
		{
			ExtendedInventory ei = ExtendedInventory.get(player);
			ei.sync();
		}
	}

	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event)
	{
		if (event.phase == Phase.START)
		{
			ExtendedInventory.get(event.player).onUpdate();
		}
	}

	@SubscribeEvent
	public void onDeath(LivingDeathEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			ExtendedInventory.get((EntityPlayer) event.entityLiving).dropAllItems();
		}
	}

	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		ItemStack stack = event.item.getEntityItem();

		if (player.inventory.getFirstEmptyStack() == -1 && !ExtendedInventory.get(player).addItemStack(stack))
		{
			event.setResult(Result.DENY);
		}
	}
}
