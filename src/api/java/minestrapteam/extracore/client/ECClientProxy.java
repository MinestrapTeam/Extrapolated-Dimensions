package minestrapteam.extracore.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.cape.CapeHelper;
import minestrapteam.extracore.cape.Capes;
import minestrapteam.extracore.cape.EmptyCape;
import minestrapteam.extracore.client.gui.GuiCreativeInventory;
import minestrapteam.extracore.client.gui.GuiModUpdates;
import minestrapteam.extracore.client.gui.GuiSurvivalInventory;
import minestrapteam.extracore.client.renderer.RenderPotion2;
import minestrapteam.extracore.client.renderer.block.RenderBlock2D;
import minestrapteam.extracore.client.renderer.block.RenderBlockBush;
import minestrapteam.extracore.client.renderer.block.RenderBlockMulti;
import minestrapteam.extracore.entity.EntityPotion2;
import minestrapteam.extracore.inventory.ContainerBrewingStand2;
import minestrapteam.extracore.inventory.ContainerCreativeList;
import minestrapteam.extracore.proxy.ECProxy;
import minestrapteam.extracore.tileentity.TileEntityBrewingStand2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

public class ECClientProxy extends ECProxy
{
	@Override
	public void init(FMLInitializationEvent event)
	{
		MULTI_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		BLOCK2D_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		CUSTOMBUSH_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();

		FMLCommonHandler.instance().bus().register(new ECClientEventHandler());

		RenderingRegistry.registerBlockHandler(MULTI_RENDER_ID, RenderBlockMulti.instance);
		RenderingRegistry.registerBlockHandler(BLOCK2D_RENDER_ID, RenderBlock2D.instance);
		RenderingRegistry.registerBlockHandler(CUSTOMBUSH_RENDER_ID, RenderBlockBush.instance);

		Capes.setLocalCape("AdrianKunz", new ResourceLocation("extracore", "textures/capes/cape_clashsoft.png"));
		Capes.noCape = Capes.addCape(new EmptyCape("no_cape"));
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GUI_BREWING_ID)
		{
			return new ContainerBrewingStand2(player.inventory, (TileEntityBrewingStand2) world.getTileEntity(x, y, z));
		}
		else if (ID == GUI_CREATIVE_ID)
		{
			return new GuiCreativeInventory(player, new ContainerCreativeList(player), this.replaceInventory(player));
		}
		else if (ID == GUI_SURVIVAL_ID)
		{
			return new GuiSurvivalInventory(player, this.replaceInventory(player));
		}
		return null;
	}

	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPotion2.class, new RenderPotion2());
	}

	@Override
	public void openMUScreen()
	{
		Minecraft mc = Minecraft.getMinecraft();
		mc.displayGuiScreen(new GuiModUpdates(mc.currentScreen));
	}

	@Override
	public void openGUI(Object gui)
	{
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) gui);
	}

	@Override
	public void setCape(EntityPlayer player, String capeName)
	{
		CapeHelper.updateCape(player, Capes.getCape(capeName));
	}

	@Override
	public boolean isClient()
	{
		return true;
	}

	@Override
	public World getClientWorld()
	{
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	public EntityPlayer getClientPlayer()
	{
		return Minecraft.getMinecraft().thePlayer;
	}

	// Potions

	@Override
	public void playSplashEffect(World world, double x, double y, double z, int color, boolean isInstant)
	{
		RenderGlobal renderGlobal = Minecraft.getMinecraft().renderGlobal;

		Random random = world.rand;
		String crackParticleName = "iconcrack_" + Item.getIdFromItem(ExtraCore.potion2);

		double distance;
		float colorMultiplier;
		double velocityX;
		double velocityY;
		double velocityZ;
		double velocityMultiplier;

		for (int i = 0; i < 8; ++i)
		{
			renderGlobal
				.spawnParticle(crackParticleName, x, y, z, random.nextGaussian() * 0.15D, random.nextDouble() * 0.2D,
				               random.nextGaussian() * 0.15D);
		}

		float r = (color >> 16 & 255) / 255.0F;
		float g = (color >> 8 & 255) / 255.0F;
		float b = (color & 255) / 255.0F;
		String particleName = isInstant ? "instantSpell" : "spell";

		for (int i = 0; i < 100; ++i)
		{
			velocityMultiplier = random.nextDouble() * 4.0D;
			distance = random.nextDouble() * Math.PI * 2.0D;
			velocityX = Math.cos(distance) * velocityMultiplier;
			velocityY = 0.01D + random.nextDouble() * 0.5D;
			velocityZ = Math.sin(distance) * velocityMultiplier;
			EntityFX entityfx = renderGlobal
				                    .doSpawnParticle(particleName, x + velocityX * 0.1D, y + 0.3D, z + velocityZ * 0.1D,
				                                     velocityX, velocityY, velocityZ);

			if (entityfx != null)
			{
				colorMultiplier = 0.75F + random.nextFloat() * 0.25F;
				entityfx.setRBGColorF(r * colorMultiplier, g * colorMultiplier, b * colorMultiplier);
				entityfx.multiplyVelocity((float) velocityMultiplier);
			}
		}
	}

	@Override
	public boolean isMinecraftClassName(String clazz)
	{
		return clazz.equals(Minecraft.class.getName());
	}
}
