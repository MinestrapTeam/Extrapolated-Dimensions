package clashsoft.mods.moredimensions.client.gui;

import clashsoft.cslib.reflect.CSReflection;
import clashsoft.mods.moredimensions.client.gui.button.GuiHeavenButton;
import clashsoft.mods.moredimensions.client.gui.button.GuiHeavenButtonLanguage;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
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
			GuiButton newButton = null;
			
			if (oldButton.getClass() == GuiButton.class)
			{
				int width = CSReflection.getValue(GuiButton.class, oldButton, 1);
				int height = CSReflection.getValue(GuiButton.class, oldButton, 2);
				
				newButton = new GuiHeavenButton(oldButton.id, oldButton.xPosition, oldButton.yPosition, width, height, oldButton.displayString);
			}
			else if (oldButton.getClass() == GuiButtonLanguage.class)
			{
				newButton = new GuiHeavenButtonLanguage(oldButton.id, oldButton.xPosition, oldButton.yPosition);
			}
			
			if (newButton != null)
			{
				newButton.enabled = oldButton.enabled;
				newButton.drawButton = oldButton.drawButton;
				
				this.buttonList.set(i, newButton);
			}
		}
	}
}
