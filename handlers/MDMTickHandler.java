package clashsoft.mods.moredimensions.handlers;

import java.util.EnumSet;

import clashsoft.mods.moredimensions.client.gui.GuiGameOverHeaven;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;

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
		GuiScreen currentScreen = Minecraft.getMinecraft().currentScreen;
		if (currentScreen == null)
			return;
		else if (currentScreen.getClass() == GuiMainMenu.class)
			; //Minecraft.getMinecraft().displayGuiScreen(new GuiPOCMainMenu());
		else if (currentScreen.getClass() == GuiGameOver.class)
			Minecraft.getMinecraft().displayGuiScreen(new GuiGameOverHeaven());
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
