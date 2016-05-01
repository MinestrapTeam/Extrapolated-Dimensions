package minestrapteam.extradims.client.gui;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import minestrapteam.extradims.entity.EDEntityProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.input.Keyboard;

public class GuiPOCIngame extends GuiIngameForge
{
	public static ResourceLocation	mana	= new ResourceLocation("moredimensions", "textures/gui/mana.png");
	
	private final Minecraft			mc;

	public GuiPOCIngame(Minecraft mc)
	{
		super(mc);
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent.Post event)
	{
		if (event.type == ElementType.HOTBAR)
		{
			ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
			
			int width = res.getScaledWidth();
			int height = res.getScaledHeight();
			
			if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
			{
				return;
			}
			
			this.renderMana(width, height);
			this.renderLevels(width, height);
		}
	}
	
	protected void renderMana(int width, int height)
	{
		this.mc.mcProfiler.startSection("mana");
		
		if (!this.mc.thePlayer.capabilities.isCreativeMode || Keyboard.isKeyDown(Keyboard.KEY_I) && this.mc.inGameHasFocus)
		{
			this.mc.renderEngine.bindTexture(mana);
			// int left = width / 2 + 91;
			// int top = height - 49 -
			// (this.mc.thePlayer.isInsideOfMaterial(Material.water) ? 10 : 0);
			
			float mana = EDEntityProperties.get(this.mc.thePlayer).getMana();
			
			String text = Float.toString(mana);
			int x = (width - this.mc.fontRenderer.getStringWidth(text)) / 2;
			int y = height - 31 - 14;
			this.mc.fontRenderer.drawString(text, x + 1, y, 0);
			this.mc.fontRenderer.drawString(text, x - 1, y, 0);
			this.mc.fontRenderer.drawString(text, x, y + 1, 0);
			this.mc.fontRenderer.drawString(text, x, y - 1, 0);
			this.mc.fontRenderer.drawString(text, x, y, 5592575);
		}
		
		this.mc.mcProfiler.endSection();
	}
	
	public void renderLevels(int width, int height)
	{
		if (Keyboard.isKeyDown(Keyboard.KEY_I) && this.mc.inGameHasFocus)
		{
			EDEntityProperties props = EDEntityProperties.get(this.mc.thePlayer);
			int i = -9;
			int i1 = 11;
			
			this.mc.fontRenderer.drawString(String.format("Melee Level: %s%.2f", EnumChatFormatting.RED, props.getMeleeLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Defence Level: %s%.2f", EnumChatFormatting.BLACK, props.getDefenceLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Magic Level: %s%.2f", EnumChatFormatting.BLUE, props.getMagicLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Ranged Level: %s%.2f", EnumChatFormatting.DARK_GRAY, props.getRangedLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Digging Level: %s%.2f", EnumChatFormatting.DARK_RED, props.getDiggingLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Mining Level: %s%.2f", EnumChatFormatting.GRAY, props.getMiningLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Smithing Level: %s%.2f", EnumChatFormatting.DARK_GRAY, props.getSmithingLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Fishing Level: %s%.2f", EnumChatFormatting.AQUA, props.getFishingLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Cooking Level: %s%.2f", EnumChatFormatting.GOLD, props.getCookingLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Wood Cutting Level: %s%.2f", EnumChatFormatting.DARK_RED, props.getWoodCuttingLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Herblore Level: %s%.2f", EnumChatFormatting.DARK_GREEN, props.getHerbloreLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Thieving Level: %s%.2f", EnumChatFormatting.YELLOW, props.getThievingLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Slayer Level: %s%.2f", EnumChatFormatting.RED, props.getSlayerLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Farming Level: %s%.2f", EnumChatFormatting.GREEN, props.getFarmingLevel()), 2, i += i1, 0xFFFFFF, true);
			this.mc.fontRenderer.drawString(String.format("Sharing Level: %s%.2f", EnumChatFormatting.WHITE, props.getSharingLevel()), 2, i += i1, 0xFFFFFF, true);
		}
	}
}
