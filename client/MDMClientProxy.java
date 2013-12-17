package clashsoft.mods.moredimensions.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;

import clashsoft.mods.moredimensions.api.IMDMBoss;
import clashsoft.mods.moredimensions.cape.CapeHelper;
import clashsoft.mods.moredimensions.client.gui.GuiBossChat;
import clashsoft.mods.moredimensions.client.gui.GuiHeavenMainMenu;
import clashsoft.mods.moredimensions.client.gui.GuiPOCIngame;
import clashsoft.mods.moredimensions.client.gui.GuiTome;
import clashsoft.mods.moredimensions.client.gui.container.GuiDamnationTable;
import clashsoft.mods.moredimensions.client.renderer.entity.RenderLich;
import clashsoft.mods.moredimensions.client.renderer.entity.RenderScider;
import clashsoft.mods.moredimensions.client.renderer.item.RenderPOCBows;
import clashsoft.mods.moredimensions.client.renderer.tileentity.RenderAlchemyTube;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import clashsoft.mods.moredimensions.entity.EntityScider;
import clashsoft.mods.moredimensions.entity.boss.EntityLich;
import clashsoft.mods.moredimensions.tileentity.TileEntityAlchemyTube;
import clashsoft.mods.moredimensions.tileentity.TileEntityDamnationTable;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;

public class MDMClientProxy extends MDMCommonProxy
{
	public Map<String, Integer>	armorFiles	= new HashMap<String, Integer>();
	
	public RenderPOCBows		bowRenderer;
	
	public static int			tubeRenderType;
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == BOSS_CHAT_GUIID)
		{
			return new GuiBossChat(player, (IMDMBoss) world.getEntityByID(x));
		}
		else if (ID == TOME_GUIID)
		{
			return new GuiTome();
		}
		else if (ID == DAMNATION_TABLE_GUIID)
		{
			return new GuiDamnationTable(player.inventory, (TileEntityDamnationTable) world.getBlockTileEntity(x, y, z));
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void replaceGUIs(GuiOpenEvent event)
	{
		if (event.gui.getClass() == GuiMainMenu.class)
		{
			event.setCanceled(true);
			Minecraft.getMinecraft().displayGuiScreen(new GuiHeavenMainMenu());
		}
	}
	
	@Override
	public void register()
	{
		// Tick Handlers
		super.register();
		TickRegistry.registerTickHandler(new MDMClientTickHandler(), Side.CLIENT);
		
		// Event Handlers
		MinecraftForge.EVENT_BUS.register(new MDMClientEventHandler());
		MinecraftForge.EVENT_BUS.register(new GuiPOCIngame(Minecraft.getMinecraft()));
		
		// Sounds
		this.installSound("streaming/PoC Menu.ogg");
		
		// Entity Renderers
		RenderingRegistry.registerEntityRenderingHandler(EntityLich.class, new RenderLich());
		RenderingRegistry.registerEntityRenderingHandler(EntityScider.class, new RenderScider());
		
		// Item Renderers
		MinecraftForgeClient.registerItemRenderer(Item.bow.itemID, this.bowRenderer = new RenderPOCBows());
		
		// Tile Entity Renderers
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemyTube.class, new RenderAlchemyTube());
		
		// Capes
		CapeHelper.addFileUrl("https://dl.dropboxusercontent.com/s/riyz6rte7ds9wm5/chaosdev.txt");
	}
	
	public void installSound(String filename)
	{
		Minecraft.getMinecraft().sndManager.addStreaming(filename);
	}
	
	@Override
	protected int getArmor(String name)
	{
		if (this.armorFiles.containsKey(name))
		{
			return this.armorFiles.get(name);
		}
		else
		{
			int result = RenderingRegistry.addNewArmourRendererPrefix(name);
			this.armorFiles.put(name, result);
			return result;
		}
	}
	
	@Override
	public void setCape(EntityPlayer player, String cape)
	{
		CapeHelper.setCape(Minecraft.getMinecraft().thePlayer, cape);
	}
	
	@Override
	public void setCape(EntityPlayer player, Packet250CustomPayload packet)
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(packet.data);
		DataInputStream dis = new DataInputStream(bis);
		
		try
		{
			String username = dis.readUTF();
			String capeName = dis.readUTF();
			
			EntityPlayer player1 = this.findPlayer(player.worldObj, username);
			this.setCape(player1, capeName);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
