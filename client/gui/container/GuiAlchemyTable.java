package clashsoft.mods.moredimensions.client.gui.container;

import clashsoft.mods.moredimensions.inventory.ContainerAlchemyTable;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTable;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class GuiAlchemyTable extends GuiContainer
{
	public TileEntityAlchemyTable alchemyTable;
	
	public GuiAlchemyTable(EntityPlayer player, TileEntityAlchemyTable alchemyTable)
	{
		super(new ContainerAlchemyTable(player.inventory, alchemyTable));
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
	}
	
}
