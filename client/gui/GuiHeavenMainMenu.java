package clashsoft.mods.moredimensions.client.gui;

import clashsoft.cslib.reflect.CSReflection;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;

public class GuiHeavenMainMenu extends GuiMainMenu
{
	public GuiHeavenMainMenu()
	{
		super();
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		for (int i = 0; i < this.buttonList.size(); i++)
		{
			GuiButton oldButton = (GuiButton) this.buttonList.get(i);
			int width = CSReflection.getValue(GuiButton.class, oldButton, 1);
			int height = CSReflection.getValue(GuiButton.class, oldButton, 2);
			
			GuiHeavenButton newButton = new GuiHeavenButton(oldButton.id, oldButton.xPosition, oldButton.yPosition, width, height, oldButton.displayString);
			this.buttonList.set(i, newButton);
		}
	}
}
