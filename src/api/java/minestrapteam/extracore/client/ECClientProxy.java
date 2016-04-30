package minestrapteam.extracore.client;

import minestrapteam.extracore.cape.CapeHelper;
import minestrapteam.extracore.cape.Capes;
import minestrapteam.extracore.cape.EmptyCape;
import minestrapteam.extracore.client.gui.GuiModUpdates;
import minestrapteam.extracore.client.renderer.block.RenderBlock2D;
import minestrapteam.extracore.client.renderer.block.RenderBlockBush;
import minestrapteam.extracore.client.renderer.block.RenderBlockMulti;
import minestrapteam.extracore.proxy.ECProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ECClientProxy extends ECProxy
{
	@Override
	public void init(FMLInitializationEvent event)
	{
		MULTI_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		BLOCK2D_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		CUSTOMBUSH_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(MULTI_RENDER_ID, RenderBlockMulti.instance);
		RenderingRegistry.registerBlockHandler(BLOCK2D_RENDER_ID, RenderBlock2D.instance);
		RenderingRegistry.registerBlockHandler(CUSTOMBUSH_RENDER_ID, RenderBlockBush.instance);
		
		Capes.setLocalCape("AdrianKunz", new ResourceLocation("cslib", "textures/capes/cape_clashsoft.png"));
		Capes.noCape = Capes.addCape(new EmptyCape("no_cape"));
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
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
}
