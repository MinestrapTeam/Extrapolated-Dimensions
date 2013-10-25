package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.entity.EntityScider;
import clashsoft.mods.moredimensions.entity.boss.EntityLich;
import cpw.mods.fml.common.registry.EntityRegistry;

import net.minecraft.entity.EnumCreatureType;

@Addon(modName = "MoreDimensionsMod", addonName = "Entitys")
public class MDMEntitys
{
	public static void load()
	{
		// -- Paradise of Chaos --
		
		// Lich Entity
		EntityRegistry.registerGlobalEntityID(EntityLich.class, "POCBossLich", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0xEEEEEE);
		
		EntityRegistry.addSpawn(EntityLich.class, 100, 1, 10, EnumCreatureType.creature);
		
		// -- Heaven --
		
		EntityRegistry.registerGlobalEntityID(EntityScider.class, "Scider", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x005500);
	}
}
