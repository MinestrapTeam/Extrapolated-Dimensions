package clashsoft.mods.moredimensions.lib;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;

public class MDMTickHandler implements ITickHandler
{
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		updateMainMenu();
	}
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		updateMainMenu();
	}
	
	public void updateMainMenu()
	{
		if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu)
		{
			// Minecraft.getMinecraft().displayGuiScreen(new GuiPOCMainMenu());
		}
	}
	
	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.CLIENT);
	}
	
	@Override
	public String getLabel()
	{
		return "ParadiseOfChaos Tick Handler";
	}
	
}
