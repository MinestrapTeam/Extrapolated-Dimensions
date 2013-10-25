package clashsoft.mods.moredimensions.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import clashsoft.mods.moredimensions.client.model.ModelScider;
import clashsoft.mods.moredimensions.entity.EntityScider;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderScider extends RenderLiving
{
	public RenderScider()
	{
		super(new ModelScider(), 1.0F);
		this.setRenderPassModel(new ModelScider());
	}
	
	protected float setSciderDeathMaxRotation(EntityScider par1EntityScider)
	{
		return 180.0F;
	}
	
	/**
	 * Sets the spider's glowing eyes
	 */
	protected int setSciderEyeBrightness(EntityScider par1EntityScider, int par2, float par3)
	{
		if (par2 != 0)
		{
			return -1;
		}
		else
		{
			this.bindTexture(getEntityTexture(par1EntityScider));
			float var4 = 1.0F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			char var5 = 61680;
			int var6 = var5 % 65536;
			int var7 = var5 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, var6 / 1.0F, var7 / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
			return 1;
		}
	}
	
	protected void scaleScider(EntityScider par1EntityScider, float par2)
	{
		float var3 = par1EntityScider.sciderScaleAmount();
		GL11.glScalef(var3, var3, var3);
	}
	
	/**
	 * Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime
	 */
	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
	{
		this.scaleScider((EntityScider) par1EntityLiving, par2);
	}
	
	protected float getDeathMaxRotation(EntityLiving par1EntityLiving)
	{
		return this.setSciderDeathMaxRotation((EntityScider) par1EntityLiving);
	}
	
	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.setSciderEyeBrightness((EntityScider) par1EntityLiving, par2, par3);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}
