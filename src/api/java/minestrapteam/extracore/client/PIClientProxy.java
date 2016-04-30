package minestrapteam.extracore.client;

import minestrapteam.extracore.client.gui.GuiCreativeInventory;
import minestrapteam.extracore.client.gui.GuiSurvivalInventory;
import minestrapteam.extracore.proxy.PIProxy;
import minestrapteam.extracore.inventory.ContainerCreativeList;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class PIClientProxy extends PIProxy
{
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GUI_CREATIVE_ID)
		{
			return new GuiCreativeInventory(player, new ContainerCreativeList(player), this.replaceInventory(player));
		}
		else if (ID == GUI_SURVIVAL_ID)
		{
			return new GuiSurvivalInventory(player, this.replaceInventory(player));
		}
		return null;
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new PIClientEventHandler());
	}
	
	@Override
	public boolean isClient()
	{
		return true;
	}
	
	@Override
	public boolean isMinecraftClassName(String className)
	{
		return className.equals(Minecraft.class.getName());
	}
}
