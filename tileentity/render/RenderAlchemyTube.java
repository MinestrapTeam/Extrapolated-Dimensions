package com.chaosdev.paradiseofchaos.tileentity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import clashsoft.mods.moredimensions.block.BlockAlchemyTube;

import com.chaosdev.paradiseofchaos.tileentity.TileEntityAlchemyTube;

public class RenderAlchemyTube extends TileEntitySpecialRenderer
{
	private ModelAlchemyTube	model	= new ModelAlchemyTube();
	private ResourceLocation	tex		= new ResourceLocation("textures/models/alchemytube.png");
	
	public void renderTileEntityAt(TileEntityAlchemyTube tileentity, double par2, double par4, double par6, float par8)
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(tex);
		GL11.glTranslatef((float) par2 + 0.5F, (float) par4 - 0.5F, (float) par6 + 0.5F);
		
		boolean[] bs = BlockAlchemyTube.getConnections(tileentity.worldObj, tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.model.renderAll(bs[0], bs[1], bs[2], bs[3], bs[4], bs[5]);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double par2, double par4, double par6, float par8)
	{
		renderTileEntityAt((TileEntityAlchemyTube) tileentity, par2, par4, par6, par8);
	}
}
