package minestrapteam.extradims.client.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import minestrapteam.extracore.util.ReflectionUtils;
import minestrapteam.extracore.util.update.ECUpdate;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.FMLCommonHandler;
import minestrapteam.extradims.client.gui.button.GuiFrameButton;
import minestrapteam.extradims.client.gui.button.GuiAeriusButtonLanguage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class GuiMainMenuAerius extends GuiMainMenu
{
	public static final ResourceLocation	splashTexts					= new ResourceLocation("minecraft", "texts/splashes.txt");
	public static final ResourceLocation	minecraftTitleTextures		= new ResourceLocation("minecraft", "textures/gui/title/minecraft.png");
	public static final ResourceLocation	enderPortalEndSkyTextures	= new ResourceLocation("minecraft", "textures/environment/end_sky.png");
	public static final ResourceLocation	endPortalTextures			= new ResourceLocation("minecraft", "textures/entity/end_portal.png");
	private static final ResourceLocation[]	titlePanoramaPaths			= new ResourceLocation[] {
			new ResourceLocation("textures/gui/title/background/panorama_0.png"),
			new ResourceLocation("textures/gui/title/background/panorama_1.png"),
			new ResourceLocation("textures/gui/title/background/panorama_2.png"),
			new ResourceLocation("textures/gui/title/background/panorama_3.png"),
			new ResourceLocation("textures/gui/title/background/panorama_4.png"),
			new ResourceLocation("textures/gui/title/background/panorama_5.png") };
	private ResourceLocation				panoramaTextureLocation;
	
	public boolean							minceraft					= false;
	public int								panoramaTimer				= 0;
	public String							splashText;
	
	private DynamicTexture					viewportTexture;
	
	public Random							rand						= new Random();
	
	public GuiMainMenuAerius()
	{
		super();
		
		this.splashText = this.getRandomSplashText();
		this.minceraft = this.rand.nextFloat() < 1.0E-4F;
	}
	
	@Override
	public void updateScreen()
	{
		this.panoramaTimer++;
	}
	
	public String getRandomSplashText()
	{
		String s = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9)
		{
			s = "Happy birthday, ez!";
		}
		else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1)
		{
			s = "Happy birthday, Notch!";
		}
		else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
		{
			s = "Merry X-mas!";
		}
		else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
		{
			s = "Happy new year!";
		}
		else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
		{
			s = "OOoooOOOoooo! Spooky!";
		}
		else
		{
			BufferedReader bufferedreader = null;
			
			try
			{
				ArrayList arraylist = new ArrayList();
				bufferedreader = new BufferedReader(new InputStreamReader(Minecraft.getMinecraft().getResourceManager().getResource(splashTexts).getInputStream(), Charsets.UTF_8));
				
				while ((s = bufferedreader.readLine()) != null)
				{
					s = s.trim();
					
					if (!s.isEmpty())
					{
						arraylist.add(s);
					}
				}
				
				s = (String) arraylist.get(this.rand.nextInt(arraylist.size()));
			}
			catch (IOException ioexception)
			{
			}
			finally
			{
				if (bufferedreader != null)
				{
					try
					{
						bufferedreader.close();
					}
					catch (IOException ioexception1)
					{
					}
				}
			}
		}
		return s;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		this.viewportTexture = new DynamicTexture(256, 256);
		this.panoramaTextureLocation = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
		
		for (int i = 0; i < this.buttonList.size(); i++)
		{
			GuiButton oldButton = (GuiButton) this.buttonList.get(i);
			GuiButton newButton = null;
			
			if (oldButton.getClass() == GuiButton.class)
			{
				int width = ReflectionUtils.getValue(GuiButton.class, oldButton, 1);
				int height = ReflectionUtils.getValue(GuiButton.class, oldButton, 2);
				
				newButton = new GuiFrameButton(oldButton.id, oldButton.xPosition, oldButton.yPosition, width, height, oldButton.displayString);
			}
			else if (oldButton.getClass() == GuiButtonLanguage.class)
			{
				newButton = new GuiAeriusButtonLanguage(oldButton.id, oldButton.xPosition, oldButton.yPosition);
			}
			
			if (newButton != null)
			{
				newButton.enabled = oldButton.enabled;
				newButton.visible = oldButton.visible;
				
				this.buttonList.set(i, newButton);
			}
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTickTime)
	{
		this.renderSkybox(mouseX, mouseY, partialTickTime);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Tessellator tessellator = Tessellator.instance;
		int k = (this.width - 274) / 2;
		
		this.mc.getTextureManager().bindTexture(minecraftTitleTextures);
		
		// Minceraft
		if (this.minceraft)
		{
			this.drawTexturedModalRect(k, 30, 0, 0, 99, 44);
			this.drawTexturedModalRect(k + 99, 30, 129, 0, 27, 44);
			this.drawTexturedModalRect(k + 125, 30, 126, 0, 3, 44);
			this.drawTexturedModalRect(k + 128, 30, 99, 0, 26, 44);
			this.drawTexturedModalRect(k + 155, 30, 0, 45, 155, 44);
		}
		else
		{
			this.drawTexturedModalRect(k, 30, 0, 0, 155, 44);
			this.drawTexturedModalRect(k + 155, 30, 0, 45, 155, 44);
		}
		
		tessellator.setColorOpaque_I(16777215);
		GL11.glPushMatrix();
		GL11.glTranslatef(this.width / 2 + 90, 70.0F, 0.0F);
		GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
		float f1 = 1.8F - MathHelper.abs(MathHelper.sin(Minecraft.getSystemTime() % 1000L / 1000.0F * (float) Math.PI * 2.0F) * 0.1F);
		f1 = f1 * 100.0F / (this.fontRendererObj.getStringWidth(this.splashText) + 32);
		GL11.glScalef(f1, f1, f1);
		this.drawCenteredString(this.fontRendererObj, this.splashText, 0, -8, 0x00AAFF);
		GL11.glPopMatrix();
		String s = ECUpdate.CURRENT_VERSION;
		
		if (this.mc.isDemo())
		{
			s = s + " Demo";
		}
		
		List<String> brandings = Lists.reverse(FMLCommonHandler.instance().getBrandings(false));
		for (int i = 0; i < brandings.size(); i++)
		{
			String branding = brandings.get(i);
			if (!Strings.isNullOrEmpty(branding))
			{
				this.drawString(this.fontRendererObj, branding, 2, this.height - (10 + i * (this.fontRendererObj.FONT_HEIGHT + 1)), 16777215);
			}
		}
		
		String s1 = "Copyright Mojang AB. Do not distribute!";
		this.drawString(this.fontRendererObj, s1, this.width - this.fontRendererObj.getStringWidth(s1) - 2, this.height - 10, 16777215);
		
		for (k = 0; k < this.buttonList.size(); ++k)
		{
			GuiButton guibutton = (GuiButton) this.buttonList.get(k);
			guibutton.drawButton(this.mc, mouseX, mouseY);
		}
	}
	
	private void drawPanorama(int par1, int par2, float par3)
	{
		Tessellator tessellator = Tessellator.instance;
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		byte b0 = 8;
		
		for (int k = 0; k < b0 * b0; ++k)
		{
			GL11.glPushMatrix();
			float f1 = ((float) (k % b0) / (float) b0 - 0.5F) / 64.0F;
			float f2 = ((float) (k / b0) / (float) b0 - 0.5F) / 64.0F;
			float f3 = 0.0F;
			GL11.glTranslatef(f1, f2, f3);
			GL11.glRotatef(MathHelper.sin((this.panoramaTimer + par3) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-(this.panoramaTimer + par3) * 0.1F, 0.0F, 1.0F, 0.0F);
			
			for (int l = 0; l < 6; ++l)
			{
				GL11.glPushMatrix();
				
				if (l == 1)
				{
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
				}
				
				if (l == 2)
				{
					GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				}
				
				if (l == 3)
				{
					GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
				}
				
				if (l == 4)
				{
					GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
				}
				
				if (l == 5)
				{
					GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				}
				
				this.mc.getTextureManager().bindTexture(titlePanoramaPaths[l]);
				tessellator.startDrawingQuads();
				tessellator.setColorRGBA_I(16777215, 255 / (k + 1));
				float f4 = 0.0F;
				tessellator.addVertexWithUV(-1.0D, -1.0D, 1.0D, 0.0F + f4, 0.0F + f4);
				tessellator.addVertexWithUV(1.0D, -1.0D, 1.0D, 1.0F - f4, 0.0F + f4);
				tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0F - f4, 1.0F - f4);
				tessellator.addVertexWithUV(-1.0D, 1.0D, 1.0D, 0.0F + f4, 1.0F - f4);
				tessellator.draw();
				GL11.glPopMatrix();
			}
			
			GL11.glPopMatrix();
			GL11.glColorMask(true, true, true, false);
		}
		
		tessellator.setTranslation(0.0D, 0.0D, 0.0D);
		GL11.glColorMask(true, true, true, true);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}
	
	private void rotateAndBlurSkybox(float par1)
	{
		this.mc.getTextureManager().bindTexture(this.panoramaTextureLocation);
		GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColorMask(true, true, true, false);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		
		byte b0 = 3;
		
		for (int i = 0; i < b0; ++i)
		{
			tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (i + 1));
			int j = this.width;
			int k = this.height;
			float f1 = (i - b0 / 2) / 256.0F;
			tessellator.addVertexWithUV(j, k, this.zLevel, 0.0F + f1, 0.0D);
			tessellator.addVertexWithUV(j, 0.0D, this.zLevel, 1.0F + f1, 0.0D);
			tessellator.addVertexWithUV(0.0D, 0.0D, this.zLevel, 1.0F + f1, 1.0D);
			tessellator.addVertexWithUV(0.0D, k, this.zLevel, 0.0F + f1, 1.0D);
		}
		
		tessellator.draw();
		GL11.glColorMask(true, true, true, true);
	}
	
	private void renderSkybox(int par1, int par2, float par3)
	{
		GL11.glViewport(0, 0, 256, 256);
		this.drawPanorama(par1, par2, par3);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		
		GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		
		float f1 = this.width > this.height ? 120.0F / this.width : 120.0F / this.height;
		float f2 = this.height * f1 / 256.0F;
		float f3 = this.width * f1 / 256.0F;
		
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
		
		int k = this.width;
		int l = this.height;
		
		tessellator.addVertexWithUV(0.0D, l, this.zLevel, 0.5F - f2, 0.5F + f3);
		tessellator.addVertexWithUV(k, l, this.zLevel, 0.5F - f2, 0.5F - f3);
		tessellator.addVertexWithUV(k, 0.0D, this.zLevel, 0.5F + f2, 0.5F - f3);
		tessellator.addVertexWithUV(0.0D, 0.0D, this.zLevel, 0.5F + f2, 0.5F + f3);
		tessellator.draw();
	}
}
