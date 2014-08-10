package minestrapteam.extradims.client;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import minestrapteam.extradims.api.IMDMBoss;
import minestrapteam.extradims.client.gui.GuiBossChat;
import minestrapteam.extradims.client.gui.GuiPOCIngame;
import minestrapteam.extradims.client.gui.GuiTome;
import minestrapteam.extradims.client.gui.container.GuiAlchemyTable;
import minestrapteam.extradims.client.gui.container.GuiDamnationTable;
import minestrapteam.extradims.client.renderer.entity.RenderLich;
import minestrapteam.extradims.client.renderer.item.RenderPOCBows;
import minestrapteam.extradims.client.renderer.tileentity.RenderAlchemyTube;
import minestrapteam.extradims.client.sound.MDMSoundHandler;
import minestrapteam.extradims.common.MDMProxy;
import minestrapteam.extradims.entity.boss.EntityLich;
import minestrapteam.extradims.tileentity.TileEntityAlchemyTable;
import minestrapteam.extradims.tileentity.TileEntityAlchemyTube;
import minestrapteam.extradims.tileentity.TileEntityDamnationTable;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class MDMClientProxy extends MDMProxy
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
			return new GuiDamnationTable(player.inventory, (TileEntityDamnationTable) world.getTileEntity(x, y, z));
		}
		else if (ID == ALCHEMY_TABLE_GUIID)
		{
			return new GuiAlchemyTable(player, (TileEntityAlchemyTable) world.getTileEntity(x, y, z));
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		// Event Handlers
		MinecraftForge.EVENT_BUS.register(new MDMClientEvents());
		MinecraftForge.EVENT_BUS.register(new GuiPOCIngame(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(MDMSoundHandler.instance);
		
		// Entity Renderers
		RenderingRegistry.registerEntityRenderingHandler(EntityLich.class, new RenderLich());
		
		// Item Renderers
		this.bowRenderer = new RenderPOCBows();
		MinecraftForgeClient.registerItemRenderer(Items.bow, this.bowRenderer);
		
		// Tile Entity Renderers
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemyTube.class, new RenderAlchemyTube());
		
		// Capes
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
}
