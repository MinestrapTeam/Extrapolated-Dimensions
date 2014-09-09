package minestrapteam.virtious.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import minestrapteam.virtious.client.model.ModelBurfalaunt;
import minestrapteam.virtious.client.model.ModelNative;
import minestrapteam.virtious.client.renderer.block.RenderGlowingBlock;
import minestrapteam.virtious.client.renderer.entity.*;
import minestrapteam.virtious.client.renderer.item.RenderItemStickyBomb;
import minestrapteam.virtious.common.VCommonProxy;
import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityLaser;
import minestrapteam.virtious.entity.EntityNative;
import minestrapteam.virtious.entity.EntityNativeSkeleton;
import minestrapteam.virtious.entity.item.EntityStickyBomb;
import minestrapteam.virtious.lib.VItems;

import net.minecraftforge.client.MinecraftForgeClient;

public class VClientProxy extends VCommonProxy
{
	public static int	lightStripRendererID;
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		lightStripRendererID = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(lightStripRendererID, RenderGlowingBlock.instance);
		
		MinecraftForgeClient.registerItemRenderer(VItems.sticky_bomb, new RenderItemStickyBomb());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBurfalaunt.class, new RenderBurfalaunt(new ModelBurfalaunt(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNative.class, new RenderNative(new ModelNative(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNativeSkeleton.class, new RenderNativeSkeleton(new ModelNative(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaser());
		RenderingRegistry.registerEntityRenderingHandler(EntityStickyBomb.class, new RenderStickyBomb());
	}
	
	@Override
	public boolean isClient()
	{
		return true;
	}
}
