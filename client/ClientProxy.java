package clashsoft.mods.moredimensions.client;

import com.jadarstudios.developercapes.DevCapes;
import com.jadarstudios.developercapes.DevCapesUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import clashsoft.mods.moredimensions.client.gui.GuiPOCIngame;
import clashsoft.mods.moredimensions.client.renderer.entity.RenderScider;
import clashsoft.mods.moredimensions.client.renderer.item.RenderPOCBows;
import clashsoft.mods.moredimensions.common.CommonProxy;
import clashsoft.mods.moredimensions.entity.EntityScider;
import clashsoft.mods.moredimensions.entity.boss.EntityLich;
import clashsoft.mods.moredimensions.lib.POCTickHandler;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTube;
import clashsoft.mods.moredimensions.tileentity.render.RenderAlchemyTube;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
	public RenderPOCBows	bowRenderer;
	
	public static int		tubeRenderType;

	public ClientProxy()
	{
		
	}
	
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityScider.class, new RenderScider());
		sywoxite = RenderingRegistry.addNewArmourRendererPrefix("sywoxite");
		
		//FIXME
		
		String username = "";
		System.out.println(username = Minecraft.getMinecraft().getSession().getUsername());
		
		DevCapesUtil.addFileUrl("https://dl.dropboxusercontent.com/s/riyz6rte7ds9wm5/chaosdev.txt");
		DevCapes.getInstance().addUser(username, "dummy");
		
		//FIXME
		
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
