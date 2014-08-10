package minestrapteam.extradims.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiPOCCredits extends GuiScreen
{
	private static final ResourceLocation	title			= new ResourceLocation("textures/gui/title/minecraft.png");
	private static final ResourceLocation	vignette		= new ResourceLocation("textures/misc/vignette.png");
	
	private final GuiScreen					parentGUI;
	private final boolean					respawn;
	
	/** Counts the number of screen updates. */
	private int								updateCounter	= 0;
	
	/** List of lines on the ending poem and credits. */
	private List							lines;
	private int								length			= 0;
	private final float						field_73987_d	= 0.5F;
	
	public GuiPOCCredits(GuiScreen parent)
	{
		this(parent, false);
	}
	
	public GuiPOCCredits(GuiScreen parent, boolean respawn)
	{
		this.parentGUI = parent;
		this.respawn = respawn;
	}
	
	@Override
	public void updateScreen()
	{
		this.updateCounter += 2;
		float f = (this.length + this.height + this.height + 24) / this.field_73987_d;
		
		if (this.updateCounter > f)
		{
			if (this.respawn)
				this.respawnPlayer();
			else
				this.mc.displayGuiScreen(this.parentGUI);
		}
	}
	
	/**
	 * Respawns the player.
	 */
	private void respawnPlayer()
	{
		this.mc.thePlayer.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
	    this.mc.displayGuiScreen(null);
	}
	
	/**
	 * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
	 */
	@Override
	protected void keyTyped(char c, int key)
	{
		if (key == 1)
		{
			if (this.respawn)
				this.respawnPlayer();
			else
				this.mc.displayGuiScreen(this.parentGUI);
		}
	}
	
	/**
	 * Returns true if this GUI should pause the game when it is displayed in single-player
	 */
	@Override
	public boolean doesGuiPauseGame()
	{
		return true;
	}
	
	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui()
	{
		if (this.lines == null)
		{
			this.lines = new ArrayList();
			
			String[] lines = new String[] {
					"[C]\u00a7f===============",
					"[C]\u00a7eMore Dimensions Mod Credits",
					"[C]\u00a7f===============",
					"",
					"\u00a77Idea:",
					"\u00a7f            xXSHREKKIDXx",
					"",
					"\u00a77Coding",
					"\u00a7f            Clashsoft",
					"\u00a7f            xXSHREKKIDXx",
					"",
					"\u00a77Art, Models & Textures",
					"\u00a7f            Complete_zero",
					"\u00a7f            xXSHREKKIDXx",
					"",
					"\u00a77Concept & Ideas",
					"\u00a7f            shadowlink1996",
					"",
					"",
					"", };
			
			for (String s : lines)
				this.lines.add(s);
			this.length = this.lines.size() * 12;
		}
	}
	
	private void func_73986_b(int mouseX, int mouseY, float partialTickTime)
	{
		Tessellator tessellator = Tessellator.instance;
		this.mc.renderEngine.bindTexture(Gui.optionsBackground);
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
		int k = this.width;
		float f1 = 0.0F - (this.updateCounter + partialTickTime) * 0.5F * this.field_73987_d;
		float f2 = this.height - (this.updateCounter + partialTickTime) * 0.5F * this.field_73987_d;
		float f3 = 0.015625F;
		float f4 = (this.updateCounter + partialTickTime - 0.0F) * 0.02F;
		float f5 = (this.length + this.height + this.height + 24) / this.field_73987_d;
		float f6 = (f5 - 20.0F - (this.updateCounter + partialTickTime)) * 0.005F;
		
		if (f6 < f4)
		{
			f4 = f6;
		}
		
		if (f4 > 1.0F)
		{
			f4 = 1.0F;
		}
		
		f4 *= f4;
		f4 = f4 * 96.0F / 255.0F;
		tessellator.setColorOpaque_F(f4, f4, f4);
		tessellator.addVertexWithUV(0.0D, this.height, this.zLevel, 0.0D, f1 * f3);
		tessellator.addVertexWithUV(k, this.height, this.zLevel, k * f3, f1 * f3);
		tessellator.addVertexWithUV(k, 0.0D, this.zLevel, k * f3, f2 * f3);
		tessellator.addVertexWithUV(0.0D, 0.0D, this.zLevel, 0.0D, f2 * f3);
		tessellator.draw();
	}
	
	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTickTime)
	{
		this.func_73986_b(mouseX, mouseY, partialTickTime);
		Tessellator tessellator = Tessellator.instance;
		int k = this.width / 2 - 137;
		int l = this.height + 50;
		float f1 = -(this.updateCounter + partialTickTime) * this.field_73987_d;
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, f1, 0.0F);
		this.mc.renderEngine.bindTexture(title);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(k, l, 0, 0, 155, 44);
		this.drawTexturedModalRect(k + 155, l, 0, 45, 155, 44);
		tessellator.setColorOpaque_I(16777215);
		int i1 = l + 200;
		int j1;
		
		for (j1 = 0; j1 < this.lines.size(); ++j1)
		{
			if (j1 == this.lines.size() - 1)
			{
				float f2 = i1 + f1 - (this.height / 2 - 6);
				
				if (f2 < 0.0F)
				{
					GL11.glTranslatef(0.0F, -f2, 0.0F);
				}
			}
			
			if (i1 + f1 + 12.0F + 8.0F > 0.0F && i1 + f1 < this.height)
			{
				String s = (String) this.lines.get(j1);
				
				if (s.startsWith("[C]"))
				{
					s = s.substring(3);
					this.fontRendererObj.drawStringWithShadow(s, k + (274 - this.fontRendererObj.getStringWidth(s)) / 2, i1, 16777215);
				}
				else
				{
					this.fontRendererObj.fontRandom.setSeed(j1 * 4238972211L + this.updateCounter / 4);
					this.fontRendererObj.drawStringWithShadow(s, k, i1, 16777215);
				}
			}
			
			i1 += 12;
		}
		
		GL11.glPopMatrix();
		this.mc.renderEngine.bindTexture(vignette);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ZERO, GL11.GL_ONE_MINUS_SRC_COLOR);
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
		j1 = this.width;
		int k1 = this.height;
		tessellator.addVertexWithUV(0.0D, k1, this.zLevel, 0.0D, 1.0D);
		tessellator.addVertexWithUV(j1, k1, this.zLevel, 1.0D, 1.0D);
		tessellator.addVertexWithUV(j1, 0.0D, this.zLevel, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, this.zLevel, 0.0D, 0.0D);
		tessellator.draw();
		GL11.glDisable(GL11.GL_BLEND);
		super.drawScreen(mouseX, mouseY, partialTickTime);
	}
}