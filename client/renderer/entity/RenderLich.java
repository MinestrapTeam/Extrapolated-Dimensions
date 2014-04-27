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
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.getSkeletonTexture((EntitySkeleton) living);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase living, float partialTickTime)
	{
		
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getSkeletonTexture((EntitySkeleton) entity);
	}
}
