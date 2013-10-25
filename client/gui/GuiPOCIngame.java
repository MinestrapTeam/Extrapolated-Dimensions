package com.chaosdev.paradiseofchaos.client.gui;

import org.lwjgl.input.Keyboard;

import com.chaosdev.paradiseofchaos.lib.POCEntityProperties;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.ForgeSubscribe;

public class GuiPOCIngame extends GuiIngameForge
{
	public static ResourceLocation	mana	= new ResourceLocation("paradiseofchaos/gui/mana.png");
	
	private final Minecraft			mc;
	private ScaledResolution	res;
	
	public GuiPOCIngame(Minecraft mc)
	{
		super(mc);
		this.mc = mc;
	}
	
	@ForgeSubscribe
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();
		
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		
		renderMana(width, height);
		renderLevels(width, height);
	}
	
	protected void renderMana(int width, int height)
	{
		mc.mcProfiler.startSection("mana");
		
		if (!mc.thePlayer.capabilities.isCreativeMode || Keyboard.isKeyDown(Keyboard.KEY_I))
		{
			mc.renderEngine.bindTexture(mana);
			int left = width / 2 + 91;
			int top = height - 49 - (mc.thePlayer.isInsideOfMaterial(Material.water) ? 10 : 0);
			
			float mana = POCEntityProperties.getEntityProperties(mc.thePlayer).getMana();
			
			int color = 5592575;
			String text = "" + mana;
			int x = (width - mc.fontRenderer.getStringWidth(text)) / 2;
			int y = height - 31 - 14;
			mc.fontRenderer.drawString(text, x + 1, y, 0);
			mc.fontRenderer.drawString(text, x - 1, y, 0);
			mc.fontRenderer.drawString(text, x, y + 1, 0);
			mc.fontRenderer.drawString(text, x, y - 1, 0);
			mc.fontRenderer.drawString(text, x, y, color);
		}
		
		mc.mcProfiler.endSection();
	}
	
	public void renderLevels(int width, int height)
	{
		if (Keyboard.isKeyDown(Keyboard.KEY_I))
		{
			POCEntityProperties props = POCEntityProperties.getEntityProperties(mc.thePlayer);
			int i1 = 11;
			int i = -i1 + 2;
			
			mc.fontRenderer.drawString(String.format("Melee Level: %s%s (%.2f)", EnumChatFormatting.RED, "TEST", props.getMeleeLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Defence Level: %s%.2f", EnumChatFormatting.BLACK, props.getDefenceLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Magic Level: %s%.2f", EnumChatFormatting.BLUE, props.getMagicLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Ranged Level: %s%.2f", EnumChatFormatting.DARK_GRAY, props.getRangedLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Digging Level: %s%.2f", EnumChatFormatting.DARK_RED, props.getDiggingLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Mining Level: %s%.2f", EnumChatFormatting.GRAY, props.getMiningLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Smithing Level: %s%.2f", EnumChatFormatting.DARK_GRAY, props.getSmithingLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Fishing Level: %s%.2f", EnumChatFormatting.AQUA, props.getFishingLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Cooking Level: %s%.2f", EnumChatFormatting.GOLD, props.getCookingLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Wood Cutting Level: %s%.2f", EnumChatFormatting.DARK_RED, props.getWoodCuttingLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Herblore Level: %s%.2f", EnumChatFormatting.DARK_GREEN, props.getHerbloreLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Thieving Level: %s%.2f", EnumChatFormatting.YELLOW, props.getThievingLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Slayer Level: %s%.2f", EnumChatFormatting.RED, props.getSlayerLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Farming Level: %s%.2f", EnumChatFormatting.GREEN, props.getFarmingLevel()), 2, i += i1, 0xFFFFFF, true);
			mc.fontRenderer.drawString(String.format("Sharing Level: %s%.2f", EnumChatFormatting.WHITE, props.getSharingLevel()), 2, i += i1, 0xFFFFFF, true);
		}
	}
}
