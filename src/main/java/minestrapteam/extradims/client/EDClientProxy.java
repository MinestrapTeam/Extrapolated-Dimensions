package minestrapteam.extradims.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import minestrapteam.extradims.api.IChatEntity;
import minestrapteam.extradims.client.gui.GuiBossChat;
import minestrapteam.extradims.client.gui.GuiPOCIngame;
import minestrapteam.extradims.client.gui.GuiTome;
import minestrapteam.extradims.client.gui.container.GuiAlchemyTable;
import minestrapteam.extradims.client.gui.container.GuiDamnationTable;
import minestrapteam.extradims.client.model.ModelBurfalaunt;
import minestrapteam.extradims.client.model.ModelNative;
import minestrapteam.extradims.client.renderer.block.RenderGlowingBlock;
import minestrapteam.extradims.client.renderer.entity.*;
import minestrapteam.extradims.client.renderer.item.RenderItemStickyBomb;
import minestrapteam.extradims.client.renderer.item.RenderPOCBows;
import minestrapteam.extradims.client.renderer.tileentity.RenderAlchemyTube;
import minestrapteam.extradims.client.sound.EDSoundHandler;
import minestrapteam.extradims.common.EDProxy;
import minestrapteam.extradims.entity.EntityBurfalaunt;
import minestrapteam.extradims.entity.EntityLaser;
import minestrapteam.extradims.entity.EntityNative;
import minestrapteam.extradims.entity.EntityNativeSkeleton;
import minestrapteam.extradims.entity.boss.EntityLich;
import minestrapteam.extradims.entity.item.EntityStickyBomb;
import minestrapteam.extradims.lib.virtious.VItems;
import minestrapteam.extradims.tileentity.TileEntityAlchemyTable;
import minestrapteam.extradims.tileentity.TileEntityAlchemyTube;
import minestrapteam.extradims.tileentity.TileEntityDamnationTable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import java.util.HashMap;
import java.util.Map;

public class EDClientProxy extends EDProxy
{
	public Map<String, Integer>	armorFiles	= new HashMap<>();
	
	public RenderPOCBows		bowRenderer;
	
	public static int			tubeRenderType;
	public static int			lightStripRenderType;
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		// Event Handlers
		MinecraftForge.EVENT_BUS.register(new EDClientEvents());
		MinecraftForge.EVENT_BUS.register(new GuiPOCIngame(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(EDSoundHandler.instance);
		
		// Entity Renderers
		RenderingRegistry.registerEntityRenderingHandler(EntityLich.class, new RenderLich());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBurfalaunt.class, new RenderBurfalaunt(new ModelBurfalaunt(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNative.class, new RenderNative(new ModelNative(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNativeSkeleton.class, new RenderNativeSkeleton(new ModelNative(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaser());
		RenderingRegistry.registerEntityRenderingHandler(EntityStickyBomb.class, new RenderStickyBomb());
		
		// Item Renderers
		this.bowRenderer = new RenderPOCBows();
		MinecraftForgeClient.registerItemRenderer(Items.bow, this.bowRenderer);
		MinecraftForgeClient.registerItemRenderer(VItems.sticky_bomb, new RenderItemStickyBomb());
		
		// Tile Entity Renderers
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemyTube.class, new RenderAlchemyTube());
		
		// Block Renderers
		lightStripRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(lightStripRenderType, RenderGlowingBlock.instance);
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == BOSS_CHAT_GUIID)
		{
			return new GuiBossChat(player, (IChatEntity) world.getEntityByID(x));
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
	public boolean isClient()
	{
		return true;
	}
}
