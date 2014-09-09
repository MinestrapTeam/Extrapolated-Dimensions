package minestrapteam.virtious.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.entity.EntityLaser;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLaser extends Render
{
	private static final ResourceLocation	texture	= new ResourceLocation("virtious", "textures/models/laser.png");
	
	public RenderLaser()
	{
		this.shadowSize = 0F;
	}
	
	public void renderLaser(EntityLaser entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		this.bindEntityTexture(entity);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTickTime - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTickTime, 0.0F, 0.0F, 1.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		Tessellator tessellator = Tessellator.instance;
		
		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(0.05625F, 0.05625F, 0.05625F);
		GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
		GL11.glNormal3f(0.05625F, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, 0F, 0.15625F);
		tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, 0.15625F, 0.15625F);
		tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, 0.15625F, 0.3125F);
		tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, 0F, 0.3125F);
		tessellator.draw();
		GL11.glNormal3f(-0.05625F, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, 0F, 0.15625F);
		tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, 0.15625F, 0.15625F);
		tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, 0.15625F, 0.3125F);
		tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, 0F, 0.3125F);
		tessellator.draw();
		
		for (int i = 0; i < 4; ++i)
		{
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, 0.05625F);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, 0F, 0F);
			tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, 0.5F, 0F);
			tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, 0.5F, 0.15625F);
			tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, 0F, 0.15625F);
			tessellator.draw();
		}
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		this.renderLaser((EntityLaser) entity, x, y, z, yaw, partialTickTime);
	}
}
