package minestrapteam.virtious.client.renderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.lib.VWorld;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;

public class VirtiousSkyRenderer extends IRenderHandler
{
	public static VirtiousSkyRenderer		instance		= new VirtiousSkyRenderer();
	
	private static final ResourceLocation	TEXTURE_MOON	= new ResourceLocation("virtious:textures/environment/Earth.png");
	private static final ResourceLocation	TEXTURE_SUN		= new ResourceLocation("virtious:textures/environment/Sun.png");
	private static final ResourceLocation	TEXTURE_CLOUDS	= new ResourceLocation("textures/environment/clouds.png");
	private static final ResourceLocation	TEXTURE_SKY		= new ResourceLocation("virtious:textures/environment/nightsky.png");
	private static final ResourceLocation	TEXTURE_SKY2	= new ResourceLocation("virtious:textures/environment/nightsky_2.png");
	
	@Override
	@SideOnly(Side.CLIENT)
	public void render(float partialTicks, WorldClient world, Minecraft mc)
	{
		if (mc.theWorld.provider.dimensionId != VWorld.dimensionID)
		{
			return;
		}
		
		Tessellator tessellator = Tessellator.instance;
		float f18 = world.getStarBrightness(partialTicks) * (1.0F - world.getRainStrength(partialTicks));// sky
																											// opacity
		if (f18 > 0.0F)
		{
			GL11.glColor4f(f18, f18, f18, f18);
			renderNightSky(partialTicks, mc);
		}
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		Vec3 vec3 = world.getSkyColor(mc.renderViewEntity, partialTicks);
		float f1 = (float) vec3.xCoord;
		float f2 = (float) vec3.yCoord;
		float f3 = (float) vec3.zCoord;
		float f4;
		if (mc.gameSettings.anaglyph)
		{
			float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
			float f6 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
			f4 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
			f1 = f5;
			f2 = f6;
			f3 = f4;
		}
		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		RenderHelper.disableStandardItemLighting();
		float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);
		float f7;
		float f8;
		float f9;
		float f10;
		if (afloat != null)
		{
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glShadeModel(GL11.GL_SMOOTH);
			GL11.glPushMatrix();
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(MathHelper.sin(world.getCelestialAngleRadians(partialTicks)) < 0.0F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			f4 = afloat[0];
			f7 = afloat[1];
			f8 = afloat[2];
			float f11;
			
			if (mc.gameSettings.anaglyph)
			{
				f9 = (f4 * 30.0F + f7 * 59.0F + f8 * 11.0F) / 100.0F;
				f10 = (f4 * 30.0F + f7 * 70.0F) / 100.0F;
				f11 = (f4 * 30.0F + f8 * 70.0F) / 100.0F;
				f4 = f9;
				f7 = f10;
				f8 = f11;
			}
			
			tessellator.startDrawing(6);
			tessellator.setColorRGBA_F(f4, f7, f8, afloat[3]);
			tessellator.addVertex(0.0D, 100.0D, 0.0D);
			byte b0 = 16;
			tessellator.setColorRGBA_F(afloat[0], afloat[1], afloat[2], 0.0F);
			
			for (int j = 0; j <= b0; ++j)
			{
				f11 = j * (float) Math.PI * 2.0F / b0;
				float f12 = MathHelper.sin(f11);
				float f13 = MathHelper.cos(f11);
				tessellator.addVertex(f12 * 120.0F, f13 * 120.0F, -f13 * 40.0F * afloat[3]);
			}
			
			tessellator.draw();
			GL11.glPopMatrix();
			GL11.glShadeModel(GL11.GL_FLAT);
		}
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		GL11.glPushMatrix();
		f4 = 1.0F - world.getRainStrength(partialTicks);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f4);
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		f10 = 30.0F;
		mc.renderEngine.bindTexture(TEXTURE_SUN);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((-f10), 100.0D, (-f10), 0.0D, 0.0D);
		tessellator.addVertexWithUV(f10, 100.0D, (-f10), 1.0D, 0.0D);
		tessellator.addVertexWithUV(f10, 100.0D, f10, 1.0D, 1.0D);
		tessellator.addVertexWithUV((-f10), 100.0D, f10, 0.0D, 1.0D);
		tessellator.draw();
		f10 = 20.0F;
		mc.renderEngine.bindTexture(TEXTURE_MOON);
		int k = world.getMoonPhase();
		int l = k % 4;
		int i1 = k / 4 % 2;
		float f14 = (l + 0) / 4.0F;
		float f15 = (i1 + 0) / 2.0F;
		float f16 = (l + 1) / 4.0F;
		float f17 = (i1 + 1) / 2.0F;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((-f10), -100.0D, f10, f16, f17);
		tessellator.addVertexWithUV(f10, -100.0D, f10, f14, f17);
		tessellator.addVertexWithUV(f10, -100.0D, (-f10), f14, f15);
		tessellator.addVertexWithUV((-f10), -100.0D, (-f10), f16, f15);
		tessellator.draw();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glPopMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(0.0F, 0.0F, 0.0F);
		if (world.provider.isSkyColored())
		{
			GL11.glColor3f(f1 * 0.2F + 0.04F, f2 * 0.2F + 0.04F, f3 * 0.6F + 0.1F);
		}
		else
		{
			GL11.glColor3f(f1, f2, f3);
		}
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(true);
	}
	
	private void renderNightSky(float partialTicks, Minecraft mc)
	{
		
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		RenderHelper.disableStandardItemLighting();
		GL11.glDepthMask(false);
		mc.renderEngine.bindTexture(TEXTURE_SKY);
		
		Tessellator tessellator = Tessellator.instance;
		
		for (int i = 0; i < 6; ++i)
		{
			GL11.glPushMatrix();
			
			if (i == 1)
			{
				GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			}
			
			if (i == 2)
			{
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
			}
			
			if (i == 3)
			{
				GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			}
			
			if (i == 4)
			{
				GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			}
			
			if (i == 5)
			{
				mc.renderEngine.bindTexture(TEXTURE_SKY);
				GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
			}
			
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-100.0D, -100.0D, -100.0D, 0.0D, 0.0D);
			tessellator.addVertexWithUV(-100.0D, -100.0D, 100.0D, 0.0D, 2.0D);
			tessellator.addVertexWithUV(100.0D, -100.0D, 100.0D, 2.0D, 2.0D);
			tessellator.addVertexWithUV(100.0D, -100.0D, -100.0D, 2.0D, 0.0D);
			tessellator.draw();
			GL11.glPopMatrix();
		}
		
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
	}
}
