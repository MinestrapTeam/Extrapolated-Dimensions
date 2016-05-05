package minestrapteam.extradims.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import minestrapteam.extradims.client.gui.GuiPOCIngame;
import minestrapteam.extradims.client.gui.container.GuiDamnationTable;
import minestrapteam.extradims.client.model.ModelAccessories;
import minestrapteam.extradims.client.model.ModelBurfalaunt;
import minestrapteam.extradims.client.model.ModelNative;
import minestrapteam.extradims.client.renderer.block.RenderGlowingBlock;
import minestrapteam.extradims.client.renderer.entity.*;
import minestrapteam.extradims.client.renderer.item.RenderItemStickyBomb;
import minestrapteam.extradims.client.sound.EDSoundHandler;
import minestrapteam.extradims.common.EDProxy;
import minestrapteam.extradims.entity.EntityBurfalaunt;
import minestrapteam.extradims.entity.EntityLaser;
import minestrapteam.extradims.entity.EntityNative;
import minestrapteam.extradims.entity.EntityNativeSkeleton;
import minestrapteam.extradims.entity.boss.EntityLich;
import minestrapteam.extradims.entity.item.EntityStickyBomb;
import minestrapteam.extradims.lib.virtious.VItems;
import minestrapteam.extradims.tileentity.TileEntityDamnationTable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

public class EDClientProxy extends EDProxy
{
	public static final ResourceLocation goldAccessories = new ResourceLocation("ed_aerius",
	                                                                            "textures/models/armor/gold_accessories.png");

	public static int lightStripRenderType;

	public static ModelAccessories accessoryModel = new ModelAccessories();

	@Override
	public void init(FMLInitializationEvent event)
	{
		// Event Handlers
		MinecraftForge.EVENT_BUS.register(new EDClientEvents());
		MinecraftForge.EVENT_BUS.register(EDSoundHandler.instance);
		MinecraftForge.EVENT_BUS.register(new GuiPOCIngame(Minecraft.getMinecraft()));

		// Entity Renderers
		RenderingRegistry.registerEntityRenderingHandler(EntityLich.class, new RenderLich());

		RenderingRegistry
			.registerEntityRenderingHandler(EntityBurfalaunt.class, new RenderBurfalaunt(new ModelBurfalaunt(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNative.class, new RenderNative(new ModelNative(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNativeSkeleton.class,
		                                                 new RenderNativeSkeleton(new ModelNative(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaser());
		RenderingRegistry.registerEntityRenderingHandler(EntityStickyBomb.class, new RenderStickyBomb());

		// Item Renderers
		MinecraftForgeClient.registerItemRenderer(VItems.sticky_bomb, new RenderItemStickyBomb());

		// Block Renderers
		lightStripRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(lightStripRenderType, RenderGlowingBlock.instance);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == DAMNATION_TABLE_GUIID)
		{
			return new GuiDamnationTable(player.inventory, (TileEntityDamnationTable) world.getTileEntity(x, y, z));
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean isClient()
	{
		return true;
	}

	public static void renderPlayer(RenderPlayerEvent.Post event)
	{
		/*

		Minecraft.getMinecraft().renderEngine.bindTexture(goldAccessories);
		final EntityPlayer player = event.entityPlayer;

		GL11.glPushMatrix();

		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(player.rotationYaw, 0F, 1F, 0F);


		final float limbSwingAmount =
			player.limbSwingAmount + (player.limbSwingAmount - player.prevLimbSwingAmount) * event.partialRenderTick;
		accessoryModel.setRotationAngles(player.limbSwing, limbSwingAmount, player.rotationYawHead, player.rotationYaw,
		                                 player.rotationPitch, 0F, player);
		accessoryModel.renderArms(0.0625F);
		accessoryModel.renderBody(0.0625F);

		GL11.glPopMatrix();
		*/
	}
}
