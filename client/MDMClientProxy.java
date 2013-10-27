package clashsoft.mods.moredimensions.client;

import java.util.HashMap;
import java.util.Map;

import clashsoft.mods.moredimensions.client.gui.GuiPOCIngame;
import clashsoft.mods.moredimensions.client.renderer.entity.RenderScider;
import clashsoft.mods.moredimensions.client.renderer.item.RenderPOCBows;
import clashsoft.mods.moredimensions.client.renderer.tileentity.RenderAlchemyTube;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.entity.EntityScider;
import clashsoft.mods.moredimensions.entity.boss.EntityLich;
import clashsoft.mods.moredimensions.handlers.MDMTickHandler;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTube;

import com.jadarstudios.developercapes.DevCapesUtil;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class MDMClientProxy extends MDMCommonProxy
{
	public Map<String, Integer> armorFiles = new HashMap<String, Integer>();
	
	public RenderPOCBows	bowRenderer;
	
	public static int		tubeRenderType;

	public MDMClientProxy()
	{
		
	}
	
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityScider.class, new RenderScider());
		shrekite = RenderingRegistry.addNewArmourRendererPrefix("shrekite");
		
		String username = "";
		System.out.println(username = Minecraft.getMinecraft().getSession().getUsername());
		
		DevCapesUtil.addFileUrl("https://dl.dropboxusercontent.com/s/riyz6rte7ds9wm5/chaosdev.txt");
		
		TickRegistry.registerTickHandler(new MDMTickHandler(), Side.CLIENT);
		
		bowRenderer = new RenderPOCBows();
		
		Minecraft mc = Minecraft.getMinecraft();
		installSound("streaming/PoC Menu.ogg");
		
		MinecraftForgeClient.registerItemRenderer(Item.bow.itemID, bowRenderer);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemyTube.class, new RenderAlchemyTube());
	}
	
	@Override
	public void postRegisterRenderers()
	{
		MinecraftForge.EVENT_BUS.register(new GuiPOCIngame(Minecraft.getMinecraft()));
	}
	
	@Override
	public void registerEntityRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityLich.class, new RenderCreeper());
	}
	
	@Override
	public void registerClientEvents()
	{
		MinecraftForge.EVENT_BUS.register(new MDMClientEventHandler());
	}
	
	public void installSound(String filename)
	{
		Minecraft.getMinecraft().sndManager.addStreaming(filename);
	}
	
	@Override
	protected int getArmor(String name)
	{
		if (armorFiles.containsKey(name))
			return armorFiles.get(name);
		else
		{
			int result = RenderingRegistry.addNewArmourRendererPrefix(name);
			armorFiles.put(name, result);
			return result;
		}
	}
}
