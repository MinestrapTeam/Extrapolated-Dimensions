package clashsoft.mods.moredimensions.client;

import clashsoft.mods.moredimensions.client.renderer.entity.RenderScider;
import clashsoft.mods.moredimensions.common.CommonProxy;
import clashsoft.mods.moredimensions.entity.EntityScider;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public ClientProxy()
	{
		
	}
	
	public static void registerRenderInformation()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityScider.class, new RenderScider());
		sywoxite = RenderingRegistry.addNewArmourRendererPrefix("sywoxite");
	}
}
