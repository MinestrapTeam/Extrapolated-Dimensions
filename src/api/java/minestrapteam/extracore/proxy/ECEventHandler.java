package minestrapteam.extracore.proxy;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.cape.Capes;
import minestrapteam.extracore.entity.ECEntities;
import minestrapteam.extracore.inventory.ExtendedInventory;
import minestrapteam.extracore.util.update.ECUpdate;
import minestrapteam.extracore.world.gen.CustomCaveGen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

public class ECEventHandler
{
	@SubscribeEvent
	public void getModdedMapGen(InitMapGenEvent event)
	{
		if (event.type == InitMapGenEvent.EventType.CAVE)
		{
			event.newGen = new CustomCaveGen();
		}
	}

	@SubscribeEvent
	public void entityConstructing(EntityEvent.EntityConstructing event)
	{
		ECEntities.loadProperties(event.entity);
	}

	@SubscribeEvent
	public void playerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (ExtraCore.proxy.isClient())
		{
			ECUpdate.notifyAll(event.player);
		}
	}

	@SubscribeEvent
	public void entityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!(event.entity instanceof EntityPlayer))
		{
			return;
		}

		EntityPlayer player = (EntityPlayer) event.entity;

		ExtraCore.proxy.replaceInventory(player);

		Capes.updateCape(player);

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
	public void onContainerOpened(PlayerOpenContainerEvent event)
	{
		ExtraCore.proxy.replaceInventory(event.entityPlayer);
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
