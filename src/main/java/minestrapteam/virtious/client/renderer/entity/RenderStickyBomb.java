package minestrapteam.virtious.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class RenderStickyBomb extends Render
{
	private static final ResourceLocation	texture	= new ResourceLocation("virtious", "textures/models/sticky_bomb.png");
	private static final ResourceLocation	model	= new ResourceLocation("virtious", "models/sticky_bomb.obj");
	
	private static IModelCustom				renderModel;
	
	public RenderStickyBomb()
	{
		this.shadowSize = 0.15F;
		this.shadowOpaque = 0.75F;
		
		renderModel = AdvancedModelLoader.loadModel(model);
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		
		render();
		
		GL11.glPopMatrix();
	}
	
	public static void render()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.renderAll();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
