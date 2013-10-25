package com.chaosdev.paradiseofchaos.client;

import com.chaosdev.paradiseofchaos.client.gui.GuiPOCIngame;
import com.chaosdev.paradiseofchaos.client.renderer.item.RenderPOCBows;
import com.chaosdev.paradiseofchaos.common.CommonProxy;
import com.chaosdev.paradiseofchaos.entity.boss.EntityLich;
import com.chaosdev.paradiseofchaos.lib.POCTickHandler;
import com.chaosdev.paradiseofchaos.tileentity.TileEntityAlchemyTube;
import com.chaosdev.paradiseofchaos.tileentity.render.RenderAlchemyTube;
import com.jadarstudios.developercapes.DevCapes;
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

public class ClientProxy extends CommonProxy
{
	public RenderPOCBows	bowRenderer;
	
	public static int		tubeRenderType;
	
	@Override
	public void registerRenderers()
	{
		String username = "";
		System.out.println(username = Minecraft.getMinecraft().getSession().getUsername());
		
		DevCapesUtil.addFileUrl("https://dl.dropboxusercontent.com/s/riyz6rte7ds9wm5/chaosdev.txt");
		DevCapes.getInstance().addUser(username, "dummy");
		
		TickRegistry.registerTickHandler(new POCTickHandler(), Side.CLIENT);
		
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
		MinecraftForge.EVENT_BUS.register(new POCClientEvents());
	}
	
	public void installSound(String filename)
	{
		Minecraft.getMinecraft().sndManager.addStreaming(filename);
	}
}
