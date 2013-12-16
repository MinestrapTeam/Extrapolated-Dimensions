package clashsoft.mods.moredimensions.client;

import java.util.EnumSet;
import java.util.List;

import clashsoft.mods.moredimensions.cape.CapeHelper;
import clashsoft.mods.moredimensions.client.gui.GuiGameOverHeaven;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;

public class MDMClientTickHandler implements ITickHandler
{
	private int counter = 0;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		this.updateMainMenu();
		this.updatePlayerCapes();
	}
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		this.updateMainMenu();
	}
	
	public void updatePlayerCapes()
	{
		Minecraft mc = Minecraft.getMinecraft();
		if (mc.theWorld != null && mc.theWorld.playerEntities.size() > 0)
		{
			@SuppressWarnings("unchecked")
			List<AbstractClientPlayer> players = mc.theWorld.playerEntities;
			
			if (counter >= players.size())
				counter = 0;
			
			AbstractClientPlayer p = players.get(counter);
			if (p != null)
			{
				String lowerUsername = p.username.toLowerCase();
				
				if (CapeHelper.getUserGroup(lowerUsername) != null)
				{
					if (!CapeHelper.getDownloadImageThreadData(p).isTextureUploaded())
					{
						String userGroup = CapeHelper.getUserGroup(lowerUsername);
						
						CapeHelper.setCapeResourceLocation(p, CapeHelper.getCapeResource(userGroup));
						CapeHelper.setDownloadImageThreadData(p, CapeHelper.getDownloadThread(userGroup));
					}
				}
			}
			
			counter++;
		}
	}
	
	public void updateMainMenu()
	{
		GuiScreen currentScreen = Minecraft.getMinecraft().currentScreen;
		if (currentScreen == null)
			return;
		else if (currentScreen.getClass() == GuiMainMenu.class)
			; // Minecraft.getMinecraft().displayGuiScreen(new GuiPOCMainMenu());
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
		return "More Dimensions Mod Client Tick Handler";
	}
	
}
