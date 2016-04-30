package minestrapteam.extradims.client.gui.container;

import org.lwjgl.opengl.GL11;

import minestrapteam.extracore.util.I18n;
import minestrapteam.extradims.alchemy.EnumHeatType;
import minestrapteam.extradims.inventory.ContainerAlchemyTable;
import minestrapteam.extradims.tileentity.TileEntityAlchemyTable;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiAlchemyTable extends GuiContainer
{
	public static final ResourceLocation	alchemyTableTexture	= new ResourceLocation("ed_alchemy", "textures/gui/container/alchemy_table.png");
	
	public TileEntityAlchemyTable			alchemyTable;
	
	public GuiAlchemyTable(EntityPlayer player, TileEntityAlchemyTable alchemyTable)
	{
		super(new ContainerAlchemyTable(player.inventory, alchemyTable));
		this.alchemyTable = alchemyTable;
		
		this.xSize = 256;
		this.ySize = 192;
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		EnumHeatType heatType = null;
		if (this.func_146978_c(13, 69, 14, 14, mouseX, mouseY))
		{
			heatType = this.alchemyTable.getHeatType(0);
		}
		else if (this.func_146978_c(67, 69, 14, 14, mouseX, mouseY))
		{
			heatType = this.alchemyTable.getHeatType(1);
		}
		else if (this.func_146978_c(193, 69, 14, 14, mouseX, mouseY))
		{
			heatType = this.alchemyTable.getHeatType(2);
		}
		else if (this.func_146978_c(38, 48, 16, 16, mouseX, mouseY))
		{
			this.drawCreativeTabHoveringText(String.format("%s: %.1f%%", I18n.getString("gui.progress"), this.alchemyTable.progressTime / this.alchemyTable.maxProgressTime * 100F), mouseX - this.guiLeft, mouseY - this.guiTop);
		}
		
		if (heatType != null)
		{
			this.drawCreativeTabHoveringText(heatType.getLocalizedName(), mouseX - this.guiLeft, mouseY - this.guiTop);
		}
		
		String title = EnumChatFormatting.YELLOW + I18n.getString("tile.alchemy_table.name");
		int width = this.fontRendererObj.getStringWidth(title);
		this.drawCreativeTabHoveringText(title, width / 2 + 4, 8);
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		// Render main background
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(alchemyTableTexture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
		EnumHeatType heatType;
		int i1;
		int i2;
		
		// Render progress arrow
		
		i1 = this.alchemyTable.getProgressScaled(16);
		this.drawTexturedModalRect(38, 48, 0, 207, i1, 16);
		
		// Render flames
		
		heatType = this.alchemyTable.getHeatType(0);
		i1 = this.alchemyTable.getEnergyTimeRemainingScaled(12, 0);
		this.drawTexturedModalRect(k + 13, l + 69 - i1, heatType.id * 14, 193 + 12 - i1, 14, i1 + 2);
		
		heatType = this.alchemyTable.getHeatType(1);
		i1 = this.alchemyTable.getEnergyTimeRemainingScaled(12, 1);
		this.drawTexturedModalRect(k + 67, l + 69 - i1, heatType.id * 14, 193 + 12 - i1, 14, i1 + 2);
		
		heatType = this.alchemyTable.getHeatType(2);
		i1 = this.alchemyTable.getEnergyTimeRemainingScaled(12, 2);
		this.drawTexturedModalRect(k + 193, l + 69 - i1, heatType.id * 14, 193 + 12 - i1, 14, i1 + 2);
		
		// Render bubbles
		
		i1 = this.alchemyTable.getProgressScaled(28);
		i2 = getBubbles(i1);
		this.drawTexturedModalRect(k + 102, l + 64 - i2, 0, 223 + 29 - i2, 12, i2);
		this.drawTexturedModalRect(k + 170, l + 64 - i2, 0, 223 + 29 - i2, 12, i2);
	}
	
	public int getBubbles(int scaledProgress)
	{
		if (scaledProgress > 0)
		{
			int i = scaledProgress / 2 % 7;
			
			switch (i)
			{
				case 0:
					return 29;
				case 1:
					return 24;
				case 2:
					return 20;
				case 3:
					return 16;
				case 4:
					return 11;
				case 5:
					return 6;
				case 6:
					return 0;
			}
		}
		return 0;
	}
}
