package minestrapteam.virtious.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.entity.EntityNative;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNative extends RenderLiving
{
	private static final ResourceLocation	texture		= new ResourceLocation("virtious:textures/models/Native.png");
	private static final ResourceLocation	glowTexture	= new ResourceLocation("virtious:textures/models/Native_glow.png");
	
	public RenderNative(ModelBase modelBase, float size)
	{
		super(modelBase, size);
		this.renderPassModel = modelBase;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
	
	protected int renderGlowing(EntityNative entity, int pass, float partialTickTime)
	{
		if (pass != 0)
		{
			return -1;
		}
		
		this.bindTexture(glowTexture);
		float f1 = 1.0F;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		if (entity.isInvisible())
		{
			GL11.glDepthMask(false);
		}
		else
		{
			GL11.glDepthMask(true);
		}
		
		char c0 = 61680;
		int j = c0 % 65536;
		int k = c0 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j, k);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
		return 1;
	}
	
	@Override
	protected int shouldRenderPass(EntityLivingBase entity, int pass, float partialTickTime)
	{
		return this.renderGlowing((EntityNative) entity, pass, partialTickTime);
	}
}
