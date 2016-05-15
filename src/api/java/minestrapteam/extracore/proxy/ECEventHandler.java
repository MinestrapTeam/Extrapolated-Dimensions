package minestrapteam.extracore.proxy;

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
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ECEventHandler
{
	@SubscribeEvent
	public void getModdedMapGen(InitMapGenEvent event)
	{
		if (event.getType() == InitMapGenEvent.EventType.CAVE)
		{
			event.setNewGen(new CustomCaveGen());
		}
	}

	@SubscribeEvent
	public void entityConstructing(EntityEvent.EntityConstructing event)
	{
		ECEntities.loadProperties(event.getEntity());
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
		if (!(event.getEntity() instanceof EntityPlayer))
		{
			return;
		}

		EntityPlayer player = (EntityPlayer) event.getEntity();

		ExtraCore.proxy.replaceInventory(player);

		Capes.updateCape(player);

		if (!event.getWorld().isRemote)
		{
			ExtendedInventory ei = ExtendedInventory.get(player);
			ei.sync();
		}
	}

	@SubscribeEvent
	public void playerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
	{
		ECEntities.copyProperties(event.getOriginal(), event.getEntityPlayer());
	}

	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event)
	{
		if (event.phase == TickEvent.Phase.START)
		{
			ExtendedInventory.get(event.player).onUpdate();
		}
	}

	@SubscribeEvent
	public void onDeath(LivingDeathEvent event)
	{
		if (!(event.getEntityLiving() instanceof EntityPlayer))
		{
			return;
		}

		final EntityPlayer player = (EntityPlayer) event.getEntityLiving();
		if (player.worldObj.isRemote || player.worldObj.getGameRules().getBoolean("keepInventory"))
		{
			// Don't drop items when keepInventory is on
			return;
		}
		ExtendedInventory.get(player).dropAllItems();
	}

	@SubscribeEvent
	public void onContainerOpened(PlayerOpenContainerEvent event)
	{
		ExtraCore.proxy.replaceInventory(event.getEntityPlayer());
	}

	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event)
	{
		EntityPlayer player = event.getEntityPlayer();
		ItemStack stack = event.getItem().getEntityItem();

		if (player.inventory.getFirstEmptyStack() == -1 && !ExtendedInventory.get(player).addItemStack(stack))
		{
			event.setResult(Event.Result.DENY);
		}
	}
}
