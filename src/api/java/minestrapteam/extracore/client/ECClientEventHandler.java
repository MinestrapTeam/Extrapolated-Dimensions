package minestrapteam.extracore.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.api.PlayerInventoryAPI;
import minestrapteam.extracore.proxy.ECProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;

public class ECClientEventHandler
{
	@SubscribeEvent
	public void onTick(@SuppressWarnings("UnusedParameters") TickEvent.ClientTickEvent event)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (PlayerInventoryAPI.customSurvivalInventory && Minecraft.getMinecraft().currentScreen instanceof GuiInventory)
		{
			player.openGui(ExtraCore.instance, ECProxy.GUI_SURVIVAL_ID, player.worldObj, 0, 0, 0);
		}
		else if (PlayerInventoryAPI.customCreativeInventory && Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative)
		{
			player.openGui(ExtraCore.instance, ECProxy.GUI_CREATIVE_ID, player.worldObj, 0, 0, 0);
		}
	}
}
