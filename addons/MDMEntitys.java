package clashsoft.mods.moredimensions.addons;

import clashsoft.cslib.addon.Addon;
import clashsoft.mods.moredimensions.entity.EntityScider;
import clashsoft.mods.moredimensions.entity.boss.EntityLich;
import cpw.mods.fml.common.registry.EntityRegistry;

@Addon(modName = "MoreDimensionsMod", addonName = "Entitys")
public class MDMEntitys
{
	public static void load()
	{
		// -- Paradise of Chaos --
		
		EntityRegistry.registerGlobalEntityID(EntityLich.class, "Lich", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0xEEEEEE);
		
		// -- Heaven --
		
		EntityRegistry.registerGlobalEntityID(EntityScider.class, "Scider", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x005500);
	}
}
