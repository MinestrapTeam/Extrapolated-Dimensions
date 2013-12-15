package clashsoft.mods.moredimensions.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import clashsoft.mods.moredimensions.client.model.ModelLich;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLich extends RenderBiped
{
	private static final ResourceLocation	skeletonTextures		= new ResourceLocation("textures/entity/skeleton/skeleton.png");
	private static final ResourceLocation	witherSkeletonTextures	= new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
	
	public RenderLich()
	{
		super(new ModelLich(), 0.5F);
	}
	
	@Override
	protected void func_82422_c()
	{
		GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
	}
	
	protected ResourceLocation getSkeletonTexture(EntitySkeleton skeleton)
	{
		return skeleton.getSkeletonType() == 1 ? witherSkeletonTextures : skeletonTextures;
	}
	
	@Override
	protected ResourceLocation func_110856_a(EntityLiving living)
	{
		return this.getSkeletonTexture((EntitySkeleton) living);
	}
	
	/**
	 * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args: entityLiving, partialTickTime
	 */
	@Override
	protected void preRenderCallback(EntityLivingBase living, float partialTickTime)
	{
		
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getSkeletonTexture((EntitySkeleton) entity);
	}
}
